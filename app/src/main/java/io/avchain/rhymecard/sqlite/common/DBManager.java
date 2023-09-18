/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package io.avchain.rhymecard.sqlite.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import io.avchain.rhymecard.config.CommonConfig;

public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public DBManager(Context context) {
        Log.i(CommonConfig.APP_TAG,"new DBManager(Context context) ");
        this.context = context;
        this.dbHelper = new DBHelper(context, CommonConfig.DATABASE_NAME, null, CommonConfig.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
       return this.db;
    }

    public void close() {
        this.dbHelper.close();
    }

    public void update(String tableName, ContentValues values, String whereClause, String[] whereValues) {
        int id = db.update(tableName, values, whereClause, whereValues);
        if (id == 0) {
            Log.d(CommonConfig.APP_TAG,"update 성공");
            db.insertWithOnConflict(tableName, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }
    }

    public void delete(String tableName, String whereClause, String[] whereValues) {
        db.delete(tableName, whereClause, whereValues);
    }

    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
