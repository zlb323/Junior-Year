package com.example.zach1.breakout;
import android.graphics.RectF;

public class Paddle {

    private RectF rect;

    private float length;
    private float height;

    private float x;

    private float y;

    private float paddleSpeed;

    public final static int STOPPED = 0;
    public final static int LEFT = 1;
    public final static int RIGHT = 2;

    private int paddleMoving = STOPPED;

    public Paddle(int screenX, int screenY){
        length = 130;
        height = 20;

        x = screenX / 2;
        y = screenY - 20;

        rect = new RectF(x, y, x + length, y + height);

        paddleSpeed = 350;
    }

    public RectF getRect(){
        return rect;
    }

    public void setMovementState(int state){
        paddleMoving = state;
    }

    public void update(long fps){
        if(paddleMoving == LEFT){
            x = x - paddleSpeed / fps;
        }

        if(paddleMoving == RIGHT){
            x = x + paddleSpeed / fps;
        }

        rect.left = x;
        rect.right = x + length;
    }

}