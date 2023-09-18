/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package io.avchain.rhymecard.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import io.avchain.rhymecard.dto.request.LoginDto;
import io.avchain.rhymecard.dto.request.UserDto;
import io.avchain.rhymecard.sqlite.common.DBManager;
import io.avchain.rhymecard.sqlite.common.SqlQuery;

@SuppressLint("Range")
public class UserDb {

    DBManager dbManager;

    public UserDb(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void updateUserData(String userId){
        ContentValues initialValues = new ContentValues();
        initialValues.put("ID", userId);
        this.dbManager.update(SqlQuery.TB_MEMBER_NAME, initialValues, "LastUpdate = ?", new String[] { this.dbManager.getDateTime() });
    }

    public UserDto getUserData(String userID) {
        UserDto user = new UserDto();
        SQLiteDatabase db = this.dbManager.getDb();
        String[] selectionArgs = {userID};
        Cursor cursor = db.query(
                SqlQuery.TB_MEMBER_NAME,
                null,
                "ID=?",
                selectionArgs,
                null,
                null,
                null
        );
        if(cursor.getCount() == 0) return null;
        while(cursor.moveToNext()) {
            user.setId(cursor.getString(cursor.getColumnIndex("ID")));
        }
        return user;
    }
}
