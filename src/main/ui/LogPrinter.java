package ui;

import model.Event;
import model.EventLog;

import java.util.ArrayList;
// a printer for log
public class LogPrinter {
    String logtext;

    // EFFECT construct a logPrinter object
    public LogPrinter() {

    }
    //Modify this
    // EFFECT convert Eventlog to String
    public String gatherlogtext(EventLog el) {
        for (Event next : el) {
            this.logtext += (next.toString() + "\n\n");
        }
        return logtext;

    }
}
