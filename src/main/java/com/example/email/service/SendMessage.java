package com.example.email.service;

public interface SendMessage {

    /**
     * 消息发送
     */
    void sendMessage(String to,String subject,String content);
}
