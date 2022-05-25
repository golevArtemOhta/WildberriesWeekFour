package com.example.wildberriesweekfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment()
    }

    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, ChatsFragment())
            .commit()
    }
}