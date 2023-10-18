import java.util.List;

public class KundSökning {
    //Instansvariabler
    private LäsFil kundFil = new LäsFil();
    private SkrivTillFil tillPtFil = new SkrivTillFil();
    private boolean hittadKund = false;
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String kundInfoRubrik = String.format("%-12s | %-20s | %s", "Personnummer", "Namn", "Senast betalda datum");
    public void sökOchHanterKund(String kundSök){
        System.out.println(kundInfoRubrik);

        //Läser in kund från fil till List
        List<Kund> kundLista = kundFil.läsKunderFrånFil("src/kund.txt");

        //Itererar genom listan för att hitta matchande namn eller personnummer
        for (Kund kund : kundLista) {
            if (kund.getNamn().equalsIgnoreCase(kundSök) || kund.getPersonNummer().equals(kundSök)) {
                hittadKund = true;
                if (kund.ärNuvarandeMedlem()) {
                    //Skriver till fil om kund har betalat
                    tillPtFil.skrivKundTillFil(kund, "src/dagligTräning.txt");
                    System.out.println(kund + ANSI_GREEN + " - Nuvarande kund" + ANSI_RESET);
                } else if (kund.ärFöreDettaKund()) {
                    System.out.println(kund + ANSI_YELLOW + " - Före detta kund" + ANSI_RESET);
                }
                break;
            }
        }
        //Utskrift för ej hittad kund
        if (!hittadKund) {
            System.out.println(ANSI_RED + "Obehörig kund" + ANSI_RESET);
        }
    }
}