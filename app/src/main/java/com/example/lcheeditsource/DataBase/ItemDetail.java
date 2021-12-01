package com.example.lcheeditsource.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ElectItemDetails")
public class ItemDetail implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int DetailsCode = 0;


    private String Item;

    private String Processor1 = "퀄컴스냅드래곤 662";
    private int ProcessorCost1 = 60;

    private String Processor2 = "Apple M1";
    private int ProcessorCost2 = 85;

    public int getDetailsCode() {
        return DetailsCode;
    }

    public void setDetailsCode(int detailsCode) {
        DetailsCode = detailsCode;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getProcessor1() {
        return Processor1;
    }

    public void setProcessor1(String processor1) {
        Processor1 = processor1;
    }

    public int getProcessorCost1() {
        return ProcessorCost1;
    }

    public void setProcessorCost1(int processorCost1) {
        ProcessorCost1 = processorCost1;
    }

    public String getProcessor2() {
        return Processor2;
    }

    public void setProcessor2(String processor2) {
        Processor2 = processor2;
    }

    public int getProcessorCost2() {
        return ProcessorCost2;
    }

    public void setProcessorCost2(int processorCost2) {
        ProcessorCost2 = processorCost2;
    }
}
