package com.example.desmos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.desmos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        binding.s.adapter = ArrayAdapter<String>(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.dimensions))


        binding.s.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when(position){
                    0->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout, Desmos2dFragment()).commit()
                    }
                    1->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout, Desmos3dFragment()).commit()
                    }
                    2->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout, WolframFragment()).commit()
                    }
                    3->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout, Geogebra3dFragment()).commit()
                    }
                    else->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout, Desmos2dFragment()).commit()
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}
