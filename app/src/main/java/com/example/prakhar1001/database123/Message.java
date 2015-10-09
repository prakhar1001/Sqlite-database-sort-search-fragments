package com.example.prakhar1001.database123;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Prakhar1001 on 10/9/2015.
 */

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

