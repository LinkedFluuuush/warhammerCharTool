package core.characteristics;

import core.World;

import java.util.LinkedList;

/**
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 */
public class Career implements Comparable{
    private String name;
    private Profile profile;
    private int type;

    private LinkedList<LinkedList<String>> skills;
    private LinkedList<LinkedList<String>> talents;
    private LinkedList<LinkedList<String>> equipments;
    private LinkedList<LinkedList<String>> weapons;
    private LinkedList<LinkedList<String>> armours;

    private LinkedList<String> accessCareers;
    private LinkedList<String> openingCareers;

    private LinkedList<String> availableRaces;

    public Career(String name, Profile profile, LinkedList<LinkedList<String>> skills,
                  LinkedList<LinkedList<String>> talents, LinkedList<LinkedList<String>> equipments,
                  LinkedList<LinkedList<String>> weapons, LinkedList<LinkedList<String>> armours, LinkedList<String> availableRaces, int type) {
        this.name = name;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
        this.availableRaces = availableRaces;
        this.type = type;
        this.accessCareers = new LinkedList<>();
        this.openingCareers = new LinkedList<>();
    }

    public Career(String name, int ws, int bs, int s, int t, int ag, int intel, int wp,
                  int fel, int a, int w, int m, int mag,
                  LinkedList<LinkedList<String>> skills,
                  LinkedList<LinkedList<String>> talents, LinkedList<LinkedList<String>> equipments,
                  LinkedList<LinkedList<String>> weapons, LinkedList<LinkedList<String>> armours, LinkedList<String> availableRaces, int type) {
        this.name = name;
        this.profile = new Profile(ws, bs, s, t, ag, intel, wp, fel, a, w, m, mag);
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
        this.availableRaces = availableRaces;
        this.type = type;
        this.accessCareers = new LinkedList<>();
        this.openingCareers = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LinkedList<LinkedList<String>> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<LinkedList<String>> skills) {
        this.skills = skills;
    }

    public LinkedList<LinkedList<String>> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<LinkedList<String>> talents) {
        this.talents = talents;
    }

    public LinkedList<LinkedList<String>> getEquipments() {
        return equipments;
    }

    public void setEquipments(LinkedList<LinkedList<String>> equipments) {
        this.equipments = equipments;
    }

    public LinkedList<LinkedList<String>> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<LinkedList<String>> weapons) {
        this.weapons = weapons;
    }

    public LinkedList<LinkedList<String>> getArmours() {
        return armours;
    }

    public void setArmours(LinkedList<LinkedList<String>> armours) {
        this.armours = armours;
    }

    public LinkedList<String> getAccessCareers() {
        return accessCareers;
    }

    public void setAccessCareers(LinkedList<String> accessCareers) {
        this.accessCareers = accessCareers;
    }

    public void addAccessCareer(String career){
        this.accessCareers.add(career);
    }

    public LinkedList<String> getOpeningCareers() {
        return openingCareers;
    }

    public void setOpeningCareers(LinkedList<String> openingCareers) {
        this.openingCareers = openingCareers;
    }

    public void addOpeningCareer(String career){
        this.openingCareers.add(career);
    }

    public LinkedList<String> getAvailableRaces() {
        return availableRaces;
    }

    public void setAvailableRaces(LinkedList<String> availableRaces) {
        this.availableRaces = availableRaces;
    }

    public LinkedList<String> getRandomPreviousCareers(int depth, int minDepth, LinkedList<String> previousCareers, LinkedList<LinkedList<String>> allPossibilities){
        Career career;
        for(String careerName : this.getAccessCareers()){
            if(this.type != 1){
                career = World.loadCareer(careerName);
                depth++;
                previousCareers.add(careerName);
                return career.getRandomPreviousCareers(depth, minDepth, previousCareers, allPossibilities);
            }

            if(depth < minDepth){
                minDepth = depth;
            }

            allPossibilities.add(previousCareers);
            previousCareers = new LinkedList<>();
        }

        for(LinkedList<String> aPossibility : allPossibilities){
            if(aPossibility.size() == minDepth){
                previousCareers = aPossibility;
            }
        }

        return previousCareers;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public String allToString(){
        String res = "Carrière : " + name + " (Carrière";

        if(type == 1){
            res += " de base)\n";
        } else {
            res += " avancée)\n";
        }

        res += profile + "\n";
        res += "Compétences : \n";

        for(int i = 0; i < skills.size() ; i++){
            for (int j = 0 ; j < skills.get(i).size() ; j++){
                res += skills.get(i).get(j);

                if(j < skills.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < skills.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Talents : \n";

        for(int i = 0; i < talents.size() ; i++){
            for (int j = 0 ; j < talents.get(i).size() ; j++){
                res += talents.get(i).get(j);

                if(j < talents.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < talents.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Equipement : \n";

        for(int i = 0; i < equipments.size() ; i++){
            for (int j = 0 ; j < equipments.get(i).size() ; j++){
                res += equipments.get(i).get(j);

                if(j < equipments.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < equipments.size() - 1){
                res += ", ";
            }
        }

        if(armours.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < armours.size() ; i++){
            for (int j = 0 ; j < armours.get(i).size() ; j++){
                res += armours.get(i).get(j);

                if(j < armours.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < armours.size() - 1){
                res += ", ";
            }
        }

        if(weapons.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < weapons.size() ; i++){
            for (int j = 0 ; j < weapons.get(i).size() ; j++){
                res += weapons.get(i).get(j);

                if(j < weapons.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < weapons.size() - 1){
                res += ", ";
            }
        }

        res += "\n\n";
        res += "Accès : \n";

        for(int i = 0; i < accessCareers.size() ; i++){
            res += accessCareers.get(i);

            if (i < accessCareers.size() - 1){
                res += ", ";
            }
        }

        res += "\n\n";
        res += "Débouchés : \n";

        for(int i = 0; i < openingCareers.size() ; i++){
            res += openingCareers.get(i);

            if (i < openingCareers.size() - 1){
                res += ", ";
            }
        }

        return res;
    }

    @Override
    public int compareTo(Object o) {
        Career c = (Career)o;

        return this.getName().compareTo(c.getName());
    }
}
