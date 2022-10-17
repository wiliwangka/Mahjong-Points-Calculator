package model;

public class Wind implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;

    private int count;



    public Wind (int idNum ){
        this.idNum = idNum;
        category = "Wind";
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

    public int getCount()  {
        return count;}

    public void increaseCount() {
        count += 1;
    }

    public void decreaseCount()  {
        count -= 1;
    }
}
