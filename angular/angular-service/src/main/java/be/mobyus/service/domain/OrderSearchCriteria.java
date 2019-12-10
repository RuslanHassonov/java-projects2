package be.mobyus.service.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderSearchCriteria {

    private User user = new User();
    private Product product = new Product();
    private Date orderDate;
    private BigDecimal orderMinAmount;
    private BigDecimal orderMaxAmount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderMinAmount() {
        return orderMinAmount;
    }

    public void setOrderMinAmount(BigDecimal orderMinAmount) {
        this.orderMinAmount = orderMinAmount;
    }

    public BigDecimal getOrderMaxAmount() {
        return orderMaxAmount;
    }

    public void setOrderMaxAmount(BigDecimal orderMaxAmount) {
        this.orderMaxAmount = orderMaxAmount;
    }
}
