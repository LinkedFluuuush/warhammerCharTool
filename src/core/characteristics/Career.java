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
public class Career {
    private String name;
    private Profile profile;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;
    private LinkedList<LinkedList<Equipment>> equipments;
    private LinkedList<LinkedList<Weapon>> weapons;
    private LinkedList<LinkedList<Armour>> armours;

    public Career(String name, Profile profile, LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents) {
        this.name = name;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
    }

    public Career(String name, int ws, int bs, int s, int t, int ag, int intel, int wp,
                  int fel, int a, int w, int m, int mag,
                  LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents) {
        this.name = name;
        this.profile = new Profile(ws, bs, s, t, ag, intel, wp, fel, a, w, m, mag);
        this.skills = skills;
        this.talents = talents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<LinkedList<Skill>> skills) {
        this.skills = skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<LinkedList<Talent>> talents) {
        this.talents = talents;
    }

    public LinkedList<LinkedList<Equipment>> getEquipments() {
        return equipments;
    }

    public void setEquipments(LinkedList<LinkedList<Equipment>> equipments) {
        this.equipments = equipments;
    }

    public LinkedList<LinkedList<Weapon>> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<LinkedList<Weapon>> weapons) {
        this.weapons = weapons;
    }

    public LinkedList<LinkedList<Armour>> getArmours() {
        return armours;
    }

    public void setArmours(LinkedList<LinkedList<Armour>> armours) {
        this.armours = armours;
    }
}
