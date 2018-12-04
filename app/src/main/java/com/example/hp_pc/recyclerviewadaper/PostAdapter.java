package com.example.hp_pc.recyclerviewadaper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> posts;
    Context context;
    PostCallback callback;
   // EditCallback editCallback;


    public PostAdapter(Context context, List<Post> posts) {

        this.posts = posts;
        this.context=context;


        callback=(PostCallback) context;
       // editCallback=(EditCallback) context;

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

       viewHolder.onImage();
       viewHolder.onButtonMenuClick(post);
      // viewHolder.onChangeLike();
        viewHolder.onChangeButtonLike();



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



        private void onImage(){
            imagePost.setOnClickListener((v)->{
                context.startActivity(new Intent(context,MainActivity.class));
            });
        }

        private void onButtonMenuClick(Post post){
            btnMenu_items.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_items,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       // Toast.makeText(context,"Clicked" + item.getTitle(),Toast.LENGTH_SHORT).show();
                        switch(item.getItemId())
                        {
                            case R.id.remove:

                           //callback
                                callback.getPost(post,getAdapterPosition());


                                break;
                            case R.id.edit:
                                //editCallback.getEdit(post,getAdapterPosition());
                                break;
                            case R.id.delete:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            });
        }



       /* private void onChangeLike(){
            btnLike.setOnClickListener(v -> {

                btnLike.setImageResource(R.drawable.heart_read);
            });

        }*/


       private  void onChangeButtonLike(){
            btnLike.setOnClickListener(new View.OnClickListener() {
                boolean change =true;
                public void onClick(View v) {
                    if(change) {
                        btnLike.setImageResource(R.drawable.heart_read);
                        change = false;
                    }
                    else {
                        change=true;
                        btnLike.setImageResource(R.drawable.heart);
                    }
                }
            });
       }

    }
    public  interface PostCallback{
        void getPost(Post post,int position);

    }

   /* public  interface EditCallback{
        void getEdit(Post post,int position);

    }*/

}
