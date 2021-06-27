package com.example.ex32.view
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar
import com.example.ex32.R
import java.util.ArrayList

class Joystick(context: Context, attrs: AttributeSet) : View(context, attrs) {

//    private var x: Double
//    private var y: Double
    private var elevator: Double
    private var aileron: Double
    // to start the joystick in the middle
    private var start = true

    init {
        //middle of the joystick
        this.elevator = (super.getWidth()/2).toDouble()
        this.aileron = (super.getHeight()/2).toDouble()
    }
    
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL


        if(start) {
            this.elevator = (super.getWidth()/2).toDouble()
            this.aileron = (super.getHeight()/2).toDouble()
            start = false
        }
        // draw a basis circle in the middle
        canvas.drawCircle(
            (super.getWidth()/2).toFloat(),
            (super.getHeight()/2).toFloat(),
            (2*(super.getHeight()/5)).toFloat(),
            paint
            )
        //print the joystick
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawCircle(
            this.elevator.toFloat(),
            this.aileron.toFloat(),
            (super.getHeight()/4).toFloat(),
            paint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var size = Math.min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        // when touch - cahnge the place of the joystick
        this.elevator = e.x.toDouble()
        this.aileron = e.y.toDouble()
        postInvalidate()
        return true;
    }

    fun setElevator(`val`: Double) {
        this.elevator = `val`
    }
    fun setAileron(`val`: Double) {
        this.aileron = `val`
    }
}