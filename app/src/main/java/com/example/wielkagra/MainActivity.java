package com.example.wielkagra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
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
    int d=0;
    int mss=0;

    boolean gra;
    int poprzednio,przycisk;

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
    ArrayList<Integer> lista2 = new ArrayList<Integer>();
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


               // Toast.makeText(getApplicationContext(),images[2],Toast.LENGTH_LONG).show();


               lista2.add(lista.get(0));
             //   Toast.makeText(getApplicationContext(),images[2],Toast.LENGTH_LONG).show();
                d++;
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        punkty++;
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


                d++;
               lista2.add(lista.get(1));
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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

               lista2.add(lista.get(2));
                d++;
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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

               lista2.add(lista.get(3));
                d++;
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        punkty++;
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

                lista2.add(lista.get(4));
                d++;

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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        mss=0;
                                        punkty=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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

               lista2.add(lista.get(5));
                d++;
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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
                lista2.add(lista.get(6));
                d++;
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
                                    punkty++;

                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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
                lista2.add(lista.get(7));
                d++;
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
                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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
                lista2.add(lista.get(8));
                d++;





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



                                    if(punkty==4)
                                    {
                                        gra=false;
                                        Toast.makeText(getApplicationContext(),"Wygrałeś w: "+Integer.toString(mss)+" sekund",Toast.LENGTH_LONG).show();
                                        punkty=0;
                                        mss=0;
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
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
               // Toast.makeText(getApplicationContext(),Integer.toString(R.drawable.button_gra),Toast.LENGTH_SHORT).show();

            }
        });













    }




}

/*
                for(int i=0;i<lista2.size();i++)
                {
                    if((lista2.get(i).equals(images[2]))&&(lista2.get(i-1).equals(images[3]))||(lista2.get(i-1).equals(images[2]))&&(lista2.get(i).equals(images[3])))
                    {
                        Toast.makeText(getApplicationContext(),"Dostajesz punkt",Toast.LENGTH_SHORT).show();
                    }
                    else if((lista2.get(i).equals(images[6]))&&(lista2.get(i-1).equals(images[5]))||(lista2.get(i-1).equals(images[6]))&&(lista2.get(i).equals(images[5])))
                    {
                        Toast.makeText(getApplicationContext(),"Dostajesz punkt",Toast.LENGTH_SHORT).show();
                    }
                    else if((lista2.get(i).equals(images[0]))&&(lista2.get(i-1).equals(images[1]))||(lista2.get(i-1).equals(images[0]))&&(lista2.get(i).equals(images[1])))
                    {
                        Toast.makeText(getApplicationContext(),"Dostajesz punkt",Toast.LENGTH_SHORT).show();
                    }
                    else if((lista2.get(i).equals(images[7]))&&(lista2.get(i-1).equals(images[8]))||(lista2.get(i-1).equals(images[7]))&&(lista2.get(i).equals(images[8])))
                    {
                        Toast.makeText(getApplicationContext(),"Dostajesz punkt",Toast.LENGTH_SHORT).show();
                    }
                }
 */
