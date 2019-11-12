/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example

import android.app.Application
import com.activeandroid.ActiveAndroid

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ActiveAndroid.initialize(this)
    }
}