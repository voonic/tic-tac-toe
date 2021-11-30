package tictactoe;

import java.awt.*;

import javax.swing.*;

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
    setBackground(Color.decode("#1E3F66"));
    int boardWidth = 3 * TicTacToeViewSpring.CELL_SIZE;
    int boardHeight = 3 * TicTacToeViewSpring.CELL_SIZE;
    JPanel gameCanvas = new JPanel();
    gameCanvas.setSize(boardWidth, boardHeight);
    gameCanvas.setBackground(Color.decode("#E8E8E8"));

//    JPanel statusPanel = new JPanel();
//    statusPanel.setSize(boardWidth, TicTacToeViewSpring.LABEL_SIZE);
//    statusPanel.setBackground(Color.decode("#1E3F66"));
//    statusPanel.setLocation(0, boardHeight);

    add(gameCanvas);
    //add(statusPanel);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.white);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
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
