package io.avchain.rhymecard.network.api;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import io.avchain.rhymecard.config.CommonConfig;
import io.avchain.rhymecard.config.RhymeCardConfig;
import io.avchain.rhymecard.dto.response.BankDto;
import io.avchain.rhymecard.dto.response.ClubCategoryDto;
import io.avchain.rhymecard.dto.response.ClubDto;
import io.avchain.rhymecard.dto.response.MemberProfileDto;
import io.avchain.rhymecard.dto.response.ResponseDto;
import io.avchain.rhymecard.network.common.NetworkService;
import io.avchain.rhymecard.network.common.NetworkUtil;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberApi {

    public static void  getMemberProfile(){
        NetworkService service = NetworkUtil.getNetworkService(CommonConfig.DID_SERVER_URL);
        Call<ResponseDto> res = service.getMemberProfile("Bearer " + RhymeCardConfig.getInstance().getToken());
        res.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                String json = NetworkUtil.getResponseJson(response,true);  // JsonArray 일때 false
                ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                try {
                    MemberProfileDto memberProfileDto = objectMapper.readValue(json, MemberProfileDto.class);
                    Log.d(CommonConfig.APP_TAG,"성공 : getMobileNumber " + memberProfileDto.getMobileNumber() );
                    Log.d(CommonConfig.APP_TAG,"성공 : getMemberDid " + memberProfileDto.getMemberDid().size() );
                } catch (IOException e) {
                    Log.d(CommonConfig.APP_TAG,"실패 : memberProfileDto " + e.getMessage() );
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.e(CommonConfig.APP_TAG,"실패 : " + t.getLocalizedMessage());
            }
        });
    }

    public static void  putMemberProfileUpdate(File imageFile){

//        String imagePath = "/path/to/your/local/image.jpg";
//        File imageFile = new File(imagePath);
        Log.d(CommonConfig.APP_TAG,"imageFile " + imageFile.getName() );
        Log.d(CommonConfig.APP_TAG,"imageFile " + imageFile.length() );

        NetworkService service = NetworkUtil.getNetworkService(CommonConfig.DID_SERVER_URL_LOCAL);

//        RequestBody imageRequestBody = RequestBody.create(MediaType.parse("image/png"), imageFile);
//        MultipartBody.Part imagePart = MultipartBody.Part.createFormData("imagePath", imageFile.getName(), imageRequestBody);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imagePath", imageFile.getName(), requestFile);

        Call<ResponseDto> res = service.putMemberProfileUpdate("Bearer " + RhymeCardConfig.getInstance().getToken(),body);

        res.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                Log.d(CommonConfig.APP_TAG,"성공 : response " + response );
            }
            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.e(CommonConfig.APP_TAG,"실패 : " + t.getLocalizedMessage());
            }
        });
    }



    public static File convertUriToFile(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }

        // Check if the URI scheme is "content" and whether it represents a file
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    String filePath = cursor.getString(columnIndex);
                    if (filePath != null) {
                        return new File(filePath);
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // If the URI scheme is "file," you can directly get the file path
            return new File(uri.getPath());
        }

        // If none of the above methods work, you can create a temporary file
        return createTempFileFromUri(context, uri);
    }

    private static File createTempFileFromUri(Context context, Uri uri) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return null;
            }

            // Create a temporary file in the app's cache directory
            File tempFile = new File(context.getCacheDir(), "temp_image");
            tempFile.createNewFile();

            OutputStream outputStream = new FileOutputStream(tempFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRealPathFromUri(Context context, Uri uri) {
        String filePath = null;

        // Check for different URI schemes
        final String scheme = uri.getScheme();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                // ExternalStorageProvider
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    filePath = context.getExternalFilesDir(null) + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                // DownloadsProvider
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));

                filePath = getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(uri)) {
                // MediaProvider
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                filePath = getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(scheme)) {
            // MediaStore (and general)
            filePath = getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(scheme)) {
            // File
            filePath = uri.getPath();
        }

        return filePath;
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(columnIndex);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

}
