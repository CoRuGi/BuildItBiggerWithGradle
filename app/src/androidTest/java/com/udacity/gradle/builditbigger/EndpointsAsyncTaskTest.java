package com.udacity.gradle.builditbigger;

public class EndpointsAsyncTaskTest extends EndpointsAsyncTask {

    private EndpointsAsyncTaskListener mListener = null;
    private Exception mError = null;

    public EndpointsAsyncTask setListener(EndpointsAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }

    @Override
    protected void onPostExecute(String result) {
        if (this.mListener != null) {
            this.mListener.onComplete(result, mError);
        }
    }

    @Override
    protected void onCancelled() {
        if (this.mListener != null) {
            mError = new InterruptedException("AsyncTask cancelled");
            this.mListener.onComplete(null, mError);
        }
    }

    public static interface EndpointsAsyncTaskListener {
        public void onComplete(String string, Exception e);
    }

}
