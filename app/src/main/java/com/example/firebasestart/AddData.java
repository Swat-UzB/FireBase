package com.example.firebasestart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasestart.databinding.ActivityAddDataBinding;

public class AddData extends AppCompatActivity {
    private ActivityAddDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}