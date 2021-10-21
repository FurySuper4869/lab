package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "订单视图对象")
public class OrdersVo {

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "地区id")
    private Long regionId;

    @ApiModelProperty(value = "收货详细地址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "附言")
    private String message;

    @ApiModelProperty(value = "使用的优惠卷id")
    private Long couponId;

    @ApiModelProperty(value = "预售活动id")
    private Long presaleId;

    @ApiModelProperty(value = "团购活动id")
    private Long grouponId;

    public Orders createOrders(){
        Orders orders=new Orders();
        orders.setConsignee(this.consignee);
        orders.setRegionID(this.regionId);
        orders.setAddress(this.address);
        orders.setMobile(this.mobile);
        orders.setMessage(this.message);
        orders.setCouponId(this.couponId);
        orders.setPresaleId(this.presaleId);
        orders.setGrouponId(this.grouponId);
        return orders;
    }
}
