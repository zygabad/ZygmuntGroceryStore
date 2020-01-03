package com.zygstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "Id", columnDefinition = "INT")
    Long id;

    @Column(name = "productName", columnDefinition = "VARCHAR(255)")
    String productName;

    @Column(name = "categoryId", columnDefinition = "INT")
    Long categoryId;
//TODO next sprint -  to powinno wskazywac na category na obiekt konkretny (nie id|) - ws-bank example w ansoegning - wskazuje na grundlagh - AnsoegningEntity.java linia 55

    @Column(name = "rating", columnDefinition = "INT")
    double rating;

    @Column(name = "prize", columnDefinition = "INT")
    double prize;

    @Column(name = "linkToPicture", columnDefinition = "VARCHAR(255)")
    String linkToPicture;

    @Column(name = "description", columnDefinition = "VARCHAR(1024)")
    String description;

    public Product(Long id, String productName, Long categoryId, double rating, double prize, String linkToPicture,
                   String description) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.rating = rating;
        this.prize = prize;
        this.linkToPicture = linkToPicture;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
