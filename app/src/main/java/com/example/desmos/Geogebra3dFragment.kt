package com.example.desmos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.desmos.databinding.FragmentGeogebra3dBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Geogebra3dFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    var binding: FragmentGeogebra3dBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_geogebra3d, container, false)


        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.geogebra3d.settings.javaScriptEnabled = true

        val url = "https://geogebra.org/3d"
        binding!!.geogebra3d.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }
        binding!!.geogebra3d.loadUrl(url)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Geogebra3dFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}