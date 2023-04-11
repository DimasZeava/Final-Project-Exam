package UTSBahasaPemrograman;

public class ECFItem {
    private String itemName;
    private String itemID;
    private int itemValue;

    ECFItem(String ina, String iid, int iv){
        itemName = ina;
        itemValue = iv;
        itemID = iid;
        System.out.println("Creating Name and Value of Item...");
    }
    
    public void setItemName(String sina){
        itemName = sina;
    }
    public void setItemID(String sid){
        itemID = sid;
    }
    public void setItemValue(int siv){
        itemValue = siv;
    }
    public String getItemName(){
        return itemName;
    }
    public String getItemID(){
        return itemID;
    }
    public int getItemValue(){
        return itemValue;
    }
}
