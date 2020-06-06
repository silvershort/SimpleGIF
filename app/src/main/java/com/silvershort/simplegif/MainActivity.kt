package com.silvershort.simplegif

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.silvershort.simplegif.dialog.OptionDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "!!!MainActivity!!!"
    private val GALLERY_REQUEST_CODE = 1001
    private val EDIT_REQUEST_CODE = 1002
    private val STORAGE_PERMISSION = 3001

    private val requiredPermissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupPermissions()

        main_info_button.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        main_load_button.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK);
            intent.data = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            intent.type = "video/*"
            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        })

        main_option_button.setOnClickListener {
            val optionDialog = OptionDialog()
            optionDialog.show(supportFragmentManager, optionDialog.tag)
            optionDialog.setDialogResultInterface(object : OptionDialog.OnDialogResult {
                override fun finish() {

                }
            })
        }
    }

    private fun gifDraw(path: String) {
        Glide.with(this)
            .load(path)
            .into(main_output_iv)
    }

    private fun getRealPathFromURI(contentUri: Uri): String? {
        var columnIndex = 0
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor =
            contentResolver.query(contentUri, proj, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    private fun setupPermissions() {
        var rejectedPermissionList = ArrayList<String>()

        for (permission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                rejectedPermissionList.add(permission)
            }
        }

        if (rejectedPermissionList.isNotEmpty()) {
            val array = arrayOfNulls<String>(rejectedPermissionList.size)
            ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(array), STORAGE_PERMISSION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            GALLERY_REQUEST_CODE -> {
                if (data != null) {
                    val uri = data.data
                    val path = getRealPathFromURI(uri!!)
                    val intent = Intent(this, EditActivity::class.java)
                    intent.putExtra("path", path)
                    startActivityForResult(intent, EDIT_REQUEST_CODE)
                } else {
                }
            }
            EDIT_REQUEST_CODE -> {
                if (data != null) {
                    main_output_layout.visibility = View.VISIBLE
                    val path = data.getStringExtra("path")
                    Log.d(TAG, "EDIT_REQUEST_CODE : ${path}")
                    gifDraw(path)
                    main_output_savepath_tv.text = "${getString(R.string.main_output_savepath)} $path"
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when(requestCode) {
            STORAGE_PERMISSION -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "거부됨")
                    finish()
                } else {
                    Log.d(TAG, "허용됨")
                }
                return
            }
        }
    }
}
