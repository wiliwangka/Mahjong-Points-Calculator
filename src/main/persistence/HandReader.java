package persistence;

//reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import org.json.JSONArray;
import org.json.JSONObject;
import ui.Mahjongapp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// import org.json.JSONArray;


// Represents a reader that reads workroom from JSON data stored in file
public class HandReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public HandReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;

    public Mahjongapp read() throws IOException {
        String jsonData = readFile(source);


        JSONObject jsonObject = new JSONObject(jsonData);
        return parseApp(jsonObject);


//
//        ArrayList<String> list = new ArrayList<String>();
//        JSONArray jsonArray = new JSONArray(jsonData);
//        int len = jsonArray.length();
//        for (int i = 0; i < len; i++) {
//            list.add(jsonArray.get(i).toString());
//        }
//
//        return list;
    }


    // EFFECTS: parses workroom from JSON object and returns it
    private Mahjongapp parseApp(JSONObject jsonObject) {
        int round = jsonObject.getInt("round");
        Mahjongapp app = new Mahjongapp();
        app.setRound(round);
        addposition(app, jsonObject);
        return app;
    }


    private void addposition(Mahjongapp app, JSONObject jsonObject) {
        int position = jsonObject.getInt("position");
        app.setPosition(position);
        addclosedhand(app, jsonObject);


    }

    private void addclosedhand(Mahjongapp app, JSONObject jsonObject) {


        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = jsonObject.getJSONArray("closedhand");
        int len = jsonArray.length();
        for (int i = 0; i < len; i++) {
            list.add(jsonArray.get(i).toString());
        }
        app.setClosedhand(list);
        addopenedhand(app, jsonObject);
    }


    private void addopenedhand(Mahjongapp app, JSONObject jsonObject) {


        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = jsonObject.getJSONArray("opnedhand");
        int len = jsonArray.length();
        for (int i = 0; i < len; i++) {
            list.add(jsonArray.get(i).toString());
        }
        app.setOpenedhand(list);

    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }
}

