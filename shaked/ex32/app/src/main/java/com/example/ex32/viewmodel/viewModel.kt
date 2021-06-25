package viewModel

import model.Model

class viewModel(ip: String?, port: Int) {

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
        this.model = Model(ip, port)
        this.aileron = 0
        this.elevator = 0
        this.rudder = 0
        this.throttle = 0
    }
}