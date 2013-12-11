package core.entities;

import core.World;
import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;
import gui.listeners.characterListener.removeCharacterAL;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * User: Linked
 * Date: 12/11/13
 * Time: 15:14
 */
public class Character {
    private String name;
    private String player;
    private String type;

    private Race race;
    private Career career;
    private LinkedList<Career> previousCareers;
    private Profile profile;
    private Profile basicProfile;
    private LinkedList<Skill> skills;
    private LinkedList<Talent> talents;
    private LinkedList<Weapon> weapons;
    private LinkedList<Armour> armours;
    private LinkedList<Equipment> equipment;
    private Money money;
    private PersonalDetails details;

    private int actualWounds;

    public Character(String name, String player, Race race, Career career,
                     LinkedList<Career> previousCareers, Profile profile,
                     LinkedList<Skill> skills, LinkedList<Talent> talents,
                     LinkedList<Weapon> weapons, LinkedList<Armour> armours,
                     LinkedList<Equipment> equipment, Money money,
                     PersonalDetails details, int actualWounds) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.previousCareers = previousCareers;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipment = equipment;
        this.money = money;
        this.details = details;
        this.actualWounds = actualWounds;
        this.type = "NPC";
    }

    public Character(String name, String player, Race race, Career career,
                     LinkedList<Career> previousCareers, Profile profile,
                     LinkedList<Skill> skills, LinkedList<Talent> talents,
                     LinkedList<Weapon> weapons, LinkedList<Armour> armours,
                     LinkedList<Equipment> equipment, Money money,
                     PersonalDetails details) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.previousCareers = previousCareers;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipment = equipment;
        this.money = money;
        this.details = details;
        this.actualWounds = profile.getW();
        this.type = "NPC";
    }

    public Character(String name, String player, Race race, Career career) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = "NPC";

        randomCharacter(type);

        this.actualWounds = profile.getW();
    }

    public Character(String player, Race race, Career career) {
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = "NPC";

        randomCharacter(type);
        randomName();

        this.actualWounds = profile.getW();
    }

    public Character(Race race, Career career) {
        this.player = "npc";
        this.race = race;
        this.career = career;
        this.type = "NPC";

        randomCharacter(type);
        randomName();

        this.previousCareers = new LinkedList<Career>();
        this.actualWounds = profile.getW();
    }

    public Character(String name, String player, Race race, Career career,
                     LinkedList<Career> previousCareers, Profile profile,
                     LinkedList<Skill> skills, LinkedList<Talent> talents,
                     LinkedList<Weapon> weapons, LinkedList<Armour> armours,
                     LinkedList<Equipment> equipment, Money money,
                     PersonalDetails details, int actualWounds, String type) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.previousCareers = previousCareers;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipment = equipment;
        this.money = money;
        this.details = details;
        this.actualWounds = actualWounds;
        this.type = type;
    }

    public Character(String name, String player, Race race, Career career,
                     LinkedList<Career> previousCareers, Profile profile,
                     LinkedList<Skill> skills, LinkedList<Talent> talents,
                     LinkedList<Weapon> weapons, LinkedList<Armour> armours,
                     LinkedList<Equipment> equipment, Money money,
                     PersonalDetails details, String type) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.previousCareers = previousCareers;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipment = equipment;
        this.money = money;
        this.details = details;
        this.actualWounds = profile.getW();
        this.type = type;
    }

    public Character(String name, String player, Race race, Career career, String type) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = type;

        randomCharacter(type);

        this.actualWounds = profile.getW();
    }

    public Character(String player, Race race, Career career, String type) {
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = type;

        randomCharacter(type);
        randomName();

        this.actualWounds = profile.getW();
    }

    public Character(Race race, Career career, String type) {
        this.player = "npc";
        this.race = race;
        this.career = career;
        this.type = type;

        randomCharacter(type);
        randomName();

        this.actualWounds = profile.getW();
    }

    public void randomName(){
        Random r = new Random();

        if(this.details.isMale())
            this.name = this.race.getmNames()[r.nextInt(this.race.getmNames().length)];
        else
            this.name = this.race.getfNames()[r.nextInt(this.race.getfNames().length)];
    }

    public void randomCharacter(String type){
        if(type.equals("PC"))
            this.basicProfile = randomPCProfile();
        else
            this.basicProfile = randomNPCProfile();

        //this.profile = basicProfile.clone();


        this.details = randomDetails();

        this.money = randomMoney();
        this.previousCareers = career.getRandomPreviousCareers(0, 0, new LinkedList<Career>(), new LinkedList<LinkedList<Career>>());

        this.applyCareers();
        System.out.println(this.basicProfile);

    }

    public Profile randomNPCProfile(){
        Random r = new Random();
        Profile raceProfile = this.race.getProfile();

        return new Profile(
                raceProfile.getWs() + (r.nextInt(10) + 1),
                raceProfile.getBs() + (r.nextInt(10) + 1),
                raceProfile.getS() + (r.nextInt(10) + 1),
                raceProfile.getT() + (r.nextInt(10) + 1),
                raceProfile.getAg() + (r.nextInt(10) + 1),
                raceProfile.getIntel() + (r.nextInt(10) + 1),
                raceProfile.getWp() + (r.nextInt(10) + 1),
                raceProfile.getFel() + (r.nextInt(10) + 1),
                1,
                race.getWounds()[r.nextInt(race.getWounds().length)],
                raceProfile.getM(),
                0);
    }

    public Profile randomPCProfile(){
        Random r = new Random();
        Profile raceProfile = this.race.getProfile();

        Profile newProfile = new Profile(
                raceProfile.getWs() + (r.nextInt(10) + 1),
                raceProfile.getBs() + (r.nextInt(10) + 1),
                raceProfile.getS() + (r.nextInt(10) + 1),
                raceProfile.getT() + (r.nextInt(10) + 1),
                raceProfile.getAg() + (r.nextInt(10) + 1),
                raceProfile.getIntel() + (r.nextInt(10) + 1),
                raceProfile.getWp() + (r.nextInt(10) + 1),
                raceProfile.getFel() + (r.nextInt(10) + 1),
                1,
                race.getWounds()[r.nextInt(race.getWounds().length)],
                raceProfile.getM(),
                0);

        newProfile.setFp(race.getFate()[r.nextInt(race.getFate().length)]);

        return newProfile;
    }

    public PersonalDetails randomDetails(){
        Random r = new Random();

        boolean male = r.nextBoolean();
        int size = race.getfSize();
        if(male){
            size = race.getmSize();
        }

        String eyeColour = race.getEyeColour()[r.nextInt(race.getEyeColour().length)];

        String birthPlace = this.getRace().getBirthPlaces().get(r.nextInt(this.getRace().getBirthPlaces().size()));
        God worshipedGod = this.getRace().getWorshipedGods().get(r.nextInt(this.getRace().getWorshipedGods().size()));
        AstralSign astralSign = World.ASTRALSIGNS.get(r.nextInt(World.ASTRALSIGNS.size()));

        LinkedList<String> distinguishingMarks = new LinkedList<String>();
        String selectedMark;
        int nbMarks = r.nextInt(4) + 1;

        for(int i = 0 ; i< nbMarks ; i++){
            do{
                selectedMark = World.DISTINGUISHINGSIGNS.get(r.nextInt(World.DISTINGUISHINGSIGNS.size()));
            } while(distinguishingMarks.contains(selectedMark));

            distinguishingMarks.add(selectedMark);
        }

        return new PersonalDetails(
                male, race.getAge()[r.nextInt(race.getAge().length)],
                birthPlace, worshipedGod, (int)(size + ((r.nextInt(10) + 1) * 2.5)),
                race.getWeight()[r.nextInt(race.getWeight().length)],
                eyeColour, race.getHairColour()[r.nextInt(race.getHairColour().length)],
                astralSign, distinguishingMarks
        );
    }

    public void applyCareers(){
        this.profile = applyCareersProfile();
        this.skills = randomSkills();
        this.talents = randomTalents();
        randomTrappings();
    }

    public Profile applyCareersProfile(){
        Random r = new Random();

        Profile newProfile = basicProfile.clone();

        for(Career career1 : previousCareers){
            if(basicProfile.getWs() + career1.getProfile().getWs() >= newProfile.getWs()){
                newProfile.setWs(basicProfile.getWs() + career1.getProfile().getWs());
            }

            if(basicProfile.getBs() + career1.getProfile().getBs() >= newProfile.getBs()){
                newProfile.setBs(basicProfile.getBs() + career1.getProfile().getBs());
            }

            if(basicProfile.getS() + career1.getProfile().getS() >= newProfile.getS()){
                newProfile.setS(basicProfile.getS() + career1.getProfile().getS());
            }

            if(basicProfile.getT() + career1.getProfile().getT() >= newProfile.getT()){
                newProfile.setT(basicProfile.getT() + career1.getProfile().getT());
            }

            if(basicProfile.getAg() + career1.getProfile().getAg() >= newProfile.getAg()){
                newProfile.setAg(basicProfile.getAg() + career1.getProfile().getAg());
            }

            if(basicProfile.getIntel() + career1.getProfile().getIntel() >= newProfile.getIntel()){
                newProfile.setIntel(basicProfile.getIntel() + career1.getProfile().getIntel());
            }

            if(basicProfile.getWp() + career1.getProfile().getWp() >= newProfile.getWp()){
                newProfile.setWp(basicProfile.getWp() + career1.getProfile().getWp());
            }

            if(basicProfile.getFel() + career1.getProfile().getFel() >= newProfile.getFel()){
                newProfile.setFel(basicProfile.getFel() + career1.getProfile().getFel());
            }

            if(basicProfile.getA() + career1.getProfile().getA() >= newProfile.getA()){
                newProfile.setA(basicProfile.getA() + career1.getProfile().getA());
            }

            if(basicProfile.getW() + career1.getProfile().getW() >= newProfile.getW()){
                newProfile.setW(basicProfile.getW() + career1.getProfile().getW());
            }

            if(basicProfile.getM() + career1.getProfile().getM() >= newProfile.getM()){
                newProfile.setM(basicProfile.getM() + career1.getProfile().getM());
            }

            if(basicProfile.getMag() + career1.getProfile().getMag() >= newProfile.getMag()){
                newProfile.setMag(basicProfile.getMag() + career1.getProfile().getMag());
            }
        }

        if(basicProfile.getWs() + this.getCareer().getProfile().getWs() >= newProfile.getWs()){
            newProfile.setWs(basicProfile.getWs() + this.getCareer().getProfile().getWs());
        }

        if(basicProfile.getBs() + this.getCareer().getProfile().getBs() >= newProfile.getBs()){
            newProfile.setBs(basicProfile.getBs() + this.getCareer().getProfile().getBs());
        }

        if(basicProfile.getS() + this.getCareer().getProfile().getS() >= newProfile.getS()){
            newProfile.setS(basicProfile.getS() + this.getCareer().getProfile().getS());
        }

        if(basicProfile.getT() + this.getCareer().getProfile().getT() >= newProfile.getT()){
            newProfile.setT(basicProfile.getT() + this.getCareer().getProfile().getT());
        }

        if(basicProfile.getAg() + this.getCareer().getProfile().getAg() >= newProfile.getAg()){
            newProfile.setAg(basicProfile.getAg() + this.getCareer().getProfile().getAg());
        }

        if(basicProfile.getIntel() + this.getCareer().getProfile().getIntel() >= newProfile.getIntel()){
            newProfile.setIntel(basicProfile.getIntel() + this.getCareer().getProfile().getIntel());
        }

        if(basicProfile.getWp() + this.getCareer().getProfile().getWp() >= newProfile.getWp()){
            newProfile.setWp(basicProfile.getWp() + this.getCareer().getProfile().getWp());
        }

        if(basicProfile.getFel() + this.getCareer().getProfile().getFel() >= newProfile.getFel()){
            newProfile.setFel(basicProfile.getFel() + this.getCareer().getProfile().getFel());
        }

        if(basicProfile.getA() + this.getCareer().getProfile().getA() >= newProfile.getA()){
            newProfile.setA(basicProfile.getA() + this.getCareer().getProfile().getA());
        }

        if(basicProfile.getW() + this.getCareer().getProfile().getW() >= newProfile.getW()){
            newProfile.setW(basicProfile.getW() + this.getCareer().getProfile().getW());
        }

        if(basicProfile.getM() + this.getCareer().getProfile().getM() >= newProfile.getM()){
            newProfile.setM(basicProfile.getM() + this.getCareer().getProfile().getM());
        }

        if(basicProfile.getMag() + this.getCareer().getProfile().getMag() >= newProfile.getMag()){
            newProfile.setMag(basicProfile.getMag() + this.getCareer().getProfile().getMag());
        }

        newProfile.setSb(newProfile.getS() / 10);
        newProfile.setTb(newProfile.getT() / 10);

        return newProfile;
    }

    public LinkedList<Skill> randomSkills(){
        LinkedList<Skill> newSkills = new LinkedList<Skill>();
        Random r = new Random();

        for(LinkedList<Skill> skillChoice : race.getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        for(Career career1 : this.previousCareers){
            for(LinkedList<Skill> skillChoice : career1.getSkills()){
                newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
            }
        }

        for(LinkedList<Skill> skillChoice : career.getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        return newSkills;
    }

    public LinkedList<Talent> randomTalents(){
        LinkedList<Talent> newTalents = new LinkedList<Talent>();
        Random r = new Random();

        for(LinkedList<Talent> talentChoice : race.getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        for(Career career1 : this.previousCareers){
            for(LinkedList<Talent> talentChoice : career1.getTalents()){
                newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
            }
        }

        for(LinkedList<Talent> talentChoice : career.getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        return newTalents;
    }

    public void randomTrappings(){
        Random r = new Random();

        LinkedList<Weapon> newWeapons = new LinkedList<Weapon>();

        for(Career career1 : this.previousCareers){
            for(LinkedList<Weapon> weaponChoice : career1.getWeapons()){
                newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
            }
        }

        for(LinkedList<Weapon> weaponChoice : career.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        for(LinkedList<Weapon> weaponChoice : race.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        LinkedList<Armour> newArmours = new LinkedList<Armour>();

        for(Career career1 : this.previousCareers){
            for(LinkedList<Armour> armourChoice : career1.getArmours()){
                newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
            }
        }

        for(LinkedList<Armour> armourChoice : career.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        for(LinkedList<Armour> armourChoice : race.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        LinkedList<Equipment> newEquipment = new LinkedList<Equipment>();

        for(Career career1 : this.previousCareers){
            for(LinkedList<Equipment> equipmentChoice : career1.getEquipments()){
                newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
            }
        }

        for(LinkedList<Equipment> equipmentChoice : career.getEquipments()){
            newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
        }

        for(LinkedList<Equipment> equipmentChoice : race.getEquipments()){
            newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
        }

        this.setWeapons(newWeapons);
        this.setArmours(newArmours);
        this.setEquipment(newEquipment);
    }

    public Money randomMoney(){
        Random r = new Random();
        int initialMoney = (r.nextInt(10) + 1) + (r.nextInt(10) + 1);

        int goldenCrowns = r.nextInt(initialMoney + 1);

        int silverShillings = 0;
        int brassPennies = 0;

        initialMoney = initialMoney - goldenCrowns;

        if(initialMoney > 0){
            initialMoney = initialMoney * 20;
            silverShillings = r.nextInt(initialMoney + 1);
            initialMoney = initialMoney - silverShillings;

            if(initialMoney > 0){
                brassPennies = initialMoney * 12;
            }
        }

        return new Money(goldenCrowns, silverShillings, brassPennies);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public LinkedList<Career> getPreviousCareers() {
        return previousCareers;
    }

    public void setPreviousCareers(LinkedList<Career> previousCareers) {
        this.previousCareers = previousCareers;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LinkedList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<Skill> skills) {
        this.skills = skills;
    }

    public LinkedList<Talent> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<Talent> talents) {
        this.talents = talents;
    }

    public LinkedList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public LinkedList<Armour> getArmours() {
        return armours;
    }

    public void setArmours(LinkedList<Armour> armours) {
        this.armours = armours;
    }

    public LinkedList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(LinkedList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public PersonalDetails getDetails() {
        return details;
    }

    public void setDetails(PersonalDetails details) {
        this.details = details;
    }

    public int getActualWounds() {
        return actualWounds;
    }

    public void setActualWounds(int actualWounds) {
        this.actualWounds = actualWounds;
    }

    @Override
    public String toString(){
        String res = name + ", " + race.getName() + " " + career.getName() + "\n";
        res += details + "\n";
        res += profile + "\n";
        res += "Compétences : \n";

        for(int i = 0; i < skills.size() ; i++){
            res += skills.get(i).getName();

            if(i < skills.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Talents : \n";

        for(int i = 0; i < talents.size() ; i++){
            res += talents.get(i).getName();

            if(i < talents.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Equipement : \n";

        for(int i = 0; i < equipment.size() ; i++){
            res += equipment.get(i).getName();

            if(i < equipment.size() - 1){
                res += ", ";
            }
        }

        if(armours.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < armours.size() ; i++){
            res += armours.get(i).getName();


            if(i < armours.size() - 1){
                res += ", ";
            }
        }

        if(weapons.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < weapons.size() ; i++){
            res += weapons.get(i).getName();

            if(i < weapons.size() - 1){
                res += ", ";
            }
        }

        res += "\n";

        res += money;

        res += "\n";

        res += "Armes : \n";

        res += "Nom\t|\tGroupe\t|\tDégâts\t|\tPortée Courte/Portée Longue\t|\tRechargement\t|\tAttributs\n";

        for(Weapon weapon : weapons){
            res += weapon.getName() + "\t|\t" + weapon.getGroup() + "\t|\t" + weapon.getDamage() + "\t|\t" +
                    weapon.getLowRange() + "/" + weapon.getHighRange() + "\t|\t" + weapon.getReload() + "\t|\t";

            for(String attribute : weapon.getAttributes()){
                res += attribute + ", ";
            }

            res = res.substring(0, res.length() - 2);

            res += "\n";
        }

        res += "\n";

        res += "Armures : \n";

        int headArmour = 0, armsArmour = 0, bodyArmour = 0, legsArmour = 0;

        res += "Nom\t|\tPoints d'armure\t|\tZones\n";

        for(Armour armour : armours){
            res += armour.getName() + "\t|\t" + armour.getArmourLevel() + "\t|\t";

            for(String zone : armour.getCoveredZones()){
                res += zone + ", ";
                if(zone.equals("Tête")){
                    headArmour += armour.getArmourLevel();
                } else if(zone.equals("Bras")){
                    armsArmour += armour.getArmourLevel();
                } else if(zone.equals("Corps")){
                    bodyArmour += armour.getArmourLevel();
                } else if(zone.equals("Jambes")){
                    legsArmour += armour.getArmourLevel();
                }
            }

            res = res.substring(0, res.length() - 2);

            res += "\n";
        }

        res += "Tête : " + headArmour + ", Bras gauche : " + armsArmour + ", Bras droit : " + armsArmour + ", " +
                "Corps : " + bodyArmour + ", Jambe gauche : " + legsArmour + ", Jambe droite  : " + legsArmour;

        return res;
    }

    public JPanel toPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel(this.getName() + ", " + this.getRace().getName() + " " + this.getCareer().getName()));

        JPanel detailsPanel = this.getDetails().toPanel();
        detailsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JPanel profilePanel = this.getProfile().toPanel();
        detailsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new BoxLayout(skillsPanel, BoxLayout.X_AXIS));
        skillsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        skillsPanel.add(new JLabel("Compétences : "));

        String s = "";
        for(Skill skill : this.getSkills()){
            s += skill.getName() + ", ";
        }

        s = s.substring(0, s.length() - 2);

        JTextArea textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        skillsPanel.add(textArea);

        JPanel talentsPanel = new JPanel();
        talentsPanel.setLayout(new BoxLayout(talentsPanel, BoxLayout.X_AXIS));
        talentsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        talentsPanel.add(new JLabel("Talents : "));

        s = "";
        for(Talent talent : this.getTalents()){
            s += talent.getName() + ", ";
        }

        s = s.substring(0, s.length() - 2);

        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        talentsPanel.add(textArea);

        JPanel armourPanel = new JPanel();
        armourPanel.setLayout(new BoxLayout(armourPanel, BoxLayout.X_AXIS));
        armourPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        armourPanel.add(new JLabel("Armures : "));

        s = "";
        for(Armour armour : this.getArmours()){
            s += armour.getName() + ", ";
        }

        if(s.length() >= 2){
            s = s.substring(0, s.length() - 2);
        }

        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        armourPanel.add(textArea);

        JPanel armourLevelPanel = new JPanel();
        armourLevelPanel.setLayout(new BoxLayout(armourLevelPanel, BoxLayout.X_AXIS));
        armourLevelPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        armourLevelPanel.add(new JLabel("Points d'armure : "));

        s = "";
        int head = 0, arms = 0, body = 0, legs = 0;
        for(Armour armour : this.getArmours()){
            if (armour.getCoveredZones().contains("Tête")){
                head++;
            }
            if (armour.getCoveredZones().contains("Bras")){
                arms++;
            }
            if (armour.getCoveredZones().contains("Corps")){
                body++;
            }
            if (armour.getCoveredZones().contains("Jambes")){
                legs++;
            }
        }

        s += "Tête : " + head + ", Bras : " + arms + ", Corps : " + body + ", Jambes : " + legs;

        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        armourLevelPanel.add(textArea);

        JPanel weaponsPanel = new JPanel();
        weaponsPanel.setLayout(new BoxLayout(weaponsPanel, BoxLayout.X_AXIS));
        weaponsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        weaponsPanel.add(new JLabel("Armes : "));

        s = "";
        for(Weapon weapon : this.getWeapons()){
            s += weapon.getName() + ", ";
        }

        if(s.length() >= 2){
            s = s.substring(0, s.length() - 2);
        }

        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        weaponsPanel.add(textArea);

        JPanel equipmentsPanel = new JPanel();
        equipmentsPanel.setLayout(new BoxLayout(equipmentsPanel, BoxLayout.X_AXIS));
        equipmentsPanel.add(new JLabel("Dotations : "));

        s = "";
        for(Equipment equipment : this.getEquipment()){
            s += equipment.getName() + ", ";
        }

        if(s.length() >= 2){
            s = s.substring(0, s.length() - 2);
        }

        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        equipmentsPanel.add(textArea);
        equipmentsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panel.add(titlePanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(detailsPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(profilePanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(skillsPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(talentsPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(armourPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(armourLevelPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(weaponsPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));
        panel.add(equipmentsPanel);
        panel.add(new Box.Filler(new Dimension(5, 5), new Dimension(10, 10), new Dimension(100, 100)));

        JButton removeButton = new JButton("Effacer le personnage");
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeButton.addActionListener(new removeCharacterAL());
        panel.add(removeButton);

        return panel;
    }
}
