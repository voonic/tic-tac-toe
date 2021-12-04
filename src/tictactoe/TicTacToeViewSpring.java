package tictactoe;

import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A view class that extends JFrame and implements all operations in TicTacToeView Interface.
 * This will be responsible for generating view and handling view interactions.
 */
public class TicTacToeViewSpring extends JFrame implements TicTacToeView {

  /**
   * The cell size of the tic-tac-toe game.
   */
  public static final int CELL_SIZE = 150;
  public static final int LABEL_SIZE = 100;
  private final BoardPanel board;

  /**
   * Creates a view based on the read only model for tic-tac-toe.
   *
   * @param rModel read only model for tic-tac-toe
   */
  public TicTacToeViewSpring(ReadonlyTttModel rModel) {
    super("Tic-Tac-Toe Game");
    int boardWidth = 3 * CELL_SIZE;
    int boardHeight = 3 * CELL_SIZE;
    setSize(boardWidth, boardHeight + LABEL_SIZE);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    board = new BoardPanel(rModel);
    getContentPane().add(board);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter mouseAdapter = new BoardMouseAdapter(listener);
    board.addMouseListener(mouseAdapter);
  }

  @Override
  public void alert(String message) {
    JOptionPane.showMessageDialog(this, message, "Oops!", JOptionPane.WARNING_MESSAGE);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
