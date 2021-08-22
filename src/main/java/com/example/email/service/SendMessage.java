package com.example.email.service;

/**
 * 消息发送类
 */
public interface SendMessage {

    /**
     * 消息发送
     */
    void sendMessage(String to,String subject,String content);
}
