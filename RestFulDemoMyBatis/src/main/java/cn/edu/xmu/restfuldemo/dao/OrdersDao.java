package cn.edu.xmu.restfuldemo.dao;

import cn.edu.xmu.restfuldemo.mapper.OrdersMapper;
import cn.edu.xmu.restfuldemo.model.*;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static cn.edu.xmu.restfuldemo.util.Common.genSeqNum;

@Repository
public class OrdersDao {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 用OrdersPo对象找Orders对象
     * @param ordersPo 条件对象，所有条件为AND，仅有索引的值可以作为条件
     * @return  orders对象列表
     */
    public ReturnObject<List<Orders>> findOrders(OrdersPo ordersPo){

        List<OrdersPo> ordersPos=ordersMapper.findOrders(ordersPo);

        List<Orders> retOrders=new ArrayList<>(ordersPos.size());

        for(OrdersPo temp:ordersPos){
            Orders item=new Orders(temp);
            retOrders.add(item);
        }

        return new ReturnObject<>(retOrders);
    }

    /**
     * 用OrderItemPo对象找OrderItem对象
     * @param orderItemPo 条件对象，所有条件为AND，仅有索引的值可以作为条件
     * @return  orderItem对象列表
     */
    public ReturnObject<List<OrderItem>> findOrderItem(OrderItemPo orderItemPo){

        List<OrderItemPo> orderItemPos=ordersMapper.findOrderItem(orderItemPo);

        List<OrderItem> retOrderItem=new ArrayList<>(orderItemPos.size());

        for(OrderItemPo temp:orderItemPos){
            OrderItem item=new OrderItem(temp);
            retOrderItem.add(item);
        }

        return new ReturnObject<>(retOrderItem);
    }

    /**
     * 创建Orders对象
     * @param orders 传入的orders对象
     */
    public Long createOrders(Orders orders){
        OrdersPo ordersPo = orders.getOrdersPo();
        try{
            ordersMapper.createOrders(ordersPo);
            System.out.println(ordersPo.getId());
            return ordersPo.getId();
        }
        catch (Exception e){
            return null;
        }
    }

    /**
     * 创建OrderItem对象
     * @param orderItem 传入的orderItem对象
     */
    public boolean createOrderItem(List<OrderItem> orderItem){
        for(OrderItem temp:orderItem){
            OrderItemPo orderItemPo=temp.getOrderItemPo();
            System.out.println("Dao:"+orderItemPo);
            try{
                ordersMapper.createOrderItem(orderItemPo);
            }
            catch (Exception e){
                return false;
            }
        }
        return true;
    }

    public ReturnObject<List<OrdersRetVo>> findOrders_Dao(OrdersPo ordersPo){

        List<OrdersPo> ordersPos=ordersMapper.findOrders(ordersPo);

        OrderItemPo orderItemPo=new OrderItemPo();
        orderItemPo.setOrderId(ordersPo.getId());
        List<OrderItemPo> orderItemPos=ordersMapper.findOrderItem(orderItemPo);

        List<OrderItem> orderItems=new ArrayList<>(orderItemPos.size());

        for(OrderItemPo temp:orderItemPos){
            OrderItem item=new OrderItem(temp);
            orderItems.add(item);
        }

        if(ordersPos.size()==1){
            List<OrdersRetVo> retOrdersRetVo=new ArrayList<>(1);
            retOrdersRetVo.add(new OrdersRetVo(new Orders(ordersPos.get(0)),orderItems));
            return new ReturnObject<>(retOrdersRetVo);
        }
        else
            return null;
    }

    public ReturnObject<List<OrdersRetVo>> findOrders_SQL(OrdersPo ordersPo){

        List<OrdersRetVo> ordersRetVos=ordersMapper.findOrdersWithOrderItem(ordersPo);

        if(ordersRetVos.size()==1){
            List<OrdersRetVo> retOrdersRetVo=new ArrayList<>(1);
            retOrdersRetVo.add(ordersRetVos.get(0));
            return new ReturnObject<>(retOrdersRetVo);
        }
        else
            return null;
    }
}


























