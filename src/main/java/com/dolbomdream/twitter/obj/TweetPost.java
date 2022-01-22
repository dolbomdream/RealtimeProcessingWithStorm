package com.dolbomdream.twitter.obj;

import java.util.Date;

public class TweetPost {

    private Long id;
    private String text;
    private String lang;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TweetPost{" +
                "id=" + this.id +
                ", text='" + this.text + '\'' +
                ", lang='" + this.lang + '\'' +
                ", createdAt=" + this.createdAt +
                '}' + '\n';
    }
}
