package JavaModule01.ex01;

public class User {
    private final int id;
    public User() {
        this.id = UserIdsGenerator.getInstance()
                .generateId();
    }

    public int getLastId() {
        return id;
    }


}
