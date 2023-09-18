/*
 * Copyright (c) 2023-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package io.avchain.rhymecard.sqlite.common;

public class SqlQuery {
    public static final String TB_MEMBER_NAME = "Member";
    public static final String TB_MEMBER_CREATE =
            "CREATE TABLE IF NOT EXISTS "+TB_MEMBER_NAME+" (" +
                    " MemberSeq integer PRIMARY KEY AUTOINCREMENT, " +
                    " Name varchar(255) DEFAULT(''), " +
                    " Nickname varchar(255) DEFAULT(''), " +
                    " Phone varchar(255) DEFAULT(''), " +
                    " Mobile varchar(20) DEFAULT(''), " +
                    " Email varchar(255) DEFAULT(''), " +
                    " Gender varchar(255) DEFAULT(''), " +
                    " Token varchar(255) DEFAULT(''), " +
                    " ID varchar(255) DEFAULT(''), " +
                    " Birth varchar(255) DEFAULT(''), " +
                    " AutoLogin integer DEFAULT(0), " +
                    " Password varchar(255) DEFAULT(''), " +
                    " LastUpdate datetime DEFAULT('0000.00.00 00:00:00'), " +
                    " SystemTypeCode varchar(20) DEFAULT(''), " +
                    " IPAuth varchar(100) DEFAULT(''), " +
                    " IPPlatform varchar(100) DEFAULT(''), " +
                    " IPAgent varchar(100) DEFAULT(''), " +
                    " Profile varchar(255) DEFAULT('')) ";
}
