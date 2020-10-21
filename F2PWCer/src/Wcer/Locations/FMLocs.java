package Wcer.Locations;

import org.osbot.rs07.api.map.Area;


public enum FMLocs {
    GRANDEXCHANGE(new Area(
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
    LUMBRIDGE_WEST(new Area(
            new int[][]{
                    {3197, 3431},
                    {3198, 3429},
                    {3200, 3429},
                    {3195, 3430}
            }
    )),
    DRAYNOR_VILLAGE(new Area(
            new int[][]{
                    {3089, 3248},
                    {3090, 3249},
                    {3093, 3249}
            }
    )),
    VARROCK_EAST(new Area(
            new int[][]{
                    {3257, 3429},
                    {3256, 3429},
                    {3257, 3430}
            }
    ));

    private Area area;
    //private String[] treeNames;

    FMLocs(Area area) {
        this.area = area;
        //this.treeNames = treeNames;
    }
    public Area getArea(){
        return area;
    }

    /*public String[] getTreeNames() {
        return treeNames;
    }*/
}
