package com.arep.webpage.model;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Task {

    @Id
    public Integer id;

    public String userOwner;
    public String text;
    public int priority;
    public String dueDate;

    public Task() {
    }

    public Task(Integer id,String text, int priority, String dueDate,String userOwner) {
        this.text = text;
        this.priority = priority;
        this.dueDate = dueDate;
        //this.id = new CompositeKey(id,userOwner);
        this.id = id;
        this.userOwner = userOwner;
    }


    public Integer getTaskId() { return this.id; }

    public void setTaskId(Integer id) { this.id = id; }

    public String getText() { return this.text; }

    public void setText(String text) { this.text = text; }

    public Integer getPriority() { return this.priority; }

    public void setPriority(Integer priority) { this.priority = priority; }

    public String getDueDate() { return this.dueDate; }

    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getUserOwner(){ return this.userOwner; }

    public void setUserOwner(String userOwner){ this.userOwner = userOwner; }

}