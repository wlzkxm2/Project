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
 */



public class Login extends Activity {
    
    private DataBaseDao mDatabaseDao;


    EditText LoginID, LoginPassword;
    Button Loginbtn, SignUpbtn;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        LoginID = (EditText) findViewById(R.id.edit_LoginID);
        LoginPassword = (EditText) findViewById(R.id.edit_LoginPassword);
        Loginbtn = (Button) findViewById(R.id.btn_Login);
        SignUpbtn = (Button) findViewById(R.id.btn_SignUp);

        String inputId = LoginID.getText().toString();
        String inputPassword = LoginPassword.getText().toString();

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserInfo> userData = mDatabaseDao.getID(LoginID.getText().toString());
                String DBPassword, InputPassword;
                InputPassword = LoginPassword.getText().toString();

                for (int i = 0; i < userData.size(); i++) {
                    //Password Check
                    DBPassword = userData.get(i).getPassword();
                    if(DBPassword.equals(InputPassword)){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        // Login EV
                    }else{
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
