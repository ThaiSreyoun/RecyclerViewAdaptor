package com.example.hp_pc.recyclerviewadaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> posts;
    Context context;
    public PostAdapter(Context context, List<Post> posts) {

        this.posts = posts;
        this.context=context;
    }

    public void setPosts(List<Post> posts) {
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(
                R.layout.post_items_layout,viewGroup,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       Post post= posts.get(i);
       viewHolder.imageProfile.setImageResource(post.getUserProfile());
       viewHolder.imagePost.setImageResource(post.getImagePost());
       viewHolder.userName.setText(post.getUserName());
       viewHolder.detail.setText(post.detail);
       viewHolder.checkIn.setText(post.checkIn);

    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageProfile,imagePost,btnComment,btnMenu_items,btnShare,btnSave,btnLike;
        TextView userName,detail,checkIn;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageProfile = itemView.findViewById(R.id.imageProfile);
            imagePost = itemView.findViewById(R.id.imagePost);
            btnComment = itemView.findViewById(R.id.comment);
            btnMenu_items = itemView.findViewById(R.id.menu_items);
            btnLike = itemView.findViewById(R.id.like);
            btnShare = itemView.findViewById(R.id.share);
            btnSave = itemView.findViewById(R.id.save);

            userName = itemView.findViewById(R.id.userName);
            detail = itemView.findViewById(R.id.detail);
            checkIn = itemView.findViewById(R.id.checkIn);
        }
    }

}
