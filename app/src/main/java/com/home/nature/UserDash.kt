package com.home.nature

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.home.nature.databinding.ActivityUserDashBinding

class UserDash : AppCompatActivity() {
    private lateinit var binding: ActivityUserDashBinding
    private lateinit var saveButton: Button
    private lateinit var TreatYourself: EditText
    private lateinit var Essentials: EditText
    private lateinit var Finance: EditText
    private lateinit var setDate: EditText
    private lateinit var BTNEDT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TreatYourself = findViewById(R.id.filled_edit_text1)
        Essentials = findViewById(R.id.filled_edit_text2)
        Finance = findViewById(R.id.filled_edit_text2)
        setDate = findViewById(R.id.date_totalsavings)
        BTNEDT = findViewById(R.id.todashedit)

        binding = ActivityUserDashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BTNEDT.setOnClickListener {
            val intent = Intent(this, UserDash::class.java)
            val message = TreatYourself.text.toString()
            intent.putExtra("message_key", message)
            startActivity(intent)
        }
    }

}