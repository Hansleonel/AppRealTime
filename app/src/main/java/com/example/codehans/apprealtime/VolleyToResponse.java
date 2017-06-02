package com.example.codehans.apprealtime;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ogtie05 on 2/06/2017.
 */

public class VolleyToResponse {

    private static VolleyToResponse mVolleyTR = null;
    private RequestQueue mRequestQueue;

    private VolleyToResponse(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyToResponse getInstance(Context context) {
        if (mVolleyTR == null) {
            mVolleyTR = new VolleyToResponse(context);
        }
        return mVolleyTR;
    }

    public RequestQueue getRequestque() {
        return mRequestQueue;
    }

    public static void addToQueque(Request request, RequestQueue fRequestQueue, Context context, VolleyToResponse volley) {
        if (request != null) {
            request.setTag(context);
            if (fRequestQueue == null)
                fRequestQueue = volley.getRequestque();
            request.setRetryPolicy(new DefaultRetryPolicy(60000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            fRequestQueue.add(request);
        }
    }

}
