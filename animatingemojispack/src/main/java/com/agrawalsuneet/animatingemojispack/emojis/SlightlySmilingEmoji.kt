package com.agrawalsuneet.animatingemojispack.emojis

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.agrawalsuneet.animatingemojispack.R
import com.agrawalsuneet.animatingemojispack.facecomponents.WhiteBackground

open class SlightlySmilingEmoji : RelativeLayout {

    var emojiRadius: Int = 500

    private lateinit var whiteBackground: WhiteBackground

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
    }

    private fun initView() {
        addBackground()


        //add white overlay
        val whiteBGSize = (emojiRadius - (emojiRadius / 8))
        val margin = emojiRadius - whiteBGSize
        whiteBackground = WhiteBackground(context, whiteBGSize)

        val whitebgParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        whitebgParams.setMargins(margin, margin, margin, margin)
        this.addView(whiteBackground, whitebgParams)


        //background = resources.getDrawable(R.drawable.emojibackground)
    }

    private fun addWhiteOverlay() {

    }


    private fun addBackground() {

        //add basic background
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.OVAL
        gradientDrawable.gradientType = GradientDrawable.RADIAL_GRADIENT
        gradientDrawable.setGradientCenter(0.5f, 0.5f)
        gradientDrawable.gradientRadius = (2 * emojiRadius).toFloat()
        gradientDrawable.setStroke((emojiRadius / 50), resources.getColor(R.color.bg_endcolor))
        val colors = intArrayOf(resources.getColor(R.color.bg_startcolor), resources.getColor(R.color.bg_midcolor), resources.getColor(R.color.bg_endcolor))
        gradientDrawable.colors = colors
        background = gradientDrawable
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(2 * emojiRadius, 2 * emojiRadius)
    }

}