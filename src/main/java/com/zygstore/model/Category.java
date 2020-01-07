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
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name= "Id" , columnDefinition = "INT")
    private Long id;

    @Column(name= "parentId" , columnDefinition = "INT")
    private Long parentId;

    @Column(name= "text" , columnDefinition = "VARCHAR(255)")
    private String text;

    @Column(name= "linkToPicture" , columnDefinition = "VARCHAR(255)")
    private String linkToPicture;

    //required by JPA - does nothing
    protected Category() {
        //in order to initialize empty object and then use setters
    }

    public Category(Long id, Long parentId, String text, String linkToPicture) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.linkToPicture = linkToPicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}
