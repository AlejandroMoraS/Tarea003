package com.iteso.is705419.sesion10.database;

import android.content.ClipData;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.is705419.sesion10.beans.Category;
import com.iteso.is705419.sesion10.beans.City;
import com.iteso.is705419.sesion10.beans.ItemProduct;
import com.iteso.is705419.sesion10.beans.Store;

import java.util.ArrayList;

/**
 * Created by Alex Mora on 16/10/2017.
 */

public class ItemProductControl {
    public long addItemProduct(ItemProduct product,DataBaseHandler dh){

        return 1;
    }

    public long updateProduct(ItemProduct product,DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getIdCategory());
        values.put(DataBaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DataBaseHandler.KEY_PRODUCT_TITLE, product.getTitle());

// Updating row
        int count = db.update(DataBaseHandler.TABLE_PRODUCT, values,
                DataBaseHandler.KEY_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(product.getCode())});
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
        return count;
    }

    public void deleteProduct(int idProduct,DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DataBaseHandler.TABLE_PRODUCT, DataBaseHandler.KEY_PRODUCT_ID
                + " = ?", new String[]{String.valueOf(idProduct)});
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
    }
    public ItemProduct getProductById(int idProduct, DataBaseHandler dh) {
        ItemProduct itemProduct = new ItemProduct();
        String selectQuery = "SELECT S." + DataBaseHandler.KEY_STORE_ID + ","
                + "S." + DataBaseHandler.KEY_STORE_LAT + ","
                + "S." + DataBaseHandler.KEY_STORE_LNG + ","
                + "S." + DataBaseHandler.KEY_STORE_NAME + ","
                + "S." + DataBaseHandler.KEY_STORE_PHONE + ","
                + "S." + DataBaseHandler.KEY_STORE_THUMBNAIL + ","
                + "C." + DataBaseHandler.KEY_CITY_ID + ","
                + "C." + DataBaseHandler.KEY_CITY_NAME + ","
                + "CA." + DataBaseHandler.KEY_CATEGORY_ID + ","
                + "CA." + DataBaseHandler.KEY_CATEGORY_NAME + ","
                + "P." + DataBaseHandler.KEY_PRODUCT_IMAGE + ","
                + "P." + DataBaseHandler.KEY_PRODUCT_ID + ","
                + "P." + DataBaseHandler.KEY_PRODUCT_TITLE + " FROM "
                + DataBaseHandler.TABLE_STORE + " S, "
                + DataBaseHandler.TABLE_CITY + " C, "
                + DataBaseHandler.TABLE_CATEGORY + " CA, "
                + DataBaseHandler.TABLE_PRODUCT + " P WHERE P."
                + DataBaseHandler.KEY_PRODUCT_ID + "= " + idProduct
                + " AND P." + DataBaseHandler.KEY_PRODUCT_CATEGORY
                + " = CA." + DataBaseHandler.KEY_CATEGORY_ID
                + " AND S." + DataBaseHandler.KEY_STORE_CITY
                + " = C." + DataBaseHandler.KEY_CITY_ID;


        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            Store store = new Store();
            store.setId(cursor.getInt(0));
            store.setLatitude(cursor.getDouble(1));
            store.setLongitude(cursor.getDouble(2));
            store.setName(cursor.getString(3));
            store.setPhone(cursor.getString(4));
            store.setThumbnail(cursor.getInt(5));

            City city = new City();
            city.setIdCity(cursor.getInt(6));
            city.setName(cursor.getString(7));

            Category category = new Category();
            category.setIdCategory(cursor.getInt(8));
            category.setName(cursor.getString(9));

            itemProduct.setImage(cursor.getInt(10));
            itemProduct.setCode(cursor.getInt(11));
            itemProduct.setTitle(cursor.getString(12));
            itemProduct.setCategory(category);
            itemProduct.setStore(store);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }

        return itemProduct;
    }
    public ArrayList<ClipData.Item> getProductsWhere(String strWhere,String strOrderBy,DataBaseHandler dh){
        return new ArrayList<ClipData.Item>();
    }
}
