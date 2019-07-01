package diar.neo.simplemvp.Feature.category;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;

public interface CategoryContract {

    interface View extends BaseView{}
    interface Presenter extends BasePresenter<View>{}



}
