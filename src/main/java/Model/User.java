package Model;

import com.google.gson.annotations.SerializedName;

public class User {

    private int id;
    @SerializedName("Name")
    private String name;
    private int age;

    public User(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public int getID() {
        return id;
    }

    void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("user{");
        sb.append("id='").append(id).append('\'');
        sb.append(", Name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append("}").append("\n");
        return sb.toString();
    }


}
