package gr.amoutzidis.smoothbar.controller.self.impl

import android.util.Log
import android.widget.SeekBar
import gr.amoutzidis.smoothbar.controller.self.prototype.AbstractSmooBarController
import gr.amoutzidis.smoothbar.widgets.SmooBarIntCallback
import kotlin.math.roundToInt

class SmooBarControllerImpl(
        private val callback: SmooBarIntCallback
): AbstractSmooBarController() {

    private var count = 3
    private var selected = 0
    private var progress = 0

    override fun setData(data: List<*>) {
        this.count = data.size
        refresh()
    }

    override fun setCount(count: Int) {
        this.count = count
        refresh()
    }

    fun getProgress() = selected

    fun setProgress(newProgress: Int){
        changeSelectedIfNeeded(newProgress)
        refresh()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        Log.e("{{", "onProgressChanged $progress fromUser $fromUser")
        if(fromUser.not()) return
        this.progress = progress
        changeSelectedIfNeeded(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.e("{{", "onStartTrackingTouch")
        this.startTrackingCallback?.invoke()
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.e("{{", "onStopTrackingTouch")
        updateProgressIfNeeded(
                (100 * selected) / (count-1)
        )

        this.stopTrackingCallback?.invoke()
    }

    private fun refresh(){
        //changeSelectedIfNeeded(progress)
        onStopTrackingTouch(null)
    }

    private fun changeSelectedIfNeeded(newProgress: Int){
        var tempSelected = percent(newProgress).roundToInt()
        if(selected != tempSelected) {
            Log.e("{{", "new Selection $tempSelected")
            selected = tempSelected

            this.onChangedCallback?.invoke(selected)
        }
    }

    private fun updateProgressIfNeeded(progress: Int){
        Log.e("{{", "updateProgressIfNeeded $progress")
        if( this.progress == progress )
            return

        this.progress = progress
        callback.invoke(progress)
    }

    private fun percent(progress: Int): Float{
        return (progress * (count - 1f)) / 100f
    }

}