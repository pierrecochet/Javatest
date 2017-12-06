package snakePackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Model {

	private Snake snake;
	private boolean gameover;
	private Frog frog;
	
	public Model() {
        this.snake = new Snake();
        this.gameover = false;
        this.frog = new Frog();
  }
	
	public void gestionDuClavier(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) { // right arrow
            this.snake.setNextKeystroke(Direction.RIGHT);
      } else if (event.getKeyCode() == KeyEvent.VK_LEFT) { // left arrow
            this.snake.setNextKeystroke(Direction.LEFT);
      } else if (event.getKeyCode() == KeyEvent.VK_UP) { // up arrow
            this.snake.setNextKeystroke(Direction.TOP);
      } else if (event.getKeyCode() == KeyEvent.VK_DOWN) { // down arrow
            this.snake.setNextKeystroke(Direction.DOWN);
      }
  }
	
	private int getNiveau() {
	      return (this.snake.getEatCount() / 5) + 1;
	}
	
      // Call of all the calculation functions
      public void calculation() {
    	  if (!this.gameover) {
              this.frog.calculation();
              this.snake.calculation(this.frog, getNiveau());
              if (this.snake.isDead()) {
                    this.gameover = true;
              }
        }
      }
      
      // Display of the graphical element on the game map
      public void display(Graphics g) {
          this.snake.display(g);
          this.frog.display(g);
          if (this.gameover) {
              String str = "game over";
              String str1 = "Score : ";
              g.setColor(Color.RED);
              g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
              FontMetrics fm = g.getFontMetrics();
              int x = (g.getClipBounds().width - fm.stringWidth(str)) / 2;
              int y = (g.getClipBounds().height / 2) + fm.getMaxDescent();
              //int x1 = (g.getClipBounds().width - fm.stringWidth(str1)) / 2;
              g.drawString(str, x, y);
//              g.setColor(Color.BLUE);
//              g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
//              g.drawString(str1, x1, y);
        }
       // score board
          g.setColor(Color.BLUE);
          g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
          g.drawString("Level : "+String.valueOf(getNiveau()), 5, 25);
          g.drawString("Score : "+String.valueOf(this.snake.getEatCount()), g.getClipBounds().width - 120, 25);
      }
      
}