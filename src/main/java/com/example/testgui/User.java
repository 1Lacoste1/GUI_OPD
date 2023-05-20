package com.example.testgui;

public class User {
    private String number_phone, name,  date_recording, type_service, brand_auto;
    private String date_issue, desc_problem, radius_wheel, model;

    public User(String number_phone, String name, String type_service) {
        this.number_phone = number_phone;
        this.name = name;
        this.type_service = type_service;
    }

    public User(String date_recording, String brand_auto, String model, String date_issue, String desc_problem, String radius_wheel) {
        this.date_recording = date_recording;
        this.brand_auto = brand_auto;
        this.model = model;
        this.date_issue = date_issue;
        this.desc_problem = desc_problem;
        this.radius_wheel = radius_wheel;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_recording() {
        return date_recording;
    }

    public void setDate_recording(String date_recording) {
        this.date_recording = date_recording;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

    public String getBrand_auto() {
        return brand_auto;
    }

    public void setBrand_auto(String brand_auto) {
        this.brand_auto = brand_auto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(String date_issue) {
        this.date_issue = date_issue;
    }

    public String getDesc_problem() {
        return desc_problem;
    }

    public void setDesc_problem(String desc_problem) {
        this.desc_problem = desc_problem;
    }

    public String getRadius_wheel() {
        return radius_wheel;
    }

    public void setRadius_wheel(String radius_wheel) {
        this.radius_wheel = radius_wheel;
    }
}

