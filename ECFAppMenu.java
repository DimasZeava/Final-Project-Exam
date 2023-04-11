package UTSBahasaPemrograman;
import java.util.Scanner;

public class ECFAppMenu {
    public void menu(){
    int choose, choose1, fui, mui, count, total, purchase, jml;
    String buy;
    boolean found;
    mui = 10;
    fui = 5;
    total = 0;
    ECFItem item[] = new ECFItem[mui];
    ECFUser u = new ECFUser("Dimas Irmansyah", "22082010088");
    item[0] = new ECFItem("ETES Laskar Table - Wood type","ETLT100",950000);
    item[1] = new ECFItem("IKEA Hemnes Table - Wood Type","IKHT100",1200000);
    item[2] = new ECFItem("IKEA Nordkisa Table - Wood Type","IKNT100",999000);
    item[3] = new ECFItem("IKEA Nordkisa Table - Bamboo Type","IKNT101",94000);
    item[4] = new ECFItem("IKEA Vedbo Chair - Blue Variant","IKVC120",999000);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
            """
                    ===================================
                    Welcome to E-Commerce Furniture App
                    ===================================
                    1. Admin User
                    2. Customer User
                    3. Exit
                    ===================================
                    """
        );
            choose = sc.nextInt();
            System.out.println("");
                switch(choose){
                    case 1 :
                    do{
                    System.out.println("""
                            =============================
                                    Welcome Admin
                            =============================
                            1. Add item
                            2. Delete item
                            3. Update item
                            4. View current item
                            6. Exit
                            =============================
                            """);
                            choose = sc.nextInt();
                            switch(choose){
                                case 1:
                                System.out.println("Add Item");
                                if(fui < mui){
                                    System.out.println("Add new item");
                                    String itemname = sc.next();
                                    String itemID = "";
                                    boolean available;
                                    do{
                                        System.out.println("Input The ID item");
                                        itemID = sc.next();
                                        available = false;
                                        for(int i = 0; i < fui; i++){
                                            if(item[i].getItemID().equalsIgnoreCase(itemID)){
                                                available = true;
                                                break;
                                            }
                                        }
                                        if(available){
                                            System.out.println(" The Item is available for now");
                                        }
                                    }while(available == true);
                                    System.out.println("Add item value");
                                    int value = sc.nextInt();
                                    item[fui] = new ECFItem(itemname, itemID, value);
                                    fui++;
                                    System.out.println("Item have been added");
                                }else{
                                    System.out.println("Storage is Full");
                                }
                                break;
                                case 2:
                                if(fui>0){
                                    System.out.println("Delete Data");
                                    System.out.println("Please input Item ID");
                                    String itemID = sc.next();
                                    found = false;
                                    for(int i = 0; i < fui; i++){
                                        if(item[i].getItemID().equalsIgnoreCase(itemID)){
                                            found = true;
                                            System.out.println("Item Found");
                                            System.out.println("Do you want to delete current data? (1.Yes/2.no)");
                                            int pilih = sc.nextInt();
                                            if(pilih == 1){
                                                item[i]=null;
                                                for(int j = i; j<fui ; j++){
                                                    if(j == fui-1)
                                                    item[j] = null;
                                                    else
                                                    item[j] = item[j+1];
                                                }
                                                fui--;
                                                System.out.println("Delete Succeded");
                                            }
                                            else 
                                            System.out.println("Cancelling Delete Data");
                                        }
                                    }
                                    if(!found){
                                        System.out.println("Item ID not found");
                                    }else{
                                        System.out.println("Item ID is currently not initialized");
                                    }
                                    break;
                                }
                                case 3 :
                                System.out.println("Update Data");
                                if(fui>0){
                                System.out.println("Please input Item ID");
                                String itemID = sc.next();
                                found = false;
                                for(int i = 0; i < fui; i++){
                                    if(item[i].getItemID().equalsIgnoreCase(itemID)){
                                        found = true;
                                        System.out.println("Item found");
                                        System.out.println("Please input new item value");
                                        int value = sc.nextInt();
                                        System.out.println("Save? (true/false)");
                                        boolean pilih = sc.nextBoolean();
                                        if(pilih==true){
                                            item[i].setItemValue(value);
                                            System.out.println("Update Succeded");
                                        }  else
                                        System.out.println("Cancelling Update Data");
                                        break;
                                                    }
                                                }if(!found){
                                                    System.out.println("Item ID not found");
                                                }
                                            }
                                            else 
                                            System.out.println("Item ID is currently not initialized");
                                            break;
                                case 4 :
                                System.out.println("View Data");
                                if(fui>0){
                                    for(int i = 0; i < fui;i++){
                                        System.out.println((i+1)+".");
                                        System.out.println(item[i].getItemName()+"\t");
                                        System.out.println(item[i].getItemID()+"\t");
                                        System.out.println(item[i].getItemValue()+"\t");
                                    }
                                }
                                else System.out.println("Item ID is currently not initialized");
                                break;
                    }
                    }while(choose!=6);
                    break;
                    case 2:
                    do{
                    System.out.println("Welcome "+u.getUsername());
                    System.out.println("UUID : " +u.getUniqueID());
                    System.out.println("""
                            =============================
                                    Customer Menu
                            =============================
                            1. View Available Product
                            2. Add to Cart
                            3. Buy
                            4. Exit
                            =============================
                            """);
                            choose1 = sc.nextInt();
                            switch(choose1){
                                case 1 :
                                System.out.println("View Available Product");
                                if(fui>0){
                                    for(int i = 0; i < fui;i++){
                                        System.out.println((i+1)+".");
                                        System.out.println(item[i].getItemName()+"\t");
                                        System.out.println(item[i].getItemID()+"\t");
                                        System.out.println(item[i].getItemValue()+"\t");
                                    }
                                }
                                else System.out.println("Item ID is currently not initialized");
                                break;
                                case 2 :
                                if(fui>0){
                                    for(int i = 0; i < fui;i++){
                                        System.out.println((i+1)+".");
                                        System.out.println(item[i].getItemName()+"\t");
                                        System.out.println(item[i].getItemID()+"\t");
                                        System.out.println(item[i].getItemValue()+"\t");
                                    }
                                }
                                boolean available;
                                do{
                                    System.out.println("Which item do you want to buy? Use ID Number");
                                    buy = sc.next();
                                    available = false;
                                    for(int i = 0; i < fui; i++){
                                        if(item[i].getItemID().equalsIgnoreCase(buy)){
                                            System.out.println("How many do you want?");
                                            count = Integer.valueOf(sc.next());
                                            total = total + (item[i].getItemValue()*count);
                                            available = true;
                                            break;
                                        }
                                    }
                                    if(available == false){
                                        System.out.println("Sorry the ID number is incorrect or the item is not available");
                                    }
                                }while(!available);
                                break;
                                case 3:
                                System.out.println("The Total you need to purchase : " + total);
                                System.out.println("Please input the nominal");
                                purchase = sc.nextInt();
                                total = purchase - total;
                                System.out.println("Your left over : " + total);
                                total = 0;
                                break;
                            }
                        }while(choose1 !=4);
            }
        }while(choose!=3);
        System.out.println("thanks using our sevice");
    }
}
