package piconot

import java.io.File
import picolib.maze.Maze
import picolib.semantics.Anything
import picolib.semantics.Blocked
import picolib.semantics.East
import picolib.semantics.GUIDisplay
import picolib.semantics.North
import picolib.semantics.Open
import picolib.semantics.Picobot
import picolib.semantics.Rule
import picolib.semantics.South
import picolib.semantics.State
import picolib.semantics.Surroundings
import picolib.semantics.TextDisplay
import picolib.semantics.West
import picolib.semantics.StayHere
import piconot.ruleConstructor._;
import piconot.semantics._;
import scalafx.application.JFXApp

object rightHand extends JFXApp{
  
   implicit class setStage(bot: Picobot with GUIDisplay) {
    stage = bot.mainStage
   }

   /*
    * USER WRITTEN CODE GOES HERE
    */
   
   
   Make_bot("maze.txt", 
       when the state is 0 and walls are "!E" then bot moves East,   
       when the state is 0 and walls are "E" then bot moves Nowhere and enters state 1,
       when the state is 1 and walls are "!E" then bot moves East and enters state 4,
       when the state is 1 and walls are "EN" then bot moves Nowhere and enters state 2,
       when the state is 1 and walls are "E!N" then bot moves North,
       when the state is 2 and walls are "!N" then bot moves North and enters state 1,
       when the state is 2 and walls are "NW" then bot moves Nowhere and enters state 3,
       when the state is 2 and walls are "!WN" then bot moves West,
       when the state is 3 and walls are "!W" then bot moves West and enters state 2,
       when the state is 3 and walls are "WS" then bot moves Nowhere and enters state 4,
       when the state is 3 and walls are "!SW" then bot moves South,
       when the state is 4 and walls are "!ES" then bot moves East,    
       when the state is 4 and walls are "ES" then bot moves Nowhere and enters state 1,
       when the state is 4 and walls are "!S" then bot moves South and enters state 3)
    
  
}
