package gui;

import core.World;
import core.entities.Character;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Money;
import core.equipment.Weapon;
import gui.listeners.characterListener.addToCharacterAL;
import gui.listeners.characterListener.createCharacterAL;
import gui.listeners.updateComboBoxesAL;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
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

    /* Character elements */
    JButton createCharacterButton;
    JTextArea nameArea;
    JComboBox<String> comboRace;
    JPanel careerPanel;
    JButton addCareerButton;

    /* Main profile elements */
    JTextArea wsArea;
    JTextArea bsArea;
    JTextArea sArea;
    JTextArea tArea;
    JTextArea agArea;
    JTextArea intArea;
    JTextArea wpArea;
    JTextArea felArea;

    /* Second profile elements */
    JTextArea aArea;
    JTextArea wArea;
    JTextArea sbArea;
    JTextArea tbArea;
    JTextArea mArea;
    JTextArea magArea;
    JTextArea ipArea;
    JTextArea fpArea;

    /* Personal profile elements */
    JTextArea ageArea;
    JComboBox<String> comboGender;
    JTextArea eyeColourArea;
    JTextArea hairColourArea;
    JTextArea sizeArea;
    JTextArea weightArea;
    JComboBox<String> comboAstralSign;
    JTextArea birthPlaceArea;
    JComboBox<String> comboGod;
    JTextArea marksArea;

    /* Skill, Talent, Armour, Weapon and Equipment */
    JPanel skillPanel;
    JPanel talentPanel;
    JPanel armourPanel;
    JPanel weaponPanel;
    JPanel equipmentPanel;

    /* Armour level */

    JLabel headArmourLabel;
    JLabel leftArmArmourLabel;
    JLabel rightArmArmourLabel;
    JLabel bodyArmourLabel;
    JLabel leftLegArmourLabel;
    JLabel rightLegArmourLabel;


    public CharacterPanel(Character character){
        super();

//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.character = character;

        this.setLayout(null);
        this.setMinimumSize(new Dimension(784, 500));
        this.setPreferredSize(new Dimension(784, 500));

        buildLayout();
        applyCharacter();
    }

    public CharacterPanel(){
        super();

        this.character = new Character();

//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setLayout(null);
        this.setMinimumSize(new Dimension(784, 500));
        this.setPreferredSize(new Dimension(784, 500));

        buildLayout();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image back = new ImageIcon("./resources/imgs/OneChar.png").getImage();
        g.drawImage(back, 0, 0, null);
    }

    private void buildLayout() {
        this.removeAll();
        this.setBackground(Color.WHITE);

        this.setLayout(null);
        this.setMinimumSize(new Dimension(784, 500));
        this.setPreferredSize(new Dimension(784, 500));

        nameArea = new JTextArea(1, 20);
        nameArea.setBounds(60,25,315,16);

        comboRace = new JComboBox<>();
        LinkedList<String> raceSorted = new LinkedList<>(World.RACES.keySet());
        Collections.sort(raceSorted);

        comboRace.addItem("");

        for(String r : raceSorted){
            comboRace.addItem(r);
        }

        comboRace.addActionListener(new updateComboBoxesAL(this));
        comboRace.setBounds(58,44,315,25);

        careerPanel = new JPanel();
        careerPanel.setBounds(80,70,268,25);
        addCareerButton = new JButton("+");
        addCareerButton.addActionListener(new addToCharacterAL("career", this));
        addCareerButton.setBounds(348, 70, 25, 25);

        createCharacterButton = new JButton("Générer personnage");
        createCharacterButton.addActionListener(new createCharacterAL(this));

        if(comboRace.getSelectedItem().equals("")){
            createCharacterButton.setEnabled(false);
        }

        createCharacterButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        createCharacterButton.setBounds(630, 455, 135, 25);

        wsArea = new JTextArea();
        wsArea.setBounds(30, 154, 30, 15);
        bsArea = new JTextArea();
        bsArea.setBounds(73, 154, 30, 15);
        sArea = new JTextArea();
        sArea.setBounds(116, 154, 30, 15);
        tArea = new JTextArea();
        tArea.setBounds(159, 154, 30, 15);
        agArea = new JTextArea();
        agArea.setBounds(202, 154, 30, 15);
        intArea = new JTextArea();
        intArea.setBounds(245, 154, 30, 15);
        wpArea = new JTextArea();
        wpArea.setBounds(288, 154, 30, 15);
        felArea = new JTextArea();
        felArea.setBounds(331, 154, 30, 15);

        aArea = new JTextArea();
        aArea.setBounds(30, 220, 30, 15);
        wArea = new JTextArea();
        wArea.setBounds(73, 220, 30, 15);
        sbArea = new JTextArea();
        sbArea.setBounds(116, 220, 30, 15);
        tbArea = new JTextArea();
        tbArea.setBounds(159, 220, 30, 15);
        mArea = new JTextArea();
        mArea.setBounds(202, 220, 30, 15);
        magArea = new JTextArea();
        magArea.setBounds(245, 220, 30, 15);
        ipArea = new JTextArea();
        ipArea.setBounds(288, 220, 30, 15);
        fpArea = new JTextArea();
        fpArea.setBounds(331, 220, 30, 15);

        ageArea = new JTextArea();
        ageArea.setBounds(55, 250, 165, 17);
        eyeColourArea = new JTextArea();
        eyeColourArea.setBounds(125, 275, 95, 17);
        hairColourArea = new JTextArea();
        hairColourArea.setBounds(140, 300, 80, 17);


        comboGender = new JComboBox<>();
        comboGender.addItem("");
        comboGender.addItem("Masculin");
        comboGender.addItem("Féminin");

        comboGender.setBounds(260, 250, 100, 17);

        sizeArea = new JTextArea();
        sizeArea.setBounds(260, 275, 100, 17);

        weightArea = new JTextArea();
        weightArea.setBounds(260, 300, 100, 17);


        comboAstralSign = new JComboBox<>();
        ComboboxToolTipRenderer comboAstralSignRenderer = new ComboboxToolTipRenderer();
        LinkedList<String> astralSignSorted = new LinkedList<>(World.ASTRALSIGNS.keySet());
        Collections.sort(astralSignSorted);
        comboAstralSign.setRenderer(comboAstralSignRenderer);

        LinkedList<String> tooltips = new LinkedList<>();
        comboAstralSign.addItem("");
        tooltips.add("");
        for(String as : astralSignSorted){
            comboAstralSign.addItem(as);
            tooltips.add(World.loadAstralSign(as).getDescription());
        }

        comboAstralSignRenderer.setTooltips(tooltips);
        comboAstralSign.setBounds(95, 323, 265, 17);

        birthPlaceArea = new JTextArea();
        birthPlaceArea.setBounds(145, 348, 215, 17);

        comboGod = new JComboBox<>();
        ComboboxToolTipRenderer comboGodRenderer = new ComboboxToolTipRenderer();
        LinkedList<String> godSorted = new LinkedList<>(World.GODS.keySet());
        Collections.sort(godSorted);
        comboGod.setRenderer(comboGodRenderer);

        tooltips = new LinkedList<>();
        String domain;
        LinkedList<String> domains;
        comboGod.addItem("");
        tooltips.add("");
        for(String god : godSorted){
            domain = "";
            comboGod.addItem(god);
            domains = World.loadGod(god).getDomains();
            for(String aDomain : domains){
                domain += aDomain + ", ";
            }
            tooltips.add(domain.substring(0, domain.length()-2));
        }
        comboGodRenderer.setTooltips(tooltips);
        comboGod.setBounds(85, 373, 275, 17);


        marksArea = new JTextArea();
        marksArea.setBounds(30, 420, 330, 60);
        marksArea.setLineWrap(true);
        marksArea.setWrapStyleWord(true);

        JScrollPane scrollPane;

        skillPanel = new JPanel();
        skillPanel.setLayout(new BoxLayout(skillPanel, BoxLayout.PAGE_AXIS));

        scrollPane = new JScrollPane(skillPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(350, 95));
        JPanel mainPanelSkill = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanelSkill.add(scrollPane);
        mainPanelSkill.setPreferredSize(new Dimension(355, 100));
        mainPanelSkill.setBounds(410, 45, 355, 100);

        JButton addSkillButton = new JButton("Ajouter une compétence");
        addSkillButton.setBounds(575,25,190,20);
        addSkillButton.addActionListener(new addToCharacterAL("skill", this));

        this.add(addSkillButton);

        talentPanel = new JPanel();
        talentPanel.setLayout(new BoxLayout(talentPanel, BoxLayout.PAGE_AXIS));

        scrollPane = new JScrollPane(talentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(350, 60));
        JPanel mainPanelTalent = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanelTalent.add(scrollPane);
        mainPanelTalent.setPreferredSize(new Dimension(355, 65));
        mainPanelTalent.setBounds(410, 170, 355, 65);

        JButton addTalentButton = new JButton("Ajouter un talent");
        addTalentButton.setBounds(575,150,190,20);
        addTalentButton.addActionListener(new addToCharacterAL("talent", this));

        this.add(addTalentButton);

        armourPanel = new JPanel();
        armourPanel.setLayout(new BoxLayout(armourPanel, BoxLayout.PAGE_AXIS));

        scrollPane = new JScrollPane(armourPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(210, 50));
        JPanel mainPanelArmour = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanelArmour.add(scrollPane);
        mainPanelArmour.setPreferredSize(new Dimension(215, 55));
        mainPanelArmour.setBounds(410, 255, 215, 55);

        JButton addArmourButton = new JButton("Ajouter une armure");
        addArmourButton.setBounds(470,235,155,20);
        addArmourButton.addActionListener(new addToCharacterAL("armour", this));

        this.add(addArmourButton);

        weaponPanel = new JPanel();
        weaponPanel.setLayout(new BoxLayout(weaponPanel, BoxLayout.PAGE_AXIS));

        scrollPane = new JScrollPane(weaponPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(210, 50));
        JPanel mainPanelWeapon = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanelWeapon.add(scrollPane);
        mainPanelWeapon.setPreferredSize(new Dimension(215, 55));
        mainPanelWeapon.setBounds(410, 330, 215, 55);

        JButton addWeaponButton = new JButton("Ajouter une arme");
        addWeaponButton.setBounds(470,310,155,20);
        addWeaponButton.addActionListener(new addToCharacterAL("weapon", this));

        this.add(addWeaponButton);

        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.PAGE_AXIS));

        scrollPane = new JScrollPane(equipmentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(210,70));
        JPanel mainPanelEquipment = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanelEquipment.add(scrollPane);
        mainPanelEquipment.setPreferredSize(new Dimension(215, 75));
        mainPanelEquipment.setBounds(410, 405, 215, 75);

        JButton addEquipmentButton = new JButton("Ajouter un équipement");
        addEquipmentButton.setBounds(470,385,155,20);
        addEquipmentButton.addActionListener(new addToCharacterAL("equipment", this));

        this.add(addEquipmentButton);

        this.add(mainPanelSkill);
        this.add(mainPanelTalent);
        this.add(mainPanelArmour);
        this.add(mainPanelWeapon);
        this.add(mainPanelEquipment);

        headArmourLabel = new JLabel();
        headArmourLabel.setBounds(637, 259, 25, 10);
        this.add(headArmourLabel);

        rightArmArmourLabel = new JLabel();
        rightArmArmourLabel.setBounds(637, 357, 25, 10);
        this.add(rightArmArmourLabel);
        leftArmArmourLabel = new JLabel();
        leftArmArmourLabel.setBounds(732, 358, 25, 10);
        this.add(leftArmArmourLabel);

        bodyArmourLabel = new JLabel();
        bodyArmourLabel.setBounds(732, 289, 25, 10);
        this.add(bodyArmourLabel);

        rightLegArmourLabel = new JLabel();
        rightLegArmourLabel.setBounds(637, 423, 25, 10);
        this.add(rightLegArmourLabel);
        leftLegArmourLabel = new JLabel();
        leftLegArmourLabel.setBounds(732, 424, 25, 10);
        this.add(leftLegArmourLabel);

        this.add(nameArea);
        this.add(comboRace);
        this.add(careerPanel);
        this.add(addCareerButton);

        this.add(createCharacterButton);

        this.add(wsArea);
        this.add(bsArea);
        this.add(sArea);
        this.add(tArea);
        this.add(agArea);
        this.add(intArea);
        this.add(wpArea);
        this.add(felArea);

        this.add(aArea);
        this.add(wArea);
        this.add(sbArea);
        this.add(tbArea);
        this.add(mArea);
        this.add(magArea);
        this.add(ipArea);
        this.add(fpArea);

        this.add(ageArea);
        this.add(eyeColourArea);
        this.add(hairColourArea);

        this.add(comboGender);
        this.add(sizeArea);
        this.add(weightArea);

        this.add(comboAstralSign);
        this.add(birthPlaceArea);
        this.add(comboGod);
        this.add(marksArea);

    }

    public void applyCharacter(){
        for (String careerName : this.getCharacter().getCareers()) {
            JLabel careerLabel = new JLabel();

            careerLabel.setText(careerName);
            careerLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

            careerPanel.add(careerLabel);
        }

        //comboRace.setSelectedItem(character.getRace());

        nameArea.setText(character.getName());

        wsArea.setText(character.getProfile().getWs() + "");
        bsArea.setText(character.getProfile().getBs() + "");
        sArea.setText(character.getProfile().getS() + "");
        tArea.setText(character.getProfile().getT() + "");
        agArea.setText(character.getProfile().getAg() + "");
        intArea.setText(character.getProfile().getIntel() + "");
        wpArea.setText(character.getProfile().getWp() + "");
        felArea.setText(character.getProfile().getFel() + "");

        aArea.setText(character.getProfile().getA() + "");
        wArea.setText(character.getProfile().getW() + "");
        sbArea.setText(character.getProfile().getSb() + "");
        tbArea.setText(character.getProfile().getTb() + "");
        mArea.setText(character.getProfile().getM() + "");
        magArea.setText(character.getProfile().getMag() + "");
        ipArea.setText(character.getProfile().getIp() + "");
        fpArea.setText(character.getProfile().getFp() + "");

        ageArea.setText(character.getDetails().getAge() + "");
        eyeColourArea.setText(character.getDetails().getEyeColour() + "");
        hairColourArea.setText(character.getDetails().getHairColour() + "");

        if (character.getDetails().isMale()) {
            comboGender.setSelectedItem("Masculin");
        } else {
            comboGender.setSelectedItem("Féminin");
        }

        if (((character.getDetails().getHeight() % 100) + "").length() == 1) {
            sizeArea.setText(character.getDetails().getHeight() / 100 + "m0" +
                    character.getDetails().getHeight() % 100);
        } else {
            sizeArea.setText(character.getDetails().getHeight() / 100 + "m" +
                    character.getDetails().getHeight() % 100);
        }

        weightArea.setText(character.getDetails().getWeight() + "kg");

        comboAstralSign.setSelectedItem(character.getDetails().getAstralSign());

        birthPlaceArea.setText(character.getDetails().getBirthplace() + "");
        birthPlaceArea.setBounds(145, 348, 215, 17);

        comboGod.setSelectedItem(character.getDetails().getFavoriteGod());

        String allMarks = "";
        for (String mark : character.getDetails().getDistinguishingMarks()) {
            allMarks += mark + ", ";
        }
        if (allMarks.length() >= 2) {
            allMarks = allMarks.substring(0, allMarks.length() - 2);
        }
        marksArea.setText(allMarks);
        marksArea.setLineWrap(true);
        marksArea.setWrapStyleWord(true);

        generatePanelSkills();
        generatePanelTalents();
        generatePanelArmours();
        generatePanelWeapons();
        generatePanelEquipments();

        this.generateArmourLevels();

        this.repaint();
        this.revalidate();
    }

    public void generatePanelSkills(){
        JLabel skillLabel;
        String skillNameLevel;
        int level;
        LinkedList<String> skills = (LinkedList<String>)character.getSkills().clone();
        Collections.sort(skills);
        String skillName;
        while(!skills.isEmpty()){
            skillLabel = new JLabel();
            skillName = skills.pop();
            level = 0;
            while(skills.removeFirstOccurrence(skillName)){
                level ++;
            }

            level *= 10;

            skillNameLevel = skillName;

            if(level != 0){
                skillNameLevel += "(+" + level + ")";
            }

            skillNameLevel += " : " + World.loadSkill(skillName).getCharacteristics();
            skillLabel.setText(skillNameLevel);
            skillLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            skillPanel.add(skillLabel);
        }
    }

    public void generatePanelTalents(){
        JLabel talentLabel;
        LinkedList<String> talents = (LinkedList<String>)character.getTalents().clone();
        Collections.sort(talents);
        String talentName;
        while(!talents.isEmpty()){
            talentLabel = new JLabel();
            talentName = talents.pop();
            while(talents.removeFirstOccurrence(talentName));

            talentLabel.setText(talentName);
            talentLabel.setToolTipText(World.loadTalent(talentName).getDescription());
            talentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            talentPanel.add(talentLabel);
        }
    }

    public void generatePanelArmours(){
        JLabel armourLabel;
        LinkedList<String> armours = (LinkedList<String>)character.getArmours().clone();
        Collections.sort(armours);
        String armourName, tooltip;
        Armour armour;
        LinkedList<String> coveredParts;
        while(!armours.isEmpty()){
            armourLabel = new JLabel();
            armourName = armours.pop();
            while(armours.removeFirstOccurrence(armourName));

            armourLabel.setText(armourName);
            tooltip = "";
            armour = World.loadArmour(armourName);
            coveredParts = armour.getCoveredZones();

            for(String part : coveredParts){
                tooltip += part + ", ";
            }

            tooltip = tooltip.substring(0, tooltip.length() - 2);

            tooltip += " : " + armour.getArmourLevel() + " PA";

            armourLabel.setToolTipText(tooltip);
            armourLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            armourPanel.add(armourLabel);
        }
    }

    public void generatePanelWeapons(){
        JLabel weaponLabel;
        LinkedList<String> weapons = (LinkedList<String>)character.getWeapons().clone();
        Collections.sort(weapons);
        String weaponName, tooltip;
        Weapon weapon;
        int reload;
        LinkedList<String> attributes;
        while(!weapons.isEmpty()){
            weaponLabel = new JLabel();
            weaponName = weapons.pop();
            while(weapons.removeFirstOccurrence(weaponName));

            weaponLabel.setText(weaponName);
            weapon = World.loadWeapon(weaponName);

            tooltip = weapon.getGroup() + " | Dégâts " + weapon.getDamage();

            if(weapon.getLowRange() != 0){
                tooltip += " | Portée : " + weapon.getLowRange() + " - " + weapon.getHighRange();
                tooltip += " | Rechargement : ";
                reload = weapon.getReload();
                if(reload / 2 != 0){
                    tooltip += (reload/2);
                    if(reload%2 != 0){
                        tooltip += " + " + (reload%2) + "/2";
                    }
                } else if(reload%2 != 0){
                    tooltip += (reload%2) + "/2";
                }

                tooltip += "A";
            }

            attributes = weapon.getAttributes();
            if(attributes.size() != 0) {
                tooltip += " | Attributs : ";
                for (String attribute : attributes) {
                    tooltip += attribute + ", ";
                }

                tooltip = tooltip.substring(0, tooltip.length() - 2);
            }

            weaponLabel.setToolTipText(tooltip);
            weaponLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            weaponPanel.add(weaponLabel);
        }
    }

    public void generatePanelEquipments(){
        JLabel equipmentLabel;
        LinkedList<String> equipments = (LinkedList<String>)character.getEquipment().clone();
        Collections.sort(equipments);
        String equipmentName, tooltip;
        Equipment equipment;
        while(!equipments.isEmpty()){
            equipmentLabel = new JLabel();
            equipmentName = equipments.pop();
            while(equipments.removeFirstOccurrence(equipmentName));

            equipmentLabel.setText(equipmentName);
            equipment = World.loadEquipment(equipmentName);

            tooltip = "Enc : " + equipment.getEnc();

            equipmentLabel.setToolTipText(tooltip);
            equipmentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            equipmentPanel.add(equipmentLabel);
        }

        /* Money */

        equipmentLabel = new JLabel();
        Money m = character.getMoney();
        equipmentLabel.setText("Money : " + m.getGoldenCrowns() + " Co, " + m.getSilverShillings() + " Pa, " + m.getBrassPennies() + " Sc");

        equipmentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        equipmentPanel.add(equipmentLabel);
    }

    public void generateArmourLevels(){
        int headLevel = 0, armLevel = 0, bodyLevel = 0, legLevel = 0;

        Armour armour;
        LinkedList<Component> listArmour = new LinkedList<>(Arrays.asList(this.getArmourPanel().getComponents()));
        JLabel tempArmourLabel;
        String armourName;

        for(Component cmp : listArmour){
            if(cmp.getClass() == JLabel.class) {
                tempArmourLabel = (JLabel) cmp;
                armourName = tempArmourLabel.getText();

                armour = World.loadArmour(armourName);
                if (armour.getCoveredZones().contains("Tête")) {
                    headLevel += armour.getArmourLevel();
                }
                if (armour.getCoveredZones().contains("Bras")) {
                    armLevel += armour.getArmourLevel();
                }
                if (armour.getCoveredZones().contains("Corps")) {
                    bodyLevel += armour.getArmourLevel();
                }
                if (armour.getCoveredZones().contains("Jambes")) {
                    legLevel += armour.getArmourLevel();
                }
            }
        }

        headArmourLabel.setText(headLevel + "");
        leftArmArmourLabel.setText(armLevel + "");
        rightArmArmourLabel.setText(armLevel + "");
        bodyArmourLabel.setText(bodyLevel + "");
        leftLegArmourLabel.setText(legLevel + "");
        rightLegArmourLabel.setText(legLevel + "");

        headArmourLabel.setBounds(637, 259, 25, 10);
        this.add(headArmourLabel);

        rightArmArmourLabel.setBounds(637, 357, 25, 10);
        this.add(rightArmArmourLabel);
        leftArmArmourLabel.setBounds(732, 358, 25, 10);
        this.add(leftArmArmourLabel);

        bodyArmourLabel.setBounds(732, 289, 25, 10);
        this.add(bodyArmourLabel);

        rightLegArmourLabel.setBounds(637, 423, 25, 10);
        this.add(rightLegArmourLabel);
        leftLegArmourLabel.setBounds(732, 424, 25, 10);
        this.add(leftLegArmourLabel);
    }

    public void emptyElements() {
        this.nameArea.setText("");
        this.careerPanel.removeAll();

        this.wsArea.setText("");
        this.bsArea.setText("");
        this.sArea.setText("");
        this.tArea.setText("");
        this.agArea.setText("");
        this.intArea.setText("");
        this.wpArea.setText("");
        this.felArea.setText("");


        this.aArea.setText("");
        this.wArea.setText("");
        this.sbArea.setText("");
        this.tbArea.setText("");
        this.mArea.setText("");
        this.magArea.setText("");
        this.ipArea.setText("");
        this.fpArea.setText("");


        this.ageArea.setText("");
        this.comboGender.setSelectedItem("");
        this.eyeColourArea.setText("");
        this.hairColourArea.setText("");
        this.sizeArea.setText("");
        this.weightArea.setText("");
        this.comboAstralSign.setSelectedItem("");
        this.birthPlaceArea.setText("");
        this.comboGod.setSelectedItem("");
        this.marksArea.setText("");


        this.skillPanel.removeAll();
        this.talentPanel.removeAll();
        this.armourPanel.removeAll();
        this.weaponPanel.removeAll();
        this.equipmentPanel.removeAll();

        this.headArmourLabel.setText("");
        this.leftArmArmourLabel.setText("");
        this.rightArmArmourLabel.setText("");
        this.bodyArmourLabel.setText("");
        this.leftLegArmourLabel.setText("");
        this.rightLegArmourLabel.setText("");

        this.revalidate();
        this.repaint();
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

    public JButton getCreateCharacterButton() {
        return createCharacterButton;
    }

    public void setCreateCharacterButton(JButton createCharacterButton) {
        this.createCharacterButton = createCharacterButton;
    }

    public JTextArea getNameArea() {
        return nameArea;
    }

    public void setNameArea(JTextArea nameArea) {
        this.nameArea = nameArea;
    }

    public JComboBox<String> getComboRace() {
        return comboRace;
    }

    public void setComboRace(JComboBox<String> comboRace) {
        this.comboRace = comboRace;
    }

    public JPanel getCareerPanel() {
        return careerPanel;
    }

    public void setCareerPanel(JPanel careerPanel) {
        this.careerPanel = careerPanel;
    }

    public JTextArea getWsArea() {
        return wsArea;
    }

    public void setWsArea(JTextArea wsArea) {
        this.wsArea = wsArea;
    }

    public JTextArea getBsArea() {
        return bsArea;
    }

    public void setBsArea(JTextArea bsArea) {
        this.bsArea = bsArea;
    }

    public JTextArea getsArea() {
        return sArea;
    }

    public void setsArea(JTextArea sArea) {
        this.sArea = sArea;
    }

    public JTextArea gettArea() {
        return tArea;
    }

    public void settArea(JTextArea tArea) {
        this.tArea = tArea;
    }

    public JTextArea getAgArea() {
        return agArea;
    }

    public void setAgArea(JTextArea agArea) {
        this.agArea = agArea;
    }

    public JTextArea getIntArea() {
        return intArea;
    }

    public void setIntArea(JTextArea intArea) {
        this.intArea = intArea;
    }

    public JTextArea getWpArea() {
        return wpArea;
    }

    public void setWpArea(JTextArea wpArea) {
        this.wpArea = wpArea;
    }

    public JTextArea getFelArea() {
        return felArea;
    }

    public void setFelArea(JTextArea felArea) {
        this.felArea = felArea;
    }

    public JTextArea getaArea() {
        return aArea;
    }

    public void setaArea(JTextArea aArea) {
        this.aArea = aArea;
    }

    public JTextArea getwArea() {
        return wArea;
    }

    public void setwArea(JTextArea wArea) {
        this.wArea = wArea;
    }

    public JTextArea getSbArea() {
        return sbArea;
    }

    public void setSbArea(JTextArea sbArea) {
        this.sbArea = sbArea;
    }

    public JTextArea getTbArea() {
        return tbArea;
    }

    public void setTbArea(JTextArea tbArea) {
        this.tbArea = tbArea;
    }

    public JTextArea getmArea() {
        return mArea;
    }

    public void setmArea(JTextArea mArea) {
        this.mArea = mArea;
    }

    public JTextArea getMagArea() {
        return magArea;
    }

    public void setMagArea(JTextArea magArea) {
        this.magArea = magArea;
    }

    public JTextArea getIpArea() {
        return ipArea;
    }

    public void setIpArea(JTextArea ipArea) {
        this.ipArea = ipArea;
    }

    public JTextArea getFpArea() {
        return fpArea;
    }

    public void setFpArea(JTextArea fpArea) {
        this.fpArea = fpArea;
    }

    public JTextArea getAgeArea() {
        return ageArea;
    }

    public void setAgeArea(JTextArea ageArea) {
        this.ageArea = ageArea;
    }

    public JComboBox<String> getComboGender() {
        return comboGender;
    }

    public void setComboGender(JComboBox<String> comboGender) {
        this.comboGender = comboGender;
    }

    public JTextArea getEyeColourArea() {
        return eyeColourArea;
    }

    public void setEyeColourArea(JTextArea eyeColourArea) {
        this.eyeColourArea = eyeColourArea;
    }

    public JTextArea getHairColourArea() {
        return hairColourArea;
    }

    public void setHairColourArea(JTextArea hairColourArea) {
        this.hairColourArea = hairColourArea;
    }

    public JTextArea getSizeArea() {
        return sizeArea;
    }

    public void setSizeArea(JTextArea sizeArea) {
        this.sizeArea = sizeArea;
    }

    public JTextArea getWeightArea() {
        return weightArea;
    }

    public void setWeightArea(JTextArea weightArea) {
        this.weightArea = weightArea;
    }

    public JComboBox<String> getComboAstralSign() {
        return comboAstralSign;
    }

    public void setComboAstralSign(JComboBox<String> comboAstralSign) {
        this.comboAstralSign = comboAstralSign;
    }

    public JTextArea getBirthPlaceArea() {
        return birthPlaceArea;
    }

    public void setBirthPlaceArea(JTextArea birthPlaceArea) {
        this.birthPlaceArea = birthPlaceArea;
    }

    public JComboBox<String> getComboGod() {
        return comboGod;
    }

    public void setComboGod(JComboBox<String> comboGod) {
        this.comboGod = comboGod;
    }

    public JTextArea getMarksArea() {
        return marksArea;
    }

    public void setMarksArea(JTextArea marksArea) {
        this.marksArea = marksArea;
    }

    public JPanel getSkillPanel() {
        return skillPanel;
    }

    public void setSkillPanel(JPanel skillPanel) {
        this.skillPanel = skillPanel;
    }

    public JPanel getTalentPanel() {
        return talentPanel;
    }

    public void setTalentPanel(JPanel talentPanel) {
        this.talentPanel = talentPanel;
    }

    public JPanel getArmourPanel() {
        return armourPanel;
    }

    public void setArmourPanel(JPanel armourPanel) {
        this.armourPanel = armourPanel;
    }

    public JPanel getWeaponPanel() {
        return weaponPanel;
    }

    public void setWeaponPanel(JPanel weaponPanel) {
        this.weaponPanel = weaponPanel;
    }

    public JPanel getEquipmentPanel() {
        return equipmentPanel;
    }

    public void setEquipmentPanel(JPanel equipmentPanel) {
        this.equipmentPanel = equipmentPanel;
    }
}

