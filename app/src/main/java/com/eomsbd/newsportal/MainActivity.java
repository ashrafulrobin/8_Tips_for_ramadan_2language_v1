package com.eomsbd.newsportal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG_FRAGMENT = "TAG_FRAGMENT";

    private Button button1;
    Button tips1;
    Button tips2;
    Button tips3;
    Button tips4;
    Button tips5;
    Button tips6;
    Button tips7;
    Button tips8;

    private FrameLayout fragmentContiner;
    TextView layout;
    ScrollView constraintLayout;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.en);

      Paper.init(this);

      String language=Paper.book().read("language");
      if (language==null){
          Paper.book().write("language","en");
     updateView((String)Paper.book().read("language"));
      }






        constraintLayout = findViewById(R.id.container);
        tips1 = (Button) findViewById(R.id.btn1);
        tips2 = (Button) findViewById(R.id.btn2);
        tips3 = (Button) findViewById(R.id.btn3);
        tips4 = (Button) findViewById(R.id.btn4);
        tips5 = (Button) findViewById(R.id.btn5);
        tips6 = (Button) findViewById(R.id.btn6);
        tips7 = (Button) findViewById(R.id.btn7);
        tips8 = (Button) findViewById(R.id.btn8);

        tips1.setOnClickListener(this);
        tips2.setOnClickListener(this);
        tips3.setOnClickListener(this);
        tips4.setOnClickListener(this);
        tips5.setOnClickListener(this);
        tips6.setOnClickListener(this);
        tips7.setOnClickListener(this);
        tips8.setOnClickListener(this);
    }

    private void updateView(String lang) {
        Context context=LocaleHelper.setLocale(this,lang);
        Resources resources=context.getResources();

        layout.setText(resources.getString(R.string.heading7));

    }


    @Override
    public void onBackPressed() {
        tellFragments();
        super.onBackPressed();

    }


    private void tellFragments() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment f : fragments) {
            if (f != null && f instanceof Tips7_fragment) {
                ((Tips7_fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips1_Fragment) {
                ((Tips1_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips2_Fragment) {
                ((Tips2_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips3_Fragment) {
                ((Tips3_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips4_Fragment) {
                ((Tips4_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips5_Fragment) {
                ((Tips5_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips6_Fragment) {
                ((Tips6_Fragment) f).onBackPressed();
            } else if (f != null && f instanceof Tips8_Fragment) {
                ((Tips8_Fragment) f).onBackPressed();
            }

        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn7) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips7_fragment fragment = new Tips7_fragment();
            transaction.replace(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn6) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips6_Fragment fragment = new Tips6_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn1) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips1_Fragment fragment = new Tips1_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn2) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips2_Fragment fragment = new Tips2_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn3) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips3_Fragment fragment = new Tips3_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn4) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips4_Fragment fragment = new Tips4_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn5) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips5_Fragment fragment = new Tips5_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        } else if (id == R.id.btn8) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Tips8_Fragment fragment = new Tips8_Fragment();
            transaction.add(R.id.frame, fragment).commit();
            constraintLayout.setVisibility(View.GONE);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.language_en){
            Paper.book().write("language","en");
            updateView((String) Paper.book().read("language"));
        }else if (item.getItemId()==R.id.language_bn) {
            Paper.book().write("language", "bn");
            updateView((String) Paper.book().read("language"));
        }
        return true;
    }
}

