package textGui;

import core.*;
import core.entities.*;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 13/11/13
 * Time: 16:57
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        World.loadAll();

        core.entities.Character randomCharacter = new core.entities.Character("Random Player", World.searchRaceByName("Halfing"), World.searchCareerByName("Agitateur"), "PC");

//        System.out.println(World.CAREERS.get(0).getAvailableRaces());

//        System.out.println(World.searchRaceByName("Halfing").getBirthPlaces());

        /*String[] regions = {"Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Le Moot", "Averland","Hochland","Middenland","Nordland","Ostermark","Ostland","Reikland","Stirland","Talabecland","Wissenland"};
        String[] villes = {"Cité", "Ville prospère", "Bourg", "Ville fortifiée", "Village agricole", "Village pauvre", "Petite communauté", "Ferme d'élevage", "Ferme de culture", "Taudis"};

        for(String s : regions){
            for(String s2 : villes){
                if(!s.equals("Le Moot"))
                    System.out.print(s + " (" + s2 +"),");
                else
                    System.out.print(s +",");
            }
        }*/
    }
}
