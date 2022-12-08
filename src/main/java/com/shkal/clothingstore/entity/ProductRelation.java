package com.shkal.clothingstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders_detail")
public class ProductRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_detail_id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public ProductRelation(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public ProductRelation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
