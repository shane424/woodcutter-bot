package Wcer.Locations;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import java.util.ArrayList;


public enum WCLocs {
        LUMBRIDGE_EAST(new Area(
                new int[][]{
                        { 3236, 3272 },
                        { 3246, 3273 },
                        { 3252, 3253 },
                        { 3264, 3253 },
                        { 3266, 3218 },
                        { 3241, 3240 }
                }
        ),new String[]{"Tree", "Oak"}, "LUMBY_EAST_TO_BANK", "LUMBY_BANK_TO_EAST"),
        LUMBRIDGE_WEST(new Area(
                new int[][]{
                        { 3207, 3253 },
                        { 3205, 3243 },
                        { 3206, 3237 },
                        { 3201, 3237 },
                        { 3199, 3233 },
                        { 3184, 3240 },
                        { 3187, 3255 }
                }
        ),new String[]{ "Tree"},"LUMBY_WEST_TO_BANK", "LUMBY_BANK_TO_WEST"),
        /*EAST_DRAYNOR_VILLAGE(new Area(
                new int[][]{
                        {3149, 3258},
                        {3158, 3252},
                        {3165, 3257},
                        {3175, 3250},
                        {3201, 3236},
                        {3206, 3250},
                        {3192, 3255},
                        {3189, 3261},
                        {3181, 3267},
                        {3182, 3281},
                        {3171, 3284},
                        {3165, 3285}
                }
        ), "Tree", "Oak", "Willow"),*/
        DRAYNOR_VILLAGE(new Area(
                new int[][]{
                        { 3081, 3238 },
                        { 3091, 3235 },
                        { 3090, 3223 },
                        { 3088, 3226 },
                        { 3087, 3229 },
                        { 3085, 3233 },
                        { 3083, 3236 }
                }
        ), new String[]{"Willow"},"DRAYNOR_TO_BANK", "BANK_TO_DRAYNOR"),
    NORTH_DRAYNOR_VILLAGE(new Area(
            new int[][]{
                    { 3072, 3301 },
                    { 3078, 3310 },
                    { 3108, 3311 },
                    { 3108, 3299 },
                    { 3078, 3293 }
            }
    ),new String[]{"Tree", "Oak"},"NORTH_DRAYNOR_TO_BANK", "BANK_TO_NORTH_RAYNOR"),
    SOUTH_MONASTERY(new Area(
            new int[][]{
                    { 3038, 3467 },
                    { 3061, 3473 },
                    { 3068, 3443 },
                    { 3059, 3419 },
                    { 3040, 3423 },
                    { 3033, 3442 }
            }
    ),new String[]{"Tree", "Oak"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK"),
    VARROCK_EAST(new Area(
            new int[][]{
                    { 3276, 3430 },
                    { 3275, 3439 },
                    { 3272, 3450 },
                    { 3275, 3457 },
                    { 3283, 3451 },
                    { 3284, 3430 },
                    { 3286, 3409 },
                    { 3275, 3414 },
                    { 3279, 3421 },
                    { 3277, 3428 }
            }
    ),new String[]{"Tree", "Oak"},"VARROCK_EAST_TO_BANK", "BANK_TO_VARROCK_EAST"),
    VARROCK_WILDY_DITCH(new Area(
            new int[][]{
                    { 3272, 3519 },
                    { 3274, 3500 },
                    { 3237, 3503 },
                    { 3230, 3508 },
                    { 3228, 3509 },
                    { 3201, 3509 },
                    { 3197, 3518 }
            }
    ),new String[]{"Tree", "Oak"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK"),
    SOUTH_LUMBER_YARD(new Area(
            new int[][]{
                    { 3313, 3463 },
                    { 3309, 3488 },
                    { 3292, 3495 },
                    { 3288, 3485 },
                    { 3271, 3484 },
                    { 3271, 3498 },
                    { 3264, 3497 },
                    { 3264, 3472 },
                    { 3277, 3462 }
            }
    ),new String[]{"Tree", "Oak", "Yew"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK"),
    GRAND_EXCHANGE(new Area(
            new int[][]{
                    { 3165, 3512 },
                    { 3173, 3515 },
                    { 3189, 3514 },
                    { 3195, 3507 },
                    { 3188, 3497 },
                    { 3188, 3480 },
                    { 3185, 3474 },
                    { 3186, 3469 },
                    { 3145, 3468 },
                    { 3141, 3472 },
                    { 3141, 3482 },
                    { 3144, 3486 },
                    { 3143, 3491 },
                    { 3140, 3495 },
                    { 3140, 3511 },
                    { 3143, 3515 },
                    { 3155, 3515 },
                    { 3179, 3499 },
                    { 3182, 3487 },
                    { 3178, 3479 },
                    { 3158, 3475 },
                    { 3148, 3482 },
                    { 3147, 3497 },
                    { 3155, 3506 }
            }
    ),new String[]{"Tree", "Oak"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK"),
    SOUTH_GRAND_EXCHANGBE(new Area(
            new int[][]{
                    { 3145, 3457 },
                    { 3149, 3465 },
                    { 3171, 3455 },
                    { 3156, 3445 }
            }
    ),new String[]{"Tree"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK"),
        EDGEVILLE(new Area(3085, 3482, 3089, 3468
        ),new String[]{"Yew"},"LUMBY_BANK_TO_EAST", "LUMBY_EAST_TO_BANK");

    private Area area;
    private String[] treeNames;
    private String areaToBank;
    private String bankToArea;



    WCLocs(Area area, String[] treeNames, String areaToBank, String bankToArea) {
        this.area = area;
        this.treeNames = treeNames;
        this.areaToBank = areaToBank;
        this.bankToArea = bankToArea;
    }
    public Area getArea(){
        return area;
    }
    public String[] getTreeNames() {
        return treeNames;
    }
    public String getAreaToBank() {
        return areaToBank;
    }
    public String getBankToArea() {
        return bankToArea;
    }

}
