package com.example.lcheeditsource;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
 *      211114 회원가입 페이지
 *      -- 이지원
 */

public class Register extends Activity {

    private DataBaseDao mDatabaseDao;

    AlertDialog.Builder dl;

    private EditText registerID,
            registerPassword,
            registerPasswordCheack,
            registerEmail,
            registerName,
            registerPhoneCall;

    private TextView Birth_textView, IDCheack_textView, debug_textView;
    private Button choiceBirth_btn, SignUpComplete_btn, IdCheack_btn;

    // 아이디 중복체크 bool 함수
    // false 일경우 아이디 중복확인을 하지 않았거나 중복된 아이디가 있다는 의미미
    private Boolean IdCheack_bool = false;

    // 비밀번호둘이 같은지 여부 검사
    private Boolean PasswordCheack_bool = false;

    // 입력값이 비어있는지 여부 체크 비어져있으면 False
    private Boolean IdEmptyCheack_bool = false;
    private Boolean PasswordEmptyCheack_bool = false;
    private Boolean EmailEmptyCheack_bool = false;
    private Boolean NameEmptyCheack_bool = false;
    private Boolean PhoneCallEmptyCheack_bool = false;

    private String _registerId,
            _registerPassword,
            _registerPasswordCheack,
            _registerEmail,
            _registerName,
            _registerPhoncall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();

        registerID = (EditText) findViewById(R.id.edit_registerID);
        registerPassword = (EditText) findViewById(R.id.edit_registerPassword);
        registerPasswordCheack = (EditText) findViewById(R.id.edit_registerPasswordC);
        registerEmail = (EditText) findViewById(R.id.edit_registerEmail);
        registerName = (EditText) findViewById(R.id.edit_registerName);
        registerPhoneCall = (EditText) findViewById(R.id.edit_registerPhoneCall);

        Birth_textView = (TextView) findViewById(R.id.text_Birth);
        IDCheack_textView = (TextView) findViewById(R.id.text_IDcheackMessage);

        choiceBirth_btn = (Button) findViewById(R.id.btn_choiceBirth);
        SignUpComplete_btn = (Button) findViewById(R.id.btn_SingComplete);
        IdCheack_btn = (Button) findViewById(R.id.btn_IDcheackButton);

        debug_textView = (TextView) findViewById(R.id.debug_textView);


       // 아이디 중복체크 TextView 초기화
       IDCheack_textView.setText("중복확인을 해주세요");

       IdCheack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 데이터베이스의 정보를 IDcheack에 담고
                // 담은 정보를 for문을 이용해서 IDCheack List의 크기만큼 반복하여
                // 데이터의 정보가 입력한 정보랑 같은지 다른지를 확인하고
                // 만약에 데이터가 존재하면 가입이 안됨

                _registerId = registerID.getText().toString();
//                Toast.makeText(getApplicationContext(), registerID.getText(), Toast.LENGTH_SHORT).show();

                List<UserInfo> userList = mDatabaseDao.getUserAll();
//                Toast.makeText(getApplicationContext(), "중복검사중입니다", Toast.LENGTH_SHORT).show();
                for (int count = 0; count < userList.size(); count++) {
                    String ListId = userList.get(count).getUserId();

//                    Toast.makeText(getApplicationContext(), "ListId", Toast.LENGTH_SHORT).show();
                    if(ListId.equals(_registerId)){
                        IDCheack_textView.setText("아이디가 존재합니다. 다른 아이디로 해주세요");
                        IdCheack_bool = false;
                        break;
                    }else {
                        IDCheack_textView.setText("사용가능한 아이디 입니다.");
                        IdCheack_bool = true;
                    }
                }
               Toast.makeText(getApplicationContext(), "실행종료" + IdCheack_bool, Toast.LENGTH_SHORT).show();
            }
       });

        choiceBirth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 생일 선택 함수
            }
        });

        SignUpComplete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                _registerId = registerID.getText().toString();
                _registerPassword = registerPassword.getText().toString();
                _registerPasswordCheack = registerPasswordCheack.getText().toString();
                _registerEmail = registerEmail.getText().toString();
                _registerName = registerName.getText().toString();
                _registerPhoncall = registerPhoneCall.getText().toString();
                choiceBirth_btn

                // 아이디가 비어져있는지 여부 검사
                if(_registerId.equals(""))
                    IdEmptyCheack_bool = false;
                else
                    IdEmptyCheack_bool = true;

                if(_registerPassword.equals(""))
                    PasswordEmptyCheack_bool = false;
                else {
                    PasswordEmptyCheack_bool = true;

                    // 패스워드가 같은지 여부 검사
                    if(_registerPassword.equals(_registerPasswordCheack)) {
                        PasswordCheack_bool = true;
                    }else
                        PasswordCheack_bool = false;
                }

                if(_registerEmail.equals(""))
                    EmailEmptyCheack_bool = false;
                else
                    EmailEmptyCheack_bool = true;

                if(_registerName.equals(""))
                    NameEmptyCheack_bool = false;
                else
                    NameEmptyCheack_bool = true;

                if(_registerPhoncall.equals(""))
                    PhoneCallEmptyCheack_bool = false;
                else
                    PhoneCallEmptyCheack_bool = true;


//
//                private Boolean IdEmptyCheack_bool = false;
//                private Boolean PasswordEmptyCheack_bool = false;
//                private Boolean EmailEmptyCheack_bool = false;
//                private Boolean NameEmptyCheack_bool = false;
//                private Boolean PhoneCallEmptyCheack_boo = false;

                debug_textView.setText("아이디체크" + IdCheack_bool + "\n" +
                        "비밀번호체크" + PasswordCheack_bool + "\n" +
                        "비밀번호 비어있는지" + PasswordEmptyCheack_bool + "\n" +
                        "이메일체크" + EmailEmptyCheack_bool + "\n" +
                        "이름체크" + NameEmptyCheack_bool + "\n" +
                        "전화번호체크" + PhoneCallEmptyCheack_bool);
                // 가입 데이터 DB에 저장
                if(IdCheack_bool == true &&
                        PasswordCheack_bool == true &&
                        EmailEmptyCheack_bool == true &&
                        NameEmptyCheack_bool == true &&
                        PhoneCallEmptyCheack_bool == true){
                    Toast.makeText(getApplicationContext(), "회원가입이 성공하였습니다", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "다시 로그인해주세요", Toast.LENGTH_SHORT).show();

                    UserInfo registerUser = new UserInfo();
                    registerUser.setUserId(_registerId);
                    registerUser.setPassword(_registerPassword);
                    registerUser.setEmail(_registerEmail);
                    registerUser.setName(_registerName);
                    registerUser.setBirth_Day();
                    registerUser.setPhoneNumber(_registerPhoncall);
                    registerUser.setUserAddressDefault();
                    registerUser.setUserAddressMore();
                    registerUser.setUserAddressNumber();
                    mDatabaseDao.setInsertUser(registerUser);
                }else{
                    
                    // 가입실패
                    Toast.makeText(getApplicationContext(), "정보가 비어있거나 비밀번호가 잘못입력되었습니다", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "정보를 재입력해주세요", Toast.LENGTH_SHORT).show();
                    registerPassword.setText("");
                    registerPasswordCheack.setText("");
                }

            }
        });
    }
}
