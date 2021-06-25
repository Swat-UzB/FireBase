package com.example.firebasestart.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasestart.databinding.UserItemBinding;
import com.example.firebasestart.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;

    public UserAdapter() {
        users = new ArrayList<>();
    }

    public void setUsers(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.userBinding.textViewFirstName.setText(user.getFirstName());
        holder.userBinding.textViewLastName.setText(user.getLastName());
        holder.userBinding.textViewGender.setText(user.getGender());
        holder.userBinding.textViewMiddleName.setText(user.getMiddleName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private UserItemBinding userBinding;

        public UserViewHolder(@NonNull UserItemBinding binding) {
            super(binding.getRoot());
            this.userBinding = binding;

        }
    }
}
