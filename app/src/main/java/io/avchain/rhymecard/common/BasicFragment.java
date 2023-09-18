package io.avchain.rhymecard.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

public abstract class BasicFragment<VB extends ViewBinding> extends Fragment implements View.OnClickListener {

    protected VB binding;
    protected Intent intent = null;

    protected abstract VB getBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.initBinding(inflater, container);
        View root = binding.getRoot();

        initView();
        initEvent();

        return root;
    }

    private void initBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = getBinding(inflater, container);
    }

    protected abstract void initView();
    protected abstract void initEvent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
