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

                // 이용자에게 입력받은 아이디 를 inputID에 적용
                inputId = LoginID.getText().toString();
                inputPassword = LoginPassword.getText().toString();

                for (int i = 0; i < userData.size(); i++) {
                    //Password Check
                    String DBID = userData.get(i).getUserId();
                    String DBPassword = userData.get(i).getPassword();
                    Boolean Admin = userData.get(i).getAdmin();
                    int UserCode = userData.get(i).getDefaultUserCode();
                    
                    // 아이디가 같은지 다른지부터 체크
                    if(DBID.equals(inputId)){
                        if(DBPassword.equals(inputPassword)){
                            if(Admin.equals(true)){
                                Page = new Intent();
                                LoginCheack = true;
                                AdminCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);     // MainActivity에 LoginCheack값 전송
                                Page.putExtra("Bool_AdminCheack", AdminCheack);     // MainActivity에 AdminCheack값 전송
                                setResult(101, Page);
                                Page.putExtra("Usercode", UserCode);
                                finish();

                                // 아이디와 패스워드가 같다면 로그인이 가능하다는 이벤트
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                break;
                            }else {
                                Page = new Intent();
                                LoginCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);
                                Page.putExtra("Usercode", UserCode);
                                setResult(101, Page);
                                finish();

                                // 아이디와 패스워드가 같다면 로그인이 가능하다는 이벤트
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                break;
                            }

                        }
                    }
                    // 로그인이 실패하면 나오는 Toast
                    Toast.makeText(getApplicationContext(), "LoginFail", Toast.LENGTH_SHORT).show();
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
