package com.example.hp_pc.recyclerviewadaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new PostAdapter(this,postList);

        recyclerView.setAdapter(adapter);

        getData();
    }
    private void getData(){
        for(int i=0;i<50;i++){
            this.postList.add(new Post(
                 R.drawable.profile,
                    "___MOMO___",
                    "Phnom Penh",
                    "Text messaging, or texting, is the act of composing and sending electronic messages",
                    "1000 likes",
                     R.drawable.image_post
            ));
        }
    }
}
