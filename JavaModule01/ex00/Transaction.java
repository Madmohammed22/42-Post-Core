package JavaModule01.ex00;

import java.util.UUID;

public class Transaction {
    UUID id;
    User recipient;
    User sender;
    boolean category;
    long balance;

    public Transaction(UUID id, User recipient, User sender, boolean category) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
    }       

    public void setId(UUID id){
        this.id = id;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setCategory(boolean category) {
        this.category = category;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }
    public Boolean getCategory(){
        return this.category;
    }

    public long getBalance(){
        return balance;
    }

}
