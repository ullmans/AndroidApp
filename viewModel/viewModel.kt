package viewModel

import model

class ViewModel(ip: String?, port: Int) {

    private var model: Model
    private var aileron: Int
    private var elevator: Int
    private var rudder: Int
    private var throttle: Int
           
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
        model = Model(ip, port)
        aileron = 0
        elevator = 0
        rudder = 0
        throttle = 0
    }
}