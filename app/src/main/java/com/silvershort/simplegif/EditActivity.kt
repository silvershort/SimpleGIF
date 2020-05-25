package com.silvershort.simplegif

import android.media.MediaScannerConnection
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.arthenica.mobileffmpeg.Config
import com.arthenica.mobileffmpeg.FFmpeg
import com.arthenica.mobileffmpeg.FFprobe
import com.arthenica.mobileffmpeg.LogCallback
import com.arthenica.mobileffmpeg.StatisticsCallback
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ClippingMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.silvershort.simplegif.dialog.CustomProgressDialog
import idv.luchafang.videotrimmer.VideoTrimmerView
import idv.luchafang.videotrimmer.tools.dpToPx
import kotlinx.android.synthetic.main.activity_edit.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class EditActivity : AppCompatActivity(), VideoTrimmerView.OnSelectedRangeChangedListener {

    private val TAG = "!!!EditActivity!!!"

    private val player: SimpleExoPlayer by lazy {
        SimpleExoPlayer.Builder(this@EditActivity).build().also {
            it.repeatMode = Player.REPEAT_MODE_ALL
            edit_playerview.player = it
        }
    }
    private val dataSource by lazy {
        DefaultDataSourceFactory(this@EditActivity,
            Util.getUserAgent(this@EditActivity, getString(R.string.app_name)))
    }
    private lateinit var mediaSource: MediaSource
    private lateinit var path: String

    private val rootFolder by lazy {
        File("${Environment.getExternalStorageDirectory().absolutePath}/${Environment.DIRECTORY_DCIM}/SimpleGIF")
    }

    private var duration: Long = 0
    private var sMillis: Long = 0
    private var eMillis: Long = 0

    override fun onResume() {
        super.onResume()
        player?.playWhenReady = true
    }

    override fun onPause() {
        player?.playWhenReady = false
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        setSupportActionBar(edit_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        path = intent.getStringExtra("path")
        Log.d(TAG, "path: $path")

        duration = FFprobe.getMediaInformation(path).duration

        Handler().postDelayed({
            edit_trimmerview
                .setVideo(File(path))
                .setMaxDuration(30_000)
                .setMinDuration(1_000)
                .setFrameCountInWindow(10)
                .setExtraDragSpace(dpToPx(2f))
                .setOnSelectedRangeChangedListener(this)
                .show()
        }, 100)

        edit_tv_complete.setOnClickListener {
            val folderPath = rootFolder.absolutePath
            val fileName = File(path).name.split(".")[0]
            val sdf = SimpleDateFormat("yyyyMMddHHmmss")
            val saveTime = sdf.format(Date(System.currentTimeMillis()))
            val savePath = "$folderPath/${fileName}_$saveTime.gif"

            val extension = File(path).name.split(".")[1]
            val cachePath = "${cacheDir.canonicalPath}/temp.$extension"

            val startTime = timeConverter(sMillis)
            val endTime = timeConverter(eMillis)

            Log.d(TAG, "savePath : $savePath")
            Log.d(TAG, "startTime : $startTime")
            Log.d(TAG, "endTime : $endTime")

            createFolder()

            val cmd = "-y -i '$path' -ss $startTime -t $endTime -vf scale=320:-1 -r 10 -pix_fmt rgb8 '$savePath'"
//            val trimCmd = "-y -i '$path' -ss $startTime -t $endTime -vcodec copy '$cachePath'"
//            val cmd = "-y -i '$cachePath' -filter_complex 'fps=10,scale=320:-1:flags=lanczos[x];[x]split[x1][x2];[x1]palettegen[p];[x2][p]paletteuse' '$savePath'"
//            val cmd = "-y -i '$path' -ss $startTime -t $endTime -filter_complex 'fps=10,scale=320:-1:flags=lanczos[x];[x]split[x1][x2];[x1]palettegen[p];[x2][p]paletteuse' '$savePath'"

//            Log.d(TAG, "cmd : $paletteCmd")
            Log.d(TAG, "cmd : $cmd")
            Thread(Runnable {
//                FFmpeg.execute(paletteCmd)
//                FFmpeg.execute(trimCmd)
                val rc = FFmpeg.execute(cmd)

                if (rc == Config.RETURN_CODE_SUCCESS) {
                    scanSaveFile(savePath)
                    finish()
                } else {

                }
            }).start()

            val proDialog = CustomProgressDialog(getString(R.string.progress_converting))
            proDialog.show(supportFragmentManager, "proDialog")
            proDialog.setDialogResultInterface(object : CustomProgressDialog.OnDialogResult {
                override fun finish() {
                    FFmpeg.cancel()
                    Toast.makeText(this@EditActivity, getString(R.string.progress_cancel), Toast.LENGTH_SHORT).show()
                }
            })

            Config.enableStatisticsCallback(StatisticsCallback {
                val progress = it.time / duration.toDouble()
                Log.d(TAG, String.format("frame: ${it.videoFrameNumber} time: ${it.time}"))
                Log.d(TAG, String.format("progress: $progress"))
                proDialog.setText(progress)
            })

            Config.enableLogCallback(LogCallback {
                Log.d(TAG, "FFmpeg : ${it.text}")
            })
        }
    }

    private fun createFolder() {
        if (!rootFolder.exists()) rootFolder.mkdir()
    }

    private fun scanSaveFile(path: String) {
        MediaScannerConnection.scanFile(applicationContext,
            arrayOf(path), null, object : MediaScannerConnection.OnScanCompletedListener {
                override fun onScanCompleted(path: String?, uri: Uri?) {
                }
            })
    }

    private fun dpToPx(dp: Float): Float {
        val density = resources.displayMetrics.density
        return dp * density
    }

    private fun timeConverter(rawLong: Long): String{
        Log.d(TAG, "rawLong : $rawLong")
        val sec = rawLong / 1000
        val mSec = rawLong % 1000
        return String.format("%02d:%02d:%02d.%02d", sec / 60 / 60, sec / 60 % 60, sec % 60, mSec)
    }

    private fun releaseVideo() {
        player.release()
    }

    private fun showDuration(startMillis: Long, endMillis: Long) {
        duration = endMillis - startMillis
        val doubleDuration = (endMillis - startMillis) / 1000.0
        edit_durationview.text = "$doubleDuration ${getString(R.string.common_selected)}"
    }

    private fun playVideo(path: String, startMillis: Long, endMillis: Long) {
        Log.d(TAG, "playvideo : $path")
        if (path.isNullOrEmpty()) return

        mediaSource = ProgressiveMediaSource.Factory(dataSource)
            .createMediaSource(Uri.parse(path))
        player.prepare(ClippingMediaSource(mediaSource, startMillis * 1000L, endMillis * 1000L))
        player.playWhenReady = true
    }

    override fun onSelectRangeStart() {
        player.playWhenReady = false
    }

    override fun onSelectRange(startMillis: Long, endMillis: Long) {
        showDuration(startMillis, endMillis)
    }

    override fun onSelectRangeEnd(startMillis: Long, endMillis: Long) {
        Log.d(TAG, "onSelectRangeEnd()")
        sMillis = startMillis
        eMillis = endMillis
        showDuration(startMillis, endMillis)
        playVideo(path, startMillis, endMillis)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            releaseVideo()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        releaseVideo()
        super.onBackPressed()
    }
}
