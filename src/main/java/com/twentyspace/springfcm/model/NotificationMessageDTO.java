package com.twentyspace.springfcm.model;

import java.io.Serializable;

/**
 * @author yogaagungk@gmail.com
 * @version : NotificationMessageDTO, v 0.1 2020-08-15 23.33
 */
public class NotificationMessageDTO implements Serializable {

    private String target;

    private String title;

    private String body;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
