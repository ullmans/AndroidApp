package model

import java.io.PrintWriter
import java.net.Socket

//package com.bezkoder.kotlin.queue

import java.util.Queue
//import java.util.LinkedList
import java.util.LinkedBlockingQueue

class Model() {

    private val out: PrintWriter
    val funcs: Queue<String>
    val values: Queue<Int>
//    val funcs: Queue<String> = LinkedBlockingQueue<String>()
//    val values: Queue<Int> = LinkedBlockingQueue<Int>()

   init{
       funcs = LinkedBlockingQueue<String>()
       values = LinkedBlockingQueue<Int>()
   }

    fun setAileron(`val`: Int) {
        funcs.add("setAileron")
        values.add(`val`)
    }

    fun setElevator(`val`: Int) {
        funcs.add("setElevator")
        values.add(`val`)
    }

    fun setRudder(`val`: Int) {
        funcs.add("setRudder")
        values.add(`val`)
    }

    fun setThrottle(`val`: Int) {
        funcs.add("setThrottle")
        values.add(`val`)
    }

    fun connect(ip: String?, port: Int) {
        val fg = Socket(ip, port)
        out = PrintWriter(fg.getOutputStream(), true)

        thread{
            while(true){
                if (!funcs.isEmpty()){

                    f = funcs.poll()
                    n = values.poll()

                    if(f == "setAileron"){
                        out.write("set /controls/flight/aileron$`val`\r\n")
                        out.flush()
                    } else if (f == "setElevator"){
                        out.write("set /controls/flight/elevator$`val`\r\n")
                        out.flush()
                    } else if(f == "setRudder"){
                        out.write("set /controls/flight/rudder$`val`\r\n")
                        out.flush()
                    } else if (f == "setThrottle"){
                        out.write("set /controls/engines/current-engine/throttle$`val`\r\n")
                        out.flush()
                    }
                }
            }
        }
    }
}