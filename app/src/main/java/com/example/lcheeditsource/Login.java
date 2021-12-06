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

        // 로그인 정보를 전달받기위한 아이디 정보와 패스워드 정보를 받을 Edit Text를 지정
        LoginID = (EditText) findViewById(R.id.edit_LoginID);
        LoginPassword = (EditText) findViewById(R.id.edit_LoginPassword);
        Loginbtn = (Button) findViewById(R.id.btn_Login);
        SignUpbtn = (Button) findViewById(R.id.btn_SignUp);

        // 로그인 버튼을 눌럿을대의 이벤트
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserInfo> userData = mDatabaseDao.getUserAll();

                // 이용자에게 입력받은 아이디 를 inputID에 적용
                inputId = LoginID.getText().toString();
                inputPassword = LoginPassword.getText().toString();

                for (int i = 0; i < userData.size(); i++) {
                    //Password Check
                    String DBID = userData.get(i).getUserId();                              // DB 내부의 아이디를 String DBID에 삽입
                    String DBPassword = userData.get(i).getPassword();                      // DB 내부의 패스워드를 String DBPassword에 삽입
                    Boolean Admin = userData.get(i).getAdmin();                             // 해당유저가 어드민인지 아닌지를 확인하기 위해 Boolean형 Admin에 삽입
                    int UserCode = userData.get(i).getDefaultUserCode();                    // 해당 유저의 프로필로의 접근이 필요하기때문에 유저의 기본 고유 코드를 불러옴
                    
                    // 아이디가 같은지 다른지부터 체크
                    if(DBID.equals(inputId)){                                               //  inputId에 이용자가 입력한 아이디와 같은지 다른지 여부를 확인한다
                        if(DBPassword.equals(inputPassword)){                               // inputPassword에 이용자가 입력한 패스워드와 같은지 다른지 여부를 확인한다
                            if(Admin.equals(true)){                                         // 만약에 로그인 한 유저가 어드민 유저일경우
                                Page = new Intent();    
                                LoginCheack = true;                                         // MainActivity로의 데이터 전송을 위해서 LoginCheack와 AdminCheack를 True값으로 설정해준다
                                AdminCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);         // MainActivity에 LoginCheack값 전송
                                Page.putExtra("Bool_AdminCheack", AdminCheack);         // MainActivity에 AdminCheack값 전송
                                Page.putExtra("UserCode", UserCode);                    // UserCode를 Key로 로그인한 유저의 기본 고유 코드를 전송
                                setResult(101, Page);                               // 101번 key를 통해 MainActivity는 접근 할 수있다
                                finish();                                                   // 메인 엑티비티로 바로 이동 가능

                                // 아이디와 패스워드가 같다면 로그인이 가능하다는 이벤트
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                break;
                            }else {
                                // 만약에 로그인 한 유저가 어드민 유저가 아니라면
                                Page = new Intent();
                                // 해당 유저는 로그인은 했지만 어드민이 아니기때문에 LoginCheack에만 True로 초기화
                                LoginCheack = true;
                                Page.putExtra("Bool_LoginCheack", LoginCheack);      // 마찬가지로 MainActivity에 로그인 여부를 전송하여 MainActivity가 읽을 수 있게 해줌
                                Page.putExtra("UserCode", UserCode);
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

        // 회원가입 버튼을 입력했을때 이벤트
        SignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign Page Move
                // 회원가입을 이용자가 눌렀다면 회원가입을 할 수 있게끔 회원가입 클래스로 이동
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
    }
}
