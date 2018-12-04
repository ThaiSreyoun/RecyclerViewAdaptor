package com.example.hp_pc.recyclerviewadaper;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity implements PostAdapter.PostCallback{
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList=new ArrayList<>();
    static public int REQUEST_CODE_POST=1;
    static public int REQUEST_CODE_EDIT=1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_menu:
                Intent intent =new Intent(this,PostNewActivity.class);
                startActivityForResult(intent,REQUEST_CODE_POST);
                return  true;
            case R.id.menu_items:
                Intent intents =new Intent(this,PostNewActivity.class);
                startActivityForResult(intents,REQUEST_CODE_POST);
                return  true;


            default: return false;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_POST && resultCode==RESULT_OK){
            //get data
            Post post =data.getParcelableExtra("data");
            //add new Item to recyclerView

            postList.add(0,post);
            adapter.notifyDataSetChanged();

            setRecyclerViewScroll(0);
            Log.e("data",post.toString());
        }
        if (requestCode==REQUEST_CODE_EDIT && resultCode==RESULT_OK){
            //get data
            Post post =data.getParcelableExtra("data");
            //add new Item to recyclerView

            postList.add(0,post);
            adapter.notifyDataSetChanged();

            setRecyclerViewScroll(0);
            Log.e("new data",post.toString());
        }


    }

    private void setRecyclerViewScroll(int position){
        recyclerView.smoothScrollToPosition(position);
    }

    @Override
    public void getPost(Post post, int position) {
        postList.remove(post);
        adapter.notifyItemRemoved(position);
    }


}
