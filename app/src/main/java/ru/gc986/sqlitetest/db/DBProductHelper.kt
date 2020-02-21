package ru.gc986.sqlitetest.db

import android.content.ContentValues
import ru.gc986.sqlitetest.db.DBNames.DB_PRODUCT_AMOUNT
import ru.gc986.sqlitetest.db.DBNames.DB_PRODUCT_NAME
import ru.gc986.sqlitetest.db.DBNames.DB_TABLE_PRODUCT


class DBProductHelper(val db: DBHelper) {

    fun putProduct(name: String, amount: Int){
        val wDB = db.getWritableDatabase()

        val cv = ContentValues()
        cv.put(DB_PRODUCT_NAME, name)
        cv.put(DB_PRODUCT_AMOUNT, amount)
        wDB.insert(DB_TABLE_PRODUCT, null, cv)
    }

    fun getCount(): Int{
        val wDB = db.getWritableDatabase()
        val cursor = wDB.query(DB_TABLE_PRODUCT, null, null, null, null, null, null)
        return cursor.count
    }

}