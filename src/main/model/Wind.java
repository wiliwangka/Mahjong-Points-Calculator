package model;

import java.util.Objects;

//Represents a Wind tiles with it's id ,category, Shuntsu indicator and count
public class Wind implements Tile {
    private int idNum;
    private String category;

    private boolean isInShuntsu;


    private boolean startShuntsu;

    private int count;

    /*
     * REQUIRES: 1>= idNum >= 4
     * EFFECTS: construct a wind tiles with id number duplication count set to 0
     */
    public Wind(int idNum) {
        this.idNum = idNum;
        category = "Wind";
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

    public void setStartShuntsu(boolean b) {
        startShuntsu = b;
    }

    public void setInShuntsu(boolean b) {
        isInShuntsu = b;
    }

    public boolean isInShuntsu() {
        return isInShuntsu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wind wind = (Wind) o;
        return idNum == wind.idNum && category.equals(wind.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNum, category);
    }
}
