package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@ApiModel(description = "订单明细视图对象")
public class OrderItemRetVo {

    @ApiModelProperty(value = "商品SKU id")
    private Long skuId;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品单价")
    private Long price;

    @ApiModelProperty(value = "折让数目")
    private Long discount;

    @ApiModelProperty(value = "优惠活动id")
    private Long couponActId;

    @ApiModelProperty(value = "分享成功id")
    private Long beSharedId;

    public OrderItemRetVo(OrderItem orderItem){
        this.skuId=orderItem.getGoodsSkuId();
        this.orderId=orderItem.getOrderId();
        this.name=orderItem.getName();
        this.quantity=orderItem.getQuantity();
        this.price=orderItem.getPrice();
        this.discount=orderItem.getDiscount();
        this.couponActId=orderItem.getCouponActivityId();
        this.beSharedId=orderItem.getBeSharedId();
    }

}
