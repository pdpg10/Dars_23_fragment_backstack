package com.example.dars_23_fragment_nav.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dars_23_fragment_nav.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private ILoginActions loginActions;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginActions.onSignedIn();
            }
        });
        view.findViewById(R.id.btn_reg).setOnClickListener(v -> loginActions.onRegister());
        view.findViewById(R.id.btn_forgot).setOnClickListener(v -> loginActions.onForgot());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ILoginActions) {
            loginActions = (ILoginActions) context;
        } else {
            throw new IllegalStateException("need to implement ILoginActions class");
        }

    }

    public interface ILoginActions {

        void onSignedIn();

        void onForgot();

        void onRegister();
    }
}
