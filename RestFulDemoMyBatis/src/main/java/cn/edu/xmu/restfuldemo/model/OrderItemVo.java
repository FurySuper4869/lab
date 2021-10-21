package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "订单明细视图对象")
public class OrderItemVo {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "商品SKU id")
    private Long goodsSkuId;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "优惠活动id")
    private Long couponActivityId;

    public OrderItem createOrderItem(){
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId(this.orderId);
        orderItem.setGoodsSkuId(this.goodsSkuId);
        orderItem.setQuantity(this.quantity);
        orderItem.setCouponActivityId(this.couponActivityId);
        return orderItem;
    }
}
