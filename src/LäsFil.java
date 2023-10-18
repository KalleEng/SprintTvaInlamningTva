import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LäsFil {
    public List<Kund> läsKunderFrånFil(String filnamn) {
        List<Kund> kunder = new ArrayList<>();

        //Try-with-resources för säker läsning från fil.
        try (BufferedReader br = new BufferedReader(new FileReader(filnamn))) {
            String rad;
            //Loop som går igenom inmatad fil. Första delen läser första raden i filen, lägger in i array och splittar upp där ", " uppkommer
            while ((rad = br.readLine()) != null) {
                String[] delar = rad.split(", ");
                String personNummer = delar[0].trim();
                String namn = delar[1].trim();
                //Läser nästa rad och parsear datum
                rad = br.readLine();
                LocalDate senastBetaldaDatum = LocalDate.parse(rad.trim());
                //Konverterar till nytt Kund-objekt
                kunder.add(new Kund(personNummer, namn, senastBetaldaDatum));
            }
            //Kastar StackTrace och felmeddelande om t.ex fil inte finns, en dataström inte stängs.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fel " + e.getMessage());
        }

        return kunder;
    }
}
