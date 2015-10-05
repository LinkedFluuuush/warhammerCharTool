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
import core.xmlHelper.dataLoader;
import core.xmlHelper.xmlLoader;

import java.util.HashMap;

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
    public static HashMap<String, Skill> SKILLS = new HashMap<>();
    public static HashMap<String, Talent> TALENTS = new HashMap<>();
    public static HashMap<String, Weapon> WEAPONS = new HashMap<>();
    public static HashMap<String, Armour> ARMOURS = new HashMap<>();
    public static HashMap<String, Equipment> EQUIPMENTS = new HashMap<>();
    public static HashMap<String, Race> RACES = new HashMap<>();
    public static HashMap<String, Career> CAREERS = new HashMap<>();
    public static HashMap<String, God> GODS = new HashMap<>();
    public static HashMap<String, AstralSign> ASTRALSIGNS = new HashMap<>();
    public static HashMap<String, String> DISTINGUISHINGSIGNS = new HashMap<>();

    private static dataLoader LOADER = new xmlLoader();

    public World(){
        SKILLS = new HashMap<>();
        TALENTS = new HashMap<>();
        WEAPONS = new HashMap<>();
        ARMOURS = new HashMap<>();
        EQUIPMENTS = new HashMap<>();
        RACES = new HashMap<>();
        CAREERS = new HashMap<>();
        GODS = new HashMap<>();
        ASTRALSIGNS = new HashMap<>();
        DISTINGUISHINGSIGNS = new HashMap<>();

        LOADER = new xmlLoader();
    }

    public static void loadAll(){
        LOADER = new xmlLoader();

        SKILLS = (HashMap<String, Skill>) LOADER.nameLoader("skill");
        TALENTS = (HashMap<String, Talent>) LOADER.nameLoader("talent");
        WEAPONS = (HashMap<String, Weapon>) LOADER.nameLoader("weapon");
        ARMOURS = (HashMap<String, Armour>) LOADER.nameLoader("armour");
        EQUIPMENTS = (HashMap<String, Equipment>) LOADER.nameLoader("equipment");
        GODS = (HashMap<String, God>) LOADER.nameLoader("god");
        ASTRALSIGNS = (HashMap<String, AstralSign>) LOADER.nameLoader("astralSign");
        DISTINGUISHINGSIGNS = (HashMap<String, String>) LOADER.nameLoader("distinguishingSign");
        RACES = (HashMap<String, Race>) LOADER.nameLoader("race");
        CAREERS = (HashMap<String, Career>) LOADER.nameLoader("career");

        /*for(Career career : CAREERS){
            LOADER.careerLinker(career);
        }
        xmlSaver.saveCareers();*/
    }

    public static Skill loadSkill(String skill) {
        Skill returnSkill;

        returnSkill = searchSkillByName(skill);

        if(returnSkill == null){
            returnSkill = LOADER.skillLoader(skill);

            if(returnSkill != null){
                SKILLS.put(skill, returnSkill);
                //System.out.println("Loaded " + returnSkill.getName());
            } else {
                //System.out.println("Couldn't load " + skill);
            }
        }

        return returnSkill;
    }

    public static Talent loadTalent(String talent) {
        Talent returnTalent;

        returnTalent = searchTalentByName(talent);

        if(returnTalent == null){
            returnTalent = LOADER.talentLoader(talent);

            if(returnTalent != null){
                TALENTS.put(talent, returnTalent);
                //System.out.println("Loaded " + returnTalent.getName());
            } else {
                //System.out.println("Couldn't load " + talent);
            }
        }
        return returnTalent;
    }

    public static Weapon loadWeapon(String weapon) {
        Weapon returnWeapon;

        returnWeapon = searchWeaponByName(weapon);

        if(returnWeapon == null){
            returnWeapon = LOADER.weaponLoader(weapon);

            if(returnWeapon != null){
                WEAPONS.put(weapon, returnWeapon);
                //System.out.println("Loaded " + returnWeapon.getName());
            } else {
                //System.out.println("Couldn't load " + weapon);
            }
        }
        return returnWeapon;
    }

    public static Armour loadArmour(String armour) {
        Armour returnArmour;

        returnArmour = searchArmourByName(armour);

        if(returnArmour == null){
            returnArmour = LOADER.armourLoader(armour);

            if(returnArmour != null){
                ARMOURS.put(armour, returnArmour);
                //System.out.println("Loaded " + returnArmour.getName());
            } else {
                //System.out.println("Couldn't load " + armour);
            }
        }
        return returnArmour;
    }

    public static Equipment loadEquipment(String equipment) {
        Equipment returnEquipment;

        returnEquipment = searchEquipmentByName(equipment);

        if(returnEquipment == null){
            returnEquipment = LOADER.equipmentLoader(equipment);

            if(returnEquipment != null){
                EQUIPMENTS.put(equipment, returnEquipment);
                //System.out.println("Loaded " + returnEquipment.getName());
            } else {
                //System.out.println("Couldn't load " + equipment);
            }
        }
        return returnEquipment;
    }

    public static God loadGod(String god) {
        God returnGod;

        returnGod = searchGodByName(god);

        if(returnGod == null){
            returnGod = LOADER.godLoader(god);

            if(returnGod != null){
                GODS.put(god, returnGod);
                //System.out.println("Loaded " + returnGod.getName());
            } else {
                //System.out.println("Couldn't load " + god);
            }
        }
        return returnGod;
    }

    public static AstralSign loadAstralSign(String astralSign) {
        AstralSign returnAstralSign;

        returnAstralSign = searchAstralSignByName(astralSign);

        if(returnAstralSign == null){
            returnAstralSign = LOADER.astralSignsLoader(astralSign);

            if(returnAstralSign != null){
                ASTRALSIGNS.put(astralSign, returnAstralSign);
                //System.out.println("Loaded " + returnAstralSign.getName());
            } else {
                //System.out.println("Couldn't load " + astralSign);
            }
        }
        return returnAstralSign;
    }

    public static String loadDistinguishingSign(String distinguishingSign) {
        String returnDistinguishingSign;

        returnDistinguishingSign = searchDistinguishingSignByName(distinguishingSign);

        if(returnDistinguishingSign == null){
            returnDistinguishingSign = LOADER.distinguishingsSignsLoader(distinguishingSign);

            if(returnDistinguishingSign != null){
                DISTINGUISHINGSIGNS.put(distinguishingSign, returnDistinguishingSign);
                //System.out.println("Loaded " + returnDistinguishingSign);
            } else {
                //System.out.println("Couldn't load " + distinguishingSign);
            }
        }
        return returnDistinguishingSign;
    }

    public static Race loadRace(String race) {
        Race returnRace;

        returnRace = searchRaceByName(race);

        if(returnRace == null){
            returnRace = LOADER.raceLoader(race);

            if(returnRace != null){
                RACES.put(race, returnRace);
                //System.out.println("Loaded " + returnRace.getName());
            } else {
                //System.out.println("Couldn't load " + race);
            }
        }
        return returnRace;
    }

    public static Career loadCareer(String career) {
        Career returnCareer;

        returnCareer = searchCareerByName(career);

        if(returnCareer == null){
            returnCareer = LOADER.careerLoader(career);

            if(returnCareer != null){
                CAREERS.put(career, returnCareer);
//                LOADER.careerLinker(returnCareer);

                //System.out.println("Loaded " + returnCareer.getName());
            } else {
                //System.out.println("Couldn't load " + career);
            }
        }
        return returnCareer;
    }

    private static Skill searchSkillByName(String name){
        return SKILLS.get(name);
    }

    private static Talent searchTalentByName(String name){
        return TALENTS.get(name);
    }

    private static Weapon searchWeaponByName(String name){
        return WEAPONS.get(name);
    }

    private static Armour searchArmourByName(String name){
        return ARMOURS.get(name);
    }

    private static Equipment searchEquipmentByName(String name){
        return EQUIPMENTS.get(name);
    }

    private static God searchGodByName(String name){
        return GODS.get(name);
    }

    private static AstralSign searchAstralSignByName(String name){
        return ASTRALSIGNS.get(name);
    }

    private static String searchDistinguishingSignByName(String name){
        return DISTINGUISHINGSIGNS.get(name);
    }

    private static Race searchRaceByName(String name){
        return RACES.get(name);
    }

    private static Career searchCareerByName(String name){
        return CAREERS.get(name);
    }
}
