package Wcer.Utils;

import Wcer.Utils.Paths;
import Wcer.Locations.WCLocs;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.map.constants.Banks;

import java.util.ArrayList;

public enum PathArrays {

        LUMBY_EAST_TO_BANK(//new Paths(
                new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
                new Position[] {
                    new Position(3263, 3233, 0),
                    new Position(3257, 3227, 0),
                    new Position(3247, 3226, 0),
                    new Position(3243, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3233, 3218, 0),
                    new Position(3223, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3213, 3227, 0)},
                new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
                new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
        WCLocs.LUMBRIDGE_EAST.getArea(), Banks.LUMBRIDGE_UPPER),
    LUMBY_BANK_TO_EAST(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3207, 3227, 0),
                    new Position(3213, 3227, 0),
                    new Position(3215, 3226, 0),
                    new Position(3215, 3218, 0),
                    new Position(3225, 3218, 0),
                    new Position(3230, 3218, 0),
                    new Position(3236, 3225, 0),
                    new Position(3246, 3225, 0),
                    new Position(3253, 3225, 0),
                    new Position(3259, 3228, 0)},
            new Position[] {
                    new Position(3207, 3228, 0),
                    new Position(3213, 3228, 0),
                    new Position(3215, 3226, 0),
                    new Position(3215, 3219, 0),
                    new Position(3225, 3219, 0),
                    new Position(3231, 3219, 0),
                    new Position(3235, 3225, 0),
                    new Position(3245, 3225, 0),
                    new Position(3253, 3225, 0),
                    new Position(3259, 3226, 0)},
            new Position[] {
                    new Position(3207, 3227, 0),
                    new Position(3215, 3227, 0),
                    new Position(3215, 3219, 0),
                    new Position(3225, 3219, 0),
                    new Position(3233, 3219, 0),
                    new Position(3233, 3224, 0),
                    new Position(3238, 3225, 0),
                    new Position(3248, 3226, 0),
                    new Position(3252, 3226, 0),
                    new Position(3258, 3226, 0)},
            new Position[] {
                    new Position(3207, 3227, 0),
                    new Position(3213, 3227, 0),
                    new Position(3215, 3226, 0),
                    new Position(3215, 3220, 0),
                    new Position(3215, 3218, 0),
                    new Position(3220, 3219, 0),
                    new Position(3225, 3219, 0),
                    new Position(3230, 3219, 0),
                    new Position(3232, 3220, 0),
                    new Position(3233, 3222, 0),
                    new Position(3234, 3224, 0),
                    new Position(3238, 3225, 0),
                    new Position(3242, 3225, 0),
                    new Position(3247, 3225, 0),
                    new Position(3251, 3225, 0),
                    new Position(3256, 3226, 0),
                    new Position(3258, 3228, 0)},
            WCLocs.LUMBRIDGE_EAST.getArea(), Banks.LUMBRIDGE_UPPER),
    LUMBY_WEST_TO_BANK(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            new Position[] {
                    new Position(3263, 3233, 0),
                    new Position(3257, 3227, 0),
                    new Position(3247, 3226, 0),
                    new Position(3243, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3233, 3218, 0),
                    new Position(3223, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3213, 3227, 0)},
            new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            WCLocs.LUMBRIDGE_WEST.getArea(), Banks.LUMBRIDGE_UPPER),
    LUMBY_BANK_TO_WEST(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3207, 3227, 0),
                    new Position(3210, 3227, 0),
                    new Position(3212, 3227, 0),
                    new Position(3215, 3227, 0),
                    new Position(3215, 3222, 0),
                    new Position(3215, 3219, 0),
                    new Position(3219, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3231, 3219, 0),
                    new Position(3233, 3222, 0),
                    new Position(3232, 3226, 0),
                    new Position(3227, 3230, 0),
                    new Position(3222, 3235, 0),
                    new Position(3216, 3239, 0),
                    new Position(3209, 3238, 0),
                    new Position(3199, 3238, 0)},
            new Position[] {
                    new Position(3207, 3228, 0),
                    new Position(3212, 3228, 0),
                    new Position(3213, 3227, 0),
                    new Position(3215, 3226, 0),
                    new Position(3215, 3223, 0),
                    new Position(3215, 3219, 0),
                    new Position(3219, 3218, 0),
                    new Position(3223, 3219, 0),
                    new Position(3229, 3219, 0),
                    new Position(3231, 3219, 0),
                    new Position(3232, 3227, 0),
                    new Position(3229, 3230, 0),
                    new Position(3227, 3234, 0),
                    new Position(3222, 3237, 0),
                    new Position(3217, 3242, 0),
                    new Position(3210, 3240, 0),
                    new Position(3206, 3241, 0),
                    new Position(3203, 3243, 0)},
            new Position[] {
                    new Position(3207, 3227, 0),
                    new Position(3210, 3227, 0),
                    new Position(3213, 3227, 0),
                    new Position(3215, 3226, 0),
                    new Position(3215, 3221, 0),
                    new Position(3215, 3218, 0),
                    new Position(3218, 3219, 0),
                    new Position(3224, 3219, 0),
                    new Position(3231, 3219, 0),
                    new Position(3235, 3222, 0),
                    new Position(3234, 3228, 0),
                    new Position(3225, 3232, 0),
                    new Position(3218, 3236, 0),
                    new Position(3211, 3238, 0),
                    new Position(3202, 3238, 0)},
            new Position[] {
                    new Position(3207, 3228, 0),
                    new Position(3210, 3227, 0),
                    new Position(3214, 3227, 0),
                    new Position(3215, 3225, 0),
                    new Position(3216, 3218, 0),
                    new Position(3225, 3218, 0),
                    new Position(3231, 3220, 0),
                    new Position(3232, 3224, 0),
                    new Position(3229, 3230, 0),
                    new Position(3221, 3235, 0),
                    new Position(3212, 3239, 0),
                    new Position(3207, 3240, 0),
                    new Position(3199, 3240, 0)},
            WCLocs.LUMBRIDGE_WEST.getArea(), Banks.LUMBRIDGE_UPPER),
    /*EAST_DRAYNOR_VILLAGE(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            new Position[] {
                    new Position(3263, 3233, 0),
                    new Position(3257, 3227, 0),
                    new Position(3247, 3226, 0),
                    new Position(3243, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3233, 3218, 0),
                    new Position(3223, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3213, 3227, 0)},
            new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            new Position[] {
                    new Position(3253, 3237, 0),
                    new Position(3254, 3227, 0),
                    new Position(3254, 3225, 0),
                    new Position(3244, 3225, 0),
                    new Position(3234, 3225, 0),
                    new Position(3234, 3218, 0),
                    new Position(3224, 3218, 0),
                    new Position(3215, 3218, 0),
                    new Position(3214, 3227, 0)},
            WCLocs.LUMBRIDGE_EAST.getArea(), Banks.LUMBRIDGE_UPPER),*/
    DRAYNOR_TO_BANK(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3087, 3235, 0),
                    new Position(3085, 3238, 0),
                    new Position(3086, 3243, 0),
                    new Position(3087, 3247, 0),
                    new Position(3091, 3247, 0),
                    new Position(3093, 3245, 0),
                    new Position(3092, 3243, 0)},
            new Position[] {
                    new Position(3085, 3240, 0),
                    new Position(3086, 3247, 0),
                    new Position(3089, 3247, 0),
                    new Position(3093, 3246, 0),
                    new Position(3091, 3242, 0)},
            new Position[] {
                    new Position(3087, 3239, 0),
                    new Position(3087, 3247, 0),
                    new Position(3093, 3247, 0),
                    new Position(3093, 3244, 0),
                    new Position(3091, 3243, 0)},
            new Position[] {
                    new Position(3084, 3238, 0),
                    new Position(3085, 3241, 0),
                    new Position(3086, 3244, 0),
                    new Position(3086, 3247, 0),
                    new Position(3090, 3247, 0),
                    new Position(3093, 3247, 0),
                    new Position(3093, 3245, 0),
                    new Position(3091, 3242, 0)},
            WCLocs.DRAYNOR_VILLAGE.getArea(), Banks.DRAYNOR),
    BANK_TO_DRAYNOR(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3093, 3244, 0),
                    new Position(3092, 3247, 0),
                    new Position(3090, 3247, 0),
                    new Position(3086, 3247, 0),
                    new Position(3086, 3244, 0),
                    new Position(3087, 3235, 0)},
            new Position[] {
                    new Position(3087, 3244, 0),
                    new Position(3087, 3237, 0),
                    new Position(3088, 3232, 0)},
            new Position[] {
                    new Position(3085, 3242, 0),
                    new Position(3086, 3238, 0),
                    new Position(3086, 3235, 0)},
            new Position[] {
                    new Position(3085, 3241, 0),
                    new Position(3087, 3236, 0)},
            WCLocs.DRAYNOR_VILLAGE.getArea(), Banks.DRAYNOR),
    NORTH_DRAYNOR_TO_BANK(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3087, 3248, 0),
                    new Position(3081, 3253, 0),
                    new Position(3082, 3260, 0),
                    new Position(3079, 3269, 0),
                    new Position(3078, 3271, 0),
                    new Position(3078, 3281, 0),
                    new Position(3078, 3283, 0),
                    new Position(3081, 3292, 0),
                    new Position(3083, 3298, 0)},
            new Position[] {
                    new Position(3087, 3249, 0),
                    new Position(3082, 3255, 0),
                    new Position(3080, 3264, 0),
                    new Position(3079, 3270, 0),
                    new Position(3079, 3276, 0),
                    new Position(3078, 3279, 0),
                    new Position(3079, 3286, 0),
                    new Position(3081, 3288, 0),
                    new Position(3087, 3296, 0),
                    new Position(3087, 3297, 0)},
            new Position[] {
                    new Position(3083, 3247, 0),
                    new Position(3082, 3256, 0),
                    new Position(3083, 3266, 0),
                    new Position(3083, 3266, 0),
                    new Position(3087, 3275, 0),
                    new Position(3087, 3276, 0),
                    new Position(3088, 3286, 0),
                    new Position(3088, 3288, 0),
                    new Position(3084, 3294, 0)},
            new Position[] {
                    new Position(3087, 3249, 0),
                    new Position(3081, 3257, 0),
                    new Position(3082, 3267, 0),
                    new Position(3084, 3277, 0),
                    new Position(3085, 3281, 0),
                    new Position(3088, 3291, 0),
                    new Position(3091, 3301, 0),
                    new Position(3091, 3303, 0)},
            WCLocs.NORTH_DRAYNOR_VILLAGE.getArea(), Banks.DRAYNOR),
    BANK_TO_NORTH_RAYNOR(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3083, 3292, 0),
                    new Position(3085, 3282, 0),
                    new Position(3085, 3280, 0),
                    new Position(3084, 3270, 0),
                    new Position(3083, 3265, 0),
                    new Position(3081, 3255, 0),
                    new Position(3086, 3248, 0),
                    new Position(3092, 3242, 0)},
            new Position[] {
                    new Position(3087, 3290, 0),
                    new Position(3087, 3284, 0),
                    new Position(3087, 3276, 0),
                    new Position(3082, 3267, 0),
                    new Position(3082, 3267, 0),
                    new Position(3082, 3261, 0),
                    new Position(3082, 3254, 0),
                    new Position(3086, 3250, 0),
                    new Position(3092, 3243, 0)},
            new Position[] {
                    new Position(3079, 3285, 0),
                    new Position(3080, 3275, 0),
                    new Position(3081, 3265, 0),
                    new Position(3082, 3255, 0),
                    new Position(3082, 3252, 0),
                    new Position(3091, 3248, 0),
                    new Position(3092, 3244, 0)},
            new Position[] {
                    new Position(3084, 3294, 0),
                    new Position(3084, 3284, 0),
                    new Position(3084, 3280, 0),
                    new Position(3082, 3270, 0),
                    new Position(3081, 3268, 0),
                    new Position(3081, 3262, 0),
                    new Position(3083, 3254, 0),
                    new Position(3087, 3249, 0),
                    new Position(3090, 3248, 0),
                    new Position(3091, 3245, 0)},
            WCLocs.NORTH_DRAYNOR_VILLAGE.getArea(), Banks.DRAYNOR),
    VARROCK_EAST_TO_BANK(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3275, 3431, 0),
                    new Position(3267, 3427, 0),
                    new Position(3260, 3427, 0),
                    new Position(3254, 3421, 0)},
            new Position[] {
                    new Position(3271, 3428, 0),
                    new Position(3261, 3428, 0),
                    new Position(3253, 3426, 0),
                    new Position(3252, 3420, 0)},
            new Position[] {
                    new Position(3276, 3432, 0),
                    new Position(3268, 3427, 0),
                    new Position(3258, 3428, 0),
                    new Position(3254, 3428, 0),
                    new Position(3253, 3419, 0)},
            new Position[] {
                    new Position(3278, 3428, 0),
                    new Position(3268, 3428, 0),
                    new Position(3266, 3428, 0),
                    new Position(3257, 3427, 0),
                    new Position(3253, 3421, 0)},
            WCLocs.VARROCK_EAST.getArea(), Banks.VARROCK_EAST),
    BANK_TO_VARROCK_EAST(//new Paths(
            new Position[] { //new Position[]{ new Position(x, y, z), new Position(x, y, z) })
                    new Position(3254, 3425, 0),
                    new Position(3262, 3426, 0),
                    new Position(3271, 3426, 0),
                    new Position(3279, 3431, 0)},
            new Position[] {
                    new Position(3256, 3426, 0),
                    new Position(3266, 3428, 0),
                    new Position(3266, 3428, 0),
                    new Position(3275, 3431, 0),
                    new Position(3277, 3438, 0)},
            new Position[] {
                    new Position(3254, 3424, 0),
                    new Position(3259, 3428, 0),
                    new Position(3267, 3429, 0),
                    new Position(3276, 3430, 0),
                    new Position(3281, 3434, 0)},
            new Position[] {
                    new Position(3254, 3426, 0),
                    new Position(3264, 3427, 0),
                    new Position(3264, 3427, 0),
                    new Position(3274, 3426, 0),
                    new Position(3276, 3426, 0),
                    new Position(3282, 3420, 0)},
            WCLocs.VARROCK_EAST.getArea(), Banks.VARROCK_EAST);//);

    private ArrayList<ArrayList<Position[]>> pathToTake;
    private Area bank;
    private Area location;

//    PathArrays(Area area, Area bank) {
//        this.location = area;
//        this.bank = bank;
//    }

    PathArrays(Position[] positions, Position[] positions1, Position[] positions2, Position[] positions3, Area area, Area bank) {
        this.location = area;
        this.bank = bank;
    }

/*bro I'm not understanding

you walk to the ladder &gt; interact with the ladder &gt; keep walking

it can't all happen in your walk event tho unless you use web walking

RS2Object ladder = objects.closest("Ladder");

Juggles
if thirdflor contains my player, click stairs

if second, click stairs

Bamboozled
if(ladder != null)

Juggles
if first, walk

Bamboozled
etc

BearJollyMan
I wasn't doing a walkingevent. That's why XD

I currently thought I could walk just from positions.

Bamboozled
you can

now just when the ladder is in site interact with it*/

    PathArrays(Paths paths) {
    }

    public ArrayList<ArrayList<Position[]>> getPath(){
        return pathToTake;
    }

    public Area getBankName() {
        return bank;
    }
    public Area getLocName() {
        return location;
    }

}
