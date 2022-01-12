package classes;

import java.util.ArrayList;

public class BoucleurRapide extends BoucleurAbstrait{
    private String etatVague;

    public BoucleurRapide(int millisSleep, VaguePoissons vP){
        super.setListObservateurs(new ArrayList<>());
        super.attacher(new AnimVaguePoisson(vP));
        this.setMillisSleep(millisSleep);
        etatVague = "test";
    }


    @Override
    public void run(){
        while(true) {
            //voir dans la classe mère
            notifier();
            try {
                System.out.println("testboucleur");
                Thread.sleep(getMillisSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getEtatVague() {
        return etatVague;
    }

    public void setEtatVague(String etatVague) {
        this.etatVague = etatVague;
    }
}
