package gui.listeners.characterListener;

import core.World;
import core.characteristics.Career;
import core.characteristics.Skill;
import core.equipment.Armour;
import core.equipment.Equipment;
import core.equipment.Weapon;
import gui.CharacterPanel;
import gui.ComboboxToolTipRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by LinkedFluuuush on 04/10/2015.
 */
public class addToCharacterAL implements ActionListener {
    private final String toAdd;
    private final CharacterPanel panel;

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
                JComboBox<Skill> comboSkills = new JComboBox<>();
                LinkedList<String> sortedSkills = new LinkedList<>(World.SKILLS.keySet());
                Collections.sort(sortedSkills);

                LinkedList<String> alreadyHaveSkills = panel.getCharacter().getSkills();

                JLabel labelSkill;
                String skillNameTemp;
                for(String skill : alreadyHaveSkills){
                    if(Collections.frequency(alreadyHaveSkills, skill) >= 3){
                        sortedSkills.remove(skill);
                    }
                }

                Skill defaultSkill = new Skill("Choisir une compétence", "");
                comboSkills.addItem(defaultSkill);
                for(String skillName : sortedSkills){
                    comboSkills.addItem(World.loadSkill(skillName));
                }

                saveButton.setEnabled(false);

                JComboBox<String> comboLevels = new JComboBox<>();

                comboSkills.addActionListener(e1 -> {
                    comboLevels.removeAllItems();

                    LinkedList<String> alreadyHaveSkills_Listener = panel.getCharacter().getSkills();

                    if(!comboSkills.getSelectedItem().equals(defaultSkill)){
                        switch (Collections.frequency(alreadyHaveSkills_Listener, ((Skill)comboSkills.getSelectedItem()).getName())){
                            case 0:
                                comboLevels.addItem("Acquis");
                            case 1:
                                comboLevels.addItem("+10");
                            case 2:
                                comboLevels.addItem("+20");
                                break;
                            default:
                                break;
                        }
                    }


                    if(comboSkills.getSelectedItem().equals(defaultSkill)){
                        saveButton.setEnabled(false);
                    } else {
                        saveButton.setEnabled(true);
                    }

                    dialog.revalidate();
                    dialog.repaint();
                    dialog.pack();
                });

                /* Buttons */
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    LinkedList<String> alreadyHaveSkills_Listener = panel.getCharacter().getSkills();

                    Skill skill = (Skill) comboSkills.getSelectedItem();
                    int timesToAdd;
                    switch(String.valueOf(comboLevels.getSelectedItem())){
                        case "+20":
                            timesToAdd = 3;
                            break;
                        case "+10":
                            timesToAdd = 2;
                            break;
                        case "Acquis":
                            timesToAdd = 1;
                            break;
                        default:
                            timesToAdd = 0;
                            break;
                    }

                    timesToAdd -= Collections.frequency(alreadyHaveSkills_Listener, ((Skill)comboSkills.getSelectedItem()).getName());

                    for(int i = 0 ; i < timesToAdd ; i++) {
                        panel.getCharacter().getSkills().add(skill.getName());
                    }

                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
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
                JComboBox<String> comboTalents = new JComboBox<>();
                LinkedList<String> sortedTalents = new LinkedList<>(World.TALENTS.keySet());
                Collections.sort(sortedTalents);

                LinkedList<String> alreadyHaveTalents = panel.getCharacter().getTalents();

