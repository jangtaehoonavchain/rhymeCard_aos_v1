package io.avchain.rhymecard.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicFragment;
import io.avchain.rhymecard.createclub.CreateClub1Activity;
import io.avchain.rhymecard.databinding.FragmentWalletBinding;
import io.avchain.rhymecard.notification.NotificationActivity;

public class WalletFragment extends BasicFragment<FragmentWalletBinding> {


    @Override
    protected FragmentWalletBinding getBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentWalletBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

        // fragment_home_alarm_btn 클릭 이벤트 처리
        binding.fragmentWalletAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // NotificationActivity로 이동하는 인텐트 생성
                Intent intent = new Intent(getContext(), NotificationActivity.class);
                startActivity(intent); // NotificationActivity 시작
            }
        });

        binding.fragmentWalletScrollView.fragmentWalletScrollviewCreateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),CreateClub1Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}