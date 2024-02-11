import java.time.LocalDate;

public class Wedding {
    private LocalDate date;
    private Couple couple;
    private String location;

    Wedding(Couple c, LocalDate d, String locationData){
        date=d;
        couple=c;
        location=locationData;
    }

    public LocalDate getDate() {
        return date;
    }

    public Couple getCouple() {
        return couple;
    }

    public String getLocation() {
        return location;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
