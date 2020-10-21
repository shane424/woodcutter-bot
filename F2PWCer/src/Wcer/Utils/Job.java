package Wcer.Utils;

public interface Job {
    void proceed() throws InterruptedException;
    boolean isComplete();
}
