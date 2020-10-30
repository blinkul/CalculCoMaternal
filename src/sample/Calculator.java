package sample;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Calculator {

    private final int ZILE_PRENATAL = 126;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    private LocalDate ziuaPreconizataNastere;
    private LocalDate ziuaConcediuPrenatal;

    public Calculator(LocalDate ziuaPreconizataNastere, LocalDate ziuaConcediuPrenatal) {
        this.ziuaPreconizataNastere = ziuaPreconizataNastere;
        this.ziuaConcediuPrenatal = ziuaConcediuPrenatal;

    }

    public String calculate() {
        long daysPrenatal = getZilePrenatalByCoDate(ziuaConcediuPrenatal);
        long daysPostnatal = calculeazaZilePostNatal(ziuaConcediuPrenatal);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Pentru un concediu prenatal luat in data %s ", dtf.format(ziuaConcediuPrenatal)));
        sb.append(String.format("vor ramane %s zile concediu prenatal ", daysPrenatal));
        sb.append(String.format("si %s zile concediu postnatal.", daysPostnatal));
        sb.append("\n\n");
        sb.append(String.format("Zile prenatal: %s", daysPrenatal));
        sb.append("\n");
        sb.append(String.format("Zile postnatal: %s", daysPostnatal));

        return sb.toString();
    }

    /*
        Calculeaza Data la care trebuie sa intrii in co, daca vrei N zile de co prenatal
     */
    private LocalDate calculZiuaInCareTrebuieSaIauCoCaSaAmXZileCo(long zileCoPrenatal) {
        return ziuaPreconizataNastere.minusDays(zileCoPrenatal);
    }

    /*
        Calculeaza numarul de zile de prenatal daca iau CO in ziua x
     */
    private long getZilePrenatalByCoDate(LocalDate coDate) {
        return ChronoUnit.DAYS.between(coDate, ziuaPreconizataNastere);
    }

    /*
        Calculeaza numarul de zile ramase dupa nastere in functie de CO Date
     */
    private long calculeazaZilePostNatal(LocalDate coDate) {
        return ZILE_PRENATAL - ChronoUnit.DAYS.between(coDate, ziuaPreconizataNastere);
    }

}
