package com.example.lcheeditsource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import org.w3c.dom.Text;

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

    EditText registerID,
            registerPassword,
            registerPasswordCheack,
            registerEmail,
            registerName,
            registerPhoneCall;

    TextView Birth_textView, IDCheack_textView;
    Button choiceBirth_btn, SignUpComplete_btn, IdCheack_btn;


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

    String _registerId,
            _registerPassword,
            _registerPasswordCheack,
            _registerEmail,
            _registerName,
            _registerPhoncall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerID = (EditText) findViewById(R.id.edit_LoginID);
        registerPassword = (EditText) findViewById(R.id.edit_LoginPassword);
        registerPasswordCheack = (EditText) findViewById(R.id.edit_registerPasswordC);
        registerEmail = (EditText) findViewById(R.id.edit_registerEmail);
        registerName = (EditText) findViewById(R.id.edit_registerName);
        registerPhoneCall = (EditText) findViewById(R.id.edit_registerPhoneCall);

        Birth_textView = (TextView) findViewById(R.id.text_Birth);
        IDCheack_textView = (TextView) findViewById(R.id.text_IDcheackMessage);

        choiceBirth_btn = (Button) findViewById(R.id.btn_choiceBirth);
        SignUpComplete_btn = (Button) findViewById(R.id.btn_SingComplete);
        IdCheack_btn = (Button) findViewById(R.id.btn_IDcheackButton);


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
                Toast.makeText(getApplicationContext(), registerID.getText(), Toast.LENGTH_SHORT).show();

//                List<UserInfo> IDcheack = mDatabaseDao.FindID(_registerId);
//                Toast.makeText(getApplicationContext(), "중복검사중입니다", Toast.LENGTH_SHORT).show();
//                for (int i = 0; i < IDcheack.size(); i++) {
//                    String CheackID = IDcheack.get(i).getUserId();
//                    if(CheackID.equals(_registerId)){
//                        IDCheack_textView.setText("아이디가 존재합니다. 다른 아이디로 해주세요");
//                        IdCheack_bool = false;
//                    }else {
//                        IdCheack_bool = true;
//                        IDCheack_textView.setText("사용가능한 아이디 입니다.");
//                    }
//                }
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
                        PasswordCheack_bool = false;
                    }else
                        PasswordCheack_bool = true;
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
//                    registerUser.setBirth_Day();
                    registerUser.setPhoneNumber(_registerPhoncall);
//                    registerUser.setUserAddressDefault();
//                    registerUser.setUserAddressMore();
//                    registerUser.setUserAddressNumber();
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
