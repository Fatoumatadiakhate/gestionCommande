package dette.Jpa.data.repository.em;

import dette.Jpa.core.repository.impl.RepositoryEmImpl;
import dette.Jpa.data.entities.User;
import dette.Jpa.data.repository.UserRepository;

public class UserRepositoryEm extends RepositoryEmImpl<User> implements UserRepository {

    public UserRepositoryEm() {
        super(User.class);
    }

    @Override
    public User selectByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        return null;
    }

}
