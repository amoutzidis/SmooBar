package gr.amoutzidis.smooth_bar.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import gr.amoutzidis.smoothbar.widgets.SmooBar

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SmooBar
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekbar)
        textView = findViewById(R.id.textView)
        seekBar.onChangedCallback {
            textView.text = it.toString()
        }
    }

    override fun onBackPressed() {
        seekBar.setProgress(76)

    }
}