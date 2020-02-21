package ru.gc986.sqlitetest.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.gc986.sqlitetest.db.DBNames.DB_PRODUCT_AMOUNT
import ru.gc986.sqlitetest.db.DBNames.DB_PRODUCT_ID
import ru.gc986.sqlitetest.db.DBNames.DB_PRODUCT_NAME
import ru.gc986.sqlitetest.db.DBNames.DB_TABLE_PRODUCT

class DBHelper(context: Context): SQLiteOpenHelper(context, dbName, null, dbVersion) {
    override fun onCreate(db: SQLiteDatabase?) {
        // создаем таблицу с полями
        db?.execSQL("create table $DB_TABLE_PRODUCT ("
                + "$DB_PRODUCT_ID integer primary key autoincrement,"
                + "$DB_PRODUCT_NAME text,"
                + "$DB_PRODUCT_AMOUNT integer" + ");");
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}