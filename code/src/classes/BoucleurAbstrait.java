package classes;

import java.util.ArrayList;

public abstract class BoucleurAbstrait implements Runnable{
    private int millisSleep;
    private ArrayList<Observateur> listObservateurs;

    public void attacher(Observateur o) {
        listObservateurs.add(o);
    }

    public void detacher(Observateur o) {
        listObservateurs.remove(o);
    }

    public void notifier() {
        for (Observateur o:
                getListObservateurs()) {
            o.update();
        }
        //on récupère le beep et update les Observateurs
    }

    //GETTERS & SETTERS
    public ArrayList<Observateur> getListObservateurs() {
        return listObservateurs;
    }

    public void setListObservateurs(ArrayList<Observateur> listObservateurs) {
        this.listObservateurs = listObservateurs;
    }

    public int getMillisSleep() {
        return millisSleep;
    }

    public void setMillisSleep(int millisSleep) {
        this.millisSleep = millisSleep;
    }
}
