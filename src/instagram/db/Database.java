package instagram.db;

import instagram.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users=new ArrayList<>();
    public Database(){

    }

    public Database(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
