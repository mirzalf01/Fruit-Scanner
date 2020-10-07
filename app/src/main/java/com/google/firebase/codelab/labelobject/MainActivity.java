package com.google.firebase.codelab.labelobject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.codelab.labelobject.Helper.InternetCheck;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLLocalModel;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.io.IOException;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

    CameraView cameraView;
    ImageView btnDetect;
    AlertDialog waitingDialog;
    private FirebaseAutoMLLocalModel localModel;
    FirebaseVisionImageLabeler labeler;
    String message;

    public static final String EXTRA_MESSAGE = "com.google.firebase.codelab.labelobject.extra.MESSAGE";

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = findViewById(R.id.camera_view);
        btnDetect =findViewById(R.id.btn_detect);

        waitingDialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Please waiting . . .")
                .setCancelable(false).build();
        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                waitingDialog.show();
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, cameraView.getWidth(), cameraView.getHeight(), false);
                cameraView.stop();

                runDetector(bitmap);
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.start();
                cameraView.captureImage();
            }
        });
    }

    private void runDetector(Bitmap bitmap) {
        //buat objek firebasevisionimage dari data bitmap
        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        //load local model dataset yang telah dilatih
        localModel = new FirebaseAutoMLLocalModel.Builder()
                .setAssetFilePath("model/manifest.json")
                .build();
        try {
            //membuat model mengeluarkan output berupa pilihan dari masing-masing hasil dengan tingkat
            //kepercayaan 0,5f atau 50%
            FirebaseVisionOnDeviceAutoMLImageLabelerOptions options =
                    new FirebaseVisionOnDeviceAutoMLImageLabelerOptions.Builder(localModel)
                            .setConfidenceThreshold(0.5f)
                            .build();
            labeler = FirebaseVision.getInstance().getOnDeviceAutoMLImageLabeler(options);
            labeler.processImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
                @Override
                public void onSuccess(List<FirebaseVisionImageLabel> firebaseVisionImageLabels) {
                    processImageLabeler(firebaseVisionImageLabels);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("ERROR", e.getMessage());
                }
            });
        } catch (FirebaseMLException e) {
            // ...
        }

    }

    private void processImageLabeler(List<FirebaseVisionImageLabel> firebaseVisionImageLabels) {
        message = "";
        for (FirebaseVisionImageLabel label : firebaseVisionImageLabels){
            message = label.getText();
            break;
        }
        if (waitingDialog.isShowing())
            waitingDialog.dismiss();
        if (!message.equals("")){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, err.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}
