package com.zygstore.model;

import java.util.Map;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class Product {
    Long id;
    String productName;
    String categoryId;
    double rating;
    double prize;
    String linkToPicture;
    String allDescriptionLine;
    Map<String, String> description;

    public Product(Long id, String productName, String categoryId, double rating, double prize, String linkToPicture, String allDescriptionLine,
                   Map<String, String> description) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.rating = rating;
        this.prize = prize;
        this.linkToPicture = linkToPicture;
        this.allDescriptionLine = allDescriptionLine;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
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

    public String getAllDescriptionLine() {
        return allDescriptionLine;
    }

    public void setAllDescriptionLine(String allDescriptionLine) {
        this.allDescriptionLine = allDescriptionLine;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }
}
