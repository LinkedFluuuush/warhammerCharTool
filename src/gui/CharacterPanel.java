package gui;

import core.World;
import core.characteristics.Career;
import core.characteristics.Race;
import core.characteristics.Skill;
import core.characteristics.Talent;
import core.entities.Character;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;
import gui.listeners.characterListener.createCharacterAL;
import gui.listeners.characterListener.recoverCharacterAL;
import gui.listeners.characterListener.removeCharacterAL;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 13:09
 */
public class CharacterPanel extends JPanel {
    private Character character;
    private Character previousCharacter;

    public CharacterPanel(Character character){
        super();

//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.character = character;

        applyCharacter();
    }

    public CharacterPanel(){
        super();

//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.character = null;

        applyCharacter();
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getPreviousCharacter() {
        return previousCharacter;
    }

    public void setPreviousCharacter(Character previousCharacter) {
        this.previousCharacter = previousCharacter;
    }

    public void applyCharacter(){
        this.removeAll();
        this.setBackground(Color.WHITE);

        this.setLayout(null);
        this.setMinimumSize(new Dimension(784, 500));

        JTextArea nameArea = new JTextArea(1, 20);
        nameArea.setBounds(60,25,315,16);
        nameArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JComboBox<String> comboRace = new JComboBox<>();
        LinkedList<String> raceSorted = new LinkedList<>(World.RACES.keySet());
        Collections.sort(raceSorted);

        for(String r : raceSorted){
            comboRace.addItem(r);
        }

        comboRace.setBounds(58,70,315,25);

        JComboBox<String> comboCareer = new JComboBox<>();
        LinkedList<String> careerSorted = new LinkedList<>(World.CAREERS.keySet());
        Collections.sort(careerSorted);
        for(String c : careerSorted){
            comboCareer.addItem(c);
        }

        comboCareer.setBounds(80,44,293,25);

        this.add(nameArea);
        this.add(comboRace);
        this.add(comboCareer);

        JButton create = new JButton("Créer un nouveau personnage");
        create.addActionListener(new createCharacterAL(this));

        create.setBounds(650,465,110,25);

        this.add(create);

/*        JButton recover = new JButton("Récupérer le dernier personnage");
        recover.addActionListener(new recoverCharacterAL());
        this.add(recover);*/

        if(this.character != null){
            this.createCharacter();
        }

        this.repaint();
        this.revalidate();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image back = new ImageIcon("./resources/imgs/OneChar.png").getImage();
        g.drawImage(back, 0, 0, null);
    }

    public void createCharacter(){
        JTextArea textAreaName = new JTextArea(character.getName());
        textAreaName.setBounds(60, 28, 310, 17);

        this.add(textAreaName);

        JTextArea textAreaWS = new JTextArea(character.getProfile().getWs() + "");
        textAreaWS.setBounds(30, 154, 30, 15);
        JTextArea textAreaBS = new JTextArea(character.getProfile().getBs() + "");
        textAreaBS.setBounds(73, 154, 30, 15);
        JTextArea textAreaS = new JTextArea(character.getProfile().getS() + "");
        textAreaS.setBounds(116, 154, 30, 15);
        JTextArea textAreaT = new JTextArea(character.getProfile().getT() + "");
        textAreaT.setBounds(159, 154, 30, 15);
        JTextArea textAreaAg = new JTextArea(character.getProfile().getAg() + "");
        textAreaAg.setBounds(202, 154, 30, 15);
        JTextArea textAreaInt = new JTextArea(character.getProfile().getIntel() + "");
        textAreaInt.setBounds(245, 154, 30, 15);
        JTextArea textAreaWP = new JTextArea(character.getProfile().getWp() + "");
        textAreaWP.setBounds(288, 154, 30, 15);
        JTextArea textAreaFel = new JTextArea(character.getProfile().getFel() + "");
        textAreaFel.setBounds(331, 154, 30, 15);

        JTextArea textAreaA = new JTextArea(character.getProfile().getA() + "");
        textAreaA.setBounds(30, 220, 30, 15);
        JTextArea textAreaW = new JTextArea(character.getProfile().getW() + "");
        textAreaW.setBounds(73, 220, 30, 15);
        JTextArea textAreaSB = new JTextArea(character.getProfile().getSb() + "");
        textAreaSB.setBounds(116, 220, 30, 15);
        JTextArea textAreaTB = new JTextArea(character.getProfile().getTb() + "");
        textAreaTB.setBounds(159, 220, 30, 15);
        JTextArea textAreaM = new JTextArea(character.getProfile().getM() + "");
        textAreaM.setBounds(202, 220, 30, 15);
        JTextArea textAreaMag = new JTextArea(character.getProfile().getMag() + "");
        textAreaMag.setBounds(245, 220, 30, 15);
        JTextArea textAreaIP = new JTextArea(character.getProfile().getIp() + "");
        textAreaIP.setBounds(288, 220, 30, 15);
        JTextArea textAreaFP = new JTextArea(character.getProfile().getFp() + "");
        textAreaFP.setBounds(331, 220, 30, 15);

        this.add(textAreaWS);
        this.add(textAreaBS);
        this.add(textAreaS);
        this.add(textAreaT);
        this.add(textAreaAg);
        this.add(textAreaInt);
        this.add(textAreaWP);
        this.add(textAreaFel);

        this.add(textAreaA);
        this.add(textAreaW);
        this.add(textAreaSB);
        this.add(textAreaTB);
        this.add(textAreaM);
        this.add(textAreaMag);
        this.add(textAreaIP);
        this.add(textAreaFP);

        JTextArea textAreaAge = new JTextArea(character.getDetails().getAge() + "");
        textAreaAge.setBounds(55, 250, 165, 17);
        JTextArea textAreaEyeColour = new JTextArea(character.getDetails().getEyeColour() + "");
        textAreaEyeColour.setBounds(125, 275, 95, 17);
        JTextArea textAreaHairColour = new JTextArea(character.getDetails().getHairColour() + "");
        textAreaHairColour.setBounds(140, 300, 80, 17);

        this.add(textAreaAge);
        this.add(textAreaEyeColour);
        this.add(textAreaHairColour);

        JTextArea textAreaSex = new JTextArea();
        if(character.getDetails().isMale()){
            textAreaSex.setText("Masculin");
        } else {
            textAreaSex.setText("Féminin");
        }
        textAreaSex.setBounds(260, 250, 100, 17);

        JTextArea textAreaSize = new JTextArea();
        if(((character.getDetails().getHeight() % 100) + "").length() == 1){
            textAreaSize.setText(character.getDetails().getHeight() / 100 + "m0" +
                    character.getDetails().getHeight() % 100);
        } else {
            textAreaSize.setText(character.getDetails().getHeight() / 100 + "m" +
                    character.getDetails().getHeight() % 100);
        }
        textAreaSize.setBounds(260, 275, 100, 17);

        JTextArea textAreaWeight = new JTextArea(character.getDetails().getWeight() + "kg");
        textAreaWeight.setBounds(260, 300, 100, 17);

        this.add(textAreaSex);
        this.add(textAreaSize);
        this.add(textAreaWeight);

        JTextArea textAreaAstralSign = new JTextArea(character.getDetails().getAstralSign() + "");
        textAreaAstralSign.setBounds(95, 323, 265, 17);
        JTextArea textAreaBirthPlace = new JTextArea(character.getDetails().getBirthplace() + "");
        textAreaBirthPlace.setBounds(145, 348, 215, 17);
        JTextArea textAreaGod = new JTextArea(character.getDetails().getFavoriteGod() + "");
        textAreaGod.setBounds(85, 373, 275, 17);

        this.add(textAreaAstralSign);
        this.add(textAreaBirthPlace);
        this.add(textAreaGod);

        JTextArea textAreaMarks = new JTextArea();
        String allMarks = "";
        for(String mark : character.getDetails().getDistinguishingMarks()){
            allMarks += mark + ", ";
        }
        if(allMarks.length() >= 2){
            allMarks = allMarks.substring(0, allMarks.length() - 2);
        }
        textAreaMarks.setText(allMarks);
        textAreaMarks.setBounds(30, 420, 330, 60);
        textAreaMarks.setLineWrap(true);
        textAreaMarks.setWrapStyleWord(true);

        this.add(textAreaMarks);

/*        JLabel labelSkills = generateLabelSkills();
        labelSkills.setBounds(410, 45, 355, 110);

        JLabel labelTalents = generateLabelTalents();
        labelTalents.setBounds(410, 170, 355, 55);

        JLabel labelArmours = generateLabelArmours();
        labelArmours.setBounds(410, 255, 215, 55);

        JLabel labelWeapons = generateLabelWeapons();
        labelWeapons.setBounds(410, 330, 215, 55);

        JLabel labelEquipment = generateLabelEquipments();
        labelEquipment.setBounds(410, 405, 215, 75);

        this.add(labelSkills);
        this.add(labelTalents);
        this.add(labelArmours);
        this.add(labelWeapons);
        this.add(labelEquipment);*/

//        this.generateArmourLevels();

        JButton removeButton = new JButton("Effacer le personnage");
        removeButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        removeButton.setMargin(new Insets(2, 5, 2, 5));
        removeButton.addActionListener(new removeCharacterAL());
        removeButton.setBounds(620, 450, 140, 30);
        this.add(removeButton);
    }

/*    public JLabel generateLabelSkills(){
        JLabel labelSkills = new JLabel();

        String allSkills = "";
        int level;
        LinkedList<Skill> skills = (LinkedList<Skill>)character.getSkills().clone();
        Skill skill;
        while(!skills.isEmpty()){
            skill = skills.pop();
            if(!allSkills.contains(skill.getName())){
                level = 0;
                while(skills.contains(skill)){
                    level += 10;
                    skills.removeFirstOccurrence(skill);
                }

                allSkills += skill.getName();

                if(level != 0){
                    allSkills += " (+" + level + ")";
                }

                allSkills += ", ";
            }
        }

        if(allSkills.length() >= 2){
            allSkills = allSkills.substring(0, allSkills.length() - 2);
        }

        labelSkills.setText("<html><span>" + allSkills + "</span></html>");
        labelSkills.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        labelSkills.setVerticalTextPosition(SwingConstants.TOP);

        return labelSkills;
    }

    public JLabel generateLabelTalents(){
        JLabel labelTalents = new JLabel();

        String allTalents = "";
        LinkedList<Talent> talents = (LinkedList<Talent>)character.getTalents().clone();
        Talent talent;
        while(!talents.isEmpty()){
            talent = talents.pop();
            if(!allTalents.contains(talent.getName())){
                allTalents += talent.getName() + ", ";
            }
        }

        if(allTalents.length() >= 2){
            allTalents = allTalents.substring(0, allTalents.length() - 2);
        }

        labelTalents.setText("<html><span>" + allTalents + "</span></html>");
        labelTalents.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        labelTalents.setVerticalTextPosition(SwingConstants.TOP);

        return labelTalents;
    }

    public JLabel generateLabelArmours(){
        JLabel labelArmours = new JLabel();

        String allArmours = "";
        LinkedList<Armour> armours = (LinkedList<Armour>)character.getArmours().clone();
        Armour armour;
        while(!armours.isEmpty()){
            armour = armours.pop();
            if(!allArmours.contains(armour.getName())){
                allArmours += armour.getName() + ", ";
            }
        }

        if(allArmours.length() >= 2){
            allArmours = allArmours.substring(0, allArmours.length() - 2);
        }

        labelArmours.setText("<html><span>" + allArmours + "</span></html>");
        labelArmours.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        labelArmours.setVerticalTextPosition(SwingConstants.TOP);

        return labelArmours;
    }

    public JLabel generateLabelWeapons(){
        JLabel labelWeapons = new JLabel();

        String allWeapons = "";
        LinkedList<Weapon> weapons = (LinkedList<Weapon>)character.getWeapons().clone();
        Weapon weapon;
        while(!weapons.isEmpty()){
            weapon = weapons.pop();
            if(!allWeapons.contains(weapon.getName())){
                allWeapons += weapon.getName() + ", ";
            }
        }

        if(allWeapons.length() >= 2){
            allWeapons = allWeapons.substring(0, allWeapons.length() - 2);
        }

        labelWeapons.setText("<html><span>" + allWeapons + "</span></html>");
        labelWeapons.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        labelWeapons.setVerticalTextPosition(SwingConstants.TOP);

        return labelWeapons;
    }

    public JLabel generateLabelEquipments(){
        JLabel labelEquipments = new JLabel();

        String allEquipments = "";
        LinkedList<Equipment> equipments = (LinkedList<Equipment>)character.getEquipment().clone();
        Equipment equipment;
        while(!equipments.isEmpty()){
            equipment = equipments.pop();
            if(!allEquipments.contains(equipment.getName())){
                allEquipments += equipment.getName() + ", ";
            }
        }

        if(allEquipments.length() >= 2){
            allEquipments = allEquipments.substring(0, allEquipments.length() - 2);
        }

        labelEquipments.setText("<html><span>" + allEquipments + "</span></html>");
        labelEquipments.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        labelEquipments.setVerticalTextPosition(SwingConstants.TOP);

        return labelEquipments;
    }

    public void generateArmourLevels(){
        int initH = (int)this.getSize().getWidth()/2 - 392;
        int initV = (int)this.getSize().getHeight()/2 - 250;

        int headLevel = 0, armLevel = 0, bodyLevel = 0, legLevel = 0;

        for(Armour armour : character.getArmours()){
            if(armour.getCoveredZones().contains("Tête")){
                headLevel += armour.getArmourLevel();
            }
            if(armour.getCoveredZones().contains("Bras")){
                armLevel += armour.getArmourLevel();
            }
            if(armour.getCoveredZones().contains("Corps")){
                bodyLevel += armour.getArmourLevel();
            }
            if(armour.getCoveredZones().contains("Jambe")){
                legLevel += armour.getArmourLevel();
            }
        }

        JLabel headLabel = new JLabel(headLevel + "");
        JLabel leftArmLabel = new JLabel(armLevel + "");
        JLabel rightArmLabel = new JLabel(armLevel + "");
        JLabel bodyLabel = new JLabel(bodyLevel + "");
        JLabel leftLegLabel = new JLabel(legLevel + "");
        JLabel rightLegLabel = new JLabel(legLevel + "");

        headLabel.setBounds(initH + 637, initV + 259, 25, 10);
        this.add(headLabel);

        rightArmLabel.setBounds(initH + 637, initV + 357, 25, 10);
        this.add(rightArmLabel);
        leftArmLabel.setBounds(initH + 732, initV + 358, 25, 10);
        this.add(leftArmLabel);

        bodyLabel.setBounds(initH + 732, initV + 289, 25, 10);
        this.add(bodyLabel);

        rightLegLabel.setBounds(initH + 637, initV + 423, 25, 10);
        this.add(rightLegLabel);
        leftLegLabel.setBounds(initH + 732, initV + 424, 25, 10);
        this.add(leftLegLabel);
    }*/
}
