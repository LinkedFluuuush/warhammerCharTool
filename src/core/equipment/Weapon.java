package core.equipment;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Weapon extends Equipment {
    private String group;
    private String damage;
    private int lowRange;
    private int highRange;
    private int reload;
    private LinkedList<String> attributes;

    public Weapon(String name, Money price, int enc, String group, String damage,
                  int lowRange, int highRange, int reload, LinkedList<String> attributes) {
        super(name, price, enc);
        this.group = group;
        this.damage = damage;
        this.lowRange = lowRange;
        this.highRange = highRange;
        this.reload = reload;
        this.attributes = attributes;
    }

    public Weapon(String name, int goldenCrowns, int silverShillings,
                  int brassPennies, int enc, String group, String damage,
                  int lowRange, int highRange, int reload,
                  LinkedList<String> attributes) {
        super(name, goldenCrowns, silverShillings, brassPennies, enc);
        this.group = group;
        this.damage = damage;
        this.lowRange = lowRange;
        this.highRange = highRange;
        this.reload = reload;
        this.attributes = attributes;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public int getLowRange() {
        return lowRange;
    }

    public void setLowRange(int lowRange) {
        this.lowRange = lowRange;
    }

    public int getHighRange() {
        return highRange;
    }

    public void setHighRange(int highRange) {
        this.highRange = highRange;
    }

    public int getReload() {
        return reload;
    }

    public void setReload(int reload) {
        this.reload = reload;
    }

    public LinkedList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(LinkedList<String> attributes) {
        this.attributes = attributes;
    }
}
