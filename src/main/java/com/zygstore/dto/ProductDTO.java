package com.zygstore.dto;

import java.util.Map;

/**
 * Place descriptionMap here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private double rating;
    private double prize;
    private String linkToPicture;
    private Map<String, String> descriptionMap;

    public ProductDTO(Long id, String name, Long categoryId, double rating, double prize, String linkToPicture,
                      Map<String, String> descriptionMap) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.rating = rating;
        this.prize = prize;
        this.linkToPicture = linkToPicture;
        this.descriptionMap = descriptionMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<String, String> getDescriptionMap() {
        return descriptionMap;
    }

    public void setDescriptionMap(Map<String, String> descriptionMap) {
        this.descriptionMap = descriptionMap;
    }
}
