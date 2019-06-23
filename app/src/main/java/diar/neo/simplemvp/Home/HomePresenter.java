package diar.neo.simplemvp.Home;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

    @Override
    public void getNews() {

    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }
}
