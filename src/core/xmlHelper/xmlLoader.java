package core.xmlHelper;

import core.World;
import core.characteristics.*;
import core.entities.AstralSign;
import core.entities.God;
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
import java.util.HashMap;
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
public class xmlLoader implements dataLoader{

    private static Document document;
    private static Element root;

/*    @Override
    public LinkedList<Skill> skillLoader(){
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

    @Override
    public LinkedList<Talent> talentLoader(){
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

    @Override
    public LinkedList<Equipment> equipmentLoader() {
        SAXBuilder sxb = new SAXBuilder();
        List<Element> equipments;
        Element currentEquipment;
        Iterator<Element> iteratorEquipments;

        LinkedList<Equipment> equipmentLinkedList = new LinkedList<Equipment>();
        Equipment equipment;

        try {
            document = sxb.build(new File("resources/equipments.xml"));
        } catch (JDOMException ignored) {
        } catch (IOException ignored) {
        }

        root = document.getRootElement();

        equipments = root.getChildren("equipment");
        iteratorEquipments = equipments.iterator();

        while (iteratorEquipments.hasNext()) {
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

    @Override
    public LinkedList<Weapon> weaponLoader(){
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

    @Override
    public LinkedList<Armour> armourLoader(){
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

    @Override
    public LinkedList<God> godLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> gods;
        Element currentGod;
        Iterator<Element> godIterator;

        List<Element> eDomains;
        List<Element> eWorshipers;

        LinkedList<God> godList = new LinkedList<God>();
        LinkedList<String> domains;
        LinkedList<String> worshipers;

        try{
            document = sxb.build(new File("resources/gods.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        gods = root.getChildren("god");
        godIterator = gods.iterator();

        while(godIterator.hasNext()){
            currentGod = godIterator.next();

            domains = new LinkedList<String>();
            eDomains = currentGod.getChildren("domain");
            for(Element domain : eDomains){
                domains.add(domain.getText());
            }

            worshipers = new LinkedList<String>();
            eWorshipers = currentGod.getChildren("worshiper");
            for(Element worshiper : eWorshipers){
                worshipers.add(worshiper.getText());
            }

            godList.add(new God(currentGod.getAttributeValue("name"), domains, worshipers));
        }

        return godList;
    }

    @Override
    public LinkedList<AstralSign> astralSignsLoader(){
            SAXBuilder sxb = new SAXBuilder();
            List<Element> astralSigns;
            Element currentSign;
        Iterator<Element> signIterator;

        LinkedList<AstralSign> astralSignList = new LinkedList<AstralSign>();

        try{
            document = sxb.build(new File("resources/astralSigns.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        astralSigns = root.getChildren("astralSign");
        signIterator = astralSigns.iterator();

        while(signIterator.hasNext()){
            currentSign = signIterator.next();

            astralSignList.add(new AstralSign(currentSign.getAttributeValue("name"), currentSign.getAttributeValue("description")));
        }

        return astralSignList;
    }

    @Override
    public LinkedList<Race> raceLoader(){
        System.out.println("Loading races");
        SAXBuilder sxb = new SAXBuilder();
        List<Element> races;
        Element currentRace;
        Iterator<Element> iteratorRaces;

        LinkedList<Race> raceLinkedList = new LinkedList<Race>();
        Race race;

        Element eProfile;
        Profile profile;
        List<Element> eWounds;
        int[] wounds;
        List<Element> eFate;
        int[] fate;
        List<Element> eWeight;
        int[] weight;
        List<Element> eAge;
        int[] age;
        Element eMNames;
        String[] mNames;
        Element eFNames;
        String[] fNames;
        Element eEyeColour;
        String[] eyeColour;
        Element eHairColour;
        String[] hairColour;

        List<Element> skillTable;
        List<Element> eSkillsChoice;
        LinkedList<Skill> currentSkillSet;
        LinkedList<LinkedList<Skill>> skills;
        List<Element> talentTable;
        List<Element> eTalentsChoice;
        LinkedList<Talent> currentTalentSet;
        LinkedList<LinkedList<Talent>> talents;
        List<Element> weaponTable;
        List<Element> eWeaponsChoice;
        LinkedList<Weapon> currentWeaponSet;
        LinkedList<LinkedList<Weapon>> weapons;
        List<Element> armourTable;
        List<Element> eArmoursChoice;
        LinkedList<Armour> currentArmourSet;
        LinkedList<LinkedList<Armour>> armours;
        List<Element> equipmentTable;
        List<Element> eEquipmentsChoice;
        LinkedList<Equipment> currentEquipmentSet;
        LinkedList<LinkedList<Equipment>> equipments;

        LinkedList<String> birthPlaces;
        List<Element> birthPlacesTable;
        LinkedList<God> worshipedGods;
        List<Element> worshipedGodsTable;

        try{
            document = sxb.build(new File("resources/races.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        races = root.getChildren("race");
        iteratorRaces = races.iterator();

        while(iteratorRaces.hasNext()){
            currentRace = iteratorRaces.next();
            System.out.println("\tLoading " + currentRace.getAttributeValue("name"));

            eProfile = currentRace.getChild("profile");
            profile = new Profile(Integer.parseInt(eProfile.getAttributeValue("WS")), Integer.parseInt(eProfile.getAttributeValue("BS")),
                    Integer.parseInt(eProfile.getAttributeValue("S")), Integer.parseInt(eProfile.getAttributeValue("T")),
                    Integer.parseInt(eProfile.getAttributeValue("Ag")), Integer.parseInt(eProfile.getAttributeValue("Int")),
                    Integer.parseInt(eProfile.getAttributeValue("WP")), Integer.parseInt(eProfile.getAttributeValue("Fel")),
                    Integer.parseInt(eProfile.getAttributeValue("M")));

            eWounds = currentRace.getChildren("wounds");
            wounds = new int[eWounds.size()];

            for(int i = 0 ; i < eWounds.size() ; i++){
                wounds[i] = Integer.parseInt(eWounds.get(i).getText());
            }

            eFate = currentRace.getChildren("fate");
            fate = new int[eFate.size()];

            for(int i = 0 ; i < eFate.size() ; i++){
                fate[i] = Integer.parseInt(eFate.get(i).getText());
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

            eWeight = currentRace.getChildren("weight");
            weight = new int[eWeight.size()];

            for(int i = 0 ; i < eWeight.size() ; i++){
                weight[i] = Integer.parseInt(eWeight.get(i).getText());
            }

            eAge = currentRace.getChildren("age");
            age = new int[eAge.size()];

            for(int i = 0 ; i < eAge.size() ; i++){
                age[i] = Integer.parseInt(eAge.get(i).getText());
            }

            skills = new LinkedList<LinkedList<Skill>>();
            skillTable = currentRace.getChildren("skillTable");

            for (Element eSkill : skillTable) {
                currentSkillSet = new LinkedList<Skill>();
                eSkillsChoice = eSkill.getChildren("skill");
                for (Element anESkillsChoice : eSkillsChoice) {
                    currentSkillSet.add(World.loadSkill(anESkillsChoice.getText()));
                }

                skills.add(currentSkillSet);
            }

            talents = new LinkedList<LinkedList<Talent>>();
            talentTable = currentRace.getChildren("talentTable");

            for (Element eTalent : talentTable) {
                currentTalentSet = new LinkedList<Talent>();
                eTalentsChoice = eTalent.getChildren("talent");
                for (Element anETalentsChoice : eTalentsChoice) {
                    currentTalentSet.add(World.loadTalent(anETalentsChoice.getText()));
                }

                talents.add(currentTalentSet);
            }

            weapons = new LinkedList<LinkedList<Weapon>>();
            weaponTable = currentRace.getChildren("weaponTable");

            for (Element eWeapon : weaponTable) {
                currentWeaponSet = new LinkedList<Weapon>();
                eWeaponsChoice = eWeapon.getChildren("weapon");
                for (Element anEWeaponsChoice : eWeaponsChoice) {
                    currentWeaponSet.add(World.loadWeapon(anEWeaponsChoice.getText()));
                }

                if (currentWeaponSet.size() != 0) {
                    weapons.add(currentWeaponSet);
                }
            }

            armours = new LinkedList<LinkedList<Armour>>();
            armourTable = currentRace.getChildren("armourTable");

            for (Element eArmour : armourTable) {
                currentArmourSet = new LinkedList<Armour>();
                eArmoursChoice = eArmour.getChildren("armour");
                for (Element anEArmoursChoice : eArmoursChoice) {
                    currentArmourSet.add(World.loadArmour(anEArmoursChoice.getText()));
                }

                if (currentArmourSet.size() != 0) {
                    armours.add(currentArmourSet);
                }
            }

            equipments = new LinkedList<LinkedList<Equipment>>();
            equipmentTable = currentRace.getChildren("equipmentTable");

            for (Element eEquipment : equipmentTable) {
                currentEquipmentSet = new LinkedList<Equipment>();
                eEquipmentsChoice = eEquipment.getChildren("equipment");
                for (Element anEEquipmentsChoice : eEquipmentsChoice) {
                    currentEquipmentSet.add(World.loadEquipment(anEEquipmentsChoice.getText()));
                }

                if (currentEquipmentSet.size() != 0) {
                    equipments.add(currentEquipmentSet);
                }
            }

            birthPlaces = new LinkedList<String>();
            birthPlacesTable = currentRace.getChildren("birthPlace");

            for(Element eBirthPlace : birthPlacesTable){
                birthPlaces.add(eBirthPlace.getText());
            }

            worshipedGods = new LinkedList<God>();
            worshipedGodsTable = currentRace.getChildren("god");

            for(Element eWorshipedGod : worshipedGodsTable){
                worshipedGods.add(World.loadGod(eWorshipedGod.getText()));
            }


            race = new Race(currentRace.getAttributeValue("name"), profile,
                    Integer.parseInt(currentRace.getChild("size").getAttributeValue("F")),
                    Integer.parseInt(currentRace.getChild("size").getAttributeValue("M")),
                    wounds, fate, weight, age, mNames, fNames, hairColour, eyeColour, skills, talents, weapons,
                    armours, equipments, birthPlaces, worshipedGods);

            raceLinkedList.add(race);
        }

        System.out.println("\n");
        return raceLinkedList;
    }

    @Override
    public LinkedList<Career> careerLoader(){
        System.out.println("Loading careers");
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

        Element racesTable;
        LinkedList<Race> availableRaces;

        try{
            document = sxb.build(new File("resources/careers.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        careers = root.getChildren("career");
        iteratorCareers = careers.iterator();

        while(iteratorCareers.hasNext()){
            currentCareer = iteratorCareers.next();
            System.out.println("\tLoading " + currentCareer.getAttributeValue("name"));

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
                    currentSkillSet.add(World.loadSkill(anESkillsChoice.getText()));
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
                    currentTalentSet.add(World.loadTalent(anETalentsChoice.getText()));
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
                    currentWeaponSet.add(World.loadWeapon(anEWeaponsChoice.getText()));
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
                    currentArmourSet.add(World.loadArmour(anEArmoursChoice.getText()));
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
                    currentEquipmentSet.add(World.loadEquipment(anEEquipmentsChoice.getText()));
                }

                if (currentEquipmentSet.size() != 0) {
                    equipments.add(currentEquipmentSet);
                }
            }

            racesTable = currentCareer.getChild("availableRaces");

            if(racesTable == null){
                availableRaces = World.RACES;
            } else {
                if(racesTable.getChildren("race") == null || racesTable.getChildren("race").isEmpty()){
                    availableRaces = World.RACES;
                } else {
                    availableRaces = new LinkedList<Race>();

                    for(Element race : racesTable.getChildren("race")){
                        availableRaces.add(World.loadRace(race.getText()));
                    }
                }
            }

            career = new Career(currentCareer.getAttributeValue("name"), profile, skills, talents, equipments, weapons, armours, availableRaces, Integer.parseInt(currentCareer.getAttributeValue("type")));

            careerLinkedList.add(career);
        }
        System.out.println("\n");

        Collections.sort(careerLinkedList);

        return careerLinkedList;
    }

    @Override
    public void careerLinker(Career career){
        System.out.println("Linking career : " + career.getName());
        SAXBuilder sxb = new SAXBuilder();
        List<Element> careers;
        Element currentCareer;
        Iterator<Element> iteratorCareers;

        try{
            document = sxb.build(new File("resources/careers.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        careers = root.getChildren("career");

        currentCareer = searchElementCareerByName(careers, career.getName());

        LinkedList<Career> accessCareer;

        if(career.getAccessCareers() == null || career.getAccessCareers().isEmpty()) {
            accessCareer = new LinkedList<Career>();
        } else {
            accessCareer = career.getAccessCareers();
        }

        List<Element> eAccessCareers = currentCareer.getChild("accessTable").getChildren();

        for(Element element : eAccessCareers){
            Career currentAccess = World.loadCareer(element.getText());
            if(currentAccess != null){
                accessCareer.add(World.loadCareer(element.getText()));

                if(!currentAccess.getOpeningCareers().contains(career)){
                    currentAccess.addOpeningCareer(career);
                }
            }
        }

        career.setAccessCareers(accessCareer);

        LinkedList<Career> openingCareer;

        if(career.getOpeningCareers() == null || career.getOpeningCareers().isEmpty()) {
            openingCareer = new LinkedList<Career>();
        } else {
            openingCareer = career.getOpeningCareers();
        }

        List<Element> eOpeningCareers = currentCareer.getChild("openingTable").getChildren();

        for(Element element : eOpeningCareers){
            Career currentOpening = World.loadCareer(element.getText());

            if(currentOpening != null){
                openingCareer.add(currentOpening);

                if(!currentOpening.getAccessCareers().contains(career)){
                    currentOpening.addAccessCareer(career);
                }
            }
        }

        career.setOpeningCareers(openingCareer);
    }

    private Element searchElementCareerByName(List<Element> careers, String name){
        Element career = null;

        for(Element currentCareer : careers){
            if(currentCareer.getAttributeValue("name").equals(name)){
                career = currentCareer;
            }
        }

        return career;
    }

    @Override
    public LinkedList<String> distinguishingsSignsLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> distinguishingSigns;
        Element currentSign;
        Iterator<Element> signIterator;

        LinkedList<String> distinguishingSignList = new LinkedList<String>();

        try{
            document = sxb.build(new File("resources/distinguishingSigns.xml"));
        }catch (JDOMException ignored) {}
        catch (IOException ignored) {}

        root = document.getRootElement();

        distinguishingSigns = root.getChildren("distinguishingSign");
        signIterator = distinguishingSigns.iterator();

        while(signIterator.hasNext()){
            currentSign = signIterator.next();

            distinguishingSignList.add(currentSign.getText());
        }

        return distinguishingSignList;
    }*/

