package com.github.bassaer.nestarrayapp

import android.os.Bundle
import android.support.annotation.StyleableRes
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMenu()
    }

    private fun loadMenu() {
        val tag = "Sample"
        val menus = resources.obtainTypedArray(R.array.menu)

        @StyleableRes val nameIndex = 0
        @StyleableRes val arrayIndex = 1

        for (i in 0 until menus.length()) {
            val menuId = menus.getResourceId(i, -1)
            if (menuId < 0) {
                break
            }
            val menu = resources.obtainTypedArray(menuId)

            val arrayId = menu.getResourceId(arrayIndex, -1)
            if (arrayId < 0) {
                menu.recycle()
                break
            }

            val array = resources.obtainTypedArray(arrayId)

            Log.d(tag, menu.getString(nameIndex))
            for (j in 0 until array.length()) {
                Log.d(tag, " └── " + array.getString(j))
            }
            menu.recycle()
            array.recycle()
        }

        menus.recycle()
    }
}
