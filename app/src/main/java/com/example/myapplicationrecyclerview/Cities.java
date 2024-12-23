package com.example.myapplicationrecyclerview;

public class Cities {
    private String img;
    private String name;
    private String  description;

    public Cities(String img, String name, String description) {
        this.img = img;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
