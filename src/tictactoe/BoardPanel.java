package tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * A package private class that represents the tic-tac-toe board.
 */
class BoardPanel extends JPanel {
  private final ReadonlyTttModel rModel;

  BoardPanel(ReadonlyTttModel rModel) {
    this.rModel = rModel;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
  }
}
