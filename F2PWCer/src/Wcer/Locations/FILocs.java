package Wcer.Locations;

import org.osbot.rs07.api.map.Area;


public enum FILocs {
    LUMBRIDGE_EAST(new Area(
            new int[][]{
                    {3239, 3253},
                    {3239, 3251},
                    {3240, 3240},
                    {3240, 3243}
            }
    ), "Lure", "Bait"),
    LUMBRIDGE_SOUTH(new Area(
            new int[][]{
                    {3245, 3156},
                    {3243, 3150},
                    {3241, 3149},
                    {3241, 3144},
                    {3198, 3202},
                    {3186, 3208},
                    {3161, 3207},
                    {3159, 3222},
                    {3162, 3236},
                    {3180, 3247}
            }
    ), "Net", "Bait");

    private Area area;
    private String[] fishingTypes;

    FILocs(Area area, String... treeNames) {
        this.area = area;
        this.fishingTypes = treeNames;
    }
    public Area getArea(){
        return area;
    }

    public String[] getFishingTypes() {
        return fishingTypes;
    }
}
