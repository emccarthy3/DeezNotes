package com.edu.elon.deeznotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by scottarmstrong on 10/20/15.
 */
public class Note {

    private Bitmap bitmap;
    protected float width, height;
    protected float x, y;
    protected int IDNumber;
    protected boolean isSelected;
    protected boolean isDeleted;
    protected Context context;
    private Paint paint = new Paint(Color.BLACK);

    private int screenWidth, screenHeight;

    public Note (Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.note);

        width = bitmap.getWidth();
        height = bitmap.getHeight();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        float smallestWidth = width / 2;
        float largestWidth = screenWidth - width / 2;
        float smallestHeight = height / 2;
        float largestHeight = screenHeight - height / 2;
        x = smallestWidth + (float) (Math.random() * ((largestWidth - smallestWidth) + 1));
        y = smallestHeight + (float) (Math.random() * ((largestHeight - smallestHeight) + 1));
        isDeleted = false;
    }

    public void delete() {
        isDeleted = true;
    }

    public void doDraw(Canvas canvas) {
        if (!isDeleted) {
            canvas.drawBitmap(bitmap,
                    null,
                    new Rect((int) (x - width / 2), (int) (y - height / 2),
                            (int) (x + width / 2), (int) (y + height / 2)),
                    null);
            paint.setTextAlign(Paint.Align.CENTER);

            paint.setAntiAlias(true);
            canvas.drawText("Hello World", x, y, paint);
        }
    }

    public void doUpdate(double elapsed, float touchX, float touchY) {
        x = (float) touchX;
        y = (float) touchY;
    }

    public Context getContext() {
        return context;
    }
}
