package diar.neo.simplemvp.Feature.search;

import android.content.Context;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;

public class SearchFragment extends BaseFragment implements SearchContract.View {
    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }
}
