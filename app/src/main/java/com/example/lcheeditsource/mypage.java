package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

public class mypage extends Activity {

    EditText myp;
    //information = inf, review = rev, scrap = scr, star = sta , brand = bra,
    // product = pro, event = event

    Button inf,rev,scr,sta,bra,pro,eve,eve2,eve3 ;
    ImageButton ima1;
    ImageView log;
    Intent Page;
    View.OnClickListener cl ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        myp =(EditText) findViewById(R.id.mypage);
        inf =(Button) findViewById(R.id.information);
        rev =(Button) findViewById(R.id.review);
        scr =(Button) findViewById(R.id.scrap);
        sta =(Button) findViewById(R.id.star);
        bra =(Button) findViewById(R.id.brand);
        pro =(Button) findViewById(R.id.product);
        eve =(Button) findViewById(R.id.event);
        eve2 =(Button) findViewById(R.id.event2);
        eve3 =(Button) findViewById(R.id.event3);
        ima1 =(ImageButton) findViewById(R.id.image1);
        log = (ImageView) findViewById(R.id.loginLogo6);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        };
        inf.setOnClickListener(cl);
        rev.setOnClickListener(cl);
        scr.setOnClickListener(cl);
        sta.setOnClickListener(cl);
        bra.setOnClickListener(cl);
        pro.setOnClickListener(cl);
        eve.setOnClickListener(cl);
        eve2.setOnClickListener(cl);
        eve3.setOnClickListener(cl);













    }
    }


