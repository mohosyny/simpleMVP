package diar.neo.simplemvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import diar.neo.simplemvp.Feature.Home.HomeFragment;
import diar.neo.simplemvp.Feature.category.CategoryFragment;
import diar.neo.simplemvp.Feature.saved.SavedFragment;
import diar.neo.simplemvp.Feature.search.SearchFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigation mBottomNavigation;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {

        mBottomNavigation = findViewById(R.id.bottom_navigation);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
        fragmentTransaction.commit();


        mBottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int i) {
                switch (i) {

                    case R.id.tab_navigation_home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                        fragmentTransaction.commit();
                        break;
                    case R.id.tab_navigation_search:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new SearchFragment());
                        fragmentTransaction.commit();
                        break;
                    case R.id.tab_navigation_category:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new CategoryFragment());
                        fragmentTransaction.commit();
                        break;
                    case R.id.tab_navigation_saved:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new SavedFragment());
                        fragmentTransaction.commit();
                        break;

                }
            }
        });


    }


    @Override
    public void onBackPressed() {

        if (mBottomNavigation.getSelectedItem() == 0) {
            super.onBackPressed();

        } else {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new SavedFragment());
            fragmentTransaction.commit();
            mBottomNavigation.setSelectedItem(0);

        }

    }
}


