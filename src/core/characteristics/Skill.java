package core.characteristics;

import core.World;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Skill {
    private String name;
    private String characteristics;

    public Skill(String name, String characteristics) {
        this.name = name;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        return this.getName() + (this.getCharacteristics().equals("") ? "" : " : " + this.getCharacteristics());
    }
}
