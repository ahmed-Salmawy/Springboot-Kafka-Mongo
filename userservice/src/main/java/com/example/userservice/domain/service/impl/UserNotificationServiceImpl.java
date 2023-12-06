package com.example.userservice.domain.service.impl;

import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.dto.UserRegMessageDto;
import com.example.userservice.domain.service.UserNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserNotificationServiceImpl implements UserNotificationService {
    KafkaTemplate<String, UserRegMessageDto> kafkaTemplate;

    @Autowired
    public UserNotificationServiceImpl(KafkaTemplate<String, UserRegMessageDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void sendWelcomeNotification(UserDto user) {
        if (Optional.ofNullable(user).isPresent()) {
            log.info("sending welcome notification to customer....{}", user.getName());
            kafkaTemplate.sendDefault(UserRegMessageDto.builder()
                    .to(user.getEmail())
                    .body(String.format("Hi Mr.%s \n Welcome Onboard ... :D",user.getName())).build());
            log.info("welcome notification sent successfully to customer....{}", user.getName());
        }
    }
}
