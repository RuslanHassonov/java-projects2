package be.mobyus.service.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "order_")
public class Order {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToOne
    private User user;
    @Temporal(DATE)
    private Date orderDate;
    private BigDecimal totalAmount;

    @OneToMany(cascade = ALL)
    @JoinColumn
    private Collection<Product> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
