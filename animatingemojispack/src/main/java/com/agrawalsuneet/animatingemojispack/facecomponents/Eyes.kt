package com.agrawalsuneet.animatingemojispack.facecomponents

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.support.v8.renderscript.*
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.agrawalsuneet.animatingemojispack.R

class Eyes : View {

    var eyeWidth: Int = 200
    var eyeHeight: Int = 300


    private lateinit var eyeGradiantDrawable: GradientDrawable

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

    constructor(context: Context?, eyeWidth: Int, eyeHeight: Int) : super(context) {
        this.eyeWidth = eyeWidth
        this.eyeHeight = eyeHeight
        initView()
    }


    private fun initView() {

        //add the white overlay on top of background
        eyeGradiantDrawable = GradientDrawable()
        eyeGradiantDrawable.shape = GradientDrawable.OVAL
        eyeGradiantDrawable.gradientType = GradientDrawable.RADIAL_GRADIENT
        eyeGradiantDrawable.gradientRadius = eyeWidth.toFloat()
        val eyecolors = intArrayOf(resources.getColor(R.color.eye_black_3),
                resources.getColor(R.color.eye_black_2),
                resources.getColor(R.color.eye_black_1))
        eyeGradiantDrawable.colors = eyecolors

        paint = Paint()
        paint.color = Color.TRANSPARENT
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = false
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(eyeWidth, eyeHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val rect = RectF(0f, 0f, eyeWidth.toFloat(), eyeHeight.toFloat())

        canvas.drawOval(rect, paint)
        background = eyeGradiantDrawable
    }
}