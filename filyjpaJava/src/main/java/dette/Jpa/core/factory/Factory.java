package dette.Jpa.core.factory;

import dette.Jpa.data.repository.ClientRepository;
import dette.Jpa.data.repository.UserRepository;
import dette.Jpa.data.repository.em.ClientRepositoryEm;
import dette.Jpa.data.repository.em.UserRepositoryEm;


public class Factory {
    private Factory() {

    }

    private static ClientRepository clientRepository = null;
    private static UserRepository userRepository = null;

    public static ClientRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryEm(getInstanceUserRepository());
        }
        return clientRepository;
    }

    public static UserRepository getInstanceUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryEm();
        }
        return userRepository;
    }

}
