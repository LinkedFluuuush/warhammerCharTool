package convertData;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 12/11/13
 * Time: 16:38
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class convertData{
    public static void main(String[] args){
        convertAll();
    }

    public static void convertAll(){
        File mainFolder = new File("oldResources");
        File[] files = mainFolder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals("Armes")) {
                convertWeapons(file);
                System.out.println("Conversion des armes effectuée.");
            } else if (file.getName().equals("Armures")) {
                convertArmours(file);
                System.out.println("Conversion des armures effectuée.");
            } else if (file.getName().equals("Competences")) {
                convertSkills(file);
                System.out.println("Conversion des compétences effectuée.");
            } else if (file.getName().equals("Objets")) {
                convertEquipment(file);
                System.out.println("Conversion des objets effectuée.");
            } else if (file.getName().equals("Talents")) {
                convertTalents(file);
                System.out.println("Conversion des TALENTS effectuée.");
            } else if (file.getName().equals("Carrieres")) {
                convertCareers(file);
                System.out.println("Conversion des carrières effectuée.");
            } else if (file.getName().equals("Races")) {
                convertRace(file);
                System.out.println("Conversion des races effectuée.");
            } else if(file.getName().equals("Dieux")){
                convertGods(file);
                System.out.println("Conversion des dieux effectuée.");
            } else if(file.getName().equals("Signes Astraux")){
                convertAstralSigns(file);
                System.out.println("Conversion des signes astraux effectuée.");
            } else if(file.getName().equals("Signes Distinctifs")){
                convertDistinguishingSigns(file);
                System.out.println("Conversion des signes distinctifs effectuée.");
            } else {
                System.out.println("Fichier non reconnu : " + file.getName() + ".");
            }
        }
    }

    private static void convertWeapons(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("weapons");
        Document document = new Document(root);
        Element weapon;
        Element attribute;

        String s;
        String[] att, s1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                s = br.readLine();
                att=s.substring(s.lastIndexOf(":")+1).split(",");
                s1=s.split(":");

                weapon = new Element("weapon");
                weapon.setAttribute("name", s1[0]);
                weapon.setAttribute("enc", s1[1]);
                weapon.setAttribute("group", s1[3]);
                weapon.setAttribute("damage", s1[4]);
                weapon.setAttribute("lowRange", s1[5]);
                weapon.setAttribute("highRange", s1[6]);
                weapon.setAttribute("reload", s1[7]);

                if(!att[0].equals("Aucun")){
                    for (String anAtt : att) {
                        attribute = new Element("attribute");
                        attribute.setText(anAtt);
                        weapon.addContent(attribute);
                    }
                }

                int[] price = convertPrices(BasisLibrary.stringToInt(s1[2]));

                weapon.setAttribute("goldenCrowns", "" + price[0]);
                weapon.setAttribute("silverShillings", "" + price[1]);
                weapon.setAttribute("brassPennies", "" + price[2]);

                root.addContent(weapon);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/weapons.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertArmours(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("armours");
        Document document = new Document(root);
        Element armour;
        Element zone;

        String s;
        String[] zones, s1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                s = br.readLine();
                zones=s.substring(s.lastIndexOf(":")+1).split(",");
                s1=s.split(":");

                armour = new Element("armour");

                armour.setAttribute("name", s1[0]);
                armour.setAttribute("enc", s1[1]);

                int[] price = convertPrices(BasisLibrary.stringToInt(s1[2]));

                armour.setAttribute("goldenCrowns", "" + price[0]);
                armour.setAttribute("silverShillings", "" + price[1]);
                armour.setAttribute("brassPennies", "" + price[2]);

                for (String zone1 : zones) {
                    zone = new Element("zone");
                    zone.setText(zone1);
                    armour.addContent(zone);
                }

                armour.setAttribute("armourLevel", s1[3]);

                root.addContent(armour);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/armours.xml"));
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {
        }
    }

    private static void convertEquipment(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("equipments");
        Document document = new Document(root);
        Element equipment;

        String s;
        String[] s1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                s = br.readLine();

                s1 = s.split(":");

                equipment = new Element("equipment");

                equipment.setAttribute("name", s1[0]);
                equipment.setAttribute("enc", s1[1]);

                int[] price = convertPrices(BasisLibrary.stringToInt(s1[2]));

                equipment.setAttribute("goldenCrowns", ""+price[0]);
                equipment.setAttribute("silverShillings", ""+price[1]);
                equipment.setAttribute("brassPennies", ""+price[2]);

                root.addContent(equipment);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/equipments.xml"));
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {
        }
    }

    private static void convertSkills(File file){
            System.out.println("Traitement de : " + file.getName());

            Element root = new Element("skills");
            Document document = new Document(root);
            Element skill;

            String s;
            int n;

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while(br.ready()){
                    s = br.readLine();
                    n = s.lastIndexOf(' ');

                    skill = new Element("skill");

                    skill.setAttribute("name", s.substring(0, n));

                    if(s.substring(n+1).equals("CC"))
                        skill.setAttribute("characteristics", "WS");
                    else if(s.substring(n+1).equals("CT"))
                        skill.setAttribute("characteristics", "BS");
                    else if(s.substring(n+1).equals("F"))
                        skill.setAttribute("characteristics", "S");
                    else if(s.substring(n+1).equals("E"))
                        skill.setAttribute("characteristics", "T");
                    else if(s.substring(n+1).equals("Ag"))
                        skill.setAttribute("characteristics", "Ag");
                    else if(s.substring(n+1).equals("Int"))
                        skill.setAttribute("characteristics", "Int");
                    else if(s.substring(n+1).equals("FM"))
                        skill.setAttribute("characteristics", "WP");
                    else if(s.substring(n+1).equals("Soc"))
                        skill.setAttribute("characteristics", "Fel");

                    root.addContent(skill);
                }

                br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/skills.xml"));
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {
        }
    }

    private static void convertTalents(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("talents");
        Document document = new Document(root);
        Element talent;

        String s;
        String[] s1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                s = br.readLine();
                s1 = s.split(":");

                talent = new Element("talent");

                talent.setAttribute("name", s1[0]);
                talent.setAttribute("description", s1[1]);

                root.addContent(talent);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/talents.xml"));
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {
        }
    }

    private static void convertRace(File file){
        File[] raceFiles = file.listFiles();
        Element root = new Element("races");
        Document document = new Document(root);
        Element race;
        String line;
        String[] elts;

        for(File f : raceFiles){
            System.out.println("Traitement de : " + f.getName());

            race = new Element("race");
            race.setAttribute("name", f.getName());

            try {
                BufferedReader br = new BufferedReader(new FileReader(f));

                line = br.readLine();
                elts = line.split(",");

                Element profile = new Element("profile");

                profile.setAttribute("WS", elts[0]);
                profile.setAttribute("BS", elts[1]);
                profile.setAttribute("S", elts[2]);
                profile.setAttribute("T", elts[3]);
                profile.setAttribute("Ag", elts[4]);
                profile.setAttribute("Int", elts[5]);
                profile.setAttribute("WP", elts[6]);
                profile.setAttribute("Fel", elts[7]);
                profile.setAttribute("M", elts[8]);

                race.addContent(profile);

                Element size = new Element("size");
                size.setAttribute("F", elts[9]);
                size.setAttribute("M", elts[10]);

                race.addContent(size);

                line = br.readLine();
                elts = line.split(",");

                for (String elt : elts) {
                    Element choice = new Element("wounds");
                    choice.setText(elt);
                    race.addContent(choice);
                }
                line = br.readLine();
                elts = line.split(",");

                for (String elt : elts) {
                    Element choice = new Element("fate");
                    choice.setText(elt);
                    race.addContent(choice);
                }

                line = br.readLine();
                elts = line.split(",");

                Element names = new Element("fNames");

                for(String name : elts){
                    Element eName = new Element("name");
                    eName.setText(name);
                    names.addContent(eName);
                }

                race.addContent(names);

                line = br.readLine();
                elts = line.split(",");

                names = new Element("mNames");

                for(String name : elts){
                    Element eName = new Element("name");
                    eName.setText(name);
                    names.addContent(eName);
                }

                race.addContent(names);

                line = br.readLine();
                elts = line.split(",");

                Element hair = new Element("hairColour");

                for(String colour : elts){
                    Element eColour = new Element("colour");
                    eColour.setText(colour);
                    hair.addContent(eColour);
                }

                race.addContent(hair);

                line = br.readLine();
                elts = line.split(",");

                Element eyes = new Element("eyeColour");

                for(String colour : elts){
                    Element eColour = new Element("colour");
                    eColour.setText(colour);
                    eyes.addContent(eColour);
                }

                race.addContent(eyes);

                line = br.readLine();
                elts = line.split(",");

                for(String weight : elts){
                    Element eWeight = new Element("weight");
                    eWeight.setText(weight);
                    race.addContent(eWeight);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String age : elts){
                    Element eAge = new Element("age");
                    eAge.setText(age);
                    race.addContent(eAge);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String competences : elts){
                    Element eCompetences = new Element("skillTable");

                    String[] choices = competences.split(":");

                    for (String choice1 : choices) {
                        Element choice = new Element("skill");
                        choice.setText(choice1);
                        eCompetences.addContent(choice);
                    }

                    race.addContent(eCompetences);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String talents : elts){
                    Element eTalents = new Element("talentTable");

                    String[] choices = talents.split(":");

                    for (String choice1 : choices) {
                        Element choice = new Element("talent");
                        choice.setText(choice1);
                        eTalents.addContent(choice);
                    }

                    race.addContent(eTalents);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String weapon : elts){
                    Element eWeapon = new Element("weaponTable");

                    String[] choices = weapon.split(":");

                    for (String choice1 : choices) {
                        if (!choice1.equals("") && choice1 != null) {
                            Element choice = new Element("weapon");
                            choice.setText(choice1);
                            eWeapon.addContent(choice);
                        }
                    }

                    race.addContent(eWeapon);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String armour : elts){
                    Element eArmours = new Element("armourTable");

                    String[] choices = armour.split(":");

                    for (String choice1 : choices) {
                        if (!choice1.equals("") && choice1 != null) {
                            Element choice = new Element("armour");
                            choice.setText(choice1);
                            eArmours.addContent(choice);
                        }
                    }

                    race.addContent(eArmours);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String equipment : elts){
                    Element eEquipments = new Element("equipmentTable");

                    String[] choices = equipment.split(":");

                    for (String choice1 : choices) {
                        if (!choice1.equals("") && choice1 != null) {
                            Element choice = new Element("equipment");
                            choice.setText(choice1);
                            eEquipments.addContent(choice);
                        }
                    }

                    race.addContent(eEquipments);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String birthPlace : elts){
                    Element eBirthPlace = new Element("birthPlace");

                    if (!birthPlace.equals("") && birthPlace != null) {
                        eBirthPlace.setText(birthPlace);
                    }

                    race.addContent(eBirthPlace);
                }

                line = br.readLine();
                elts = line.split(",");

                for(String god : elts){
                    Element eGod = new Element("god");

                    if (!god.equals("") && god != null) {
                        eGod.setText(god);
                    }

                    race.addContent(eGod);
                }

                root.addContent(race);

                br.close();

            } catch (FileNotFoundException ignored) {
            } catch (IOException ignored) {
            }
        }

        try {
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/races.xml"));
        } catch (IOException ignored) {
        }

    }

    private static void convertCareers(File file){
        File[] careersFiles = file.listFiles();
        Element root = new Element("careers");
        Document document = new Document(root);
        Element career;
        String line;
        String[] elts;

        for(File f : careersFiles){
            if(f.getName().endsWith("~")){
                System.out.println("Fichier ignoré : " + f.getName());
            } else {
                System.out.println("Traitement de : " + f.getName());

                career = new Element("career");
                career.setAttribute("name", f.getName());

                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));

                    line = br.readLine();
                    elts = line.split(",");

                    Element profile = new Element("profile");

                    profile.setAttribute("WS", elts[0]);
                    profile.setAttribute("BS", elts[1]);
                    profile.setAttribute("S", elts[2]);
                    profile.setAttribute("T", elts[3]);
                    profile.setAttribute("Ag", elts[4]);
                    profile.setAttribute("Int", elts[5]);
                    profile.setAttribute("WP", elts[6]);
                    profile.setAttribute("Fel", elts[7]);
                    profile.setAttribute("A", elts[8]);
                    profile.setAttribute("W", elts[9]);
                    profile.setAttribute("M", elts[10]);
                    profile.setAttribute("Mag", elts[11]);

                    career.addContent(profile);

                    line = br.readLine();
                    elts = line.split(",");

                    Element competencesTable = new Element("skillsTable");

                    for(String competences : elts){
                        Element eCompetences = new Element("eSkills");

                        String[] choices = competences.split(":");

                        for (String choice1 : choices) {
                            Element choice = new Element("choice");
                            choice.setText(choice1);
                            eCompetences.addContent(choice);
                        }

                        competencesTable.addContent(eCompetences);
                    }

                    career.addContent(competencesTable);

                    line = br.readLine();
                    elts = line.split(",");

                    Element talentsTable = new Element("talentsTable");

                    for(String talents : elts){
                        Element eTalents = new Element("eTalents");

                        String[] choices = talents.split(":");

                        for (String choice1 : choices) {
                            Element choice = new Element("choice");
                            choice.setText(choice1);
                            eTalents.addContent(choice);
                        }

                        talentsTable.addContent(eTalents);
                    }

                    career.addContent(talentsTable);

                    line = br.readLine();
                    elts = line.split(",");

                    Element weaponsTable = new Element("weaponsTable");

                    for(String weapon : elts){
                        Element eWeapon = new Element("eWeapons");

                        String[] choices = weapon.split(":");

                        for (String choice1 : choices) {
                            if (!choice1.equals("") && choice1 != null) {
                                Element choice = new Element("choice");
                                choice.setText(choice1);
                                eWeapon.addContent(choice);
                            }
                        }

                        weaponsTable.addContent(eWeapon);
                    }

                    career.addContent(weaponsTable);

                    line = br.readLine();
                    elts = line.split(",");

                    Element armoursTable = new Element("armoursTable");

                    for(String armour : elts){
                        Element eArmours = new Element("eArmours");

                        String[] choices = armour.split(":");

                        for (String choice1 : choices) {
                            if (!choice1.equals("") && choice1 != null) {
                                Element choice = new Element("choice");
                                choice.setText(choice1);
                                eArmours.addContent(choice);
                            }
                        }

                        armoursTable.addContent(eArmours);
                    }

                    career.addContent(armoursTable);

                    line = br.readLine();
                    elts = line.split(",");

                    Element equipmentsTable = new Element("equipmentsTable");

                    for(String equipment : elts){
                        Element eEquipments = new Element("eEquipments");

                        String[] choices = equipment.split(":");

                        for (String choice1 : choices) {
                            if (!choice1.equals("") && choice1 != null) {
                                Element choice = new Element("choice");
                                choice.setText(choice1);
                                eEquipments.addContent(choice);
                            }
                        }

                        equipmentsTable.addContent(eEquipments);
                    }

                    career.addContent(equipmentsTable);

                    Element accessTable = new Element("accessTable");
                    Element accessCareer;

                    line = br.readLine();
                    elts = line.split(",");

                    for(String access : elts){
                        accessCareer = new Element("accessCareer");
                        accessCareer.setText(access);
                        accessTable.addContent(accessCareer);
                    }

                    career.addContent(accessTable);

                    Element openingTable = new Element("openingTable");
                    Element openingCareer;

                    line = br.readLine();
                    elts = line.split(",");

                    for(String opening : elts){
                        openingCareer = new Element("openingCareer");
                        openingCareer.setText(opening);
                        openingTable.addContent(openingCareer);
                    }

                    career.addContent(openingTable);

                    line = br.readLine();

                    career.setAttribute("type", line.charAt(0) + "");

                    if(br.ready()){
                        line = br.readLine();
                        elts = line.split(",");

                        Element availableRaces = new Element("availableRaces");

                        for(String s : elts){
                            if(!s.equals("")){
                                Element choice = new Element("race");
                                choice.setText(s);
                                availableRaces.addContent(choice);
                            }
                        }

                        career.addContent(availableRaces);
                    }
                    root.addContent(career);

                } catch (FileNotFoundException ignored) {
                } catch (IOException ignored) {
                }
            }
        }

        try {
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/careers.xml"));
        } catch (IOException ignored) {
        }
    }

    private static void convertGods(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("gods");
        Document document = new Document(root);
        Element god;
        Element domain;
        Element worshiper;

        String line;
        String[] elts;
        String[] elts2;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                line = br.readLine();
                elts = line.split(":");

                god = new Element("god");
                god.setAttribute("name", elts[0]);

                elts2 = elts[1].split(",");

                for(String elt : elts2){
                    domain = new Element("domain");
                    domain.setText(elt);
                    god.addContent(domain);
                }

                elts2 = elts[2].split(",");

                for(String elt : elts2){
                    worshiper = new Element("worshiper");
                    worshiper.setText(elt);
                    god.addContent(worshiper);
                }

                root.addContent(god);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/gods.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertAstralSigns(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("astralSigns");
        Document document = new Document(root);
        Element sign;

        String line;
        String[] elts;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                line = br.readLine();
                elts = line.split(":");

                sign = new Element("astralSign");
                sign.setAttribute("name", elts[0]);
                sign.setAttribute("description", elts[1]);

                root.addContent(sign);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/astralSigns.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertDistinguishingSigns(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("distinguishingSigns");
        Document document = new Document(root);
        Element sign;

        String line;
        String[] elts;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready()){
                line = br.readLine();

                sign = new Element("distinguishingSign");
                sign.setText(line);

                root.addContent(sign);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/distinguishingSigns.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] convertPrices(int price){
        int[] finalPrice = new int[3];

        finalPrice[0] = price / 240;
        finalPrice[1] = (price % 240) / 12;
        finalPrice[2] = (price % 240) % 12;

        return finalPrice;
    }
}
