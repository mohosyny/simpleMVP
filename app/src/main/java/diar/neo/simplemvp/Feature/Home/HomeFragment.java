package diar.neo.simplemvp.feature.home;

import android.content.Context;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;
import diar.neo.simplemvp.data.NewsAdapter;
import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.data.NewsRepository;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter presenter;
    private RecyclerView newsRecycler;
    private ImageView imgSlider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new HomePresenter(new NewsRepository());
    }


    @Override
    public void showNews(List<News> news) {

        newsRecycler.setAdapter(new NewsAdapter(getViewContext(),news,this));
    }

    @Override
    public void showBanners(List<Banner> banners) {
        Picasso.get().
                load(banners.get(0).getUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgSlider);
    }

    @Override
    public void showError(String s) {
        Toast.makeText(getViewContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }


    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void setupViews() {

        newsRecycler = rootView.findViewById(R.id.rv_home_fragment);
        imgSlider = rootView.findViewById(R.id.img_home_fragment_slider);
        newsRecycler.setLayoutManager(new LinearLayoutManager(getViewContext(), RecyclerView.VERTICAL, false));

    }



    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }
}
