package textGui;

import core.*;
import core.Character;

import java.util.Random;

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

        core.Character randomCharacter = new Character("Random Player", World.searchRaceByName("Humain"), World.searchCareerByName("Agitateur"));

        System.out.println(randomCharacter);
    }
}
