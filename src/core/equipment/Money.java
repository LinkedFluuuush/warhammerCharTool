package core.equipment;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Money {
    private int goldenCrowns;
    private int silverShillings;
    private int brassPennies;

    public Money(){
        goldenCrowns = 0;
        silverShillings = 0;
        brassPennies = 0;
    }

    public Money(int goldenCrowns, int silverShillings, int brassPennies) {

        this.goldenCrowns = goldenCrowns;
        this.silverShillings = silverShillings;
        this.brassPennies = brassPennies;
    }

    public Money getRandomMoney(Money moneyMax){
        Random r = new Random();

        this.goldenCrowns = r.nextInt(1 + (moneyMax.getGoldenCrowns() - 1));
        this.silverShillings = r.nextInt(1 + (moneyMax.getSilverShillings() - 1));
        this.brassPennies = r.nextInt(1 + (moneyMax.getBrassPennies() - 1));

        return this;
    }

    public int getGoldenCrowns() {
        return goldenCrowns;
    }

    public void setGoldenCrowns(int goldenCrowns) {
        this.goldenCrowns = goldenCrowns;
    }

    public int getSilverShillings() {
        return silverShillings;
    }

    public void setSilverShillings(int silverShillings) {
        this.silverShillings = silverShillings;
    }

    public int getBrassPennies() {
        return brassPennies;
    }

    public void setBrassPennies(int brassPennies) {
        this.brassPennies = brassPennies;
    }
}
