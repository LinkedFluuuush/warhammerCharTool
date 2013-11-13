package core.characteristics;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class Race {
    private String name;
    private Profile profile;
    private int fSize;
    private int mSize;
    private int[] wounds;
    private int[] fate;
    private int[] weight;
    private int[] age;
    private String[] mNames;
    private String[] fNames;
    private String[] hairColour;
    private String[] eyeColour;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;

    public Race(String name, Profile profile, int fSize, int mSize, int[] wounds,
                int[] fate, int[] weight, int[] age, String[] mNames, String[] fNames,
                String[] hairColour, String[] eyeColour,
                LinkedList<LinkedList<Skill>> skills,
                LinkedList<LinkedList<Talent>> talents) {
        this.name = name;
        this.profile = profile;
        this.fSize = fSize;
        this.mSize = mSize;
        this.wounds = wounds;
        this.fate = fate;
        this.weight = weight;
        this.age = age;
        this.mNames = mNames;
        this.fNames = fNames;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.skills = skills;
        this.talents = talents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getfSize() {
        return fSize;
    }

    public void setfSize(int fSize) {
        this.fSize = fSize;
    }

    public int getmSize() {
        return mSize;
    }

    public void setmSize(int mSize) {
        this.mSize = mSize;
    }

    public int[] getWounds() {
        return wounds;
    }

    public void setWounds(int[] wounds) {
        this.wounds = wounds;
    }

    public int[] getFate() {
        return fate;
    }

    public void setFate(int[] fate) {
        this.fate = fate;
    }

    public int[] getWeight() {
        return weight;
    }

    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    public int[] getAge() {
        return age;
    }

    public void setAge(int[] age) {
        this.age = age;
    }

    public String[] getmNames() {
        return mNames;
    }

    public void setmNames(String[] mNames) {
        this.mNames = mNames;
    }

    public String[] getfNames() {
        return fNames;
    }

    public void setfNames(String[] fNames) {
        this.fNames = fNames;
    }

    public String[] getHairColour() {
        return hairColour;
    }

    public void setHairColour(String[] hairColour) {
        this.hairColour = hairColour;
    }

    public String[] getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String[] eyeColour) {
        this.eyeColour = eyeColour;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<LinkedList<Skill>> skills) {
        this.skills = skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<LinkedList<Talent>> talents) {
        this.talents = talents;
    }
}
