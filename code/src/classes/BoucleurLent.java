package classes;

import java.util.ArrayList;

public class BoucleurLent extends BoucleurAbstrait{

    public BoucleurLent(int millisSleep, VaguePoissons vP){
        super.setListObservateurs(new ArrayList<>());
        super.attacher(new ObservateurCreationPoisson(vP));
        this.setMillisSleep(millisSleep);
    }


    @Override
    public void run(){
        while(true) {
            //voir dans la classe mère
            notifier();
            try {
                //System.out.println("testboucleurlent");
                Thread.sleep(getMillisSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
