package com.example.hw1_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.hw1_tictactoe.DataVault.DataVault;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CONSTLENGTH = 3;

    private static DataVault data;
    private static Button[][] buttonsLinks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.game_field); // for testing, todo: delete
        //------------------------------------
        data = DataVault.getInstance();
        buttonsLinks = new Button[CONSTLENGTH][CONSTLENGTH];



        // Bindings:
        // --------------------- Main Menu - activity_main ---------------------

//        Button menu_start_button = findViewById(R.id.menu_start_button); // for testing, todo: enable
        // TODO: if pressed >>>>  setContentView(R.layout.game_field);



        // ---------------------------- game_field ----------------------------

        // ---- top - info image ----
        ImageView game_field_InfoBar_iv = findViewById(R.id.game_field_InfoBar_iv);

        // ---- middle - desk ----
        ImageView game_field_GridImage_iv = findViewById(R.id.game_field_GridImage_iv);
        ImageView game_field_GreenLinesImagesContainer_iv = findViewById(R.id.game_field_GreenLinesImagesContainer_iv);


        buttonsLinks[0][0] = findViewById(R.id.game_field_button00);
        buttonsLinks[0][1] = findViewById(R.id.game_field_button01);
        buttonsLinks[0][2] = findViewById(R.id.game_field_button02);
        buttonsLinks[1][0] = findViewById(R.id.game_field_button10);
        buttonsLinks[1][1] = findViewById(R.id.game_field_button11);
        buttonsLinks[1][2] = findViewById(R.id.game_field_button12);
        buttonsLinks[2][0] = findViewById(R.id.game_field_button20);
        buttonsLinks[2][1] = findViewById(R.id.game_field_button21);
        buttonsLinks[2][2] = findViewById(R.id.game_field_button22);

        // ---- bottom ----
        Button game_field_PlayAgain_button = findViewById(R.id.game_field_PlayAgain_button);

        // --------------------------------------------------------------------


//
//        for(int i = 0; i < CONSTLENGTH; ++i){
//            for(int j = 0; j < CONSTLENGTH; ++j){
//                buttonsLinks[i][j].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        Log.d("TAG", "Try to make move = Player: " + currentPlayer + " Where: " + buttonsLinks[i][j].getId()+ " *(RawValues[0,1,2])");
//                        // TODO: 14.11.2021
//                    }
//
//                });
//            }
//        }


    }

    @Override
    public void onClick(View v) {
        int x=-1,y=-1;

        switch (v.getId()) {

            case R.id.game_field_button00:
                x = 0; y = 0; break;

            case R.id.game_field_button01:
                x = 0; y = 1; break;

            case R.id.game_field_button02:
                x = 0; y = 2; break;

            case R.id.game_field_button10:
                x = 1; y = 0; break;

            case R.id.game_field_button11:
                x = 1; y = 1; break;

            case R.id.game_field_button12:
                x = 1; y = 2; break;

            case R.id.game_field_button20:
                x = 2; y = 0; break;

            case R.id.game_field_button21:
                x = 2; y = 1; break;

            case R.id.game_field_button22:
                x = 2; y = 2; break;

            case R.id.game_field_PlayAgain_button:
                // TODO: if pressed >>>> performs as menu_start_button
                break;

            default:
                try {
                    throw new Exception("Unknown button");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        Log.d("TAG", "Try to make move = Player: " + data.getCurrentPlayer() + " Where: " + x + y + " *(RawValues[0,1,2])");
        data.makeMove(x,y);
    }
}
