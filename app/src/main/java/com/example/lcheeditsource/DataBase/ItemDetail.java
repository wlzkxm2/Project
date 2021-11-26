package com.example.lcheeditsource.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ElectItemDetails")
public class ItemDetail implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int DetailsCode = 0;

    @NonNull
    private String Item;

    final private String Processor1 = "퀄컴스냅드래곤 662";
    final private int ProcessorCost1 = 60;

    final private String Processor2 = "Apple M1";
    final private int ProcessorCost2 = 85;

}
