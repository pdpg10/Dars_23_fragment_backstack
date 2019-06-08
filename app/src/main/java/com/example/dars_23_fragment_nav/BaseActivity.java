package com.example.dars_23_fragment_nav;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    public void addFragment(Fragment fragment,
                            boolean isAddToBS) {
        Log.d(TAG, "addFragment: ");
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root, fragment);
        if (isAddToBS) {
            ft.addToBackStack(fragment.getClass().getSimpleName());
        }
        ft.commit();

    }

    public void replaceFragment(Fragment fragment,
                                boolean isAddToBS) {
        Log.d(TAG, "replaceFragment: ");
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, fragment);
        if (isAddToBS) {
            ft.addToBackStack(fragment.getClass().getSimpleName());
        }
        ft.commit();
    }
}
