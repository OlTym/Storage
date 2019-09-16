package Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UsersStorage {

    static int id = 0;

    @SerializedName("Users")
    private List<User> list = new ArrayList<>();


    public void add(User user) {


        user.setID(GeneratorID.newGuid());

        list.add(user);

    }

    public List<User> getList() {
        return list;

    }


    @Override
    public String toString() {
        return "Users{" +
                "list=" + list +
                '}';
    }


    public void delete(int index) {
        list.remove(list.get(index));
    }

    public void update(int index, User user) {
        list.set(index, user);
    }
}


