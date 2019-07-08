package com.zygstore.dto;

import java.util.List;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDTO {
    private String name;
    private String categoryId;
    private double rating;
    private double prize;
    private List<String> description;
    private String linkToPicture;

    public ProductDTO(String name, String categoryId, double rating, double prize, List<String> description, String linkToPicture) {
        this.name = name;
        this.categoryId = categoryId;
        this.rating = rating;
        this.prize = prize;
        this.description = description;
        this.linkToPicture = linkToPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}
