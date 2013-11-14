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
public class Career {
    private String name;
    private Profile profile;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;
    private LinkedList<LinkedList<Equipment>> equipments;
    private LinkedList<LinkedList<Weapon>> weapons;
    private LinkedList<LinkedList<Armour>> armours;

    public Career(String name, Profile profile, LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents, LinkedList<LinkedList<Equipment>> equipments,
                  LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours) {
        this.name = name;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
    }

    public Career(String name, int ws, int bs, int s, int t, int ag, int intel, int wp,
                  int fel, int a, int w, int m, int mag,
                  LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents, LinkedList<LinkedList<Equipment>> equipments,
                  LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours) {
        this.name = name;
        this.profile = new Profile(ws, bs, s, t, ag, intel, wp, fel, a, w, m, mag);
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public LinkedList<LinkedList<Equipment>> getEquipments() {
        return equipments;
    }

    public LinkedList<LinkedList<Weapon>> getWeapons() {
        return weapons;
    }

    public LinkedList<LinkedList<Armour>> getArmours() {
        return armours;
    }

    @Override
    public String toString(){
        String res = "Carrière : " + name + "\n";
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
