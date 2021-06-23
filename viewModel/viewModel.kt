package viewModel

import model.Model

class ViewModel(var m:Model, var aileron: Int, var elevator: Int, var rudder: Int, var throttle: Int,) {

    private var m: Model
    private var aileron: Int = 0
    private var elevator: Int = 0
    private var rudder: Int = 0
    private var throttle: Int = 0
           
    fun setAileron(`val`: Int) {
       model.setAileron(aileron) 
    }

    fun setElevator(`val`: Int) {
      model.setElevator(elevator)
    }

    fun setRudder(`val`: Int) {
        model.setRudder(rudder)
    }

    fun setThrottle(`val`: Int) {
       model.setThrottle(throttle)
    }

    init {
        model = m
//        aileron = findViewById(R.id.aileronBar)
//        elevator = findViewById(R.id.elevator)
//        rudder = findViewById(R.id.rudderBar)
//        throttle = findViewById(R.id.throttleBar)
    }
}