package com.dandy.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    var btnSms:Button ?=null
    var btnStk:Button ?=null
    var btnEmail:Button ?=null
    var btnShare:Button ?=null
    var btnCall:Button ?=null
    var btnCamera:Button ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        btnSms=findViewById(R.id.btnSms)
        btnStk=findViewById(R.id.btnStk)
        btnEmail=findViewById(R.id.btnEmail)
        btnShare=findViewById(R.id.btnShare)
        btnCall=findViewById(R.id.btnCall)
        btnCamera=findViewById(R.id.btnCam)

        btnSms!!.setOnClickListener {
            val uri= Uri.parse("smsto:0773636468")
            val intent= Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hi,..")
            startActivity(intent)
        }

        btnStk!!.setOnClickListener {
            val simTkLaunch= applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simTkLaunch?.let { startActivity(it)}
        }

        btnEmail!!.setOnClickListener {
            val emailInt= Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "n.adrianm283@gmail.com", null))
            emailInt.putExtra(Intent.EXTRA_SUBJECT, "UPDATE")
            emailInt.putExtra(Intent.EXTRA_TEXT, "Hello, small update here regarding...")
            startActivity(Intent.createChooser(emailInt, "Send email..."))
        }

        btnShare!!.setOnClickListener {
            val shareInt= Intent(Intent.ACTION_SEND)
            shareInt.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareInt.type = "text/plain"
            shareInt.putExtra(Intent.EXTRA_TEXT, "Hi, download this app and tell me what you think!")
            startActivity(shareInt)
        }

        btnCall!!.setOnClickListener {
            val callInt= Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0729834717"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(callInt)
            }
        }

        btnCamera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
    }
}