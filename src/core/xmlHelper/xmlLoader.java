package core.xmlHelper;

import core.World;
import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 13/11/13
 * Time: 17:57
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class xmlLoader {

    static Document document;
    static Element root;

    public static LinkedList<Skill> skillLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> skills;
        Element currentSkill;
        Iterator<Element> iteratorSkills;

        LinkedList<Skill> skillLinkedList = new LinkedList<Skill>();
        Skill skill;

        try{
            document = sxb.build(new File("resources/skills.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        skills = root.getChildren("skill");
        iteratorSkills = skills.iterator();

        while(iteratorSkills.hasNext()){
            currentSkill = iteratorSkills.next();
            skill = new Skill(currentSkill.getAttributeValue("name"), currentSkill.getAttributeValue("characteristics"));
            skillLinkedList.add(skill);
        }

        return skillLinkedList;
    }

    public static LinkedList<Talent> talentLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> talents;
        Element currentTalent;
        Iterator<Element> iteratorTalents;

        LinkedList<Talent> talentLinkedList = new LinkedList<Talent>();
        Talent talent;

        try{
            document = sxb.build(new File("resources/talents.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        talents = root.getChildren("talent");
        iteratorTalents = talents.iterator();

        while(iteratorTalents.hasNext()){
            currentTalent = iteratorTalents.next();
            talent = new Talent(currentTalent.getAttributeValue("name"), currentTalent.getAttributeValue("description"));
            talentLinkedList.add(talent);
        }

        return talentLinkedList;
    }

    public static LinkedList<Equipment> equipmentLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> equipments;
        Element currentEquipment;
        Iterator<Element> iteratorEquipments;

        LinkedList<Equipment> equipmentLinkedList = new LinkedList<Equipment>();
        Equipment equipment;

        try{
            document = sxb.build(new File("resources/equipments.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        equipments = root.getChildren("equipment");
        iteratorEquipments = equipments.iterator();

        while(iteratorEquipments.hasNext()){
            currentEquipment = iteratorEquipments.next();
            equipment = new Equipment(currentEquipment.getAttributeValue("name"), new Money(
                    Integer.parseInt(currentEquipment.getAttributeValue("goldenCrowns")),
                    Integer.parseInt(currentEquipment.getAttributeValue("silverShillings")),
                    Integer.parseInt(currentEquipment.getAttributeValue("brassPennies"))),
                    Integer.parseInt(currentEquipment.getAttributeValue("enc")));
            equipmentLinkedList.add(equipment);
        }

        return equipmentLinkedList;
    }

    public static LinkedList<Weapon> weaponLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> weapons;
        Element currentWeapon;
        Iterator<Element> iteratorWeapons;

        LinkedList<Weapon> weaponLinkedList = new LinkedList<Weapon>();
        Weapon weapon;
        LinkedList<String> attributes;
        List<Element> eAttributes;


        try{
            document = sxb.build(new File("resources/weapons.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        weapons = root.getChildren("weapon");
        iteratorWeapons = weapons.iterator();

        while(iteratorWeapons.hasNext()){
            currentWeapon = iteratorWeapons.next();
            attributes = new LinkedList<String>();

            eAttributes = currentWeapon.getChildren("attribute");

            for (Element eAttribute : eAttributes) {
                attributes.add(eAttribute.getText());
            }

            weapon = new Weapon(currentWeapon.getAttributeValue("name"), new Money(
                    Integer.parseInt(currentWeapon.getAttributeValue("goldenCrowns")),
                    Integer.parseInt(currentWeapon.getAttributeValue("silverShillings")),
                    Integer.parseInt(currentWeapon.getAttributeValue("brassPennies"))),
                    Integer.parseInt(currentWeapon.getAttributeValue("enc")),
                    currentWeapon.getAttributeValue("group"),
                    currentWeapon.getAttributeValue("damage"),
                    Integer.parseInt(currentWeapon.getAttributeValue("lowRange")),
                    Integer.parseInt(currentWeapon.getAttributeValue("highRange")),
                    Integer.parseInt(currentWeapon.getAttributeValue("reload")), attributes);
            weaponLinkedList.add(weapon);
        }

        return weaponLinkedList;
    }

    public static LinkedList<Armour> armourLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> armours;
        Element currentArmour;
        Iterator<Element> iteratorArmours;

        LinkedList<Armour> armourLinkedList = new LinkedList<Armour>();
        Armour armour;
        LinkedList<String> zones;
        List<Element> eZones;


        try{
            document = sxb.build(new File("resources/armours.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        armours = root.getChildren("armour");
        iteratorArmours = armours.iterator();

        while(iteratorArmours.hasNext()){
            currentArmour = iteratorArmours.next();
            zones = new LinkedList<String>();

            eZones = currentArmour.getChildren("zone");

            for (Element eZone : eZones) {
                zones.add(eZone.getText());
            }

            armour = new Armour(currentArmour.getAttributeValue("name"), new Money(
                    Integer.parseInt(currentArmour.getAttributeValue("goldenCrowns")),
                    Integer.parseInt(currentArmour.getAttributeValue("silverShillings")),
                    Integer.parseInt(currentArmour.getAttributeValue("brassPennies"))),
                    Integer.parseInt(currentArmour.getAttributeValue("enc")),
                    Integer.parseInt(currentArmour.getAttributeValue("armourLevel")), zones);
            armourLinkedList.add(armour);
        }

        return armourLinkedList;
    }

    public static LinkedList<Race> raceLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> races;
        Element currentRace;
        Iterator<Element> iteratorRaces;

        LinkedList<Race> raceLinkedList = new LinkedList<Race>();
        Race race;

        Element eProfile;
        Profile profile;
        Element eWounds;
        int[] wounds;
        Element eFate;
        int[] fate;
        Element eWeight;
        int[] weight;
        Element eAge;
        int[] age;
        Element eMNames;
        String[] mNames;
        Element eFNames;
        String[] fNames;
        Element eEyeColour;
        String[] eyeColour;
        Element eHairColour;
        String[] hairColour;

        Element skillTable;
        List<Element> eSkills;
        List<Element> eSkillsChoice;
        LinkedList<Skill> currentSkillSet;
        LinkedList<LinkedList<Skill>> skills;
        Element talentTable;
        List<Element> eTalents;
        List<Element> eTalentsChoice;
        LinkedList<Talent> currentTalentSet;
        LinkedList<LinkedList<Talent>> talents;
        Element weaponTable;
        List<Element> eWeapons;
        List<Element> eWeaponsChoice;
        LinkedList<Weapon> currentWeaponSet;
        LinkedList<LinkedList<Weapon>> weapons;
        Element armourTable;
        List<Element> eArmours;
        List<Element> eArmoursChoice;
        LinkedList<Armour> currentArmourSet;
        LinkedList<LinkedList<Armour>> armours;
        Element equipmentTable;
        List<Element> eEquipments;
        List<Element> eEquipmentsChoice;
        LinkedList<Equipment> currentEquipmentSet;
        LinkedList<LinkedList<Equipment>> equipments;

        try{
            document = sxb.build(new File("resources/races.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        races = root.getChildren("race");
        iteratorRaces = races.iterator();

        while(iteratorRaces.hasNext()){
            currentRace = iteratorRaces.next();

            eProfile = currentRace.getChild("profile");
            profile = new Profile(Integer.parseInt(eProfile.getAttributeValue("WS")), Integer.parseInt(eProfile.getAttributeValue("BS")),
                    Integer.parseInt(eProfile.getAttributeValue("S")), Integer.parseInt(eProfile.getAttributeValue("T")),
                    Integer.parseInt(eProfile.getAttributeValue("Ag")), Integer.parseInt(eProfile.getAttributeValue("Int")),
                    Integer.parseInt(eProfile.getAttributeValue("WP")), Integer.parseInt(eProfile.getAttributeValue("Fel")),
                    Integer.parseInt(eProfile.getAttributeValue("M")));

            eWounds = currentRace.getChild("wounds");
            wounds = new int[eWounds.getChildren("choice").size()];

            for(int i = 0 ; i < eWounds.getChildren("choice").size() ; i++){
                wounds[i] = Integer.parseInt(eWounds.getChildren("choice").get(i).getText());
            }

            eFate = currentRace.getChild("fate");
            fate = new int[eFate.getChildren("choice").size()];

            for(int i = 0 ; i < eFate.getChildren("choice").size() ; i++){
                fate[i] = Integer.parseInt(eFate.getChildren("choice").get(i).getText());
            }

            eFNames = currentRace.getChild("fNames");
            fNames = new String[eFNames.getChildren("name").size()];

            for(int i = 0 ; i < eFNames.getChildren("name").size() ; i++){
                fNames[i] = eFNames.getChildren("name").get(i).getText();
            }

            eMNames = currentRace.getChild("mNames");
            mNames = new String[eMNames.getChildren("name").size()];

            for(int i = 0 ; i < eMNames.getChildren("name").size() ; i++){
                mNames[i] = eMNames.getChildren("name").get(i).getText();
            }

            eEyeColour = currentRace.getChild("eyeColour");
            eyeColour = new String[eEyeColour.getChildren("colour").size()];

            for(int i = 0 ; i < eEyeColour.getChildren("colour").size() ; i++){
                eyeColour[i] = eEyeColour.getChildren("colour").get(i).getText();
            }

            eHairColour = currentRace.getChild("hairColour");
            hairColour = new String[eHairColour.getChildren("colour").size()];

            for(int i = 0 ; i < eHairColour.getChildren("colour").size() ; i++){
                hairColour[i] = eHairColour.getChildren("colour").get(i).getText();
            }

            eWeight = currentRace.getChild("weightTable");
            weight = new int[eWeight.getChildren("eWeight").size()];

            for(int i = 0 ; i < eWeight.getChildren("eWeight").size() ; i++){
                weight[i] = Integer.parseInt(eWeight.getChildren("eWeight").get(i).getText());
            }

            eAge = currentRace.getChild("ageTable");
            age = new int[eAge.getChildren("eAge").size()];

            for(int i = 0 ; i < eAge.getChildren("eAge").size() ; i++){
                age[i] = Integer.parseInt(eAge.getChildren("eAge").get(i).getText());
            }

            skills = new LinkedList<LinkedList<Skill>>();
            skillTable = currentRace.getChild("skillsTable");
            eSkills = skillTable.getChildren("eSkills");

            for (Element eSkill : eSkills) {
                currentSkillSet = new LinkedList<Skill>();
                eSkillsChoice = eSkill.getChildren("choice");
                for (Element anESkillsChoice : eSkillsChoice) {
                    currentSkillSet.add(World.searchSkillByName(anESkillsChoice.getText()));
                }

                skills.add(currentSkillSet);
            }

            talents = new LinkedList<LinkedList<Talent>>();
            talentTable = currentRace.getChild("talentsTable");
            eTalents = talentTable.getChildren("eTalents");

            for (Element eTalent : eTalents) {
                currentTalentSet = new LinkedList<Talent>();
                eTalentsChoice = eTalent.getChildren("choice");
                for (Element anETalentsChoice : eTalentsChoice) {
                    currentTalentSet.add(World.searchTalentByName(anETalentsChoice.getText()));
                }

                talents.add(currentTalentSet);
            }

            weapons = new LinkedList<LinkedList<Weapon>>();
            weaponTable = currentRace.getChild("weaponsTable");
            eWeapons = weaponTable.getChildren("eWeapons");

            for (Element eWeapon : eWeapons) {
                currentWeaponSet = new LinkedList<Weapon>();
                eWeaponsChoice = eWeapon.getChildren("choice");
                for (Element anEWeaponsChoice : eWeaponsChoice) {
                    currentWeaponSet.add(World.searchWeaponByName(anEWeaponsChoice.getText()));
                }

                if (currentWeaponSet.size() != 0) {
                    weapons.add(currentWeaponSet);
                }
            }

            armours = new LinkedList<LinkedList<Armour>>();
            armourTable = currentRace.getChild("armoursTable");
            eArmours = armourTable.getChildren("eArmours");

            for (Element eArmour : eArmours) {
                currentArmourSet = new LinkedList<Armour>();
                eArmoursChoice = eArmour.getChildren("choice");
                for (Element anEArmoursChoice : eArmoursChoice) {
                    currentArmourSet.add(World.searchArmourByName(anEArmoursChoice.getText()));
                }

                if (currentArmourSet.size() != 0) {
                    armours.add(currentArmourSet);
                }
            }

            equipments = new LinkedList<LinkedList<Equipment>>();
            equipmentTable = currentRace.getChild("equipmentsTable");
            eEquipments = equipmentTable.getChildren("eEquipments");

            for (Element eEquipment : eEquipments) {
                currentEquipmentSet = new LinkedList<Equipment>();
                eEquipmentsChoice = eEquipment.getChildren("choice");
                for (Element anEEquipmentsChoice : eEquipmentsChoice) {
                    currentEquipmentSet.add(World.searchEquipmentByName(anEEquipmentsChoice.getText()));
                }

                if (currentEquipmentSet.size() != 0) {
                    equipments.add(currentEquipmentSet);
                }
            }

            race = new Race(currentRace.getAttributeValue("name"), profile,
                    Integer.parseInt(currentRace.getChild("size").getAttributeValue("F")),
                    Integer.parseInt(currentRace.getChild("size").getAttributeValue("M")),
                    wounds, fate, weight, age, mNames, fNames, hairColour, eyeColour, skills, talents, weapons,
                    armours, equipments);

            raceLinkedList.add(race);
        }

        return raceLinkedList;
    }

    public static LinkedList<Career> careerLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> careers;
        Element currentCareer;
        Iterator<Element> iteratorCareers;

        LinkedList<Career> careerLinkedList = new LinkedList<Career>();
        Career career;

        Element eProfile;
        Profile profile;

        Element skillTable;
        List<Element> eSkills;
        List<Element> eSkillsChoice;
        LinkedList<Skill> currentSkillSet;
        LinkedList<LinkedList<Skill>> skills;
        Element talentTable;
        List<Element> eTalents;
        List<Element> eTalentsChoice;
        LinkedList<Talent> currentTalentSet;
        LinkedList<LinkedList<Talent>> talents;
        Element weaponTable;
        List<Element> eWeapons;
        List<Element> eWeaponsChoice;
        LinkedList<Weapon> currentWeaponSet;
        LinkedList<LinkedList<Weapon>> weapons;
        Element armourTable;
        List<Element> eArmours;
        List<Element> eArmoursChoice;
        LinkedList<Armour> currentArmourSet;
        LinkedList<LinkedList<Armour>> armours;
        Element equipmentTable;
        List<Element> eEquipments;
        List<Element> eEquipmentsChoice;
        LinkedList<Equipment> currentEquipmentSet;
        LinkedList<LinkedList<Equipment>> equipments;

        try{
            document = sxb.build(new File("resources/careers.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        careers = root.getChildren("career");
        iteratorCareers = careers.iterator();

        while(iteratorCareers.hasNext()){
            currentCareer = iteratorCareers.next();

            eProfile = currentCareer.getChild("profile");
            profile = new Profile(Integer.parseInt(eProfile.getAttributeValue("WS")),
                    Integer.parseInt(eProfile.getAttributeValue("BS")),
                    Integer.parseInt(eProfile.getAttributeValue("S")),
                    Integer.parseInt(eProfile.getAttributeValue("T")),
                    Integer.parseInt(eProfile.getAttributeValue("Ag")),
                    Integer.parseInt(eProfile.getAttributeValue("Int")),
                    Integer.parseInt(eProfile.getAttributeValue("WP")),
                    Integer.parseInt(eProfile.getAttributeValue("Fel")),
                    Integer.parseInt(eProfile.getAttributeValue("A")),
                    Integer.parseInt(eProfile.getAttributeValue("W")),
                    Integer.parseInt(eProfile.getAttributeValue("M")),
                    Integer.parseInt(eProfile.getAttributeValue("Mag")));

            skills = new LinkedList<LinkedList<Skill>>();
            skillTable = currentCareer.getChild("skillsTable");
            eSkills = skillTable.getChildren("eSkills");

            for (Element eSkill : eSkills) {
                currentSkillSet = new LinkedList<Skill>();
                eSkillsChoice = eSkill.getChildren("choice");
                for (Element anESkillsChoice : eSkillsChoice) {
                    currentSkillSet.add(World.searchSkillByName(anESkillsChoice.getText()));
                }

                skills.add(currentSkillSet);
            }

            talents = new LinkedList<LinkedList<Talent>>();
            talentTable = currentCareer.getChild("talentsTable");
            eTalents = talentTable.getChildren("eTalents");

            for (Element eTalent : eTalents) {
                currentTalentSet = new LinkedList<Talent>();
                eTalentsChoice = eTalent.getChildren("choice");
                for (Element anETalentsChoice : eTalentsChoice) {
                    currentTalentSet.add(World.searchTalentByName(anETalentsChoice.getText()));
                }

                talents.add(currentTalentSet);
            }

            weapons = new LinkedList<LinkedList<Weapon>>();
            weaponTable = currentCareer.getChild("weaponsTable");
            eWeapons = weaponTable.getChildren("eWeapons");

            for (Element eWeapon : eWeapons) {
                currentWeaponSet = new LinkedList<Weapon>();
                eWeaponsChoice = eWeapon.getChildren("choice");
                for (Element anEWeaponsChoice : eWeaponsChoice) {
                    currentWeaponSet.add(World.searchWeaponByName(anEWeaponsChoice.getText()));
                }

                if (currentWeaponSet.size() != 0) {
                    weapons.add(currentWeaponSet);
                }
            }

            armours = new LinkedList<LinkedList<Armour>>();
            armourTable = currentCareer.getChild("armoursTable");
            eArmours = armourTable.getChildren("eArmours");

            for (Element eArmour : eArmours) {
                currentArmourSet = new LinkedList<Armour>();
                eArmoursChoice = eArmour.getChildren("choice");
                for (Element anEArmoursChoice : eArmoursChoice) {
                    currentArmourSet.add(World.searchArmourByName(anEArmoursChoice.getText()));
                }

                if (currentArmourSet.size() != 0) {
                    armours.add(currentArmourSet);
                }
            }

            equipments = new LinkedList<LinkedList<Equipment>>();
            equipmentTable = currentCareer.getChild("equipmentsTable");
            eEquipments = equipmentTable.getChildren("eEquipments");

            for (Element eEquipment : eEquipments) {
                currentEquipmentSet = new LinkedList<Equipment>();
                eEquipmentsChoice = eEquipment.getChildren("choice");
                for (Element anEEquipmentsChoice : eEquipmentsChoice) {
                    currentEquipmentSet.add(World.searchEquipmentByName(anEEquipmentsChoice.getText()));
                }

                if (currentEquipmentSet.size() != 0) {
                    equipments.add(currentEquipmentSet);
                }
            }

            career = new Career(currentCareer.getAttributeValue("name"), profile, skills, talents, equipments, weapons, armours);

            careerLinkedList.add(career);
        }

        return careerLinkedList;
    }
}
