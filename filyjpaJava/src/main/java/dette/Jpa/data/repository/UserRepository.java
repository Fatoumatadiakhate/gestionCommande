package dette.Jpa.data.repository;

import dette.Jpa.core.repository.Repository;
import dette.Jpa.data.entities.User;

public interface UserRepository extends Repository<User> {
    User selectByLogin(String login);
    User selectByID(int id);
}
