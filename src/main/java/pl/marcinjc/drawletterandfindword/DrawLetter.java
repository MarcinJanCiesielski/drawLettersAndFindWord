package pl.marcinjc.drawletterandfindword;

import java.util.Random;
import java.util.Scanner;

public class DrawLetter {
    private final Character[] vowels = new Character[] {'a', 'e', 'y', 'i', 'o', 'ą', 'ę', 'u', 'ó'};
    private final Character[] consonants = new Character[] {'b', 'c', 'ć', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'ł', 'm',
            'n', 'ń', 'p', 'r', 's', 'ś', 't', 'w', 'z', 'ż', 'ź'};

    public DrawLetter(){

    }

    public Character drawLetter(){
        Scanner scanner = new Scanner(System.in);
        int whatToLookFor = 0;//starting point
        Character letter='m';

        do{
            System.out.println("Jaką literę chcesz wylosować: samogłoskę (wpisz: 1) czy spółgłoskę (wpisz: 2)!");
            System.out.print("Podaj czego szukać: ");
            whatToLookFor = scanner.nextInt();
            if(whatToLookFor==1){
                letter = drawVowel();
            } else if(whatToLookFor==2){
                letter = drawConsonant();
            }
        } while(whatToLookFor!=1 && whatToLookFor!=2);

        return letter;
    }

    private Character drawVowel() {
        Random random = new Random();
        int number = random.nextInt(vowels.length-1);
        return vowels[number];
    }

    private Character drawConsonant(){
        Random random = new Random();
        int number = random.nextInt(consonants.length-1);
        return consonants[number];
    }
}
