package model;

public class Man implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;



    public Man (int idNum ){
        this.idNum = idNum;
        category = "Man";
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
