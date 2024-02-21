# Riichi Mahjong Points Calculator 🀄️
___

## Introduction 
___

Mahjong is a classic tile-based board game that usually requires 4 players to participate. The goal of the game is to
adjust the tiles in your hand into a specific combination through drawing and discarding tiles from the deck and called
Ron (win) before the other 3 players do.  Japanese style Mahjong or *Riichi* Mahjong is a variant of Mahjong that is 
commonly played in the UBC Mahjong Club. Unlike other variants of the Mahjong, *Riichi* has a very complicated pointing
system that sometimes even the experienced players can lose track of current points.I have always found it annoying 
when I under-count my points in a game especially when it makes me lose a game. However, with over 30 kinds of points 
combinations to check in *Riichi* , it's really easy to miss out on one of two kinds. Therefore ,I think an app that can
calculate the true worth of your hand will be really useful.

My goal for this project is to develop an app that can track and calculate points for a *Riichi* Mahjong game. This will
allow players to enjoy more of the game itself instead of worrying about under/ over counting their points.


## User Stories
___
- As a user, I want to add tile into a list of tiles that represent my winning hand
- As a user, I want to restart my tile enters if I made mistakes  
- As a user, I want to know how many yaku is my hand.
- As a user,I want to indicate my current position and wind of the round.
- As a user, I want to the calculater to recognize any yakuman and double yakuman hand composition
- As a user, I want to be able to restore my hand and calculate it's point later
- As a user, I want to add multiple tiles into my hand using graphical buttons 
- As a user, I want to save my finished/ half finished hand 
- As a user, I want to load my hand entries from the file I saved to from last round 
- As a user, I want to load sample hands into the calculator


## Instructions for Grader

---
- You can generate the first required event related to adding Xs to a Y by clicking on any one of the buttons
with a tile icons on it.  
- You can generate the second required event related to adding Xs to a Y by repeating the first step.
- You can locate my visual component by the icon of the add tiles button and the visualization of the added tiles 
 in the Opened tiles collection and Closed tiles collection.
- You can save the state of my application by first select tiles into your hand and click the Save button.
- You can reload the state of my application by click the load button or select on of the option from the sample hand 
and click load sample hand.
- after adding enough tile of tiplets (XXX), Kuntsu (XXXX), Shuntsu (X X+1 X+2) and a pair(XX) you may have 
at least 14 tiles in your hand and for every kuntsu your tiles limit increase by one and up to 18 tiles.
- You can press the calculate button of get the point for your hand.

### Phase 4: Task 2

---



Fri Dec 02 02:52:34 PST 2022
Event: select a sample hand


Fri Dec 02 02:52:34 PST 2022
Event: Added Tile h1 to hand

Fri Dec 02 02:52:34 PST 2022
Event: Added Tile m1 to hand

Fri Dec 02 02:52:35 PST 2022
Event: Added Tile w3 to hand

Fri Dec 02 02:52:35 PST 2022
Event: set wind to West

Fri Dec 02 02:52:35 PST 2022
Event: set position to East

Fri Dec 02 02:52:35 PST 2022
Event: Loaded sample hand from library

Fri Dec 02 02:52:38 PST 2022
Event: Save hand

Fri Dec 02 02:52:48 PST 2022
Event: Calculate hand

Fri Dec 02 03:21:08 PST 2022
Event: Score earned =28
hand contains:[Daisuushii 大四喜]


### Phase 4: Task 3

---
As a reflection of the structure of my classes,I came to realize that I don't really need a Tile interface to 
represent the variations of different tiles. As all my tile class that implement the Tile interface have 
 the same methods and fields, using a interface hierarchy forced me to implement every of the five class I have
for tile for basically identical methods. Perhapes a abstract class will be better for such a structure which I can 
just implement the tile super class for the rest of subclass to work. This would make my code cleaner and 
prevent alot of copying and pasting.



