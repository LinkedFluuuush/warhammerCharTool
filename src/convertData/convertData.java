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
        File mainFolder = new File("oldResources");
        File[] files = mainFolder.listFiles();

        for(int i = 0; i < files.length; i++){
            if(files[i].getName().equals("Armes")){
                convertWeapons(files[i]);
                System.out.println("Conversion des armes effectuée.");
            } else if(files[i].getName().equals("Armures")){
                convertArmours(files[i]);
                System.out.println("Conversion des armures effectuée.");
            } else if(files[i].getName().equals("Competences")){
                convertSkills(files[i]);
                System.out.println("Conversion des compétences effectuée.");
            } else if(files[i].getName().equals("Objets")){
                convertEquipment(files[i]);
                System.out.println("Conversion des objets effectuée.");
            } else if(files[i].getName().equals("Talents")){
                convertTalents(files[i]);
                System.out.println("Conversion des talents effectuée.");
            } else if(files[i].getName().equals("Carrieres")){
                convertCareers(files[i]);
                System.out.println("Conversion des carrières effectuée.");
            } else if(files[i].getName().equals("Races")){
                convertRace(files[i]);
                System.out.println("Conversion des races effectuée.");
            } else {
                System.out.println("Fichier non reconnu : " + files[i].getName() + ".");
            }
        }
    }

    public static void convertWeapons(File file){
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
                    for(int i = 0; i < att.length ; i++){
                        attribute = new Element("attribute");
                        attribute.setText(att[i]);
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

    public static void convertArmours(File file){
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

                armour = new Element("Armour");

                armour.setAttribute("name", s1[0]);
                armour.setAttribute("enc", s1[1]);

                int[] price = convertPrices(BasisLibrary.stringToInt(s1[2]));

                armour.setAttribute("goldenCrowns", "" + price[0]);
                armour.setAttribute("silverShillings", "" + price[1]);
                armour.setAttribute("brassPennies", "" + price[2]);

                for(int i = 0; i < zones.length ; i++){
                    zone = new Element("zone");
                    zone.setText(zones[i]);
                    armour.addContent(zone);
                }

                armour.setAttribute("armourLevel", s1[3]);

                root.addContent(armour);
            }

            br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/armours.xml"));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void convertEquipment(File file){
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
            xmlOutputter.output(document, new FileOutputStream("resources/equipment.xml"));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void convertSkills(File file){
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
                    skill.setAttribute("competence", s.substring(n+1));

                    root.addContent(skill);
                }

                br.close();

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/skills.xml"));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void convertTalents(File file){
        System.out.println("Traitement de : " + file.getName());

        Element root = new Element("talents");
        Document document = new Document(root);
        Element talent;

        String s;
        String[] s1;
        int n;

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
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void convertRace(File file){
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

                Element wounds = new Element("wounds");

                for(int i = 0; i < elts.length ; i++){
                    Element choice = new Element("choice");
                    choice.setText(elts[i]);
                    wounds.addContent(choice);
                }

                race.addContent(wounds);

                line = br.readLine();
                elts = line.split(",");

                Element fate = new Element("fate");

                for(int i = 0; i < elts.length ; i++){
                    Element choice = new Element("choice");
                    choice.setText(elts[i]);
                    fate.addContent(choice);
                }
                race.addContent(fate);

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

                Element weightTable = new Element("weightTable");

                for(String weight : elts){
                    Element eWeight = new Element("eWeight");
                    eWeight.setText(weight);
                    weightTable.addContent(eWeight);
                }

                race.addContent(weightTable);

                line = br.readLine();
                elts = line.split(",");

                Element ageTable = new Element("ageTable");

                for(String age : elts){
                    Element eAge = new Element("eAge");
                    eAge.setText(age);
                    ageTable.addContent(eAge);
                }

                race.addContent(ageTable);

                line = br.readLine();
                elts = line.split(",");

                Element competencesTable = new Element("competencesTable");

                for(String competences : elts){
                    Element eCompetences = new Element("eCompetences");

                    String[] choices = competences.split(":");

                    for(int i = 0 ; i < choices.length ; i++){
                        Element choice = new Element("choice");
                        choice.setText(choices[i]);
                        eCompetences.addContent(choice);
                    }

                    competencesTable.addContent(eCompetences);
                }

                race.addContent(competencesTable);

                line = br.readLine();
                elts = line.split(",");

                Element talentsTable = new Element("talentsTable");

                for(String talents : elts){
                    Element eTalents = new Element("eTalents");

                    String[] choices = talents.split(":");

                    for(int i = 0 ; i < choices.length ; i++){
                        Element choice = new Element("choice");
                        choice.setText(choices[i]);
                        eTalents.addContent(choice);
                    }

                    talentsTable.addContent(eTalents);
                }

                race.addContent(talentsTable);

                root.addContent(race);

                br.close();

            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }

        try {
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/races.xml"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void convertCareers(File file){
        File[] careersFiles = file.listFiles();
        Element root = new Element("careers");
        Document document = new Document(root);
        Element career;
        String line;
        String[] elts;

        for(File f : careersFiles){
            System.out.println("Traitement de : " + f.getName());

            career = new Element("career");
            career.setName(f.getName());

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

                Element competencesTable = new Element("competencesTable");

                for(String competences : elts){
                    Element eCompetences = new Element("eCompetences");

                    String[] choices = competences.split(":");

                    for(int i = 0 ; i < choices.length ; i++){
                        Element choice = new Element("choice");
                        choice.setText(choices[i]);
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

                    for(int i = 0 ; i < choices.length ; i++){
                        Element choice = new Element("choice");
                        choice.setText(choices[i]);
                        eTalents.addContent(choice);
                    }

                    talentsTable.addContent(eTalents);
                }

                career.addContent(talentsTable);

                line = br.readLine();
                elts = line.split(",");

                Element trappingsTable = new Element("trappingsTable");

                for(String trapping : elts){
                    Element eTrappings = new Element("eTrappings");

                    String[] choices = trapping.split(":");

                    for(int i = 0 ; i < choices.length ; i++){
                        Element choice = new Element("choice");
                        choice.setText(choices[i]);
                        eTrappings.addContent(choice);
                    }

                    talentsTable.addContent(eTrappings);
                }

                career.addContent(trappingsTable);

                root.addContent(career);

            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }

        try {
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream("resources/careers.xml"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public static int[] convertPrices(int price){
        int[] finalPrice = new int[3];

        finalPrice[0] = price / 240;
        finalPrice[1] = (price % 240) / 12;
        finalPrice[2] = (price % 240) % 12;

        return finalPrice;
    }
}
