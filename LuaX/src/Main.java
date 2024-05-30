import analizador.cvs.ParseException;
import analizador.cvs.LuaParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) {

        String filePath = "test.txt";

        try {
            InputStream inputStream = new FileInputStream(filePath);
            LuaParser parser = new LuaParser(inputStream);

            try {
                parser.Chunk();
                System.out.println("LUA Syntaxis Accepted. No error detected.");
            } catch (ParseException e) {
                System.out.println("Syntax Error found: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
    }
}

