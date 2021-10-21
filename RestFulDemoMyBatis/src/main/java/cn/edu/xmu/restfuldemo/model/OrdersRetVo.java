package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@ApiModel(description = "订单视图对象")
public class OrdersRetVo implements VoObject{

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "父订单")
    private Long pid;

    @ApiModelProperty(value = "订单类型")
    private Byte orderType;

    @ApiModelProperty(value = "订单主状态")
    private Byte state;

    @ApiModelProperty(value = "订单子状态")
    private Byte substate;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime confirmTime;

    @ApiModelProperty(value = "订单商品优惠前总额")
    private Long originPrice;

    @ApiModelProperty(value = "优惠卷/优惠活动折扣数额")
    private Long discountPrice;

    @ApiModelProperty(value = "运费")
    private Long freightPrice;

    @ApiModelProperty(value = "返给分享者的点数")
    private Integer rebateNum;

    @ApiModelProperty(value = "附言")
    private String message;

    @ApiModelProperty(value = "地区id")
    private Long regionId;

    @ApiModelProperty(value = "收货详细地址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "使用的优惠卷id")
    private Long couponId;

    @ApiModelProperty(value = "团购活动id")
    private Long grouponId;

    @ApiModelProperty(value = "预售活动id")
    private Long presaleId;

    @ApiModelProperty(value = "快递单号")
    private String shipmentSn;

    @ApiModelProperty(value = "订单明细")
    private List<OrderItemRetVo> orderItems=new LinkedList<>();

    public OrdersRetVo(Orders orders,List<OrderItem> orderItems){
        this.id=orders.getId();
        this.orderSn=orders.getOrderSn();
        this.pid=orders.getPid();
        this.orderType=orders.getOrderType();
        this.state=orders.getState();
        this.substate=orders.getSubstate();
        this.gmtCreate=orders.getGmtCreate();
        this.gmtModified=orders.getGmtModified();
        this.confirmTime=orders.getConfirmTime();
        this.originPrice=orders.getOriginPrice();
        this.discountPrice=orders.getDiscountPrice();
        this.freightPrice=orders.getFreightPrice();
        this.rebateNum=orders.getRebateNum();
        this.message=orders.getMessage();
        this.regionId=orders.getRegionID();
        this.address=orders.getAddress();
        this.mobile=orders.getMobile();
        this.consignee=orders.getConsignee();
        this.couponId=orders.getCouponId();
        this.grouponId=orders.getGrouponId();
        this.presaleId=orders.getPresaleId();
        this.shipmentSn=orders.getShipmentSn();
        for(OrderItem temp:orderItems){
            OrderItemRetVo orderItemRetVo=new OrderItemRetVo(temp);
            this.orderItems.add(orderItemRetVo);
        }
    }

    @Override
    public Object createVo() {
        return this;
    }
}
