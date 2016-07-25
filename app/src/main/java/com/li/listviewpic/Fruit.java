package com.li.listviewpic;

/**
 * Created by lenovo on 2016/7/25.
 */
public class Fruit {

    private String name;
    private  int ImageId;

    public Fruit(int imageId, String name) {
        ImageId = imageId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return ImageId;
    }
}
