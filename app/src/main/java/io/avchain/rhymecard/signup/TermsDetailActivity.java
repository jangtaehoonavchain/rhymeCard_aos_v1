package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupTermsDetailBinding;

public class TermsDetailActivity extends BasicActivity<ActivitySignupTermsDetailBinding> implements View.OnClickListener {

    @Override
    protected ActivitySignupTermsDetailBinding getBinding() {
        return ActivitySignupTermsDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

        findViewById(R.id.TermsDetail_Top_backbtn).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TermsDetail_Top_backbtn:
                finish();
                break;
        }
    }
}
