import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner-objekt för att ta emot indata från användare
        Scanner scan = new Scanner(System.in);

        System.out.println("Sök på namn eller personnummer: ");
        String kundSök = scan.nextLine().trim();

        KundSökning kundSökning = new KundSökning();
        kundSökning.sökOchHanterKund(kundSök);

    }
}