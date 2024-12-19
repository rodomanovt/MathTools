package com.example.desmos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.desmos.databinding.FragmentWebViewBinding


private const val ARG_PARAM1 = "websiteIndex"


class WebViewFragment : Fragment() {
    private var websiteIndex: Int? = null

    private var binding: FragmentWebViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            websiteIndex = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_web_view, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.webview.settings.javaScriptEnabled = true

        val websiteIndex = arguments?.getInt("websiteIndex", 0)
        val url = Websites().getUrls()[websiteIndex!!]
        binding!!.webview.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }
        binding!!.webview.loadUrl(url)
    }

    companion object {
        @JvmStatic
        fun newInstance(websiteIndex: Int) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, websiteIndex)
                }
            }
    }
}