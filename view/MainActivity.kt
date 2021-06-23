package com.example.ex32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
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
//        send to view model ip and port
    }
}