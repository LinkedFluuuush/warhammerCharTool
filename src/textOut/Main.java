package textOut;

import core.World;

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

//        World.loadDistinguishingSigns();
//        World.loadAstralSign("Le Trait du Peintre");

//        core.entities.Character randomCharacter = new core.entities.Character("Random Player", "Halfing", "Agitateur", "PC");

//        System.out.println(randomCharacter);

//        System.out.println(World.careers.get(0).getAvailableRaces());

        System.out.println(World.loadRace("Halfing").getBirthPlaces());

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
