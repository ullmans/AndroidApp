package com.example.ex32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

import viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //why doesnt he know the view model??
        viewModel = viewModel()
        val binding: ActivityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_Main)
        binding.viewModel=viewModel
    }

    /*
        onClick of the button, that connect to fg
    */
    fun connect(view: View) {
        val ip = findViewById(R.id.IP) as EditText
        val port = findViewById(R.id.PORT) as EditText
        //why doesnt he knows the ip and port of the view model??
        viewModel.ip=ip
        viewModel.port=port
        viewModel.connect()
    }
}