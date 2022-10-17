package model;

public class Honor implements Tile{
    private int idNum;
    private String category;
    private boolean startShuntsu;



    public Honor (int idNum ){
        this.idNum = idNum;
        category = "Honor";
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
