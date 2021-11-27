package lk.iit.ase.model;

public class Museum extends Attraction{

    private boolean isCharged;
    private float chargeAmount;

    public boolean isCharged() {
        return isCharged;
    }

    public void setCharged(boolean charged) {
        isCharged = charged;
    }

    public float getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(float chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "isCharged=" + isCharged +
                ", chargeAmount=" + chargeAmount +
                '}';
    }
}
