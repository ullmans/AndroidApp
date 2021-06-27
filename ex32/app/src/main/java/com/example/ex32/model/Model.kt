package com.example.ex32.model

import java.io.PrintWriter
import java.net.Socket

import java.util.Queue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

/**
 * every setter add the change to the queueus and the thread send it when the queue
 * is not empty
 */
class Model(ip: String?, port: Int) {
    //queues for save the correct thing to change and the number
    val funcs: Queue<String> = LinkedBlockingQueue<String>()
    val nums: Queue<Double> = LinkedBlockingQueue<Double>()

    fun setAileron(`val`: Double) {
        funcs.add("setAileron")
        nums.add(`val`)
    }

    fun setElevator(`val`: Double) {
        funcs.add("setElevator")
        nums.add(`val`)
    }

    fun setRudder(`val`: Double) {
        funcs.add("setRudder")
        nums.add(`val`)
    }

    fun setThrottle(`val`: Double) {
        funcs.add("setThrottle")
        nums.add(`val`)
    }

    init {


        thread{
            //connect to the FG with socket
            val fg = Socket(ip, port)
            val out = PrintWriter(fg.getOutputStream(), true)


            while(true){
                //poll the order and send to FG
                if (!funcs.isEmpty()){

                    val f = funcs.poll()
                    val n = nums.poll()


                    if(f == "setAileron"){
                        out.print("set /controls/flight/aileron $n`\r\n")
                        out.flush()
                    } else if (f == "setElevator"){
                        out.print("set /controls/flight/elevator $n`\r\n")
                        out.flush()
                    } else if(f == "setRudder"){
                        out.print("set /controls/flight/rudder $n`\r\n")
                        out.flush()
                    } else if (f == "setThrottle"){
                        out.print("set /controls/engines/current-engine/throttle $n`\r\n")
                        out.flush()
                    }
                }
            }
        }
    }
}