// 상품비교 화면 최지욱//
package com.example.lcheeditsource;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
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
//        ViewSet();

        List<Production> ItemListCall = mItemDao.getAllItemData();

        // 화면에 아이템을 보여주는 역할
        ItemdetailSet(ItemListCall);





    }
/*
    private void ViewSet() {
        firstItemName = findViewById(R.id.);            // 상품 이름
        firstItemPrice = findViewById(R.id.);       // 상품 가격
        btn_FirstItemBuy = findViewById(R.id.);      // 상품 구매 버튼
        SecondItemName = findViewById(R.id);            // 두번째 상품 이름
        secondItemPrice = findViewById(R.id.);      // 두번째 상픔 가격
        btn_SecondItemBuy = findViewById(R.id.);     // 두번째 상품 구매 버튼

        Specone = findViewById(R.id);               // 무슨 스펙인가?
        Spectwo = findViewById(R.id);
        Specthree = findViewById(R.id);
        Specfour = findViewById(R.id);
        Specfive = findViewById(R.id);

        firstItemSpec1 = findViewById(R.id);         // 첫번째 아이템 스펙 1
        firstItemSpec2 = findViewById(R.id);         // 두번재 아이템 스펙 2
        firstItemSpec3 = findViewById(R.id);
        firstItemSpec4 = findViewById(R.id);

        secondItemSpec1 = findViewById(R.id);
        secondItemSpec2 = findViewById(R.id);
        secondItemSpec3 = findViewById(R.id);
        secondItemSpec4 = findViewById(R.id);

        firstItemAdvantage = findViewById(R.id);
        firstItemDisAdvantage = findViewById(R.id);

        secondItemAdvantage = findViewById(R.id);
        seconItemDisAdvantage = findViewById(R.id.);

        firstItemImage = findViewById(R.id);        // 첫번째 이미지 이름
        secondItemImage = findViewById(R.id);       // 두번째 이미지 이름

        back_goods = findViewById(R.id);        // 뒤로가기



    }
 */

    private void ItemdetailSet(List<Production> ItemListCall){
        for (int i = 0; i < ItemListCall.size(); i++) {
            if(i == 0){
                // 첫번째 아이템에 관한 setText
                // 이를 통해 아이템 이름과 정보가 표시됨
                firstItemName.setText(ItemListCall.get(i).getItemName());
                firstItemPrice.setText(ItemListCall.get(i).getPrice());
                firstItemSpec1.setText(ItemListCall.get(i).getSpec1());
                firstItemSpec2.setText(ItemListCall.get(i).getSpec2());
                firstItemSpec3.setText(ItemListCall.get(i).getSpec3());
                firstItemSpec4.setText(ItemListCall.get(i).getSpec4());

                firstItemAdvantage.setText("");
                firstItemDisAdvantage.setText("");

                if(ItemListCall.get(i).getItemName().contains("P11")){
                    firstItemImage.setImageResource(R.drawable.lenovo);
                }else if(ItemListCall.get(i).getItemName().contains("IPad")){
                    firstItemImage.setImageResource(R.drawable.ipad);
                }else{
                    firstItemImage.setImageResource(R.drawable.product);
                }
            } else if(i == 1){
                // 첫번째 아이템에 관한 setText
                // 이를 통해 아이템 이름과 정보가 표시됨
                SecondItemName.setText(ItemListCall.get(i).getItemName());
                secondItemPrice.setText(ItemListCall.get(i).getPrice());
                secondItemSpec1.setText(ItemListCall.get(i).getSpec1());
                secondItemSpec2.setText(ItemListCall.get(i).getSpec2());
                secondItemSpec3.setText(ItemListCall.get(i).getSpec3());
                secondItemSpec4.setText(ItemListCall.get(i).getSpec4());

                secondItemAdvantage.setText("");
                seconItemDisAdvantage.setText("");

                if(ItemListCall.get(i).getItemName().contains("P11")){
                    secondItemImage.setImageResource(R.drawable.lenovo);
                }else if(ItemListCall.get(i).getItemName().contains("IPad")){
                    secondItemImage.setImageResource(R.drawable.ipad);
                }else{
                    secondItemImage.setImageResource(R.drawable.product);
                }
            }


        }
    }

}
