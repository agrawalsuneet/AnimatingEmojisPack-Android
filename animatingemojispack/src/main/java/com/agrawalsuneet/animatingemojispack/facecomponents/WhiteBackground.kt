package com.agrawalsuneet.animatingemojispack.facecomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import com.agrawalsuneet.animatingemojispack.R

class WhiteBackground : View {

    var circleRadius: Int = 300
    private lateinit var whitebgGradientDrawable: GradientDrawable

    private lateinit var paint: Paint

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
    }

    constructor(context: Context?, circleRadius: Int) : super(context) {
        this.circleRadius = circleRadius
        initView()
    }


    private fun initView() {

        //add the white overlay on top of background
        whitebgGradientDrawable = GradientDrawable()
        whitebgGradientDrawable.shape = GradientDrawable.OVAL
        whitebgGradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT
        val whitebgColors = intArrayOf(resources.getColor(R.color.bg_white_1),
                resources.getColor(R.color.bg_white_2),
                resources.getColor(R.color.bg_white_3),
                resources.getColor(R.color.bg_white_4),
                resources.getColor(R.color.bg_white_5),
                resources.getColor(R.color.bg_white_6),
                resources.getColor(R.color.bg_white_7),
                resources.getColor(R.color.bg_white_8))
        whitebgGradientDrawable.colors = whitebgColors

        paint = Paint()
        paint.color = Color.TRANSPARENT
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = false
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(2 * circleRadius, 2 * circleRadius)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(circleRadius.toFloat(), circleRadius.toFloat(), circleRadius.toFloat(), paint)
        background = whitebgGradientDrawable
    }
}