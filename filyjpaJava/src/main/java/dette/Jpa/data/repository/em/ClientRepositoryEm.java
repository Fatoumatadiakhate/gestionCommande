package dette.Jpa.data.repository.em;

import javax.persistence.NoResultException;

import dette.Jpa.data.entities.Client;

import dette.Jpa.core.repository.impl.RepositoryEmImpl;
import dette.Jpa.data.repository.ClientRepository;
import dette.Jpa.data.repository.UserRepository;

public class ClientRepositoryEm extends RepositoryEmImpl<Client> implements ClientRepository {
    UserRepository userRepository;

    public ClientRepositoryEm(UserRepository userRepository) {
        super(Client.class);
        this.userRepository = userRepository;
    }

    @Override
    public Client selectByTelephone(String telephone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByTelephone'");
    }

    @Override
    public Client selectBySurname(String surname) {
        try {
            return em.createQuery("SELECT u FROM Client u WHERE u.surname = :name", Client.class)
                    .setParameter("name", surname)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
