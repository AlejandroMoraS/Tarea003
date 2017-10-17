package com.iteso.is705419.sesion10.beans;

import android.os.Parcel;

import static com.iteso.is705419.sesion10.R.id.location;

/**
 * Created by alejandromorasanchez on 21/09/17.
 */

public class ItemProduct {
    private int code;
    private int image;
    private String title;
    private String description;
    private Category category;
    private Store store;
    private int location;

    public ItemProduct(Parcel in){
        store = in.readParcelable(Store.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(store, flags);
        dest.writeParcelable(category, flags);
    }

    public ItemProduct(){

    }

    public ItemProduct(int code, int image, String title, String description, Category category, Store store) {
        this.code = code;
        this.image = image;
        this.title = title;
        this.description = description;
        this.category = category;
        this.store = store;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getLocation() {
        return location;
    }
}
