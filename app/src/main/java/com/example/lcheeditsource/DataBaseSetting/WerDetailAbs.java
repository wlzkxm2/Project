package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lcheeditsource.DataBase.WearDetail;

@Database(entities = {WearDetail.class}, version = 1)
public abstract class WerDetailAbs extends RoomDatabase {
    public abstract WearDetailDao wearDetailDao();
}
