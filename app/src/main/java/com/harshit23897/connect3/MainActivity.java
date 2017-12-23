package com.harshit23897.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[][] board = new String[4][4];
    private final String str = "MyActivity";
    private int currentPlayer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeBoard();
    }

    public void initializeBoard() {
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                board[i][j] = "";
            }
        }
    }

    public void cellClick(View v) {
        String  cellNumber = v.getResources().getResourceName(v.getId());
        TextView cellView = findViewById(v.getId());
        cellNumber = cellNumber.substring(33);
        int rowNumber = cellNumber.charAt(0)-'0';
        Log.i(str, "Hello");
        int columnNumber = cellNumber.charAt(1)-'0';
        RadioButton radio_O = findViewById(R.id.radio_O);
        RadioButton radio_X = findViewById(R.id.radio_X);

        if(board[rowNumber][columnNumber].equals("")) {
            if(currentPlayer == 1) {
                board[rowNumber][columnNumber] = "O";
                cellView.setText("O");
            }
            else {
                board[rowNumber][columnNumber] = "X";
                cellView.setText("X");
            }
            currentPlayer = 1 - currentPlayer;
            if(checkForWin()) {
                if(currentPlayer == 1)
                    Toast.makeText(MainActivity.this, "Winner Player " + Integer.toString(currentPlayer), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Winner Player " + Integer.toString(currentPlayer+2), Toast.LENGTH_SHORT).show();
                TextView cellView1 = findViewById(R.id.cell11);
                TextView cellView2 = findViewById(R.id.cell12);
                TextView cellView3 = findViewById(R.id.cell13);
                TextView cellView4 = findViewById(R.id.cell21);
                TextView cellView5 = findViewById(R.id.cell22);
                TextView cellView6 = findViewById(R.id.cell23);
                TextView cellView7 = findViewById(R.id.cell31);
                TextView cellView8 = findViewById(R.id.cell32);
                TextView cellView9 = findViewById(R.id.cell33);

                cellView1.setEnabled(false);
                cellView2.setEnabled(false);
                cellView3.setEnabled(false);
                cellView4.setEnabled(false);
                cellView5.setEnabled(false);
                cellView6.setEnabled(false);
                cellView7.setEnabled(false);
                cellView8.setEnabled(false);
                cellView9.setEnabled(false);

            }
            else if(checkForFullBoard()) {
                Toast.makeText(MainActivity.this, "Tie", Toast.LENGTH_SHORT).show();
                TextView cellView1 = findViewById(R.id.cell11);
                TextView cellView2 = findViewById(R.id.cell12);
                TextView cellView3 = findViewById(R.id.cell13);
                TextView cellView4 = findViewById(R.id.cell21);
                TextView cellView5 = findViewById(R.id.cell22);
                TextView cellView6 = findViewById(R.id.cell23);
                TextView cellView7 = findViewById(R.id.cell31);
                TextView cellView8 = findViewById(R.id.cell32);
                TextView cellView9 = findViewById(R.id.cell33);

                cellView1.setEnabled(false);
                cellView2.setEnabled(false);
                cellView3.setEnabled(false);
                cellView4.setEnabled(false);
                cellView5.setEnabled(false);
                cellView6.setEnabled(false);
                cellView7.setEnabled(false);
                cellView8.setEnabled(false);
                cellView9.setEnabled(false);
            }
            else if(currentPlayer == 1) {
                radio_O.setChecked(true);
                radio_X.setChecked(false);
            }
            else {
                radio_O.setChecked(false);
                radio_X.setChecked(true);
            }
        }
    }

    public boolean checkForFullBoard() {
        int flag = 0;
        for(int i = 1; i <= 3; ++i) {
            for(int j = 1; j <= 3; ++j) {
                if(board[i][j] == "")
                    ++flag;
            }
        }
        if(flag >= 1)
            return false;
        else
            return true;
    }
    public boolean checkForWin() {
        //Check for principle diagonal
        if(!board[1][1].equals("") && board[1][1].equals(board[2][2]) && board[1][1].equals(board[3][3])) {
            return true;
        }
        //Check for other diagonal
        if(!board[1][3].equals("") && board[1][3].equals(board[2][2]) && board[1][3].equals(board[3][1])) {
            return true;
        }
        for(int i = 1; i <= 3; ++i) {
            //Check for Row
            if(!board[i][1].equals("") && board[i][1].equals(board[i][2]) && board[i][1].equals(board[i][3])) {
                return true;
            }
            //Check for Column
            if(!board[1][i].equals("") && board[1][i].equals(board[2][i]) && board[1][i].equals(board[3][i])) {
                return true;
            }
        }
        return false;
    }

    public void resetBoard(View v) {
        for(int i = 1; i <= 3; ++i) {
            for(int j = 1; j <= 3; ++j) {
                board[i][j] = "";
            }
        }
        currentPlayer = 0;
        RadioButton radio_O = findViewById(R.id.radio_O);
        RadioButton radio_X = findViewById(R.id.radio_X);
        radio_X.setChecked(true);
        radio_O.setChecked(false);

        TextView cellView1 = findViewById(R.id.cell11);
        TextView cellView2 = findViewById(R.id.cell12);
        TextView cellView3 = findViewById(R.id.cell13);
        TextView cellView4 = findViewById(R.id.cell21);
        TextView cellView5 = findViewById(R.id.cell22);
        TextView cellView6 = findViewById(R.id.cell23);
        TextView cellView7 = findViewById(R.id.cell31);
        TextView cellView8 = findViewById(R.id.cell32);
        TextView cellView9 = findViewById(R.id.cell33);

        cellView1.setEnabled(true);
        cellView2.setEnabled(true);
        cellView3.setEnabled(true);
        cellView4.setEnabled(true);
        cellView5.setEnabled(true);
        cellView6.setEnabled(true);
        cellView7.setEnabled(true);
        cellView8.setEnabled(true);
        cellView9.setEnabled(true);

        cellView1.setText("");
        cellView2.setText("");
        cellView3.setText("");
        cellView4.setText("");
        cellView5.setText("");
        cellView6.setText("");
        cellView7.setText("");
        cellView8.setText("");
        cellView9.setText("");
    }
}
