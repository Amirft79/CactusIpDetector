package ir.cactus.app.cactusipdetector.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import ir.cactus.app.cactusipdetector.databinding.ActivitySplashScreenBinding
import ir.cactus.app.cactusipdetector.utils.NetworkHelper
import ir.cactus.app.cactusipdetector.utils.ShowSnack
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var  binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            if (NetworkHelper.isNetworkConnected(this@SplashScreenActivity)){
                startApp()
            }else{
                ShowSnack(binding.root,"Check Your Internet Connection",5000)
                binding.btnCheckInternet.visibility= View.VISIBLE
                binding.btnCheckInternet.setOnClickListener {
                    if (NetworkHelper.isNetworkConnected(this@SplashScreenActivity)){
                        startApp()
                    }else{
                        ShowSnack(binding.root,"Check Your Internet Connection",5000)
                    }
                }
            }

        }

    }





    private fun startApp() {
        binding.ivCactusIntro.animate().alpha(1f).setDuration(4000).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
    }

    }
}