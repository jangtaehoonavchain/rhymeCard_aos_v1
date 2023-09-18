package io.avchain.rhymecard.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import io.avchain.rhymecard.sqlite.common.DBManager;

public abstract class BasicActivity<VB extends ViewBinding> extends AppCompatActivity implements View.OnClickListener{

    protected VB binding;
    protected Intent intent = null;
    protected FragmentManager fm;
    protected DBManager dbManager;

    protected abstract VB getBinding();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initBinding();
        setContentView(binding.getRoot());

        this.dbManager = new DBManager(getApplicationContext());

        initView();
        initEvent();
    }

    public DBManager getDBManager() {
        return this.dbManager;
    }

    @Override
    public void onDestroy() {
        dbManager.close();
        super.onDestroy();
    }

    private void initBinding() {
        binding = getBinding();
    }

    protected abstract void initView();
    protected abstract void initEvent();

    protected void switchFragment(Fragment frag, boolean isAddBackStack, int resId) {
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(resId, frag);
        if(isAddBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void getDevecId(){

    }
}
