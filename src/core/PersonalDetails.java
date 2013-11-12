package core;

import core.characteristics.Race;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class PersonalDetails {
    private boolean male;
    private int age;
    private String dateOfBirth;
    private String birthplace;
    private String nationality;
    private String favoriteGod;
    private int height;
    private int weight;
    private String rightEyeColour;
    private String leftEyeColour;
    private String hairColour;
    private LinkedList<String> distinguishingMarks;

    public PersonalDetails(){
        male = true;
        age = 0;
        dateOfBirth = "Unknown";
        birthplace = "Unknown";
        nationality = "Unknown";
        favoriteGod = "Unknown";
        height = 0;
        weight = 0;
        rightEyeColour = "Unknown";
        leftEyeColour = rightEyeColour;
        hairColour = "Unknown";
        distinguishingMarks = new LinkedList<String>();
    }

    public PersonalDetails(boolean male, int age, String dateOfBirth, String birthplace, String nationality,
                           String favoriteGod, int height, int weight, String rightEyeColour, String leftEyeColour,
                           String hairColour, LinkedList<String> distinguishingMarks) {
        this.male = male;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.favoriteGod = favoriteGod;
        this.height = height;
        this.weight = weight;
        this.rightEyeColour = rightEyeColour;
        this.leftEyeColour = leftEyeColour;
        this.hairColour = hairColour;
        this.distinguishingMarks = distinguishingMarks;
    }

    public PersonalDetails(Race race){
        male = true;
        age = 0;
        dateOfBirth = "Unknown";
        birthplace = "Unknown";
        nationality = "Unknown";
        favoriteGod = "Unknown";
        height = 0;
        weight = 0;
        rightEyeColour = "Unknown";
        leftEyeColour = rightEyeColour;
        hairColour = "Unknown";
        distinguishingMarks = new LinkedList<String>();

        this.generateDetails(race);
    }

    public PersonalDetails generateDetails(Race race){
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFavoriteGod() {
        return favoriteGod;
    }

    public void setFavoriteGod(String favoriteGod) {
        this.favoriteGod = favoriteGod;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRightEyeColour() {
        return rightEyeColour;
    }

    public void setRightEyeColour(String rightEyeColour) {
        this.rightEyeColour = rightEyeColour;
    }

    public String getLeftEyeColour() {
        return leftEyeColour;
    }

    public void setLeftEyeColour(String leftEyeColour) {
        this.leftEyeColour = leftEyeColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public LinkedList<String> getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(LinkedList<String> distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }
}
