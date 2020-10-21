package Wcer;

import Wcer.GUI.GUI;

import Wcer.Utils.Job;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import Wcer.Locations.WCLocs;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;


@ScriptManifest(author = "Bear", info = "It cuts AND banks!", name = "Bears F2P Woodcutter", version = 0, logo = "")
public class Wcer extends Script{

    public static Deque<Job> jobs = new LinkedList<>();
    private Job curJob = null;
    public GUI gui = new GUI(this);


    private long startTime;
    private long timeRan;

    public static boolean guiOpen;

    private int costOfItem;
    private int itemsMade;
    private double gpGained;
    private double totalGpGained;
    private int gpPerHour;
    private int totalGpPerHour;

    public Wcer() throws IOException {
    }

    @Override
    public void onMessage(Message m) {
        log("OnMessage");
        switch(m.getMessage()) {
            case "You get some logs.":
                itemsMade++;
                break;
            case "You catch some oak logs.":
                itemsMade++;
                break;
            case "You catch some willow logs.":
                itemsMade++;
                break;
            case "You catch some maple logs.":
                itemsMade++;
                break;
            case "You catch some yew logs.":
                itemsMade++;
                break;
            case "You catch some magic logs.":
                itemsMade++;
                break;
        }
    }

    @Override
    public void onStart() throws InterruptedException {
        log("OnStart");
        gui.setVisible(true);
        guiOpen = true;
        while(guiOpen){
            if(!gui.isShowing()){
                gui.setVisible(true);
            }
            sleep(random(200,800));
        }

        startTime = System.currentTimeMillis();
        //Code here will execute before the loop is started
        costOfItem = 5;//getPrice(1519).get();
        log("Cost of item: " + costOfItem);
        // Tracking a single skill
        getExperienceTracker().start(Skill.WOODCUTTING);

    }

    @Override
    public void onExit() {
        log("OnExit");
        if(gui != null) { // If the JFrame has been created
            gui.setVisible(false); // Hide it
            gui.dispose(); // Dispose
            log("Closing GUI");
        }
        gui.dispose();
    }


    @Override
    public int onLoop() throws InterruptedException {
        log("OnLoop");
        if(curJob != null) { // If the user has started the script
            log("Curjob != null");
            if (!curJob.isComplete()) {
                curJob.proceed();
                log("Proceeding");
            }
            else{
                curJob = null;
            }
        }
        else{
            if(!jobs.isEmpty()){
                log(jobs.size());
                curJob = jobs.poll();
                log("Polling");
            }
            else {
                stop();
            }
        }

        return random(500,700); //The amount of time in milliseconds before the loop starts over
    }

    @Override
    public void onPaint(Graphics2D g) {
        int xpGained = experienceTracker.getGainedXP(Skill.WOODCUTTING);
        int xpPerHour = experienceTracker.getGainedXPPerHour(Skill.WOODCUTTING);
        int levelsGained = experienceTracker.getGainedLevels(Skill.WOODCUTTING);

        gpGained = itemsMade * costOfItem;
        gpPerHour = (int)(gpGained / ((System.currentTimeMillis() - startTime) / 3600000.0D));
        totalGpPerHour = gpPerHour;
        timeRan = System.currentTimeMillis() - startTime;
        DecimalFormat df = new DecimalFormat("#");

        // Creating and setting a new font that is Open Sans, Bold and size 18
        Font font = new Font("Open Sans", Font.BOLD, 18);
        g.setFont(font);
        g.fillRect(0, 250, 515, 90);
        // Changing the size of the current font to size 18
        g.setFont(g.getFont().deriveFont(18.0f));

        // Drawing a rectangle
        //g.drawRect(100, 100 , 200, 200);
// Using a constant value
        g.setColor(Color.black);
       /* g.drawString("Current Woodcutting Level: " + skills.getStatic(Skill.WOODCUTTING), 5, 290);
        g.drawString("Levels Gained: " + levelsGained, 5, 310);
        g.drawString("XP Gained: " + formatXpVal(xpGained), 380, 290);
        g.drawString("XP/hr: " + formatXpVal(xpPerHour), 380, 310);
        g.drawString("" + df.format(totalGpPerHour) + " k/hr", 380, 330);*/
        g.drawString(formatTime(timeRan), 5, 330);
    }

    public final String formatTime(final long ms){
        long s = ms / 1000, m = s / 60, h = m / 60, d = h / 24;
        s %= 60; m %= 60; h %= 24;

        return d > 0 ? String.format("%02d:%02d:%02d:%02d", d, h, m, s) :
                h > 0 ? String.format("%02d:%02d:%02d", h, m, s) :
                        String.format("%02d:%02d", m, s);
    }

    private String formatXpVal(int val) {
        String ret;

        if(val > 1000) {
            ret = String.format("%.1fk", (double) val / 1000);
        } else {
            ret = String.valueOf(val);
        }

        return ret;
    }

    public final String formatValue(final int v){
        return (v > 1_000_000) ? String.format("%.2fm", (double) (v / 1_000_000)) :
                (v > 1000) ? String.format("%.1fk", (double) (v / 1000)) :
                        v + "";
    }

    private Optional<Integer> getPrice(int id){
        Optional<Integer> price = Optional.empty();

        try {
            URL url = new URL("http://api.rsbuddy.com/grandExchange?a=guidePrice&i=" + id);
            URLConnection con = url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            con.setUseCaches(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String[] data = br.readLine().replace("{", "").replace("}", "").split(",");
            br.close();
            price = Optional.of(Integer.parseInt(data[0].split(":")[1]));
        } catch(Exception e){
            e.printStackTrace();
        }
        return price;
    }


}
