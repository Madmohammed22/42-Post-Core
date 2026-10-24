package JavaModule01.ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user = new User(UUID.randomUUID(), "mohammed", 500);
        System.out.println(user.getId() + " " + user.getName() + " " + user.getBalance());
    }
}
