package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    String mResult = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public void testAsyncTask() throws InterruptedException{
        final CountDownLatch signal = new CountDownLatch(1);

        EndpointsAsyncTaskTest task = new EndpointsAsyncTaskTest();
        task.setListener(new EndpointsAsyncTaskTest.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String string, Exception e) {
                mResult = string;
                mError = e;
                signal.countDown();
            }
        }).execute(new Pair<Context, String>(this.getContext(), "MisterX"));
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mResult));
    }
}