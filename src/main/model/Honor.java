package model;

import java.util.Objects;

//Represents an honor tiles with it's id ,category, Shuntsu indicator and count
public class Honor implements Tile {
    private int idNum;
    private String category;
    private boolean startShuntsu;

    private boolean isInShuntsu;

    private int count;

    private int inShuntsuCount;
    private int startShuntsuCount;

    /*
     * REQUIRES: 1>= idNum >= 3
     * EFFECTS: construct an honor tiles with id number count set to 0
     */
    public Honor(int idNum) {
        this.idNum = idNum;
        category = "Honor";
        startShuntsu = false;
        count = 0;
        inShuntsuCount = 0;
        startShuntsuCount = 0;
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

    public int getInShuntsuCount() {
        return inShuntsuCount;
    }

    public void increaseInShuntsuCount() {
        inShuntsuCount += 1;
    }

    public int getstartofShuntsuCount() {
        return startShuntsuCount;
    }

    public void increaseStartofShuntsuCount() {
        startShuntsuCount += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Honor honor = (Honor) o;
        return idNum == honor.idNum && category.equals(honor.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNum, category);
    }
}
