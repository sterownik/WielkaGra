package com.example.wielkagra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {






    int punkty=0;
    int mss=0;

    boolean gra;
    int poprzednio,przycisk;
    


    protected void onDestroy() {
        super.onDestroy();
        punkty=0;
        mss=0;
    }

    int[] images = new int[] {
            R.drawable.wzor_jeden,
            R.drawable.krecik_kopia,
            R.drawable.button_gra,
            R.drawable.kopiamis,
            R.drawable.przycisk_wzor_dwa,
            R.drawable.lama_lama,
            R.drawable.kopia_lama,
            R.drawable.wzor_trzy,
            R.drawable.trygrys_kopia};
    ArrayList<Integer> lista = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gra=true;
        final Handler handler2 = new Handler();
        handler2.post(new Runnable() {
            @Override
            public void run() {
                if(gra) {
                    mss++;
                }
                handler2.postDelayed(this,1000);
            }
        });

        Random rand= new Random();
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.fanfary_jeden);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(),R.raw.mario_coin);

        while (lista.size()<9)
        {
            int random=rand.nextInt(images.length);
            if(!lista.contains(images[random]))
            {
                lista.add(images[random]);
            }
        }


        final ImageButton przycisk1=(ImageButton) findViewById(R.id.but1);
        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                przycisk1.setImageResource(lista.get(0));
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds1=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds1++;
                            if(mseconds1==2)
                            {
                                run=false;

                                if((lista.get(0)==images[2]&&poprzednio==images[3])||(lista.get(0)==images[3]&&poprzednio==images[2])||
                                        (lista.get(0)==images[6]&&poprzednio==images[5])||(lista.get(0)==images[5]&&poprzednio==images[6])||
                                        (lista.get(0)==images[0]&&poprzednio==images[1])||(lista.get(0)==images[1]&&poprzednio==images[0])||
                                        (lista.get(0)==images[7]&&poprzednio==images[8])||(lista.get(0)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk1.setImageResource(R.drawable.okejka_tak);
                                    przycisk1.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk1 = (ImageButton)findViewById(przycisk);
                                    przycisk1.setImageResource(R.drawable.okejka_tak);
                                    przycisk1.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        punkty++;
                                        mp2.start();
                                    }

                                }
                                else{
                                    poprzednio=lista.get(0);
                                    przycisk=R.id.but1;
                                    przycisk1.setImageResource(R.drawable.poczatkowy);
                                }
                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });

            }
        });

        final ImageButton przycisk2=(ImageButton)findViewById(R.id.but2);
        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                przycisk2.setImageResource(lista.get(1));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds2=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds2++;
                            if(mseconds2==2)
                            {
                                run=false;

                                if((lista.get(1)==images[2]&&poprzednio==images[3])||(lista.get(1)==images[3]&&poprzednio==images[2])||
                                        (lista.get(1)==images[6]&&poprzednio==images[5])||(lista.get(1)==images[5]&&poprzednio==images[6])||
                                        (lista.get(1)==images[0]&&poprzednio==images[1])||(lista.get(1)==images[1]&&poprzednio==images[0])||
                                        (lista.get(1)==images[7]&&poprzednio==images[8])||(lista.get(1)==images[8]&&poprzednio==images[7])
                                )
                                {



                                    przycisk2.setImageResource(R.drawable.okejka_tak);
                                    przycisk2.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk2 = (ImageButton)findViewById(przycisk);
                                    przycisk2.setImageResource(R.drawable.okejka_tak);
                                    przycisk2.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }


                                }
                                else{
                                    poprzednio=lista.get(1);
                                    przycisk=R.id.but2;
                                    przycisk2.setImageResource(R.drawable.poczatkowy);
                                }
                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });


            }
        });
        final ImageButton przycisk3=(ImageButton)findViewById(R.id.but3);
        przycisk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                przycisk3.setImageResource(lista.get(2));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds3=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds3++;
                            if(mseconds3==2)
                            {
                                run=false;

                                if((lista.get(2)==images[2]&&poprzednio==images[3])||(lista.get(2)==images[3]&&poprzednio==images[2])||
                                        (lista.get(2)==images[6]&&poprzednio==images[5])||(lista.get(2)==images[5]&&poprzednio==images[6])||
                                        (lista.get(2)==images[0]&&poprzednio==images[1])||(lista.get(2)==images[1]&&poprzednio==images[0])||
                                        (lista.get(2)==images[7]&&poprzednio==images[8])||(lista.get(2)==images[8]&&poprzednio==images[7])
                                )
                                {


                                    przycisk3.setImageResource(R.drawable.okejka_tak);
                                    przycisk3.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk3 = (ImageButton)findViewById(przycisk);
                                    przycisk3.setImageResource(R.drawable.okejka_tak);
                                    przycisk3.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }


                                }
                                else{
                                    poprzednio=lista.get(2);
                                    przycisk=R.id.but3;
                                    przycisk3.setImageResource(R.drawable.poczatkowy);
                                }


                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });


            }
        });

        final ImageButton przycisk4=(ImageButton)findViewById(R.id.but4);
        przycisk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                przycisk4.setImageResource(lista.get(3));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds4=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds4++;
                            if(mseconds4==2)
                            {
                                run=false;

                                if((lista.get(3)==images[2]&&poprzednio==images[3])||(lista.get(3)==images[3]&&poprzednio==images[2])||
                                        (lista.get(3)==images[6]&&poprzednio==images[5])||(lista.get(3)==images[5]&&poprzednio==images[6])||
                                        (lista.get(3)==images[0]&&poprzednio==images[1])||(lista.get(3)==images[1]&&poprzednio==images[0])||
                                        (lista.get(3)==images[7]&&poprzednio==images[8])||(lista.get(3)==images[8]&&poprzednio==images[7])
                                )
                                {
                                    przycisk4.setImageResource(R.drawable.okejka_tak);
                                    przycisk4.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk4 = (ImageButton)findViewById(przycisk);
                                    przycisk4.setImageResource(R.drawable.okejka_tak);
                                    przycisk4.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        punkty++;
                                        mp2.start();
                                    }

                                }
                                else{
                                    poprzednio=lista.get(3);
                                    przycisk=R.id.but4;
                                    przycisk4.setImageResource(R.drawable.poczatkowy);
                                }


                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });


            }
        });
        final ImageButton przycisk5=(ImageButton)findViewById(R.id.but5);
        przycisk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Handler handler = new Handler();
                przycisk5.setImageResource(lista.get(4));

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds5=0;
                    @Override
                    public void run() {
                        if(run)
                        {
                            mseconds5++;
                            if(mseconds5==2)
                            {
                                run=false;

                                if((lista.get(4)==images[2]&&poprzednio==images[3])||(lista.get(4)==images[3]&&poprzednio==images[2])||
                                        (lista.get(4)==images[6]&&poprzednio==images[5])||(lista.get(4)==images[5]&&poprzednio==images[6])||
                                        (lista.get(4)==images[0]&&poprzednio==images[1])||(lista.get(4)==images[1]&&poprzednio==images[0])||
                                        (lista.get(4)==images[7]&&poprzednio==images[8])||(lista.get(4)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk5.setImageResource(R.drawable.okejka_tak);
                                    przycisk5.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk5 = (ImageButton)findViewById(przycisk);
                                    przycisk5.setImageResource(R.drawable.okejka_tak);
                                    przycisk5.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        mss=0;
                                        punkty=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }

                                }
                                else{
                                    poprzednio=lista.get(4);
                                    przycisk=R.id.but5;
                                    przycisk5.setImageResource(R.drawable.poczatkowy);
                                }
                            }
                        }
                        handler.postDelayed(this,1000);
                    }
                });

            }
        });
        final ImageButton przycisk6=(ImageButton)findViewById(R.id.but6);
        przycisk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                przycisk6.setImageResource(lista.get(5));
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds6=0;
                    @Override
                    public void run() {
                        if(run)
                        {
                            mseconds6++;
                            if(mseconds6==2)
                            {
                                run=false;

                                if((lista.get(5)==images[2]&&poprzednio==images[3])||(lista.get(5)==images[3]&&poprzednio==images[2])||
                                        (lista.get(5)==images[6]&&poprzednio==images[5])||(lista.get(5)==images[5]&&poprzednio==images[6])||
                                        (lista.get(5)==images[0]&&poprzednio==images[1])||(lista.get(5)==images[1]&&poprzednio==images[0])||
                                        (lista.get(5)==images[7]&&poprzednio==images[8])||(lista.get(5)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk6.setImageResource(R.drawable.okejka_tak);
                                    przycisk6.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk6 = (ImageButton)findViewById(przycisk);
                                    przycisk6.setImageResource(R.drawable.okejka_tak);
                                    przycisk6.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }
                                }
                                else{
                                    poprzednio=lista.get(5);
                                    przycisk=R.id.but6;
                                    przycisk6.setImageResource(R.drawable.poczatkowy);
                                }
                            }
                        }
                        handler.postDelayed(this,1000);
                    }
                });

            }
        });

        final ImageButton przycisk7=(ImageButton)findViewById(R.id.but7);
        przycisk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                przycisk7.setImageResource(lista.get(6));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds7=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds7++;
                            if(mseconds7==2)
                            {
                                run=false;

                                if((lista.get(6)==images[2]&&poprzednio==images[3])||(lista.get(6)==images[3]&&poprzednio==images[2])||
                                        (lista.get(6)==images[6]&&poprzednio==images[5])||(lista.get(6)==images[5]&&poprzednio==images[6])||
                                        (lista.get(6)==images[0]&&poprzednio==images[1])||(lista.get(6)==images[1]&&poprzednio==images[0])||
                                        (lista.get(6)==images[7]&&poprzednio==images[8])||(lista.get(6)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk7.setImageResource(R.drawable.okejka_tak);
                                    przycisk7.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk7 = (ImageButton)findViewById(przycisk);
                                    przycisk7.setImageResource(R.drawable.okejka_tak);
                                    przycisk7.setVisibility(View.INVISIBLE);


                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }
                                }
                                else{
                                    poprzednio=lista.get(6);
                                    przycisk=R.id.but7;
                                    przycisk7.setImageResource(R.drawable.poczatkowy);

                                }

                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });


            }
        });

        final ImageButton przycisk8=(ImageButton)findViewById(R.id.but8);
        przycisk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                przycisk8.setImageResource(lista.get(7));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds8=0;
                    @Override
                    public void run() {

                        if(run)
                        {
                            mseconds8++;
                            if(mseconds8==2)
                            {
                                run=false;

                                if((lista.get(7)==images[2]&&poprzednio==images[3])||(lista.get(7)==images[3]&&poprzednio==images[2])||
                                        (lista.get(7)==images[6]&&poprzednio==images[5])||(lista.get(7)==images[5]&&poprzednio==images[6])||
                                        (lista.get(7)==images[0]&&poprzednio==images[1])||(lista.get(7)==images[1]&&poprzednio==images[0])||
                                        (lista.get(7)==images[7]&&poprzednio==images[8])||(lista.get(7)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk8.setImageResource(R.drawable.okejka_tak);
                                    przycisk8.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk8 = (ImageButton)findViewById(przycisk);
                                    przycisk8.setImageResource(R.drawable.okejka_tak);
                                    przycisk8.setVisibility(View.INVISIBLE);
                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }
                                }
                                else{
                                    poprzednio=lista.get(7);
                                    przycisk=R.id.but8;
                                    przycisk8.setImageResource(R.drawable.poczatkowy);
                                }

                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });


            }
        });
        final ImageButton przycisk9=(ImageButton)findViewById(R.id.but9);
        przycisk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                przycisk9.setImageResource(lista.get(8));
                final Handler handler = new Handler();

                handler.post(new Runnable() {
                    boolean  run=true;
                    int mseconds9=0;
                    @Override
                    public void run() {


                        if(run)
                        {
                            mseconds9++;
                            if(mseconds9==2)
                            {
                                run=false;

                                if((lista.get(8)==images[2]&&poprzednio==images[3])||(lista.get(8)==images[3]&&poprzednio==images[2])||
                                        (lista.get(8)==images[6]&&poprzednio==images[5])||(lista.get(8)==images[5]&&poprzednio==images[6])||
                                        (lista.get(8)==images[0]&&poprzednio==images[1])||(lista.get(8)==images[1]&&poprzednio==images[0])||
                                        (lista.get(8)==images[7]&&poprzednio==images[8])||(lista.get(8)==images[8]&&poprzednio==images[7])
                                )
                                {

                                    przycisk9.setImageResource(R.drawable.okejka_tak);
                                    przycisk9.setVisibility(View.INVISIBLE);
                                    ImageButton przycisk9 = (ImageButton)findViewById(przycisk);
                                    przycisk9.setImageResource(R.drawable.okejka_tak);
                                    przycisk9.setVisibility(View.INVISIBLE);

                                    if(punkty==3)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        mp.start();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        mp2.start();
                                        punkty++;
                                    }

                                }
                                else{
                                    poprzednio=lista.get(8);
                                    przycisk=R.id.but9;
                                    przycisk9.setImageResource(R.drawable.poczatkowy);
                                }

                            }
                        }
                        handler.postDelayed(this,1000);
                    }

                });

            }
        });

    }
}

