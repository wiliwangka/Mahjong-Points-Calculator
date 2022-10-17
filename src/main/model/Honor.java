package model;

//Represents an honor tiles with it's id ,category, Shuntsu indicator and count
public class Honor implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;

    private int count;

    /*
     * REQUIRES: 1>= idNum >= 3
     * EFFECTS: construct an honor tiles with id number count set to 0
     */
    public Honor(int idNum) {
        this.idNum = idNum;
        category = "Honor";
        startShuntsu = false;
        count = 0;
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

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count += 1;
    }

    public void decreaseCount() {
        count -= 1;
    }

    public boolean isStartShuntsu() {
        return startShuntsu;
    }
}
