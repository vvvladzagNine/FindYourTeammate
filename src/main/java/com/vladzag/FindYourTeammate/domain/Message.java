package com.vladzag.FindYourTeammate.domain;

import javax.persistence.Entity;

//@Entity
public class Message {

    private Long senderId;
    private Long getterId;
    private String messageText;
    private Long date;

    public Message(Long senderId, Long getterId, String messageText, Long date) {
        this.senderId = senderId;
        this.getterId = getterId;
        this.messageText = messageText;
        this.date = date;
    }

    public Message() {
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getGetterId() {
        return getterId;
    }

    public void setGetterId(Long getterId) {
        this.getterId = getterId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
