package com.silvershort.simplegif.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import com.silvershort.simplegif.R
import com.silvershort.simplegif.util.PreferenceManager
import kotlinx.android.synthetic.main.option_dialog.*

class OptionDialog : DialogFragment() {

    private val TAG = "!!!OptionDialog!!!"
    private lateinit var dialogResult: OnDialogResult

    private lateinit var option_encoding_radiogroup: RadioGroup
    private lateinit var option_width_radiogroup: RadioGroup
    private lateinit var option_frame_radiogroup: RadioGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.option_dialog, container)
        dialog?.setCanceledOnTouchOutside(false)

        PreferenceManager.getPreferences(context!!)

        option_encoding_radiogroup = view.findViewById<RadioGroup>(R.id.option_encoding_radiogroup)
        option_width_radiogroup = view.findViewById<RadioGroup>(R.id.option_width_radiogroup)
        option_frame_radiogroup = view.findViewById<RadioGroup>(R.id.option_frame_radiogroup)

/*        val option_item_low_radiobutton = view.findViewById<RadioButton>(R.id.option_item_low_radiobutton)
        val option_item_high_radiobutton = view.findViewById<RadioButton>(R.id.option_item_high_radiobutton)
        val option_item_original_radiobutton = view.findViewById<RadioButton>(R.id.option_item_original_radiobutton)
        val option_item_320px_radiobutton = view.findViewById<RadioButton>(R.id.option_item_320px_radiobutton)
        val option_item_480px_radiobutton = view.findViewById<RadioButton>(R.id.option_item_480px_radiobutton)
        val option_item_10f_radiobutton = view.findViewById<RadioButton>(R.id.option_item_10f_radiobutton)
        val option_item_15f_radiobutton = view.findViewById<RadioButton>(R.id.option_item_15f_radiobutton)*/

        Log.d(TAG, "encoding : ${PreferenceManager.getEncoding()}")
        Log.d(TAG, "encoding : ${PreferenceManager.getWidth()}")
        Log.d(TAG, "encoding : ${PreferenceManager.getFrame()}")

        when(PreferenceManager.getEncoding()) {
            PreferenceManager.ENCODING_NORMAL -> {
                option_encoding_radiogroup.check(R.id.option_item_low_radiobutton)
            }
            PreferenceManager.ENCODING_PALETTE -> {
                option_encoding_radiogroup.check(R.id.option_item_high_radiobutton)
            }
        }
        when(PreferenceManager.getWidth()) {
            -1 -> {
                option_width_radiogroup.check(R.id.option_item_original_radiobutton)
            }
            320 -> {
                option_width_radiogroup.check(R.id.option_item_320px_radiobutton)
            }
            480 -> {
                option_width_radiogroup.check(R.id.option_item_480px_radiobutton)
            }
        }
        when(PreferenceManager.getFrame()) {
            10 -> {
                option_frame_radiogroup.check(R.id.option_item_10f_radiobutton)
            }
            15 -> {
                option_frame_radiogroup.check(R.id.option_item_15f_radiobutton)
            }
        }

        option_encoding_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener
        { group, checkedId ->
            when (checkedId) {
                R.id.option_item_low_radiobutton -> {
                    PreferenceManager.setEncoding(PreferenceManager.ENCODING_NORMAL)
                }
                R.id.option_item_high_radiobutton -> {
                    PreferenceManager.setEncoding(PreferenceManager.ENCODING_PALETTE)
                }
            }
        })
        option_width_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener
        { group, checkedId ->
            when (checkedId) {
                R.id.option_item_320px_radiobutton -> {
                    PreferenceManager.setWidth(320)
                }
                R.id.option_item_480px_radiobutton -> {
                    PreferenceManager.setWidth(480)
                }
                R.id.option_item_original_radiobutton -> {
                    PreferenceManager.setWidth(PreferenceManager.WIDTH_ORIGINAL)
                }
            }
        })
        option_frame_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener
        { group, checkedId ->
            when (checkedId) {
                R.id.option_item_10f_radiobutton -> {
                    PreferenceManager.setFrame(10)
                }
                R.id.option_item_15f_radiobutton -> {
                    PreferenceManager.setFrame(15)
                }
            }
        })

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

    fun setDialogResultInterface(dialogResult: OnDialogResult) {
        this.dialogResult = dialogResult
    }

    interface OnDialogResult {
        fun finish()
    }
}