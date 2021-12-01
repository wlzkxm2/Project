package com.example.lcheeditsource;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lcheeditsource.ItemListData.Adapter;
import com.example.lcheeditsource.ItemListData.ItemListData;

import java.util.ArrayList;

public class ItemListView extends Activity {

    RecyclerView recyclerView;
    ArrayList<ItemListData> itemListData;
    Adapter myAdapter;
    String[] ItemName;
    int[] ItemPrice;
    int[] ItemResouceID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlistview);

        recyclerView = findViewById(R.id.ItemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        itemListData = new ArrayList<ItemListData>();

        myAdapter = new Adapter(this, itemListData);

        recyclerView.setAdapter(myAdapter);


    }
}
