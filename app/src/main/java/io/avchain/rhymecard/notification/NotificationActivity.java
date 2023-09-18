package io.avchain.rhymecard.notification;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivityNotificationBinding;

public class NotificationActivity extends BasicActivity<ActivityNotificationBinding> implements View.OnClickListener {

    private ImageButton cancelBtn;

    @Override
    protected ActivityNotificationBinding getBinding() {
        return ActivityNotificationBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        cancelBtn = binding.NotificationCancelBtn;
    }

    @Override
    protected void initEvent() {
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Notification_cancel_btn) {
            // Notification_cancel_btn을 눌렀을 때 실행될 코드
            finish(); // 현재 활동 종료하여 이전 화면으로 돌아감
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}