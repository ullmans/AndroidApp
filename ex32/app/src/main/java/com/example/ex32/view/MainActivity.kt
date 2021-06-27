package com.example.ex32.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.ex32.R
import com.example.ex32.viewmodel.viewModel
import android.view.MotionEvent

import android.view.View.OnTouchListener

class MainActivity : AppCompatActivity() {

    private lateinit var vm: viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add listener to follow the change of rudder
        val rudder = findViewById<SeekBar>(R.id.rudder)
        rudder?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // because the values are from -1 to 1
                vm.setRudder((progress - 500).toDouble() / 500)
            }
            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                vm.setRudder((seek.progress - 500).toDouble()/ 500)
            }
        })

        //add listener to follow the change of throttle
        val throttle = findViewById<SeekBar>(R.id.throttle)
        throttle?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                vm.setThrottle(progress.toDouble() / 1000)
            }
            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {
                vm.setThrottle(seek.progress.toDouble() / 1000)
            }
        })
        // add listener to joystick to send elevator and aileron
        val joystick = findViewById<Joystick>(R.id.Joystick)
        joystick.setOnTouchListener { v, event ->
            //set the place of joystick
            joystick.setElevator(event.x.toDouble())
            joystick.setAileron(event.y.toDouble())
            //print after change
            joystick.postInvalidate()
            // send values to FG
            vm.setElevator(2*(event.x - v.width/2).toDouble() / v.width )
            vm.setAileron(-2*((event.y - v.height/2).toDouble() / v.height))
            return@setOnTouchListener true
        }

    }


    /*
        onClick of the button, that connect to fg
    */
    fun connect(view: View) {
        val ip = findViewById<EditText>(R.id.IP)
        val port = findViewById<EditText>(R.id.PORT)
        vm = viewModel(ip.text.toString(), port.text.toString().toInt())
//        send to view model ip and port
    }
}