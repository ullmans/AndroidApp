import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class joystick : View() {

    private var x = 0.0
    private var y = 0.0

    init {
        this.x = ((super.getTop() + super.getBottom())/2).toDouble()
        this.y = ((super.getLeft() + super.getRight())/2).toDouble()

    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL
        canvas.drawCircle(
            ((super.getTop() + super.getBottom())/2).toFloat(),
            ((super.getLeft() + super.getRight())/2).toFloat(),
            ((2/3)*super.getHeight()).toFloat(),
            paint
            )
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawCircle(
            this.x.toFloat(),
            this.y.toFloat(),
            ((1/2)*super.getHeight()).toFloat(),
            paint
        )
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        this.x = e.x.toDouble()
        this.y = e.y.toDouble()
        return true;
    }
}