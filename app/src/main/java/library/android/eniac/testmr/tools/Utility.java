package library.android.eniac.testmr.tools;

import android.Manifest;
import android.content.Context;
import android.content.Intent;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public class Utility {

    public static String getAssetJsonData(Context context, String jsonFile) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    public static Boolean checkLocationPermission(Context context) {
        final boolean[] hasPermission = {false};
        new TedPermission(context)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                        hasPermission[0] = true;

                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        hasPermission[0] = false;
                    }
                })
                .setDeniedMessage("If you reject permission,you can not use this application, Please turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

        return hasPermission[0];
    }


}
