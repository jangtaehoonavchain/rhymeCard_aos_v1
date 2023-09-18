package io.avchain.rhymecard.network.api;

import android.util.Log;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import io.avchain.rhymecard.config.CommonConfig;
import io.avchain.rhymecard.dto.response.BankDto;
import io.avchain.rhymecard.dto.response.ClubCategoryDto;
import io.avchain.rhymecard.dto.response.ClubDto;
import io.avchain.rhymecard.dto.response.ResponseDto;
import io.avchain.rhymecard.network.common.NetworkService;
import io.avchain.rhymecard.network.common.NetworkUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubApi {

    public static void  getClubBankList(){
        NetworkService service = NetworkUtil.getNetworkService(CommonConfig.DID_SERVER_URL);
        Call<ResponseDto> res = service.getClubBankList();
        res.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                String json = NetworkUtil.getResponseJson(response,false);  // JsonArray 일때 false
                ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                try {
                    List<BankDto> dto = objectMapper.readValue(json, new TypeReference<List<BankDto>>(){});
                    Log.d(CommonConfig.APP_TAG,"성공 : BankListDto " + dto.get(0).getDisplay() );
                } catch (IOException e) {
                    Log.d(CommonConfig.APP_TAG,"실패 : BankListDto " + e.getMessage() );
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.e(CommonConfig.APP_TAG,"Network Fail : " + t.getLocalizedMessage());
            }
        });
    }

    public static void  getClubCategoryList(){
        NetworkService service = NetworkUtil.getNetworkService(CommonConfig.DID_SERVER_URL);
        Call<ResponseDto> res = service.getClubCategoryList();
        res.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                String json = NetworkUtil.getResponseJson(response,false);  // JsonArray 일때 false
                ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                try {
                    List<ClubCategoryDto> dto = objectMapper.readValue(json, new TypeReference<List<ClubCategoryDto>>(){});
                    Log.d(CommonConfig.APP_TAG,"성공 : bankListDto " + dto.get(0).getDisplay() );
                    Log.d(CommonConfig.APP_TAG,"성공 : bankListDto " + dto.get(0).getClubCategoryitem().get(0).getItemDispaly() );
                } catch (IOException e) {
                    Log.d(CommonConfig.APP_TAG,"실패 : bankListDto " + e.getMessage() );
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.e(CommonConfig.APP_TAG,"Network Fail : " + t.getLocalizedMessage());
            }
        });
    }


    public static void  getClubListAll(){
        String parm = "page=0&size=10&sort=clubSeq,desc";
        NetworkService service = NetworkUtil.getNetworkService(CommonConfig.DID_SERVER_URL);
        Call<ResponseDto> res = service.getClubListAll(parm);
        res.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                String json = NetworkUtil.getResponseJson(response,true);  // JsonArray 일때 false
                ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                try {
                    ClubDto dto = objectMapper.readValue(json, new TypeReference<ClubDto>(){});
                    Log.d(CommonConfig.APP_TAG,"성공 : ClubDto " + dto.getContent().get(0).getClubSeq() );
                } catch (IOException e) {
                    Log.d(CommonConfig.APP_TAG,"실패 : ClubDto " + e.getMessage() );
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.e(CommonConfig.APP_TAG,"Network Fail : " + t.getLocalizedMessage());
            }
        });
    }
}
