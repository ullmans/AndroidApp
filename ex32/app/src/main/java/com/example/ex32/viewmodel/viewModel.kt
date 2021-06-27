package com.example.ex32.viewmodel

import com.example.ex32.model.Model

class viewModel(ip: String?, port: Int) {

    private var model: Model
    private var aileron: Double
    private var elevator: Double
    private var rudder: Double
    private var throttle: Double

    fun setAileron(`val`: Double) {
        aileron = `val`
       model.setAileron(aileron)
    }

    fun setElevator(`val`: Double) {
        elevator = `val`
      model.setElevator(elevator)
    }

    fun setRudder(`val`: Double) {
        rudder = `val`
        model.setRudder(rudder)
    }

    fun setThrottle(`val`: Double) {
        throttle = `val`
       model.setThrottle(throttle)
    }

    init {
        this.model = Model(ip, port)
        this.aileron = 0.toDouble()
        this.elevator = 0.toDouble()
        this.rudder = 0.toDouble()
        this.throttle = 0.toDouble()
    }
}