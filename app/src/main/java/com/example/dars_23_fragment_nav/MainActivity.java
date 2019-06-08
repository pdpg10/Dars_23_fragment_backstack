package com.example.dars_23_fragment_nav;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.example.dars_23_fragment_nav.fragment.ForgotPasswordFragment;
import com.example.dars_23_fragment_nav.fragment.LoginFragment;
import com.example.dars_23_fragment_nav.fragment.RegisterFragment;
import com.example.dars_23_fragment_nav.fragment.ResetPassFragment;
import com.example.dars_23_fragment_nav.fragment.WelcomeFragment;

public class MainActivity
        extends BaseActivity
        implements LoginFragment.ILoginActions,
        RegisterFragment.IRegisterActions,
        ForgotPasswordFragment.IForgotActions,
        ResetPassFragment.IResetActions {
    private static final String TAG = "MainActivity";
    private boolean isRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
//            isRegistered = getPreferences().getBoolean()//read from pref
            if (isRegistered) {
                addFragment(new WelcomeFragment(), true);
            } else {
                addFragment(new LoginFragment(), false);
            }
        }
    }

    @Override
    public void onSignedIn() {
        // todo backStack vs replace issue
        replaceFragment(new WelcomeFragment(), false);
    }

    @Override
    public void onForgot() {
        addFragment(new ForgotPasswordFragment(), true);
    }

    @Override
    public void onRegister() {
        addFragment(new RegisterFragment(), true);
    }


    @Override
    public void onRegistered() {
//        onBackPressed();
        getSupportFragmentManager().popBackStack(); // activity finish()
    }

    @Override
    public void onForget() {
        replaceFragment(new ResetPassFragment(), true);
    }

    @Override
    public void onReseted() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
