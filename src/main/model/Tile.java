package model;

public interface Tile {
    int getIdNum();

    String getCatergory();

    Boolean startOfShuntsu();

    int getCount();

    void increaseCount();

    void decreaseCount();


}
