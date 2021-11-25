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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.util.List;


/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211113 로그인 페이지
 *      -- 이지원
 * 
 *      211123 로그인 분기 체크 추가
 *      -- 이지원
 */



public class Login extends Activity {
    
    private DataBaseDao mDatabaseDao;


    EditText LoginID, LoginPassword;
    Button Loginbtn, SignUpbtn;

    Intent Page;

    String inputId, inputPassword;
    Boolean LoginCheack = false;
    Boolean AdminCheack = false;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();

        LoginID = (EditText) findViewById(R.id.edit_LoginID);
        LoginPassword = (EditText) findViewById(R.id.edit_LoginPassword);
        Loginbtn = (Button) findViewById(R.id.btn_Login);
        SignUpbtn = (Button) findViewById(R.id.btn_SignUp);

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserInfo> userData = mDatabaseDao.getUserAll();

                inputId = LoginID.getText().toString();
                inputPassword = LoginPassword.getText().toString();

                for (int i = 0; i < userData.size(); i++) {
                    //Password Check
                    String DBID = userData.get(i).getUserId();
                    String DBPassword = userData.get(i).getPassword();
                    Boolean Admin = userData.get(i).getAdmin();
                    
                    // 아이디가 같은지 다른지부터 체크
                    if(DBID.equals(inputId)){
                        if(DBPassword.equals(inputPassword)){
                            if(Admin.equals(true)){
                                Page = new Intent();
                                LoginCheack = true;
                                AdminCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);
                                Page.putExtra("Bool_AdminCheack", AdminCheack);
                                setResult(101, Page);
                                finish();

                                // 아이디와 패스워드가 같다면 로그인이 가능하다는 이벤트
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                            }else {
                                Page = new Intent();
                                LoginCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);
                                setResult(101, Page);
                                finish();

                                // 아이디와 패스워드가 같다면 로그인이 가능하다는 이벤트
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                            }

                        }
                        // Login EV
                    }else{
                        // 만약 아이디와 패스워드가 다르다면 나오는 이벤트
                        Toast.makeText(getApplicationContext(), "LoginFail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign Page Move
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
    }
}
