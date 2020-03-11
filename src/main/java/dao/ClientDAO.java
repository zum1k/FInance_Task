package dao;

import entity.Client;

public interface ClientDAO {
    Client getByLoginPassword(String login, String password);

    boolean isExistsByLogin(String login);

    void register(Client client);
}
