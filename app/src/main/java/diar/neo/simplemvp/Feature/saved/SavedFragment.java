package diar.neo.simplemvp.Feature.saved;

import android.content.Context;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;

public class SavedFragment extends BaseFragment implements SavedContract.View {
    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_saved;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }
}
