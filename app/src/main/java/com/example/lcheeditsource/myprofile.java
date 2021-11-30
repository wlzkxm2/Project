package com.example.lcheeditsource;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import android.content.Intent;
import com.example.lcheeditsource.DataBase.UserInfo;
import android.view.View;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

public class myprofile extends Activity {
    private DataBaseDao mDataBaseDao;

    Button back, ps;
    //profilesBack, profilesSetting

    TextView email, phone, shop, message ;
    // text_userEmailView, text_userMessageView,text_userShopView

    Intent Page ;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        back = (Button) findViewById(R.id.btn_profilesBack);
        ps = (Button) findViewById(R.id.btn_profilesSetting);
        email = (TextView) findViewById(R.id.text_userEmailView);
        phone = (TextView) findViewById(R.id.text_userPhonecallView);
        shop = (TextView) findViewById(R.id.text_userShopView);
        message = (TextView) findViewById(R.id.text_userShopView);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
        ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //내 정보 수정 페이지로 이동
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // email 페이지로 이동
            }

        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // PhonecallNumber 페이지로 이동
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add to shop 페이지로 이동
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show all comment 페이지로 이동
            }
        });


    }


}

