package snakePackage;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;

public class Snake {

      private LinkedList<Box> list;
      private Direction direction;
      private boolean isDead;
      private Direction direc;
      private int eatCount;
      private int moveCounter;
      
      public Snake() {
            this.list = new LinkedList<Box>();
            this.list.add(new Box(14, 15));
            this.list.add(new Box(15, 15));
            this.list.add(new Box(16, 15));
            this.direction = Direction.LEFT;
      }
      
      public void setNextKeystroke(Direction direc) {
          this.direc = direc;
    }
      
      private void turn() {
          if (this.direc != null) {
                if (this.direction == Direction.TOP
                            || this.direction == Direction.DOWN) {
                      if (this.direc == Direction.RIGHT) {
                            this.direction = Direction.RIGHT;
                      } else if (this.direc == Direction.LEFT) {
                            this.direction = Direction.LEFT;
                      }
                } else {
                      if (this.direc == Direction.TOP) {
                            this.direction = Direction.TOP;
                      } else if (this.direc == Direction.DOWN) {
                            this.direction = Direction.DOWN;
                      }
                }
                //The cache get cleared for the next keystroke
                this.direc = null;
          }
    }
      
      private void move() {
          // Adding a ball at the head of the snake
          this.list.addFirst(getNextcase());
          //remove one at the end of the snake to simulate the movement
          this.list.removeLast();
    }
      
      private Box getNextcase() {
          Box head = this.list.getFirst();
          switch (this.direction) {
                case TOP:
                      return new Box(head.getXIndex(), head.getYIndex() - 1);
                case RIGHT:
                      return new Box(head.getXIndex() + 1, head.getYIndex());
                case DOWN:
                      return new Box(head.getXIndex(), head.getYIndex() + 1);
                case LEFT:
                      return new Box(head.getXIndex() - 1, head.getYIndex());
          }
          return null;
    }
      
      private boolean canMove() {
    	  Box nextCase = getNextcase();
          return nextCase.isValid() && !this.list.contains(nextCase);
    }
      
      public boolean isDead() {
          return this.isDead;
    }
     
      private boolean canEat(Frog frog) {
          return frog.equals(getNextcase());
    }
      
      private void eat() {
          //add a box
          this.list.addFirst(getNextcase());
       //add one to the counter
          this.eatCount++;
    }
      
      public int getEatCount() {
          return this.eatCount;
    }
    //speed of the snake dependent on the level in game.
    //It's like a timer before each animation of the snake, the higher the
    //level will be the lower the laps between each animation will be (so the snake will go faster)
      private int getThresholdCounter(int level) {
          switch (level) {
                case 1:
                      return 20;
                case 2:
                      return 16;
                case 3:
                      return 14;
                case 4:
                      return 12;
                case 5:
                      return 10;
                case 6:
                      return 8;
                case 7:
                      return 6;
                case 8:
                      return 4;
                case 9:
                      return 3;
                default :
                      return 2;
          }
    }
      
      public void calculation(Frog frog, int level) {
          this.moveCounter++;
          // verify if it's time to animate the snake
          if (this.moveCounter >= getThresholdCounter(level)) { 
                this.moveCounter = 0;
                // look at the direction to go
                turn();
                //look if there is no apple in front of him
                if (canEat(frog)) {
                      eat();
                      frog.newFrog();
                } else if (canMove()) {
                      move();
                } else {
                      //if the snake can't move the game is over
                      this.isDead = true;
                }
          }
      }
      
      
      public void display(Graphics g) {
    	  // activating an anti-aliasing to improve the display (to soften the edges of the objects)
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
            //creation of the snake
    	  for (Box box : this.list) {
    		  g.setColor(Color.GREEN);
              g.fillOval(box.getX(), box.getY(), box.getWidth(), box.getHight());
        }
      }
      
}

