package core;

import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 13/11/13
 * Time: 17:57
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class World {
    public static LinkedList<Skill> SKILLS;
    public static LinkedList<Talent> TALENTS;
    public static LinkedList<Weapon> WEAPONS;
    public static LinkedList<Armour> ARMOURS;
    public static LinkedList<Equipment> EQUIPMENTS;
    public static LinkedList<Race> RACES;
    public static LinkedList<Career> CAREERS;
}
