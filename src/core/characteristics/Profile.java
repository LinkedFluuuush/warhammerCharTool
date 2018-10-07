package core.characteristics;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Profile {
    private int ws;
    private int bs;
    private int s;
    private int t;
    private int ag;
    private int intel;
    private int wp;
    private int fel;

    private int a;
    private int w;
    private int sb;
    private int tb;
    private int m;
    private int mag;
    private int ip;
    private int fp;

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int a, int w, int sb, int tb, int m, int mag, int ip, int fp) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = a;
        this.w = w;
        this.sb = sb;
        this.tb = tb;
        this.m = m;
        this.mag = mag;
        this.ip = ip;
        this.fp = fp;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int a, int w, int m, int mag) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = a;
        this.w = w;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = mag;
        this.ip = 0;
        this.fp = 0;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int w, int m, int fp) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = 1;
        this.w = w;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = 0;
        this.ip = 0;
        this.fp = fp;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel, int m) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = 1;
        this.w = 0;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = 0;
        this.ip = 0;
        this.fp = 0;
    }

    public Profile(){
        this(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getAg() {
        return ag;
    }

    public void setAg(int ag) {
        this.ag = ag;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWp() {
        return wp;
    }

    public void setWp(int wp) {
        this.wp = wp;
    }

    public int getFel() {
        return fel;
    }

    public void setFel(int fel) {
        this.fel = fel;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getSb() {
        return sb;
    }

    public void setSb(int sb) {
        this.sb = sb;
    }

    public int getTb() {
        return tb;
    }

    public void setTb(int tb) {
        this.tb = tb;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    @Override
    public String toString(){
        String res = "Caratéristiques\n";
        res += "CC\tCT\tF\tE\tAg\tInt\tFM\tSoc\n";
        res += this.getWs() + "\t" + this.getBs() + "\t" + this.getS() + "\t" + this.getT() + "\t" + this.getAg() +
                "\t" + this.getIntel() + "\t" + this.getWp() + "\t" + this.getFel() + "\n";
        res += "A\tB\tBF\tBE\tM\tMag\tPF\tPD\n";
        res += this.getA() + "\t" + this.getW() + "\t" + this.getSb() + "\t" + this.getTb() + "\t" + this.getM() +
                "\t" + this.getMag() + "\t" + this.getIp() + "\t" + this.getFp() + "\n";
        return res;
    }

/*    public JPanel toPanel(){
        JPanel panel = new JPanel(new GridLayout(4, 8));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.add(new JLabel("CC"));
        panel.add(new JLabel("CT"));
        panel.add(new JLabel("F"));
        panel.add(new JLabel("E"));
        panel.add(new JLabel("Ag"));
        panel.add(new JLabel("Int"));
        panel.add(new JLabel("FM"));
        panel.add(new JLabel("Soc"));

        JLabel buttonMinus = new JLabel("-", SwingConstants.CENTER);
        buttonMinus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel buttonPlus = new JLabel("+", SwingConstants.CENTER);
        buttonPlus.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        buttonMinus.setSize(new Dimension(15, 15));
        buttonPlus.setSize(new Dimension(15, 15));

        //buttonMinus.addMouseListener();

        JPanel panelWs = new JPanel(new GridLayout(1, 3));
        panelWs.add(buttonMinus);
        panelWs.add(new JTextArea("" + this.getWs()));
        panelWs.add(buttonPlus);

        panel.add(panelWs);

        panel.add(new JTextArea("" + this.getBs()));
        panel.add(new JTextArea("" + this.getS()));
        panel.add(new JTextArea("" + this.getT()));
        panel.add(new JTextArea("" + this.getAg()));
        panel.add(new JTextArea("" + this.getIntel()));
        panel.add(new JTextArea("" + this.getWp()));
        panel.add(new JTextArea("" + this.getFel()));

        panel.add(new JLabel("A"));
        panel.add(new JLabel("B"));
        panel.add(new JLabel("BF"));
        panel.add(new JLabel("BE"));
        panel.add(new JLabel("M"));
        panel.add(new JLabel("Mag"));
        panel.add(new JLabel("PF"));
        panel.add(new JLabel("PD"));

        panel.add(new JTextArea("" + this.getA()));
        panel.add(new JTextArea("" + this.getW()));
        panel.add(new JTextArea("" + this.getSb()));
        panel.add(new JTextArea("" + this.getTb()));
        panel.add(new JTextArea("" + this.getM()));
        panel.add(new JTextArea("" + this.getMag()));
        panel.add(new JTextArea("" + this.getIp()));
        panel.add(new JTextArea("" + this.getFp()));

        return panel;
    }*/

    @Override
    public Profile clone(){
        return new Profile(this.getWs(),this.getBs(),this.getS(),this.getT(),this.getAg(),this.getIntel(),this.getWp(),
                this.getFel(),this.getA(),this.getW(),this.getSb(),this.getTb(),this.getM(),this.getMag(),this.getIp(),
                this.getFp());
    }
}
