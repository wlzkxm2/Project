package com.example.lcheeditsource;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.util.List;

public class customer_service extends Activity {
    private DataBaseDao mDataBaseDao;

    TextView CustomerServiceText, TextboxView, TextView1, TextView2, TextView3, TextView4;
    ImageView loginlogo5;
    ImageButton imageButton;
    Button button, button2, button3, button4, button5;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_service);

        CustomerServiceText = (TextView) findViewById(R.id.text_sentence);
//        TextboxView = (TextView) findViewById(R.id.TextboxView);
//        TextView1 = (TextView) findViewById(R.id.TextView1);
//        TextView2 = (TextView) findViewById(R.id.TextView2);
//        TextView3 = (TextView) findViewById(R.id.TextView3);
//        TextView4 = (TextView) findViewById(R.id.TextView4);
//        loginlogo5 = (ImageView) findViewById(R.id.loginLogo5);
//        imageButton = (ImageButton) findViewById(R.id.imageButton);
//        button = (Button) findViewById(R.id.button);
//        button2 = (Button) findViewById(R.id.button2);
//        button3 = (Button) findViewById(R.id.button3);
//        button4 = (Button) findViewById(R.id.button4);
//        button5 = (Button) findViewById(R.id.button5);
//
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //????????????
//                Page = new Intent(getApplicationContext(), Register.class);
//                startActivity(Page);
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //1:1?????? ???????????? ??????
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //QnA ???????????? ??????
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //???????????? ???????????? ??????
//            }
//        });
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //LCHE ?????? ???????????? ??????
//            }
//        });
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //???????????? ???????????? ??????
//            }
//        });
    }
}
