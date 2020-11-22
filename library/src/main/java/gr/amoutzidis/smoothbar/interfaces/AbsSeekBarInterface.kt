package gr.amoutzidis.smoothbar.interfaces

import android.graphics.drawable.Drawable

interface AbsSeekBarInterface: ProgressBarInterface{

    fun getThumb(): Drawable?
    fun setThumb(drawable: Drawable?)

    fun getProgressDrawable(): Drawable?
    fun setProgressDrawable(drawable: Drawable?)

    fun setSplitTrack(splitTrack: Boolean)
    fun getSplitTrack(): Boolean


}