    public HashMap<String, ?> nameLoader(String name){
        HashMap<String, ?> map;
        switch (name) {
            case "skill":
                map = new HashMap<String, Skill>();

                break;
            case "talent":
                map = new HashMap<String, Talent>();

                break;
            case "equipment":
                map = new HashMap<String, Equipment>();

                break;
            case "weapon":
                map = new HashMap<String, Weapon>();

                break;
            case "armour":
                map = new HashMap<String, Armour>();

                break;
            case "god":
                map = new HashMap<String, God>();

                break;
            case "astralSign":
                map = new HashMap<String, AstralSign>();

                break;
            case "race":
                map = new HashMap<String, Race>();

                break;
            case "career":
                map = new HashMap<String, Career>();

                break;
            case "distinguishingSign":
                map = new HashMap<String, String>();

                break;
            default:
                System.err.println("Error : name not found : " + name);
                return null;
        }


        SAXBuilder sxb = new SAXBuilder();
        List<Element> elements;
        Element currentElement;
        Iterator<Element> iteratorElements;

        try{
            document = sxb.build(new File("resources/" + name +"s.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        elements = root.getChildren(name);
        iteratorElements = elements.iterator();

        while(iteratorElements.hasNext()){
            currentElement = iteratorElements.next();
            if(name.equals("distinguishingSign")){
                map.put(currentElement.getText(), null);
            } else {
                map.put(currentElement.getAttributeValue("name"), null);
            }
        }

        return map;
    }

    /* Unit Loaders */

    @Override
    public Skill skillLoader(String skill) {
        List<Element> skills;
        Element currentSkill;
        Iterator<Element> iteratorSkills;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/skills.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        skills = root.getChildren("skill");
        iteratorSkills = skills.iterator();

        while (iteratorSkills.hasNext()){
            currentSkill = iteratorSkills.next();
            if(currentSkill.getAttributeValue("name").equals(skill)){
                return new Skill(currentSkill.getAttributeValue("name"), currentSkill.getAttributeValue("characteristics"));
            }
        }

        return null;
    }

    @Override
    public Talent talentLoader(String talent) {
        List<Element> talents;
        Element currentTalent;
        Iterator<Element> iteratorTalents;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/talents.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        talents = root.getChildren("talent");
        iteratorTalents = talents.iterator();

        while (iteratorTalents.hasNext()){
            currentTalent = iteratorTalents.next();
            if(currentTalent.getAttributeValue("name").equals(talent)){
                return new Talent(currentTalent.getAttributeValue("name"), currentTalent.getAttributeValue("description"));
            }
        }

        return null;
    }

    @Override
    public Equipment equipmentLoader(String equipment) {
        List<Element> equipments;
        Element currentEquipment;
        Iterator<Element> iteratorEquipments;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/equipments.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        equipments = root.getChildren("equipment");
        iteratorEquipments = equipments.iterator();

        while (iteratorEquipments.hasNext()){
            currentEquipment = iteratorEquipments.next();
            if(currentEquipment.getAttributeValue("name").equals(equipment)){
                return new Equipment(currentEquipment.getAttributeValue("name"), new Money(
                        Integer.parseInt(currentEquipment.getAttributeValue("goldenCrowns")),
                        Integer.parseInt(currentEquipment.getAttributeValue("silverShillings")),
                        Integer.parseInt(currentEquipment.getAttributeValue("brassPennies"))),
                        Integer.parseInt(currentEquipment.getAttributeValue("enc")));
            }
        }

        return null;
    }

    @Override
    public Weapon weaponLoader(String weapon) {
        List<Element> weapons;
        Element currentWeapon;
        Iterator<Element> iteratorWeapons;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/weapons.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        weapons = root.getChildren("weapon");
        iteratorWeapons = weapons.iterator();

        while (iteratorWeapons.hasNext()){
            currentWeapon = iteratorWeapons.next();
            if(currentWeapon.getAttributeValue("name").equals(weapon)){
                LinkedList<String> attributes = new LinkedList<>();

                List<Element> eAttributes = currentWeapon.getChildren("attribute");

                for (Element eAttribute : eAttributes) {
                    attributes.add(eAttribute.getText());
                }

               return new Weapon(currentWeapon.getAttributeValue("name"), new Money(
                        Integer.parseInt(currentWeapon.getAttributeValue("goldenCrowns")),
                        Integer.parseInt(currentWeapon.getAttributeValue("silverShillings")),
                        Integer.parseInt(currentWeapon.getAttributeValue("brassPennies"))),
                        Integer.parseInt(currentWeapon.getAttributeValue("enc")),
                        currentWeapon.getAttributeValue("group"),
                        currentWeapon.getAttributeValue("damage"),
                        Integer.parseInt(currentWeapon.getAttributeValue("lowRange")),
                        Integer.parseInt(currentWeapon.getAttributeValue("highRange")),
                        Integer.parseInt(currentWeapon.getAttributeValue("reload")), attributes);
            }
        }

        return null;
    }

    @Override
    public Armour armourLoader(String armour) {
        List<Element> armours;
        Element currentArmour;
        Iterator<Element> iteratorArmours;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/armours.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        armours = root.getChildren("armour");
        iteratorArmours = armours.iterator();

        while (iteratorArmours.hasNext()){
            currentArmour = iteratorArmours.next();
            if(currentArmour.getAttributeValue("name").equals(armour)){
                LinkedList<String> zones = new LinkedList<>();

                List<Element> eZones = currentArmour.getChildren("zone");

                for (Element eZone : eZones) {
                    zones.add(eZone.getText());
                }

                return new Armour(currentArmour.getAttributeValue("name"), new Money(
                        Integer.parseInt(currentArmour.getAttributeValue("goldenCrowns")),
                        Integer.parseInt(currentArmour.getAttributeValue("silverShillings")),
                        Integer.parseInt(currentArmour.getAttributeValue("brassPennies"))),
                        Integer.parseInt(currentArmour.getAttributeValue("enc")),
                        Integer.parseInt(currentArmour.getAttributeValue("armourLevel")), zones, currentArmour.getAttributeValue("armourType"));
            }
        }

        return null;
    }

    @Override
    public God godLoader(String god) {
        List<Element> gods;
        Element currentGod;
        Iterator<Element> iteratorGods;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/gods.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        gods = root.getChildren("god");
        iteratorGods = gods.iterator();

        while (iteratorGods.hasNext()){
            currentGod = iteratorGods.next();
            if(currentGod.getAttributeValue("name").equals(god)){
                LinkedList<String> domains = new LinkedList<>();
                List<Element> eDomains = currentGod.getChildren("domain");
                for(Element domain : eDomains){
                    domains.add(domain.getText());
                }

                LinkedList<String> worshipers = new LinkedList<>();
                List<Element>  eWorshipers = currentGod.getChildren("worshiper");
                for(Element worshiper : eWorshipers){
                    worshipers.add(worshiper.getText());
                }

                return new God(currentGod.getAttributeValue("name"), domains, worshipers);
            }
        }

        return null;
    }

    @Override
    public AstralSign astralSignsLoader(String astralSign) {
        List<Element> astralSigns;
        Element currentAstralSign;
        Iterator<Element> iteratorAstralSigns;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/astralSigns.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        astralSigns = root.getChildren("astralSign");
        iteratorAstralSigns = astralSigns.iterator();

        while (iteratorAstralSigns.hasNext()){
            currentAstralSign = iteratorAstralSigns.next();
            if(currentAstralSign.getAttributeValue("name").equals(astralSign)){
                return new AstralSign(currentAstralSign.getAttributeValue("name"), currentAstralSign.getAttributeValue("description"));
            }
        }

        return null;
    }

    @Override
    public Race raceLoader(String race) {
        List<Element> races;
        Element currentRace;
        Iterator<Element> iteratorRaces;

        Element eProfile;
        Profile profile;
        List<Element> eWounds;
        int[] wounds;
        List<Element> eFate;
        int[] fate;
        List<Element> eWeight;
        int[] weight;
        List<Element> eAge;
        int[] age;
        Element eMNames;
        String[] mNames;
        Element eFNames;
        String[] fNames;
        Element eEyeColour;
        String[] eyeColour;
        Element eHairColour;
        String[] hairColour;

        List<Element> skillTable;
        List<Element> eSkillsChoice;
        LinkedList<String> currentSkillSet;
        LinkedList<LinkedList<String>> skills;
        List<Element> talentTable;
        List<Element> eTalentsChoice;
        LinkedList<String> currentTalentSet;
        LinkedList<LinkedList<String>> talents;
        List<Element> weaponTable;
        List<Element> eWeaponsChoice;
        LinkedList<String> currentWeaponSet;
        LinkedList<LinkedList<String>> weapons;
        List<Element> armourTable;
        List<Element> eArmoursChoice;
        LinkedList<String> currentArmourSet;
        LinkedList<LinkedList<String>> armours;
        List<Element> equipmentTable;
        List<Element> eEquipmentsChoice;
        LinkedList<String> currentEquipmentSet;
        LinkedList<LinkedList<String>> equipments;

        LinkedList<String> birthPlaces;
        List<Element> birthPlacesTable;
        LinkedList<String> worshipedGods;
        List<Element> worshipedGodsTable;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/races.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        races = root.getChildren("race");
        iteratorRaces = races.iterator();

        while (iteratorRaces.hasNext()){
            currentRace = iteratorRaces.next();
            if(currentRace.getAttributeValue("name").equals(race)){
                eProfile = currentRace.getChild("profile");
                profile = new Profile(Integer.parseInt(eProfile.getAttributeValue("WS")), Integer.parseInt(eProfile.getAttributeValue("BS")),
                        Integer.parseInt(eProfile.getAttributeValue("S")), Integer.parseInt(eProfile.getAttributeValue("T")),
                        Integer.parseInt(eProfile.getAttributeValue("Ag")), Integer.parseInt(eProfile.getAttributeValue("Int")),
                        Integer.parseInt(eProfile.getAttributeValue("WP")), Integer.parseInt(eProfile.getAttributeValue("Fel")),
                        Integer.parseInt(eProfile.getAttributeValue("M")));

                eWounds = currentRace.getChildren("wounds");
                wounds = new int[eWounds.size()];

                for(int i = 0 ; i < eWounds.size() ; i++){
                    wounds[i] = Integer.parseInt(eWounds.get(i).getText());
                }

                eFate = currentRace.getChildren("fate");
                fate = new int[eFate.size()];

                for(int i = 0 ; i < eFate.size() ; i++){
                    fate[i] = Integer.parseInt(eFate.get(i).getText());
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

                eWeight = currentRace.getChildren("weight");
                weight = new int[eWeight.size()];

                for(int i = 0 ; i < eWeight.size() ; i++){
                    weight[i] = Integer.parseInt(eWeight.get(i).getText());
                }

                eAge = currentRace.getChildren("age");
                age = new int[eAge.size()];

                for(int i = 0 ; i < eAge.size() ; i++){
                    age[i] = Integer.parseInt(eAge.get(i).getText());
                }

                skills = new LinkedList<>();
                skillTable = currentRace.getChildren("skillTable");

                for (Element eSkill : skillTable) {
                    currentSkillSet = new LinkedList<>();
                    eSkillsChoice = eSkill.getChildren("skill");
                    for (Element anESkillsChoice : eSkillsChoice) {
                        currentSkillSet.add(anESkillsChoice.getText());
                    }

                    skills.add(currentSkillSet);
                }

                talents = new LinkedList<>();
                talentTable = currentRace.getChildren("talentTable");

                for (Element eTalent : talentTable) {
                    currentTalentSet = new LinkedList<>();
                    eTalentsChoice = eTalent.getChildren("talent");
                    for (Element anETalentsChoice : eTalentsChoice) {
                        currentTalentSet.add(anETalentsChoice.getText());
                    }

                    talents.add(currentTalentSet);
                }

                weapons = new LinkedList<>();
                weaponTable = currentRace.getChildren("weaponTable");

                for (Element eWeapon : weaponTable) {
                    currentWeaponSet = new LinkedList<>();
                    eWeaponsChoice = eWeapon.getChildren("weapon");
                    for (Element anEWeaponsChoice : eWeaponsChoice) {
                        currentWeaponSet.add(anEWeaponsChoice.getText());
                    }

                    if (currentWeaponSet.size() != 0) {
                        weapons.add(currentWeaponSet);
                    }
                }

                armours = new LinkedList<>();
                armourTable = currentRace.getChildren("armourTable");

                for (Element eArmour : armourTable) {
                    currentArmourSet = new LinkedList<>();
                    eArmoursChoice = eArmour.getChildren("armour");
                    for (Element anEArmoursChoice : eArmoursChoice) {
                        currentArmourSet.add(anEArmoursChoice.getText());
                    }

                    if (currentArmourSet.size() != 0) {
                        armours.add(currentArmourSet);
                    }
                }

                equipments = new LinkedList<>();
                equipmentTable = currentRace.getChildren("equipmentTable");

                for (Element eEquipment : equipmentTable) {
                    currentEquipmentSet = new LinkedList<>();
                    eEquipmentsChoice = eEquipment.getChildren("equipment");
                    for (Element anEEquipmentsChoice : eEquipmentsChoice) {
                        currentEquipmentSet.add(anEEquipmentsChoice.getText());
                    }

                    if (currentEquipmentSet.size() != 0) {
                        equipments.add(currentEquipmentSet);
                    }
                }

                birthPlaces = new LinkedList<>();
                birthPlacesTable = currentRace.getChildren("birthPlace");

                for(Element eBirthPlace : birthPlacesTable){
                    birthPlaces.add(eBirthPlace.getText());
                }

                worshipedGods = new LinkedList<>();
                worshipedGodsTable = currentRace.getChildren("god");

                for(Element eWorshipedGod : worshipedGodsTable){
                    worshipedGods.add(eWorshipedGod.getText());
                }


                return new Race(currentRace.getAttributeValue("name"), profile,
                        Integer.parseInt(currentRace.getChild("size").getAttributeValue("F")),
                        Integer.parseInt(currentRace.getChild("size").getAttributeValue("M")),
                        wounds, fate, weight, age, mNames, fNames, hairColour, eyeColour, skills, talents, weapons,
                        armours, equipments, birthPlaces, worshipedGods);
            }
        }

        return null;
    }

    @Override
    public Career careerLoader(String career) {
        List<Element> careers;
        Element currentCareer;
        Iterator<Element> iteratorCareers;

        Element eProfile;
        Profile profile;

        Element skillTable;
        List<Element> eSkills;
        List<Element> eSkillsChoice;
        LinkedList<String> currentSkillSet;
        LinkedList<LinkedList<String>> skills;

        Element talentTable;
        List<Element> eTalents;
        List<Element> eTalentsChoice;
        LinkedList<String> currentTalentSet;
        LinkedList<LinkedList<String>> talents;

        Element weaponTable;
        List<Element> eWeapons;
        List<Element> eWeaponsChoice;
        LinkedList<String> currentWeaponSet;
        LinkedList<LinkedList<String>> weapons;

        Element armourTable;
        List<Element> eArmours;
        List<Element> eArmoursChoice;
        LinkedList<String> currentArmourSet;
        LinkedList<LinkedList<String>> armours;

        Element equipmentTable;
        List<Element> eEquipments;
        List<Element> eEquipmentsChoice;
        LinkedList<String> currentEquipmentSet;
        LinkedList<LinkedList<String>> equipments;

        Element racesTable;
        LinkedList<String> availableRaces;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/careers.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        careers = root.getChildren("career");
        iteratorCareers = careers.iterator();

        while (iteratorCareers.hasNext()){
            currentCareer = iteratorCareers.next();
            if(currentCareer.getAttributeValue("name").equals(career)){
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

                skills = new LinkedList<>();
                skillTable = currentCareer.getChild("skillsTable");
                eSkills = skillTable.getChildren("eSkills");

                for (Element eSkill : eSkills) {
                    currentSkillSet = new LinkedList<>();
                    eSkillsChoice = eSkill.getChildren("choice");
                    for (Element anESkillsChoice : eSkillsChoice) {
                        currentSkillSet.add(anESkillsChoice.getText());
                    }

                    skills.add(currentSkillSet);
                }

                talents = new LinkedList<>();
                talentTable = currentCareer.getChild("talentsTable");
                eTalents = talentTable.getChildren("eTalents");

                for (Element eTalent : eTalents) {
                    currentTalentSet = new LinkedList<>();
                    eTalentsChoice = eTalent.getChildren("choice");
                    for (Element anETalentsChoice : eTalentsChoice) {
                        currentTalentSet.add(anETalentsChoice.getText());
                    }

                    talents.add(currentTalentSet);
                }

                weapons = new LinkedList<>();
                weaponTable = currentCareer.getChild("weaponsTable");
                eWeapons = weaponTable.getChildren("eWeapons");

                for (Element eWeapon : eWeapons) {
                    currentWeaponSet = new LinkedList<>();
                    eWeaponsChoice = eWeapon.getChildren("choice");
                    for (Element anEWeaponsChoice : eWeaponsChoice) {
                        currentWeaponSet.add(anEWeaponsChoice.getText());
                    }

                    if (currentWeaponSet.size() != 0) {
                        weapons.add(currentWeaponSet);
                    }
                }

                armours = new LinkedList<>();
                armourTable = currentCareer.getChild("armoursTable");
                eArmours = armourTable.getChildren("eArmours");

                for (Element eArmour : eArmours) {
                    currentArmourSet = new LinkedList<>();
                    eArmoursChoice = eArmour.getChildren("choice");
                    for (Element anEArmoursChoice : eArmoursChoice) {
                        currentArmourSet.add(anEArmoursChoice.getText());
                    }

                    if (currentArmourSet.size() != 0) {
                        armours.add(currentArmourSet);
                    }
                }

                equipments = new LinkedList<>();
                equipmentTable = currentCareer.getChild("equipmentsTable");
                eEquipments = equipmentTable.getChildren("eEquipments");

                for (Element eEquipment : eEquipments) {
                    currentEquipmentSet = new LinkedList<>();
                    eEquipmentsChoice = eEquipment.getChildren("choice");
                    for (Element anEEquipmentsChoice : eEquipmentsChoice) {
                        currentEquipmentSet.add(anEEquipmentsChoice.getText());
                    }

                    if (currentEquipmentSet.size() != 0) {
                        equipments.add(currentEquipmentSet);
                    }
                }

                racesTable = currentCareer.getChild("availableRaces");

                if(racesTable == null){
                    availableRaces = new LinkedList<>(World.RACES.keySet());
                } else {
                    if(racesTable.getChildren("race") == null || racesTable.getChildren("race").isEmpty()){
                        availableRaces = new LinkedList<>(World.RACES.keySet());
                    } else {
                        availableRaces = new LinkedList<>();

                        for(Element race : racesTable.getChildren("race")){
                            availableRaces.add(race.getText());
                        }
                    }
                }

                Career.CareerType type;
                if(Integer.parseInt(currentCareer.getAttributeValue("type")) == 1){
                    type = Career.CareerType.BASE;
                } else {
                    type = Career.CareerType.AVANCE;
                }

                return new Career(currentCareer.getAttributeValue("name"), profile, skills, talents, equipments, weapons, armours, availableRaces, type);
            }
        }

        return null;
    }

    @Override
    public String distinguishingsSignsLoader(String distinguishingSign) {
        List<Element> distinguishingSigns;
        Element currentDistinguishingSign;
        Iterator<Element> iteratorDistinguishingSigns;

        SAXBuilder sxb = new SAXBuilder();
        try{
            document = sxb.build(new File("resources/distinguishingSigns.xml"));
        }catch (JDOMException | IOException ignored) {}

        root = document.getRootElement();

        distinguishingSigns = root.getChildren("distinguishingSign");
        iteratorDistinguishingSigns = distinguishingSigns.iterator();

        while (iteratorDistinguishingSigns.hasNext()){
            currentDistinguishingSign = iteratorDistinguishingSigns.next();
            if(currentDistinguishingSign.getText().equals(distinguishingSign)){
                return currentDistinguishingSign.getText();
            }
        }

        return null;
    }
}
