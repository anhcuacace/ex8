package com.tunanh.myapplication.main

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.ArrayList

class SinhVienHelper: SQLiteOpenHelper {
    val DATABASE_NAME: String = "SinhVien.db"
    val TABLE_NAME: String = "SinhVien"
    val KEY_ID: String = "id"
    val KEY_NAME: String = "name"
    val KEY_ADDRESS: String = "address"
    val KEY_PHONE:String ="phone"
    val DATABASE_VERSION:Int =1

    constructor(context: Context?, name: String?, factory: CursorFactory?, version: Int) : super(
        context,
        name,
        factory,
        version
    )

    override fun onCreate(db: SQLiteDatabase) {
        val sql="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +  KEY_NAME + " VACHAR(200)," +
                                KEY_ADDRESS +   "VACHAR(200)," +
                                KEY_PHONE + "  VACHAR(200) )"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
    val  allFolder : List < SinhVien >
        get() {
            val listSinhVien: MutableList<SinhVien> = ArrayList()
            val db = readableDatabase
            val data = db.rawQuery("SELECT * FROM " + TABLE_NAME + "", null)
            while (data.moveToNext()) {
                val id = data.getInt(data.getColumnIndex(KEY_ID))
                val name = data.getString(data.getColumnIndex(KEY_NAME))
                val address = data.getString(data.getColumnIndex(KEY_ADDRESS))
                val phone = data.getString(data.getColumnIndex(KEY_PHONE))
                listSinhVien.add(SinhVien(id, name, address,phone))
            }
            return listSinhVien
        }
    fun insertSinhVien(sinhVien: SinhVien) {
        val db = writableDatabase
        //db.execSQL("INSERT INTO "+TABLE_NAME+"(name,description) VALUES (?,?)",new String[]{folder.getName(),folder.getDescription()});
        db.execSQL("INSERT INTO "+TABLE_NAME+"(name,address,phone) VALUES ('" + sinhVien.name + "','" + sinhVien.address + "','"+sinhVien.phone+"')")
        Log.d("AAA", "thêm mới dữ liệu thành công")
    }

    fun updateSinhVien(sinhVien: SinhVien) {
        val db = writableDatabase
        db.execSQL(
            "UPDATE " + TABLE_NAME + " SET " +
                    KEY_NAME + " = ?," +
                    KEY_ADDRESS + " = ?"+
                    KEY_ADDRESS+"= ? WHERE " +
                    KEY_ID + " = ?",
            arrayOf(sinhVien.name, sinhVien.address, sinhVien.phone,sinhVien.id.toString() + "")
        )
    }

    fun deleteFolder(sinhVien: SinhVien) {
        val db = writableDatabase
        val sql = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=? "
        db.execSQL(sql, arrayOf(sinhVien.id.toString() + ""))
    }

}