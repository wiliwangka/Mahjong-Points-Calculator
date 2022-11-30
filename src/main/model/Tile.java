package model;

//Represents a tile
public interface Tile {



    //EFFECTS: Returns the id number of the tile
    int getIdNum();

    //EFFECTS:Returns category of the tile
    String getCatergory();

    //EFFECTS:check if the tiles is the start of three consequtive tiles
    Boolean startOfShuntsu();

    //EFFECTS:Returns the number of times the tile appear
    int getCount();

    //EFFECTS: Increase the number of Counts
    void increaseCount();

    //EFFECTS:decrease the number of Counts
    void decreaseCount();

    void setStartShuntsu(boolean b);

    void setInShuntsu(boolean b);

    boolean isInShuntsu();

    int getInShuntsuCount();

    void increaseInShuntsuCount();

    int getstartofShuntsuCount();

    void increaseStartofShuntsuCount();

}
