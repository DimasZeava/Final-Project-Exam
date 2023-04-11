package UTSBahasaPemrograman;
public class ECFUser {
    private String username, uniqueID;
    
    ECFUser(String un, String uuid){
        username = un;
        uniqueID = uuid;
        System.out.println("Creating User...");
    }

    public void setUsername(String sun){
        username = sun;
    }
    public void setUniqueID(String suuid){
        uniqueID = suuid;
    }
    public String getUsername(){
        return username;
    }
    public String getUniqueID(){
        return uniqueID;
    }
}
