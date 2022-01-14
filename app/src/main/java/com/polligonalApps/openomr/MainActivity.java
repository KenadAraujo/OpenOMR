package com.polligonalApps.openomr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private CameraPreview cameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.camera = getInstanciaCamera();

        this.cameraPreview = new CameraPreview(this,this.camera);
        FrameLayout preview = findViewById(R.id.camera_preview);
        preview.addView(this.cameraPreview);
    }

    private boolean verificaSeACameraExiste(Context contexto){
        return contexto.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
    private Camera getInstanciaCamera(){
        Camera c = null;
        c = Camera.open();
        return c;
    }
}