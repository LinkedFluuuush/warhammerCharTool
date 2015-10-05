package core.characteristics;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class Race {
    private String name;
    private Profile profile;
    private int fSize;
    private int mSize;
    private int[] wounds;
    private int[] fate;
    private int[] weight;
    private int[] age;
    private String[] mNames;
    private String[] fNames;
    private String[] hairColour;
    private String[] eyeColour;

    private LinkedList<LinkedList<String>> skills;
    private LinkedList<LinkedList<String>> talents;
    private LinkedList<LinkedList<String>> weapons;
    private LinkedList<LinkedList<String>> armours;
    private LinkedList<LinkedList<String>> equipments;

    private LinkedList<String> birthPlaces;
    private LinkedList<String> worshipedGods;

    public Race(String name, Profile profile, int fSize, int mSize, int[] wounds, int[] fate, int[] weight, int[] age,
                String[] mNames, String[] fNames, String[] hairColour, String[] eyeColour,
                LinkedList<LinkedList<String>> skills, LinkedList<LinkedList<String>> talents,
                LinkedList<LinkedList<String>> weapons, LinkedList<LinkedList<String>> armours,
                LinkedList<LinkedList<String>> equipments, LinkedList<String> birthPlaces, LinkedList<String> worshipedGods) {
        this.name = name;
        this.profile = profile;
        this.fSize = fSize;
        this.mSize = mSize;
        this.wounds = wounds;
        this.fate = fate;
        this.weight = weight;
        this.age = age;
        this.mNames = mNames;
        this.fNames = fNames;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.skills = skills;
        this.talents = talents;
        this.weapons = weapons;
        this.armours = armours;
        this.equipments = equipments;
        this.birthPlaces = birthPlaces;
        this.worshipedGods = worshipedGods;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getfSize() {
        return fSize;
    }

    public int getmSize() {
        return mSize;
    }

    public int[] getWounds() {
        return wounds;
    }

    public int[] getFate() {
        return fate;
    }

    public int[] getWeight() {
        return weight;
    }

    public int[] getAge() {
        return age;
    }

    public String[] getmNames() {
        return mNames;
    }

    public String[] getfNames() {
        return fNames;
    }

    public String[] getHairColour() {
        return hairColour;
    }

    public String[] getEyeColour() {
        return eyeColour;
    }

    public LinkedList<LinkedList<String>> getSkills() {
        return skills;
    }

    public LinkedList<LinkedList<String>> getTalents() {
        return talents;
    }

    public LinkedList<LinkedList<String>> getWeapons() {
        return weapons;
    }

    public LinkedList<LinkedList<String>> getArmours() {
        return armours;
    }

    public LinkedList<LinkedList<String>> getEquipments() {
        return equipments;
    }

    public LinkedList<String> getBirthPlaces() {
        return birthPlaces;
    }

    public LinkedList<String> getWorshipedGods() {
        return worshipedGods;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public String allToString(){
        String res = "Race : " + name + "\n";
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

        return res;
    }
}
