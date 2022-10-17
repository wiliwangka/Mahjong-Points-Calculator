package model;

public class Pin implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;



    public Pin (int idNum ){
        this.idNum = idNum;
        category = "Pin";
        startShuntsu = false;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getCatergory() {
        return category;
    }

    public Boolean startOfShuntsu() {
        return startShuntsu;
    }
}
