package game_logic;

public class game_logic {

    private double multipler = 1;
    private double myCoins = 0;
    private double passiveIncome = 0;


    //Inkrementiert Coins
    public double incrementCoins() {
        myCoins = myCoins + 1 * multipler;
        return myCoins;
    }

    public double getCoins() {
        return myCoins;
    }

    public double getMultipler() {
        return multipler;
    }

    public double increaseMultiplier() {
        this.multipler = multipler + 1;
        return multipler;
    }

    public void setMyCoins(double myCoins) {
        this.myCoins = myCoins;
    }

    public double incrementPassiveIncome() {
        this.passiveIncome = passiveIncome + 1;
        return passiveIncome;
    }

    public double getPassiveIncome() {
        return passiveIncome;
    }
}