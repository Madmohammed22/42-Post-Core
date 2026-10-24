package JavaModule01.ex00;

import java.util.UUID;

public class Transaction {
    public enum Category {
        debits,
        credits
    }
    String id;
    User recipient;
    User sender;
    long transferAmount;
    Category category;

    public Transaction(String id, User recipient, User sender, Category category, long transferAmount) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        setCategory(category);
        setTransferAmount(transferAmount);
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public User getRecipient() {
        return recipient;
    }
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category)
    {
        if (category == null) {
            throw new IllegalArgumentException(
                    "Category cannot be null"
            );
        }
        this.category = category;
    }
    public long getTransferAmount(){
        return transferAmount;
    }
    public void setTransferAmount(long transferAmount) {

        if (category == null) {
            throw new IllegalStateException(
                    "Set the category before the amount"
            );
        }

        if (category == Category.debits && transferAmount >= 0) {
            throw new IllegalArgumentException(
                    "Debit amount must be negative"
            );
        }

        if (category == Category.credits && transferAmount <= 0) {
            throw new IllegalArgumentException(
                    "Credit amount must be positive"
            );
        }
        this.transferAmount = transferAmount;
    }

    public boolean isValidTransactionAmount(User recipient,  User sender, long transferAmount){
        if ( sender.getBalance() <= 0 || recipient.getBalance() <= 0  ){
            return false;
        }

        if ( transferAmount <= 0 || sender.getBalance() < transferAmount){
            return false;
        }

        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
        return true;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
