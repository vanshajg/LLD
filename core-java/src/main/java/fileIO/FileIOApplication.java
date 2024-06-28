package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class FileIOApplication implements Serializable {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("hello.txt");
        test();
    }

    private static void test() throws FileNotFoundException {
        throw new FileNotFoundException("File not found");
    }
}
