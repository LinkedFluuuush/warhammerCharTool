package core;

import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
import core.entities.AstralSign;
import core.entities.God;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;
import core.xmlHelper.xmlLoader;

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
    public static LinkedList<God> GODS;
    public static LinkedList<AstralSign> ASTRALSIGNS;
    public static LinkedList<String> DISTINGUISHINGSIGNS;

    public static void loadAll(){
        SKILLS = xmlLoader.skillLoader();
        TALENTS = xmlLoader.talentLoader();
        WEAPONS = xmlLoader.weaponLoader();
        ARMOURS = xmlLoader.armourLoader();
        EQUIPMENTS = xmlLoader.equipmentLoader();
        GODS = xmlLoader.godLoader();
        ASTRALSIGNS = xmlLoader.astralSignsLoader();
        DISTINGUISHINGSIGNS = xmlLoader.distinguishingsSignsLoader();
        RACES = xmlLoader.raceLoader();
        CAREERS = xmlLoader.careerLoader();

        for(Career career : CAREERS){
            xmlLoader.careerLinker(career);
        }
    }

    public static Skill searchSkillByName(String name){
        for (Skill SKILL : SKILLS) {
            if (SKILL.getName().equals(name)) {
                return SKILL;
            }
        }

        return null;
    }

    public static Talent searchTalentByName(String name){
        for (Talent TALENT : TALENTS) {
            if (TALENT.getName().equals(name)) {
                return TALENT;
            }
        }

        return null;
    }

    public static Weapon searchWeaponByName(String name){
        for (Weapon WEAPON : WEAPONS) {
            if (WEAPON.getName().equals(name)) {
                return WEAPON;
            }
        }

        return null;
    }

    public static Armour searchArmourByName(String name){
        for (Armour ARMOUR : ARMOURS) {
            if (ARMOUR.getName().equals(name)) {
                return ARMOUR;
            }
        }

        return null;
    }

    public static Equipment searchEquipmentByName(String name){
        for (Equipment EQUIPMENT : EQUIPMENTS) {
            if (EQUIPMENT.getName().equals(name)) {
                return EQUIPMENT;
            }
        }

        return null;
    }

    public static God searchGodByName(String name){
        for (God GOD : GODS) {
            if (GOD.getName().equals(name)) {
                return GOD;
            }
        }

        return null;
    }

    public static AstralSign searchAstralSignByName(String name){
        for (AstralSign ASTRALSIGN : ASTRALSIGNS) {
            if (ASTRALSIGN.getName().equals(name)) {
                return ASTRALSIGN;
            }
        }

        return null;
    }

    public static String searchDistinguishingSignByName(String name){
        for (String DISTINGUISHINGSIGN : DISTINGUISHINGSIGNS) {
            if (DISTINGUISHINGSIGN.equals(name)) {
                return DISTINGUISHINGSIGN;
            }
        }

        return null;
    }

    public static Race searchRaceByName(String name){
        for (Race RACE : RACES) {
            if (RACE.getName().equals(name)) {
                return RACE;
            }
        }

        return null;
    }

    public static Career searchCareerByName(String name){
        for (Career CAREER : CAREERS) {
            if (CAREER.getName().equals(name)) {
                return CAREER;
            }
        }

        return null;
    }
}
