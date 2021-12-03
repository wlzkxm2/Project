package com.example.lcheeditsource;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;

import java.util.Arrays;
import java.util.List;

public class ItemlistView extends AppCompatActivity {

    private RecyclerAdapter adapter;
    public ProductionDAO mItemDao;

    Intent Page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlistview);

        // Search 에서 보낸 값을 받아옴
        Page = getIntent();
        String SearchTxt = Page.getStringExtra("SearchData");

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.ItemRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        ProductionAbs itemDB = Room.databaseBuilder(getApplicationContext(), ProductionAbs.class, "Item.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mItemDao = itemDB.productionDAO();

        // 상품의 데이터를 List에 삽입
        List<Production> DBitemList = mItemDao.getAllItemData();
        // 상품의 이미지를 대입
        List<Integer> Imagelist = Arrays.asList(R.drawable.lenovo, R.drawable.ipad);

        // 상품의 갯수만큼 출력
        for (int i = 0; i < DBitemList.size(); i++) {

            ItemData data = new ItemData();
            data.setItemName(DBitemList.get(i).getItemName());
            data.setItemPrice(Integer.toString(DBitemList.get(i).getPrice()) + "원");
            data.setResources(Imagelist.get(i));

            adapter.addItem(data);

 //        List<String> Itemlist = null;
//        List<String> Pricelists = null;
//        List<Integer> Imagelist = null;
//        for (int i = 0; i < DBitemList.size(); i++) {
//            String name = DBitemList.get(i).getItemName();
//            String Price = Integer.toString(DBitemList.get(i).getPrice());
//            Itemlist.add(name);
//            Pricelists.add(Price);
//
//        }


//        List<String> Itemlist = Arrays.asList("아이패드", "레노버 p11");
//        List<String> Pricelists = Arrays.asList("870,000", "250,000");

        }

        adapter.notifyDataSetChanged();
    }
}
