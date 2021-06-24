package model

import java.io.PrintWriter
import java.net.Socket

//package com.bezkoder.kotlin.queue

import java.util.Queue
//import java.util.LinkedList
import java.util.LinkedBlockingQueue

class Model(ip: String?, port: Int) {

    private val out: PrintWriter
    val funcs: Queue<String> = LinkedBlockingQueue<String>()
    val values: Queue<Int> = LinkedBlockingQueue<Int>()

    thread{
        while(true){
            if (!funcs.isEmpty()){

                f = funcs.poll()
                n = values.poll()

                if(f == "setAileron"){
                    out.print("set /controls/flight/aileron$`val`\r\n")
                    out.flush()
                } else if (f == "setElevator"){
                    out.print("set /controls/flight/elevator$`val`\r\n")
                    out.flush()
                } else if(f == "setRudder"){
                    out.print("set /controls/flight/rudder$`val`\r\n")
                    out.flush()
                } else if (f == "setThrottle"){
                    out.print("set /controls/engines/current-engine/throttle$`val`\r\n")
                    out.flush()
                }
            }
        }
    }

    fun setAileron(`val`: Int) {
        funcs.add("setAileron")
        nums.add(`val`)
//        out.print("set /controls/flight/aileron$`val`\r\n")
//        out.flush()
    }

    fun setElevator(`val`: Int) {
        funcs.add("setElevator")
        nums.add(`val`)
//        out.print("set /controls/flight/elevator$`val`\r\n")
//        out.flush()
    }

    fun setRudder(`val`: Int) {
        funcs.add("setRudder")
        nums.add(`val`)
//        out.print("set /controls/flight/rudder$`val`\r\n")
//        out.flush()
    }

    fun setThrottle(`val`: Int) {
        funcs.add("setThrottle")
        nums.add(`val`)
//        out.print("set /controls/engines/current-engine/throttle$`val`\r\n")
//        out.flush()
    }

    init {
        val fg = Socket(ip, port)
        out = PrintWriter(fg.getOutputStream(), true)
    }
}