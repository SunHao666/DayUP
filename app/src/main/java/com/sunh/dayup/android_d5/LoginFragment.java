package com.sunh.dayup.android_d5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sunh.dayup.R;

/**
 * Created by jpwen on 2017/7/31.
 */

public class LoginFragment extends Fragment implements LoginContract.View,View.OnClickListener{

    private EditText et_name;
    private EditText et_pwd;
    private Button btn_login;

    LoginPresenter presenter = new LoginPresenter(this);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_pwd = (EditText) view.findViewById(R.id.et_pwd);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void showProgress() {
        Snackbar.make(et_name,"progress start ...",Snackbar.LENGTH_SHORT).show();
}

    @Override
    public void hideProgress() {
        Snackbar.make(et_name,"progress hide ...",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showErroreMessage(String error) {
        Snackbar.make(et_name,error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void complete() {
        Snackbar.make(et_name,"任务完成",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        presenter.login(et_name.getText().toString(),et_pwd.getText().toString());
    }
}
