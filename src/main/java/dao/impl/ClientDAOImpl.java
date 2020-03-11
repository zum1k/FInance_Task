package dao.impl;

import dao.ClientDAO;
import dao.checker.Checker;
import dao.checker.client.CheckerByLoginImpl;
import dao.checker.client.CheckerByLoginPassword;
import dao.exception.DAOException;
import dao.filemanager.FileManager;
import dao.filemanager.FileManagerImpl;
import dao.mapper.ClientMapper;
import dao.mapper.impl.ClientMapperImpl;
import entity.Client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientDAOImpl implements ClientDAO {
    private static final String FILEPATH = "src/main/resources/Clients.txt";
    private static final int FIRST_INDEX = 0;

    @Override
    public Client getByLoginPassword(String login, String password) {
        FileManagerImpl fileManager = new FileManagerImpl();
        Checker checker = new CheckerByLoginPassword(login, password);
        List<String> strings;
        Client client;
        strings = fileManager.readStrings(checker, FILEPATH);
        ClientMapperImpl clientMapper = new ClientMapperImpl();
        if(strings.size()==0){
            System.out.println("В файле ничего нет");
            return null;

        }
        client = clientMapper.toClient(strings.get(FIRST_INDEX));
        return client;

    }

    @Override
    public boolean isExistsByLogin(String login) {
        FileManagerImpl fileManager = new FileManagerImpl();
        Checker checker = new CheckerByLoginImpl(login);
        List<String> strings;
        boolean result = false;
        strings = fileManager.readStrings(checker, FILEPATH);
        if (strings.size() > FIRST_INDEX) {
            result = true;
        }
        return result;
    }

    @Override
    public void register(Client client) {
        client.setId(calcID());
        ClientMapperImpl clientMapper = new ClientMapperImpl();
        String string = clientMapper.toString(client);
        FileManager fileManager = new FileManagerImpl();
        try {
            fileManager.writeString(string, FILEPATH);
        } catch (IOException ex) {
            throw new DAOException("Данного файла нет: " + FILEPATH, ex);
        }
    }
    private int calcID(){
        int res = 0;
        try {
            Scanner in = new Scanner(new File(FILEPATH));
            List<String> strings  = new ArrayList<>();
            while (in.hasNextLine()) {
                if (in.hasNextLine()) {
                    strings.add(in.nextLine());
                }
            }
            if (strings.isEmpty()) {
                return 1;
            }
            ClientMapper clientMapper = new ClientMapperImpl();
            res = clientMapper.toClient(strings.get(strings.size()-1)).getId();
        } catch (IOException e) {
            throw new DAOException("Ошибка чтения " , e);
        }
        return res+1;
    }
}
