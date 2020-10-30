package sample;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Calculator {


    // SET DATES
    private final static LocalDate ZIUA_PRECONIZATA_NASTERE = LocalDate.of(2021, Month.MARCH, 9);
    private final static LocalDate ZIUA_CONCEDIU_PRENATAL = LocalDate.of(2020, Month.DECEMBER, 23);
    //----------

    //corrected

    private final static int ZILE_PRENATAL = 126;
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public void calculate() {

    }

    public static void main(String[] args) {

        long daysPrenatal = getZilePrenatalByCoDate(ZIUA_CONCEDIU_PRENATAL);
        long daysPostnatal = calculeazaZilePostNatal(ZIUA_CONCEDIU_PRENATAL);
        System.out.println("Ziua preconizata: " + dtf.format(ZIUA_PRECONIZATA_NASTERE));

        System.out.print(String.format("Daca iau co pe %s mai raman %s de zile co prenatal si %s zile co post natal.",
                dtf.format(ZIUA_CONCEDIU_PRENATAL),
                daysPrenatal,
                daysPostnatal

        ));
    }

    /*
        Calculeaza Data la care trebuie sa intrii in co, daca vrei N zile de co prenatal
     */
    private static LocalDate calculZiuaInCareTrebuieSaIauCoCaSaAmXZileCo(long zileCoPrenatal) {
        return ZIUA_PRECONIZATA_NASTERE.minusDays(zileCoPrenatal);
    }

    /*
        Calculeaza numarul de zile de prenatal daca iau CO in ziua x
     */
    private static long getZilePrenatalByCoDate(LocalDate coDate) {
        return ChronoUnit.DAYS.between(coDate, ZIUA_PRECONIZATA_NASTERE);
    }

    /*
        Calculeaza numarul de zile ramase dupa nastere in functie de CO Date
     */
    private static long calculeazaZilePostNatal(LocalDate coDate) {
        return ZILE_PRENATAL - ChronoUnit.DAYS.between(coDate, ZIUA_PRECONIZATA_NASTERE);
    }

    // CO --- X Zile PreNatal -- NASTERE -- Y zile PostNatal
}
