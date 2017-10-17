package com.iteso.is705419.sesion10.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex Mora on 16/10/2017.
 */

public class Category implements Parcelable {
    private int idCategory;
    private String name;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
