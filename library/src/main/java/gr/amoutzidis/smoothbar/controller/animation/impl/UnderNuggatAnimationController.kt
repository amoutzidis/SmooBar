package gr.amoutzidis.smoothbar.controller.animation.impl

import android.animation.ValueAnimator
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.SeekBar
import gr.amoutzidis.smoothbar.controller.animation.prototype.AnimationController

class UnderNuggatAnimationController(
        seekBar: SeekBar
): AnimationController(seekBar),
ValueAnimator.AnimatorUpdateListener{

    private val animator = ValueAnimator.ofInt(0,0).apply {
        interpolator = LinearInterpolator()
        addUpdateListener(this@UnderNuggatAnimationController)
        this.duration = 100L
    }

    override fun onAnimationUpdate(animation: ValueAnimator?) {
        animation ?: return
        val newProgress = animation.animatedValue as Int
        Log.e("{{", "onAnimationUpdate $newProgress")
        seekBar.progress = newProgress
    }

    private fun fromTo(from: Int, to: Int){
        Log.e("{{", "from $from to $to")
        if(from == to)
            return
        animator.setIntValues(from, to)
        animator.start()
    }

    override fun update(to: Int) {
        Log.e("{{", "Under Nuggat update to $to")
        fromTo(seekBar.progress, to)
    }

}
