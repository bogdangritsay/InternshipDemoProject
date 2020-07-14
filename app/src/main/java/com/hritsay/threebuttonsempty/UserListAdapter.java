package com.hritsay.threebuttonsempty;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hritsay.threebuttonsempty.databinding.RecyclerItemBinding;

import java.util.LinkedList;


public class UserListAdapter  extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private LayoutInflater mInflater;
    private final LinkedList<UserItem> mUserList;
    private int selectedPosition = -1;

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
     private RecyclerItemBinding recyclerItemBinding;

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            notifyItemChanged(selectedPosition);
            selectedPosition = getAdapterPosition();
            notifyItemChanged(selectedPosition);
        }

        public UserViewHolder(RecyclerItemBinding itemBinding) {
            super(itemBinding.getRoot());
             recyclerItemBinding =itemBinding;
            itemView.setOnClickListener(this);
        }

    }

    public UserListAdapter(Context context, LinkedList<UserItem> userList) {
        mInflater = LayoutInflater.from(context);
        this.mUserList = userList;
    }

    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerItemBinding recyclerItemBinding = RecyclerItemBinding.inflate(inflater, parent, false);
        return new UserViewHolder(recyclerItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserListAdapter.UserViewHolder holder, final int position) {
        holder.recyclerItemBinding.itemTitle.setText(mUserList.get(position).getTitle());
        holder.recyclerItemBinding.itemDescription.setText(mUserList.get(position).getDescription());
        holder.itemView.setBackgroundColor(selectedPosition == position && selectedPosition != -1 ? Color.GREEN : Color.TRANSPARENT);
    }


    @Override
    public int getItemCount() {
     return this.mUserList.size();
    }

}
