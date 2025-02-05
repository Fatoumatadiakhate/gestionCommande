package dette.Jpa.view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dette.Jpa.data.entities.Client;

import dette.Jpa.core.factory.Factory;
import dette.Jpa.data.entities.User;
import dette.Jpa.data.enums.RoleEnum;
import dette.Jpa.data.fily.impl.ClientDto;
import dette.Jpa.services.ClientService;
import dette.Jpa.services.UserService;
import dette.Jpa.services.impl.ClientServiceImpl;
import dette.Jpa.services.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);

        

        ClientService clientServiceImpl = new ClientServiceImpl(
                Factory.getInstanceClientRepository());

        UserService userServiceImpl = new UserServiceImpl(Factory.getInstanceUserRepository());

        Client client;
        do {
            System.out.println("1-Creer Client");
            System.out.println("2-Lister Client");
            System.out.println("3-Rechercher  Client Par Telephone");
            System.out.println("4-Creer un Compte User");
            System.out.println("5-Lister les comptes User");
            System.out.println("6-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    // Entite
                    client = new Client();
                    System.out.println("Entrer le surnom");
                    String surname = scanner.nextLine();
                    if (clientServiceImpl.searchClientBySurname(surname) != null) {
                        System.out.println("Le surname esxiste deja");
                    } else {
                        client.setSurname(surname);
                        System.out.println("Entrer le Telephone");
                        client.setTelephone(scanner.nextLine());
                        System.out.println("Entrer l'adresse");
                        client.setAdresse(scanner.nextLine());
                        System.out.println("Voulez vous associez un compte a ce client O/N");
                        char res = scanner.next().charAt(0);
                        scanner.nextLine();
                        if (res == 'O') {
                            User user = new User();
                            System.out.println("Entrer Nom ");
                            user.setNom(scanner.nextLine());
                            System.out.println("Entrer le Prenom");
                            user.setPrenom(scanner.nextLine());
                            System.out.println("Entrer le Login");
                            user.setLogin(scanner.nextLine());
                            System.out.println("Entrer le Password");
                            user.setPassword(scanner.nextLine());
                            user.setRole(RoleEnum.CLIENT);
                            client.setUser(user);
                        }

                        clientServiceImpl.createClient(client);

                    }
                   

                    break;
                case 2:
                    List<ClientDto> list = new ClientDto().toListDto( clientServiceImpl.findAllClient());
                    list.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Entrer le Telephone");
                    String tel = scanner.nextLine();
                    client = clientServiceImpl.searchClient(tel);
                    if (client == null) {
                        System.out.println("Pas de client");
                    } else {
                        System.out.println(client);
                    }

                    break;
                case 4:
                    break;

                case 5:
                    List<User> listUsers = userServiceImpl.findAllUser();
                    listUsers.forEach(System.out::println);
                    break;

                default:
                    break;
            }

        } while (choix != 6);

        scanner.close();
    }
}