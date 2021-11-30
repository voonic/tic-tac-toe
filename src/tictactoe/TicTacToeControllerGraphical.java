package tictactoe;

/**
 * A class the implements all the operations of the TicTacToeController to provide
 * graphical controls and input.
 */
public class TicTacToeControllerGraphical implements TicTacToeController {

  private final TicTacToe m;
  private final TicTacToeView view;

  /**
   * Initializes the tic-tac-toe graphical controller based on the model and view provided.
   *
   * @param m The model of the tic-tac-toe game
   * @param view The view of the game
   */
  public TicTacToeControllerGraphical(TicTacToe m, TicTacToeView view) {
    this.m = m;
    this.view = view;
    this.view.addClickListener(this);
  }
  
  @Override
  public void playGame() {
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    m.move(row, col);
  }
}
