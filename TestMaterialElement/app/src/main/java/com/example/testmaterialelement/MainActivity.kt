package com.example.testmaterialelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var btnAlertDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        action()
    }

    private fun initialize(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
    }

    private fun action(){
        btnAlertDialog.setOnClickListener(View.OnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("MY CUSTOM ALERT")
                .setMessage("SUCCESSFUL TRANSACTION")
                .setNegativeButton("Decline"){dialog,which->
                    dialog.dismiss()
                }
                .setPositiveButton("OK"){dialog,which->
                    dialog.dismiss()
                }


                .show()


        })
    }
}