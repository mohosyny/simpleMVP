package diar.neo.simplemvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
            bottomNavigationView =findViewById(R.id.bttm_nav);
            NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.navHost_fragment);
            NavigationUI.setupWithNavController(bottomNavigationView,
                    navHostFragment.getNavController());

//
}


