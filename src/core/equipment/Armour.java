package core.equipment;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Armour extends Equipment {
    private int armourLevel;
    private LinkedList<String> coveredZones;

    public Armour(String name, Money price, int enc, int armourLevel,
                  LinkedList<String> coveredZones) {
        super(name, price, enc);
        this.armourLevel = armourLevel;
        this.coveredZones = coveredZones;
    }

    public Armour(String name, int goldenCrowns, int silverShillings,
                  int brassPennies, int enc, int armourLevel,
                  LinkedList<String> coveredZones) {
        super(name, goldenCrowns, silverShillings, brassPennies, enc);
        this.armourLevel = armourLevel;
        this.coveredZones = coveredZones;
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
}
