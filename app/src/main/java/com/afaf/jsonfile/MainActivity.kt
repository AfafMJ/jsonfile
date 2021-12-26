package com.afaf.jsonfile


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRV = findViewById<RecyclerView>(R.id.rvMain)

        val json = getJsonDataFromAsset(this, "data.json")
        val jsonArray = JSONArray(json)
        val images = arrayListOf<Image>()

        mainRV.adapter = RVAdapter(images)
        mainRV.layoutManager = LinearLayoutManager(this)

        for (i in 0 until jsonArray.length()) {
            val title = jsonArray.getJSONObject(i).getString("title")
            val url = jsonArray.getJSONObject(i).getString("url")
            images.add(Image(title, url))
        }


    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}