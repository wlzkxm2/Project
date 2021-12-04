package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lcheeditsource.DataBase.ItemDetail;

@Dao
public interface ItemDetailDao {

    @Insert // 데이터 삽입
    void setInsertUser(ItemDetail itemDetail);

    @Update // 데이터 수정
    void setUpdateUser(ItemDetail itemDetail);

    @Delete // 데이터 삭제
    void setDeleteUser(ItemDetail itemDetail);

}
