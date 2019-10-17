package com.example.conductorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.conductorkotlin.controllers.MainController
import com.example.conductorkotlin.controllers.SecondController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // todo 1 attach router to the activity
    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // todo 1.1 attach router to the activity
        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        // todo 2 check for root controller and set it to the router
        if (!router.hasRootController()){
            router.setRoot(RouterTransaction.with(MainController()))
        }
        // todo 3 navigating to an other controller
        router.pushController(RouterTransaction.with(SecondController()))

    }
}