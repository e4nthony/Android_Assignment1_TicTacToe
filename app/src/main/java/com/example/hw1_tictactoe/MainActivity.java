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

public class MainActivity extends AppCompatActivity {

    public static final int CONSTLENGTH = 3;

    private static State[][] deskData;
    private static Button[][] buttonsLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.game_field); // for testing todo: delete
        //------------------------------------

        deskData = DataVault.getInstance().getData();





        // --------------------- Main Menu - activity_main ---------------------

        Button menu_start_button = findViewById(R.id.menu_start_button);
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
        // TODO: if pressed >>>> performs as menu_start_button

        // --------------------------------------------------------------------



        for(int i = 0; i < CONSTLENGTH; ++i){
            for(int j = 0; j < CONSTLENGTH; ++j){
                buttonsLinks[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO: 14.11.2021
                    }
                });
            }
        }


    }
}