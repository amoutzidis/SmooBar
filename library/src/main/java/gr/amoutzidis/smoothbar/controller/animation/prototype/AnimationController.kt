package gr.amoutzidis.smoothbar.controller.animation.prototype

import android.widget.SeekBar

//class AnimationController(
//        private val durationInMillis: Long = 100L,
//        private val updateCallback: (Int)-> Unit): ValueAnimator.AnimatorUpdateListener{
//
//    private val animator = ValueAnimator.ofInt(0,0).apply {
//        interpolator = LinearInterpolator()
//        addUpdateListener(this@AnimationController)
//        this.duration = durationInMillis
//    }
//
//    fun fromTo(from: Int, to: Int){
//        Log.e("{{", "fromTo $from $to")
//        if(from == to)
//            return
//        animator.setIntValues(from, to)
//        animator.start()
//    }
//
//    override fun onAnimationUpdate(animation: ValueAnimator?) {
//        animation ?: return
//        updateCallback(animation.animatedValue as Int)
//    }
//}

abstract class AnimationController(protected val seekBar: SeekBar){

    abstract fun update(to: Int)

}