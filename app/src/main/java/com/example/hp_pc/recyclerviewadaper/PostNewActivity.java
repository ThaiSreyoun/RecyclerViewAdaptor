package com.example.hp_pc.recyclerviewadaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostNewActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textPost;
    Button btnPostNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new);
        textPost=findViewById(R.id.textPostNew);
        btnPostNew=findViewById(R.id.btnPostNew);


        btnPostNew.setOnClickListener(this);


    }

    public void onClick(View v){
        if(v.getId()==R.id.btnPostNew){
            Post post=new Post(
                    R.drawable.profile,
                    "___MOMO___",
                    "Phnom Penh",
                    textPost.getText().toString(),
                    "0",
                    R.drawable.image_post);

            Intent intent =new Intent();
            Bundle bundle =new Bundle();
            bundle.putParcelable("data",post);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
