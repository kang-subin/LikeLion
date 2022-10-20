package domein;

public class User { //slecet 문을 실행하여 얻은 rs객체에 담긴 값을 가져올때 사용되는 객체
String id;
String name;
String password;

public User(String id, String name, String password){
    this.id = id;
    this.name = name;
    this.password = password;
}

    public String getId(){
    return id;
}
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
}
