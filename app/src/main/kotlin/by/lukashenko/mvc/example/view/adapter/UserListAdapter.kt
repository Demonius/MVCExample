/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.lukashenko.mvc.example.R
import by.lukashenko.mvc.example.model.db.User

class UserListAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var listUser: List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = listUser.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.hold(listUser[position])
    }

    fun addAllData(list: List<User>) {
        listUser = list
        notifyDataSetChanged()
    }
}