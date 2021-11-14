package com.example.hw1_tictactoe.DataVault;

import android.util.Log;

import com.example.hw1_tictactoe.State;

public class DataVault {

    private static final int ROWLENGTH = 3;
    private static final int COLLENGTH = 3;

    private static DataVault INSTANCE;
    private static State[][] data;


    /** private Constructor implements singleton */
    private DataVault() {
        data = new State[3][3]; // desk 3x3
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
        for(int i = 0; i < ROWLENGTH; ++i){
            for(int j = 0; j < COLLENGTH; ++j){
                data[i][j] = State.NONE;
            }
        }
    }

    public State[][] getData() {
        return data;
    }

    public Boolean makeMove(State player, int x, int y){

        if (data[x][y] != State.NONE) {
            return false;
        }

        data[x][y] = player;

        Log.d("TAG", "Move Saved = Player: " + player + " Where: " + x + y + " *(RawValues[0,1,2])");
        return true;
    }

}