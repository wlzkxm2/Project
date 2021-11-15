package com.example.lcheeditsource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211115 설정 페이지
 *      -- 이지원
 */

public class Setting extends Activity {
    
    ImageButton settingBack;
    Button settingLogin, settingPush, settingAgree, settingVer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        
        settingBack = (ImageButton) findViewById(R.id.btn_settingBack);
        settingLogin = (Button) findViewById(R.id.btn_settingLogin);
        settingPush = (Button)  findViewById(R.id.btn_settingPush); 
        settingAgree = (Button) findViewById(R.id.btn_settingAgree);
        settingVer = (Button) findViewById(R.id.btn_settingAppVer);
        
        // 뒤로가기 터치시 실행되는 이벤트
        // intent함수를 이용해 메인으로 돌아감
        settingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        
        // 로그인 버튼을 터치시 실행되는 이벤트
        // intent 함수를 이용해 로그인 화면으로 이동함
        settingLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        
        // Push 의 버튼을 터치시 실행되는 이벤트
        // intent 함수를 이용해 push알림 화면으로 이동함
        // 미구현
        /*
        settingPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        */
        
        // 마케팅 수신동의 버튼을 터치시 실행되는 이벤트
        // intent 함수를 이용해 마케팅 수신관련 화면으로 이동함
        // 미구현
        /*
        settingAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
              */
        
        // 앱버전 확인 버튼을 터치시 실행되는 이벤트
        // intent 함수를 이용해 앱 버전 확인페이지로 이동함
        settingVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
