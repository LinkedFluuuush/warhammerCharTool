package core.xmlHelper;

import core.World;
import core.characteristics.*;
import core.entities.AstralSign;
import core.entities.God;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

    public HashMap<String, ? extends Object> nameLoader(String name);

    /* Unit Loaders */

    public Skill skillLoader(String skill);

    public Talent talentLoader(String talent);

    public Equipment equipmentLoader(String equipment);

    public Weapon weaponLoader(String weapon);

    public Armour armourLoader(String armour);

    public God godLoader(String god);

    public AstralSign astralSignsLoader(String astralSign);

    public Race raceLoader(String race);

    public Career careerLoader(String career);

    public String distinguishingsSignsLoader(String distinguishingSign);
}
