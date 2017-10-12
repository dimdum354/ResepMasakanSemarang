package com.example.dimzs.resepmasakansemarang;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dimzs on 01-Oct-17.
 */

public class DetailActivity extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addImageID();
        bindData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String judul;
        String bahan [] = getResources().getStringArray(R.array.detail_resep);
        String cara [] = getResources().getStringArray(R.array.cara_resep);
        Intent  intent = getIntent();
        judul = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);
        TextView tv_judul = (TextView) findViewById(R.id.judul);
        TextView tv_bahan = (TextView) findViewById(R.id.bahan);
        TextView tv_keterangan = (TextView) findViewById(R.id.keterangan);
        ImageView image = (ImageView) findViewById(R.id.gambar);
        tv_judul.setText(judul);
        tv_bahan.setText(bahan[position]);
        tv_keterangan.setText(cara[position]);
        image.setImageResource(mImageID.get(position));

    }
    private void addImageID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.drawable.siji);
        mImageID.add(R.drawable.loro);
        mImageID.add(R.drawable.telu);
        mImageID.add(R.drawable.papat);
        mImageID.add(R.drawable.limo);
        mImageID.add(R.drawable.enem);
        mImageID.add(R.drawable.pitu);
        mImageID.add(R.drawable.wolu);
    }
}
