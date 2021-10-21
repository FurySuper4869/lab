package cn.edu.xmu.restfuldemo.model;

import cn.edu.xmu.restfuldemo.util.ReturnObject;

import java.time.LocalDateTime;

public class Orders implements VoObject {

    private OrdersPo ordersPo;

    public Orders() {
        this.ordersPo = new OrdersPo();
    }

    public Orders(OrdersPo ordersPo) {
        this.ordersPo = ordersPo;
    }

    @Override
    public Object createVo() {
        return new OrdersRetVo(this,null);
    }

    public OrdersPo getOrdersPo() {
        return this.ordersPo;
    }

    public Long getId() {
        return ordersPo.getId();
    }

    public Long getCustomerId() {
        return ordersPo.getCustomerId();
    }

    public Long getShopId() {
        return ordersPo.getShopId();
    }

    public String getOrderSn() {
        return ordersPo.getOrderSn();
    }

    public Long getPid() {
        return ordersPo.getPid();
    }

    public String getConsignee() {
        return ordersPo.getConsignee();
    }

    public Long getRegionID() {
        return ordersPo.getRegionId();
    }

    public String getAddress() {
        return ordersPo.getAddress();
    }

    public String getMobile() {
        return ordersPo.getMobile();
    }

    public String getMessage() {
        return ordersPo.getMessage();
    }

    public Byte getOrderType() {
        return ordersPo.getOrderType();
    }

    public Long getFreightPrice() {
        return ordersPo.getFreightPrice();
    }

    public Long getCouponId() {
        return ordersPo.getCouponId();
    }

    public Long getCouponActivityId() {
        return ordersPo.getCouponActivityId();
    }

    public Long getDiscountPrice() {
        return ordersPo.getDiscountPrice();
    }

    public Long getOriginPrice() {
        return ordersPo.getOriginPrice();
    }

    public Long getPresaleId() {
        return ordersPo.getPresaleId();
    }

    public Long getGrouponDiscount() {
        return ordersPo.getGrouponDiscount();
    }

    public Integer getRebateNum() {
        return ordersPo.getRebateNum();
    }

    public LocalDateTime getConfirmTime() {
        return ordersPo.getConfirmTime();
    }

    public String getShipmentSn() {
        return ordersPo.getShipmentSn();
    }

    public Byte getState() {
        return ordersPo.getState();
    }

    public Byte getSubstate() {
        return ordersPo.getSubstate();
    }

    public Byte getBeDeleted() {
        return ordersPo.getBeDeleted();
    }

    public LocalDateTime getGmtCreate() {
        return ordersPo.getGmtCreate();
    }

    public LocalDateTime getGmtModified() {
        return ordersPo.getGmtModified();
    }

    public Long getGrouponId() {
        return ordersPo.getGrouponId();
    }

    public void setId(Long id) {
        ordersPo.setId(id);
    }

    public void setCustomerId(Long customerId) {
        ordersPo.setCustomerId(customerId);
    }

    public void setShopId(Long shopId) {
        ordersPo.setShopId(shopId);
    }

    public void setOrderSn(String orderSn) {
        ordersPo.setOrderSn(orderSn);
    }

    public void setPid(Long pid) {
        ordersPo.setPid(pid);
    }

    public void setConsignee(String consignee) {
        ordersPo.setConsignee(consignee);
    }

    public void setRegionID(Long regionID) {
        ordersPo.setRegionId(regionID);
    }

    public void setAddress(String address) {
        ordersPo.setAddress(address);
    }

    public void setMobile(String mobile) {
        ordersPo.setMobile(mobile);
    }

    public void setMessage(String message) {
        ordersPo.setMessage(message);
    }

    public void setOrderType(Byte orderType) {
        ordersPo.setOrderType(orderType);
    }

    public void setFreightPrice(Long freightPrice) {
        ordersPo.setFreightPrice(freightPrice);
    }

    public void setCouponId(Long couponId) {
        ordersPo.setCouponId(couponId);
    }

    public void setCouponActivityId(Long couponActivityId) {
        ordersPo.setCouponActivityId(couponActivityId);
    }

    public void setDiscountPrice(Long discountPrice) {
        ordersPo.setDiscountPrice(discountPrice);
    }

    public void setOriginPrice(Long originPrice) {
        ordersPo.setOriginPrice(originPrice);
    }

    public void setPresaleId(Long presaleId) {
        ordersPo.setOriginPrice(presaleId);
    }

    public void setGrouponDiscount(Long grouponDiscount) {
        ordersPo.setGrouponDiscount(grouponDiscount);
    }

    public void setRebateNum(Integer rebateNum) {
        ordersPo.setRebateNum(rebateNum);
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        ordersPo.setConfirmTime(confirmTime);
    }

    public void setShipmentSn(String shipmentSn) {
        ordersPo.setShipmentSn(shipmentSn);
    }

    public void setState(Byte state) {
        ordersPo.setState(state);
    }

    public void setSubstate(Byte substate) {
        ordersPo.setState(substate);
    }

    public void setBeDeleted(Byte beDeleted) {
        ordersPo.setBeDeleted(beDeleted);
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        ordersPo.setGmtCreate(gmtCreate);
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        ordersPo.setGmtModified(gmtModified);
    }

    public void setGrouponId(Long grouponId) {
        ordersPo.setGrouponId(grouponId);
    }
}



















