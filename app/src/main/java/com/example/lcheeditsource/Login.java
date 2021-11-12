package com.example.lcheeditsource;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;


/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211112 로그인 페이지
 *      -- 이지원
 */



public class Login extends Activity {

    EditText LoginID, LoginPassword;
    ImageButton Loginbtn, SinUpbtn;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        LoginID = (EditText) findViewById(R.id.edit_LoginID);
        LoginPassword = (EditText) findViewById(R.id.edit_LoginPassword);
        Loginbtn = (ImageButton) findViewById(R.id.btn_Login);
        SinUpbtn = (ImageButton) findViewById(R.id.btn_SignUp);

        String inputId = LoginID.getText().toString();
        String inputPassword = LoginPassword.getText().toString();

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
