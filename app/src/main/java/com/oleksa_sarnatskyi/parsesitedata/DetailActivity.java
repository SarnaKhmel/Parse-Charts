package com.oleksa_sarnatskyi.parsesitedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView titleTExtView, detailTextView;
    private String detailString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView);
        titleTExtView = findViewById(R.id.textView);
        detailTextView = findViewById(R.id.detailTextView);

        titleTExtView.setText(getIntent().getStringExtra("title"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(imageView);
        Content content = new Content();
        content.execute();

        configurateAnalyseButton();
    }

    private void  configurateAnalyseButton()
    {
        Button eventAnalyse = (Button) findViewById(R.id.eventAnalyse);
        eventAnalyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, AnalyseActivity.class));
            }
        });
    }

    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            detailTextView.setText(detailString);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String baseUrl = "https://afisha.vash.ua";
                String detailUrl = getIntent().getStringExtra("detailUrl");


                String url = baseUrl + detailUrl;

                Log.d("detail  full url ", url);
                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("div.new-text");

                detailString = data.select("div.new-text")
                        .text();
                Log.d("text log",  detailString);


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
