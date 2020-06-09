package be.mobyus.ie5.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity(name = "Orders")
public class Order {
	//TODO BEWARE do NOT name your table ORDER since this is a RESERVED keyword in SQL!
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paymentMethod;
    private BigDecimal orderTotal;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;
    private Eshop eShop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Eshop geteShop() {
        return eShop;
    }

    public void seteShop(Eshop eShop) {
        this.eShop = eShop;
    }
}
