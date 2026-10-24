package JavaModule01.ex00;

import javax.xml.namespace.QName;
import java.util.UUID;

public class User {
    UUID id;
    String name;
    long balance;

    public User(UUID id, String name, long balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public long getBalance(){
        return balance;
    }
}
