package circus.stuff;

import circus.Assets;

public abstract class Equipment implements Assets {
    protected int purchasePrice;

    public Equipment(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getValue() {
        return purchasePrice;
    }
}
