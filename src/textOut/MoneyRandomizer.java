package textOut;

import core.equipment.Money;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 17/11/13
 * Time: 19:08
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class MoneyRandomizer {

    public static Money randomMoney(int base){
        Random r = new Random();
        int initialMoney = base;

        int goldenCrowns = r.nextInt(initialMoney + 1);

        int silverShillings = 0;
        int brassPennies = 0;

        initialMoney = initialMoney - goldenCrowns;

        if(initialMoney > 0){
            initialMoney = initialMoney * 20;
            silverShillings = r.nextInt(initialMoney + 1);
            initialMoney = initialMoney - silverShillings;

            if(initialMoney > 0){
                brassPennies = initialMoney * 12;
            }
        }

        return new Money(goldenCrowns, silverShillings, brassPennies);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int base;

        do{
            System.out.println("Combien d'or ?");
            base = sc.nextInt();

        System.out.println(randomMoney(base) + "\n");
        } while(base != 0);
    }
}
