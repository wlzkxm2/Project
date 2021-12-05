package com.example.lcheeditsource;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.room.Room;

import android.content.Intent;

import com.example.lcheeditsource.DataBase.UserInfo;

import android.view.View;

import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.util.List;

public class myprofile extends Activity {

    public DataBaseDao mDatabaseDao;       // Dao 객체 생성
    Button back, ps;
    //profilesBack, profilesSetting

    TextView email, phone, shop, message, UserName;
    // text_userEmailView, text_userMessageView,text_userShopView

    Intent Page;

    // 메인 엑티비티에서 불러오는 기본 유저 코드
    // 이를 통해 유저를 특정
    int UserCode;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();

        back = (Button) findViewById(R.id.btn_profilesBack);
        ps = (Button) findViewById(R.id.btn_profilesSetting);

        UserName = (TextView) findViewById(R.id.text_UserName);
        email = (TextView) findViewById(R.id.text_userEmailView);
        phone = (TextView) findViewById(R.id.text_userPhonecallView);
        shop = (TextView) findViewById(R.id.text_userShopView);
        message = (TextView) findViewById(R.id.text_userShopView);

        Page = getIntent();
        UserCode = Page.getExtras().getInt("UserCodeCall");

        Log.v("로그", "유저 코드 : " + UserCode);

        List<UserInfo> userData = mDatabaseDao.getUserAll();

        getUser(userData);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                finish();
            }
        });
        ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //내 정보 수정 페이지로 이동
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // email 페이지로 이동
            }

        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // PhonecallNumber 페이지로 이동
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add to shop 페이지로 이동
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show all comment 페이지로 이동
            }
        });


    }

    private void getUser(List<UserInfo> userData) {

        for (int i = 0; i < userData.size(); i++) {
            int DBUserCode = userData.get(i).getDefaultUserCode();
            if(DBUserCode == UserCode){
                UserName.setText(userData.get(i).getName());
                email.setText(userData.get(i).getEmail());
                phone.setText(userData.get(i).getPhoneNumber());
                shop.setText("즐겨찾는 상점");
                message.setText("메세지 확인");
            }
        }



    }


}

