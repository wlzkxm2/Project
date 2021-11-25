package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBase.UserInfo;

@Database(entities = {Production.class}, version = 1)
public abstract class ProductionAbs extends RoomDatabase {
    // Dao 선언
    public abstract ProductionDAO productionDAO();
}
