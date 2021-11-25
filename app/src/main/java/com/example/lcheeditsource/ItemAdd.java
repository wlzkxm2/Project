package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

public class ItemAdd extends Activity {

    private DataBaseDao mDatabaseDao;

    Intent Page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemadd);

        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();


    }
}
