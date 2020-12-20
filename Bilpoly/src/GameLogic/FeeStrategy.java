package GameLogic;

enum FeeType {
    TUITION_FEE,
    DORM_FEE,
    BOOK_FEE,
    FOOD_FEE;
}

public class FeeStrategy implements PlaceStrategy {
    private final int FEE;
    private FeeType feeType;

    public FeeStrategy(int FEE, String type) {
        if (type.equals("tuition"))
            feeType = FeeType.TUITION_FEE;
        else if (type.equals("dorm"))
            feeType = FeeType.DORM_FEE;
        else if (type.equals("book"))
            feeType = FeeType.BOOK_FEE;
        else if (type.equals("food"))
            feeType = FeeType.FOOD_FEE;
        this.FEE = FEE;
    }

    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(-FEE);
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public int getFee() {
        return FEE;
    }
}
