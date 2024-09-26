package dette.Jpa.data.repository.list;


import dette.Jpa.data.entities.Client;

import dette.Jpa.core.repository.impl.RepositoryListImpl;
import dette.Jpa.data.repository.ClientRepository;


public class ClientRepositoryList extends RepositoryListImpl<Client>  implements ClientRepository{
   
    @Override
    public Client selectByTelephone(String telephone) {
        return list.stream()
                .filter(client -> client.getTelephone().compareTo(telephone) == 0)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Client selectBySurname(String surname) {
        return list.stream()
                .filter(client -> client.getSurname().compareTo(surname) == 0)
                .findFirst()
                .orElse(null);

    }
}
