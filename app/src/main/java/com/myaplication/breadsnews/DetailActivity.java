package com.myaplication.breadsnews;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Blob;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvPenjelasan;
    private TextView tvDaerah;
    private TextView tvaHargaRendah;
    private TextView tvaHargaTinggi;
    private int hargaRendah;
    private int hargaTinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle(getIntent().getStringExtra("nama_batik"));
        tvPenjelasan.setText(getIntent().getStringExtra("makna_batik"));
        tvDaerah.setText("Asal Daerah Batik: " + getIntent().getStringExtra( "daerah_batik"));
        tvaHargaRendah.setText("Harga Terendah Batik: Rp  " + (getIntent().getIntExtra("harga_rendah", hargaRendah)));
        tvaHargaTinggi.setText("Harga Tertinggi Batik: Rp  " + (getIntent().getIntExtra("harga_tinggi", hargaTinggi)));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("link_batik")).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(ivDetail);

        FloatingActionButton fab = findViewById(R.id.share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gambar = "Link gambar Batik : " + getIntent().getStringExtra("link_batik");
                String namabatik = "Nama Batik : " + getIntent().getStringExtra("nama_batik");
                String asalbatik = "Asal daerah batik : " + getIntent().getStringExtra("daerah_batik");
                String penjelasan = "Makna Batik :" + getIntent().getStringExtra("makna_batik");
                String hargatinggi = "Harga Tertinggi : " + getIntent().getIntExtra("harga_tinggi", hargaTinggi);
                String hargarendah = "Harga Terendah : " + getIntent().getIntExtra("harga_rendah", hargaRendah);

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, namabatik + "\n\n" + asalbatik + "\n\n" + penjelasan +
                        "\n\n" + hargatinggi + "\n\n" + hargarendah + "\n\n" + gambar);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, "Bagikan ke :");
                startActivity(shareIntent);
            }
        });
    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        tvPenjelasan = findViewById(R.id.tv_penjelasan);
        tvDaerah = findViewById(R.id.tv_daerah);
        tvaHargaRendah = findViewById(R.id.tv_hargarendah);
        tvaHargaTinggi = findViewById(R.id.tv_hargatinggi);
    }
}