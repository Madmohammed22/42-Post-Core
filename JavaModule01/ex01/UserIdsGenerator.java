package JavaModule01.ex01;

import java.util.Random;
import java.util.UUID;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int lastId = 0;

    private UserIdsGenerator() {}
    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return ++lastId;
    }

}
