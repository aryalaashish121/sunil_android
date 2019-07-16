package CreateChannel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {

    Context context;
    public static String CHANNEL_1="Channel1";
    public static String CHANNEL_2="Channel2";

    public CreateChannel(Context context) {
        this.context = context;
    }

    public void createChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)

        {
            NotificationChannel chnnel1=new NotificationChannel(
                    CHANNEL_1,"Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            chnnel1.setDescription("This is chanel 1");

            NotificationChannel channel2=new NotificationChannel(
                    CHANNEL_2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is channel 2");

            NotificationManager manager=context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chnnel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
