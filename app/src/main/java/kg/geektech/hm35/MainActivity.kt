package kg.geektech.hm35

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.hm35.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ShitAdapter.OnClick {

    companion object{
        const val SHIT = "Shit"
    }

    private lateinit var binding: ActivityMainBinding
    private val image = mutableListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: ShitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        goToShit()
    }

    private fun goToShit() {
        binding.btnOk.setOnClickListener{
            val intent = Intent(this, ActivityShit::class.java)
            intent.putExtra(SHIT,list)
            startActivity(intent)
        }
    }

    private fun initView() {
        adapter = ShitAdapter(fullList())
        adapter.setOnClick(this)
        binding.recyclerView.adapter = adapter
    }

    private fun fullList(): MutableList<String> {
        for (i in 1..10){
            image.add("https://upload.wikimedia.org/wikipedia/ru/e/e6/Goat_Simulator_logo.png")
        }
return image
    }

    override fun onClocked(position: String) {
        list.add(position)
    }

    override fun onRemoved(position: String) {
        list.remove(position)
    }
}