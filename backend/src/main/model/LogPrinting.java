package model;

public class LogPrinting {

    // EFFECTS: print log of events so far on exit
    public static void printLog() {

        EventLog.getInstance()
                .logEvent(new Event("Exited"));

        for (Event next : EventLog.getInstance()) {
            System.out.println("" + next.toString() + "\n");
        }

    }
}
