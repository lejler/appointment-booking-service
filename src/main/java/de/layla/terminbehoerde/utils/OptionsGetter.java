package de.layla.terminbehoerde.utils;

import org.openqa.selenium.By;

import java.time.Month;
import java.util.ArrayList;

public class OptionsGetter {

    private static final String calendarUrl = "https://service.berlin.de/terminvereinbarung/termin/tag.php?termin=1&anliegen[]=120703&dienstleisterlist=122210,122217,327316,122219,327312,122227,327314,122231,327346,122238,122243,327348,122254,331011,349977,122252,329742,122260,329745,122262,329748,122271,327278,122273,327274,122277,327276,330436,122280,327294,122282,327290,122284,327292,122291,327270,122285,327266,122286,327264,122296,327268,150230,329760,122297,327286,122294,327284,122312,329763,122314,329775,122304,327330,122311,327334,122309,327332,317869,122281,327352,122279,329772,122283,122276,327324,122274,327326,122267,329766,122246,327318,122251,327320,327653,122257,327322,122208,327298,122226,327300&herkunft=http%3A%2F%2Fservice.berlin.de%2Fdienstleistung%2F120703%2F";

    public static void main(String[] args) {
    }

    public static String[] getMonthsWithYears() {
        DriverHelper.getInstance().get(calendarUrl);
        return DriverHelper.getInstance().findElements(By.className("month"))
                .stream().map(e -> e.getAttribute("innerHTML"))
                .toArray(String[]::new);
    }

    public static ArrayList<String> getMonths() {
        ArrayList<String> months = new ArrayList<>();
        for (String entry : getMonthsWithYears()) {
            months.add(entry.replaceAll(" .*", ""));
        }
        return months;
    }

    public static ArrayList<String> getYears() {
        ArrayList<String> years = new ArrayList<>();
        for (String entry : getMonthsWithYears()) {
            String[] result = entry.split(" ");
            years.add(result[1]);
        }
        for (String y : years) {
            System.out.println(y);
        }
        return years;
    }

    public static Month convertStringToMonth(String month) {
        switch (month) {
            case "Januar":
                return Month.JANUARY;
            case "Februar":
                return Month.FEBRUARY;
            case "März":
                return Month.MARCH;
            case "April":
                return Month.APRIL;
            case "Mai":
                return Month.MAY;
            case "Juni":
                return Month.JUNE;
            case "Juli":
                return Month.JULY;
            case "August":
                return Month.AUGUST;
            case "September":
                return Month.SEPTEMBER;
            case "Oktober":
                return Month.OCTOBER;
            case "November":
                return Month.NOVEMBER;
            case "Dezember":
                return Month.DECEMBER;
            default:
                System.out.println("Invalid month");
                return null;
        }
    }

}
