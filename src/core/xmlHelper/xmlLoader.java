package core.xmlHelper;

import core.characteristics.Skill;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 13/11/13
 * Time: 17:57
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class xmlLoader {

    static Document document;
    static Element root;

    public LinkedList<Skill> skillLoader(){
        SAXBuilder sxb = new SAXBuilder();
        List<Element> skills;
        Iterator<Element> iteratorSkills;

        LinkedList<Skill> skillLinkedList = new LinkedList<Skill>();
        Skill currentSkill = new Skill();

        try{
            document = sxb.build(new File("resources/skills.xml"));
        }catch (JDOMException e) {}
        catch (IOException e) {}

        root = document.getRootElement();

        skills = root.getChildren("skill");
        iteratorSkills = skills.iterator();

        while(iteratorSkills.hasNext()){

        }

    }
}
