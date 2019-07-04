package diar.neo.simplemvp.feature.search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.base.BaseFragment;

public class SearchFragment extends BaseFragment implements SearchContract.View {
    @Override
    public void setupViews() {

        EditText edtSearch = rootView.findViewById(R.id.edt_search);
        edtSearch.requestFocus();
        showKeyboard();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getViewContext(), s, Toast.LENGTH_SHORT).show();
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


    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getViewContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getViewContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
