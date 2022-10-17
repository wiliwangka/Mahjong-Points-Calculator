package model;

public class So implements Tile  {


    private int idNum;
    private String category;
    private boolean startShuntsu;



    public So (int idNum ){
        this.idNum = idNum;
        category = "So";
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
