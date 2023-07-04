package instagram.service.serviceImpl;

import instagram.db.Database;
import instagram.model.User;
import instagram.service.UserService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Database database;

    public UserServiceImpl(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public String addNewUser(User user) {
        database.getUsers().add(user);
        return "Добавлен ";
    }

    @Override
    public List<User> getAllUsers() {
        return database.getUsers();
    }

    @Override
    public void userUpdateById(Long id, String nickName, String password, String photo) {
        List<User> users = new ArrayList<>();
        users.addAll(database.getUsers());
        users.stream()
                .filter(user -> user.getId().equals(id)).findFirst()
                .ifPresent(user -> {
                    user.setNickName(nickName);
                    user.setPassword(password);
                    user.setPhoto(photo);
                });
        System.out.println("Успешно обнавлено!!!");
    }

//        User user = getAllUsers().stream().
//                filter(user1 -> user1.getId()==id).findFirst().get();
//        user.setNickName(user.getNickName());
//        user.setPassword(user.getPassword());
//        user.setPhoto(user.getPhoto());

//        List<User> users = database.getUsers().stream().filter(user1 -> user1.getId().equals(id));
//        users.forEach(user1 -> user1.setNickName(nickName));
//        users.forEach(user1 -> user1.setPassword(password));
//        users.forEach(user1 -> user1.setPhoto(photo));

    //database.getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().ifPresent(user -> {user.setNickName(nickName);user.setPassword(password);user.setPhoto(photo);})

    @Override
    public User searchByName(String nickName) {
//        List<User> users = database.getUsers().stream().filter(user -> user.getNickName().equalsIgnoreCase(nickName)).toList();
//        User user = new User();
//        for (User u:users) {
//            if (u.getNickName().equalsIgnoreCase(nickName)){
//                u.setId(user.getId());
//                u.setNickName(user.getNickName());
//                u.setPassword(user.getPassword());
//                u.setAge(user.getAge());
//                u.setPhoto(user.getPhoto());
//                u.setGender(user.getGender());
//                return user;
//            }
//        }

        for (User u : database.getUsers()) {
            if (u.getNickName().equalsIgnoreCase(nickName)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User sortByAge() {
//        List<User> users = database.getUsers().stream().sorted().toList();
//        User user = new User();
//        for (User u:users) {
//            if (u.getAge()<0){
//                System.out.println(u);
//            }
//        }
        List<User> users = getAllUsers();
        User userBek = users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .orElse(null);
  
        return userBek;
    }

    @Override
    public User filter(int age) {
        List<User> users = database.getUsers().stream().sorted(Comparator.comparingInt(User::getAge)).toList();
        User user = new User();
        for (User u : users) {
            if (u.getAge() == age) {
                System.out.println(u);
            }
        }
        return user;
    }
}
