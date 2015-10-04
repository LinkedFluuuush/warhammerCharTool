package core.entities;

import core.World;
import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;

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

    private String race;
    private String career;
    private LinkedList<String> previousCareers;
    private Profile profile;
    private Profile basicProfile;
    private LinkedList<String> skills;
    private LinkedList<String> talents;
    private LinkedList<String> weapons;
    private LinkedList<String> armours;
    private LinkedList<String> equipment;
    private Money money;
    private PersonalDetails details;

    private int actualWounds;

    public Character(String name, String player, String race, String career,
                     LinkedList<String> previousCareers, Profile profile,
                     LinkedList<String> skills, LinkedList<String> talents,
                     LinkedList<String> weapons, LinkedList<String> armours,
                     LinkedList<String> equipment, Money money,
                     PersonalDetails details, int actualWounds) {
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

        if(name.equals("")){
            randomName();
        } else {
            this.name = name;
        }
    }

    public Character(String name, String player, String race, String career,
                     LinkedList<String> previousCareers, Profile profile,
                     LinkedList<String> skills, LinkedList<String> talents,
                     LinkedList<String> weapons, LinkedList<String> armours,
                     LinkedList<String> equipment, Money money,
                     PersonalDetails details) {
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

        if(name.equals("")){
            randomName();
        } else {
            this.name = name;
        }
    }

