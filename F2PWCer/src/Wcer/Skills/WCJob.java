package Wcer.Skills;

import Wcer.Locations.WCLocs;
import Wcer.Utils.Bank;
import Wcer.Utils.Job;

import Wcer.Utils.PathArrays;
import Wcer.Utils.Paths;
import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static org.osbot.rs07.script.MethodProvider.random;

public class WCJob implements Job {

    private long startTime;

    public Script script;
    public String tree;
    public String location;
    private int endLevel;
    public Area area;
    public WCLocs wcLocs;

    public boolean notInArea;
    public boolean isDropping;
    public boolean isBanking = false;
    public boolean isGoingToArea = false;
    Entity _Tree;// = null;
    List<Paths> ourPaths = new ArrayList<Paths>();
    Timer timer = new Timer();


    public WCJob(Script s, String t, String l, int lvl, boolean isDropping){
        script = s;
        tree = t;
        location = l;
        endLevel = lvl;
        this.isDropping = isDropping;
        script.log("IN: " + location);
        script.log("Tree: " + tree);
    }

//    public int getLvl(){
//
//        Levels lvls = new Levels(script);
//        int WClvl = lvls.getWClvl();
//
//        return WClvl;
//    }

    public Entity closestTree(Area ar){
        script.log(ar);
        Entity t = script.objects.closest(new Filter<RS2Object>() {
            @Override
            public boolean match(RS2Object object) {
                return object != null &&
                        (tree.equals(object.getName())) &&
                            ar.contains(script.myPlayer());// &&
                                //object.getPosition().distance(script.myPlayer().getPosition()) <= 5;
            }
        });
        script.log(t.exists());
        return t;
    }

    public Area getLoc(String name){
        Area a = null;
        for(int i = 0; i < WCLocs.values().length; i++){
            if(WCLocs.values()[i].toString().equals(name)) {
                a = wcLocs.values()[i].getArea();
                script.log("MATCHED");
            }
        }
        script.log(wcLocs.values()[1].getArea());
        script.log(wcLocs.values()[1].getArea().toString());
        script.log("AREA: " + a);
        return a;
    }

    /*public List<Integer> getTrees(){
        List<Integer> trees;

        if(tree == "Normal"){
            trees = Arrays.asList(678,1276,1277,1278,1280,1282,1283,1284,1285,1286,1287,1288,1289,1291);

        }
        else if(tree == "Oak"){
            trees = Arrays.asList(13413,13420,65940,65941,65942, 1751);
        }
        else if(tree == "Willow"){
            trees = Arrays.asList(8481,8482,8483,8484,8485,8486,8487,8488,13414,13421);
        }
        else if(tree == "Maple"){
            trees = Arrays.asList(1307,4674,8435,8436,8437,8438,8439,8440,8441,8442,8443,8444);
        }
        else if(tree == "Yew"){
            trees = Arrays.asList(8503,8504,8505,8506,8507,8508,8509,8510,8511,8512,8513);
        }
        else{
            trees = Arrays.asList(1306,8396,8397,8398,8399,8400,8401,8402,8403,8404,8405,8406,8407,8408,8409);
        }
        return trees;
    }*/


