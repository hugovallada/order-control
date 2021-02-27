package com.github.hugovallada.orderscontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.hugovallada.orderscontrol.entities.pk.OrderItemPK;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        generateId(order, product);
        this.quantity = quantity;
        this.price = price;
    }

    private void generateId(Order order, Product product) {
        this.id.setOrder(order);
        this.id.setProduct(product);
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }


    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getSubTotal() {
        return quantity * price;
    }
}
