package gui;

import core.characteristics.Career;
import core.entities.Character;
import gui.listeners.characterListener.removeCharacterAL;

import javax.swing.*;
import java.awt.*;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 13:09
 */
public class CharacterPanel extends JPanel {
    private Character character;

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

    public void applyCharacter(){
        this.removeAll();

        if(this.character == null){
            this.setLayout(new FlowLayout());
            this.add(new CreateCharacterPanel());
            this.repaint();
            this.revalidate();
        } else {
            this.setLayout(null);
            //JPanel panel = character.toPanel();
            //this.add(panel);
            this.setMinimumSize(new Dimension(784, 500));
            this.repaint();

            this.createCharacter();
        }

        //this.revalidate();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int initH = (int)this.getSize().getWidth()/2 - 392;
        int initV = (int)this.getSize().getHeight()/2 - 250;

        if(this.character == null){

        } else {
            g.drawImage(new ImageIcon("./resources/imgs/OneChar.png").getImage(),
                    (int)this.getSize().getWidth()/2 - 392,
                    (int)this.getSize().getHeight()/2 - 250, null);
            //g.drawRect(initH + 60, initV + 83, 310, 17);
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

        JButton removeButton = new JButton("Effacer le personnage");
        removeButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        removeButton.setMargin(new Insets(2, 5, 2, 5));
        removeButton.addActionListener(new removeCharacterAL());
        removeButton.setBounds(initH + 620, initV + 450, 140, 30);
        this.add(removeButton);
    }
}
