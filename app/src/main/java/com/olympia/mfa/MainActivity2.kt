package com.olympia.mfa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olympia.R
import com.olympia.databinding.MfaActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MfaActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}