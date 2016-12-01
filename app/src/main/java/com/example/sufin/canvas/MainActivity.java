package com.example.sufin.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import static com.example.sufin.canvas.R.id.layout1;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnTouchListener {

    private int corx,cory;
    private Lienzo fondo;
    private Canvas canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RelativeLayout layout = (RelativeLayout) findViewById(layout1);
        Lienzo fondo = new Lienzo(this);
        layout.addView(fondo);
        getSupportActionBar().hide();

        /*corx=100;
        cory=100;
        fondo.setOnTouchListener(this);
        layout.addView(fondo);*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.linea) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
            Lienzo fondo = new Lienzo(this);
            layout.addView(fondo);

        } else if (id == R.id.circulo) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
            Lienzo2 fondo2 = new Lienzo2(this);
            layout.addView(fondo2);

        } else if (id == R.id.diana) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
            Lienzo3 fondo3 = new Lienzo3(this);
            layout.addView(fondo3);

        } else if (id == R.id.cuadrado) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
            Lienzo4 fondo4 = new Lienzo4(this);
            layout.addView(fondo4);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        corx=(int)event.getX();
        cory=(int)event.getY();
        fondo.invalidate();
        return true;
    }


    private class Lienzo extends View {
        Path path=new Path();
        float x=50;
        float y=75;
        String accion = "Nada";

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 0);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStrokeWidth(4);
            canvas.drawLine(50, 50, ancho, alto, pincel1);

            }

        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }



    }

    private class Lienzo2 extends View{
        Path path=new Path();
        float x=250;
        float y=375;
        String accion = "Nada";

        public Lienzo2(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);
            Paint pincel1=new Paint();

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.moveTo(x,y);
            }
            canvas.drawPath(path, pincel1);
            pincel1.setARGB(255,125,250,56);
            canvas.drawCircle(x,y,100,pincel1);

        }

        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }

    private class Lienzo3 extends View{
        Path path=new Path();
        float x=50;
        float y=75;
        String accion = "Nada";

        public Lienzo3(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 255);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStyle(Paint.Style.STROKE);
            for (int f = 0; f < 10; f++) {
                canvas.drawCircle(ancho / 2, alto / 2, f * 15, pincel1);
            }

            canvas.drawPath(path, pincel1);


        }
        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }

    private class Lienzo4 extends View{
        Path path=new Path();
        float x=50;
        float y=50;
        String accion = "Nada";
        public Lienzo4(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(Color.argb(250,110,70,200));

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.moveTo(x,y);
            }
            canvas.drawPath(path, paint);
            canvas.drawRect(x,y,x+150,x+y+150,paint);

        }
        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }
}
