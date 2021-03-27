package com.hersa.solution.sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TicTacToe {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Game game = new Game(scanner);

        game.start();
    }

}

class Game{

    Map<Integer, Player> players  = new HashMap<Integer, Player>();

    Scanner scanner;

    public int gameState = 0;
    public final int STATE_GAME_OVER = -1;

    public int inTurn = 0;

    String[][] board;

    int boardSize = 3;

    int fullCells = 0;

    public Game(Scanner scanner){
        this.scanner = scanner;
    }

    public void start(){

        initPlayers();

        initBoard();

        System.out.println("Welcome, Here is your board!");

        printBoard();

        while(!isExit()){
            playGame();
        }

        Player player = getCurrentPlayer();

        System.out.println();

        if (player == null){
            System.out.println("DRAW!");
        }else {
            System.out.println(player.name + " wins!");
        }
    }

    private void playGame() {

        // next player
        if ((inTurn + 1) > players.size()){
            inTurn = 1;
        }else{
            inTurn ++;
        }

        playerTurn();
    }
    private Player getCurrentPlayer(){
        return players.get(inTurn);
    }

    private void playerTurn() {
        String input = "";

        int[] pos = new int[2];

        boolean invalid = false;

        while(input.isEmpty() && !isExit()){

            if (invalid){
                System.out.println("Invalid entry. Try again.");
            }

            System.out.println(getCurrentPlayer().name + ", where would you like to move? Ex. 1,1");

            input = scanner.nextLine();

            try {
                invalid = false;

                String[] s = input.trim().split(",");

                pos[0] = Integer.parseInt(s[0].trim());
                pos[1] = Integer.parseInt(s[1].trim());

                if (pos[0] < 1 || pos[0] > boardSize || pos[1] < 1 || pos[1] > boardSize){
                    throw new Exception("");
                }

                validateLocation(pos);

                updateBoard(pos);

                printBoard();

                checkGame();

            }catch (Exception e){
                input = "";
                invalid = true;
            }
        }

    }

    private void checkGame() {
        boolean won = checkWins();

        // is board full
        if(won || isBoardFull()){
            inTurn = !won ? 0 : inTurn;

            gameState = STATE_GAME_OVER;
        };
    }

    private boolean checkWins() {

        boolean won = false;

        String symbol = getCurrentPlayer().symbol;

        // check rows
        for (int i = 0; i < board.length; i++) {
            String[] row = board[i];
            int points = 0;
            for (int j = 0; j < board.length; j++) {
                if(row[j].trim().equals(symbol)){
                    points ++;
                }
            }
            if(points == boardSize){
                return true;
            }
        }

        // check columns
        for (int i = 0; i < board.length; i++) {
            int points = 0;
            for (int j = 0; j < board.length; j++) {
                String d = board[j][i];
                if (d.trim().equals(symbol)){
                    points++;
                }
            }
            if (points == boardSize){
                return true;
            }
        }

        // check diagonal
        int i = 0;
        int j = boardSize - 1;

        int d1  =0 ;
        int d2 = 0;

        while(i < boardSize){

            if(board[i][i].equals(symbol)){
                d1++;
            }

            if(board[j][j].equals(symbol)){
                d2++;
            }

            i++;
            j--;
        }

        if(d1 == boardSize || d2 == boardSize){
            return true;
        }

        return won;
    }

    private boolean isBoardFull() {
        return fullCells == (boardSize * boardSize);
    }

    public void initPlayers(){

        Player player1 = new Player("X");
        players.put(players.size() + 1, player1 );

        Player player2 = new Player("O");
        players.put(players.size() + 1, player2 );

        for (Map.Entry<Integer, Player> entry : players.entrySet()){
            Player player = entry.getValue();
            getPlayerName(player);
        }
    }

    public void getPlayerName(Player player){

        while(player.name.isEmpty() && !isExit()){

            System.out.println("Enter player name:");

            String name = scanner.nextLine();

            player.name = name == null ? "" : name;
        }
    }

    private void initBoard() {
        board = new String[boardSize][boardSize];

        for (int i = 0; i < board.length; i++) {
            String[] row = board[i];
            for (int j = 0; j < board.length; j++) {
                row[j] = " _ ";
            }
        }
    }


    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            String[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }

    private void updateBoard(int[] pos) {
        board[pos[0] - 1][pos[1] - 1] = " " + players.get(inTurn).symbol + " ";
        fullCells++;
    }

    private void validateLocation(int[] pos) throws Exception {
        if(!board[pos[0] - 1][pos[1] - 1].equals(" _ ")){
            throw new Exception("");
        }
    }

    public boolean isExit(){
        return gameState == STATE_GAME_OVER;
    }

}

class Player{

    String name;
    String symbol;
    int num;

    public AtomicInteger playerCount = new AtomicInteger(1);

    public Player(){
        init();
    }

    public Player(String symbol){
        init();
        this.symbol = symbol;
    }

    public Player(String name, String symbol){
        init();
        this.name = name;
        this.symbol = symbol;
    }

    private void init(){
        this.name = "";
        this.symbol = "";
        this.num = playerCount.getAndIncrement();
    }

}
