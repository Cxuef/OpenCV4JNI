package com.ckt.eirot.opencv4jni;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "OpenCV4JNI";
    private ImageView mImageView;
    private Bitmap bmp;
    private boolean switchStatus;

    static {
        System.loadLibrary("grayprocess");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.img_opencv);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ibeauty);
        mImageView.setImageBitmap(bmp);
        mImageView.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        doOpenCV();
    }

    private void doOpenCV() {
        Log.d(TAG, "----->>doOpenCV: switchStatus = " + switchStatus);
        if (switchStatus) {
            mImageView.setImageResource(R.drawable.ibeauty);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            switchStatus = false;
        }else {
            int w = bmp.getWidth();
            int h = bmp.getHeight();
            int[] pixels = new int[w*h];
            bmp.getPixels(pixels, 0, w, 0, 0, w, h);
            int[] resultInt = GrayProcess.grayProcess(pixels, w, h);
            Bitmap resultImg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);
            mImageView.setImageBitmap(resultImg);

            switchStatus = true;
            getWindow().setStatusBarColor(getResources().getColor(R.color.gray));
        }
    }
}
