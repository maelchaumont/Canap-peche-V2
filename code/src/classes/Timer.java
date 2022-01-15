package classes;

import javafx.beans.property.*;

public class Timer extends Observateur{
    private float timeOf1LoopMillis;
    private GameManager gM;

    //à donner en secondes
    public Timer(float totalTimeSec, float timeOf1LoopMillis, GameManager gM) {
        this.gM = gM;
        this.timeOf1LoopMillis = timeOf1LoopMillis;
        setActualTime(totalTimeSec);
    }

    @Override
    public void update() {
        if((getActualTime() - (timeOf1LoopMillis / 1000)) > 0) {
            setActualTime(getActualTime() - (timeOf1LoopMillis / 1000));
        }
        else {
            setActualTime(0);
            gM.gameOver();
        }
    }

    //binding
    private FloatProperty actualTime = new SimpleFloatProperty();
    public float getActualTime(){return actualTime.get();}
    public void setActualTime(float newTime){actualTime.set(newTime);}
    public ReadOnlyFloatProperty actualTimeProperty(){return actualTime;}
}
