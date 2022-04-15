package kg.geektech.hm35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.hm35.databinding.ActivityShitBinding

class ActivityShit : AppCompatActivity() {
    private lateinit var binding: ActivityShitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityShitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveImage()
    }

    private fun saveImage() {
        val list = intent.getStringArrayListExtra(MainActivity.SHIT)
        binding.apply {
            recyclerViewTwo.adapter = list?.let { ShitAdapter(it) }
            ivExit.setOnClickListener{
                finish()
            }
        }
    }
}