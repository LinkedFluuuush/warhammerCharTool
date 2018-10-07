package core.entities;

import core.World;
import core.characteristics.Career;
import core.characteristics.Profile;
import core.characteristics.Race;
import core.equipment.Armour;
import core.equipment.Money;
import core.equipment.Weapon;

import java.util.Arrays;
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
    private LinkedList<String> careers;
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

    public Character(String name, String player, String type, String race, LinkedList<String> careers) {
        this.name = name;
        this.player = player;
        this.type = type;
        this.race = race;
        this.careers = careers;
        this.randomCharacter(this.type);
    }

    public Character(){
        this.name = "";
        this.player = "NPC";
        this.type = "NPC";

        this.race = "";
        this.careers = new LinkedList<>();

        this.profile = new Profile();
        this.basicProfile = new Profile();


        this.skills = new LinkedList<>();
        this.talents = new LinkedList<>();
        this.weapons = new LinkedList<>();
        this.armours = new LinkedList<>();
        this.equipment = new LinkedList<>();

        this.money = new Money();
        this.details = new PersonalDetails();
    }

    public Character(String race, LinkedList<String> careers) {
        this.race = race;
        this.careers = careers;
        this.type = "NPC";

        this.randomCharacter(this.type);

        this.randomName();

        this.actualWounds = profile.getW();
    }

    public Character(String name, String player, String race, LinkedList<String> career,
                     String type, String[] caracs, String age, String eyeColour,
                     String hairColour, String gender, String size, String weight,
                     String astralSign, String birthPlace, String worshippedGod,
                     String[] marks, LinkedList<String> skills, LinkedList<String> talents,
                     LinkedList<String> armours, LinkedList<String> weapons,
                     LinkedList<String> equipments, Money money) {

        Random r = new Random();

        this.name = name;
        this.player = player;
        this.race = race;
        this.careers = careers;
        this.type = type;

        int[] basicCharacs = new int[16];

        for(int i = 0 ; i < 16 ; i++){
            if(caracs[i].equals("")){
                basicCharacs[i] = 0;
            } else {
                basicCharacs[i] = Integer.parseInt(caracs[i]);
            }
        }

        this.basicProfile = new Profile(basicCharacs[0], basicCharacs[1], basicCharacs[2],
                basicCharacs [3], basicCharacs[4], basicCharacs[5], basicCharacs[6],
                basicCharacs [7], basicCharacs[8], basicCharacs[9], basicCharacs[10],
                basicCharacs [11], basicCharacs[12], basicCharacs[13], basicCharacs[14],
                basicCharacs [15]);

        boolean sex;

        if(gender.equals("")){
            sex = r.nextBoolean();
        } else {
            sex = gender.equals("Masculin");
        }

        size = size.replace("m", "");
        weight = weight.replaceAll("kg", "");

        int ageInt = (age.equals("")) ? World.loadRace(this.race).getAge()[r.nextInt(World.loadRace(this.race).getAge().length)] : Integer.parseInt(age);
        int sizeInt = (size.equals("")) ? (sex ? World.loadRace(this.race).getmSize() : World.loadRace(this.race).getfSize()) + (int)(r.nextInt(10) * 2.5) : Integer.parseInt(size);
        int weightInt = (weight.equals("")) ? World.loadRace(this.race).getWeight()[r.nextInt(World.loadRace(this.race).getWeight().length)] : Integer.parseInt(weight);

        this.setDetails(new PersonalDetails(sex, ageInt,
                birthPlace, worshippedGod, sizeInt, weightInt,
                eyeColour, hairColour, astralSign, new LinkedList<String>(Arrays.asList(marks))));

        this.skills = skills;
        this.talents = talents;
        this.armours = armours;
        this.weapons = weapons;
        this.equipment = equipments;
        this.money = money;

        this.completeCharacter();
    }

    public void completeCharacter() {

        Random r = new Random();

        Race race = World.loadRace(this.race);

        this.details.setMale(r.nextBoolean());

        if(this.name.equals("")){
            this.randomName();
        }


        if(this.details.getBirthplace().equals("")){
            this.details.setBirthplace(race.getBirthPlaces().get(r.nextInt(race.getBirthPlaces().size())));
        }

        if(this.details.getFavoriteGod().equals("")){
            this.details.setFavoriteGod(race.getWorshipedGods().get(r.nextInt(race.getWorshipedGods().size())));
        }

        if(this.details.getEyeColour().equals("")){
            this.details.setEyeColour(race.getEyeColour()[r.nextInt(race.getEyeColour().length)]);
        }

        if(this.details.getHairColour().equals("")){
            this.details.setHairColour(race.getHairColour()[r.nextInt(race.getHairColour().length)]);
        }

        if(this.details.getAstralSign().equals("")){
            this.details.setAstralSign((String) World.ASTRALSIGNS.keySet().toArray()[r.nextInt(World.ASTRALSIGNS.keySet().size())]);
        }

        if(this.details.getDistinguishingMarks().isEmpty() || this.details.getDistinguishingMarks().get(0).equals("")){
            LinkedList<String> distinguishingMarks = new LinkedList<>();
            String selectedMark;
            int nbMarks = r.nextInt(4) + 1;

            for(int i = 0 ; i< nbMarks ; i++){
                do{
                    selectedMark = new LinkedList<>(World.DISTINGUISHINGSIGNS.keySet()).get(r.nextInt(World.DISTINGUISHINGSIGNS.size()));
                } while(distinguishingMarks.contains(selectedMark));

                distinguishingMarks.add(selectedMark);
            }

            this.details.setDistinguishingMarks(distinguishingMarks);
        }

        this.details.setAge((this.details.getAge() == 0) ? World.loadRace(this.race).getAge()[r.nextInt(World.loadRace(this.race).getAge().length)] : this.details.getAge());
        this.details.setHeight((this.details.getHeight() == 0) ? (this.details.isMale() ? World.loadRace(this.race).getmSize() : World.loadRace(this.race).getfSize()) + (int)(r.nextInt(10) * 2.5) : this.details.getHeight());
        this.details.setWeight((this.details.getWeight() == 0) ? World.loadRace(this.race).getWeight()[r.nextInt(World.loadRace(this.race).getWeight().length)] : this.details.getWeight());


        this.completeBasicProfile(race);
        this.profile = this.applyCareersProfile();
        this.skills.addAll(this.randomSkills());
        this.talents.addAll(this.randomTalents());
        this.randomTrappings();

        this.cleanLists();
    }

    private void cleanLists() {
        LinkedList<String> cleanedSkills = new LinkedList<>();

        for(String skill : this.skills){
            if(countElement(cleanedSkills, skill) < 3){
                cleanedSkills.add(skill);
            }
        }

        this.skills = cleanedSkills;

        LinkedList<String> cleanedTalents = new LinkedList<>();
        for(String talent : this.talents){
            if(!cleanedTalents.contains(talent)){
                cleanedTalents.add(talent);
            }
        }

        this.talents = cleanedTalents;
    }

    private int countElement(LinkedList<String> list, String element) {
        int i = 0;

        for(String s : list){
            if(s.equals(element)){
                i++;
            }
        }

        return i;
    }

    private void completeBasicProfile(Race race) {
        Random r = new Random();

        if(this.basicProfile.getWs() == 0){
            this.basicProfile.setWs(r.nextInt(20) + race.getProfile().getWs());
        }

        if(this.basicProfile.getBs() == 0){
            this.basicProfile.setBs(r.nextInt(20) + race.getProfile().getBs());
        }

        if(this.basicProfile.getS() == 0){
            this.basicProfile.setS(r.nextInt(20) + race.getProfile().getWs());
        }

        if(this.basicProfile.getT() == 0){
            this.basicProfile.setT(r.nextInt(20) + race.getProfile().getT());
        }

        if(this.basicProfile.getAg() == 0){
            this.basicProfile.setAg(r.nextInt(20) + race.getProfile().getAg());
        }

        if(this.basicProfile.getIntel() == 0){
            this.basicProfile.setIntel(r.nextInt(20) + race.getProfile().getIntel());
        }

        if(this.basicProfile.getWp() == 0){
            this.basicProfile.setWp(r.nextInt(20) + race.getProfile().getWp());
        }

        if(this.basicProfile.getFel() == 0){
            this.basicProfile.setFel(r.nextInt(20) + race.getProfile().getFel());
        }
    }

    private void randomName(){
        Random r = new Random();

        if(this.details.isMale())
            this.name = World.loadRace(this.race).getmNames()[r.nextInt(World.loadRace(this.race).getmNames().length)];
        else
            this.name = World.loadRace(this.race).getfNames()[r.nextInt(World.loadRace(this.race).getfNames().length)];
    }

    private void randomCharacter(String type){
        if(type.equals("PC"))
            this.basicProfile = randomPCProfile();
        else
            this.basicProfile = randomNPCProfile();

        //this.profile = basicProfile.clone();


        this.details = randomDetails();

        this.money = randomMoney();
//        this.previousCareers = career.getRandomPreviousCareers(0, 0, new LinkedList<Career>(), new LinkedList<LinkedList<Career>>());

        this.applyCareers();
    }

    private Profile randomNPCProfile(){
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

    private Profile randomPCProfile(){
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

    private PersonalDetails randomDetails(){
        Random r = new Random();

        boolean male = r.nextBoolean();
        int size = World.loadRace(this.race).getfSize();
        if(male){
            size = World.loadRace(this.race).getmSize();
        }

        String eyeColour = World.loadRace(this.race).getEyeColour()[r.nextInt(World.loadRace(this.race).getEyeColour().length)];

        String birthPlace = World.loadRace(this.race).getBirthPlaces().get(r.nextInt(World.loadRace(this.race).getBirthPlaces().size()));
        String worshipedGod = World.loadRace(this.race).getWorshipedGods().get(r.nextInt(World.loadRace(this.race).getWorshipedGods().size()));
        String astralSign = new LinkedList<>(World.ASTRALSIGNS.keySet()).get(r.nextInt(World.ASTRALSIGNS.keySet().size()));

        LinkedList<String> distinguishingMarks = new LinkedList<>();
        String selectedMark;
        int nbMarks = r.nextInt(4) + 1;

        for(int i = 0 ; i< nbMarks ; i++){
            do{
                selectedMark = new LinkedList<>(World.DISTINGUISHINGSIGNS.keySet()).get(r.nextInt(World.DISTINGUISHINGSIGNS.size()));
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

    private void applyCareers(){
        this.profile = applyCareersProfile();
        this.skills = randomSkills();
        this.talents = randomTalents();
        randomTrappings();
    }

    private Profile applyCareersProfile(){
        Random r = new Random();

        Profile newProfile = basicProfile.clone();
        Career career1;
        for(String careerName : careers){
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

        newProfile.setSb(newProfile.getS() / 10);
        newProfile.setTb(newProfile.getT() / 10);

        return newProfile;
    }

    private LinkedList<String> randomSkills(){
        LinkedList<String> newSkills = new LinkedList<>();
        Random r = new Random();
        Career career1;

        for(LinkedList<String> skillChoice : World.loadRace(this.race).getSkills()){
            newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
        }

        for(String careerName : this.careers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> skillChoice : career1.getSkills()){
                newSkills.add(skillChoice.get(r.nextInt(skillChoice.size())));
            }
        }

        return newSkills;
    }

    private LinkedList<String> randomTalents(){
        LinkedList<String> newTalents = new LinkedList<>();
        Random r = new Random();
        Career career1;

        for(LinkedList<String> talentChoice : World.loadRace(this.race).getTalents()){
            newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
        }

        for(String careerName : this.careers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> talentChoice : career1.getTalents()){
                newTalents.add(talentChoice.get(r.nextInt(talentChoice.size())));
            }
        }

        return newTalents;
    }

    private void randomTrappings(){
        Random r = new Random();
        Career career1;
        Race raceEff = World.loadRace(this.race);

        LinkedList<String> newWeapons = new LinkedList<>();

        for(String careerName : this.careers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> weaponChoice : career1.getWeapons()){
                newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
            }
        }

        for(LinkedList<String> weaponChoice : raceEff.getWeapons()){
            newWeapons.add(weaponChoice.get(r.nextInt(weaponChoice.size())));
        }

        LinkedList<String> newArmours = new LinkedList<>();

        for(String careerName : this.careers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> armourChoice : career1.getArmours()){
                newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
            }
        }


        for(LinkedList<String> armourChoice : raceEff.getArmours()){
            newArmours.add(armourChoice.get(r.nextInt(armourChoice.size())));
        }

        LinkedList<String> newEquipment = new LinkedList<>();

        for(String careerName : this.careers){
            career1 = World.loadCareer(careerName);
            for(LinkedList<String> equipmentChoice : career1.getEquipments()){
                newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
            }
        }

        for(LinkedList<String> equipmentChoice : raceEff.getEquipments()){
            newEquipment.add(equipmentChoice.get(r.nextInt(equipmentChoice.size())));
        }

        this.weapons.addAll(newWeapons);
        this.armours.addAll(newArmours);
        this.equipment.addAll(newEquipment);
    }

    private Money randomMoney(){
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

    public LinkedList<String> getCareers() {
        return careers;
    }

    public void setCareers(LinkedList<String> careers) {
        this.careers = careers;
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
        String res = name + ", " + race+ " " + careers + "\n";
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
                switch (zone) {
                    case "Tête":
                        headArmour += armour.getArmourLevel();
                        break;
                    case "Bras":
                        armsArmour += armour.getArmourLevel();
                        break;
                    case "Corps":
                        bodyArmour += armour.getArmourLevel();
                        break;
                    case "Jambes":
                        legsArmour += armour.getArmourLevel();
                        break;
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
