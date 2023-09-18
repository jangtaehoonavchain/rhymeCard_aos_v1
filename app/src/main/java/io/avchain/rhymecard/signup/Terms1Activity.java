package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.view.View;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupTerms1Binding;

public class Terms1Activity extends BasicActivity<ActivitySignupTerms1Binding> implements View.OnClickListener {

    @Override
    protected ActivitySignupTerms1Binding getBinding() {
        return ActivitySignupTerms1Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {
        binding.activitySignupTerms1Scrollview.terms1ScrollviewBtnOk.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.terms1_scrollview_btn_ok:

                Intent intent = new Intent(this, Terms2Activity.class);
                startActivity(intent);
                break;

        }
    }
}