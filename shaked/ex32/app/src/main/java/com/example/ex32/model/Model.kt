package model

import java.io.PrintWriter
import java.net.Socket

//package com.bezkoder.kotlin.queue

import java.util.Queue
//import java.util.LinkedList
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

class Model(ip: String?, port: Int) {

    private val out: PrintWriter
    val funcs: Queue<String> = LinkedBlockingQueue<String>()
    val nums: Queue<Int> = LinkedBlockingQueue<Int>()

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

        thread{
            while(true){
                if (!funcs.isEmpty()){

                    val f = funcs.poll()
                    val n = nums.poll()

                    if(f == "setAileron"){
                        out.print("set /controls/flight/aileron$n`\r\n")
                        out.flush()
                    } else if (f == "setElevator"){
                        out.print("set /controls/flight/elevator$n`\r\n")
                        out.flush()
                    } else if(f == "setRudder"){
                        out.print("set /controls/flight/rudder$n`\r\n")
                        out.flush()
                    } else if (f == "setThrottle"){
                        out.print("set /controls/engines/current-engine/throttle$n`\r\n")
                        out.flush()
                    }
                }
            }
        }
    }
}