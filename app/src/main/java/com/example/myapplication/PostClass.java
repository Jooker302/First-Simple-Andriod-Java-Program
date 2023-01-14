package com.example.myapplication;

public class PostClass {
    private String title;
    private String price;
    private String contact;

    public PostClass(String title, String price, String contact) {
        this.title = title;
        this.price = price;
        this.contact = contact;
    }

    public PostClass() {
    }

    @Override
    public String toString() {
        return "PostClass{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
