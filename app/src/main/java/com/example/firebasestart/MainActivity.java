package com.example.firebasestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.firebasestart.adapters.UserAdapter;
import com.example.firebasestart.databinding.ActivityMainBinding;
import com.example.firebasestart.pojo.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseFirestore db;
    private List<User> users;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        users = new ArrayList<>();
        adapter = new UserAdapter();
        binding.recyclerUsers.setLayoutManager(new GridLayoutManager(this,1));
        binding.recyclerUsers.setAdapter(adapter);
        db = FirebaseFirestore.getInstance();
        db.collection("users").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
//                                User user = new User(snapshot.get("firstName").toString(), snapshot.get("lastName").toString(),
//                                        snapshot.get("gender").toString(), snapshot.get("middleName").toString());
//                                Log.d("TTT", "onComplete: " + snapshot.get("firstName").toString());
                                User user = snapshot.toObject(User.class);
                                users.add(user);
                            }
                            adapter.setUsers(users);
                        }
                    }
                });

    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AddData.class);
        startActivity(intent);
    }
}
