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
import picolib.semantics.MoveDirection
import picolib.semantics.StayHere
import picolib.semantics.Surroundings
import picolib.semantics.TextDisplay
import picolib.semantics.West
import piconot.ruleConstructor._;
import scalafx.application.JFXApp



package object semantics{
  
  
  implicit class mazeConstructor(value: String) {
    val maze = Maze("resources" + File.separator + value);
  }
   
   def Make_bot(maze:mazeConstructor, initialRules:ruleConstructor*): Picobot with GUIDisplay = { 
     val finalRules :List[List[Rule]] = initialRules.toList.map(_.toRule);
     println(initialRules.toList)
     
     object EmptyBot extends Picobot(maze.maze, finalRules.flatten)
     with TextDisplay with GUIDisplay
     
     EmptyBot
   }
   
  
   val Nowhere: MoveDirection = StayHere
   val when: ruleConstructor = new ruleConstructor;
   val state:Int = 1;
   val walls:Int = 1;
   val bot:Int = 1;
   val enters:Int = 1;
}