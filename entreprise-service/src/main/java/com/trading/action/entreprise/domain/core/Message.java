package com.trading.action.entreprise.domain.core;

public class Message {
    private String label;
    private MessageType messageType;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Message() {
    }

    public Message(String label, MessageType messageType) {
        this.label = label;
        this.messageType = messageType;
    }
}
