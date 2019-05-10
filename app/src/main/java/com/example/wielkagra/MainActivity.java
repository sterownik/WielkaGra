package com.example.wielkagra;

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
    int d=0;
    boolean p1,p2,p3,p4,p5,p6,p7,p8,p9;
    int[] images = new int[] {R.drawable.wzor_jeden,
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
                p1=true;
               // Toast.makeText(getApplicationContext(),images[2],Toast.LENGTH_LONG).show();
               

               lista2.add(lista.get(0));
             //   Toast.makeText(getApplicationContext(),images[2],Toast.LENGTH_LONG).show();
                d++;
                przycisk1.setImageResource(lista.get(0));


                final Handler handler = new Handler();
                boolean  run=true;
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
                                przycisk1.setImageResource(R.drawable.poczatkowy);
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
                boolean  run=true;

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
                                przycisk2.setImageResource(R.drawable.poczatkowy);
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
                                przycisk3.setImageResource(R.drawable.poczatkowy);


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
                                przycisk4.setImageResource(R.drawable.poczatkowy);


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
                przycisk5.setImageResource(lista.get(4));
                final Handler handler = new Handler();


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
                                przycisk5.setImageResource(R.drawable.poczatkowy);
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
                                przycisk6.setImageResource(R.drawable.poczatkowy);
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
                                przycisk7.setImageResource(R.drawable.poczatkowy);


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
                                przycisk8.setImageResource(R.drawable.poczatkowy);

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
                                przycisk9.setImageResource(R.drawable.poczatkowy);


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
