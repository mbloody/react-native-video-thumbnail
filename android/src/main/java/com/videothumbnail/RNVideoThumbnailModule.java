package com.videothumbnail;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Base64;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class RNVideoThumbnailModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNVideoThumbnailModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNVideoThumbnail";
  }

  @ReactMethod
  public void get(String filePath, Promise promise) {
    filePath = filePath.replace("file://","");
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    retriever.setDataSource(filePath);
    Bitmap image = retriever.getFrameAtTime();
    if (image != null) {
        String encoded = "data:image/png;base64," + convertBitmapToBase64(image);
        WritableMap map = Arguments.createMap();

        map.putString("data", encoded);
        map.putDouble("width", image.getWidth());
        map.putDouble("height", image.getHeight());

        promise.resolve(map);
    } else {
      promise.reject("E_RNVideoThumbnail_ERROR", "could not get thumbnail");
    }
  }

  private String convertBitmapToBase64(Bitmap bitmap) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
    byte[] byteArray = byteArrayOutputStream.toByteArray();
    return Base64.encodeToString(byteArray, Base64.DEFAULT);
  }

}