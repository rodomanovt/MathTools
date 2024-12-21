package com.example.desmos

class Websites {

    private val urlMap: Map<String, String> = mapOf(
        "Desmos 2D" to "https://desmos.com/calculator?lang=ru",
        "Desmos 3D" to "https://desmos.com/3d?lang=ru",
        "WolframAlpha" to "https://wolframalpha.com",
        "Geogebra 3D" to "https://geogebra.org/3d"
    )

    fun getNames(): ArrayList<String>{
        return urlMap.keys.toList() as ArrayList<String>
    }

    fun getUrls(): List<String>{
        return urlMap.values.toList() as ArrayList<String>
    }
}