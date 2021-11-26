package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.lcheeditsource.DataBase.WearDetail;


@Dao
public interface WearDetailDao {

    @Insert // 데이터 삽입
    void setInsertUser(WearDetail wearDetail);

    @Update // 데이터 수정
    void setUpdateUser(WearDetail wearDetail);

    @Delete // 데이터 삭제
    void setDeleteUser(WearDetail wearDetail);

}
