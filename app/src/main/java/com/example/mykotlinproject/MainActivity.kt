package com.example.mykotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dta_nim: EditText
    private lateinit var dta_nama: EditText
    private lateinit var dta_nilai: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dta_nim = findViewById(R.id.nim)
        dta_nama = findViewById(R.id.nama)
        dta_nilai = findViewById(R.id.nilai)

        supportActionBar?.title = ("Input Data")
        proses.setOnClickListener {
            if (nim.text.isEmpty()) {
                toast("Nim harus diisi", Toast.LENGTH_LONG)
            } else if (nama.text.isEmpty()) {
                toast("Nama harus diisi", Toast.LENGTH_LONG)
            } else if (nilai.text.toString().toInt() > 100) {
                toast("Nilai harus diisi", Toast.LENGTH_LONG)
            } else if (nilai.text.isEmpty()) {
                toast("Nilai tidak boleh lebih dari 100", Toast.LENGTH_LONG)
            } else if (nama.text.isNotEmpty() || nim.text.isNotEmpty() || nilai.text.isNotEmpty()) {
                toast("Sukses Input Data", Toast.LENGTH_LONG)

                val intent = Intent(this, Main2Activity::class.java)
                intent.putExtra("data_nim", dta_nim.text.toString())
                intent.putExtra("data_nama", dta_nama.text.toString())
                intent.putExtra("data_nilai", dta_nilai.text.toString())
                intent.putExtra("data_grade", dta_nilai.text.toString())
                startActivity(intent)


            }
        }
    }
    private fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}
