package pl.coderslab.gabinet_fizjoterapii.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;

public class Reserve {

    private LocalDate dateFrom;

    private LocalDate dateUntil;

    @Range(max = 1, message = "1 patient allowed")
    private int persons;

    private boolean isPossible;

    public boolean isPossible() {
        return isPossible;
    }

    public void setPossible(boolean possible) {
        isPossible = possible;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(LocalDate dateUntil) {
        this.dateUntil = dateUntil;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
}
