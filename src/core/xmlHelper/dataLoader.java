package core.xmlHelper;

import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
import core.entities.AstralSign;
import core.entities.God;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;

import java.util.HashMap;

/**
 * Created by LinkedFluuuush on 29/09/2015.
 */
public interface dataLoader {
    /* Global Loaders */

/*    public LinkedList<Skill> skillLoader();

    public LinkedList<Talent> talentLoader();

    public LinkedList<Equipment> equipmentLoader();

    public LinkedList<Weapon> weaponLoader();

    public LinkedList<Armour> armourLoader();

    public LinkedList<God> godLoader();

    public LinkedList<AstralSign> astralSignsLoader();

    public LinkedList<Race> raceLoader();

    public LinkedList<Career> careerLoader();

    public void careerLinker(Career career);

    public LinkedList<String> distinguishingsSignsLoader();*/

    HashMap<String, ?> nameLoader(String name);

    /* Unit Loaders */

    Skill skillLoader(String skill);

    Talent talentLoader(String talent);

    Equipment equipmentLoader(String equipment);

    Weapon weaponLoader(String weapon);

    Armour armourLoader(String armour);

    God godLoader(String god);

    AstralSign astralSignsLoader(String astralSign);

    Race raceLoader(String race);

    Career careerLoader(String career);

    String distinguishingsSignsLoader(String distinguishingSign);
}