    public void walkToArea(){
        script.log("CASE WALK HAS STARTED");
        if(notInArea &&
                !script.myPlayer().isMoving() &&
                !script.myPlayer().isAnimating()){
            script.log("Not in the Area: Walking");
            //script.walking.webWalk((area.getRandomPosition()));
            script.walking.walkPath(PathArrays.
        }
        else if(/*(!area.contains(script.myPlayer()) ||*/
                (_Tree.getPosition().distance(script.myPlayer().getPosition()) > 5) &&
                        !script.myPlayer().isMoving() &&
                        !script.myPlayer().isAnimating()) { //  { walk to area }
            script.log("In the Area: walking");
            if(!area.contains(script.myPlayer()))
                script.walking.webWalk((area.getRandomPosition()));
            else{
                //_Tree = closestTree(area);
                script.log("Area contains player");
                script.log("distance from tree: " + script.myPlayer().getPosition().distance(_Tree.getPosition()));
                script.walking.walk(_Tree);
            }
            /*while(!area.contains(script.myPlayer())) {
                script.walking.webWalk((area.getRandomPosition()));
            }
            while(_Tree.getPosition().distance(script.myPlayer().getPosition()) > 5){
                //_Tree = closestTree(area);
                script.log("Area contains player");
                script.log("distance from tree: " + script.myPlayer().getPosition().distance(_Tree.getPosition()));
                script.walking.walk(_Tree);
            }*/
        }
        script.log("CASE WALK HAS ENDED");
    }

    public void chopTree() throws InterruptedException {
        area = getLoc(location);
        _Tree = closestTree(area);
        script.log("CASE CUT HAS STARTED");

        Position pos = _Tree.getPosition();
        script.log(startTime);
        //while (System.currentTimeMillis() > 3000) {
        script.log(startTime);
        _Tree.interact("Chop Down");
        script.sleep(random(700,1200));
        script.log("tree exists: " + _Tree.exists());
        script.log("CASE CUT HAS ENDED");
    }

    private enum State {
        CUT, DROP, WAIT, BANK, WALK
    };

    private State getState() {
        area = getLoc(location);
        if(area.contains(script.myPlayer())
        ) {
            notInArea = false;
            _Tree = closestTree(area);
        }
        else{
            notInArea = true;
        }
        if (script.inventory.isFull())      // if inventory is full, BANK
            return State.BANK;
        if (!notInArea && _Tree != null && !script.myPlayer().isAnimating() /*&& !script.myPlayer().isMoving()*/
                && area.contains(script.myPlayer())
                    && _Tree.getPosition().distance(script.myPlayer().getPosition()) <= 12){  // if tree is there, and player is not cutting and the player is not moving, CUT
            return State.CUT;
        }
        if(notInArea && //!area.contains(script.myPlayer()) &&
                !script.myPlayer().isAnimating() &&
                    !script.myPlayer().isMoving()){
                        //_Tree.getPosition().distance(script.myPlayer().getPosition()) > 5) { //if dist. to random pos of area > 4 and player is not animating/moving, WALK
            script.log("Not in area area");
            return State.WALK;
        }
        else if(!notInArea && //!area.contains(script.myPlayer()) &&
            !script.myPlayer().isAnimating() &&
                !script.myPlayer().isMoving() &&
                    _Tree.getPosition().distance(script.myPlayer().getPosition()) > 5) { //if dist. to random pos of area > 4 and player is not animating/moving, WALK
            script.log("In area area");
            return State.WALK;
        }
        //script.log(_Tree.getPosition().distance(script.myPlayer().getPosition()));
        return State.WAIT;
    }


    public void proceed() throws InterruptedException {
        script.log("area");
        Bank banking = new Bank(script);
        area = getLoc(location);
        //if(area.contains(script.myPlayer()))
        //    _Tree = closestTree(area);
        switch (getState()) {
            case CUT:
                chopTree();
                break;
            case DROP:
                script.log("CASE DROP HAS STARTED");
                script.inventory.dropAllExcept("Bronze axe");
                script.log("CASE DROP HAS ENDED");
                break;
            case WAIT:
                script.log("CASE WAIT HAS STARTED");
//                tree = script.objects.closest(new Filter<RS2Object>() {
//                    @Override
//                    public boolean match(RS2Object object) {
//                        return object != null &&
//                                (trees.contains(object.getId()) &&
//                                        area.contains(script.myPlayer()) &&
//                                            tree.getPosition().distance(script.myPlayer().getPosition()) > 5);
//                    }
//                });
                while((script.myPlayer().isAnimating() || script.myPlayer().isMoving()) && _Tree.isVisible()) {
                    script.log("waiting");
                    script.sleep(random(220, 450));
                }
                script.log("tree exists: " + "test"); //Tree becomes false once cut.
                script.log("CASE WAIT HAS ENDED");
                break;
            case WALK:
                walkToArea();
                break;
            case BANK:
                script.log("CASE BANK HAS STARTED");
                isBanking = true;
                isGoingToArea = false;
                script.log(banking.getClosestBank().toString());
                boolean inBank = banking.runToBank(banking.getClosestBank());
                    if (inBank) {
                        script.log("inbank");
                        Entity banker = script.objects.closest("Bank booth");
                        if (banker != null) {
                            script.log("banker is not null");
                            banker.interact("Bank");
                            script.sleep(random(1000, 3700));
                            script.bank.depositAllExcept("Bronze axe","Iron axe","Steel axe","Black axe","Mithril axe","Adamant axe", "Rune axe");
                            script.bank.close();
                        }
                    }
                    if(script.inventory.isEmpty()){
                        isBanking = false;
                    }
                //}
                script.log("CASE BANK HAS ENDED");
                break;
        }
    }

    public boolean isComplete(){
        return script.skills.getDynamic(Skill.WOODCUTTING) >= endLevel;
    }

}