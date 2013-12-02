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
import listeners.removeParentML;

import javax.swing.*;
import java.awt.*;
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

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.character = character;

        applyCharacter();
    }

    public CharacterPanel(){
        super();

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
        this.repaint();

        if(this.character == null){
            this.setLayout(new FlowLayout());

            JComboBox<Race> comboRace = new JComboBox<Race>();
            for(Race r : World.RACES){
                comboRace.addItem(r);
            }

            JComboBox<Career> comboCareer = new JComboBox<Career>();
            for(Career c : World.CAREERS){
                comboCareer.addItem(c);
            }

            this.add(comboRace);
            this.add(comboCareer);

            JButton create = new JButton("Créer un nouveau personnage");
            create.addActionListener(new createCharacterAL(comboRace, comboCareer, this));
            this.add(create);

            JButton recover = new JButton("Récupérer le dernier personnage");
            recover.addActionListener(new recoverCharacterAL());
            this.add(recover);

            this.revalidate();
        } else {
            this.setLayout(null);
            //JPanel panel = character.toPanel();
            //this.add(panel);
            this.setMinimumSize(new Dimension(784, 500));

            this.createCharacter();
        }

        //this.revalidate();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(this.character != null){
            int initH = (int)this.getSize().getWidth()/2 - 392;
            int initV = (int)this.getSize().getHeight()/2 - 250;

            g.drawImage(new ImageIcon("./resources/imgs/OneChar.png").getImage(),
                (int)this.getSize().getWidth()/2 - 392,
                (int)this.getSize().getHeight()/2 - 250, null);
        }
    }

    public void createCharacter(){
        int initH = (int)this.getSize().getWidth()/2 - 392;
        int initV = (int)this.getSize().getHeight()/2 - 250;

        JTextArea textAreaName = new JTextArea(character.getName());

        String s = character.getCareer().getName();

        /*if(character.getPreviousCareers() != null || !character.getPreviousCareers().isEmpty()){
           s += " (Anciennement ";

            for(Career career : character.getPreviousCareers()){
                s += career +", ";
            }

            s = s.substring(0, s.length() - 2);

            s += ")";
        }*/

        JLabel labelCareer = new JLabel(s);

        JLabel labelRace = new JLabel(character.getRace().getName());


        textAreaName.setBounds(initH + 60, initV + 28, 310, 17);
        labelCareer.setBounds(initH + 85, initV + 52, 285, 17);
        labelRace.setBounds(initH + 60, initV + 78, 310, 17);

        this.add(textAreaName);
        this.add(labelCareer);
        this.add(labelRace);

        JTextArea textAreaWS = new JTextArea(character.getProfile().getWs() + "");
        textAreaWS.setBounds(initH + 30, initV + 154, 30, 15);
        JTextArea textAreaBS = new JTextArea(character.getProfile().getBs() + "");
        textAreaBS.setBounds(initH + 73, initV + 154, 30, 15);
        JTextArea textAreaS = new JTextArea(character.getProfile().getS() + "");
        textAreaS.setBounds(initH + 116, initV + 154, 30, 15);
        JTextArea textAreaT = new JTextArea(character.getProfile().getT() + "");
        textAreaT.setBounds(initH + 159, initV + 154, 30, 15);
        JTextArea textAreaAg = new JTextArea(character.getProfile().getAg() + "");
        textAreaAg.setBounds(initH + 202, initV + 154, 30, 15);
        JTextArea textAreaInt = new JTextArea(character.getProfile().getIntel() + "");
        textAreaInt.setBounds(initH + 245, initV + 154, 30, 15);
        JTextArea textAreaWP = new JTextArea(character.getProfile().getWp() + "");
        textAreaWP.setBounds(initH + 288, initV + 154, 30, 15);
        JTextArea textAreaFel = new JTextArea(character.getProfile().getFel() + "");
        textAreaFel.setBounds(initH + 331, initV + 154, 30, 15);

        JTextArea textAreaA = new JTextArea(character.getProfile().getA() + "");
        textAreaA.setBounds(initH + 30, initV + 220, 30, 15);
        JTextArea textAreaW = new JTextArea(character.getProfile().getW() + "");
        textAreaW.setBounds(initH + 73, initV + 220, 30, 15);
        JTextArea textAreaSB = new JTextArea(character.getProfile().getSb() + "");
        textAreaSB.setBounds(initH + 116, initV + 220, 30, 15);
        JTextArea textAreaTB = new JTextArea(character.getProfile().getTb() + "");
        textAreaTB.setBounds(initH + 159, initV + 220, 30, 15);
        JTextArea textAreaM = new JTextArea(character.getProfile().getM() + "");
        textAreaM.setBounds(initH + 202, initV + 220, 30, 15);
        JTextArea textAreaMag = new JTextArea(character.getProfile().getMag() + "");
        textAreaMag.setBounds(initH + 245, initV + 220, 30, 15);
        JTextArea textAreaIP = new JTextArea(character.getProfile().getIp() + "");
        textAreaIP.setBounds(initH + 288, initV + 220, 30, 15);
        JTextArea textAreaFP = new JTextArea(character.getProfile().getFp() + "");
        textAreaFP.setBounds(initH + 331, initV + 220, 30, 15);

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
        textAreaAge.setBounds(initH + 55, initV + 250, 165, 17);
        JTextArea textAreaEyeColour = new JTextArea(character.getDetails().getEyeColour() + "");
        textAreaEyeColour.setBounds(initH + 125, initV + 275, 95, 17);
        JTextArea textAreaHairColour = new JTextArea(character.getDetails().getHairColour() + "");
        textAreaHairColour.setBounds(initH + 140, initV + 300, 80, 17);

        this.add(textAreaAge);
        this.add(textAreaEyeColour);
        this.add(textAreaHairColour);

        JTextArea textAreaSex = new JTextArea();
        if(character.getDetails().isMale()){
            textAreaSex.setText("Masculin");
        } else {
            textAreaSex.setText("Féminin");
        }
        textAreaSex.setBounds(initH + 260, initV + 250, 100, 17);

        JTextArea textAreaSize = new JTextArea();
        if(((character.getDetails().getHeight() % 100) + "").length() == 1){
            textAreaSize.setText(character.getDetails().getHeight() / 100 + "m0" +
                    character.getDetails().getHeight() % 100);
        } else {
            textAreaSize.setText(character.getDetails().getHeight() / 100 + "m" +
                    character.getDetails().getHeight() % 100);
        }
        textAreaSize.setBounds(initH + 260, initV + 275, 100, 17);

        JTextArea textAreaWeight = new JTextArea(character.getDetails().getWeight() + "kg");
        textAreaWeight.setBounds(initH + 260, initV + 300, 100, 17);

        this.add(textAreaSex);
        this.add(textAreaSize);
        this.add(textAreaWeight);

        JTextArea textAreaAstralSign = new JTextArea(character.getDetails().getAstralSign() + "");
        textAreaAstralSign.setBounds(initH + 95, initV + 323, 265, 17);
        JTextArea textAreaBirthPlace = new JTextArea(character.getDetails().getBirthplace() + "");
        textAreaBirthPlace.setBounds(initH + 145, initV + 348, 215, 17);
        JTextArea textAreaGod = new JTextArea(character.getDetails().getFavoriteGod() + "");
        textAreaGod.setBounds(initH + 85, initV + 373, 275, 17);

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
        textAreaMarks.setBounds(initH + 30, initV + 420, 330, 60);
        textAreaMarks.setLineWrap(true);
        textAreaMarks.setWrapStyleWord(true);

        this.add(textAreaMarks);

        JLabel labelSkills = generateLabelSkills();
        labelSkills.setBounds(initH + 410, initV + 45, 355, 110);

        JLabel labelTalents = generateLabelTalents();
        labelTalents.setBounds(initH + 410, initV + 170, 355, 55);

        JLabel labelArmours = generateLabelArmours();
        labelArmours.setBounds(initH + 410, initV + 255, 215, 55);

        JLabel labelWeapons = generateLabelWeapons();
        labelWeapons.setBounds(initH + 410, initV + 330, 215, 55);

        JLabel labelEquipment = generateLabelEquipments();
        labelEquipment.setBounds(initH + 410, initV + 405, 215, 75);

        this.add(labelSkills);
        this.add(labelTalents);
        this.add(labelArmours);
        this.add(labelWeapons);
        this.add(labelEquipment);

        this.generateArmourLevels();

        JButton removeButton = new JButton("Effacer le personnage");
        removeButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        removeButton.setMargin(new Insets(2, 5, 2, 5));
        removeButton.addActionListener(new removeCharacterAL());
        removeButton.setBounds(initH + 620, initV + 450, 140, 30);
        this.add(removeButton);
    }

    public JLabel generateLabelSkills(){
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
    }
}
