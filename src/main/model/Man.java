package model;

public class Man implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;

    private int count;


    public Man(int idNum) {
        this.idNum = idNum;
        category = "Man";
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
}
