package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.view.View;

import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupCertification3Binding;
import io.avchain.rhymecard.databinding.ActivitySignupCertification4Binding;

public class Certification4Activity extends BasicActivity<ActivitySignupCertification4Binding> implements View.OnClickListener{
    @Override
    protected ActivitySignupCertification4Binding getBinding() {
        return ActivitySignupCertification4Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

        binding.activitySignupCertification4Scrollview.certi4BtnOk.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.certi4_btn_ok:

                Intent intent = new Intent(this, AddInfoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
