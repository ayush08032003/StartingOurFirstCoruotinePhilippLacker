package com.ayushwalker.startingourfirstcoruotine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
//            delay(3000L)
            val networkCallAnswer = doNetworkCall()
            Log.d(TAG,"Coroutines says hello from thread ${Thread.currentThread().name}")
        }
        Log.d(TAG,"Hello from thread ${Thread.currentThread().name}")


    }

    suspend fun doNetworkCall() : String{
        delay(3000L)
        return "This is the Answer.!"
    }

}

/*
STEPS/NOTES: -
1. First start by adding:
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

    these two in the gradle(:app) file
2. Add GlobalScope.launch as this will launch the coroutines in the mainActivity,
    delay() do same stuff as sleep(), but unlike sleep(), it doesn't block the whole thread..!
    A suspend function can only be run either inside a coroutine or either another suspend function.
 */