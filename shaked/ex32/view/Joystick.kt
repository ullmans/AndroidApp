package com.example.ex32.view
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.ArrayList

class Joystick(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var x = -1
    private var y = -1

    init {
        this.x = super.getWidth()/2
        this.y = super.getHeight()/2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL
        if (this.x == -1 && this.y==-1) {
            this.x = super.getWidth()/2
            this.y = super.getHeight()/2
        }

        canvas.drawCircle(
            (super.getWidth()/2).toFloat(),
            (super.getHeight()/2).toFloat(),
            (2*(super.getHeight()/5)).toFloat(),
            paint
            )
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawCircle(
            this.x.toFloat(),
            this.y.toFloat(),
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
        this.x = e.x.toInt()
        this.y = e.y.toInt()
        return true;
    }
}