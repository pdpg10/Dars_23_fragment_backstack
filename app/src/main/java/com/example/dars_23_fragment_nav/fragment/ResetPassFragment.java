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
public class ResetPassFragment extends Fragment {
    private ResetPassFragment.IResetActions registerActions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(v -> registerActions.onReseted());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ResetPassFragment.IResetActions) {
            registerActions = (ResetPassFragment.IResetActions) context;
        } else {
            throw new IllegalStateException("need to implement IRegisterActions class");
        }
    }

    public interface IResetActions {
        void onReseted();
    }

}
