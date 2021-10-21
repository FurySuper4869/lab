package cn.edu.xmu.restfuldemo.mapper;

import cn.edu.xmu.restfuldemo.model.OrderItemPo;
import cn.edu.xmu.restfuldemo.model.OrdersPo;
import cn.edu.xmu.restfuldemo.model.OrdersRetVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    /**
     * 用OrdersPo对象找，
     * @param ordersPo 条件对象，所有条件为AND，仅有索引的值可以作为条件
     * @return  OrdersPo对象列表
     */
    List<OrdersPo> findOrders(OrdersPo ordersPo);

    /**
     * 用OrderItemPo对象找，
     * @param orderItemPo 条件对象，所有条件为AND，仅有索引的值可以作为条件
     * @return  OrderItemPo对象列表
     */
    List<OrderItemPo> findOrderItem(OrderItemPo orderItemPo);

    /**
     * 创建OrdersPo对象
     * @param ordersPo ordersPo对象
     */
    void createOrders(OrdersPo ordersPo);

    /**
     * 创建OrderItemPo对象
     * @param orderItemPo orderItemPo对象
     */
    void createOrderItem(OrderItemPo orderItemPo);

    List<OrdersRetVo> findOrdersWithOrderItem(OrdersPo ordersPo);
}
