import Model.User;
import Model.UsersStorage;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileStorage implements Storage {

    private String nameFile;
    private WorkerFile workerFile;
    private UsersStorage usersStorage;

    public FileStorage(String nameFile) {
        final String pathDir = ".\\Storage\\";
        this.nameFile = pathDir + nameFile;
        workerFile = new WorkerFile(this.nameFile);
        workerFile.creatDirectory(pathDir);
        usersStorage = new UsersStorage();
    }


    @Override
    public void removeAll() {
        List<User> list = getListUsers();

        if (list != null) {
            list.clear();
            workerFile.deleteFile();
        } else {
            System.out.println("The storage is empty");
        }

    }

    @Override
    public void removeUser(int id) {
        boolean remove = false;

        List<User> list = getListUsers();
        if (list != null) {
            for (User user : list) {
                if (user.getID() == id) {
                    usersStorage.delete(list.indexOf(user));
                    workerFile.saveToStorage(usersStorage);
                    System.out.println("This user is removed successfully");
                    remove = true;
                    break;
                }
            }
        } else {
            System.out.println("This storage is empty");
        }
        if (!remove) {
            System.out.println("This user is not in this storage ");
        }
    }

    @Override
    public void removeUserByName(String name) {
        boolean remove = false;
        List<User> list = getListUsers();

        if (list != null) {
            for (User user : list) {
                if (user.getName().equals(name)) {
                    usersStorage.delete(list.indexOf(user));
                    workerFile.saveToStorage(usersStorage);
                    System.out.println("This user is removed successfully");
                    remove = true;
                    break;
                }
            }
        } else {
            System.out.println("This storage is empty");
        }
        if (!remove) {
            System.out.println("This user is not in this storage ");
        }
    }

    @Override
    public void addUser(User user) {


        usersStorage.add(user);
        workerFile.saveToStorage(usersStorage);
        System.out.println("This user is added successfully");
    }

    @Override
    public void updateUser(User user) {
        boolean update = false;
        List<User> list = getListUsers();
        if (list != null) {

            for (User us : list) {
                if (us.getID() == user.getID()) {
                    usersStorage.update(list.indexOf(us), user);
                    workerFile.saveToStorage(usersStorage);
                    System.out.println("This user is updeted successfully");
                    update = true;
                    break;
                }
            }
        } else {
            System.out.println("This storage is empty");
        }
        if (!update) {
            System.out.println("This user is not in this storage ");
        }
    }

    @Override
    public User getUser(int id) {
        List<User> list = getListUsers();
        int index = -1;
        if (list != null) {
            for (User user : list) {
                if (user.getID() == id) {
                    index = list.indexOf(user);
                    break;
                }
            }
        } else {
            System.out.println("This storage is empty");
        }
        if (index == -1) {
            System.out.println("This user is not in this storage ");
            return null;
        } else {
            return list.get(index);
        }


    }

    @Override
    public List<User> getAllUsers() {

        return getListUsers();
    }


    private List<User> getListUsers() {
        String json = null;
        UsersStorage restoredStorage = null;

        if (Files.exists(Paths.get(this.nameFile)) && Files.isRegularFile(Paths.get(this.nameFile))) {
            json = workerFile.readFromFile();
        }

        if (json != null) {
            Gson gson = new Gson();
            restoredStorage = gson.fromJson(json, UsersStorage.class);
            return restoredStorage.getList();
        }

        return null;

    }

}
