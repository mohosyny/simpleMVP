package diar.neo.simplemvp.feature.category;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;
import diar.neo.simplemvp.data.Category;
import diar.neo.simplemvp.data.NewsRepository;

public class CategoryFragment extends BaseFragment implements CategoryContract.View {

    private CategoryContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new CategoryPresenter(new NewsRepository());
    }


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.detachView();
    }
    @Override
    public void setupViews() {
        Toolbar toolbar=rootView.findViewById(R.id.toolbar_frament_category);
        toolbar.setTitle(R.string.category);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ( (AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        mRecyclerView=rootView.findViewById(R.id.rv_category_fragment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getViewContext(),RecyclerView.VERTICAL,false)); }

    @Override
    public int getLayout() {
        return R.layout.fragment_category;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void showCategory(List<Category> categoryList) {
        mRecyclerView.setAdapter(new CategoryAdapter(getViewContext(),categoryList));

    }

    @Override
    public void showError(String s) {
        Toast.makeText(getViewContext(), s, Toast.LENGTH_SHORT).show();
    }
}
