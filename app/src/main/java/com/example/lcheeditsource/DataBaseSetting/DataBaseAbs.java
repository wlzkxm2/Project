package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBase.UserInfo;

/*
 *
 *   수정 정보 알려줄것
 *   수정한 Line도 상세히 적을것
 *
 *   211108 / 17:30 데이터 테이블 생성
 *
 * */       // 코드 변경시 여기에 변경한 코드에 대한 정보 입력

// 데이터베이스 접속하는 추상 클래스 입니다
@Database(entities = {UserInfo.class}, version = 1)
public abstract class DataBaseAbs extends RoomDatabase {
    // Dao 선언
    public abstract DataBaseDao dataBaseDao();
}
