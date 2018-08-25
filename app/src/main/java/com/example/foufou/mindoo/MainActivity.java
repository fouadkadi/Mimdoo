package com.example.foufou.mindoo;

import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt =(Button)findViewById(R.id.button);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this ,tape_space.class);
                startActivityForResult(it,1);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LinearLayout r = (LinearLayout) findViewById(R.id.red);
        LinearLayout y = (LinearLayout) findViewById(R.id.yellow);
        LinearLayout g = (LinearLayout) findViewById(R.id.green);

        if(requestCode==1) {

            if (resultCode == RESULT_OK) {

                String txt = data.getExtras().getString("txt");
                String color = data.getExtras().getString("color");
                TextView tx = new TextView(MainActivity.this);
                tx.setText(txt);
                tx.setPadding(30,10,30,10);
                tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                LinearLayout.LayoutParams par =(LinearLayout.LayoutParams)tx.getLayoutParams();
                par.setMargins(10,10,10,10);
                tx.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);


                if (color.equals("red")) {
                    tx.setBackgroundResource(R.drawable.red);
                    r.addView(tx);

                }
                if (color.equals("yellow")){
                    tx.setBackgroundResource(R.drawable.yel);
                    y.addView(tx);

                }
                if (color.equals("green")) {
                    tx.setBackgroundResource(R.drawable.gre);
                    g.addView(tx);

                }

                // remover

                LinearLayout main=(LinearLayout) findViewById(R.id.red);
                int a = main.getChildCount();
                for (int i=0;i<a;i++)
                {
                    final int z =i;
                        View v =main.getChildAt(i);
                        v.setOnLongClickListener(new View.OnLongClickListener() {
                        LinearLayout main=(LinearLayout) findViewById(R.id.red);
                        View v=main.getChildAt(z);
                        @Override
                        public boolean onLongClick(View view) {
                            main.removeView(v);

                            return true;
                        }
                    });

                }

                // yellow remover

                LinearLayout main2=(LinearLayout) findViewById(R.id.yellow);
                int a2 = main2.getChildCount();
                for (int i=0;i<a2;i++)
                {
                    final int z =i;
                    View v =main2.getChildAt(i);
                    v.setOnLongClickListener(new View.OnLongClickListener() {
                        LinearLayout main=(LinearLayout) findViewById(R.id.yellow);
                        View v=main.getChildAt(z);
                        @Override
                        public boolean onLongClick(View view) {
                            main.removeView(v);

                            return true;
                        }
                    });

                }

                // green remover

                LinearLayout main3=(LinearLayout) findViewById(R.id.green);
                int a3 = main3.getChildCount();
                for (int i=0;i<a3;i++)
                {
                    final int z =i;
                    View v =main3.getChildAt(i);
                    v.setOnLongClickListener(new View.OnLongClickListener() {
                        LinearLayout main=(LinearLayout) findViewById(R.id.green);
                        View v=main.getChildAt(z);
                        @Override
                        public boolean onLongClick(View view) {
                            main.removeView(v);

                            return true;
                        }
                    });

                }







            }
        }

    }



}
