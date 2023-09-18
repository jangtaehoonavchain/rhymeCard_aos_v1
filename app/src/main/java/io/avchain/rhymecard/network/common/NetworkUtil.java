package io.avchain.rhymecard.network.common;


import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.avchain.rhymecard.config.CommonConfig;
import io.avchain.rhymecard.dto.response.ResponseDto;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;



public class NetworkUtil {

    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .cipherSuites(
                    CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
            .build();


    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

/*
* Connection Timeout
요청을 시작한 후 서버와의 TCP handshake가 완료되기까지 지속되는 시간이다. 즉, Retrofit이 설정된 연결 시간 제한 내에서 서버에 연결할 수없는 경우 해당 요청을 실패한 것으로 계산한다.
따라서 사용자의 인터넷 연결 상태가 좋지 않을때 기본 시간 제한인 10초를 더 높은 값으로 설정하면 좋다.

Read Timeout
읽기 시간 초과는 연결이 설정되면 모든 바이트가 전송되는 속도를 감시한다. 서버로부터의 응답까지의 시간이 읽기 시간 초과보다 크면 요청이 실패로 계산된다.
LongPolling을 위해 변경해 주어야 하는 설정값이다.

Write Timeout
쓰기 타임 아웃은 읽기 타임 아웃의 반대 방향이다. 얼마나 빨리 서버에 바이트를 보낼 수 있는지 확인한다.
* */

    private static OkHttpClient getNewHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.MINUTES); // Disable timeouts for read

        return enableTls12OnPreLollipop(clientBuilder).build();
    }

    public static NetworkService getNetworkService(String url, String token) {
        //Log.d("xanitus","[NetworkUtil --> getNetworkService(String url, String token)] url : " + token + "token : " + token);
        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        return restAdapter.create(NetworkService.class);
    }
    // 핸드폰인증시
    public static NetworkService getNetworkService(String url) {
        Log.d("xanitus","[NetworkUtil --> getNetworkService(String url) + okHttpClient] url " + url);
        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //.client(getNewHttpClient())  // 원래 없었음
                .baseUrl(url)
                .build();
        return restAdapter.create(NetworkService.class);
    }
    public static NetworkService getNetworkServiceBackground(String url) {
        Log.d("xanitus","[NetworkUtil --> getNetworkServiceBackground(String url) + okHttpClient] OkHttpClient url " + url);
        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getNewHttpClient())
                .baseUrl(url)
                .build();
        return restAdapter.create(NetworkService.class);
    }
    public static NetworkService getNetworkService(String url, int download) {
        Log.d("xanitus","[NetworkUtil --> getNetworkService(String url, int download)] url " + url + "download " + download);
        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        return restAdapter.create(NetworkService.class);
    }
    public void getData(String url) {
    }
    public void test() {
    }
    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder client) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            try {
                client.sslSocketFactory(new TLSSocketFactory());

                ConnectionSpec cs = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .build();

                List<ConnectionSpec> specs = new ArrayList<>();
                specs.add(cs);
                specs.add(ConnectionSpec.COMPATIBLE_TLS);
                specs.add(ConnectionSpec.CLEARTEXT);

                client.connectionSpecs(specs);
            } catch (Exception exc) {
                Log.e("OkHttpClientProvider", "Error while enabling TLS 1.2", exc);
            }
        }

        return client;
    }

    public static String getResponseJson(Response<ResponseDto> response, boolean object){
        Object data = response.body().getData();
        Log.d(CommonConfig.APP_TAG,"" );
        Log.d(CommonConfig.APP_TAG,"" );
        Log.d(CommonConfig.APP_TAG,"http response " + response );
        Log.d(CommonConfig.APP_TAG,"response data " + data.toString() );
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        if(object){
            JsonObject obj = parser.parse(gson.toJson( data )).getAsJsonObject();
            Log.d(CommonConfig.APP_TAG," JsonObject :  " + obj.toString());
            Log.d(CommonConfig.APP_TAG,"" );
            Log.d(CommonConfig.APP_TAG,"" );
            return obj.toString();
        }else{
            JsonArray jsonArray = parser.parse(gson.toJson( data )).getAsJsonArray();
            Log.d(CommonConfig.APP_TAG," JsonArray :  " + jsonArray.toString());
            Log.d(CommonConfig.APP_TAG,"" );
            Log.d(CommonConfig.APP_TAG,"" );
            return jsonArray.toString();
        }
    }

}
