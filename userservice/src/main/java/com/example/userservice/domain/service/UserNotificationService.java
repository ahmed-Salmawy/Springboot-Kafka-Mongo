package com.example.userservice.domain.service;

import com.example.userservice.base.BaseService;
import com.example.userservice.domain.dto.UserDto;

public interface UserNotificationService extends BaseService {
    void sendWelcomeNotification(UserDto user);
}
