package core;

import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
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

    public static void loadAll(){
        SKILLS = xmlLoader.skillLoader();
        TALENTS = xmlLoader.talentLoader();
        WEAPONS = xmlLoader.weaponLoader();
        ARMOURS = xmlLoader.armourLoader();
        EQUIPMENTS = xmlLoader.equipmentLoader();
        RACES = xmlLoader.raceLoader();
    }

    public static Skill searchSkillByName(String name){
        for(int i = 0; i < SKILLS.size() ; i++){
            if(SKILLS.get(i).getName().equals(name)){
                return SKILLS.get(i);
            }
        }

        return null;
    }

    public static Talent searchTalentByName(String name){
        for(int i = 0; i < TALENTS.size() ; i++){
            if(TALENTS.get(i).getName().equals(name)){
                return TALENTS.get(i);
            }
        }

        return null;
    }

    public static Weapon searchWeaponByName(String name){
        for(int i = 0; i < WEAPONS.size() ; i++){
            if(WEAPONS.get(i).getName().equals(name)){
                return WEAPONS.get(i);
            }
        }

        return null;
    }

    public static Armour searchArmourByName(String name){
        for(int i = 0; i < ARMOURS.size() ; i++){
            if(ARMOURS.get(i).getName().equals(name)){
                return ARMOURS.get(i);
            }
        }

        return null;
    }

    public static Equipment searchEquipmentByName(String name){
        for(int i = 0; i < EQUIPMENTS.size() ; i++){
            if(EQUIPMENTS.get(i).getName().equals(name)){
                return EQUIPMENTS.get(i);
            }
        }

        return null;
    }

    public static Race searchRaceByName(String name){
        for(int i = 0; i < RACES.size() ; i++){
            if(RACES.get(i).getName().equals(name)){
                return RACES.get(i);
            }
        }

        return null;
    }

    public static Career searchCareerByName(String name){
        for(int i = 0; i < CAREERS.size() ; i++){
            if(CAREERS.get(i).getName().equals(name)){
                return CAREERS.get(i);
            }
        }

        return null;
    }
}
