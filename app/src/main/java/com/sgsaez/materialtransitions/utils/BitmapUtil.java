package com.sgsaez.materialtransitions.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import java.util.UUID;

public class BitmapUtil {

    private static LruCache<String, Bitmap> mMemoryCache;
    static {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8; // Use 1/8th of the available memory for this memory cache.
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024; // The cache size will be measured in kilobytes rather than number of items.
            }
        };
    }

    public static Bundle storeBitmapInBundle(Bitmap bitmap, Bundle bundle) {
        String key = "bitmap_" + UUID.randomUUID();
        storeBitmapInMemCache(key, bitmap);
        bundle.putString("bitmap_id", key);
		return bundle;
    }

   private static void storeBitmapInMemCache(String key, Bitmap bitmap) {
        if (mMemoryCache.get(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public static Bitmap getBitmapFromMemoryCache(String key) {
		return mMemoryCache.get(key);
    }

    public static Bitmap createBitmap(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }
}
