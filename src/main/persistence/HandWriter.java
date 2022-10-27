package persistence;

import org.json.JSONArray;


import java.io.*;
import java.util.ArrayList;

//reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a writer that writes JSON representation of workroom to file
public class HandWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public HandWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer;
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(ArrayList<String> hand) {
        JSONArray json = toJson(hand);
        saveToFile(json.toString(TAB));
    }

    public JSONArray toJson(ArrayList<String> hand) {
        JSONArray jsArray = new JSONArray();
        for (int i = 0; i < hand.size(); i++) {
            jsArray.put(hand.get(i));
        }
        return jsArray;

    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

