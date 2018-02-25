package com.agrawalsuneet.animatingemojispack.facecomponents

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.support.v8.renderscript.*
import android.util.AttributeSet
import android.widget.ImageView
import com.agrawalsuneet.animatingemojispack.R

class WhiteBackground : ImageView {

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

        /*val inBitmap = drawableToBitmap(whitebgGradientDrawable)
        val outBitmap = inBitmap.copy(inBitmap.getConfig(), true)

        val rs = RenderScript.create(context)
        val input = Allocation.createFromBitmap(rs, inBitmap,
                Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT);
        val output = Allocation.createTyped(rs, input.getType());

        //Blur the image
        val script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(23f);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(outBitmap);

        //background = BitmapDrawable(resources, outBitmap)

        //setImageBitmap(outBitmap)
        rs.destroy()*/
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

    fun drawableToBitmap(drawable: Drawable): Bitmap {

        var bitmap: Bitmap

        if (drawable is BitmapDrawable) {
            if (drawable.bitmap != null) {
                return drawable.bitmap
            }
        }

        if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
}