package lk.iit.ase.model;

import java.util.UUID;

public class Attraction {
    private UUID attractionId;
    private String attractionName;
    private int openTIme;
    private int closeTime;

    public UUID getAttractionId() {
        return attractionId;
    }

    public void setAttractionId() {
        this.attractionId = UUID.randomUUID();
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public int getOpenTIme() {
        return openTIme;
    }

    public void setOpenTIme(int openTIme) {
        this.openTIme = openTIme;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "openTIme=" + openTIme +
                ", closeTime=" + closeTime +
                '}';
    }
}
