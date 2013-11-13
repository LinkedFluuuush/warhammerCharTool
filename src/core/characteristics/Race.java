package core.characteristics;

import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class Race {
    private String name;
    private Profile profile;
    private int fSize;
    private int mSize;
    private int[] wounds;
    private int[] fate;
    private int[] weight;
    private int[] age;
    private String[] mNames;
    private String[] fNames;
    private String[] hairColour;
    private String[] eyeColour;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;
    private LinkedList<LinkedList<Weapon>> weapons;
    private LinkedList<LinkedList<Armour>> armours;
    private LinkedList<LinkedList<Equipment>> equiments;

    public Race(String name, Profile profile, int fSize, int mSize, int[] wounds, int[] fate, int[] weight, int[] age,
                String[] mNames, String[] fNames, String[] hairColour, String[] eyeColour,
                LinkedList<LinkedList<Skill>> skills, LinkedList<LinkedList<Talent>> talents,
                LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours,
                LinkedList<LinkedList<Equipment>> equiments) {
        this.name = name;
        this.profile = profile;
        this.fSize = fSize;
        this.mSize = mSize;
        this.wounds = wounds;
        this.fate = fate;
        this.weight = weight;
        this.age = age;
        this.mNames = mNames;
        this.fNames = fNames;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equiments = equiments;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getfSize() {
        return fSize;
    }

    public int getmSize() {
        return mSize;
    }

    public int[] getWounds() {
        return wounds;
    }

    public int[] getFate() {
        return fate;
    }

    public int[] getWeight() {
        return weight;
    }

    public int[] getAge() {
        return age;
    }

    public String[] getmNames() {
        return mNames;
    }

    public String[] getfNames() {
        return fNames;
    }

    public String[] getHairColour() {
        return hairColour;
    }

    public String[] getEyeColour() {
        return eyeColour;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public LinkedList<LinkedList<Weapon>> getWeapons() {
        return weapons;
    }

    public LinkedList<LinkedList<Armour>> getArmours() {
        return armours;
    }

    public LinkedList<LinkedList<Equipment>> getEquiments() {
        return equiments;
    }
}
