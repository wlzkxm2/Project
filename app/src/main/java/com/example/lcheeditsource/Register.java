package com.example.lcheeditsource;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;


public class Register extends Activity {

    private DataBaseDao mDatabaseDao;

    Intent GotoLogin;

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
            _registerPhoncall,
            _registerBirthYear,
            _registerBirthMonth,
            _registerBirthDay,
            _registerBirth;

    // 날짜 입력을 위한 함수

    DatePickerDialog datePickerDialog;

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

//        debug_textView = (TextView) findViewById(R.id.debug_textView);


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
                // debug
//                Toast.makeText(getApplicationContext(), registerID.getText(), Toast.LENGTH_SHORT).show();

                // 데이터내부 정보를 전부 불러옴
                List<UserInfo> userList = mDatabaseDao.getUserAll();
                // debug
//                Toast.makeText(getApplicationContext(), "중복검사중입니다", Toast.LENGTH_SHORT).show();

                if(userList.size() <= 0){
                    IDCheack_textView.setText("사용가능한 아이디 입니다.");
                    IdCheack_bool = true;

                }else{
                    for (int count = 0; count < userList.size(); count++) {
                        // 데이터베이스 count 번째 데이터의 아이디를 ListId에 저장
                        String ListId = userList.get(count).getUserId();

                        // debug
//                    Toast.makeText(getApplicationContext(), "ListId", Toast.LENGTH_SHORT).show();

                        // ListId의 데이터(데이터베이스 Count번재 데이터)가 유저가 입력한 데이터과 같을 경우 검사
                        if(ListId.equals(_registerId)){
                            // 만약 같다면 아이디가 존재한다는 팝업이벤트
                            IDCheack_textView.setText("아이디가 존재합니다. 다른 아이디로 해주세요");
                            IdCheack_bool = false;
                            break;
                        }else {
                            // 같지 않다면 회원가입이 가능하다는 팝업 이벤트
                            IDCheack_textView.setText("사용가능한 아이디 입니다.");
                            // bool 값을 통해 중복검사를 하지 않고 회원가입 하는 행위를 차단
                            IdCheack_bool = true;
                        }
                    }
                }
                // 데이터베이스 데이터 수만큼 반복

                // debug
//               Toast.makeText(getApplicationContext(), "실행종료" + IdCheack_bool, Toast.LENGTH_SHORT).show();
            }
       });

       // 생일 입력 함수
        choiceBirth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int Year = c.get(Calendar.YEAR);
                int Month = c.get(Calendar.MONTH);
                int Day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog BirthPicker = new DatePickerDialog(Register.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker v, int year, int month, int dayOfMonth){
                                Birth_textView.setText(year + " / " + (month+1) + " / " + dayOfMonth);
                                // 입력한 함수를 String 변수에 삽입
                                _registerBirthYear = Integer.toString(year);
                                _registerBirthMonth = Integer.toString(month+1);
                                _registerBirthDay = Integer.toString(dayOfMonth);
                                Toast.makeText(getApplicationContext() , _registerBirthYear + " " +
                                        _registerBirthMonth + " " +
                                        _registerBirthDay, Toast.LENGTH_SHORT).show();
                                _registerBirth = _registerBirthYear + "-" + _registerBirthMonth + "-" + _registerBirthDay;
                                Toast.makeText(getApplicationContext(), _registerBirth, Toast.LENGTH_SHORT).show();
                            }
                        }, Year, Month, Day);
                BirthPicker.show();


            }
        });



        SignUpComplete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GotoLogin = new Intent(getApplicationContext(), Login.class);

                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String getTime = dateFormat.format(date);


                _registerId = registerID.getText().toString();
                _registerPassword = registerPassword.getText().toString();
                _registerPasswordCheack = registerPasswordCheack.getText().toString();
                _registerEmail = registerEmail.getText().toString();
                _registerName = registerName.getText().toString();
                _registerPhoncall = registerPhoneCall.getText().toString();

//
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
//
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


//                debug_textView.setText("아이디체크" + IdCheack_bool + "\n" +
//                        "비밀번호체크" + PasswordCheack_bool + "\n" +
//                        "비밀번호 비어있는지" + PasswordEmptyCheack_bool + "\n" +
//                        "이메일체크" + EmailEmptyCheack_bool + "\n" +
//                        "이름체크" + NameEmptyCheack_bool + "\n" +
//                        "전화번호체크" + PhoneCallEmptyCheack_bool);
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
                    registerUser.setRigisterDate(getTime);
                    registerUser.setBirth_Day(_registerBirth);
                    registerUser.setPhoneNumber(_registerPhoncall);
//                    registerUser.setUserAddressDefault();
//                    registerUser.setUserAddressMore();
//                    registerUser.setUserAddressNumber();
                    mDatabaseDao.setInsertUser(registerUser);

                    startActivity(GotoLogin);
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
