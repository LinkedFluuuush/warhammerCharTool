package core.characteristics;

import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;

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

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;
    private LinkedList<LinkedList<Weapon>> weapons;
    private LinkedList<LinkedList<Armour>> armours;
    private LinkedList<LinkedList<Equipment>> equipments;

    public Race(String name, Profile profile, int fSize, int mSize, int[] wounds, int[] fate, int[] weight, int[] age,
                String[] mNames, String[] fNames, String[] hairColour, String[] eyeColour,
                LinkedList<LinkedList<Skill>> skills, LinkedList<LinkedList<Talent>> talents,
                LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours,
                LinkedList<LinkedList<Equipment>> equipments) {
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

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public LinkedList<LinkedList<Weapon>> getWeapons() {
        return weapons;
    }

    public LinkedList<LinkedList<Armour>> getArmours() {
        return armours;
    }

    public LinkedList<LinkedList<Equipment>> getEquipments() {
        return equipments;
    }

    @Override
    public String toString(){
        String res = "Race : " + name + "\n";
        res += profile + "\n";
        res += "Compétences : \n";

        for(int i = 0; i < skills.size() ; i++){
            for (int j = 0 ; j < skills.get(i).size() ; j++){
                res += skills.get(i).get(j).getName();

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
                res += talents.get(i).get(j).getName();

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
                res += equipments.get(i).get(j).getName();

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
                res += armours.get(i).get(j).getName();

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
                res += weapons.get(i).get(j).getName();

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
