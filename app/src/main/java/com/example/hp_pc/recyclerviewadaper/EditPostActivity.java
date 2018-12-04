package com.example.hp_pc.recyclerviewadaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditPostActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText checkInEdit;
    EditText contentEdit;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        checkInEdit=findViewById(R.id.edit_checkIn);
        contentEdit=findViewById(R.id.edit_content);
        btnEdit=findViewById(R.id.btnEdit);

       btnEdit.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.btnEdit){
            Post post=new Post(
                    R.drawable.profile,
                    "___MOMO___",
                    checkInEdit.getText().toString(),
                    contentEdit.getText().toString(),
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
