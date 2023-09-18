package io.avchain.rhymecard.network.common;

import io.avchain.rhymecard.dto.response.ResponseDto;
import io.avchain.rhymecard.dto.request.LoginDto;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {

    // network/api/ClubApi

    @GET("club/bank/list")
    Call<ResponseDto> getClubBankList();

    @GET("club/category/list")
    Call<ResponseDto> getClubCategoryList();

    @GET("club/list/all")
    Call<ResponseDto> getClubListAll(@Query("parm") String parm);




  // network/api/MemberApi
    @Multipart
    @PUT("member/profile/update")
    Call<ResponseDto> putMemberProfileUpdate(@Header("Authorization") String authorization,@Part MultipartBody.Part imagePath);

    @GET("member/profile")
    Call<ResponseDto> getMemberProfile(@Header("Authorization") String authorization);



    // etc
    @Headers({"Content-Type: application/json"})
    @POST("login")
    Call<ResponseDto> getLoginData(@Body LoginDto user);


}
