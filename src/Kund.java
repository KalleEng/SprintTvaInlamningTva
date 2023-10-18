import java.time.LocalDate;

public class Kund {
    private String personNummer;
    private String namn;
    private LocalDate senastBetaldaDatum;

    public Kund(String personNummer, String namn, LocalDate senastBetaldaDatum) {
        this.personNummer = personNummer;
        this.namn = namn;
        this.senastBetaldaDatum = senastBetaldaDatum;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public String getNamn() {
        return namn;
    }

    //Boolean som returnerar om senaste betalda datumet är mindre än ett år sedan från dagens datum
    public boolean ärNuvarandeMedlem() {
        LocalDate ettÅrTillbaka = LocalDate.now().minusYears(1);
        return !senastBetaldaDatum.isBefore(ettÅrTillbaka);
    }
    //Boolean som returnerar om senaste betalda datumet är mer än ett år sedan från dagens datum
    public boolean ärFöreDettaKund() {
        return !ärNuvarandeMedlem();
    }
    //Överskriver toString-metoden för att ge en formaterad sträng för snyggare utskrift
    @Override
    public String toString() {
        return String.format("%-12s | %-20s | %s", personNummer, namn, senastBetaldaDatum);
    }
}
