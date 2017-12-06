package snakePackage;
public class Box implements Constante {

      private int xIndex;
      private int yIndex;
      
      public Box(int xIndex, int yIndex) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
      }

      // setter for xIndex
      public void setXIndex(int x) {
            this.xIndex = x;
      }

      // getter for xIndex
      public int getXIndex() {
            return this.xIndex;
      }

      // setter for yIndex
      public void setYIndex(int y) {
            this.yIndex = y;
      }

      // getter for yIndex
      public int getYIndex() {
            return this.yIndex;
      }

      // horizontal coord
      public int getX() {
            return this.xIndex * BOXES_SIZE;
      }

      // vertical coord
      public int getY() {
            return this.yIndex * BOXES_SIZE;
      }

      public int getWidth() {
            return BOXES_SIZE;
      }

      public int getHight() {
            return BOXES_SIZE;
      }
      
   // verifies if the box is in the map (returns true if so)
      public boolean isValid() {
            return this.xIndex >= 0 && this.xIndex < COLUMNS_NUMBER
                   && this.yIndex >= 0 && this.yIndex < LINES_NUMBER;
      }
      
      @Override
      public boolean equals(Object obj) {
            if (obj instanceof Box) {
                  Box box = (Box) obj;
                  return this.xIndex == box.xIndex
                         && this.yIndex == box.yIndex;
            }
            return false;
      }
      
}