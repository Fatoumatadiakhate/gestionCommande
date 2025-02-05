package dette.Jpa.services.impl;

import java.util.List;

import dette.Jpa.data.entities.Client;

import dette.Jpa.data.repository.ClientRepository;
import dette.Jpa.services.ClientService;

public class ClientServiceImpl implements ClientService {
    // Couplage Faible entre le Servic et le Repository
    private ClientRepository clientRepository;

    // Injection Dependance Par Constructeur
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public void createClient(Client client) {
        clientRepository.insert(client);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.selectAll();
    }

    @Override
    public Client searchClient(String telephone) {
        return clientRepository.selectByTelephone(telephone);
    }

    @Override
    public Client searchClientBySurname(String surname) {
        return clientRepository.selectBySurname(surname);
    }

}
