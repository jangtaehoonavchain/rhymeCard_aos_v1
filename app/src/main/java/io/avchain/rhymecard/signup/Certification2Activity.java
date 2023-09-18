package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupCertification2Binding;

public class Certification2Activity extends BasicActivity<ActivitySignupCertification2Binding> implements View.OnClickListener {


    private TextView timerTextView;
    private CountDownTimer countDownTimer;


    @Override
    protected ActivitySignupCertification2Binding getBinding() {
        return ActivitySignupCertification2Binding.inflate(getLayoutInflater());

    }

    @Override
    protected void initView() {

        EditText verificationCodeEditText = findViewById(R.id.certification2_scrollview_constraint1_verification_code_section_edittxt);
        final AppCompatButton button = findViewById(R.id.certification1_scrollview_constraint2_btn_ok);

        timerTextView = findViewById(R.id.certification2_scrollview_constraint1_verification_code_section_resttime);



        verificationCodeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 텍스트 변경 전에 호출되는 메서드
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트가 변경될 때 호출되는 메서드
                // 여기서 텍스트가 비어있지 않으면 버튼의 배경색을 변경할 수 있습니다.
                if (s.length() > 0) {
                    button.setBackgroundResource(R.drawable.combine_btn_long_blue);
                } else {
                    button.setBackgroundResource(R.drawable.component_btn_long_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트 변경 후에 호출되는 메서드
            }
        });

        // 3분 타이머를 생성하고 시작합니다.
        countDownTimer = new CountDownTimer(180000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = (millisUntilFinished / 1000) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeString = String.format("%02d:%02d", minutes, seconds);
                timerTextView.setText(timeString);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("00:00"); // 타이머 종료 시 00:00으로 설정
                // 여기에서 필요한 작업을 수행하세요.
            }
        };

        countDownTimer.start(); // 타이머 시작
    }

    @Override
    protected void initEvent() {
       binding.activitySignupCertification2Scrollview.certification1ScrollviewConstraint2BtnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.certification1_scrollview_constraint2_btn_ok:
                Intent intent = new Intent(this, Certification3Activity.class);
                startActivity(intent);
                break;

            case R.id.Cettification2_Top_main_backbtn:
                finish();
                break;
        }
    }
}