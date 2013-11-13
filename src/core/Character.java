package core;

import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;

import java.util.LinkedList;
import java.util.Random;

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
    }

    public Character(String name, String player, Race race, Career career) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;

        randomPNJ();

        this.actualWounds = profile.getW();
    }

    public Character(String name, String player, Race race, Career career,
                     LinkedList<Career> previousCareers,
                     LinkedList<Skill> skills, LinkedList<Talent> talents,
                     LinkedList<Weapon> weapons, LinkedList<Armour> armours,
                     LinkedList<Equipment> equipment, Money money,
                     PersonalDetails details) {
        this.name = name;
        this.player = player;
        this.race = race;
        this.career = career;
        this.previousCareers = previousCareers;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipment = equipment;
        this.money = money;
        this.details = details;
        this.actualWounds = profile.getW();

        this.profile = randomPNJProfile();
    }

    public Character randomPNJ(){
        this.profile = randomPNJProfile();
        this.details = randomDetails();
        this.skills = randomSkills();
        this.talents = randomTalents();
        randomTrappings();
        this.money = randomMoney();

        return this;
    }

    public Profile randomPNJProfile(){
        Random r = new Random();
        Profile raceProfile = this.race.getProfile();
        Profile careerProfile = this.career.getProfile();

        Profile newProfile = new Profile(
                raceProfile.getWs() + (r.nextInt(10) + 1) + careerProfile.getWs(),
                raceProfile.getBs() + (r.nextInt(10) + 1) + careerProfile.getBs(),
                raceProfile.getS() + (r.nextInt(10) + 1) + careerProfile.getS(),
                raceProfile.getT() + (r.nextInt(10) + 1) + careerProfile.getT(),
                raceProfile.getAg() + (r.nextInt(10) + 1) + careerProfile.getAg(),
                raceProfile.getIntel() + (r.nextInt(10) + 1) + careerProfile.getIntel(),
                raceProfile.getWp() + (r.nextInt(10) + 1) + careerProfile.getWp(),
                raceProfile.getFel() + (r.nextInt(10) + 1) + careerProfile.getFel(),
                1 + careerProfile.getA(),
                race.getWounds()[r.nextInt(race.getWounds().length)] + careerProfile.getW(),
                raceProfile.getM() + careerProfile.getM(),
                careerProfile.getMag());

        return newProfile;
    }

    public Profile randomPJProfile(){
        Random r = new Random();
        Profile raceProfile = this.race.getProfile();
        Profile careerProfile = this.career.getProfile();

        Profile newProfile = new Profile(
                raceProfile.getWs() + (r.nextInt(10) + 1) + careerProfile.getWs(),
                raceProfile.getBs() + (r.nextInt(10) + 1) + careerProfile.getBs(),
                raceProfile.getS() + (r.nextInt(10) + 1) + careerProfile.getS(),
                raceProfile.getT() + (r.nextInt(10) + 1) + careerProfile.getT(),
                raceProfile.getAg() + (r.nextInt(10) + 1) + careerProfile.getAg(),
                raceProfile.getIntel() + (r.nextInt(10) + 1) + careerProfile.getIntel(),
                raceProfile.getWp() + (r.nextInt(10) + 1) + careerProfile.getWp(),
                raceProfile.getFel() + (r.nextInt(10) + 1) + careerProfile.getFel(),
                1 + careerProfile.getA(),
                race.getWounds()[r.nextInt(race.getWounds().length)] + careerProfile.getW(),
                raceProfile.getM() + careerProfile.getM(),
                careerProfile.getMag());

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

        PersonalDetails newDetails = new PersonalDetails(
                male,
                race.getAge()[r.nextInt(race.getAge().length)],
                "Unknown", "Empire", "Ulric",
                (int)(size + ((r.nextInt(10) + 1) * 2.5)),
                race.getWeight()[r.nextInt(race.getWeight().length)],
                eyeColour, eyeColour,
                race.getHairColour()[r.nextInt(race.getHairColour().length)],
                new LinkedList<String>()
        );

        return details;
    }

    public LinkedList<Skill> randomSkills(){
        LinkedList<Skill> newSkills = new LinkedList<Skill>();
        Random r = new Random();

        for(LinkedList<Skill> skillChoice : career.getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        return newSkills;
    }

    public LinkedList<Talent> randomTalents(){
        LinkedList<Talent> newTalents = new LinkedList<Talent>();
        Random r = new Random();

        for(LinkedList<Talent> talentChoice : career.getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        return newTalents;
    }

    public void randomTrappings(){
        Random r = new Random();

        LinkedList<Weapon> newWeapons = new LinkedList<Weapon>();

        for(LinkedList<Weapon> weaponChoice : career.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        LinkedList<Armour> newArmours = new LinkedList<Armour>();

        for(LinkedList<Armour> armourChoice : career.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        LinkedList<Equipment> newEquipment = new LinkedList<Equipment>();

        for(LinkedList<Equipment> equipmentChoice : career.getEquipments()){
            newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
        }

        this.setWeapons(newWeapons);
        this.setArmours(newArmours);
        this.setEquipment(newEquipment);
    }

    public Money randomMoney(){
        Random r = new Random();
        int initialMoney = (r.nextInt(10) + 1) + (r.nextInt() + 1);

        int goldenCrowns = r.nextInt(initialMoney + 1);
        int silverShillings = 0;
        int brassPennies = 0;

        initialMoney = initialMoney - goldenCrowns;

        if(initialMoney > 0){
            initialMoney = initialMoney * 20;
            silverShillings = r.nextInt(initialMoney + 1);
            initialMoney = initialMoney - silverShillings;

            if(initialMoney > 0){
                silverShillings = initialMoney * 12;
            }
        }

        Money newMoney = new Money(goldenCrowns, silverShillings, brassPennies);

        return newMoney;
    }

    @Override
    public String toString(){
        String res = name + " joué par " + player + ".\n\n";
        res += race.getName() + " " + career.getName() + ".";

        res += "\n Anciennes carrières :\n\t";

        for(Career previousCareer : previousCareers){
            res += previousCareer.getName() + ", ";
        }


        res += details + "\n\n";
        res += profile + "\n\n";

        res += "Compétences : \n";

        for(Skill skill : skills){
            res += "\t" + skill + "\n";
        }

        res += "\n Talents : \n";

        for(Talent talent : talents){
            res += "\t" + talent + "\n";
        }

        res += "\n Armes :\n";

        for(Weapon weapon : weapons){
            res += "\t" + weapon + "\n";
        }

        res += "\n Armures :\n";

        for(Armour armour : armours){
            res += "\t" + armour + "\n";
        }

        res += "\n Equipement :\n";
        res += "\t" + money + "\n";

        for(Equipment equipment1 : equipment){
            res += "\t" + equipment1.getName() + "\n";
        }

        res +="\n\n";

        return res;
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
}
