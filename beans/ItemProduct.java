package com.iteso.is705419.sesion10.beans;

/**
 * Created by alejandromorasanchez on 21/09/17.
 */

public class ItemProduct {

    int image;
    String store,location,phone,description;
    String title;

    public ItemProduct(int image, String store, String location, String phone, String description, String title) {
        image = 0;
        store = "";location="";phone="";description=""; title= "";
        this.title = title;
        this.image = image;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public ItemProduct() {
        image = 0;
        store = "";location="";phone="";description=""; title= "";
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
