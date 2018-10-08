package core.xmlHelper;

import core.World;
import core.characteristics.Career;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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

        Career aCareer;
        for(String aCareerName : World.CAREERS.keySet()){
            aCareer = World.loadCareer(aCareerName);
            career = new Element("career");
            career.setAttribute("name", aCareer.getName());
            if(aCareer.getType() == Career.CareerType.BASE) {
                career.setAttribute("type", "1");
            } else {
                career.setAttribute("type", "0");
            }

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

            for(LinkedList<String> skillList : aCareer.getSkills()){
                eSkill = new Element("eSkills");
                for(String aSkill : skillList){
                    choice = new Element("choice");
                    choice.setText(aSkill);
                    eSkill.addContent(choice);
                }
                skillTable.addContent(eSkill);
            }

            career.addContent(skillTable);

            talentTable = new Element("talentsTable");

            for(LinkedList<String> talentList : aCareer.getTalents()){
                eTalent = new Element("eTalents");
                for(String aTalent : talentList){
                    choice = new Element("choice");
                    choice.setText(aTalent);
                    eTalent.addContent(choice);
                }
                talentTable.addContent(eTalent);
            }

            career.addContent(talentTable);

            weaponTable = new Element("weaponsTable");

            for(LinkedList<String> weaponList : aCareer.getWeapons()){
                eWeapon = new Element("eWeapons");
                for(String aWeapon : weaponList){
                    choice = new Element("choice");
                    choice.setText(aWeapon);
                    eWeapon.addContent(choice);
                }
                weaponTable.addContent(eWeapon);
            }

            career.addContent(weaponTable);

            armourTable = new Element("armoursTable");

            for(LinkedList<String> armourList : aCareer.getArmours()){
                eArmour = new Element("eArmours");
                for(String aArmour : armourList){
                    choice = new Element("choice");
                    choice.setText(aArmour);
                    eArmour.addContent(choice);
                }
                armourTable.addContent(eArmour);
            }

            career.addContent(armourTable);

            equipmentTable = new Element("equipmentsTable");

            for(LinkedList<String> equipmentList : aCareer.getEquipments()){
                eEquipment = new Element("eEquipments");
                for(String aEquipment : equipmentList){
                    choice = new Element("choice");
                    choice.setText(aEquipment);
                    eEquipment.addContent(choice);
                }
                equipmentTable.addContent(eEquipment);
            }

            career.addContent(equipmentTable);

            accessTable = new Element("accessTable");

            Set set = new HashSet() ;
            set.addAll(aCareer.getAccessCareers()) ;
            LinkedList<String> distinctList = new LinkedList(set) ;

            for(String aAccessCareer : distinctList){
                accessCareer = new Element("accessCareer");
                accessCareer.setText(aAccessCareer);
                accessTable.addContent(accessCareer);
            }

            career.addContent(accessTable);

            openingTable = new Element("openingTable");

            set = new HashSet() ;
            set.addAll(aCareer.getOpeningCareers()) ;
            distinctList = new LinkedList(set) ;

            for(String aOpeningCareer : distinctList){
                openingCareer = new Element("openingCareer");
                openingCareer.setText(aOpeningCareer);
                openingTable.addContent(openingCareer);
            }

            career.addContent(openingTable);

            availableRaces = new Element("availableRaces");

            set = new HashSet() ;
            set.addAll(aCareer.getAvailableRaces()) ;
            distinctList = new LinkedList(set) ;

            if(distinctList.size() == 0){
                distinctList.addAll(World.RACES.keySet());
            }

            for(String aAvailableRace : distinctList){
                race = new Element("race");
                race.setText(aAvailableRace);
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
