package instagram.service;

import instagram.model.User;

import java.util.List;

public interface UserService {
    String addNewUser(User user);
    List<User>getAllUsers();
    void userUpdateById(Long id,String nickName,String password,String photo);
    User searchByName(String nickName);
    User sortByAge();
    User filter(int age);
}

