package com.silvershort.simplegif.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.silvershort.simplegif.R
import com.white.progressview.HorizontalProgressView

class CustomProgressDialog() : DialogFragment() {

    private val TAG = "!!!CustomProgressDialog!!!"

    private lateinit var progress: HorizontalProgressView
    private lateinit var progress_tv_title: TextView
    private lateinit var progress_pro_view: HorizontalProgressView
    private lateinit var dialogResult: OnDialogResult
    private var title: String? = null

    constructor(title: String) : this() {
        this.title = title
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.custom_progress_dialog, container)
        dialog?.setCanceledOnTouchOutside(false)
        progress = view.findViewById(R.id.progress_pro_view)
        progress_tv_title = view.findViewById(R.id.progress_tv_title);
        progress_pro_view = view.findViewById(R.id.progress_pro_view);

        progress_pro_view.progress = 0

        if (!title.isNullOrEmpty()) {
            progress_tv_title.text = title
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(activity!!, theme) {
            override fun onBackPressed() {
                if (dialogResult != null) {
                    dialogResult.finish()
                }
                dismiss()
            }
        }
    }

    fun setText(percent: Double) {
        progress?.setProgress((percent * 100).toInt(), true)
    }

    fun setDialogResultInterface(dialogResult: OnDialogResult) {
        this.dialogResult = dialogResult
    }

    interface OnDialogResult {
        fun finish()
    }
}