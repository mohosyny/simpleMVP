package diar.neo.simplemvp.Feature.category;

import android.content.Context;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;

public class CategoryFragment extends BaseFragment implements CategoryContract.View {
    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_category;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }
}
