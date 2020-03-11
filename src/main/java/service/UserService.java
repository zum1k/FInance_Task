package service;

import dao.ClientDAO;
import dao.impl.ClientDAOImpl;
import entity.Client;

public class UserService {
    public Client logIn(String login, String password) {
        ClientDAO clientDAO = new ClientDAOImpl();
        return clientDAO.getByLoginPassword(login, password);
    }

    public Client logOut() {
        return null;
    }

    public Client register(String login, String password) {
        if (isExist(login)) {
            return null;
        }
        ClientDAO clientDAO = new ClientDAOImpl();
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        clientDAO.register(client);
        return client;
    }

    private boolean isExist(String login) {
        ClientDAO clientDAO = new ClientDAOImpl();
        return clientDAO.isExistsByLogin(login);
    }

    public void exit() {
        System.out.println("До свидания.");
        System.exit(0);
    }

}
