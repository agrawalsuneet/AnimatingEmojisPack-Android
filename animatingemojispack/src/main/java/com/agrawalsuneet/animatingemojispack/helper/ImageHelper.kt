package com.agrawalsuneet.animatingemojispack.helper

import android.graphics.Bitmap
import android.support.v8.renderscript.Allocation
import android.support.v8.renderscript.Element
import android.support.v8.renderscript.RenderScript
import android.support.v8.renderscript.ScriptIntrinsicBlur

class ImageHelper {

    companion object {
        fun blurBitmapWithRenderscript(rs: RenderScript, bitmap: Bitmap) {
            //this will blur the bitmapOriginal with a radius of 25 and save it in bitmapOriginal
            //use this constructor for best performance, because it uses USAGE_SHARED mode which reuses memory
            val input = Allocation.createFromBitmap(rs, bitmap)
            val output = Allocation.createTyped(rs, input.type)
            val script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
            // must be >0 and <= 25
            script.setRadius(25f)
            script.setInput(input)
            script.forEach(output)
            output.copyTo(bitmap)
        }
    }
}