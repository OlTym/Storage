import Model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String file = "storage.txt";

        FileStorage storage = new FileStorage(file);


        User alex = new User("Alex", 22);
        User ben = new User("Ben", 25);
        User victor = new User("Victor", 30);
        User mary = new User("Mary", 27);
        User dina = new User("Dina", 35);

        storage.addUser(alex);
        storage.addUser(ben);
        storage.addUser(victor);
        storage.addUser(mary);
        storage.addUser(dina);

        List<User> users = storage.getAllUsers();
        System.out.println(users);

        storage.removeUser(mary.getID());
        users = storage.getAllUsers();
        System.out.println(users);

        storage.removeUserByName("Alex");
        users = storage.getAllUsers();
        System.out.println(users);

        ben.setAge(40);
        storage.updateUser(ben);
        users = storage.getAllUsers();
        System.out.println(users);

        User user = storage.getUser(dina.getID());
        System.out.println(user.toString());

        storage.removeAll();

    }
}
