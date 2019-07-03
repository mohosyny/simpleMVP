package diar.neo.simplemvp.feature.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import diar.neo.simplemvp.Constants;
import diar.neo.simplemvp.R;

public class DetailActivity extends AppCompatActivity {
    private String image_url, title, description, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getExtras();
        setupViews();

    }

    private void getExtras() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            image_url = bundle.getString(Constants.KEY_IMAGE);
            date = bundle.getString(Constants.KEY_DATE);
            title = bundle.getString(Constants.KEY_TITLE);
            description = bundle.getString(Constants.KEY_DESC);
        }

    }


    private void setupViews() {


        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.RIGHT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);


        ImageView imgMain = findViewById(R.id.img_detail);
        TextView txtDesc = findViewById(R.id.txt_detail_description);
        TextView txtDate = findViewById(R.id.txt_detail_date);
        TextView txtTitle = findViewById(R.id.txt_detail_title);

        Picasso.get().load(image_url).into(imgMain);
        txtDate.setText(date);
        txtTitle.setText(title);
        txtDesc.setText(description);

    }
}
