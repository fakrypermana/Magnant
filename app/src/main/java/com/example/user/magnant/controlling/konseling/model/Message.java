package com.example.user.magnant.controlling.konseling.model;

public class Message {
    String message;
    //String sender;
    String sender;
    //long createdAt;
    String createdAt;


    public Message(String message, String sender, String createdAt) {
        this.message = message;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
