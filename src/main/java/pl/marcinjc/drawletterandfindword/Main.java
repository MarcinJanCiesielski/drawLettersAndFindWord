package pl.marcinjc.drawletterandfindword;

import java.io.IOException;
import java.util.Set;

public class Main {

    /*
        Mianowicie jezeli posiadam plik (slownik jezyka angielskiego) jak wgrac go do programu rzeby byl przechowywany jako Array.
        Pisze prace zaliczeniowa na 1 semestrze I mam napisac program, ktory bedzie pytal uzytkownika czy chce spolgloske czy samogloske.
        Po wyborze java ma wylosowac odpowiednio samogloske lub spolgoska (I tak 8 razy).
        Potem program powinien z tych 8 liter utworzyc jak najdluzsze slowa.
        wlasnie tu pojawia sie potrzeba zaladowania slownika do programu. Nasz wykladowca zaproponowal nam uzycie Arrays.
        Czy wiecie jak to zrobic? Przepraszam jesli wybralem zly temat lekcji
     */

    public final static String filePath = "X:\\pl_PL.dic";

    public static void main(String[] args) throws IOException {
        Character[] listOfChars = new Character[8]; //new Character[]{'a','e','i','k','s','p','r','t'};
        DrawLetter dl = new DrawLetter();
        for (int i = 0; i < 8; i++) {
            Character letter= dl.drawLetter();
            listOfChars[i] = letter;
        }
        System.out.print("\n\nWylosowano następujące litery: ");
        for(char ch:listOfChars){
            System.out.print(""+ch+", ");
        }
        System.out.println("");

        FindWord fw = new FindWord(listOfChars, filePath);
        Set<String> words = fw.findWords();

        if(words.isEmpty()){
            System.out.println("Nie znaleziono słów zawierających wszystkie litery");
        } else {
            System.out.println("Liczba słów zawierająca wszystkie liery to: " + words.size());
            System.out.println("Najdłuższe słowo to: " + findTheLongestWord(words));
        }

    }

    protected static String findTheLongestWord(Set<String> words){
        int wordLength=0;
        String longestWord = null;

        for(String word: words){
            int tempLength = word.length();
            if(tempLength > wordLength) {
                wordLength = tempLength;
                longestWord = word;
            }
        }
        return longestWord;
    }
}
