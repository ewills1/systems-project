public class TrackPack extends Product {

    private Type type; 

    enum Type {ANALOGUE, DCC_READY, DCC_FITTED, DCC_SOUND};

    public TrackPack(String productCode, String name, String brandName, int quantity, BigDecimal price, Type type) {
        super(productCode, name, brandName, quantity, price);
        this.Type = type;
    }
}