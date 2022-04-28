package benhamida.jassem.ocsorange.ui.play_program

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import benhamida.jassem.ocsorange.framework.UseCases
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayProgramViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

   var exoPlayer: ExoPlayer?= null

    fun initPlayer(context: Context, videoUri: String) {
        exoPlayer = ExoPlayer.Builder(context).build()
        /*val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        val mediaSource: MediaSource = DashMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videoUri))
        exoPlayer?.setMediaSource(mediaSource)
        */
        val mediaItem: MediaItem = MediaItem.fromUri(Uri.parse(videoUri))
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.prepare()
        exoPlayer?.play()
    }

    fun playVideo() {
        exoPlayer?.play()
    }

    fun pauseVideo() {
        exoPlayer?.pause()
    }

    fun stopVideo() {
        exoPlayer?.stop()
    }

    fun releasePlayer() {
        exoPlayer?.let {
            it.release()
            exoPlayer = null
        }
    }
}