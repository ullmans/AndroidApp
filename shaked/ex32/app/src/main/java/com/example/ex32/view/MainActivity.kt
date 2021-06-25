package com.example.ex32.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import viewModel.viewModel
import android.widget.EditText
import com.example.ex32.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
        onClick of the button, that connect to fg
    */
    fun connect(view: View) {
        val ip = findViewById(R.id.IP) as EditText
        val port = findViewById(R.id.PORT) as EditText
        viewmodel = viewModel(ip.toString(), port.toString().toInt())
//        send to view model ip and port
    }
}