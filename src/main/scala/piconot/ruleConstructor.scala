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
import picolib.semantics.MoveDirection
import scala.collection.mutable.ListBuffer
import picolib.semantics.RelativeDescription

case class botConstructionException(smth:String)  extends Exception;

/*
object botMaker {
  def when(unused: Any): ruleConstructor = {
    new ruleConstructor;
  }
}
* */

class ruleConstructor() {
	var initialState: Int = -1;
	var finalState: Int = -1; 
	var moveDirection: MoveDirection = null;
	var wallLocations: String = "";
	
	def state(a: Int): ruleConstructor = {
	  finalState = a;
	  var returnConstructor: ruleConstructor = new ruleConstructor;
	  returnConstructor.initialState = this.initialState;
	  returnConstructor.finalState = this.finalState;
	  returnConstructor.moveDirection = this.moveDirection;
	  returnConstructor.wallLocations = this.wallLocations;
	
	  this.initialState = -1;
	  this.finalState = -1; 
	  this.moveDirection = null;
	  this.wallLocations = "";
	  returnConstructor
	}
	
	def when(unused: Any): ruleConstructor = {
	  new ruleConstructor;
	}
	
	def is(initial: Int): ruleConstructor = {
	  if((initial < 0) || (initial > 100)) {
	    throw new botConstructionException("inital state not within allowed range");
	  }
	  initialState = initial;
	  finalState = initial;
	  this
	}
	
	def and(unused: Any) : ruleConstructor = {
	  this
	}
	
	def walls() : ruleConstructor = {
	  this
	}
	
	def are(inputWalls: String): ruleConstructor = {
	  wallLocations = inputWalls;
	  this
	}
	
	def then(unused: Any) : ruleConstructor = {
	  this
	}
	
	def moves(direction: MoveDirection): ruleConstructor = {
	  moveDirection = direction
	  var returnConstructor: ruleConstructor = new ruleConstructor;
	  returnConstructor.initialState = this.initialState;
	  returnConstructor.finalState = this.finalState;
	  returnConstructor.moveDirection = this.moveDirection;
	  returnConstructor.wallLocations = this.wallLocations;
	
	  this.initialState = -1;
	  this.finalState = -1; 
	  this.moveDirection = null;
	  this.wallLocations = "";
	  returnConstructor
	}
	
	def enter() : ruleConstructor = {
	  this
	}
	
	def the(unused: Any): ruleConstructor = {
	  this
	}
	/*
	def state(lastState: Int) : ruleConstructor =  {
	  finalState = lastState;
	  this
	}
	* 
	*/
	
	private def parseSurroundings(surroundingsString: String) : Surroundings = {
	  var north: RelativeDescription = Anything;
	  var south: RelativeDescription = Anything;
	  var east: RelativeDescription = Anything;
	  var west: RelativeDescription = Anything;
	  
	  if(wallLocations.contains("N")) {
	    north = Blocked
	  }
	  if(wallLocations.contains("!N")) {
	    north = Open
	  }
	  if(wallLocations.contains("E")) {
	    east = Blocked
	  }
	  if(wallLocations.contains("!E")) {
	    east = Open
	  }
	  if(wallLocations.contains("S")) {
	    south = Blocked
	  }
	  if(wallLocations.contains("!S")) {
	    south = Open
	  }
	  if(wallLocations.contains("W")) {
	    west = Blocked
	  }
	  if(wallLocations.contains("!W")) {
	    west = Open
	  }
	   
	  Surroundings(north, east, west, south)
	}
	
	def toRule : List[Rule] = {
	  var returnList: ListBuffer[Rule] = new ListBuffer[Rule];
	  
	  if(initialState == -1) {
	    for(i <- 0 to 99) {
	      returnList += Rule(State(i.toString), parseSurroundings(wallLocations), moveDirection, State(finalState.toString));
	    }
	    returnList.toList
	  }
	  else {
	    List(Rule(State(initialState.toString), parseSurroundings(wallLocations), moveDirection, State(finalState.toString)))
	  }
	  
	  
	}
	
}

object ruleConstructor {
  
}

