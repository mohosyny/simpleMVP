package diar.neo.simplemvp.feature.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import diar.neo.simplemvp.Constants;
import diar.neo.simplemvp.R;

public class DetailFragment extends Fragment {
    private String image_url, title, description, date;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            image_url = getArguments().getString(Constants.KEY_IMAGE);
            date = getArguments().getString(Constants.KEY_DATE);
            title = getArguments().getString(Constants.KEY_TITLE);
            description = getArguments().getString(Constants.KEY_DESC);

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.RIGHT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);


        ImageView imgMain = view.findViewById(R.id.img_detail);
        TextView txtDesc = view.findViewById(R.id.txt_detail_description);
        TextView txtDate = view.findViewById(R.id.txt_detail_date);
        TextView txtTitle = view.findViewById(R.id.txt_detail_title);

        Picasso.get().load(image_url).into(imgMain);
        txtDate.setText(date);
        txtTitle.setText(title);
        txtDesc.setText(description);
    }

}
