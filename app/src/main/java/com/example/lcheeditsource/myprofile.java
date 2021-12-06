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

        // 유저에 대한 정보를 나타낼 TextView를 지정
        UserName = (TextView) findViewById(R.id.text_UserName);
        email = (TextView) findViewById(R.id.text_userEmailView);
        phone = (TextView) findViewById(R.id.text_userPhonecallView);
        shop = (TextView) findViewById(R.id.text_userShopView);
        message = (TextView) findViewById(R.id.text_userShopView);

        Page = getIntent();
        // MainActivity 에서 전달 받은 유저의 기본 고유 코드를 받아온다
        UserCode = Page.getExtras().getInt("UserCodeCall");

        // 유저 정보확인을 위한 디버그 코드
        Log.v("로그", "유저 코드 : " + UserCode);

        // 데이터베이스에서 유저의 모든 정보를 가져와 객체에 담는다
        List<UserInfo> userData = mDatabaseDao.getUserAll();

        // getUser클래스를 통해 전달받은 유저의 기본 고유 코드를 확인하여 그에 맞는 유저의 정보를 보여줌
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
            // DB내부에 유저 기본 고유 코드를 DBUserCode에 저장
            int DBUserCode = userData.get(i).getDefaultUserCode();

            // 만약 MainActivity로부터 전달받은 유저의 고유코드와 맞다면 해당 유저의 정보를 불러옴옴
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

