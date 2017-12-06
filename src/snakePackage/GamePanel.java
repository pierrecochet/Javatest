package snakePackage;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JFrame implements Constante {

	private Model model;
	
      public GamePanel() {
            super("2D Snake");
            this.model = new Model();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            final JPanel content = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                      super.paintComponent(g);
                      GamePanel.this.model.display(g);
                }
          };
       // listener that handle the keystrokes
          content.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                      GamePanel.this.model.gestionDuClavier(e);
                }
          });
            // dimension of the window adapted to the number of column and lines
            content.setPreferredSize(new Dimension(
            		COLUMNS_NUMBER * BOXES_SIZE,
                    LINES_NUMBER * BOXES_SIZE));
            setFocusable(false);
            content.setFocusable(true);
            setContentPane(content);
            Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        while (true) {
                        	//call the calculation method that handle all the others
                            GamePanel.this.model.calculation();
                         //update the content
                            content.repaint();
                            try {
                                  Thread.sleep(DELAY);
                            } catch (InterruptedException e) {
                            }
                        }
                  }
            });
            thread.start();
      }
      
}