                for(String talent : alreadyHaveTalents) {
                    sortedTalents.remove(talent);
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
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    String talentName = (String) comboTalents.getSelectedItem();

                    panel.getCharacter().getTalents().add(talentName);

                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
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
                JComboBox<String> comboArmours = new JComboBox<>();
                LinkedList<String> sortedArmours = new LinkedList<>(World.ARMOURS.keySet());
                Collections.sort(sortedArmours);

                LinkedList<String> alreadyHaveArmours = panel.getCharacter().getArmours();

                JLabel labelArmour;
                Armour armour, armourInQueue;
                LinkedList<String> sortedArmourCopy;

                for(String armourName : alreadyHaveArmours){
                    sortedArmours.remove(armourName);

                    armour = World.loadArmour(armourName);
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
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    String armourName = (String) comboArmours.getSelectedItem();

                    panel.getCharacter().getArmours().add(armourName);

                    panel.generateArmourLevels();
                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
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
                JComboBox<String> comboWeapons = new JComboBox<>();
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
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    String weaponName = (String) comboWeapons.getSelectedItem();
                    panel.getCharacter().getWeapons().add(weaponName);

                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
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
                JComboBox<String> comboEquipment = new JComboBox<>();
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

                selectEquipment.addActionListener(e1 -> {
                    crownArea.setEnabled(false);
                    shillingArea.setEnabled(false);
                    pennyArea.setEnabled(false);

                    comboEquipment.setEnabled(true);
                });

                selectMoney.addActionListener(e1 -> {
                    crownArea.setEnabled(true);
                    shillingArea.setEnabled(true);
                    pennyArea.setEnabled(true);

                    comboEquipment.setEnabled(false);
                });

                /* Buttons */
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    if(selectEquipment.isSelected()) {
                        String equipmentName = (String) comboEquipment.getSelectedItem();
                        panel.getCharacter().getEquipment().add(equipmentName);
                    } else {
                        if(crownArea.getText().matches("([0-9]+)||(^$)") && shillingArea.getText().matches("([0-9]+)|(^$)") && pennyArea.getText().matches("([0-9]+)|(^$)")) {
                            if(crownArea.getText().equals("")){
                                crownArea.setText("0");
                            }

                            if(shillingArea.getText().equals("")){
                                shillingArea.setText("0");
                            }

                            if(pennyArea.getText().equals("")){
                                pennyArea.setText("0");
                            }

                            panel.getCharacter().getMoney().setBrassPennies(Integer.parseInt(pennyArea.getText()) + panel.getCharacter().getMoney().getBrassPennies());
                            panel.getCharacter().getMoney().setSilverShillings(Integer.parseInt(shillingArea.getText()) + panel.getCharacter().getMoney().getSilverShillings());
                            panel.getCharacter().getMoney().setGoldenCrowns(Integer.parseInt(crownArea.getText()) + panel.getCharacter().getMoney().getGoldenCrowns());
                        } else {
                            dialog.dispose();
                            return;
                        }
                    }

                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
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
            case "career":
                dialog = new JDialog((JFrame)panel.getParent().getParent().getParent().getParent(),"Sélection d'une carrière", true);
                contentPane = dialog.getContentPane();

                /* Panels */
                choicePane = new JPanel();
                choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
                choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                buttonPane = new JPanel();
                buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

                /* Selection elements */
                JComboBox<String> comboCareers = new JComboBox<>();
                LinkedList<String> sortedCareers = new LinkedList<>(World.CAREERS.keySet());
                Collections.sort(sortedCareers);

                LinkedList<String> alreadyHaveCareers = panel.getCharacter().getCareers();

                ComboboxToolTipRenderer comboCareerRenderer = new ComboboxToolTipRenderer();
                comboCareers.setRenderer(comboCareerRenderer);

                for(String careerName : sortedCareers) {
                    if (!alreadyHaveCareers.contains(careerName) &&
                            (World.loadCareer(careerName).getType().equals(Career.CareerType.BASE) ||
                                    Career.isCareerAvailableFrom(careerName, alreadyHaveCareers)) &&
                            World.loadCareer(careerName).getAvailableRaces().contains(panel.getComboRace().getSelectedItem())) {
                        comboCareers.addItem(careerName);
                    }
                }

                /* Buttons */
                cancelButton.addActionListener(e1 -> dialog.dispose());

                saveButton.addActionListener(e1 -> {
                    String careerName = (String) comboCareers.getSelectedItem();

                    panel.getCharacter().getCareers().add(careerName);
                    panel.revalidate();
                    panel.repaint();
                    dialog.dispose();
                });

                choicePane.add(comboCareers);

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
            default:
                break;
        }

        panel.emptyElements();
        panel.applyCharacter();
    }
}
