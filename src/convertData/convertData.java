package convertData;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

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
            if(files[i].getName() == "Armes"){
                convertWeapons(files[i]);
            } else if(files[i].getName() == "Armures"){

            } else if(files[i].getName() == "Competences"){

            } else if(files[i].getName() == "Objets"){

            } else if(files[i].getName() == "Talents"){

            } else if(files[i].getName() == "Carrieres"){

            } else if(files[i].getName() == "Races"){

            } else {
                System.out.println("Fichier non reconnu : " + files[i].getName() + ".");
            }
        }
    }

    public static void convertWeapons(File file){
        Element root = new Element("weapons");
        Document document = new Document(root);
        Element weapon;
        Element price;
        Element attributes;

        String s;
        String[] att, s1;
        int goldenCrowns, silverShillings, brassPennies;

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

                attributes = new Element("attributes");

                goldenCrowns = BasisLibrary.stringToInt(s1[2]) / 240;
                silverShillings = (BasisLibrary.stringToInt(s1[2]) % 240) / 12;
                brassPennies = (BasisLibrary.stringToInt(s1[2]) % 240) % 12;

                weapon.setAttribute("goldenCrowns", "" + goldenCrowns);
                weapon.setAttribute("silverShillings", "" + silverShillings);
                weapon.setAttribute("brassPennies", "" + brassPennies);



                liA.add(new Arme(s1[0], stringToInt(s1[1]), stringToInt(s1[2]),
                        s1[3], s1[4], stringToInt(s1[5]), stringToInt(s1[6]),
                        stringToInt(s1[7]), att));
            }

            br.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
