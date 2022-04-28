package benhamida.jassem.ocsorange.ui.play_program

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import benhamida.jassem.ocsorange.Constants
import benhamida.jassem.ocsorange.R
import com.google.android.exoplayer2.util.Util
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_play_program.*

@AndroidEntryPoint
class PlayProgramActivity : AppCompatActivity() {

    private val viewModel: PlayProgramViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_program)
        setupUI()
        initExoPlayer()
    }

    private fun setupUI() {
        close_btn.setOnClickListener { finish() }
    }

    private fun initExoPlayer() {
        viewModel.initPlayer(applicationContext, Constants.STREAM_DASH_URL)
        program_player_view.player = viewModel.exoPlayer
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) enableImmersiveMode()
    }

    private fun enableImmersiveMode() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initExoPlayer()
            program_player_view?.let {
                it.onResume()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23 || viewModel.exoPlayer == null) {
            initExoPlayer()
            program_player_view?.let {
                it.onResume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            program_player_view?.let {
                it.onPause()
            }
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            program_player_view?.let {
                it.onPause()
            }
            releasePlayer()
        }
    }

    fun releasePlayer() {
        viewModel.releasePlayer()
        program_player_view.setPlayer(null)
        program_player_view.getAdViewGroup().removeAllViews()
    }
}