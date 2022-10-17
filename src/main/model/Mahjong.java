package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Mahjong {
private int score;
    public Mahjong (ArrayList<String> los ,int r, int p){
       HashSet<Tile> hand = losToMahjongHashset(los);
                    countTile(hand);

       ScoreCalculator newgame = new ScoreCalculator(hand , r,p);
        newgame.computeScore();
       this.score = newgame.getScore();
    }
    public HashSet<Tile> losToMahjongHashset(ArrayList<String> los){
        HashSet<Tile> myhands = new HashSet<>();
        for (String s : los ) {
            String[] part = s.split("(?<=\\D)(?=\\d)");
            String a =  part[0];
            int b = Integer.parseInt(part[1]);
            if (a.equals("s")){
                Tile sotsu = new So(b);
                myhands.add(sotsu);

            } else if (a.equals("p")) {
                Tile pintsu = new Pin(b);
                myhands.add(pintsu);

            }else if (a.equals("m")) {
                Tile mantsu = new Man(b);
                myhands.add(mantsu);

            }else if (a.equals("w")) {
                Tile wind = new Wind(b);
                myhands.add(wind);

            }else if (a.equals("h")) {
                Tile honor = new Honor(b);
                myhands.add(honor);

            }
        }
        return myhands;


    }
   public void countTile(HashSet<Tile> hand){
       for (Tile s : hand ){
           if (s.getCount() >= 1){
               hand.remove(s);
           s.increaseCount();}
           s.increaseCount();

       }
   }
    public int getScore(){
        return score;
    }
}
