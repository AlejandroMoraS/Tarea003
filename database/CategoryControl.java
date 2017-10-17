package com.iteso.is705419.sesion10.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.is705419.sesion10.beans.Category;
import com.iteso.is705419.sesion10.beans.Store;

import java.util.ArrayList;

/**
 * Created by Alex Mora on 16/10/2017.
 */

public class CategoryControl {

    public ArrayList<Store> getStoresWhere (int x, int x1, DataBaseHandler dh){
        return new ArrayList<>();
    }
    public  ArrayList<Category> getAllCategories( DataBaseHandler dh){
        ArrayList<Category> categories = new ArrayList<>();
        String selectQuery = "SELECT C." + DataBaseHandler.KEY_CATEGORY_ID + ","
                + "C." + DataBaseHandler.KEY_CATEGORY_NAME + " FROM "
                + DataBaseHandler.TABLE_CATEGORY + " C";
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do{
                Category category = new Category();
                category.setIdCategory(cursor.getInt(0));
                category.setName(cursor.getString(1));
                categories.add(category);
            }while (cursor.moveToNext());
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        return  categories;
    }

}
