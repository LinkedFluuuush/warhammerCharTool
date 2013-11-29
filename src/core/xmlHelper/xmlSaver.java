package core.xmlHelper;

import core.World;
import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/**
 * User: Linked
 * Date: 23/11/13
 * Time: 20:22
 */
public class xmlSaver {

    public static void saveCareers(){
        Element root = new Element("careers");
        Document document = new Document(root);

        Element career;
        Element profile;

        Element skillTable;
        Element eSkill;

        Element talentTable;
        Element eTalent;

        Element weaponTable;
        Element eWeapon;

        Element armourTable;
        Element eArmour;

        Element equipmentTable;
        Element eEquipment;

        Element accessTable;
        Element accessCareer;

        Element openingTable;
        Element openingCareer;

        Element availableRaces;
        Element race;

        Element choice;

        for(Career aCareer : World.CAREERS){
            System.out.println(aCareer);

            career = new Element("career");
            career.setAttribute("name", aCareer.getName());
            career.setAttribute("type", aCareer.getType()+"");

            profile = new Element("profile");
            profile.setAttribute("WS", aCareer.getProfile().getWs() + "");
            profile.setAttribute("BS", aCareer.getProfile().getBs() + "");
            profile.setAttribute("S", aCareer.getProfile().getS() + "");
            profile.setAttribute("T", aCareer.getProfile().getT() + "");
            profile.setAttribute("Ag", aCareer.getProfile().getAg() + "");
            profile.setAttribute("Int", aCareer.getProfile().getIntel() + "");
            profile.setAttribute("WP", aCareer.getProfile().getWp() + "");
            profile.setAttribute("Fel", aCareer.getProfile().getFel() + "");
            profile.setAttribute("A", aCareer.getProfile().getA() + "");
            profile.setAttribute("W", aCareer.getProfile().getW() + "");
            profile.setAttribute("M", aCareer.getProfile().getM() + "");
            profile.setAttribute("Mag", aCareer.getProfile().getMag() + "");

            career.addContent(profile);

            skillTable = new Element("skillsTable");

            for(LinkedList<Skill> skillList : aCareer.getSkills()){
                eSkill = new Element("eSkills");
                for(Skill aSkill : skillList){
                    choice = new Element("choice");
                    choice.setText(aSkill.getName());
                    eSkill.addContent(choice);
                }
                skillTable.addContent(eSkill);
            }

            career.addContent(skillTable);

            talentTable = new Element("talentsTable");

            for(LinkedList<Talent> talentList : aCareer.getTalents()){
                eTalent = new Element("eTalents");
                for(Talent aTalent : talentList){
                    choice = new Element("choice");
                    choice.setText(aTalent.getName());
                    eTalent.addContent(choice);
                }
                talentTable.addContent(eTalent);
            }

            career.addContent(talentTable);

            weaponTable = new Element("weaponsTable");

            for(LinkedList<Weapon> weaponList : aCareer.getWeapons()){
                eWeapon = new Element("eWeapons");
                for(Weapon aSkill : weaponList){
                    choice = new Element("choice");
                    choice.setText(aSkill.getName());
                    eWeapon.addContent(choice);
                }
                weaponTable.addContent(eWeapon);
            }

            career.addContent(weaponTable);

            armourTable = new Element("armoursTable");

            for(LinkedList<Armour> armourList : aCareer.getArmours()){
                eArmour = new Element("eArmours");
                for(Armour aArmour : armourList){
                    choice = new Element("choice");
                    choice.setText(aArmour.getName());
                    eArmour.addContent(choice);
                }
                armourTable.addContent(eArmour);
            }

            career.addContent(armourTable);

            equipmentTable = new Element("equipmentsTable");

            for(LinkedList<Equipment> equipmentList : aCareer.getEquipments()){
                eEquipment = new Element("eEquipments");
                for(Equipment aEquipment : equipmentList){
                    choice = new Element("choice");
                    choice.setText(aEquipment.getName());
                    eEquipment.addContent(choice);
                }
                equipmentTable.addContent(eEquipment);
            }

            career.addContent(equipmentTable);

            accessTable = new Element("accessTable");

            for(Career aAccessCareer : aCareer.getAccessCareers()){
                accessCareer = new Element("accessCareer");
                accessCareer.setText(aAccessCareer.getName());
                accessTable.addContent(accessCareer);
            }

            career.addContent(accessTable);

            openingTable = new Element("openingTable");

            for(Career aOpeningCareer : aCareer.getOpeningCareers()){
                openingCareer = new Element("openingCareer");
                openingCareer.setText(aOpeningCareer.getName());
                openingTable.addContent(openingCareer);
            }

            career.addContent(openingTable);

            availableRaces = new Element("availableRaces");

            for(Race aAvailableRace : aCareer.getAvailableRaces()){
                System.out.println(aAvailableRace);
                race = new Element("race");
                race.setText(aAvailableRace.getName());
                availableRaces.addContent(race);
            }

            career.addContent(availableRaces);

            root.addContent(career);
        }

        try {
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/careers.xml"));
        } catch (IOException ignored) {
        }
    }
}
