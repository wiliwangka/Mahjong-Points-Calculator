package ui;

import model.Event;
import model.EventLog;

import java.util.ArrayList;

public class LogPrinter {
    String logtext;

    public LogPrinter() {

    }

    public String gatherlogtext(EventLog el) {
        for (Event next : el) {
            this.logtext += (next.toString() + "\n\n");
        }
        return logtext;

    }
}
