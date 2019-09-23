package com.example.surface_proj2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public abstract class MySurface extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float xCoor = 0;
    private float yCoor = 0;

    public MySurface(Context context)
    {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){
        drawPoint();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
        paint = null;
    }



    public void drawPoint()
    {
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.BLACK);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(xCoor, yCoor, 100, paint);
        canvas.drawCircle(25,25,100, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public float getxCoor()
    {
        return xCoor;
    }

    public float getyCoor()
    {
        return yCoor;
    }

    public void setxCoor(float xCoor)
    {
        this.xCoor = xCoor;
    }

    public void setyCoor(float yCoor)
    {
        this.yCoor = yCoor;
    }

    public Paint getPaint()
    {
        return paint;
    }

    public void setPaint(Paint paint)
    {
        this.paint = paint;
    }





}
