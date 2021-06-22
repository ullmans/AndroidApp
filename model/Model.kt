package model

import java.io.PrintWriter
import java.net.Socket

class Model(ip: String?, port: Int) {
    private val out: PrintWriter
    fun setAileron(`val`: Int) {
        out.print("set /controls/flight/aileron$`val`\r\n")
        out.flush()
    }

    fun setElevator(`val`: Int) {
        out.print("set /controls/flight/elevator$`val`\r\n")
        out.flush()
    }

    fun setRudder(`val`: Int) {
        out.print("set /controls/flight/rudder$`val`\r\n")
        out.flush()
    }

    fun setThrottle(`val`: Int) {
        out.print("set /controls/engines/current-engine/throttle$`val`\r\n")
        out.flush()
    }

    init {
        val fg = Socket(ip, port)
        out = PrintWriter(fg.getOutputStream(), true)
    }
}