package Wcer.Utils;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.map.constants.Banks;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import java.util.List;

public class Bank {

    private Script script;
    private Area area;

    public Bank(Script s/*, Area a*/) {
        script = s;
        //area = a;
    }

    public boolean openClosestBank() {
        if (script.bank.isOpen()) {
            script.bank.close();
            script.log(script);
        }

        RS2Object bankBooth = script.objects.closest("Bank Booth");
        if (bankBooth != null)
            if (bankBooth.getPosition().distance(script.myPosition()) < 10) {
                if (bankBooth.getPosition().distance(script.players.myPosition()) > 13) {
                    script.walking.webWalk(bankBooth.getPosition());
                }

                if (!bankBooth.isVisible()) {
                    script.camera.toEntity(bankBooth);
                }

                bankBooth.interact("Bank");

                try {
                    MethodProvider.sleep(MethodProvider.random(500, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (script.myPlayer().isMoving()) {
                    try {
                        MethodProvider.sleep(MethodProvider.random(100, 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    MethodProvider.sleep(MethodProvider.random(600, 800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (script.bank.isOpen())
                    return true;
                else
                    return false;
            } else {
                NPC banker = script.npcs.closest("Banker");
                if (banker != null) {
                    if (banker.getPosition().distance(script.players.myPosition()) > 13) {
                        script.walking.webWalk(banker.getPosition());
                    }

                    if (!banker.isOnScreen()) {
                        this.script.camera.toEntity(banker);
                    }

                    if (banker.hasAction("Use Bow String")) {
                        banker.interact("Use Bow String");
                    }

                    banker.interact("Bank");
                    try {
                        MethodProvider.sleep(MethodProvider.random(500, 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    while (script.myPlayer().isMoving()) {
                        try {
                            MethodProvider.sleep(MethodProvider.random(100, 500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        MethodProvider.sleep(MethodProvider.random(600, 800));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (script.bank.isOpen())
                        return true;
                    else
                        return false;
                }
            }
            return false;
        }



        /**
         * Utilizes the webWalk class to walk to an area
         *
         * @param bank - An area returned by the getClosestBank() method
         * @return True if we arrived in the bank, otherwise false
         */

        public boolean runToBank(Area bank){
            script.log("running to bank");
            //Paths()
            //script.walking.webWalk(bank.getRandomPosition());
            if(bank.contains(script.myPlayer()))
                return true;
            else
                return false;
        }

        /**
         * Gets the closest bank from your position and returns that Area object<br>
         * @return Area
         */

        public Area getClosestBank(){
            //this.script.log("BEFORE CHECKING!");
            Area closestBank = null;
            Area[] banks = {
                    Banks.AL_KHARID,
                    Banks.DRAYNOR,
                    Banks.EDGEVILLE,
                    Banks.FALADOR_EAST,
                    Banks.FALADOR_WEST,
                    Banks.VARROCK_EAST,
                    Banks.VARROCK_WEST,
                    Banks.CAMELOT,
                    Banks.CATHERBY,
                    Banks.ARDOUGNE_NORTH,
                    Banks.ARDOUGNE_SOUTH,
                    Banks.CANIFIS,
                    Banks.CASTLE_WARS,
                    Banks.DUEL_ARENA,
                    Banks.GNOME_STRONGHOLD,
                    Banks.LUMBRIDGE_UPPER
            };

            int l = banks.length;
            script.log("BEFORE CHECKING!");
            if(script.myPlayer() != null){
                Position p = script.myPosition();
                for(int i = 0; i < l; i++){
                    Area curBank = banks[i];
                    if(closestBank == null){
                        closestBank = curBank;
                    }
                    else{
                        if(curBank.getRandomPosition().distance(p) < closestBank.getRandomPosition().distance(p)){
                            closestBank = curBank;
                        }
                    }
                }
            }
            else{
                System.exit(1);
            }
            return closestBank;
        }

    public boolean depositAllFish(List<String> list)
    {
        if(list.isEmpty())
            return true;
        int count = list.size();
        for(int i = 0; i < count; i ++)
        {
            String item = list.get(i);
            if(script.inventory.contains("Raw " + item))
            {
                script.bank.deposit("Raw " + item, MethodProvider.random(28,60));
                continue;
            }
            else
            if(script.inventory.contains("Raw " + item + "s"))
            {
                script.bank.deposit("Raw " + item + "s", MethodProvider.random(28,60));
                continue;
            }
        }
        return true;
    }




    /*private enum BearsAIO.Util.Bank {
        DRAYNOR(Banks.DRAYNOR),
        AL_KHARID(Banks.AL_KHARID),
        LUMBRIDGE(Banks.LUMBRIDGE_UPPER),
        FALADOR_EAST(Banks.FALADOR_EAST),
        FALADOR_WEST(Banks.FALADOR_WEST),
        VARROCK_EAST(Banks.FALADOR_EAST),
        VARROCK_WEST(Banks.VARROCK_WEST),
        SEERS(Banks.CAMELOT),
        CATHERBY(Banks.CATHERBY),
        EDGEVILLE(Banks.EDGEVILLE),
        YANILLE(Banks.YANILLE),
        GNOME_STRONGHOLD(Banks.GNOME_STRONGHOLD),
        ARDOUNGE_NORTH(Banks.ARDOUGNE_NORTH),
        ARDOUNE_SOUTH(Banks.ARDOUGNE_SOUTH),
        CASTLE_WARS(Banks.CASTLE_WARS),
        DUEL_ARENA(Banks.DUEL_ARENA),
        PEST_CONTROL(Banks.PEST_CONTROL),
        CANIFIS(Banks.CANIFIS),
        BLAST_FURNACE(new Area(1949, 4956, 1947, 4958)),
        TZHAAR(Banks.TZHAAR);

        private final Area area;

        BearsAIO.Util.Bank(Area area) {
            this.area = area;
        }


    }

    public static Area closestTo(Entity e) {
        HashMap<BearsAIO.Util.Bank, Integer> distMap = new HashMap<BearsAIO.Util.Bank, Integer>();
        for (BearsAIO.Util.Bank b : BearsAIO.Util.Bank.values()) {
            distMap.put(b, e.getPosition().distance(b.area.getRandomPosition()));
        }
        HashMap<Integer, BearsAIO.Util.Bank> distMapSorted = sortByDistance(distMap);
        Area cBank = distMapSorted.values().toArray(new BearsAIO.Util.Bank[BearsAIO.Util.Bank.values().length])[0].area;
        return cBank;
    }

    private static <K, V extends Comparable<? super V>> HashMap<V, K> sortByDistance(Map<K, V> map) {
        HashMap<V, K> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();
        st.sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> result.put(e.getValue(), e.getKey()));
        return result;
    }*/

}