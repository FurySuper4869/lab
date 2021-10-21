package cn.edu.xmu.restfuldemo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Data
@Alias("OrderItemPo")
public class OrderItemPo {

    private Long id;

    private Long orderId;

    private Long goodsSkuId;

    private Integer quantity;

    private Long price;

    private Long discount;

    private String name;

    private Long couponActivityId;

    private Long beSharedId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
}
