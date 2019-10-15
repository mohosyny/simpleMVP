package diar.neo.simplemvp.feature.saved;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;
import diar.neo.simplemvp.data.NewsAdapter;
import diar.neo.simplemvp.data.NewsRepository;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.feature.home.HomeContract;
import diar.neo.simplemvp.feature.home.HomeFragment;

public class SavedFragment extends BaseFragment implements SavedContract.View {

    private SavedContract.Presenter presenter;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;


    @Override
    public void setupViews() {
        Toolbar toolbar=rootView.findViewById(R.id.toolbar_fragment_saved);
        toolbar.setTitle(R.string.saved);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ( (AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        presenter = new SavedPresenter(new NewsRepository());
        recyclerView = rootView.findViewById(R.id.fragment_saved_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getViewContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_saved;
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
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void showSavedNews(List<News> news) {
        adapter = new NewsAdapter(getViewContext(), news);
        recyclerView.setAdapter(adapter);
    }
}
