package com.example.userservice.aspect.notification;

import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.service.UserNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
@Slf4j
public class UserRegNotifyAspect {
    private final UserNotificationService userNotificationService;

    @Autowired
    public UserRegNotifyAspect(UserNotificationService userNotificationService) {
        this.userNotificationService = userNotificationService;
    }


    @After("@annotation(userRegNotify)")
    public void sendNotification(JoinPoint joinPoint, UserRegNotify userRegNotify) {
        UserDto userDto = null;
        try {
            userDto = (UserDto) joinPoint.getArgs()[0];
            userNotificationService.sendWelcomeNotification(userDto);
        } catch (Exception ex) {
            log.error("unable to cast first argument to UserDto.class");
        }


    }
}
