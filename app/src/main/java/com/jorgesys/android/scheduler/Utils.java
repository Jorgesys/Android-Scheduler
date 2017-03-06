package com.jorgesys.android.scheduler;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jorgesys on 12/12/12.
 */

public class Utils {

    private static final String TAG = "Utils";
    private static final String EN = "en";
    private static final String US = "US";

    public static final int TOAST_TOP = 0;
    public static final int TOAST_CENTER = 1;
    public static final int TOAST_BOTTOM = 2;
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static void showCustomToast(String msg, int duration, int position, Context ctx){
        try{
            if(!"".equals(msg)){
                LayoutInflater inflater = LayoutInflater.from(ctx);
                View layout = inflater.inflate(R.layout.toast_custom, null);
                TextView text = (TextView) layout.findViewById(R.id.textToShow);
                text.setText(msg);
                Toast toast = new Toast(ctx.getApplicationContext());
                switch(position){
                    case TOAST_TOP:
                        toast.setGravity(Gravity.TOP, 0, 0);
                        break;
                    case TOAST_CENTER:
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        break;
                    case TOAST_BOTTOM:
                    default:
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        break;
                }

                toast.setDuration(duration);
                toast.setView(layout);
                toast.show();
            }
        }catch(IllegalStateException ise){
            Log.e(TAG, "ise showCustomToast(), " + ise.getMessage());
        }catch(Exception e){
            Log.e(TAG, "e showCustomToast(), " + e.getMessage());
        }
    }

}
