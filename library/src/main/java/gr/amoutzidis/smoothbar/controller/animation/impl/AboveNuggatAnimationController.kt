package gr.amoutzidis.smoothbar.controller.animation.impl

import android.os.Build
import android.util.Log
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import gr.amoutzidis.smoothbar.controller.animation.prototype.AnimationController

class AboveNuggatAnimationController(seekBar: SeekBar): AnimationController(seekBar) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun update(to: Int) {
        Log.e("{{", "Above Nuggat update to $to")
        seekBar.setProgress(to, true)
    }
}