/*    public Character(String name, String race, String career) {
        this.name = name;
        this.player = "npc";
        this.race = race;
        this.career = career;
        this.type = "NPC";

        randomCharacter(type);

        this.actualWounds = profile.getW();
    }*/

    public Character(String race, String career) {
        this.player = "npc";
        this.race = race;
        this.career = career;
        this.type = "NPC";

        randomCharacter(type);
        randomName();

        this.previousCareers = new LinkedList<String>();
        this.actualWounds = profile.getW();
    }

    public Character(String name, String player, String race, String career,
                     LinkedList<String> previousCareers, Profile profile,
                     LinkedList<String> skills, LinkedList<String> talents,
                     LinkedList<String> weapons, LinkedList<String> armours,
                     LinkedList<String> equipment, Money money,
                     PersonalDetails details, int actualWounds, String type) {
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

        if(name.equals("")){
            randomName();
        } else {
            this.name = name;
        }

    }

    public Character(String name, String player, String race, String career,
                     LinkedList<String> previousCareers, Profile profile,
                     LinkedList<String> skills, LinkedList<String> talents,
                     LinkedList<String> weapons, LinkedList<String> armours,
                     LinkedList<String> equipment, Money money,
                     PersonalDetails details, String type) {
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

        if(name.equals("")){
            randomName();
        } else {
            this.name = name;
        }

    }

    public Character(String name, String player, String race, String career, String type) {
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = type;

        randomCharacter(type);

        if(name.equals("")){
            randomName();
        } else {
            this.name = name;
        }

        this.actualWounds = profile.getW();
    }

    public Character(String player, String race, String career, String type) {
        this.player = player;
        this.race = race;
        this.career = career;
        this.type = type;

        randomCharacter(type);
        randomName();

        this.actualWounds = profile.getW();
    }

    public Character(String race, String career, String type) {
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
            this.name = World.loadRace(this.race).getmNames()[r.nextInt(World.loadRace(this.race).getmNames().length)];
        else
            this.name = World.loadRace(this.race).getfNames()[r.nextInt(World.loadRace(this.race).getfNames().length)];
    }

    public void randomCharacter(String type){
        if(type.equals("PC"))
            this.basicProfile = randomPCProfile();
        else
            this.basicProfile = randomNPCProfile();

        //this.profile = basicProfile.clone();


        this.details = randomDetails();

        this.money = randomMoney();
//        this.previousCareers = career.getRandomPreviousCareers(0, 0, new LinkedList<Career>(), new LinkedList<LinkedList<Career>>());
        this.previousCareers = new LinkedList<String>();

        this.applyCareers();
    }

    public Profile randomNPCProfile(){
        Random r = new Random();
        Profile raceProfile = World.loadRace(this.race).getProfile();

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
                World.loadRace(this.race).getWounds()[r.nextInt(World.loadRace(this.race).getWounds().length)],
                raceProfile.getM(),
                0);
    }

    public Profile randomPCProfile(){
        Random r = new Random();
        Profile raceProfile = World.loadRace(this.race).getProfile();

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
                World.loadRace(this.race).getWounds()[r.nextInt(World.loadRace(this.race).getWounds().length)],
                raceProfile.getM(),
                0);

        newProfile.setFp(World.loadRace(this.race).getFate()[r.nextInt(World.loadRace(this.race).getFate().length)]);

        return newProfile;
    }

    public PersonalDetails randomDetails(){
        Random r = new Random();

        boolean male = r.nextBoolean();
        int size = World.loadRace(this.race).getfSize();
        if(male){
            size = World.loadRace(this.race).getmSize();
        }

        String eyeColour = World.loadRace(this.race).getEyeColour()[r.nextInt(World.loadRace(this.race).getEyeColour().length)];

        String birthPlace = World.loadRace(this.race).getBirthPlaces().get(r.nextInt(World.loadRace(this.race).getBirthPlaces().size()));
        String worshipedGod = World.loadRace(this.race).getWorshipedGods().get(r.nextInt(World.loadRace(this.race).getWorshipedGods().size()));
        String astralSign = new LinkedList<String>(World.ASTRALSIGNS.keySet()).get(r.nextInt(World.ASTRALSIGNS.keySet().size()));

        LinkedList<String> distinguishingMarks = new LinkedList<String>();
        String selectedMark;
        int nbMarks = r.nextInt(4) + 1;

        for(int i = 0 ; i< nbMarks ; i++){
            do{
                selectedMark = new LinkedList<String>(World.DISTINGUISHINGSIGNS.keySet()).get(r.nextInt(World.DISTINGUISHINGSIGNS.size()));
            } while(distinguishingMarks.contains(selectedMark));

            distinguishingMarks.add(selectedMark);
        }

        return new PersonalDetails(
                male, World.loadRace(this.race).getAge()[r.nextInt(World.loadRace(this.race).getAge().length)],
                birthPlace, worshipedGod, (int)(size + ((r.nextInt(10) + 1) * 2.5)),
                World.loadRace(this.race).getWeight()[r.nextInt(World.loadRace(this.race).getWeight().length)],
                eyeColour, World.loadRace(this.race).getHairColour()[r.nextInt(World.loadRace(this.race).getHairColour().length)],
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
        Career career1;
        for(String careerName : previousCareers){
            career1 = World.loadCareer(careerName);
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

        career1 = World.loadCareer(this.getCareer());

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

        newProfile.setSb(newProfile.getS() / 10);
        newProfile.setTb(newProfile.getT() / 10);

        return newProfile;
    }

    public LinkedList<String> randomSkills(){
        LinkedList<String> newSkills = new LinkedList<String>();
        Random r = new Random();
        Career career1;

        for(LinkedList<String> skillChoice : World.loadRace(this.race).getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        for(String careerName : this.previousCareers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> skillChoice : career1.getSkills()){
                newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
            }
        }

        for(LinkedList<String> skillChoice : World.loadCareer(this.career).getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        return newSkills;
    }

    public LinkedList<String> randomTalents(){
        LinkedList<String> newTalents = new LinkedList<String>();
        Random r = new Random();
        Career career1;

        for(LinkedList<String> talentChoice : World.loadRace(this.race).getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        for(String careerName : this.previousCareers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> talentChoice : career1.getTalents()){
                newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
            }
        }

        for(LinkedList<String> talentChoice : World.loadCareer(this.career).getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        return newTalents;
    }

    public void randomTrappings(){
        Random r = new Random();
        Career careerEff = World.loadCareer(this.career), career1;
        Race raceEff = World.loadRace(this.race);

        LinkedList<String> newWeapons = new LinkedList<String>();

        for(String careerName : this.previousCareers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> weaponChoice : career1.getWeapons()){
                newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
            }
        }

        for(LinkedList<String> weaponChoice : careerEff.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        for(LinkedList<String> weaponChoice : raceEff.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        LinkedList<String> newArmours = new LinkedList<String>();

        for(String careerName : this.previousCareers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> armourChoice : career1.getArmours()){
                newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
            }
        }

        for(LinkedList<String> armourChoice : careerEff.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        for(LinkedList<String> armourChoice : raceEff.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        LinkedList<String> newEquipment = new LinkedList<String>();

        for(String careerName : this.previousCareers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> equipmentChoice : career1.getEquipments()){
                newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
            }
        }

        for(LinkedList<String> equipmentChoice : careerEff.getEquipments()){
            newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
        }

        for(LinkedList<String> equipmentChoice : raceEff.getEquipments()){
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public LinkedList<String> getPreviousCareers() {
        return previousCareers;
    }

    public void setPreviousCareers(LinkedList<String> previousCareers) {
        this.previousCareers = previousCareers;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }

    public LinkedList<String> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<String> talents) {
        this.talents = talents;
    }

    public LinkedList<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<String> weapons) {
        this.weapons = weapons;
    }

    public LinkedList<String> getArmours() {
        return armours;
    }

    public void setArmours(LinkedList<String> armours) {
        this.armours = armours;
    }

    public LinkedList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(LinkedList<String> equipment) {
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
        String res = name + ", " + race+ " " + career + "\n";
        res += details + "\n";
        res += profile + "\n";
        res += "Compétences : \n";

        for(int i = 0; i < skills.size() ; i++){
            res += skills.get(i);

            if(i < skills.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Talents : \n";

        for(int i = 0; i < talents.size() ; i++){
            res += talents.get(i);

            if(i < talents.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Equipement : \n";

        for(int i = 0; i < equipment.size() ; i++){
            res += equipment.get(i);

            if(i < equipment.size() - 1){
                res += ", ";
            }
        }

        if(armours.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < armours.size() ; i++){
            res += armours.get(i);


            if(i < armours.size() - 1){
                res += ", ";
            }
        }

        if(weapons.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < weapons.size() ; i++){
            res += weapons.get(i);

            if(i < weapons.size() - 1){
                res += ", ";
            }
        }

        res += "\n";

        res += money;

        res += "\n";

        res += "Armes : \n";

        res += "Nom\t|\tGroupe\t|\tDégâts\t|\tPortée Courte/Portée Longue\t|\tRechargement\t|\tAttributs\n";

        Weapon weapon;
        for(String weaponName : weapons){
            weapon = World.loadWeapon(weaponName);
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

        Armour armour;
        for(String armourName : armours){
            armour = World.loadArmour(armourName);
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

/*    public JPanel toPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel(this.getName() + ", " + this.getRace() + " " + this.getCareer()));

        JPanel detailsPanel = this.getDetails().toPanel();
        detailsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JPanel profilePanel = this.getProfile().toPanel();
        detailsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new BoxLayout(skillsPanel, BoxLayout.X_AXIS));
        skillsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        skillsPanel.add(new JLabel("Compétences : "));

        String s = "";
        for(String skill : this.getSkills()){
            s += skill + ", ";
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
        for(String talent : this.getTalents()){
            s += talent + ", ";
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
        for(String armour : this.getArmours()){
            s += armour + ", ";
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
        Armour armour;
        for(String armourName : this.getArmours()){
            armour = World.loadArmour(armourName);
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
        for(String weapon : this.getWeapons()){
            s += weapon + ", ";
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
        for(String equipment : this.getEquipment()){
            s += equipment + ", ";
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
    }*/
}
