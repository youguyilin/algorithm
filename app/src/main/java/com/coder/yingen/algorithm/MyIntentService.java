package com.coder.yingen.algorithm;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;


/**
 * PackageName: com.coder.yingen.algorithm
 * ClassName: MyIntentService
 * Author: chuyingen
 * Date: 2019-05-18 16:56
 * Description:
 */
public class MyIntentService extends IntentService {

    public MyIntentService(String name) {
        super(name);
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }


}
