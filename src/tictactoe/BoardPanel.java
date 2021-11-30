package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * A package private class that represents the tic-tac-toe board.
 */
class BoardPanel extends JPanel {
  private final ReadonlyTttModel rModel;
  private final Color primaryColor;

  BoardPanel(ReadonlyTttModel rModel) {
    this.rModel = rModel;
    this.primaryColor = Color.decode("#1E3F66");
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(primaryColor);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.white);
    //Add four divider baselines
    drawBaselines(g2d);
    drawMoves(g2d);
    drawStatus(g2d);
  }

  private void drawMoves(Graphics2D g2d) {
    int gutter = 30;
    int fontSize = 120;
    g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        Player mark = rModel.getMarkAt(row, col);
        if (mark != null) {
          g2d.drawString(String.format("%s", mark),
                  (row * TicTacToeViewSpring.CELL_SIZE) + gutter,
                  (col * TicTacToeViewSpring.CELL_SIZE) + fontSize);
        }
      }
    }
  }

  private void drawBaselines(Graphics2D g2d) {
    int gutter = 10;
    g2d.drawLine(TicTacToeViewSpring.CELL_SIZE, gutter,
            TicTacToeViewSpring.CELL_SIZE, (3 * TicTacToeViewSpring.CELL_SIZE) - gutter);
    g2d.drawLine(TicTacToeViewSpring.CELL_SIZE * 2, gutter,
            TicTacToeViewSpring.CELL_SIZE * 2, (3 * TicTacToeViewSpring.CELL_SIZE) - gutter);
    g2d.drawLine(gutter, TicTacToeViewSpring.CELL_SIZE,
             (3 * TicTacToeViewSpring.CELL_SIZE) - gutter, TicTacToeViewSpring.CELL_SIZE);
    g2d.drawLine(gutter, TicTacToeViewSpring.CELL_SIZE * 2,
            (3 * TicTacToeViewSpring.CELL_SIZE) - gutter, TicTacToeViewSpring.CELL_SIZE * 2);
  }

  private void drawStatus(Graphics2D g2d) {
    int boardHeight = 3 * TicTacToeViewSpring.CELL_SIZE;
    g2d.setFont(new Font("TimesRoman", Font.PLAIN, 24));
    int statusXPosition = 10;
    int statusYPosition = boardHeight + 40;
    if (!rModel.isGameOver()) {
      g2d.drawString(String.format("Enter the move for %s", rModel.getTurn()),
              statusXPosition, statusYPosition);
    } else {
      Player winner = rModel.getWinner();
      if (winner != null) {
        g2d.drawString(String.format("Game is over! %s wins.", winner),
                statusXPosition, statusYPosition);
      } else {
        g2d.drawString("Game is over! Tie game.", statusXPosition, statusYPosition);
      }
    }
  }
}
