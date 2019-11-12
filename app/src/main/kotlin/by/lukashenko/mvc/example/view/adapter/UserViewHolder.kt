/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.lukashenko.mvc.example.R
import by.lukashenko.mvc.example.model.db.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun hold(item: User) {
        containerView.apply {
            tvName.text = context.getString(R.string.text_name, item.name)
            tvAge.text = context.getString(R.string.text_age, item.age.toString())
        }
    }
}