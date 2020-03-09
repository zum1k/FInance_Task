package dao.mapper.impl;

import dao.mapper.ClientMapper;
import entity.Client;
import org.junit.Assert;
import org.junit.Test;

public class ClientMapperImplTest {
    @Test
    public void toString_Client_String(){
        //given
        ClientMapper clientMapper = new ClientMapperImpl();
        Client client = new Client();
        client.setId(1);
        client.setLogin("testLogin");
        client.setPassword("testPassword");

        //when
        String result =  clientMapper.toString(client);

        //then
        Assert.assertEquals("1 testLogin testPassword", result);
    }

    @Test
    public void toClient_String_Client(){
        //given
        ClientMapper clientMapper = new ClientMapperImpl();
        String value = "1 login password";
        Client client = new Client();
        client.setId(1);
        client.setLogin("login");
        client.setPassword("password");

        //when
        Client result = clientMapper.toClient(value);

        //then
        Assert.assertEquals(client, result);

    }
}

