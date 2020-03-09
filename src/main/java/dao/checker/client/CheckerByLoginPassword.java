package dao.checker.client;

import dao.checker.Checker;
import dao.mapper.ClientMapper;
import dao.mapper.impl.ClientMapperImpl;
import entity.Client;

public class CheckerByLoginPassword implements Checker {
    private String login;
    private String password;

    public CheckerByLoginPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean check(String string){
        ClientMapper clientMapper = new ClientMapperImpl();
        Client client = clientMapper.toClient(string);
        return login.equals(client.getLogin()) && password.equals(client.getPassword());
    }
}
