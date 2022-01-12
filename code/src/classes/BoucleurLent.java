package classes;

import java.util.ArrayList;

public class BoucleurLent extends BoucleurAbstrait{
    private String etatVague;

    public BoucleurLent(int millisSleep){
        super.setListObservateurs(new ArrayList<>());
        this.setMillisSleep(millisSleep);
        etatVague = "test";
    }


    @Override
    public void run(){
        while(true) {
            //voir dans la classe mère
            notifier();
            try {
                System.out.println("testboucleurlent");
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
