package com.example.hw1_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.hw1_tictactoe.DataVault.DataVault;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CONSTLENGTH = 3;

    private static DataVault data;
    private static ImageButton[][] buttonsLinks;
    private View focusOnButtonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.game_field); // for testing todo: delete
        //------------------------------------
        data = DataVault.getInstance();
        buttonsLinks = new ImageButton[CONSTLENGTH][CONSTLENGTH];



        // Bindings:
        // --------------------- Main Menu - activity_main ---------------------

//        Button menu_start_button = findViewById(R.id.menu_start_button); // for testing todo: enable
        // TODO: if pressed >>>>  setContentView(R.layout.game_field);



        // ---------------------------- game_field ----------------------------

        // ---- top - info image ----
        ImageView game_field_InfoBar_iv = findViewById(R.id.game_field_InfoBar_iv);

        // ---- middle - desk ----
        ImageView game_field_GridImage_iv = findViewById(R.id.game_field_GridImage_iv);
        ImageView game_field_GreenLinesImagesContainer_iv = findViewById(R.id.game_field_GreenLinesImagesContainer_iv);


        buttonsLinks[0][0] = findViewById(R.id.game_field_img_btn00);
        buttonsLinks[0][1] = findViewById(R.id.game_field_img_btn01);
        buttonsLinks[0][2] = findViewById(R.id.game_field_img_btn02);
        buttonsLinks[1][0] = findViewById(R.id.game_field_img_btn10);
        buttonsLinks[1][1] = findViewById(R.id.game_field_img_btn11);
        buttonsLinks[1][2] = findViewById(R.id.game_field_img_btn12);
        buttonsLinks[2][0] = findViewById(R.id.game_field_img_btn20);
        buttonsLinks[2][1] = findViewById(R.id.game_field_img_btn21);
        buttonsLinks[2][2] = findViewById(R.id.game_field_img_btn22);

        buttonsLinks[0][0].setOnClickListener(this);
        buttonsLinks[0][1].setOnClickListener(this);
        buttonsLinks[0][2].setOnClickListener(this);
        buttonsLinks[1][0].setOnClickListener(this);
        buttonsLinks[1][1].setOnClickListener(this);
        buttonsLinks[1][2].setOnClickListener(this);
        buttonsLinks[2][0].setOnClickListener(this);
        buttonsLinks[2][1].setOnClickListener(this);
        buttonsLinks[2][2].setOnClickListener(this);


        // ---- bottom ----
        Button game_field_PlayAgain_button = findViewById(R.id.game_field_PlayAgain_button);

        // --------------------------------------------------------------------
    }

    @Override
    public void onClick(View v) {
        int x=-1,y=-1;
        focusOnButtonID = v;

        switch (v.getId()) {

            case R.id.game_field_img_btn00:
                x = 0; y = 0; break;

            case R.id.game_field_img_btn01:
                x = 0; y = 1; break;

            case R.id.game_field_img_btn02:
                x = 0; y = 2; break;

            case R.id.game_field_img_btn10:
                x = 1; y = 0; break;

            case R.id.game_field_img_btn11:
                x = 1; y = 1; break;

            case R.id.game_field_img_btn12:
                x = 1; y = 2; break;

            case R.id.game_field_img_btn20:
                x = 2; y = 0; break;

            case R.id.game_field_img_btn21:
                x = 2; y = 1; break;

            case R.id.game_field_img_btn22:
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
        State thisMoveWasPerformedBy = data.getCurrentPlayer();

        Log.d("TAG", "Try to make move = Player: " + thisMoveWasPerformedBy + " Where: " + x + y + " *(RawValues[0,1,2])");

        boolean result = data.makeMove(x,y);

        switch (thisMoveWasPerformedBy) {

            case X:
                focusOnButtonID.setBackgroundResource(R.drawable.x_mark);
                break;
            case O:
                focusOnButtonID.setBackgroundResource(R.drawable.o_mark);
                break;

            default:
                try {
                    throw new Exception("Error");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }




    }
}