package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 * A view class that extends JFrame and implements all operations in TicTacToeView Interface.
 * This will be responsible for generating view and handling view interactions.
 */
public class TicTacToeViewSpring extends JFrame implements TicTacToeView {

  private BoardPanel board;

  /**
   * Creates a view based on the read only model for tic-tac-toe.
   * @param rModel read only model for tic-tac-toe
   */
  public TicTacToeViewSpring(ReadonlyTttModel rModel) {
    super("Tic-Tac-Toe Game");
    setSize(600, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    board = new BoardPanel(rModel);
    add(board);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter mouseAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(e.getX() + ":" + e.getY());
      }
    };
    board.addMouseListener(mouseAdapter);
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
