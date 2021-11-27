package lk.iit.ase;

import lk.iit.ase.model.Attraction;
import lk.iit.ase.model.Museum;
import lk.iit.ase.model.Park;
import lk.iit.ase.model.Theater;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        /*//create museum
        Museum museum = new Museum();
        museum.setOpenTIme(700);
        museum.setCloseTime(2000);
        museum.setCharged(true);
        museum.setChargeAmount(2.0f);

        //create park
        Park park = new Park();
        park.setOpenTIme(700);
        park.setCloseTime(2000);

        //create theater
        Theater theater = new Theater();
        theater.setOpenTIme(700);
        theater.setCloseTime(2000);
        theater.setChargeAmount(3.0f);*/

        Museum museum;
        Park park;
        Theater theater;
        //create attraction list
        List<Attraction> attractionList = new ArrayList<>();
        List<Attraction> openAttractionList = new ArrayList<>();
        boolean loopFlage = true;

        Scanner scanner = new Scanner(System.in);

        while (loopFlage) {
            out.println("Enter attraction type:");
            out.println("(Park - 1, Museum - 2, Theater - 3)");
            int attractionType = Integer.parseInt(scanner.nextLine());

            out.println("Enter the attraction name:");
            String attractionName = scanner.nextLine();
            out.println("Enter the Open hour(HHMM):");
            int openHour = Integer.parseInt(scanner.nextLine());
            out.println("Enter the close hour(HHMM):");
            int closeHour = Integer.parseInt(scanner.nextLine());

            if (attractionType == 1) {
                park = new Park();
                park.setOpenTIme(openHour);
                park.setCloseTime(closeHour);
                park.setAttractionName(attractionName);
                attractionList.add(park);
            } else if (attractionType == 2) {
                museum = new Museum();
                museum.setOpenTIme(openHour);
                museum.setCloseTime(closeHour);
                museum.setAttractionName(attractionName);
                out.println("Do you want add charging:");
                out.println("Yes/No - y/n:");
                String chargingFlag = scanner.nextLine();
                if ("y".equalsIgnoreCase(chargingFlag)) {
                    museum.setCharged(true);
                    out.println("Enter the charging amount(£):");
                    float chargeAmount = Float.parseFloat(scanner.nextLine());
                    museum.setChargeAmount(chargeAmount);
                } else {
                    museum.setCharged(false);
                }
                attractionList.add(museum);
            } else {
                theater = new Theater();
                theater.setOpenTIme(openHour);
                theater.setCloseTime(closeHour);
                theater.setAttractionName(attractionName);
                out.println("Enter the charging amount(£):");
                float chargeAmount = Float.parseFloat(scanner.nextLine());
                theater.setChargeAmount(chargeAmount);
                attractionList.add(theater);
            }
            out.println("Attraction successfully added !!!");
            out.println("=====================================");
            out.println("Do you want to add new Attraction");
            out.println("Yes/No - y/n:");
            String continuingFlag = scanner.nextLine();
            if ("n".equalsIgnoreCase(continuingFlag)) {
                loopFlage = false;
            }
            out.println("=====================================");
        }

        for (Attraction attraction : attractionList) {
            if (attraction.getCloseTime() > 1900) {
                if (attraction instanceof Museum) {
                    Museum museum1 = (Museum) attraction;
                    if (museum1.isCharged() && museum1.getChargeAmount() < 5) {
                        openAttractionList.add(museum1);
                    }
                } else if (attraction instanceof Theater) {
                    Theater theater1 = (Theater) attraction;
                    if (theater1.getChargeAmount() < 5) {
                        openAttractionList.add(attraction);
                    }
                } else { //Park attraction
                    openAttractionList.add(attraction);
                }
            }
        }
        out.println("=====================================");
        out.println("List of attractions, which are open after 1900 and which cost less than £5");
        for (Attraction openAttraction : openAttractionList) {
            out.println(openAttraction.toString());
        }
        out.println("=====================================");
    }
}
