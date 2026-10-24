package JavaModule01.ex00;

public class Program {
    public static void main(String[] args) {
        User sender = new User(1, "mohammed", 500);
        User recipient = new User(2, "anas", 200);

        Transaction debit = new Transaction(
                Transaction.generateId(),
                recipient,
                sender,
                Transaction.Category.debits,
                -100
        );

        Transaction credit = new Transaction(
                Transaction.generateId(),
                recipient,
                sender,
                Transaction.Category.credits,
                100
        );

        System.out.println("Sender: " + sender.getName());
        System.out.println("Sender balance: " + sender.getBalance());
        System.out.println("Recipient: " + recipient.getName());
        System.out.println("Recipient balance: " + recipient.getBalance());

        System.out.println("Debit ID: " + debit.getId());
        System.out.println("Debit amount: " + debit.getTransferAmount());
        System.out.println("Credit ID: " + credit.getId());
        System.out.println("Credit amount: " + credit.getTransferAmount());
    }
}