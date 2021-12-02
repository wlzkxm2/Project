package com.example.lcheeditsource;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlistview);

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

        List<Production> DBitemList = mItemDao.getAllItemData();
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


        List<String> Itemlist = Arrays.asList("아이패드", "레노버 p11");
        List<String> Pricelists = Arrays.asList("870,000", "250,000");
        List<Integer> Imagelist = Arrays.asList(R.drawable.ipad, R.drawable.lenovo);

        for (int i = 0; i < Itemlist.size(); i++) {

            ItemData data = new ItemData();
            data.setItemName(DBitemList.get(i).getItemName());
            data.setItemPrice(Integer.toString(DBitemList.get(i).getPrice()) + "원");
            data.setResources(Imagelist.get(i));

            adapter.addItem(data);

        }

        adapter.notifyDataSetChanged();
    }
}