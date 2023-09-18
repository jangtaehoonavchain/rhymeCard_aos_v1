/***************************************************************************************************
 * File Name    : FirebaseMessageService.java
 * Function     :
 * Author       : eXMobile
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * =================================================================================================
 * Ver  Date        Author     Modification
 * =================================================================================================
 1.0    2019.06.21  최명호
 1.1    2019.07.26  최명호    Notification -> Data 사용으로 수정함
 **************************************************************************************************/
package io.avchain.rhymecard.util.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import io.avchain.rhymecard.MainActivity;
import io.avchain.rhymecard.config.CommonConfig;
import io.avchain.rhymecard.R;

// DESC >> FirebaseMessageService Firebase 알림 서비스 클래스
public class FirebaseMessageService extends FirebaseMessagingService {
    private static final String TAG = "AvatarBeansMsgService";
    private static final String MESSAGE_TITLE = "아바타빈즈";
    public static final int NOTIFICATION_REQUEST_CODE = 8102;
    public static final int NOTIFICATION_ID = 0;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            handleNow(remoteMessage);
        }
        Log.d(CommonConfig.APP_TAG, "Message Notification Title: " + remoteMessage.getData().get("title"));
        Log.d(CommonConfig.APP_TAG, "Message Notification Body: " + remoteMessage.getData().get("body"));
        sendNotification(remoteMessage.getData().get("body"));
    }
    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_REQUEST_CODE /* Request code */, intent,PendingIntent.FLAG_IMMUTABLE);
        String channelId = getString(R.string.notification_channel_id);
        String channelName = getString(R.string.notification_channel_name);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.app_icon)
                        .setContentTitle(MESSAGE_TITLE)
                        .setContentText(messageBody)
                        .setSound(defaultSoundUri)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setContentIntent(pendingIntent);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("아바타헬스 검사기록/진료일정/기타메시지 알림입니다.");
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(NOTIFICATION_ID /* ID of notification */, notificationBuilder.build());
    }
    @Override
    public void onNewToken(String token) {
        Log.d(CommonConfig.APP_TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }
    private void handleNow(RemoteMessage remoteMessage) {

        Log.d(CommonConfig.APP_TAG, "remoteMessage : " + remoteMessage.getData().get("body"));
//        SharedPrefUtil.init(getApplicationContext());
//        DBManager dbManager = new DBManager(getApplicationContext());
//        NotificationData data = new NotificationData();
//        String userId = SharedPrefUtil.getString("ID", "");
//        data.setUserId(userId);
//        data.setReadFlag("F");
//        data.setMessage(remoteMessage.getData().get("body"));
//        dbManager.insertAlertData(data);
//        Intent broadcastIntent = new Intent(MainActivity.INTENT_FILTER);
//        broadcastIntent.putExtra("update", true);
//        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);
    }
    private void sendRegistrationToServer(String token) {
//        SharedPrefUtil.init(getApplicationContext());
//        SharedPrefUtil.putString("deviceId", token);
    }
}
