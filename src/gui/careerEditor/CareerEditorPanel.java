package gui.careerEditor;

import core.World;
import core.characteristics.Career;
import core.characteristics.Profile;
import core.xmlHelper.xmlSaver;
import gui.careerEditor.listeners.AddGroupToCareer;
import gui.careerEditor.listeners.AddToCareer;
import gui.careerEditor.listeners.LoadCareerListener;
import gui.careerEditor.listeners.RemoveFromCareerListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CareerEditorPanel extends JPanel {
    private Career career;

    private JButton openExistingCareerButton;
    private JButton clearCareerButton;
    private JButton saveCareerButton;

    private JTextField nameField = new JTextField();
    private JCheckBox baseCareer = new JCheckBox();

    private JPanel availableRacePanel = new JPanel();
    private JButton addRaceButton;


    private JTextField ccField = new JTextField();
    private JTextField ctField = new JTextField();
    private JTextField fField = new JTextField();
    private JTextField eField = new JTextField();
    private JTextField agField = new JTextField();
    private JTextField intField = new JTextField();
    private JTextField fmField = new JTextField();
    private JTextField socField = new JTextField();

    private JTextField aField = new JTextField();
    private JTextField bField = new JTextField();
    private JTextField mField = new JTextField();
    private JTextField magField = new JTextField();

    private JPanel skillPanel = new JPanel();
    private JButton addSkillGroupButton;

    private JPanel talentPanel = new JPanel();
    private JButton addTalentGroupButton;

    private JPanel weaponPanel = new JPanel();
    private JButton addWeaponGroupButton;

    private JPanel armourPanel = new JPanel();
    private JButton addArmourGroupButton;

    private JPanel equipmentPanel = new JPanel();
    private JButton addEquipmentGroupButton;

    private JPanel accessPanel = new JPanel();
    private JButton addAccessButton;

    private JPanel openingPanel = new JPanel();
    private JButton addOpeningButton;

    private void addComponent(Component comp, GridBagLayout gridBagLayout, GridBagConstraints c, JPanel panel){
        gridBagLayout.setConstraints(comp, c);
        panel.add(comp);
    }


    public CareerEditorPanel(){
        super();
        this.career = new Career();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.setMinimumSize(new Dimension(784, 500));
        this.setPreferredSize(new Dimension(784, 500));


        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.LINE_AXIS));

        rowPanel.add(new JLabel("Nom de la carrière"));
        rowPanel.add(nameField);

        rowPanel.add(new JLabel("Carrière de base"));
        baseCareer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(baseCareer.isSelected()) {
                    getCareer().setType(Career.CareerType.BASE);
                } else {
                    getCareer().setType(Career.CareerType.AVANCE);
                }
            }
        });
        rowPanel.add(baseCareer);

        this.add(rowPanel);

        JPanel profilePanel = new JPanel(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(new JLabel("Profil principal"), gridbag, c, profilePanel);

        c.gridwidth = 1;                //reset to the default
        this.addComponent(new JLabel("CC"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("CT"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("F"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("E"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("Ag"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("Int"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("FM"), gridbag, c, profilePanel);
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(new JLabel("Soc"), gridbag, c, profilePanel);

        c.gridwidth = 1;                //reset to the default
        this.addComponent(ccField, gridbag, c, profilePanel);
        this.addComponent(ctField, gridbag, c, profilePanel);
        this.addComponent(fField, gridbag, c, profilePanel);
        this.addComponent(eField, gridbag, c, profilePanel);
        this.addComponent(agField, gridbag, c, profilePanel);
        this.addComponent(intField, gridbag, c, profilePanel);
        this.addComponent(fmField, gridbag, c, profilePanel);
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(socField, gridbag, c, profilePanel);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(new JLabel("Profil secondaire"), gridbag, c, profilePanel);

        c.gridwidth = 1;                //reset to the default
        this.addComponent(new JLabel("A"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("B"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("BF"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("BE"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("M"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("Mag"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("PF"), gridbag, c, profilePanel);
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(new JLabel("PD"), gridbag, c, profilePanel);

        c.gridwidth = 1;                //reset to the default
        this.addComponent(aField, gridbag, c, profilePanel);
        this.addComponent(bField, gridbag, c, profilePanel);
        this.addComponent(new JLabel("---"), gridbag, c, profilePanel);
        this.addComponent(new JLabel("---"), gridbag, c, profilePanel);
        this.addComponent(mField, gridbag, c, profilePanel);
        this.addComponent(magField, gridbag, c, profilePanel);
        this.addComponent(new JLabel("---"), gridbag, c, profilePanel);
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        this.addComponent(new JLabel( "---"), gridbag, c, profilePanel);

        this.add(profilePanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,4));

        rowPanel.add(new JLabel("Compétences"));
        addSkillGroupButton = new JButton("Ajouter un choix de compétences");
        addSkillGroupButton.addActionListener(new AddGroupToCareer("skill", this));
        rowPanel.add(addSkillGroupButton);

        rowPanel.add(new JLabel("Talents"));
        addTalentGroupButton = new JButton("Ajouter un choix de talents");
        addTalentGroupButton.addActionListener(new AddGroupToCareer("talent", this));
        rowPanel.add(addTalentGroupButton);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,2));

        JScrollPane scrollPane;
        skillPanel.setLayout(new BoxLayout(skillPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(skillPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        talentPanel.setLayout(new BoxLayout(talentPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(talentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,4));

        rowPanel.add(new JLabel("Armes"));
        addWeaponGroupButton = new JButton("Ajouter un choix d'armes");
        addWeaponGroupButton.addActionListener(new AddGroupToCareer("weapon", this));
        rowPanel.add(addWeaponGroupButton);

        rowPanel.add(new JLabel("Armures"));
        addArmourGroupButton = new JButton("Ajouter un choix d'armures");
        addArmourGroupButton.addActionListener(new AddGroupToCareer("armour", this));
        rowPanel.add(addArmourGroupButton);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,2));

        weaponPanel.setLayout(new BoxLayout(weaponPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(weaponPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        armourPanel.setLayout(new BoxLayout(armourPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(armourPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.LINE_AXIS));

        rowPanel.add(new JLabel("Equipement"));
        addEquipmentGroupButton = new JButton("Ajouter un choix d'equipement");
        addEquipmentGroupButton.addActionListener(new AddGroupToCareer("equipment", this));
        rowPanel.add(addEquipmentGroupButton);
        this.add(rowPanel);

        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(equipmentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        this.add(scrollPane);


        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,4));

        rowPanel.add(new JLabel("Acces"));
        addAccessButton = new JButton("Ajouter un acces");
        addAccessButton.addActionListener(new AddToCareer("access", this));
        rowPanel.add(addAccessButton);

        rowPanel.add(new JLabel("Débouchés"));
        addOpeningButton = new JButton("Ajouter un débouché");
        addOpeningButton.addActionListener(new AddToCareer("opening", this));
        rowPanel.add(addOpeningButton);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(1,2));

        accessPanel.setLayout(new BoxLayout(accessPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(accessPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        openingPanel.setLayout(new BoxLayout(openingPanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(openingPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        rowPanel.add(scrollPane);

        this.add(rowPanel);

        rowPanel = new JPanel();
        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.LINE_AXIS));

        rowPanel.add(new JLabel("Races autorisées"));
        addRaceButton = new JButton("Ajouter une race");
        addRaceButton.addActionListener(new AddToCareer("race", this));
        rowPanel.add(addRaceButton);
        this.add(rowPanel);

        availableRacePanel.setLayout(new BoxLayout(availableRacePanel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(availableRacePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(270, 75));
        this.add(scrollPane);

        rowPanel = new JPanel();
        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.LINE_AXIS));

        openExistingCareerButton = new JButton("Ouvrir une carrière");
        openExistingCareerButton.addActionListener(new LoadCareerListener(this));
        rowPanel.add(openExistingCareerButton);
        clearCareerButton = new JButton("Nouvelle carriere");
        clearCareerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCareer(new Career());
                emptyElements();
                applyCareer();
            }
        });
        rowPanel.add(clearCareerButton);
        saveCareerButton = new JButton("Sauvegarder");
        saveCareerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!nameField.getText().equals("")) {
                    applyProfile();

                    World.CAREERS.put(getCareer().getName(), getCareer());
                    xmlSaver.saveCareers();
                }
            }
        });
        rowPanel.add(saveCareerButton);
        this.add(rowPanel);

        this.applyCareer();
    }

    public void applyCareer(){
        this.getNameField().setText(this.getCareer().getName());
        this.getBaseCareer().setSelected(this.getCareer().getType().equals(Career.CareerType.BASE));

        this.getCcField().setText(String.valueOf(this.getCareer().getProfile().getWs()));
        this.getCtField().setText(String.valueOf(this.getCareer().getProfile().getBs()));
        this.getfField().setText(String.valueOf(this.getCareer().getProfile().getS()));
        this.geteField().setText(String.valueOf(this.getCareer().getProfile().getT()));
        this.getAgField().setText(String.valueOf(this.getCareer().getProfile().getAg()));
        this.getIntField().setText(String.valueOf(this.getCareer().getProfile().getIntel()));
        this.getFmField().setText(String.valueOf(this.getCareer().getProfile().getWp()));
        this.getSocField().setText(String.valueOf(this.getCareer().getProfile().getFel()));

        this.getaField().setText(String.valueOf(this.getCareer().getProfile().getA()));
        this.getbField().setText(String.valueOf(this.getCareer().getProfile().getW()));
        this.getmField().setText(String.valueOf(this.getCareer().getProfile().getM()));
        this.getMagField().setText(String.valueOf(this.getCareer().getProfile().getMag()));

        JLabel aLabel;

        for(LinkedList<String> aGroup : this.getCareer().getSkills()){
            aLabel = new JLabel(String.join(" ou ", aGroup));
            aLabel.setToolTipText(String.join(" ou ", aGroup));
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("skill", aGroup, this));
            this.getSkillPanel().add(aLabel);
        }

        for(LinkedList<String> aGroup : this.getCareer().getTalents()){
            aLabel = new JLabel(String.join(" ou ", aGroup));
            aLabel.setToolTipText(String.join(" ou ", aGroup));
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("talent", aGroup, this));
            this.getTalentPanel().add(aLabel);
        }

        for(LinkedList<String> aGroup : this.getCareer().getWeapons()){
            aLabel = new JLabel(String.join(" ou ", aGroup));
            aLabel.setToolTipText(String.join(" ou ", aGroup));
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("weapon", aGroup, this));
            this.getWeaponPanel().add(aLabel);
        }

        for(LinkedList<String> aGroup : this.getCareer().getArmours()){
            aLabel = new JLabel(String.join(" ou ", aGroup));
            aLabel.setToolTipText(String.join(" ou ", aGroup));
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("armour", aGroup, this));
            this.getArmourPanel().add(aLabel);
        }

        for(LinkedList<String> aGroup : this.getCareer().getEquipments()){
            aLabel = new JLabel(String.join(" ou ", aGroup));
            aLabel.setToolTipText(String.join(" ou ", aGroup));
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("equipment", aGroup, this));
            this.getEquipmentPanel().add(aLabel);
        }

        for(String anAccess : this.getCareer().getAccessCareers()){
            aLabel = new JLabel(anAccess);
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("access", anAccess, this));
            this.getAccessPanel().add(aLabel);
        }

        for(String anOpening : this.getCareer().getOpeningCareers()){
            aLabel = new JLabel(anOpening);
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("opening", anOpening, this));
            this.getOpeningPanel().add(aLabel);
        }

        for(String aRace : this.getCareer().getAvailableRaces()){
            aLabel = new JLabel(aRace);
            aLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            aLabel.addMouseListener(new RemoveFromCareerListener("race", aRace, this));
            this.getAvailableRacePanel().add(aLabel);
        }

        this.revalidate();
        this.repaint();
    }

    public void applyProfile(){
        getCareer().setName(nameField.getText());

        Profile profile = getCareer().getProfile();

        try {
            profile.setWs(Integer.parseInt(getCcField().getText()));
        } catch (Exception e) {
            profile.setWs(0);
        }

        try {
            profile.setBs(Integer.parseInt(getCtField().getText()));
        } catch (Exception e) {
            profile.setBs(0);
        }

        try {
            profile.setS(Integer.parseInt(getfField().getText()));
        } catch (Exception e) {
            profile.setS(0);
        }

        try {
            profile.setT(Integer.parseInt(geteField().getText()));
        } catch (Exception e) {
            profile.setT(0);
        }

        try {
            profile.setAg(Integer.parseInt(getAgField().getText()));
        } catch (Exception e) {
            profile.setAg(0);
        }

        try {
            profile.setIntel(Integer.parseInt(getIntField().getText()));
        } catch (Exception e) {
            profile.setIntel(0);
        }

        try {
            profile.setWp(Integer.parseInt(getFmField().getText()));
        } catch (Exception e) {
            profile.setWp(0);
        }

        try {
            profile.setFel(Integer.parseInt(getSocField().getText()));
        } catch (Exception e) {
            profile.setFel(0);
        }

        try {
            profile.setA(Integer.parseInt(getaField().getText()));
        } catch (Exception e) {
            profile.setA(0);
        }

        try {
            profile.setW(Integer.parseInt(getbField().getText()));
        } catch (Exception e) {
            profile.setW(0);
        }

        try {
            profile.setM(Integer.parseInt(getmField().getText()));
        } catch (Exception e) {
            profile.setM(0);
        }

        try {
            profile.setMag(Integer.parseInt(getMagField().getText()));
        } catch (Exception e) {
            profile.setMag(0);
        }
    }

    public void emptyElements() {
        this.getNameField().setText("");
        this.getBaseCareer().setSelected(false);

        this.getCcField().setText("0");
        this.getCtField().setText("0");
        this.getfField().setText("0");
        this.geteField().setText("0");
        this.getAgField().setText("0");
        this.getIntField().setText("0");
        this.getFmField().setText("0");
        this.getSocField().setText("0");

        this.getaField().setText("0");
        this.getbField().setText("0");
        this.getmField().setText("0");
        this.getMagField().setText("0");


        this.getSkillPanel().removeAll();
        this.getTalentPanel().removeAll();
        this.getWeaponPanel().removeAll();
        this.getArmourPanel().removeAll();
        this.getEquipmentPanel().removeAll();
        this.getAccessPanel().removeAll();
        this.getOpeningPanel().removeAll();
        this.getAvailableRacePanel().removeAll();
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public JButton getOpenExistingCareerButton() {
        return openExistingCareerButton;
    }

    public void setOpenExistingCareerButton(JButton openExistingCareerButton) {
        this.openExistingCareerButton = openExistingCareerButton;
    }

    public JButton getClearCareerButton() {
        return clearCareerButton;
    }

    public void setClearCareerButton(JButton clearCareerButton) {
        this.clearCareerButton = clearCareerButton;
    }

    public JButton getSaveCareerButton() {
        return saveCareerButton;
    }

    public void setSaveCareerButton(JButton saveCareerButton) {
        this.saveCareerButton = saveCareerButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JCheckBox getBaseCareer() {
        return baseCareer;
    }

    public void setBaseCareer(JCheckBox baseCareer) {
        this.baseCareer = baseCareer;
    }

    public JPanel getAvailableRacePanel() {
        return availableRacePanel;
    }

    public void setAvailableRacePanel(JPanel availableRacePanel) {
        this.availableRacePanel = availableRacePanel;
    }

    public JButton getAddRaceButton() {
        return addRaceButton;
    }

    public void setAddRaceButton(JButton addRaceButton) {
        this.addRaceButton = addRaceButton;
    }

    public JTextField getCcField() {
        return ccField;
    }

    public void setCcField(JTextField ccField) {
        this.ccField = ccField;
    }

    public JTextField getCtField() {
        return ctField;
    }

    public void setCtField(JTextField ctField) {
        this.ctField = ctField;
    }

    public JTextField getfField() {
        return fField;
    }

    public void setfField(JTextField fField) {
        this.fField = fField;
    }

    public JTextField geteField() {
        return eField;
    }

    public void seteField(JTextField eField) {
        this.eField = eField;
    }

    public JTextField getAgField() {
        return agField;
    }

    public void setAgField(JTextField agField) {
        this.agField = agField;
    }

    public JTextField getIntField() {
        return intField;
    }

    public void setIntField(JTextField intField) {
        this.intField = intField;
    }

    public JTextField getFmField() {
        return fmField;
    }

    public void setFmField(JTextField fmField) {
        this.fmField = fmField;
    }

    public JTextField getSocField() {
        return socField;
    }

    public void setSocField(JTextField socField) {
        this.socField = socField;
    }

    public JTextField getaField() {
        return aField;
    }

    public void setaField(JTextField aField) {
        this.aField = aField;
    }

    public JTextField getbField() {
        return bField;
    }

    public void setbField(JTextField bField) {
        this.bField = bField;
    }

    public JTextField getmField() {
        return mField;
    }

    public void setmField(JTextField mField) {
        this.mField = mField;
    }

    public JTextField getMagField() {
        return magField;
    }

    public void setMagField(JTextField magField) {
        this.magField = magField;
    }

    public JPanel getSkillPanel() {
        return skillPanel;
    }

    public void setSkillPanel(JPanel skillPanel) {
        this.skillPanel = skillPanel;
    }

    public JButton getAddSkillGroupButton() {
        return addSkillGroupButton;
    }

    public void setAddSkillGroupButton(JButton addSkillGroupButton) {
        this.addSkillGroupButton = addSkillGroupButton;
    }

    public JPanel getTalentPanel() {
        return talentPanel;
    }

    public void setTalentPanel(JPanel talentPanel) {
        this.talentPanel = talentPanel;
    }

    public JButton getAddTalentGroupButton() {
        return addTalentGroupButton;
    }

    public void setAddTalentGroupButton(JButton addTalentGroupButton) {
        this.addTalentGroupButton = addTalentGroupButton;
    }

    public JPanel getWeaponPanel() {
        return weaponPanel;
    }

    public void setWeaponPanel(JPanel weaponPanel) {
        this.weaponPanel = weaponPanel;
    }

    public JButton getAddWeaponGroupButton() {
        return addWeaponGroupButton;
    }

    public void setAddWeaponGroupButton(JButton addWeaponGroupButton) {
        this.addWeaponGroupButton = addWeaponGroupButton;
    }

    public JPanel getArmourPanel() {
        return armourPanel;
    }

    public void setArmourPanel(JPanel armourPanel) {
        this.armourPanel = armourPanel;
    }

    public JButton getAddArmourGroupButton() {
        return addArmourGroupButton;
    }

    public void setAddArmourGroupButton(JButton addArmourGroupButton) {
        this.addArmourGroupButton = addArmourGroupButton;
    }

    public JPanel getEquipmentPanel() {
        return equipmentPanel;
    }

    public void setEquipmentPanel(JPanel equipmentPanel) {
        this.equipmentPanel = equipmentPanel;
    }

    public JButton getAddEquipmentGroupButton() {
        return addEquipmentGroupButton;
    }

    public void setAddEquipmentGroupButton(JButton addEquipmentGroupButton) {
        this.addEquipmentGroupButton = addEquipmentGroupButton;
    }

    public JPanel getAccessPanel() {
        return accessPanel;
    }

    public void setAccessPanel(JPanel accessPanel) {
        this.accessPanel = accessPanel;
    }

    public JButton getAddAccessButton() {
        return addAccessButton;
    }

    public void setAddAccessButton(JButton addAccessButton) {
        this.addAccessButton = addAccessButton;
    }

    public JPanel getOpeningPanel() {
        return openingPanel;
    }

    public void setOpeningPanel(JPanel openingPanel) {
        this.openingPanel = openingPanel;
    }

    public JButton getAddOpeningButton() {
        return addOpeningButton;
    }

    public void setAddOpeningButton(JButton addOpeningButton) {
        this.addOpeningButton = addOpeningButton;
    }
}
