package gui.listeners.characterListener;

import core.World;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;
import gui.CharacterPanel;
import gui.ComboboxToolTipRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by LinkedFluuuush on 04/10/2015.
 */
public class addToCharacterAL implements ActionListener {
    String toAdd;
    CharacterPanel panel;

    public addToCharacterAL(String toAdd, CharacterPanel panel) {
        this.toAdd = toAdd;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog;
        Container contentPane;
        JPanel choicePane;
        JPanel buttonPane;
        JButton cancelButton = new JButton("Annuler");
        JButton saveButton = new JButton("Valider");

        switch (toAdd){
            case "skill":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'une compétence", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                JComboBox<String> comboSkills = new JComboBox<String>();
                LinkedList<String> sortedSkills = new LinkedList<>(World.SKILLS.keySet());
                Collections.sort(sortedSkills);

                LinkedList<Component> alreadyHaveSkills = new LinkedList<>(Arrays.asList(panel.getSkillPanel().getComponents()));

                JLabel labelSkill;
                String skillNameTemp;
                for(Component cmp : alreadyHaveSkills){
                    if(cmp.getClass() == JLabel.class){
                        labelSkill = (JLabel) cmp;
                        if(labelSkill.getText().contains("(+20)")) {
                            skillNameTemp = labelSkill.getText();
                            skillNameTemp = skillNameTemp.replaceAll("( \\(\\+20\\))(.*)", "");
                            sortedSkills.remove(skillNameTemp);
                        }
                    }
                }

                comboSkills.addItem("Choisir une compétence");
                for(String skillName : sortedSkills){
                    comboSkills.addItem(skillName + " : " + World.loadSkill(skillName).getCharacteristics());
                }

                saveButton.setEnabled(false);

                JComboBox<String> comboLevels = new JComboBox<String>();

                comboSkills.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        comboLevels.removeAllItems();
                        LinkedList<Component> alreadyHaveSkills = new LinkedList<>(Arrays.asList(panel.getSkillPanel().getComponents()));

                        JLabel labelSkill = null;
                        boolean skillFound = false;
                        String skillName;
                        for(Component cmp : alreadyHaveSkills){
                            if(cmp.getClass() == JLabel.class){
                                labelSkill = (JLabel) cmp;
                                skillName = labelSkill.getText();
                                skillName = skillName.replace(" (+10)", "");
                                skillName = skillName.replace(" (+20)", "");

                                if(skillName.equals(comboSkills.getSelectedItem())) {
                                    skillFound = true;
                                    break;
                                }
                            }
                        }

                        if(skillFound){
                            if(labelSkill.getText().contains("+10")){
                                comboLevels.addItem("+20");
                            } else {
                                comboLevels.addItem("+10");
                                comboLevels.addItem("+20");
                            }
                        } else {
                            comboLevels.addItem("Acquis");
                            comboLevels.addItem("+10");
                            comboLevels.addItem("+20");
                        }

                        if(comboSkills.getSelectedItem().equals("Choisir une compétence")){
                            saveButton.setEnabled(false);
                        } else {
                            saveButton.setEnabled(true);
                        }

                        dialog.revalidate();
                        dialog.repaint();
                        dialog.pack();
                    }
                });

                /* Buttons */
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkedList<Component> alreadyHaveSkills = new LinkedList<>(Arrays.asList(panel.getSkillPanel().getComponents()));

                        JLabel skillLabel;
                        String skillName;
                        for(Component cmp : alreadyHaveSkills){
                            if(cmp.getClass() == JLabel.class){
                                skillLabel = (JLabel) cmp;
                                skillName = skillLabel.getText();
                                skillName = skillName.replace(" (+10)", "");
                                skillName = skillName.replace(" (+20)", "");

                                if(skillName.equals(comboSkills.getSelectedItem())) {
                                    panel.getSkillPanel().remove(skillLabel);
                                    break;
                                }
                            }
                        }

                        skillLabel = new JLabel();

                        skillName = ((String) comboSkills.getSelectedItem()).split(" : ")[0];
                        String skillChar = ((String) comboSkills.getSelectedItem()).split(" : ")[1];
                        String skillNameLevel = skillName;
                        String level = (String) comboLevels.getSelectedItem();

                        if(!level.equals("Acquis")){
                            skillNameLevel += " (" + level + ")";
                        }

                        skillNameLevel += " : " + skillChar;
                        skillLabel.setText(skillNameLevel);
                        skillLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

                        panel.getSkillPanel().add(skillLabel);
                        panel.revalidate();
                        panel.repaint();
                        dialog.dispose();
                    }
                });

                choicePane.add(comboSkills);
                choicePane.add(Box.createRigidArea(new Dimension(10,0)));
                choicePane.add(comboLevels);

                buttonPane.add(Box.createHorizontalGlue());
                buttonPane.add(cancelButton);
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
                buttonPane.add(saveButton);

                contentPane.add(choicePane, BorderLayout.CENTER);
                contentPane.add(buttonPane, BorderLayout.PAGE_END);

                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setVisible(true);
                break;
            case "talent":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'un talent", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                JComboBox<String> comboTalents = new JComboBox<String>();
                LinkedList<String> sortedTalents = new LinkedList<>(World.TALENTS.keySet());
                Collections.sort(sortedTalents);

                LinkedList<Component> alreadyHaveTalents = new LinkedList<>(Arrays.asList(panel.getTalentPanel().getComponents()));

                JLabel labelTalent;
                for(Component cmp : alreadyHaveTalents){
                    if(cmp.getClass() == JLabel.class){
                        labelTalent = (JLabel) cmp;
                        sortedTalents.remove(labelTalent.getText());
                    }
                }

                ComboboxToolTipRenderer comboTalentRenderer = new ComboboxToolTipRenderer();
                comboTalents.setRenderer(comboTalentRenderer);

                LinkedList<String> tooltips = new LinkedList<>();

                for(String talentName : sortedTalents){
                    comboTalents.addItem(talentName);
                    tooltips.add(World.loadTalent(talentName).getDescription());
                }

                comboTalentRenderer.setTooltips(tooltips);

                /* Buttons */
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel talentLabel = new JLabel();

                        String talentName = (String) comboTalents.getSelectedItem();

                        talentLabel.setText(talentName);
                        talentLabel.setToolTipText(World.loadTalent(talentName).getDescription());
                        talentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

                        panel.getTalentPanel().add(talentLabel);
                        panel.revalidate();
                        panel.repaint();
                        dialog.dispose();
                    }
                });

                choicePane.add(comboTalents);

                buttonPane.add(Box.createHorizontalGlue());
                buttonPane.add(cancelButton);
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
                buttonPane.add(saveButton);

                contentPane.add(choicePane, BorderLayout.CENTER);
                contentPane.add(buttonPane, BorderLayout.PAGE_END);

                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setVisible(true);
                break;
            case "armour":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'une armure", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                JComboBox<String> comboArmours = new JComboBox<String>();
                LinkedList<String> sortedArmours = new LinkedList<>(World.ARMOURS.keySet());
                Collections.sort(sortedArmours);

                LinkedList<Component> alreadyHaveArmours = new LinkedList<>(Arrays.asList(panel.getArmourPanel().getComponents()));

                JLabel labelArmour;
                Armour armour, armourInQueue;
                LinkedList<String> sortedArmourCopy;

                for(Component cmp : alreadyHaveArmours){
                    if(cmp.getClass() == JLabel.class){
                        labelArmour = (JLabel) cmp;
                        sortedArmours.remove(labelArmour.getText());

                        armour = World.loadArmour(labelArmour.getText());
                        sortedArmourCopy = (LinkedList<String>) sortedArmours.clone();
                        for(String armourInQueueName : sortedArmourCopy){
                            armourInQueue = World.loadArmour(armourInQueueName);
                            if(armourInQueue.getArmourType().equals(armour.getArmourType())){
                                for(String covered : armour.getCoveredZones()){
                                    if(armourInQueue.getCoveredZones().contains(covered)){
                                        sortedArmours.remove(armourInQueueName);
                                    }
                                }
                            }
                        }
                    }
                }

                ComboboxToolTipRenderer comboArmourRenderer = new ComboboxToolTipRenderer();
                comboArmours.setRenderer(comboArmourRenderer);

                LinkedList<String> tooltipsArmour = new LinkedList<>();
                String tooltip;
                LinkedList<String> coveredParts;
                for(String armourName : sortedArmours){
                    comboArmours.addItem(armourName);
                    tooltip = "";
                    armour = World.loadArmour(armourName);
                    coveredParts = armour.getCoveredZones();

                    for(String part : coveredParts){
                        tooltip += part + ", ";
                    }

                    tooltip = tooltip.substring(0, tooltip.length() - 2);

                    tooltip += " : " + armour.getArmourLevel() + " PA";
                    tooltipsArmour.add(tooltip);

                }

                comboArmourRenderer.setTooltips(tooltipsArmour);

                /* Buttons */
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel armourLabel = new JLabel();

                        String armourName = (String) comboArmours.getSelectedItem();

                        armourLabel.setText(armourName);
                        String tooltip = "";
                        Armour armour = World.loadArmour(armourName);
                        LinkedList<String> coveredParts = armour.getCoveredZones();

                        for(String part : coveredParts){
                            tooltip += part + ", ";
                        }

                        tooltip = tooltip.substring(0, tooltip.length() - 2);

                        tooltip += " : " + armour.getArmourLevel() + " PA";

                        armourLabel.setToolTipText(tooltip);
                        armourLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

                        panel.getArmourPanel().add(armourLabel);
                        panel.generateArmourLevels();
                        panel.revalidate();
                        panel.repaint();
                        dialog.dispose();
                    }
                });

                choicePane.add(comboArmours);

                buttonPane.add(Box.createHorizontalGlue());
                buttonPane.add(cancelButton);
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
                buttonPane.add(saveButton);

                contentPane.add(choicePane, BorderLayout.CENTER);
                contentPane.add(buttonPane, BorderLayout.PAGE_END);

                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setVisible(true);
                break;
            case "weapon":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'une arme", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                JComboBox<String> comboWeapons = new JComboBox<String>();
                LinkedList<String> sortedWeapons = new LinkedList<>(World.WEAPONS.keySet());
                Collections.sort(sortedWeapons);

                ComboboxToolTipRenderer comboWeaponRenderer = new ComboboxToolTipRenderer();
                comboWeapons.setRenderer(comboWeaponRenderer);

                LinkedList<String> tooltipsWeapon = new LinkedList<>();
                String tooltipWeapon;
                Weapon weapon;
                LinkedList<String> attributes;
                int reload;

                for(String weaponName : sortedWeapons){
                    comboWeapons.addItem(weaponName);
                    tooltipWeapon = "";
                    weapon = World.loadWeapon(weaponName);

                    tooltipWeapon = weapon.getGroup() + " | Dégâts " + weapon.getDamage();

                    if(weapon.getLowRange() != 0){
                        tooltipWeapon += " | Portée : " + weapon.getLowRange() + " - " + weapon.getHighRange();
                        tooltipWeapon += " | Rechargement : ";
                        reload = weapon.getReload();
                        if(reload / 2 != 0){
                            tooltipWeapon += (reload/2);
                            if(reload%2 != 0){
                                tooltipWeapon += " + " + (reload%2) + "/2";
                            }
                        } else if(reload%2 != 0){
                            tooltipWeapon += (reload%2) + "/2";
                        }

                        tooltipWeapon += "A";
                    }

                    attributes = weapon.getAttributes();
                    if(attributes.size() != 0) {
                        tooltipWeapon += " | Attributs : ";
                        for (String attribute : attributes) {
                            tooltipWeapon += attribute + ", ";
                        }

                        tooltipWeapon = tooltipWeapon.substring(0, tooltipWeapon.length() - 2);
                    }

                    tooltipsWeapon.add(tooltipWeapon);

                }

                comboWeaponRenderer.setTooltips(tooltipsWeapon);

                /* Buttons */
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel weaponLabel = new JLabel();

                        String weaponName = (String) comboWeapons.getSelectedItem();

                        weaponLabel.setText(weaponName);
                        String tooltip = "";
                        Weapon weapon = World.loadWeapon(weaponName);

                        tooltip = weapon.getGroup() + " | Dégâts " + weapon.getDamage();

                        if(weapon.getLowRange() != 0){
                            tooltip += " | Portée : " + weapon.getLowRange() + " - " + weapon.getHighRange();
                            tooltip += " | Rechargement : ";
                            int reload = weapon.getReload();
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

                        LinkedList<String> attributes = weapon.getAttributes();
                        if(attributes.size() != 0) {
                            tooltip += " | Attributs : ";
                            for (String attribute : attributes) {
                                tooltip += attribute + ", ";
                            }

                            tooltip = tooltip.substring(0, tooltip.length() - 2);
                        }

                        weaponLabel.setToolTipText(tooltip);
                        weaponLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

                        panel.getWeaponPanel().add(weaponLabel);
                        panel.revalidate();
                        panel.repaint();
                        dialog.dispose();
                    }
                });

                choicePane.add(comboWeapons);

                buttonPane.add(Box.createHorizontalGlue());
                buttonPane.add(cancelButton);
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
                buttonPane.add(saveButton);

                contentPane.add(choicePane, BorderLayout.CENTER);
                contentPane.add(buttonPane, BorderLayout.PAGE_END);

                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setVisible(true);
                break;
            case "equipment":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'un objet", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.PAGE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                ButtonGroup selection = new ButtonGroup();

                JPanel selectEquipmentPanel = new JPanel();
                selectEquipmentPanel.setLayout(new GridLayout(2, 1));

                JRadioButton selectEquipment = new JRadioButton("Ajouter un objet");
                selectEquipment.setSelected(true);
                JComboBox<String> comboEquipment = new JComboBox<String>();
                LinkedList<String> sortedEquipments = new LinkedList<>(World.EQUIPMENTS.keySet());
                Collections.sort(sortedEquipments);

                ComboboxToolTipRenderer comboEquipmentRenderer = new ComboboxToolTipRenderer();
                comboEquipment.setRenderer(comboEquipmentRenderer);

                LinkedList<String> tooltipsEquipment = new LinkedList<>();
                String tooltipEquipment;
                Equipment equipment;

                for(String equipmentName : sortedEquipments){
                    comboEquipment.addItem(equipmentName);
                    equipment = World.loadEquipment(equipmentName);

                    tooltipEquipment = "Enc : " + equipment.getEnc();

                    tooltipsEquipment.add(tooltipEquipment);

                }

                comboEquipmentRenderer.setTooltips(tooltipsEquipment);

                selectEquipmentPanel.add(selectEquipment);
                selectEquipmentPanel.add(Box.createRigidArea(new Dimension(0,5)));
                selectEquipmentPanel.add(comboEquipment);

                JPanel selectMoneyPanel = new JPanel();
                selectMoneyPanel.setLayout(new GridLayout(2, 1));

                JRadioButton selectMoney = new JRadioButton("Ajouter de l'argent");

                JPanel addMoneyPanel = new JPanel();
                addMoneyPanel.setLayout(new BoxLayout(addMoneyPanel, BoxLayout.LINE_AXIS));

                JLabel crownLabel = new JLabel("Co :");
                JTextArea crownArea = new JTextArea(1,3);

                JLabel shillingLabel = new JLabel("Pa :");
                JTextArea shillingArea = new JTextArea(1,3);

                JLabel pennyLabel = new JLabel("Sc :");
                JTextArea pennyArea = new JTextArea(1,3);

                crownArea.setEnabled(false);
                shillingArea.setEnabled(false);
                pennyArea.setEnabled(false);

                addMoneyPanel.add(crownLabel);
                addMoneyPanel.add(Box.createRigidArea(new Dimension(5,0)));
                addMoneyPanel.add(crownArea);
                addMoneyPanel.add(Box.createRigidArea(new Dimension(5,0)));
                addMoneyPanel.add(shillingLabel);
                addMoneyPanel.add(Box.createRigidArea(new Dimension(5,0)));
                addMoneyPanel.add(shillingArea);
                addMoneyPanel.add(Box.createRigidArea(new Dimension(5,0)));
                addMoneyPanel.add(pennyLabel);
                addMoneyPanel.add(Box.createRigidArea(new Dimension(5,0)));
                addMoneyPanel.add(pennyArea);

                selectMoneyPanel.add(selectMoney);
                selectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 5)));
                selectMoneyPanel.add(addMoneyPanel);

                selection.add(selectEquipment);
                selection.add(selectMoney);

                selectEquipment.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        crownArea.setEnabled(false);
                        shillingArea.setEnabled(false);
                        pennyArea.setEnabled(false);

                        comboEquipment.setEnabled(true);
                    }
                });

                selectMoney.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        crownArea.setEnabled(true);
                        shillingArea.setEnabled(true);
                        pennyArea.setEnabled(true);

                        comboEquipment.setEnabled(false);
                    }
                });

                /* Buttons */
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel equipmentLabel = new JLabel();

                        if(selectEquipment.isSelected()) {
                            String equipmentName = (String) comboEquipment.getSelectedItem();

                            equipmentLabel.setText(equipmentName);
                            Equipment equipment = World.loadEquipment(equipmentName);

                            String tooltip = "Enc : " + equipment.getEnc();

                            equipmentLabel.setToolTipText(tooltip);
                            equipmentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                        } else {
                            if(crownArea.getText().matches("([0-9]+)||(^$)") && shillingArea.getText().matches("([0-9]+)|(^$)") && pennyArea.getText().matches("([0-9]+)|(^$)")) {
                                JLabel moneyLabel;
                                String[] moneySplit;
                                int[] newMoney = {0, 0, 0};
                                for (Component cmp : panel.getEquipmentPanel().getComponents()) {
                                    if (cmp.getClass() == JLabel.class) {
                                        moneyLabel = (JLabel) cmp;
                                        if (moneyLabel.getText().startsWith("Money")) {
                                            moneySplit = moneyLabel.getText().split(",");
                                            newMoney[0] = Integer.parseInt(moneySplit[0].substring(8, moneySplit[0].length() - 3));
                                            newMoney[1] = Integer.parseInt(moneySplit[1].substring(1, moneySplit[1].length() - 3));
                                            newMoney[2] = Integer.parseInt(moneySplit[2].substring(1, moneySplit[2].length() - 3));

                                            panel.getEquipmentPanel().remove(moneyLabel);
                                        }
                                    }
                                }

                                if(crownArea.getText().equals("")){
                                    crownArea.setText("0");
                                }

                                if(shillingArea.getText().equals("")){
                                    shillingArea.setText("0");
                                }

                                if(pennyArea.getText().equals("")){
                                    pennyArea.setText("0");
                                }

                                newMoney[0] += Integer.parseInt(crownArea.getText());
                                newMoney[1] += Integer.parseInt(shillingArea.getText());
                                newMoney[2] += Integer.parseInt(pennyArea.getText());

                                equipmentLabel.setText("Money : " + newMoney[0] + " Co, " + newMoney[1] + " Pa, " + newMoney[2] + " Sc");

                                equipmentLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                            } else {
                                dialog.dispose();
                                return;
                            }
                        }
                        panel.getEquipmentPanel().add(equipmentLabel);

                        panel.revalidate();
                        panel.repaint();
                        dialog.dispose();
                    }
                });

                choicePane.add(selectEquipmentPanel);
                choicePane.add(Box.createRigidArea(new Dimension(0,5)));
                choicePane.add(selectMoneyPanel);

                buttonPane.add(Box.createHorizontalGlue());
                buttonPane.add(cancelButton);
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
                buttonPane.add(saveButton);

                contentPane.add(choicePane, BorderLayout.EAST);
                contentPane.add(buttonPane, BorderLayout.PAGE_END);

                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setVisible(true);
                break;
            default:
                break;
        }
    }
}
