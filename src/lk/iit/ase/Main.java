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
        //create attraction list
        List<Attraction> attractionList = new ArrayList<>();
        List<Attraction> openAttractionList = new ArrayList<>();
        boolean loopFlag = true;

        Scanner scanner = new Scanner(System.in);

        while (loopFlag) {
            out.println("Enter attraction type:");
            out.println("(Park - 1, Museum - 2, Theater - 3)");
            int attractionType = Integer.parseInt(scanner.nextLine());

            out.println("Enter the attraction name:");
            String attractionName = scanner.nextLine();
            out.println("Enter the Open hour(HHMM):");
            int openHour = Integer.parseInt(scanner.nextLine());
            out.println("Enter the close hour(HHMM):");
            int closeHour = Integer.parseInt(scanner.nextLine());

            setAttractionList(attractionList, scanner, attractionType, attractionName, openHour, closeHour);
            out.println("Attraction successfully added !!!");
            out.println("=====================================");
            out.println("Do you want to add new Attraction");
            out.println("Yes/No - y/n:");
            String continuingFlag = scanner.nextLine();
            if ("n".equalsIgnoreCase(continuingFlag)) {
                loopFlag = false;
            }
            out.println("=====================================");
        }

        setOpenAttractionList(attractionList, openAttractionList);
        out.println("=====================================");
        out.println("List of attractions, which are open after 1900 and which cost less than £5");
        for (Attraction openAttraction : openAttractionList) {
            out.println("attraction id -> "+openAttraction.getAttractionId() + ", attraction name -> "+openAttraction.getAttractionName());
        }
        out.println("=====================================");
    }

    private static void setOpenAttractionList(List<Attraction> attractionList, List<Attraction> openAttractionList) {
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
    }

    private static void setAttractionList(List<Attraction> attractionList, Scanner scanner, int attractionType, String attractionName, int openHour, int closeHour) {
        Museum museum;
        Park park;
        Theater theater;
        if (attractionType == 1) {
            park = new Park();
            park.setOpenTIme(openHour);
            park.setCloseTime(closeHour);
            park.setAttractionName(attractionName);
            park.setAttractionId();
            attractionList.add(park);
        } else if (attractionType == 2) {
            museum = new Museum();
            museum.setOpenTIme(openHour);
            museum.setCloseTime(closeHour);
            museum.setAttractionName(attractionName);
            museum.setAttractionId();
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
            theater.setAttractionId();
            out.println("Enter the charging amount(£):");
            float chargeAmount = Float.parseFloat(scanner.nextLine());
            theater.setChargeAmount(chargeAmount);
            attractionList.add(theater);
        }
    }
}
