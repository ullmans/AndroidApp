package viewModel

import model

class ViewModel(m:Model) {

    private var model: Model
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
        aileron = 0
        elevator = 0
        rudder = 0
        throttle = 0
    }
}