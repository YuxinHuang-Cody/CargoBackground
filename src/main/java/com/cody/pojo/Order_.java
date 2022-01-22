package com.cody.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/14
 */
@Entity
public class Order_ {
    private int id;
    private Date deliveryTime;
    private String company;
    private String operator;
    private String dispatcher;
    private String pickUpAddress;
    private String shippingAddress;
    private String warehousingNumber;
    private String companyOrderNumber;
    private double totalFee;
    private Double basicFee;
    private Double expresswayFee;
    private Double overnightFee;
    private Double carryFee;
    private Double weighFee;
    private Double otherFee;
    private String driver;
    private String cargoInformation;
    private String remarks;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "delivery_time")
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "dispatcher")
    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Basic
    @Column(name = "pick_up_address")
    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    @Basic
    @Column(name = "shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "warehousing_number")
    public String getWarehousingNumber() {
        return warehousingNumber;
    }

    public void setWarehousingNumber(String warehousingNumber) {
        this.warehousingNumber = warehousingNumber;
    }

    @Basic
    @Column(name = "company_order_number")
    public String getCompanyOrderNumber() {
        return companyOrderNumber;
    }

    public void setCompanyOrderNumber(String companyOrderNumber) {
        this.companyOrderNumber = companyOrderNumber;
    }

    @Basic
    @Column(name = "total_fee")
    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    @Basic
    @Column(name = "basic_fee")
    public Double getBasicFee() {
        return basicFee;
    }

    public void setBasicFee(Double basicFee) {
        this.basicFee = basicFee;
    }

    @Basic
    @Column(name = "expressway_fee")
    public Double getExpresswayFee() {
        return expresswayFee;
    }

    public void setExpresswayFee(Double expresswayFee) {
        this.expresswayFee = expresswayFee;
    }

    @Basic
    @Column(name = "overnight_fee")
    public Double getOvernightFee() {
        return overnightFee;
    }

    public void setOvernightFee(Double overnightFee) {
        this.overnightFee = overnightFee;
    }

    @Basic
    @Column(name = "carry_fee")
    public Double getCarryFee() {
        return carryFee;
    }

    public void setCarryFee(Double carryFee) {
        this.carryFee = carryFee;
    }

    @Basic
    @Column(name = "weigh_fee")
    public Double getWeighFee() {
        return weighFee;
    }

    public void setWeighFee(Double weighFee) {
        this.weighFee = weighFee;
    }

    @Basic
    @Column(name = "other_fee")
    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    @Basic
    @Column(name = "driver")
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Basic
    @Column(name = "cargo_information")
    public String getCargoInformation() {
        return cargoInformation;
    }

    public void setCargoInformation(String cargoInformation) {
        this.cargoInformation = cargoInformation;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order_ order = (Order_) o;
        return id == order.id &&
                Double.compare(order.totalFee, totalFee) == 0 &&
                Objects.equals(deliveryTime, order.deliveryTime) &&
                Objects.equals(company, order.company) &&
                Objects.equals(operator, order.operator) &&
                Objects.equals(dispatcher, order.dispatcher) &&
                Objects.equals(pickUpAddress, order.pickUpAddress) &&
                Objects.equals(shippingAddress, order.shippingAddress) &&
                Objects.equals(warehousingNumber, order.warehousingNumber) &&
                Objects.equals(companyOrderNumber, order.companyOrderNumber) &&
                Objects.equals(basicFee, order.basicFee) &&
                Objects.equals(expresswayFee, order.expresswayFee) &&
                Objects.equals(overnightFee, order.overnightFee) &&
                Objects.equals(carryFee, order.carryFee) &&
                Objects.equals(weighFee, order.weighFee) &&
                Objects.equals(otherFee, order.otherFee) &&
                Objects.equals(driver, order.driver) &&
                Objects.equals(cargoInformation, order.cargoInformation) &&
                Objects.equals(remarks, order.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryTime, company, operator, dispatcher, pickUpAddress, shippingAddress, warehousingNumber, companyOrderNumber, totalFee, basicFee, expresswayFee, overnightFee, carryFee, weighFee, otherFee, driver, cargoInformation, remarks);
    }
}
