package JavaModule01.ex00;

import java.util.UUID;

public class User {
    private int id;
    private String name;
    private long balance;

    public User(int id, String name, long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }

        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getBalance(){
        return balance;
    }
    public void setBalance(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }
        this.balance = balance;
    }
}
