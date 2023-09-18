package io.avchain.rhymecard.signup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.avchain.rhymecard.MainActivity;
import io.avchain.rhymecard.R;
import io.avchain.rhymecard.common.BasicActivity;
import io.avchain.rhymecard.config.CommonConfig;
import io.avchain.rhymecard.config.RhymeCardConfig;
import io.avchain.rhymecard.databinding.ActivityIntroBinding;
import io.avchain.rhymecard.network.api.ClubApi;
import io.avchain.rhymecard.network.api.MemberApi;

public class IntroActivity extends BasicActivity<ActivityIntroBinding> implements View.OnClickListener {
    public static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected ActivityIntroBinding getBinding() {
        return ActivityIntroBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {

        /* Network Api TEST jang */
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJJRDIwMjMwOTE1MDk0MzI1MzUzNCIsImlzc3VlIjoiMjAyMzA5MTgxODIyMDQiLCJhdXRoIjoidXNlciIsIm9yZ2FuaXphdGlvbiI6InNudWJpIiwibmFtZSI6Iuyepe2DnO2biCIsImlkIjoiSUQyMDIzMDkxNTA5NDMyNTM1MzQiLCJhdmF0YXIiOiJ1c2VyIiwiZGVwYXJ0bWVudCI6ImRpYWx5c2lzIiwidGl0bGUiOiJwYXRpZW50IiwiZGV2aWNlLWlkIjpbImM0Z1l4Z194U04yZ1BPdFBvMVdKNU86QVBBOTFiSEs3ZFFESTAxcXBhTjNZY19UZGJHZVBnZzVDTTVWdWNxb3V6ampTWUsxYjh1NVB0NENKV0g1dDNBN3dkWkZKbm9KRk1mQjRXX1ZhRlBmVG01Mi1wNW5SRGxYQWZtZEgxcld2eW5weXZUOElkVDE5RU8tMjl4clVPYmlrbjlSejZxOGF0NzQiXX0.7qQUIs0j7xr2WtWEsaFzwmG57-bKca56wakZBuXuUcxbuWVOw4D1zhBDtjG442_JTlDJDMbALBoELA8nG5E1hA";
        RhymeCardConfig.getInstance().setToken(token);

        //ClubApi.getClubBankList();
        //ClubApi.getClubCategoryList();
        //ClubApi.getClubListAll();
        //MemberApi.getMemberProfile();





        //Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //this.startActivityForResult(intent, PICK_IMAGE_REQUEST);
        //MemberApi.putMemberProfileUpdate();
        /* Network Api TEST jang */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImageUri = data.getData();
        //File file = MemberApi.convertUriToFile(this,selectedImageUri);
        Log.d(CommonConfig.APP_TAG,"selectedImageUri " + selectedImageUri );

        File file = new File(MemberApi.getRealPathFromUri(this, selectedImageUri));
        MemberApi.putMemberProfileUpdate(file);

    }



    @Override
    protected void initEvent() {
        binding.activityIntroScrollview.btnEnter.setOnClickListener(this::onClick);

        binding.activityIntroScrollview.btnRestore.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_enter:

                Intent intent = new Intent(this, Terms1Activity.class);
                startActivity(intent);
                break;

            case R.id.btn_restore:

                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;

        }
    }
}