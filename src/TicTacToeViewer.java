import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int BOARD_START = 150;

    private final int WINDOW_HEIGHT = 600;
    private final int WINDOW_WIDTH = 600;

    private TicTacToe tic;


    public TicTacToeViewer(TicTacToe tic) {
        this.tic = tic;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int start = 150;
        int add = 0;
        String numbers;


        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                this.tic.getBoard()[i][j].draw(g, BOARD_START);
            }
        }

        for(int k=0; k<3; k++) {
            numbers = String.valueOf(k);
            g.drawString(numbers, start + add + 50, start - 50);
            add+=100;
        }

        add = 0;

        for(int l=0; l<3; l++) {
            numbers = String.valueOf(l);
            g.drawString(numbers, start - 50, start + add + 50);
            add+=100;
        }

        if(tic.getWinner().equals("X")) {
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("X WINS", 200, 550 );
        }

        if(tic.getWinner().equals("O")) {
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("O WINS", 200, 550 );
        }

        if(tic.checkTie()) {
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("Its A Tie", 200, 550 );
        }
    }
}
