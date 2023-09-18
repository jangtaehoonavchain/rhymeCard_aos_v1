package io.avchain.rhymecard;

        import android.view.View;

        import io.avchain.rhymecard.fragment.HomeFragment;
        import io.avchain.rhymecard.fragment.DetailFragment;
        import io.avchain.rhymecard.fragment.WalletFragment;
        import io.avchain.rhymecard.common.BasicActivity;
        import io.avchain.rhymecard.databinding.ActivityMainBinding;


public class MainActivity extends BasicActivity<ActivityMainBinding> implements View.OnClickListener {

    @Override
    protected ActivityMainBinding getBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

        switchFragment(new WalletFragment(), false, binding.activityMainFragment.getId());

    }

    @Override
    protected void initEvent() {

        binding.radioMainMenu.setOnCheckedChangeListener((radioGroup, i) -> {
            switch(i) {
                case R.id.bottom_home:
                    switchFragment(new HomeFragment(), false, binding.activityMainFragment.getId());
                    break;

                case R.id.bottom_wallet:
                    switchFragment(new WalletFragment(), false, binding.activityMainFragment.getId());
                    break;

                case R.id.bottom_more:
                    switchFragment(new DetailFragment(), false, binding.activityMainFragment.getId());
                    break;
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}