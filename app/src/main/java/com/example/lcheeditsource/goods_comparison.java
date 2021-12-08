// 상품비교 화면 최지욱//
package com.example.lcheeditsource;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;

import java.util.List;

public class goods_comparison extends Activity {
    private DataBaseDao mDataBaseDao;

    TextView firstItemName, SecondItemName,                      // 상품 이름
            firstItemPrice, secondItemPrice,             //가격
            Specone, Spectwo, Specthree, Specfour, Specfive,     // 스펙
            firstItemSpec1, secondItemSpec1,             // 아이템 스펙1
            firstItemSpec2, secondItemSpec2,             // 아이템 스펙2
            firstItemSpec3, secondItemSpec3,             // 아이템 스펙3
            firstItemSpec4, secondItemSpec4,             // 아이템 스펙4
            firstItemSpec5, secondItemSpec5,                 // 아이템 스펙 5
            firstItemAdvantage, secondItemAdvantage,     // 아이템 장점
            firstItemDisAdvantage, seconItemDisAdvantage;     // 아이템 점

    ImageView firstItemImage, secondItemImage;
    ImageButton back_goods;
    Button btn_FirstItemBuy, btn_SecondItemBuy;

    Intent Page;

    public ProductionDAO mItemDao;
//t수정

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_comparison);

        ProductionAbs itemDB = Room.databaseBuilder(getApplicationContext(), ProductionAbs.class, "Item.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mItemDao = itemDB.productionDAO();

        // 버튼과 텍스트뷰 셋
        ViewSet();

        List<Production> ItemListCall = mItemDao.getAllItemData();

        // 화면에 아이템을 보여주는 역할
        ItemdetailSet(ItemListCall);


    }

    private void ViewSet() {
        firstItemName = findViewById(R.id.text_fitsrtItemName);            // 상품 이름
        firstItemPrice = findViewById(R.id.text_firstItemPrice);       // 상품 가격
        btn_FirstItemBuy = findViewById(R.id.btn_FirstItemBuy);      // 상품 구매 버튼
        SecondItemName = findViewById(R.id.text_secondItemName);            // 두번째 상품 이름
        secondItemPrice = findViewById(R.id.text_secondItemPrice);      // 두번째 상픔 가격
        btn_SecondItemBuy = findViewById(R.id.btn_SecondItemBuy);     // 두번째 상품 구매 버튼

        Specone = findViewById(R.id.text_Spec01);               // 무슨 스펙인가?
        Spectwo = findViewById(R.id.text_Spec02);
        Specthree = findViewById(R.id.text_Spec03);
        Specfour = findViewById(R.id.text_Spec04);
        Specfive = findViewById(R.id.text_Spec05);

        firstItemSpec1 = findViewById(R.id.text_firstItemSpec1);         // 첫번째 아이템 스펙 1
        firstItemSpec2 = findViewById(R.id.text_firstItemSpec2);         // 두번재 아이템 스펙 2
        firstItemSpec3 = findViewById(R.id.text_firstItemSpec3);
        firstItemSpec4 = findViewById(R.id.text_firstItemSpec4);
        firstItemSpec5 = findViewById(R.id.text_firstItemSpec5);

        secondItemSpec1 = findViewById(R.id.text_secondItemSpec1);
        secondItemSpec2 = findViewById(R.id.text_secondItemSpec2);
        secondItemSpec3 = findViewById(R.id.text_secondItemSpec3);
        secondItemSpec4 = findViewById(R.id.text_secondItemSpec4);
        secondItemSpec5 = findViewById(R.id.text_secondItemSpec5);

        firstItemAdvantage = findViewById(R.id.text_firstItemAdv);
        firstItemDisAdvantage = findViewById(R.id.text_firstItemdisAdv);

        secondItemAdvantage = findViewById(R.id.text_secondItemAdv);
        seconItemDisAdvantage = findViewById(R.id.text_secondItemdisAdv);

        firstItemImage = findViewById(R.id.image_firstItemImage);        // 첫번째 이미지 이름
        secondItemImage = findViewById(R.id.image_secondItemImage);       // 두번째 이미지 이름

        back_goods = findViewById(R.id.btn_backGoods);        // 뒤로가기


    }

    private void ItemdetailSet(List<Production> ItemListCall) {

        Log.v("로그", "불러옴");

        for (int i = 0; i < ItemListCall.size(); i++) {
            if (i == 0) {
                // 첫번째 아이템에 관한 setText
                // 이를 통해 아이템 이름과 정보가 표시됨
                firstItemName.setText(ItemListCall.get(i).getItemName());
                firstItemPrice.setText(Integer.toString(ItemListCall.get(i).getPrice()) + "원");
                firstItemSpec1.setText(ItemListCall.get(i).getSpec1() + " : 60");
                firstItemSpec1.setBackgroundColor(Color.YELLOW);        // 텍스트의 백그라운드 컬러
                firstItemSpec2.setText(ItemListCall.get(i).getSpec2() + " : 55");
                firstItemSpec2.setBackgroundColor(Color.YELLOW);
                firstItemSpec3.setText(ItemListCall.get(i).getSpec3());
                firstItemSpec3.setBackgroundColor(Color.GREEN);
                firstItemSpec4.setText("64GB : 50");
                firstItemSpec4.setBackgroundColor(Color.YELLOW);
                firstItemSpec5.setText("60Hz : 50");
                firstItemSpec5.setBackgroundColor(Color.YELLOW);
                firstItemAdvantage.setText("저렴한 가격 \n2K 디스플레이 \n넷플릭스 FHD 지원");
                firstItemDisAdvantage.setText("게이밍엔 부족한 성능 \n영상 시청외엔 적합하지 않은 성능");

                if (ItemListCall.get(i).getItemName().contains("P11")) {
                    firstItemImage.setImageResource(R.drawable.lenovo);
                } else if (ItemListCall.get(i).getItemName().contains("IPad")) {
                    firstItemImage.setImageResource(R.drawable.ipad);
                } else {
                    firstItemImage.setImageResource(R.drawable.product);
                }
            } else if (i == 1) {
                // 첫번째 아이템에 관한 setText
                // 이를 통해 아이템 이름과 정보가 표시됨
                SecondItemName.setText(ItemListCall.get(i).getItemName());
                secondItemPrice.setText(Integer.toString(ItemListCall.get(i).getPrice()) + "원");
                secondItemSpec1.setText("APLLE M1 : 80");
                secondItemSpec1.setBackgroundColor(Color.GREEN);
                secondItemSpec2.setText("램8GB : 75");
                secondItemSpec2.setBackgroundColor(Color.GREEN);
                secondItemSpec3.setText("11인치");
                secondItemSpec3.setBackgroundColor(Color.GREEN);
                secondItemSpec4.setText("128GB : 70");
                secondItemSpec4.setBackgroundColor(Color.GREEN);
                secondItemSpec5.setText("120Hz : 100");
                secondItemSpec5.setBackgroundColor(Color.GREEN);

                secondItemAdvantage.setText("전문가에게 대체불가능한 성능\n최고의 퍼포먼스\n11인치의 넓은 대화면\n잘구축된 생태계");
                seconItemDisAdvantage.setText("높은가격\n영상만 시청하기엔 과스펙");

                if (ItemListCall.get(i).getItemName().contains("P11")) {
                    secondItemImage.setImageResource(R.drawable.lenovo);
                } else if (ItemListCall.get(i).getItemName().contains("IPad")) {
                    secondItemImage.setImageResource(R.drawable.ipad);
                } else {
                    secondItemImage.setImageResource(R.drawable.product);
                }
            }


        }
    }


}
