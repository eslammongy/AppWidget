package gts.medical.appwidgetsample.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class Circle(context: Context?,  x: Float, y: Float, r: Int) : View(context) {

    private var x:Float? = 0F
    private var y:Float? = 0F
    private val r: Int
    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        mPaint.color = 0x000000
        this.x = x
        this.y = y
        this.r = r
    }

     override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(x!!, y!!, r.toFloat(), mPaint)
    }


}