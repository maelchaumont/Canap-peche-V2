package classes;

import java.util.ArrayList;

public class BoucleurLent extends BoucleurAbstrait{
    private String etatVague;

    public BoucleurLent(){
        super.setListObservateurs(new ArrayList<>());
        super.attacher(new AnimVaguePoisson());
        etatVague = "test";
    }


    @Override
    public void run(){
        while(true) {
            //voir dans la classe mère
            notifier();
            try {
                Thread.sleep(10000);//10 sec
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