package ru.jjd.base.lesson11.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime dateCreated;
    private Country country;//ссылка на enum country

    public Article(String title) {
        if (title != null) {
            setTitle(title);
            setDateCreated(LocalDateTime.now());
        }
    }

    public void setText(String text) {
        if (text != null) {
            this.text = text;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        if (dateCreated != null) {
            this.dateCreated = dateCreated;
        }
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country + "";
    }
}
