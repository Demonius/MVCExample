/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.controler

import android.app.Activity
import android.content.Intent
import by.lukashenko.mvc.example.model.UserModel
import by.lukashenko.mvc.example.model.db.User
import by.lukashenko.mvc.example.view.AddActivity
import by.lukashenko.mvc.example.view.MainActivity

class ControllerMainActivity(
    private val view: MainActivity,
    private val model: UserModel
) {

    companion object {
        private const val REQUEST_CODE = 555
    }

    private var listUser: List<User> = ArrayList()

    private fun showAllData() {
        view.handlerListUser(listUser)
    }

    fun showAddView() {
        val intent = Intent(view, AddActivity::class.java)
        view.startActivityForResult(intent, REQUEST_CODE)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE -> setResultData(resultCode, data)
        }
    }

    private fun setResultData(resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> setResultData(data)
        }
    }

    private fun setResultData(data: Intent?) {
        data?.apply {

        }
    }

    fun clearListUser() {
        listUser = emptyList()
        model.deleteAllUser()
        showAllData()
    }

    fun getData() {
        listUser = model.getAllUser()
        showAllData()
    }
}