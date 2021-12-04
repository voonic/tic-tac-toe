package tictactoe;

import static tictactoe.TicTacToeViewSpring.CELL_SIZE;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * A mouse adapter that listens for the clicks on the board game and converts
 * it into valid rows and cols.
 */
public class BoardMouseAdapter extends MouseAdapter {

  private final TicTacToeController controller;

  /**
   * Initialises the Mouse Adapter based on the controller object passed.
   *
   * @param controller The controller for handling input
   */
  public BoardMouseAdapter(TicTacToeController controller) {
    this.controller = controller;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    super.mouseClicked(e);
    int row = 0;
    if (e.getX() > CELL_SIZE && e.getX() <= (2 * CELL_SIZE)) {
      row = 1;
    } else if (e.getX() > (2 * CELL_SIZE) && e.getX() <= (3 * CELL_SIZE)) {
      row = 2;
    }
    int col = 0;
    if (e.getY() > CELL_SIZE && e.getY() <= (2 * CELL_SIZE)) {
      col = 1;
    } else if (e.getY() > (2 * CELL_SIZE) && e.getY() <= (3 * CELL_SIZE)) {
      col = 2;
    }
    controller.handleCellClick(row, col);
  }
}
