package dette.Jpa.services;

import java.util.List;

import dette.Jpa.data.entities.Client;

public interface ClientService {
    void createClient(Client client);

    List<Client> findAllClient();

    Client searchClient(String telephone);

    Client searchClientBySurname(String surname);
}
