package convertData;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.stringToInt;
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
            /*} else if(files[i].getName() == "Armures"){

            } else if(files[i].getName() == "Competences"){

            } else if(files[i].getName() == "Objets"){

            } else if(files[i].getName() == "Talents"){

            } else if(files[i].getName() == "Carrieres"){

            } else if(files[i].getName() == "Races"){
*/
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

                int[] price = convertPrices(BasisLibrary.stringToInt())

                liO.add(new Objet(s.substring(0,n),stringToInt(s.substring(n+1, n1)), stringToInt(s.substring(n1+1))));
            }

            br.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }



    public static int[] convertPrices(int price){
        int[] finalPrice = new int[3];

        finalPrice[0] = price / 240;
        finalPrice[1] = (price % 240) / 12;
        finalPrice[3] = (price % 240) % 12;

        return finalPrice;
    }
}
