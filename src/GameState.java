import java.io.Serializable;
//test
public class GameState implements Serializable {
    private int spacesMoved;
    private int coinAmount;
    private int starAmount;


    public GameState(){

    }

    public GameState (int spacesMoved, int coinAmount, int starAmount){
        this.spacesMoved = spacesMoved;
        this.coinAmount = coinAmount;
        this.starAmount = starAmount;
    }

    public int getSpacesMoved() {
        return spacesMoved;
    }

    public void setSpacesMoved(int spacesMoved) {
        this.spacesMoved = spacesMoved;
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }

    public int getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(int starAmount) {
        this.starAmount = starAmount;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "spacesMoved=" + spacesMoved +
                ", coinAmount=" + coinAmount +
                ", starAmount=" + starAmount +
                '}';
    }
}
