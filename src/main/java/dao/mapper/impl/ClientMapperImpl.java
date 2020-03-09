package dao.mapper.impl;

import dao.mapper.ClientMapper;
import entity.Client;

public class ClientMapperImpl implements ClientMapper {
    public static final String SPLITERATOR = " ";
    public static final int ID_INDEX = 0;
    public static final int LOGIN_INDEX = 1;
    public static final int PASSWORD_INDEX = 2;


    @Override
    public String toString(Client client) {
        return client.getId() + SPLITERATOR + client.getLogin()+ SPLITERATOR + client.getPassword();
    }

    @Override
    public Client toClient(String string) {
        if(string == null) {
            return null;
        }
        String[] strings = string.split(SPLITERATOR);
        Client client = new Client();
        client.setId(Integer.parseInt(strings[ID_INDEX]));
        client.setLogin(strings[LOGIN_INDEX]);
        client.setPassword(strings[PASSWORD_INDEX]);

        return client;
    }
}
