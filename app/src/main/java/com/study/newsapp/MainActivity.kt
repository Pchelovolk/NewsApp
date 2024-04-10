package com.study.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import com.study.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  var binding: ActivityMainBinding? = null
    private val mBinding get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_splash)

//        Handler(Looper.myLooper()!!).postDelayed({
//            setContentView(mBinding.root)
//            bottom_nav_menu.setupWithNavController(
//                navController = nav_host_fragment.findNavController()
//            )
//        }, 1000)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            bottom_nav_menu.setupWithNavController(
            navController = nav_host_fragment.findNavController()
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}