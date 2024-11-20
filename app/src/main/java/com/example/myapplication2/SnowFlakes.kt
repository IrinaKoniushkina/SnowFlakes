package com.example.myapplication2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.AsyncTask
import kotlin.random.Random
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.math.sin

data class Snowflake(var x: Float, var y: Float, val velocity: Float, val radius: Float, val color: Int)
lateinit var snow: Array<Snowflake>
val paint = Paint()
var h = 1000; var w = 1000

open class SnowFlakes(ctx: Context) : View(ctx) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.rgb(66,170,255))

        for (s in snow){
            paint.color = s.color
            canvas.drawCircle(s.x, s.y, s.radius, paint)
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        h = bottom - top; w = right - left
        val r = Random(0)
        snow = Array(100) { Snowflake(
            x = r.nextFloat() * w,
            y =  r.nextFloat() * h,
            velocity = 5 + 10 * r.nextFloat(),
            radius = 30 + 10 * r.nextFloat(),
            Color.rgb(200, 200 + r.nextInt(56), 255))
        }
    }

    fun moveSnowFlakes(){
        for (s in snow) {
            val horizontalSpeed = 10f
            val speedFactor = if (s.y > h / 1.3) {
                0.4f
            } else {
                1.0f
            }
            s.y += s.velocity * speedFactor
            s.x += horizontalSpeed

            if (s.y > h) {
                s.y -= h
            }
            if (s.x > w) {
                s.x = 0f
            }
        }
        invalidate()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        moveSnowFlakes()
        return true
    }
}
