package com.naitri.mad_practical5_21012011141

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseButton: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editTextText)
        val phoneNoButton: Button = findViewById(R.id.button2)
        val editText1: EditText = findViewById(R.id.editTextPhone)
        val callLogButton: Button = findViewById(R.id.button3)
        val galleryButton: Button = findViewById(R.id.button4)
        val cameraButton: Button = findViewById(R.id.button5)
        val alarmButton: Button = findViewById(R.id.button6)
        browseButton.setOnClickListener() {
            webUrl(editText.text.toString())
        }
        phoneNoButton.setOnClickListener() {
            phoneNo(editText1.text.toString())
        }
        callLogButton.setOnClickListener {
            opencallLog()
        }
        galleryButton.setOnClickListener() {
            makeGallery()
        }

        cameraButton.setOnClickListener() {
            makeCamera()
        }
        alarmButton.setOnClickListener() {
            makeAlarm()
        }
    }

    fun webUrl(str: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(str)).also {
            startActivity(it)
        }
    }

    fun phoneNo(phone_No: String) {
        Intent(Intent.ACTION_VIEW,
            Uri.parse("tel:$phone_No")).also {
            startActivity(it)
        }
    }
    fun opencallLog() {

        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also {
            startActivity(it)
        }
    }
    fun makeGallery() {

        Intent(Intent.ACTION_VIEW).setType("image/*").also {
            startActivity(it)
        }
    }
    fun makeCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
            startActivity(it)
        }
    }
    fun makeAlarm() {
        Intent(AlarmClock.ACTION_SET_ALARM).also {
            startActivity(it)
        }
    }
    }

