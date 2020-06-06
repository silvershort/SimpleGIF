package com.silvershort.simplegif.util

import android.content.Context
import android.content.SharedPreferences

object PreferenceManager {
    private val TAG = "!!!PreferenceManager!!!"
    private lateinit var prefer: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    const val ENCODING_NORMAL = 0
    const val ENCODING_PALETTE = 1

    const val WIDTH_ORIGINAL = -1

    fun getPreferences(context: Context) {
        prefer = context.getSharedPreferences("option", Context.MODE_PRIVATE)
        editor = prefer.edit()
    }

    fun setWidth(width: Int) {
        editor?.putInt("width", width)
        editor?.commit()
    }

    fun getWidth() = prefer?.getInt("width", 320)

    fun setFrame(frame: Int) {
        editor?.putInt("frame", frame)
        editor?.commit()
    }

    fun getFrame() = prefer?.getInt("frame", 10)

    fun setEncoding(encoding: Int) {
        editor?.putInt("encoding", encoding)
        editor?.commit()
    }

    fun getEncoding() = prefer?.getInt("encoding", ENCODING_PALETTE)

    fun resetDefault() {
        editor?.putInt("width", 320)
        editor?.putInt("frame", 10)
        editor?.putInt("encoding", ENCODING_PALETTE)
        editor.commit()
    }







}