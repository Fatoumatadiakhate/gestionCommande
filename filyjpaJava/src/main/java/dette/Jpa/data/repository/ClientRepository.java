package dette.Jpa.data.repository;

import dette.Jpa.data.entities.Client;

import dette.Jpa.core.repository.Repository;

public interface ClientRepository  extends Repository<Client>{
    Client selectByTelephone(String telephone);
    Client selectBySurname(String surname);
}
