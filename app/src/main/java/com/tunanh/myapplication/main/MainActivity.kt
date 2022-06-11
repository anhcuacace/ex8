package com.tunanh.myapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.tunanh.myapplication.R
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var rcv_folder: RecyclerView? = null
    var folderList: MutableList<SinhVien> = ArrayList()
    var toolbar: Toolbar? = null

    var adapter: SInhVienAdapter? = null
    var databaseFolder: SinhVienHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    companion object {
        const val REQUEST_CODE_ADD_ITEM = 123
        const val REQUEST_CODE_EDIT_ITEM = 1234
        const val ACTION_ADD = "add"
        const val ACTION_EDIT = "edit"
        const val ITEM_SV = "item_sinhvien"
        const val LIST_SV = "list_sv"
        const val NAME_FOLDER = "name"
        const val DESCRIPTION_FOLDER = "description"
    }
}