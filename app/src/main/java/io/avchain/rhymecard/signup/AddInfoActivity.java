package io.avchain.rhymecard.signup;

import android.content.Intent;
import android.view.View;

import io.avchain.rhymecard.MainActivity;
import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.databinding.ActivitySignupAddinfoBinding;

public class AddInfoActivity extends BasicActivity<ActivitySignupAddinfoBinding> implements View.OnClickListener {


    @Override
    protected ActivitySignupAddinfoBinding getBinding() {
        return ActivitySignupAddinfoBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

        binding.activitySignupAddinfoScrollview.componentEditEmailEditText.setHint("이메일 입력");
        binding.activitySignupAddinfoScrollview.addinfoBtnOk.setOnClickListener(this::onClick);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addinfo_btn_ok:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}
