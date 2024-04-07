package ru.gb.examp2_sem3_homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.examp2_sem3_homework.domain.User;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Поля UserService, NotificationService
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public UserService getUserService() {
        return userService;
    }

    //Метод processRegistration
    public User processRegistration(String name, int age, String email) {
        return userService.createUser(name, age, email);
    }
}
