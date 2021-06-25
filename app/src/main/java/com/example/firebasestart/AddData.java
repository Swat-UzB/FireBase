package com.example.firebasestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasestart.databinding.ActivityAddDataBinding;
import com.example.firebasestart.pojo.User;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddData extends AppCompatActivity {
    private ActivityAddDataBinding binding;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityAddDataBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            db = FirebaseFirestore.getInstance();
    }

    public void setUser(View v) {
        String first = binding.enterFirstName.getText().toString();
        String last = binding.enterLastName.getText().toString();
        String gender = binding.spinnerGender.getSelectedItem().toString();
        String middle = binding.enterMiddleName.getText().toString();
        if (first.trim().length() > 0 && last.trim().length() > 0 && middle.trim().length() > 0) {
            User user = new User(first, last, gender, middle);
            db.collection("users").document().set(user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            clear();

        } else {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void clear() {
        binding.enterFirstName.setText("");
        binding.enterLastName.setText("");
        binding.enterMiddleName.setText("");
    }
}