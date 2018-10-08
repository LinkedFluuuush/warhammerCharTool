package gui.careerEditor.listeners;

import gui.careerEditor.CareerEditorPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveFromCareerListener implements MouseListener {
    private String type;
    private Object object;
    private CareerEditorPanel careerEditorPanel;

    public RemoveFromCareerListener(String type, Object object, CareerEditorPanel careerEditorPanel) {
        this.type = type;
        this.object = object;
        this.careerEditorPanel = careerEditorPanel;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        List finalList;

        switch (type){
            case "skill":
                finalList = careerEditorPanel.getCareer().getSkills();
                break;
            case "talent":
                finalList = careerEditorPanel.getCareer().getTalents();
                break;
            case "weapon":
                finalList = careerEditorPanel.getCareer().getWeapons();
                break;
            case "armour":
                finalList = careerEditorPanel.getCareer().getArmours();
                break;
            case "equipment":
                finalList = careerEditorPanel.getCareer().getEquipments();
                break;
            case "access":
                finalList = careerEditorPanel.getCareer().getAccessCareers();
                break;
            case "opening":
                finalList = careerEditorPanel.getCareer().getOpeningCareers();
                break;
            case "race":
                finalList = careerEditorPanel.getCareer().getAvailableRaces();
                break;
            default:
                finalList = new ArrayList();
        }

        finalList.remove(object);
        careerEditorPanel.applyProfile();
        careerEditorPanel.emptyElements();
        careerEditorPanel.applyCareer();
        careerEditorPanel.revalidate();
        careerEditorPanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
