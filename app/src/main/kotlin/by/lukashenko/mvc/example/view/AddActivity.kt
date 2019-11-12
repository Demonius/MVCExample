/*
 * Copyright (c) 2019.
 * It's added by Lukashenko Dmitriy
 */

package by.lukashenko.mvc.example.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import by.lukashenko.mvc.example.R
import by.lukashenko.mvc.example.controler.ControllerAddActivity
import by.lukashenko.mvc.example.model.UserModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private lateinit var controler: ControllerAddActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val model = UserModel()
        controler = ControllerAddActivity(this, model)
        initView()
    }

    private fun initView() {
        etEnterName.apply {
            addTextChangedListener(InputUserTextWatcher(this))
        }
        etEnterAge.apply {
            addTextChangedListener(InputUserTextWatcher(this))
        }

        btnAddUser.setOnClickListener { controler.addUser() }
    }


    fun setErrorInputLayout(stateError: Boolean) {
        layoutEnterName.apply {
            isErrorEnabled = stateError
            error = getString(R.string.error_input_name)
        }
    }

    fun setErrorInputAge(stateError: Boolean) {
        layoutEnterAge.apply {
            isErrorEnabled = stateError
            error = getString(R.string.error_input_age)
        }
    }

    private inner class InputUserTextWatcher(private val view: TextInputEditText) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            when (view.id) {
                R.id.etEnterName -> controler.setName(s.toString())
                R.id.etEnterAge -> controler.setAge(s.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }
}
