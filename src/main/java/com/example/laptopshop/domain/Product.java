package com.example.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @NotNull
    @NotEmpty(message = "trường này không được để trống")
    private String name;

    @NotNull
    @Min(value = 1, message = "giá tiền phải lớn hơn 0")
    private double price;

    @NotNull
    @NotEmpty(message = "trường này không được để trống")
    @Column(columnDefinition = "MEDIUMTEXT")
    private String detailDesc;

    @NotNull
    @NotEmpty(message = "trường này không được để trống")
    private String shortDesc;

    @NotNull
    @Min(value = 1, message = "số lượng phải lớn hơn 0")
    private String quantity;
    private String sold;
    private String factory;
    private String target;
    private String image;

    @OneToMany(mappedBy = "product")
    List<CartDetail> cartDetails;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDetailDesc() {
        return detailDesc;
    }
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    public String getShortDesc() {
        return shortDesc;
    }
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getSold() {
        return sold;
    }
    public void setSold(String sold) {
        this.sold = sold;
    }
    public String getFactory() {
        return factory;
    }
    public void setFactory(String factory) {
        this.factory = factory;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detailDesc="
                + detailDesc + ", shortDesc=" + shortDesc + ", quantity=" + quantity + ", sold=" + sold + ", factory="
                + factory + ", target=" + target + "]";
    }
    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }
    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    
}
