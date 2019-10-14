package diar.neo.simplemvp.feature.search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;
import diar.neo.simplemvp.data.NewsRepository;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.feature.home.NewsAdapter;

public class SearchFragment extends BaseFragment implements SearchContract.View {
    private SearchContract.Presenter presenter;
    private RecyclerView recyclerView;
    private List<News> newsList;
    private NewsAdapter newsAdapter;
    private EditText edtSearch;
    private TextView txtNotFound;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SearchPresenter(new NewsRepository());
        newsList = new ArrayList<>();
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
        txtNotFound = rootView.findViewById(R.id.txt_not_found);
        edtSearch = rootView.findViewById(R.id.edt_search);
        recyclerView = rootView.findViewById(R.id.search_fragment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getViewContext(), LinearLayoutManager.VERTICAL, false));
        // edtSearch.requestFocus();
        //  showKeyboard();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.getSearchedNews(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }


    @Override
    public void showSearchedNews(List<News> news) {
        newsList.clear();
        newsList = news;
        if (newsList.isEmpty()){
            txtNotFound.setVisibility(View.VISIBLE);
        }else {
            txtNotFound.setVisibility(View.GONE);
            newsAdapter = new NewsAdapter(getViewContext(), newsList);
            recyclerView.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();
        }
        edtSearch.clearFocus();

        //  closeKeyboard();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getViewContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        //  closeKeyboard();
    }

    private void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getViewContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

   private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getViewContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
