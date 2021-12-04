/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211115 알림 페이지 생성
 *      -- 김종원
 *      211123 알림 자바 코드 추가
 *      -- 김종원
 */

package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;


public class notice extends Activity {
    private DataBaseDao mDataBaseDao;

    Button nb1, nb2, nb3, nb4, nb5;
    ImageButton back;
    EditText nt3;
    TextView nt1, nt2;
    ImageView ni1;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);

        back = (ImageButton) findViewById(R.id.back3);
        nb1 = (Button) findViewById(R.id.noticebutton1);
        nb2 = (Button) findViewById(R.id.noticebutton2);
        nb3 = (Button) findViewById(R.id.noticebutton3);
        nb4 = (Button) findViewById(R.id.noticebutton4);
        nb5 = (Button) findViewById(R.id.noticebutton5);
        nt1 = (TextView) findViewById(R.id.noticetext1);
        nt2 = (TextView) findViewById(R.id.noticetext2);
        nt3 = (EditText) findViewById(R.id.noticetext3);
        ni1 = (ImageView) findViewById(R.id.noticeimage1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                finish();
            }
        });
        nb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //첫번째 알림 화면으로 이동
            }
        });
        nb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //두번째 알림 화면으로 이동
            }
        });
        nb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //세번째 알림 화면으로 이동
            }
        });
        nb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //네번째 알림 화면으로 이동
            }
        });
        nb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //다섯번째 알림 화면으로 이동
            }
        });
    }
}