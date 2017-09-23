package pl.marcinjc.drawletterandfindword;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FindWord {
    private Character[] chars;
    public final String filePath;


    FindWord(Character[] chars, String filePath){
        if(chars.length != 8){
            throw new IllegalArgumentException("Tablica powinna zawierać dokładnie 8 elementów!!!");
        }
        this.chars = chars;
        this.filePath = filePath;
    }

    public Set<String> findWords() throws IOException {
        Set<String> words = new HashSet<String>();
        String line;
        BufferedReader file = Files.newBufferedReader(Paths.get(filePath),Charset.forName("ISO-8859-2"));

        while((line = file.readLine()) != null){
            if(line.contains("/")){
                int number = line.indexOf("/");
                line = line.substring(0, number);
            }
            boolean isInLine = containsAllChars(line);

            if(isInLine){
                words.add(line);
            }
            //System.out.println(line + ", " + (isInLine?"zawiera wszysktie znaki":"NIE zawiera wszystkich znaków"));
        }

        return words;
    }

    private boolean containsAllChars(String line){
        StringBuffer linesb = new StringBuffer(line.toLowerCase());
        for (char ch: chars) {
            if(line.indexOf(ch)<0){
                return false;
            }
        }
        return true;
    }
}
