package com.twentyspace.springfcm.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.twentyspace.springfcm.model.NotificationMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author yogaagungk@gmail.com
 * @version : NotificationService, v 0.1 2020-08-15 23.22
 */
@Service
public class NotificationService {

    private final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Value("${app.firebase.config}")
    private String firebaseConfig;

    private FirebaseApp firebaseApp;

    @PostConstruct
    private void init() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(
                            new ClassPathResource(firebaseConfig).getInputStream()
                    )).build();

            if (FirebaseApp.getApps().isEmpty()) {
                this.firebaseApp = FirebaseApp.initializeApp(options);
            } else {
                this.firebaseApp = FirebaseApp.getInstance();
            }
        } catch (IOException e) {
            LOGGER.error("error during create FirebaseApp");
        }
    }

    public String sendNotificationToTopic(NotificationMessageDTO request) {
        Message message = Message.builder()
                .setTopic(request.getTarget())
                .setNotification(new Notification(request.getTitle(), request.getBody()))
                .putData("content", request.getTitle())
                .putData("body", request.getBody())
                .build();

        try {
            return FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            LOGGER.error("fail to send notification");
        }

        return null;
    }

    public String sendNotificationToDevice(NotificationMessageDTO request) {
        Message message = Message.builder()
                .setToken(request.getTarget())
                .setNotification(new Notification(request.getTitle(), request.getBody()))
                .putData("content", request.getTitle())
                .putData("body", request.getBody())
                .build();

        try {
            return FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            LOGGER.error("fail to send notification");
        }

        return null;
    }

}
