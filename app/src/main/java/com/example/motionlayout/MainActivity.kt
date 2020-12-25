package com.example.motionlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.motionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layout = findViewById<MotionLayout>(R.id.mmLayout)
        binding.lotties.pauseAnimation()
        binding.button.setOnClickListener {
            layout.transitionToEnd()
            binding.lotties.playAnimation()
            val background = object : Thread() {
                override fun run() {
                    try {
                        sleep(9000)
                    }catch (e : Exception){
                        e.printStackTrace()
                    } finally {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        startActivity(intent)
                    }
                }
            }
            background.start()
        }


    }
}