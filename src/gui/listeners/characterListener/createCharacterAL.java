package gui.listeners.characterListener;

import core.entities.Character;
import core.equipment.Money;
import gui.CharacterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 23:30
 */
public class createCharacterAL implements ActionListener {
    private CharacterPanel characterPanel;

    public createCharacterAL(CharacterPanel characterPanel) {
        this.characterPanel = characterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String race = (String)this.characterPanel.getComboRace().getSelectedItem();
        String career = (String)this.characterPanel.getComboCareer().getSelectedItem();
        String name = this.characterPanel.getNameArea().getText();

        String caracs[] = {this.characterPanel.getWsArea().getText(),
                this.characterPanel.getBsArea().getText(),
                this.characterPanel.getsArea().getText(),
                this.characterPanel.gettArea().getText(),
                this.characterPanel.getAgArea().getText(),
                this.characterPanel.getIntArea().getText(),
                this.characterPanel.getWpArea().getText(),
                this.characterPanel.getFelArea().getText(),
                this.characterPanel.getaArea().getText(),
                this.characterPanel.getwArea().getText(),
                this.characterPanel.getSbArea().getText(),
                this.characterPanel.getTbArea().getText(),
                this.characterPanel.getmArea().getText(),
                this.characterPanel.getMagArea().getText(),
                this.characterPanel.getIpArea().getText(),
                this.characterPanel.getFpArea().getText()};

        String age = this.characterPanel.getAgeArea().getText();
        String gender = (String) this.characterPanel.getComboGender().getSelectedItem();
        String eyeColour = this.characterPanel.getEyeColourArea().getText();
        String hairColour = this.characterPanel.getHairColourArea().getText();

        String size = this.characterPanel.getSizeArea().getText();
        String weight = this.characterPanel.getWeightArea().getText();

        String astralSign = (String) this.characterPanel.getComboAstralSign().getSelectedItem();
        String birthPlace = this.characterPanel.getBirthPlaceArea().getText();

        String worshippedGod = (String) this.characterPanel.getComboGod().getSelectedItem();

        String[] marks = this.characterPanel.getMarksArea().getText().split(", ");

        LinkedList<String> skills = new LinkedList<>();
        Component[] labels = this.characterPanel.getSkillPanel().getComponents();
        String aName;

        for(Component c : labels){
            if(c.getClass() == JLabel.class){
                aName = ((JLabel) c).getText().split(" : ")[0];
                if(aName.endsWith("(+10)")){
                    aName = aName.substring(0, aName.length() - 5);
                    skills.add(aName);
                } else if (aName.endsWith("(+20)")){
                    aName = aName.substring(0, aName.length() - 5);
                    skills.add(aName);
                    skills.add(aName);
                }

                skills.add(aName);
            }
        }

        LinkedList<String> talents = new LinkedList<>();
        labels = this.characterPanel.getTalentPanel().getComponents();

        for(Component c : labels){
            if(c.getClass() == JLabel.class){
                aName = ((JLabel) c).getText();

                talents.add(aName);
            }
        }

        LinkedList<String> armours = new LinkedList<>();
        labels = this.characterPanel.getArmourPanel().getComponents();

        for(Component c : labels){
            if(c.getClass() == JLabel.class){
                aName = ((JLabel) c).getText();

                armours.add(aName);
            }
        }

        LinkedList<String> weapons = new LinkedList<>();
        labels = this.characterPanel.getWeaponPanel().getComponents();

        for(Component c : labels){
            if(c.getClass() == JLabel.class){
                aName = ((JLabel) c).getText();

                weapons.add(aName);
            }
        }

        LinkedList<String> equipments = new LinkedList<>();
        labels = this.characterPanel.getEquipmentPanel().getComponents();
        Money money = new Money(0, 0, 0);

        for(Component c : labels){
            if(c.getClass() == JLabel.class){
                aName = ((JLabel) c).getText();

                if(aName.startsWith("Money : ")){
                    aName = aName.substring(8);
                    String[] moneySplitted = aName.split(", ");

                    moneySplitted[0] = moneySplitted[0].substring(0, moneySplitted[0].length()-3);
                    moneySplitted[1] = moneySplitted[1].substring(0, moneySplitted[1].length() - 3);
                    moneySplitted[2] = moneySplitted[2].substring(0, moneySplitted[2].length() - 3);

                    money.setGoldenCrowns(Integer.parseInt(moneySplitted[0]));
                    money.setSilverShillings(Integer.parseInt(moneySplitted[1]));
                    money.setBrassPennies(Integer.parseInt(moneySplitted[2]));
                } else {
                    equipments.add(aName);
                }
            }
        }

        Character character = new Character(name, "NPC", race, career, "NPC",
                caracs, age, eyeColour, hairColour, gender, size, weight, astralSign, birthPlace,
                worshippedGod, marks, skills, talents, armours, weapons, equipments, money);

        characterPanel.setCharacter(character);
        characterPanel.applyCharacter();

        JTabbedPane tabbedPane = (JTabbedPane)characterPanel.getParent();
        String title = "";

        if(characterPanel.getCharacter().getName() != null && !characterPanel.getCharacter().getName().equals("")){
            title += characterPanel.getCharacter().getName() + " - ";
        }

        title += characterPanel.getCharacter().getRace()
                + " " + characterPanel.getCharacter().getCareer();

        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), title);

        this.characterPanel.getCreateCharacterButton().setEnabled(false);
    }
}
