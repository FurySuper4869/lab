package cn.edu.xmu.restfuldemo.model;

import java.time.LocalDateTime;

public class OrderItem implements VoObject{

    private OrderItemPo orderItemPo;

    public OrderItem() {
        this.orderItemPo = new OrderItemPo();
    }

    public OrderItem(OrderItemPo orderItemPo) {
        this.orderItemPo = orderItemPo;
    }

    @Override
    public Object createVo() {
        return null;
    }

    public OrderItemPo getOrderItemPo(){
        return this.orderItemPo;
    }

    public Long getId(){
        return orderItemPo.getId();
    }

    public Long getOrderId(){
        return orderItemPo.getOrderId();
    }

    public Long getGoodsSkuId(){
        return orderItemPo.getGoodsSkuId();
    }

    public Integer getQuantity(){
        return orderItemPo.getQuantity();
    }

    public Long getPrice(){
        return orderItemPo.getPrice();
    }

    public Long getDiscount(){
        return orderItemPo.getDiscount();
    }

    public String getName(){
        return orderItemPo.getName();
    }

    public Long getCouponActivityId(){
        return orderItemPo.getCouponActivityId();
    }

    public Long getBeSharedId(){
        return orderItemPo.getBeSharedId();
    }

    public LocalDateTime getGmtCreate(){
        return orderItemPo.getGmtCreate();
    }

    public LocalDateTime getGmtModified(){
        return orderItemPo.getGmtModified();
    }

    public void setId(Long id){
        orderItemPo.setId(id);
    }

    public void setOrderId(Long orderId){
        orderItemPo.setOrderId(orderId);
    }

    public void setGoodsSkuId(Long goodsSkuId){
        orderItemPo.setGoodsSkuId(goodsSkuId);
    }

    public void setQuantity(Integer quantity){
        orderItemPo.setQuantity(quantity);
    }

    public void setPrice(Long price){
        orderItemPo.setPrice(price);
    }

    public void setDiscount(Long discount){
        orderItemPo.setDiscount(discount);
    }

    public void setName(String name){
        orderItemPo.setName(name);
    }

    public void setCouponActivityId(Long couponActivityId){
        orderItemPo.setCouponActivityId(couponActivityId);
    }

    public void setBeSharedId(Long beShareId){
        orderItemPo.setBeSharedId(beShareId);
    }

    public void setGmtCreate(LocalDateTime gmtCreate){
        orderItemPo.setGmtCreate(gmtCreate);
    }

    public void setGmtModified(LocalDateTime gmtModified){
        orderItemPo.setGmtModified(gmtModified);
    }
}


















