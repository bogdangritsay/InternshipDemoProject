package com.hritsay.threebuttonsempty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hritsay.threebuttonsempty.databinding.FragmentSecondBinding;
import com.hritsay.threebuttonsempty.databinding.MyFragmentBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private MyFragment myFragment;
    private SecondFragment mySecondFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void goSite(View view) {

            String siteUrl = getResources().getString(R.string.site_url);
            Uri webpage = Uri.parse(siteUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!");
            }
        }

    public void goYouTube(View view) {
        String siteUrl = getResources().getString(R.string.youtube_url);
        Uri webpage = Uri.parse(siteUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void goFragment(View view) {
        myFragment = new MyFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.bottom_layout, myFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goSecondFragment(View view) {
        mySecondFragment = new SecondFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.bottom_layout, mySecondFragment, SecondFragment.TAG);
        ft.addToBackStack(MyFragment.TAG);
        ft.commit();
    }
}
