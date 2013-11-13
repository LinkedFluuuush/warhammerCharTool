package core.characteristics;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class Career {
    private String name;
    private Profile profile;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Skill>> talents;


    public Career(String name, Profile profile, LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Skill>> talents) {
        this.name = name;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
    }

    public Career(String name, int ws, int bs, int s, int t, int ag, int intel, int wp,
                  int fel, int a, int w, int m, int mag,
                  LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Skill>> talents) {
        this.name = name;
        this.profile = new Profile(ws, bs, s, t, ag, intel, wp, fel, a, w, m, mag);
        this.skills = skills;
        this.talents = talents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<LinkedList<Skill>> skills) {
        this.skills = skills;
    }

    public LinkedList<LinkedList<Skill>> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<LinkedList<Skill>> talents) {
        this.talents = talents;
    }
}
