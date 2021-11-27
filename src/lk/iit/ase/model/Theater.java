package lk.iit.ase.model;

public class Theater extends Attraction{
    private float chargeAmount;

    public float getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(float chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "chargeAmount=" + chargeAmount +
                '}';
    }
}
