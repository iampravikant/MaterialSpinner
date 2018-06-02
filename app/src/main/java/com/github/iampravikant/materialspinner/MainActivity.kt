package com.github.iampravikant.materialspinner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_occupation.setItems(resources.getStringArray(R.array.occupations))

        main_submit.setOnClickListener {
            Toast.makeText(
                    this@MainActivity,
                    main_occupation.getSelectedItem().toString(),
                    Toast.LENGTH_SHORT
            ).show()
        }
    }
}
