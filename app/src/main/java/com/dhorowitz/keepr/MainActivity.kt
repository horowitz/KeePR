package com.dhorowitz.keepr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dhorowitz.keepr.BuildConfig.KEEPR_CLIENT_ID

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "client id = $KEEPR_CLIENT_ID", Toast.LENGTH_LONG).show()
    }
}
