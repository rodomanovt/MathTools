package com.example.desmos

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.desmos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)



        binding.s.adapter = ArrayAdapter<String>(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.dimensions))

        binding.wv.settings.javaScriptEnabled = true
        val toast = Toast.makeText(this, "q", Toast.LENGTH_SHORT)

        binding.s.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val url: String =
                    if(position == 0) "https://wolframalpha.com/"//"https://www.desmos.com/calculator?lang=ru"
                    else "https://www.desmos.com/3d?lang=ru"

                toast.show()

                binding.wv.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url!!)
                        return true
                    }
                }
                binding.wv.loadUrl(url)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}
