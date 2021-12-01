package com.example.lcheeditsource.ItemListData;

public class ItemListData {
    private int imageResourceID;
    private String ItemName;
    private int Itemprice;

    public ItemListData(int id, String Name, int Price){
        this.imageResourceID = id;
        this.ItemName = Name;
        this.Itemprice = Price;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemprice() {
        return Itemprice;
    }

    public void setItemprice(int itemprice) {
        Itemprice = itemprice;
    }
}
