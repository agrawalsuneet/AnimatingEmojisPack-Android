package com.agrawalsuneet.animatingemojis

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v8.renderscript.*
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setupImages()

        //val rs = RenderScript.create(this)
    }

    /*private lateinit var mNormalImage: ImageView
    private lateinit var mBlurImage: ImageView
    private lateinit var mColorImage: ImageView*/

    /*private fun setupImages() {
        mNormalImage = findViewById(R.id.image_normal) as ImageView
        mBlurImage = findViewById(R.id.image_blurred) as ImageView
        mColorImage = findViewById(R.id.image_colored) as ImageView

        //Start with an image from our APK resources
        val inBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.smile)
        val outBitmap = inBitmap.copy(inBitmap.getConfig(), true)
        val grayBitmap = inBitmap.copy(inBitmap.getConfig(), true)

        //Create the context and I/O allocations
        val rs = RenderScript.create(this)
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

        //Make the image greyscale
        val scriptColor =
                ScriptIntrinsicColorMatrix.create(rs, Element.U8_4(rs));
        scriptColor.setGreyscale();
        scriptColor.forEach(input, output);
        output.copyTo(grayBitmap);

        //Show the results
        mNormalImage.setImageBitmap(inBitmap);
        mBlurImage.setImageBitmap(outBitmap);
        mColorImage.setImageBitmap(grayBitmap);

        //We don't need RenderScript anymore
        rs.destroy();

    }*/

}
