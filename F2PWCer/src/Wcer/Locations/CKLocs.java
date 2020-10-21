package Wcer.Locations;

import org.osbot.rs07.api.map.Area;


public enum CKLocs {
    ALKHARID(new Area(
            new int[][]{
                    {3244, 3278},
                    {3234, 3273},
                    {3242, 3263},
                    {3242, 3240},
                    {3250, 3227},
                    {3258, 3231},
                    {3263, 3214},
                    {3266, 3214},
                    {3267, 3225},
                    {3264, 3254},
                    {3252, 3253},
                    {3250, 3272}
            }
    )),
    TOPLUMBY(new Area(
            new int[][]{
                    {3207, 3251},
                    {3207, 3237},
                    {3201, 3237},
                    {3199, 3233},
                    {3198, 3202},
                    {3186, 3208},
                    {3161, 3207},
                    {3159, 3222},
                    {3162, 3236},
                    {3180, 3247}
            }
    ), "TBox"),
    EDGEVILLE(new Area(
            new int[][]{
                    {3086, 3239},
                    {3082, 3237},
                    {3088, 3225},
                    {3092, 3227},
                    {3091, 3235}
            }
    )),
    VARROCK_EAST(new Area(
            new int[][]{
                    {3286, 3409},
                    {3277, 3408},
                    {3274, 3411},
                    {3274, 3419},
                    {3277, 3419},
                    {3277, 3427},
                    {3274, 3427},
                    {3274, 3438},
                    {3271, 3438},
                    {3271, 3457},
                    {3279, 3459},
                    {3286, 3437}
            }
    ));

    private Area area;
    private String[] itemsNeeded;

    CKLocs(Area area, String... treeNames) {
        this.area = area;
        this.itemsNeeded = treeNames;
    }
    public Area getArea(){
        return area;
    }

    public String[] getItemsNeeded() {
        return itemsNeeded;
    }
}
