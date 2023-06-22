package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    suspend fun printFollowers(){
        var instaCount=0
        var fbCount=0
        val myJob=CoroutineScope(Dispatchers.IO).launch {
            instaCount = getFbFollowers()
        }
        val myJob2=CoroutineScope(Dispatchers.IO).launch {
            fbCount = getInstaFollowers()
        }
        myJob.join()
        myJob2.join()
        Log.d("MYAG","My FB followers: $fbCount and My Insta followers: $instaCount")

    }

    suspend fun getFbFollowers(): Int{
        delay(3000)
        return 54
    }
    suspend fun getInstaFollowers(): Int{
        delay(3000)
        return 134
    }
}