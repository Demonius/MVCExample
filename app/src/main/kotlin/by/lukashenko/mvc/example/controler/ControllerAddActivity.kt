/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.controler

import android.app.Activity
import by.lukashenko.mvc.example.model.UserModel
import by.lukashenko.mvc.example.model.db.User
import by.lukashenko.mvc.example.view.AddActivity

class ControllerAddActivity(private val view: AddActivity, private val model: UserModel) {

    companion object {
        private const val ZERO_AGE = 0
    }

    private val user = User()
    private var stateErrorInputName = false
    private var stateErrorInputAge = false

    fun setName(name: String) {
        user.name = name
        checkName()
    }

    private fun checkName() {
        stateErrorInputName = user.name.isNotEmpty()
    }

    fun setAge(age: String) {
        user.age = if (age.isNotEmpty()) age.toInt() else ZERO_AGE
        checkAge()
    }

    private fun checkAge() {
        stateErrorInputAge = user.age > ZERO_AGE
    }

    fun addUser() {

        if (!stateErrorInputName) {
            view.setErrorInputLayout(!stateErrorInputName)
            return
        }

        if (!stateErrorInputAge) {
            view.setErrorInputAge(!stateErrorInputAge)
            return
        }

        if (stateErrorInputName && stateErrorInputAge) {
            model.addUser(user)
            view.setResult(Activity.RESULT_OK)
            view.finish()
        }
    }
}