package com.silvershort.simplegif

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ClippingMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import idv.luchafang.videotrimmer.VideoTrimmerView
import idv.luchafang.videotrimmer.tools.dpToPx
import kotlinx.android.synthetic.main.activity_edit.*
import java.io.File

class EditActivity : AppCompatActivity(), VideoTrimmerView.OnSelectedRangeChangedListener {

    private val TAG = "!!!EditActivity!!!"

    private val player: SimpleExoPlayer by lazy {
        SimpleExoPlayer.Builder(this@EditActivity).build()
    }
    private val dataSource by lazy {
        DefaultDataSourceFactory(this@EditActivity,
            Util.getUserAgent(this@EditActivity, getString(R.string.app_name)))
    }
    private val mediaSource: MediaSource by lazy {
        ProgressiveMediaSource.Factory(dataSource)
            .createMediaSource(Uri.parse(path))
    }
    private val path: String by lazy {
        intent.getStringExtra("path")
    }
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

        Handler().postDelayed({
            edit_trimmerview
                .setVideo(File(path))
                .setMaxDuration(30_000)
                .setMinDuration(1_000)
                .setFrameCountInWindow(10)
                .setExtraDragSpace(dpToPx(2f))
                .setOnSelectedRangeChangedListener(this)
        }, 100)

        edit_tv_complete.setOnClickListener({

        })
    }

    private fun dpToPx(dp: Float): Float {
        val density = resources.displayMetrics.density
        return dp * density
    }

    private fun timeConverter(rawLong: Long): String{
        val sec = rawLong % 1000
        val mSec = rawLong / 1000
        return String.format("%02d:%02d:%02d.%d", sec / 60 / 60, sec / 60 % 60, sec % 60, mSec)
    }

    private fun releaseVideo() {
        player.release()
    }

    private fun showDuration(startMillis: Long, endMillis: Long) {
        val duration = (endMillis - startMillis) / 1000.0
        edit_durationview.text = "$duration ${R.string.common_selected}"
    }

    private fun playVideo(path: String, startMillis: Long, endMillis: Long) {
        if (path.isNullOrEmpty()) return
        player.playWhenReady = true
        ClippingMediaSource(mediaSource, startMillis * 1000L, endMillis * 1000L)
            .let { player.prepare(it) }
    }

    override fun onSelectRangeStart() {
        player.playWhenReady = false
    }

    override fun onSelectRange(startMillis: Long, endMillis: Long) {
        showDuration(startMillis, endMillis)
    }

    override fun onSelectRangeEnd(startMillis: Long, endMillis: Long) {
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
