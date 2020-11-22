package gr.amoutzidis.smoothbar.controller.animation.factory

import android.os.Build
import android.widget.SeekBar
import gr.amoutzidis.smoothbar.controller.animation.impl.AboveNuggatAnimationController
import gr.amoutzidis.smoothbar.controller.animation.impl.UnderNuggatAnimationController
import gr.amoutzidis.smoothbar.controller.animation.prototype.AnimationController

object AnimationControllerFactory{

    fun createCompatibleController(seekBar: SeekBar): AnimationController {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            AboveNuggatAnimationController(seekBar)
        else
            UnderNuggatAnimationController(seekBar)
    }

}