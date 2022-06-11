package com.tunanh.myapplication.main

import java.io.Serializable

class SinhVien : Serializable {
    constructor( id: Int,name: String, address: String, phone: String) {
        this.name = name
        this.address = address
        this.phone = phone
        this.id = id
    }

    var name: String
    var address: String
    var phone: String
    var id: Int
}