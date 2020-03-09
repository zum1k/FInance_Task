package dao.checker.client;

import dao.checker.Checker;
import dao.mapper.ClientMapper;
import dao.mapper.impl.ClientMapperImpl;
import entity.Client;

public class CheckerByLoginImpl implements Checker {
    private String login;

    public CheckerByLoginImpl(String login) {
        this.login = login;
    }

    @Override
    public boolean check(String string){
    ClientMapper clientMapper = new ClientMapperImpl();
    Client client = clientMapper.toClient(string);
        return login.equals(client.getLogin());
    }
}
