package viewModel

import model

class ViewModel(ip: String?, port: Int) {

    val model: Model
    var aileron: Int
    var elevator: Int
    var rudder: Int
    var throttle: Int
    val ip: String?
    val port: Int

    var aileron: Int
        set(value) {
            aileron=value
            model.setAileron(value)
        }
    var elevator: Int
        set(value){
            elevator=value
            model.setElevator(elevator)
        }
    var rudder: Int
        set(value){
            ruuder=value
            model.setRudder(rudder)
        }
    var throttle: Int
        set(value){
            throttle=value
            model.setThrottle(throttle)
        }
    var ip: String?
        set(value){
            ip=value
        }
    var port: Int{
        set(value){
            port=value
        }
    }

    fun connect(){
        model.connect(ip, port)
    }

    init {
        this.model = Model
        this.aileron = 0
        this.elevator = 0
        this.rudder = 0
        this.throttle = 0
    }
}