package dao;

import entity.Client;

import java.io.IOException;

public interface ClientDAO {
    Client getByLoginPassword(String login, String password);

//    Client getById(int id);

    boolean isExistsByLogin(String login);

    void register(Client client);
}
