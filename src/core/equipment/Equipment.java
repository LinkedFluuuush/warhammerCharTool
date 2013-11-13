package core.equipment;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Equipment {
    private String name;
    private int enc;
    private Money price;

    public Equipment(String name, Money price, int enc) {
        this.name = name;
        this.price = price;
        this.enc = enc;
    }

    public Equipment(String name, int goldenCrowns, int silverShillings,
                     int brassPennies, int enc) {
        this.name = name;
        this.enc = enc;
        this.price = new Money(goldenCrowns, silverShillings, brassPennies);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnc() {
        return enc;
    }

    public void setEnc(int enc) {
        this.enc = enc;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
