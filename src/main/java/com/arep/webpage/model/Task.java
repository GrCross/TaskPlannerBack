package com.arep.webpage.model;

import java.util.Date;

public class Task {

    public Integer id;
    public String text;
    public int priority;
    public String dueDate;

    public Task() {}

    public Task(String text, int priority, String dueDate) {
        this.text = text;
        this.priority = priority;
        this.dueDate = dueDate;     
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    
}