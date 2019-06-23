package diar.neo.simplemvp.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import diar.neo.simplemvp.data.News;

public class HomeFragment extends Fragment implements HomeContract.View {

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
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
