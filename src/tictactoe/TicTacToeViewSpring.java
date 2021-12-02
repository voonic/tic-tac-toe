package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    MouseAdapter mouseAdapter = new MouseAdapter() {
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
        try {
          listener.handleCellClick(row, col);
          refresh();
        } catch (IllegalArgumentException | IllegalStateException ex) {
          alert(ex.getMessage());
        }
      }
    };
    board.addMouseListener(mouseAdapter);
  }

  private void alert(String message) {
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
