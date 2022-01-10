package classes;

import java.util.ArrayList;

public class BoucleurRapide extends BoucleurAbstrait{
    private String etatVague;

    public BoucleurRapide(){
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
                System.out.println("testboucleur");
                Thread.sleep(17);
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
