package com.example.lcheeditsource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;


/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211108 / 18:00 데이터베이스 접근함수 생성
 *      Line 25 Dao객체 생성
 *      Line 32 ~ 76 데이터베이스 접근 함수 생성
 *      -- 이지원
 *      211111 / 메인페이지 XML완성
 *      -- 김종원
 *
 * */

public class MainActivity extends AppCompatActivity {

    private DataBaseDao mDatabaseDao;       // Dao 객체 생성

    Intent Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 베이스삽입
        // !! 수정 금지 !!
        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();


         /*

        // 데이터 삽입
        User user = new User();     //  객체 인스턴스
        user.setName("입력할 이름");
        user.setAge("나이");
        user.setPhoneNumber("010-1234-5678");
        mUserDao.setInsertUser(user);

        // UserDao에 만든 데이터 조회 쿼리
        // 결과값이 list User에 저장됨
        List<User> userList = mUserDao.getUserAll();
        // 데이터 조회
        for (int i = 0; i < userList.size(); i++) {
            Log.d("Test", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhoneNumber() + "\n");
        }

//         데이터 수정
        User user2 = new User();     //  객체 인스턴스
        user2.setId(1);              // 데이터베이스의 id
        user2.setName("지원_수정");
        user2.setAge("25");
        user2.setPhoneNumber("010-1234-0000");
        mUserDao.setUpdateUser(user2);      // 데이터 수정


        // 데이터 삭제
        User user3 = new User();
        user3.setId(4);
        mUserDao.setDeleteUser(user3);
        */ // 데이터 베이스의 기본형

        // !! 여기까지 수정금지 !!




    }
}
