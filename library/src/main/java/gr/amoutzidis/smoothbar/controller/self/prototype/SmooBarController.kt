package gr.amoutzidis.smoothbar.controller.self.prototype

import android.widget.SeekBar
import gr.amoutzidis.smoothbar.widgets.SmooBarCallback
import gr.amoutzidis.smoothbar.widgets.SmooBarIntCallback

interface SmooBarController: SeekBar.OnSeekBarChangeListener{


    fun setData(data: List<*>)
    fun setCount(count: Int)

    fun onChangedCallback(callback: SmooBarIntCallback)
    fun stopTrackingCallback(callback: SmooBarCallback)
    fun startTrackingCallback(callback: SmooBarCallback)

}