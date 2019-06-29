package diar.neo.simplemvp.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import diar.neo.simplemvp.Const;
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
            image_url = bundle.getString(Const.KEY_IMAGE);
            date = bundle.getString(Const.KEY_DATE);
            title = bundle.getString(Const.KEY_TITLE);
            description=bundle.getString(Const.KEY_DESC);
        }

    }


    private void setupViews() {

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
