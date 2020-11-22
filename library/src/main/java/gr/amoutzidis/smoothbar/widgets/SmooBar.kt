package gr.amoutzidis.smoothbar.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.widget.AbsSeekBar
import android.widget.FrameLayout
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import gr.amoutzidis.smoothbar.R
import gr.amoutzidis.smoothbar.controller.animation.factory.AnimationControllerFactory
import gr.amoutzidis.smoothbar.controller.animation.prototype.AnimationController
import gr.amoutzidis.smoothbar.controller.self.prototype.SmooBarController
import gr.amoutzidis.smoothbar.controller.self.impl.SmooBarControllerImpl
import gr.amoutzidis.smoothbar.interfaces.AbsSeekBarInterface

typealias SmooBarIntCallback = (Int)-> Unit
typealias SmooBarCallback = ()-> Unit

class SmooBar: FrameLayout, SmooBarController, AbsSeekBarInterface {

    constructor(context: Context) : super(context) { initialize(null) }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { initialize(attrs) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) { initialize(attrs) }

    private lateinit var seekBar: SeekBar
    private lateinit var animatorController: AnimationController
    private val dataController = SmooBarControllerImpl {
        animatorController.update(it)
    }


    private fun initialize(attrs: AttributeSet?){
        seekBar = SeekBar(context, attrs)
        seekBar.setOnSeekBarChangeListener(this)
        seekBar.max = 100
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.min = 0
        }

        addView(seekBar)
        animatorController = AnimationControllerFactory.createCompatibleController(seekBar)

        exportAttributes(attrs)
    }

    private fun exportAttributes(attrs: AttributeSet?){
        attrs ?: return

        seekBar.splitTrack

        val attributes =
                context.obtainStyledAttributes(attrs, R.styleable.SmooBar)
        val position = attributes.getInteger(R.styleable.SmooBar_android_progress,0)

        setProgress(position)
        attributes.recycle()
    }

    override fun setData(data: List<*>) {
        dataController.setData(data)
    }

    override fun setCount(count: Int) {
        dataController.setCount(count)
    }

    override fun onChangedCallback(callback: SmooBarIntCallback) {
       dataController.onChangedCallback(callback)
    }

    override fun stopTrackingCallback(callback: SmooBarCallback) {
        dataController.stopTrackingCallback(callback)
    }

    override fun startTrackingCallback(callback: SmooBarCallback) {
        dataController.startTrackingCallback(callback)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        dataController.onProgressChanged(seekBar, progress, fromUser)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        dataController.onStartTrackingTouch(seekBar)
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        dataController.onStopTrackingTouch(seekBar)
    }

    override fun getThumb() = seekBar.thumb

    override fun setThumb(drawable: Drawable?) { seekBar.thumb = drawable }

    override fun getProgressDrawable() = seekBar.progressDrawable

    override fun setProgressDrawable(drawable: Drawable?) { seekBar.progressDrawable = drawable }

    override fun setSplitTrack(splitTrack: Boolean) { seekBar.splitTrack = splitTrack }

    override fun getSplitTrack() = seekBar.splitTrack

    override fun getProgress() = dataController.getProgress()

    override fun setProgress(progress: Int) { dataController.setProgress(progress) }
}

