package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout.DispatchChangeEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        CoroutineScope(Dispatchers.IO).launch {
            printFollower()
        }

    }

    suspend fun getInstaFollower(): Int{
        delay(3000)
        return 53
    }

    suspend fun getFbFollower(): Int{
        delay(3000)
        return 113
    }

    suspend fun printFollower(){

        var myDef=CoroutineScope(Dispatchers.IO).async {
            getInstaFollower()
        }

        var myDef2=CoroutineScope(Dispatchers.IO).async {
            getFbFollower()
        }
        Log.d("Count_TAG","${myDef.await()}  || ${myDef2.await()}")

    }
}