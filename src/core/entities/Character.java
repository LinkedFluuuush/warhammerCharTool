package core.entities;

import core.characteristics.*;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;

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

    public Character(String player, Race race, Career career) {
        this.player = player;
        this.race = race;
        this.career = career;

        randomPNJ();
        randomName();

        this.actualWounds = profile.getW();
    }

    public Character(Race race, Career career) {
        this.player = "npc";
        this.race = race;
        this.career = career;

        randomPNJ();
        randomName();

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

    public void randomName(){
        Random r = new Random();

        if(this.details.isMale())
            this.name = this.race.getmNames()[r.nextInt(this.race.getmNames().length)];
        else
            this.name = this.race.getfNames()[r.nextInt(this.race.getfNames().length)];
    }

    public void randomPNJ(){
        this.profile = randomPNJProfile();
        this.details = randomDetails();
        this.skills = randomSkills();
        this.talents = randomTalents();
        randomTrappings();
        this.money = randomMoney();

    }

    public Profile randomPNJProfile(){
        Random r = new Random();
        Profile raceProfile = this.race.getProfile();
        Profile careerProfile = this.career.getProfile();

        return new Profile(
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

        return new PersonalDetails(
                male,
                race.getAge()[r.nextInt(race.getAge().length)],
                "Unknown", "Empire", "Ulric",
                (int)(size + ((r.nextInt(10) + 1) * 2.5)),
                race.getWeight()[r.nextInt(race.getWeight().length)],
                eyeColour, eyeColour,
                race.getHairColour()[r.nextInt(race.getHairColour().length)],
                new LinkedList<String>()
        );
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

        for(LinkedList<Weapon> weaponChoice : race.getWeapons()){
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
}
