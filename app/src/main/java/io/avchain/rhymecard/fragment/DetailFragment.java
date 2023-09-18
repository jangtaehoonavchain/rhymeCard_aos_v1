package io.avchain.rhymecard.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicFragment;
import io.avchain.rhymecard.databinding.FragmentDetailBinding;
import io.avchain.rhymecard.notification.NotificationActivity;
import io.avchain.rhymecard.profile.ManageProfileActivity;


public class DetailFragment extends BasicFragment<FragmentDetailBinding> {



    @Override
    protected FragmentDetailBinding getBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentDetailBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

        binding.fragmentMoreScrollView.componentListConstraintlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ManageProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}