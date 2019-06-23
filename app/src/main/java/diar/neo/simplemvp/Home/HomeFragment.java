package diar.neo.simplemvp.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;
import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.data.News;

public class HomeFragment extends BaseFragment implements HomeContract.View {

private HomeContract.Presenter presenter;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter=new HomePresenter();
    }


    @Override
    public void showNews(List<News> news) {

    }

    @Override
    public Context getViewContext() {
        return null;
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

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }
}
