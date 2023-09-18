/*
 * Copyright (c) 2023-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package io.avchain.rhymecard.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import io.avchain.rhymecard.databinding.ActivityIntroBinding;
import io.avchain.rhymecard.databinding.ActivitySplashBinding;
import io.avchain.rhymecard.signup.IntroActivity;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.config.CommonConfig;

public class SplashActivity extends BasicActivity<ActivitySplashBinding> implements View.OnClickListener {

    private ActivitySplashBinding binding;

    @Override
    protected ActivitySplashBinding getBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /** FCM 메시지 토큰 생성  */
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                Log.i(CommonConfig.APP_TAG, "#SplashActivity task.isSuccessful() " + task.isSuccessful());
                if(task.isSuccessful() == false) {
                    Log.i(CommonConfig.APP_TAG, "#SplashActivity Fetching FCM registration token failed " + task.getException());
                    return;
                }
                // Get new FCM registration token
                String token = task.getResult();
                Log.i(CommonConfig.APP_TAG, "#SplashActivity Fetching FCM token " + token);
            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(intent);
                finish(); // 스플래시 액티비티 종료
            }
        }, 3000); // 3초 후에 실행
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onClick(View v) {

    }
}