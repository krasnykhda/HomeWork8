package model;
public class Client{
    private String name;
    private String id;
    private  String age;
    public Client(String name,String id, String age){
        this.name=name;
        this.id=id;
        this.age=age;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public boolean equals(Client client) {
        if (client.id.equals(this.id)) {
            return true;
        } else return false;
    }
}