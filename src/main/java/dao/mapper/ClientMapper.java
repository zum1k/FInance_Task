package dao.mapper;

import entity.Client;

public interface ClientMapper {
    String toString(Client client);

    Client toClient(String string);
}

