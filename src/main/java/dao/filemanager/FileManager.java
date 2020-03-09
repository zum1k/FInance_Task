package dao.filemanager;

import dao.checker.Checker;

import java.io.IOException;
import java.util.List;

public interface FileManager {
    List<String> readStrings(Checker checker, String filename) throws IOException;

    void writeString(String string, String filename) throws IOException;
}
