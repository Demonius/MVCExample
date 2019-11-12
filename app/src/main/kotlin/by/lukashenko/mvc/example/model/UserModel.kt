/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.model

import by.lukashenko.mvc.example.model.db.User
import com.activeandroid.ActiveAndroid
import com.activeandroid.query.Select

class UserModel() {

    fun getAllUser(): List<User> = Select().from(User::class.java).execute()


    fun deleteAllUser() {
        ActiveAndroid.beginTransaction()
        try {
            getAllUser().forEach { user ->
                user.delete()
            }
            ActiveAndroid.setTransactionSuccessful()
        } finally {
            ActiveAndroid.endTransaction()
        }

    }

    fun addUser(user: User) {
        ActiveAndroid.beginTransaction()
        try {
            user.save()
            ActiveAndroid.setTransactionSuccessful()
        } finally {
            ActiveAndroid.endTransaction()
        }
    }
}