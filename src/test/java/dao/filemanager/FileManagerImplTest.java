package dao.filemanager;

import dao.checker.Checker;
import dao.checker.client.CheckerByLoginImpl;
import dao.exception.DAOException;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileManagerImplTest {
    @Test(expected = Exception.class)
    public void readString_Exception() throws Exception{
        //given
        FileManager fileManager = new FileManagerImpl();
        Checker checker = new CheckerByLoginImpl("login");

        //when
        fileManager.readStrings(checker, "123");
    }
}
