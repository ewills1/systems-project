public class RollingStock extends Product{

private String era;
private Carriage carriage;
private Wagon wagon;

    enum Carriage {
        CORRIDOR_FIRST,
        CORRIDOR_SECOND,
        OPEN_FIRST,
        OPEN_SECOND,
        SLEEPER_CAR,
        BUFFET_CAR,
        COMPOSITE_BREAK_VAN,
        RESTAURANT_CAR,
        GENERAL_UTILITY_VAN,
        COMPOSITE_COACH,
        PULLMAN_VIP,
        POST_OFFICE_SORTING_VAN,
        BRAKE_SECOND,
        BRAKE_VAN,
        STANDARD_CLASS
    };

    enum Wagon {
        CATTLE_WAGON,
        HORSE_BOX_WAGON,
        PARCELS_VAN,
        16T_MINERAL_WAGON,
        6_PLANK_COAL_WAGON,
        8_PLANK_COAL_WAGON,
        20T_HOPPER_WAGON,
        21T_CLAM_BALLAST_WAGON
    };

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String era, Carriage carriage){
        super(productCode, name, brandName, quantity, price)
        this.era = era
        this.carriage = carriage
    }

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String era, Wagon wagon){
        super(productCode, name, brandName, quantity, price)
        this.era = era
        this.wagon = wagon
    }
}