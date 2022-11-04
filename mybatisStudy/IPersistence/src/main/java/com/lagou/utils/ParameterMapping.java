package com.lagou.utils;

public class ParameterMapping {

    private String content;

    public ParameterMapping(String content) {
        this.content = content;
    }
    // #{id} 的id
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
