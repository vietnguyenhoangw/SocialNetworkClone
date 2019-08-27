package com.example.SocialNetworkClone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UserSelectActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolBarTitle;
    ImageView closeImage;
    ImageView acceptImage;

    RadioGroup radioGroup_item, radioGroup_like, radioGroup_share, radioGroup_comment;

    int itemcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        CreateWidget();

        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close();
            }
        });

        acceptImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataChange();
            }
        });

    }

    /* mapping and toolbar */
    public void CreateWidget() {
        toolbar = findViewById(R.id.toolbar);

        toolBarTitle = toolbar.findViewById(R.id.toolbarTitle);
        toolBarTitle.setText("Change data");
        closeImage = toolbar.findViewById(R.id.imgStart);
        closeImage.setImageResource(R.drawable.ic_close_x);
        acceptImage = toolbar.findViewById(R.id.reset);
        acceptImage.setImageResource(R.drawable.ic_done_black_24dp);

        radioGroup_item = findViewById(R.id.radioGroup);
    }

    public void Close() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserSelectActivity.this);

        builder.setTitle("Close");
        builder.setIcon(R.drawable.ic_close_x);

        builder.setMessage("Do you want close Change data?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /* getdata and passing to feedFragment */
    public void getDataChange() {

        /* create bundle to put data and passing to feedfragment*/
        Intent data = new Intent();

        int idItem = radioGroup_item.getCheckedRadioButtonId();
        switch (idItem) {
            case R.id.radioButton_item1:
                itemcheck = 1;
                break;
            case  R.id.radioButton_item2:
                itemcheck = 2;
                break;
            case R.id.radioButton_item3:
                itemcheck = 3;
                break;
        }

        data.putExtra("id", itemcheck);
        setResult(RESULT_OK, data);
        finish();

        onBackPressed();
    }
}