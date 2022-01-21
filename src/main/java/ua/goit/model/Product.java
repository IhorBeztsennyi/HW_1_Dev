package ua.goit.model;

public class Product {
    private final char name;
    private final double pricePerOne;
    private final int promotionAmount;
    private final double promotionPrice;

    public Product(char name, double pricePerOne, int promotionAmount, double promotionPrice) {
        this.name = name;
        this.pricePerOne = pricePerOne;
        this.promotionAmount = promotionAmount;
        this.promotionPrice = promotionPrice;
    }

    public char getName() {
        return name;
    }

    public double getPricePerOne() {
        return pricePerOne;
    }

    public int getPromotionAmount() {
        return promotionAmount;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

}
