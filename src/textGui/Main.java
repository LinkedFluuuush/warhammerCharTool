package textGui;

import core.*;

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

        //core.entities.Character randomCharacter = new Character("Random Player", World.searchRaceByName("Humain"), World.searchCareerByName("Agitateur"));

        //System.out.println(randomCharacter);

        System.out.println(World.ASTRALSIGNS);
    }
}
