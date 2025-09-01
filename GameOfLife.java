import java.util.Random;

public class GameOfLife {

    private boolean[][] lfgame;

    // Constructors - בנאים
    public GameOfLife(int size) {
        this.lfgame = new boolean[size + 2][size + 2];
        Random rand = new Random();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                this.lfgame[i][j] = rand.nextBoolean();
            }
        }
    }

    // Copy Constructor - בנאי מעתיק
    // קבלת מטריצה והעתקתה
    public GameOfLife(GameOfLife lfgm) {
        int n = lfgm.lfgame.length;
        this.lfgame = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.lfgame[i][j] = lfgm.lfgame[i][j];
            }
        }
    }

    // Set + Get - קביעה ואיחזור
    public int getMatrixLength() {
        return lfgame.length; // בהתחלה הורדתי 2 מהאורך (על מנת לקבל את את האורך הרלוונטי, אך התוכנה כבר מורידה 2 לכן השארתי את זה ככה.
    }

    // ********* One Item in Matrix Methods **********
    public void setMatrixValue(int x, int y) {
        this.lfgame[x][y] = true;
    }

    public boolean getMatrixValue(int x, int y) {
        return this.lfgame[x][y];
    }

    // ספירת השכנים לתא מסויים
    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (!(i == x && j == y) && lfgame[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // הגדרת דור אחד
    public void oneGeneration() {
        boolean[][] temp = new boolean[this.lfgame.length][this.lfgame[0].length];
        for (int i = 1; i < this.lfgame.length - 1; i++) {
            for (int j = 1; j < this.lfgame[i].length - 1; j++) {
                int neighbors = countNeighbors(i, j);
                temp[i][j] = (neighbors >= 3 && neighbors <= 5);
            }
        }
        this.lfgame = temp;
    }

    // toString
    public String toString() {
        String s = "\n***  Life Game  ***\n\n    ";
        for (int j = 1; j < this.lfgame[0].length - 1; j++) {
            s += j + "   ";
        }
        s += "\n";
        for (int i = 1; i < this.lfgame.length - 1; i++) {
            s += "\n" + i + ":  ";
            for (int j = 1; j < this.lfgame[i].length - 2; j++) {
                if (this.lfgame[i][j]) {
                    s += "X" + " , ";
                } else {
                    s += " " + " , ";
                }
            }
            if (this.lfgame[i][this.lfgame[i].length - 2]) {
                s += "X";
            } else {
                s += " ";
            }
        }
        return s + "\n";
    }

    public static void main(String[] args) {
        GameOfLife lfg = new GameOfLife(10);
        System.out.println(lfg.toString());

        GraphicMatrixGameOfLife lfgGM =
                new GraphicMatrixGameOfLife("Graphic Matrix Game Of Life", lfg);

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            lfg.oneGeneration();
            System.out.println(lfg.toString());
            lfgGM = new GraphicMatrixGameOfLife("Graphic Matrix Game Of Life", lfg);
        }
        System.out.println(lfg.countNeighbors(3, 4));
    }
}
