package com.twentyspace.springfcm.controller;

import com.twentyspace.springfcm.model.NotificationMessageDTO;
import com.twentyspace.springfcm.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yogaagungk@gmail.com
 * @version : NotificationController, v 0.1 2020-08-15 23.53
 */
@RestController
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping(value = "topic")
    public String sendNotificationToTopic(@RequestBody NotificationMessageDTO request) {
        return service.sendNotificationToTopic(request);
    }

    @PostMapping(value = "token")
    public String sendNotificationToDevice(@RequestBody NotificationMessageDTO request) {
        return service.sendNotificationToDevice(request);
    }
}
