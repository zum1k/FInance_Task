package dao.filemanager;

import dao.checker.Checker;
import dao.exception.DAOException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerImpl implements FileManager {

    public FileManagerImpl() {
    }

    @Override
    public List<String> readStrings(Checker checker, String filename) {
        List<String> list = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (checker.check(line)) {
                    list.add(line);
                }
            }
        } catch (IOException ex) {
            throw new DAOException("Ошибка чтения ", ex);
        }
        return list;
    }

    @Override
    public void writeString(String string, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write("\n" + string + "\n");
        } catch (IOException ex) {
            throw new DAOException("Ошибка записи: ", ex);
        }
    }

}
