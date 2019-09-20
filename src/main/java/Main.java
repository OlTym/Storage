import Model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String file = "storage.txt";

        FileStorage storage = new FileStorage(file);

        System.out.println("Clear the storage");
        storage.removeAll();


        System.out.println("Add users into the storage");
        storage.addUser(new User("Alex", 22));
        storage.addUser(new User("Ben", 25));
        storage.addUser(new User("Victor", 30));
        storage.addUser(new User("Mary", 27));
        storage.addUser(new User("Dina", 35));

        List<User> users = storage.getAllUsers();
        System.out.println("Users list\n" + users);
        System.out.println("===============================================");

        System.out.println("Remove user by id=" + users.get(3).getID() + " named " + users.get(3).getName());
        storage.removeUser(users.get(3).getID());
        users = storage.getAllUsers();
        System.out.println("Users list\n" + users);
        System.out.println("===============================================");

        System.out.println("Remove user by named " + users.get(3).getName());
        storage.removeUserByName(users.get(3).getName());
        users = storage.getAllUsers();
        System.out.println("Users list\n" + users);
        System.out.println("===============================================");

        System.out.println("Get user id=" + users.get(2).getID());
        User user = storage.getUser(users.get(2).getID());
        System.out.println(user);

        System.out.println("Update user named " + user.getName());
        user.setAge(40);
        storage.updateUser(user);
        users = storage.getAllUsers();
        System.out.println("Users list\n" + users);
        System.out.println("===============================================");
    }
}
