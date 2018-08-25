package com.example.foufou.mindoo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.Delayed;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by foufou on 15/11/2017.
 */

public class tape_space extends MainActivity {
    public TextView t;
    public TextView tape;
    public Button b;
    public String str;
    float cpt=0;
    int cpt2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tape_zone);

        b = (Button)findViewById(R.id.button2);
        t=(TextView)findViewById(R.id.textView);
        tape =(TextView)findViewById(R.id.textView3);
        tape.setVisibility(View.GONE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e = (EditText) findViewById(R.id.editText2);
                b.setVisibility(View.GONE);
                t.setText("Click it now");
                str = e.getText().toString();
                e.setVisibility(View.GONE);
                tape.setText(str);
                tape.setAlpha(0);
                tape.setVisibility(View.VISIBLE);
                new CountDownTimer(1000,1){
                    public void onTick(long millisUntilFinished)
                    {
                        tape.setAlpha(cpt);



                        cpt+=0.02;


                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();



                tape.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RelativeLayout m = (RelativeLayout) findViewById(R.id.boom);
                        m.setVisibility(View.VISIBLE);
                        Button br=(Button)findViewById(R.id.buttonr);
                        Button bg=(Button)findViewById(R.id.buttong);
                        Button by=(Button)findViewById(R.id.buttony);

                        // red choice
                        br.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent my_it = new Intent(tape_space.this,MainActivity.class);
                                my_it.putExtra("txt",tape.getText());
                                my_it.putExtra("color","red");
                                setResult(RESULT_OK,my_it);
                                finish();


                            }
                        });

                        // yellow choice
                        by.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent my_it = new Intent(tape_space.this,MainActivity.class);
                                my_it.putExtra("txt",tape.getText());
                                my_it.putExtra("color","yellow");
                                setResult(RESULT_OK,my_it);
                                finish();



                            }
                        });

                        // green choice
                        bg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent my_it = new Intent(tape_space.this,MainActivity.class);
                                my_it.putExtra("txt",tape.getText());
                                my_it.putExtra("color","green");
                                setResult(RESULT_OK,my_it);
                                finish();



                            }
                        });



                    }
                });








            }
        });

    }



}
