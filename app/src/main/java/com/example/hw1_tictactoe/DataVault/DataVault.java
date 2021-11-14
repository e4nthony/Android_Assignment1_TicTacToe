package com.example.hw1_tictactoe.DataVault;

import android.util.Log;

import com.example.hw1_tictactoe.State;

public class DataVault {

    private static final int CONSTLENGTH = 3;
    private static final int ROW = 0;
    private static final int COL = 1;

    private static DataVault INSTANCE;
    private static State[][] data;

    private static State currentPlayer;
    private static int[] btn_Position; //last pressed button's position. Uses ROW/COL Consts.

    /** private Constructor implements singleton */
    private DataVault() {
        data = new State[3][3]; // desk 3x3

        currentPlayer = State.X;

        btn_Position = new int[2];
        btn_Position[ROW] = -1;
        btn_Position[COL] = -1;
    }

    /** access to Constructor via getInstance() func. */
    public static DataVault getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DataVault();
        }
        ClearDesk();
        return INSTANCE;
    }

    public static void ClearDesk() {
        for(int i = 0; i < CONSTLENGTH; ++i){
            for(int j = 0; j < CONSTLENGTH; ++j){
                data[i][j] = State.NONE;
            }
        }
    }

    public State[][] getData() {
        return data;
    }

    public State getCurrentPlayer() {
        return currentPlayer;
    }

    public int[] getLastPressedBtnID() {
        return btn_Position;
    }

    public Boolean makeMove(int x, int y){
        btn_Position[ROW] = x;
        btn_Position[COL] = y;

        if (data[x][y] != State.NONE) {
            return false;
        }

        data[x][y] = currentPlayer; // = O OR = X

        Log.d("TAG", "Move Saved = Player: " + currentPlayer + " Where: " + x + y + " *(RawValues[0,1,2])");
        return true;
    }

}