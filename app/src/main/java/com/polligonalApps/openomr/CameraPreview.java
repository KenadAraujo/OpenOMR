package com.polligonalApps.openomr;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private Camera camera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        try {
            this.camera.setPreviewDisplay(this.holder);
            this.camera.startPreview();
        } catch (IOException e) {
            Log.d("CAMERA", "Error setting camera preview: " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        if(this.holder == null ){
            return;
        }
        try{
            this.camera.stopPreview();
        }catch (Exception e){
            Log.d("CAMERA", "Error setting camera preview: " + e.getMessage());
        }
        try{
            this.camera.setPreviewDisplay(this.holder);
            this.camera.startPreview();
        }catch (Exception e){
            Log.d("CAMERA", "Error setting camera preview: " + e.getMessage());
        }
    }
}
