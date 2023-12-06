package com.example.emailservice.domain.listner.impl;

import com.example.emailservice.base.BaseListener;
import com.example.emailservice.domain.dto.UserDto;
import com.example.emailservice.domain.dto.UserRegMessageDto;
import com.example.emailservice.domain.listner.UserRegisterationListner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserRegisterationListnerImpl implements UserRegisterationListner {


    @Override
    @KafkaListener(topics = "user-reg", groupId = "user-reg-group")
    public void listen(UserRegMessageDto message) {
        log.info("message received {}",message);


    }
}
