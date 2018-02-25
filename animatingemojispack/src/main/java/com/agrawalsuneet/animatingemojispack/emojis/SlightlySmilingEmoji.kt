package com.agrawalsuneet.animatingemojispack.emojis

import android.content.Context
import android.graphics.*
import android.graphics.drawable.GradientDrawable
import android.support.v8.renderscript.*
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.agrawalsuneet.animatingemojispack.R
import com.agrawalsuneet.animatingemojispack.facecomponents.Eyes
import com.agrawalsuneet.animatingemojispack.facecomponents.WhiteBackground


open class SlightlySmilingEmoji : RelativeLayout {

    var emojiRadius: Int = 400
    var eyeBlinkAnimDuration: Int = 2000

    private lateinit var whiteBackground: WhiteBackground
    private lateinit var leftEye: Eyes
    private lateinit var rigthEye: Eyes

    private var eyeWidth: Int = 0
    private var eyeHeight: Int = 0


    private lateinit var renderScript: RenderScript

    constructor(context: Context) : super(context) {
        initView()
        //blinkLeftEye()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
        //blinkLeftEye()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
        //blinkLeftEye()
    }

    private fun initView() {
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


        //add white overlay
        val whiteBGSize = (emojiRadius - (emojiRadius / 8))
        val margin = emojiRadius - whiteBGSize
        whiteBackground = WhiteBackground(context, whiteBGSize)
        val whitebgParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        whitebgParams.setMargins(margin, margin, margin, margin)
        this.addView(whiteBackground, whitebgParams)


        //Eyes
        eyeWidth = (emojiRadius * 0.35).toInt()
        eyeHeight = (emojiRadius * 0.5).toInt()
        val marginFromCenter = (emojiRadius * 0.2f).toInt()
        val marginFromEdges = (emojiRadius - eyeWidth - marginFromCenter)

        //LinearLayout for eyes
        val eyesLinearLayout = LinearLayout(context)
        val llparams = LinearLayout.LayoutParams(2 * (eyeWidth + marginFromCenter), eyeHeight)
        llparams.topMargin = (emojiRadius * 0.4f).toInt()
        llparams.leftMargin = marginFromEdges
        llparams.rightMargin = marginFromEdges
        eyesLinearLayout.orientation = LinearLayout.HORIZONTAL

        //add left eye
        leftEye = Eyes(context, eyeWidth, eyeHeight)
        val leftEyeParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        leftEyeParams.rightMargin = marginFromCenter
        eyesLinearLayout.addView(leftEye, leftEyeParams)

        //add right eye
        rigthEye = Eyes(context, eyeWidth, eyeHeight)
        val rightEyeParam = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        rightEyeParam.leftMargin = marginFromCenter
        eyesLinearLayout.addView(rigthEye, rightEyeParam)

        this.addView(eyesLinearLayout, llparams)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(2 * emojiRadius, 2 * emojiRadius)
    }

    private fun blinkLeftEye() {
        val scaleAnim = ScaleAnimation(1.0f, 1.0f, 1.0f, 0.1f, (eyeHeight * 0.6).toFloat(), (eyeWidth * 0.5).toFloat())
        scaleAnim.duration = eyeBlinkAnimDuration.toLong()
        scaleAnim.interpolator = AccelerateInterpolator()
        scaleAnim.repeatMode = Animation.REVERSE
        leftEye.startAnimation(scaleAnim)
    }

}