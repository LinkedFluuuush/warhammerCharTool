package core;

import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class Character {
    private String name;
    private String player;

    private Race race;
    private Career career;
    private LinkedList<Career> previousCareers;
    private Profile profile;
    private LinkedList<Skill> skills;
    private LinkedList<Talent> talents;
    private LinkedList<Weapon> weapons;
    private LinkedList<Armour> armours;
    private LinkedList<Equipment> equipment;
    private Money money;
    private PersonalDetails details;

    private int actualWounds;

}
