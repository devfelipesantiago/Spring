package com.spring.spring.entities.pk;

import com.spring.spring.entities.Order;
import com.spring.spring.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPk)) return false;
        OrderItemPk that = (OrderItemPk) o;
        return getProduct().equals(that.getProduct()) && getOrder().equals(that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getOrder());
    }
}
