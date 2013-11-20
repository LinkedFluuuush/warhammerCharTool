package core.entities;

import java.util.LinkedList;

/**
 * User: Linked
 * Date: 18/11/13
 * Time: 20:06
 */
public class God {
    private String name;
    private LinkedList<String> domains;
    private LinkedList<String> worshipers;

    public God(String name, LinkedList<String> domains, LinkedList<String> worshipers) {
        this.name = name;
        this.domains = domains;
        this.worshipers = worshipers;
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getDomains() {
        return domains;
    }

    public LinkedList<String> getWorshipers() {
        return worshipers;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
