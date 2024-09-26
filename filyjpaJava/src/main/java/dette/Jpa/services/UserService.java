package dette.Jpa.services;

import java.util.List;

import dette.Jpa.data.entities.User;

public interface UserService {

    public void createUser(User user) ;
    public List<User> findAllUser();
}
