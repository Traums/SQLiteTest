package ru.gc986.sqlitetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ru.gc986.sqlitetest.db.DBHelper
import ru.gc986.sqlitetest.db.DBProductHelper

class MainActivity : AppCompatActivity() {

    val db: DBHelper = DBHelper(this)
    val dbPH = DBProductHelper(db)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPutProduct.setOnClickListener {
            dbPH.putProduct(etName.text.toString(), etAmount.text.toString().toInt())
            etName.text.clear()
            etAmount.text.clear()

            val count = "Count of products = ${dbPH.getCount()}"
            Toast.makeText(this, count, Toast.LENGTH_SHORT).show()

            val text: TextView = findViewById(R.id.textView4) as TextView
            var outText = ""
            val cou = ("${dbPH.getCount()}").toInt()
            var add = "${dbPH.getProduct(0)}"
            for (i in 0..cou - 1) {
                add = "${dbPH.getProduct(i.toInt())}"
                outText += add + "\n"

            }
            text.setText(outText)

        }
    }

}
