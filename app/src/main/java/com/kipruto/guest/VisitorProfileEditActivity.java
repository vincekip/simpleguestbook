package com.kipruto.guest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class VisitorProfileEditActivity extends AppCompatActivity {
    private static final int GET_FROM_GALLERY = 0;
    ImageView profilepicset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_profile_edit);

        profilepicset = findViewById(R.id.profielpic);
        profilepicset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilepicupload();
            }
        });
    }


    private void profilepicupload(){
                Intent intenter= new Intent();
                intenter.setType("image/*");
                intenter.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intenter, "Select Profile Picture"), GET_FROM_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK)
        {
            Uri imageUri = data.getData();
            profilepicset.setImageURI(imageUri);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case  R.id.exit:
                startActivity(new Intent(VisitorProfileEditActivity.this, VisitorProfileActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
        }

        return false;
    }
}