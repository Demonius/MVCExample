/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.model.db

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table


@Table(name = "user")
class User : Model {
    constructor() : super()
    constructor(name: String, age: Int) : super() {
        this.name = name
        this.age = age
    }

    @Column(name = "Name")
    var name: String = ""

    @Column(name = "age")
    var age: Int = 0
}