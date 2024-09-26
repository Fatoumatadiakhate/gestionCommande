package dette.Jpa.data.repository.list;



import dette.Jpa.core.repository.impl.RepositoryListImpl;
import dette.Jpa.data.entities.User;
import dette.Jpa.data.repository.UserRepository;

public class UserRepositoryList extends RepositoryListImpl<User> implements UserRepository {

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByLogin'");
    }

    @Override
    public User selectByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    } 

}
