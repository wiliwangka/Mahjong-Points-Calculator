package model;

import java.util.Objects;

//Represents a Pin tile with it's id ,category, Shuntsu indicator and count
public class Pin implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;
    private boolean isInShuntsu;
    private int count;

    /*
     * REQUIRES: 1>= idNum >= 9
     * EFFECTS: construct an Pin tiles with id number count set to 0
     */
    public Pin(int idNum) {
        this.idNum = idNum;
        category = "Pin";
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
        Pin pin = (Pin) o;
        return idNum == pin.idNum && category.equals(pin.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNum, category);
    }
}
