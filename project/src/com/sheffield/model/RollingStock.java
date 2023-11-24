package com.sheffield.model;
import java.math.BigDecimal;

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
        MINERAL_WAGON,
        PLANK_COAL_WAGON_6,
        PLANK_COAL_WAGON_8,
        HOPPER_WAGON,
        CLAM_BALLAST_WAGON
    };

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String era, Carriage carriage){
        super(productCode, name, brandName, quantity, price);
        this.era = era;
        this.carriage = carriage;
    }

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String era, Wagon wagon){
        super(productCode, name, brandName, quantity, price);
        this.era = era;
        this.wagon = wagon;
    }
}