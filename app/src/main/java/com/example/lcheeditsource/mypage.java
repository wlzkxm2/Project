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
    private DataBaseDao mDataBaseDao;

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
                //뒤로가기
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);

            }


        };

        inf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
        //내 정보 수정 페이지로 이동
            }
        });

        rev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //내 리뷰 페이지로 이동
            }
        });

        scr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //스크랩 페이지로 이동
            }
        });

        sta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //즐겨찾기 페이지로 이동
            }
        });

        bra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //브랜드 페이지로 이동
            }
        });

        pro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //제품 페이지로 이동
            }
        });

        eve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //이벤트 페이지로 이동
            }
        });

        eve2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //이벤트 신청내역 페이지로 이동
            }
        });

        eve3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //굿즈 이벤트 페이지로 이동
            }
        });




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


