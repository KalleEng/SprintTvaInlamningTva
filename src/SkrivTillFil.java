import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SkrivTillFil {
    public void skrivKundTillFil(Kund kund, String filnamn) {
        //Try-with-resources för att skriva säkert till fil, append mode satt till true för att lägga till i filen och inte skriva över.
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filnamn, true))) {
            //Skriver en sträng med indata och lägger till i fil
            wr.write(kund.getPersonNummer() + ", " + kund.getNamn() + ", " + LocalDate.now());
            wr.newLine();


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fel " + e.getMessage());
        }
    }
}

