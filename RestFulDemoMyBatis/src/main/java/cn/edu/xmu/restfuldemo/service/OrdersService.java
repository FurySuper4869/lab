package cn.edu.xmu.restfuldemo.service;

import cn.edu.xmu.restfuldemo.dao.OrdersDao;
import cn.edu.xmu.restfuldemo.model.*;
import cn.edu.xmu.restfuldemo.util.ResponseCode;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 获取某个订单信息，仅展示相关内容
     *
     * @param id 订单id
     * @return 订单对象
     */
    public ReturnObject<VoObject> findById(Long id) {
        OrdersPo queryObj1 = new OrdersPo();
        queryObj1.setId(id);
        OrderItemPo queryObj2 = new OrderItemPo();
        queryObj2.setOrderId(id);
        ReturnObject<VoObject> retOrders=null;
        ReturnObject<List<Orders>> returnObject1=ordersDao.findOrders(queryObj1);
        ReturnObject<List<OrderItem>> returnObject2=ordersDao.findOrderItem(queryObj2);

        if (returnObject1.getCode().equals(ResponseCode.OK)&&returnObject2.getCode().equals(ResponseCode.OK)) {
            if (returnObject1.getData().size() == 1) {
                OrdersRetVo ordersRetVo=new OrdersRetVo(returnObject1.getData().get(0),returnObject2.getData());
                retOrders = new ReturnObject<>(ordersRetVo);
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject1.getCode(), returnObject1.getErrmsg());
        }

        return retOrders;
    }

    /**
     * 新增商品
     * @param ordersRetVo 新商品信息
     */
    @Transactional
    public boolean createOrders(OrdersRetVo ordersRetVo) {
        try{
            Orders orders=new Orders();
            orders.setConsignee(ordersRetVo.getConsignee());
            orders.setRegionID(ordersRetVo.getRegionId());
            orders.setAddress(ordersRetVo.getAddress());
            orders.setMobile(ordersRetVo.getMobile());
            orders.setMessage(ordersRetVo.getMessage());
            orders.setCouponId(ordersRetVo.getCouponId());
            orders.setPresaleId(ordersRetVo.getPresaleId());
            orders.setGrouponId(ordersRetVo.getGrouponId());
            Long orderid=ordersDao.createOrders(orders);

            List<OrderItem> orderItems=new LinkedList<>();
            for(OrderItemRetVo temp:ordersRetVo.getOrderItems()) {
                OrderItem orderItem=new OrderItem();
                orderItem.setOrderId(orderid);
                orderItem.setGoodsSkuId(temp.getSkuId());
                orderItem.setQuantity(temp.getQuantity());
                orderItem.setCouponActivityId(temp.getCouponActId());
                orderItems.add(orderItem);
            }
            ordersDao.createOrderItem(orderItems);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public ReturnObject<VoObject> findById_Dao(Long id) {
        OrdersPo queryObj1 = new OrdersPo();
        queryObj1.setId(id);

        ReturnObject<VoObject> retOrders=null;
        ReturnObject<List<OrdersRetVo>> returnObject=ordersDao.findOrders_Dao(queryObj1);

        if (returnObject.getCode().equals(ResponseCode.OK)) {
            if (returnObject.getData().size() == 1) {
                retOrders = new ReturnObject<>(returnObject.getData().get(0));
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject.getCode(), returnObject.getErrmsg());
        }

        return retOrders;
    }

    public ReturnObject<VoObject> findById_SQL(Long id) {
        OrdersPo queryObj1 = new OrdersPo();
        queryObj1.setId(id);

        ReturnObject<VoObject> retOrders=null;
        ReturnObject<List<OrdersRetVo>> returnObject=ordersDao.findOrders_SQL(queryObj1);

        if (returnObject.getCode().equals(ResponseCode.OK)) {
            if (returnObject.getData().size() == 1) {
                retOrders = new ReturnObject<>(returnObject.getData().get(0));
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject.getCode(), returnObject.getErrmsg());
        }

        return retOrders;
    }
}


























