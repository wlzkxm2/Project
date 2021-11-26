package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lcheeditsource.DataBase.ItemDetail;

@Database(entities = {ItemDetail.class}, version = 1)
public abstract class ItemDetailAbs extends RoomDatabase {
    public abstract ItemDetailDao itemDetailDao();
}
