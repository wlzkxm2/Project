// 상품비교 화면 최지욱//
package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.util.List;

public class goods_comparison extends Activity {
    private DataBaseDao mDataBaseDao;

    TextView VSText, ipadView, lenovoView, lowestView, GoodsExplainView, GoodsExplainView2,
             textView, textView2, textView3, textView4, textView5, textView6, First_bar,
             Second_bar, Third_bar, Fourth_bar, Fifth_bar, Sixth_bar, Seventh_bar, Eighth_bar,
             Ninth_bar, Tenth_bar, Strengths, Strengths_one, Strengths_two, Strengths_three,
             Strengths_four, Strengths_five, Strengths_six, Weakness, Weakness_one, Weakness_two,
            Weakness_three, Weakness_four;
    ImageView loginLogo2, UserImage, imageView4;
    ImageButton back23;
    Button btn_FirstItemBuy, btn_SecondeItemBuy;

    Intent Page;



    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_comparison);

        VSText = (TextView) findViewById(R.id.VSText);
        ipadView = (TextView) findViewById(R.id.ipadView);
        lenovoView = (TextView) findViewById(R.id.lenovoView);
        lowestView = (TextView) findViewById(R.id.lowestView);
        GoodsExplainView = (TextView) findViewById(R.id.GoodsExplainView);
        GoodsExplainView2 = (TextView) findViewById(R.id.GoodsExplainView2);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        First_bar = (TextView) findViewById(R.id.First_bar);
        Second_bar = (TextView) findViewById(R.id.Second_bar);
        Third_bar = (TextView) findViewById(R.id.Third_bar);
        Fourth_bar = (TextView) findViewById(R.id.Fourth_bar);
        Fifth_bar = (TextView) findViewById(R.id.Fifth_bar);
        Sixth_bar = (TextView) findViewById(R.id.Sixth_bar);
        Seventh_bar = (TextView) findViewById(R.id.Seventh_bar);
        Eighth_bar = (TextView) findViewById(R.id.Eighth_bar);
        Ninth_bar = (TextView) findViewById(R.id.Ninth_bar);
        Tenth_bar = (TextView) findViewById(R.id.Tenth_bar);
        Strengths = (TextView) findViewById(R.id.Strengths);
        Strengths_one = (TextView) findViewById(R.id.Strengths_one);
        Strengths_two = (TextView) findViewById(R.id.Strengths_two);
        Strengths_three = (TextView) findViewById(R.id.Strengths_three);
        Strengths_four = (TextView) findViewById(R.id.Strengths_four);
        Strengths_five = (TextView) findViewById(R.id.Strengths_five);
        Strengths_six = (TextView) findViewById(R.id.Strengths_six);
        Weakness = (TextView) findViewById(R.id.Weakness);
        Weakness_one = (TextView) findViewById(R.id.Weakness_one);
        Weakness_two = (TextView) findViewById(R.id.Weakness_two);
        Weakness_three = (TextView) findViewById(R.id.Weakness_three);
        Weakness_four = (TextView) findViewById(R.id.Weakness_four);
        loginLogo2 = (ImageView) findViewById(R.id.loginLogo2);
        UserImage = (ImageView) findViewById(R.id.UserImage);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        back23 = (ImageButton) findViewById(R.id.back23);
        btn_FirstItemBuy = (Button) findViewById(R.id.btn_FirstItemBuy);
        btn_SecondeItemBuy = (Button) findViewById(R.id.btn_SecondeItemBuy);





        back23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
        btn_FirstItemBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 구매하기 페이지로 이동
            }
        });
        btn_SecondeItemBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 구매하기 페이지로 이동
            }
        });


    }

}
