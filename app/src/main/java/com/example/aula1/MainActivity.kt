package com.example.aula1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aula1.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private var exchange: Double = 5.13
    private var convertedValue : Double = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pageTitle.text = "Convert BRL to USD"
        binding.actionButton.text = "Convert"
        binding.ConvertedValue.text = ""

        binding.valueBrl.setOnClickListener{
            binding.valueBrl.text.clear()

        }

        binding.actionButton.setOnClickListener {
            try {
                val brlValueText = binding.valueBrl.text.toString().toDouble()
//                val brlValue = brlValueText.toDouble()

                convertedValue = brlValueText / exchange
                val textToPrint: String =
                    String.format("%.2f", convertedValue)
                binding.ConvertedValue.text = "O valor é de: $textToPrint USD"
            } catch (e: NumberFormatException) {
                binding.ConvertedValue.text = "Erro: Insira um número válido."
            }
        }
    }
}