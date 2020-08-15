package com.twentyspace.springfcm.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author yogaagungk@gmail.com
 * @version : TopicMessageDTO, v 0.1 2020-08-15 23.31
 */
public class TopicMessageDTO implements Serializable {

    private String topicName;

    private List<String> tokens;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
}
