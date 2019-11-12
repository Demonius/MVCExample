/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.lukashenko.mvc.example.R
import by.lukashenko.mvc.example.controler.ControllerMainActivity
import by.lukashenko.mvc.example.model.UserModel
import by.lukashenko.mvc.example.model.db.User
import by.lukashenko.mvc.example.view.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainController: ControllerMainActivity
    private lateinit var adapterUser: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val model = UserModel()
        mainController = ControllerMainActivity(this, model)

        initView()
        fab.setOnClickListener(this)

        mainController.getData()
    }

    private fun initView() {
        adapterUser = UserListAdapter()
        vpListUser.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = adapterUser
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> actionClearButton()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun actionClearButton(): Boolean {
        mainController.clearListUser()
        return true
    }

    override fun onClick(view: View?) {
        view?.let {
            when (view.id) {
                R.id.fab -> mainController.showAddView()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mainController.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun handlerListUser(listUser: List<User>) {
        adapterUser.addAllData(listUser)
    }
}
