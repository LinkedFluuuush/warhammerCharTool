package core.equipment;

import java.util.LinkedList;

/**
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 */
public class Armour extends Equipment {
    private int armourLevel;
    private LinkedList<String> coveredZones;
    private String armourType;

    public Armour(String name, Money price, int enc, int armourLevel,
                  LinkedList<String> coveredZones, String armourType) {
        super(name, price, enc);
        this.armourLevel = armourLevel;
        this.coveredZones = coveredZones;
        this.armourType = armourType;
    }

    public Armour(String name, int goldenCrowns, int silverShillings,
                  int brassPennies, int enc, int armourLevel,
                  LinkedList<String> coveredZones, String armourType) {
        super(name, goldenCrowns, silverShillings, brassPennies, enc);
        this.armourLevel = armourLevel;
        this.coveredZones = coveredZones;
        this.armourType = armourType;
    }

    public int getArmourLevel() {
        return armourLevel;
    }

    public void setArmourLevel(int armourLevel) {
        this.armourLevel = armourLevel;
    }

    public LinkedList<String> getCoveredZones() {
        return coveredZones;
    }

    public void setCoveredZones(LinkedList<String> coveredZones) {
        this.coveredZones = coveredZones;
    }

    public String getArmourType() {
        return armourType;
    }

    public void setArmourType(String armourType) {
        this.armourType = armourType;
    }
}
