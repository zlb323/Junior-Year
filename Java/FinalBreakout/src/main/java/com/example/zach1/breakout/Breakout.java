package com.example.zach1.breakout;
import android.app.Activity;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.graphics.Paint;
import android.content.Context;
import android.view.SurfaceHolder;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class Breakout extends Activity {


    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game(this);
        setContentView(game);

    }
    class Game extends SurfaceView implements Runnable {

        Thread thread = null;

        SurfaceHolder holder;
        volatile boolean playing;
        boolean paused = true;

        Canvas can;
        Paint p;

        long frames;

        private long timeSoFar;

        int x;
        int y;

        Paddle pad;

        Ball ball;

        Brick[] bricks = new Brick[200];
        int numBricks = 0;

        int score = 0;

        int lifes = 3;

        public Game(Context context) {

            super(context);

            holder = getHolder();
            p = new Paint();

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            x = size.x;
            y = size.y;

            pad = new Paddle(x, y);

            ball = new Ball(x, y);

            createBricksAndRestart();

        }

        public void createBricksAndRestart() {

            ball.reset(x, y);

            int brickWidth = x / 8;
            int brickHeight = y / 10;

            numBricks = 0;
            for (int column = 0; column < 8; column++) {
                for (int row = 0; row < 3; row++) {
                    bricks[numBricks] = new Brick(row, column, brickWidth, brickHeight);
                    numBricks++;
                }
            }
            if (lifes == 0) {
                score = 0;
                lifes = 3;
            }
        }

        @Override
        public void run() {
            while (playing) {
                long startFrameTime = System.currentTimeMillis();
                if (!paused) {
                    update();
                }
                draw();
                timeSoFar = System.currentTimeMillis() - startFrameTime;
                if (timeSoFar >= 1) {
                    frames = 1000 / timeSoFar;
                }

            }

        }

        public void update() {

            pad.update(frames);

            ball.update(frames);

            for (int i = 0; i < numBricks; i++) {
                if (bricks[i].getVisibility()) {
                    if (RectF.intersects(bricks[i].getRect(), ball.getRect())) {
                        bricks[i].setInvisible();
                        ball.reverseYVelocity();
                        score = score + 10;
                    }
                }
            }
            if (RectF.intersects(pad.getRect(), ball.getRect())) {
                ball.setRandomXVelocity();
                ball.reverseYVelocity();
                ball.clearObstacleY(pad.getRect().top - 2);
            }
            if (ball.getRect().bottom > y) {
                ball.reverseYVelocity();
                ball.clearObstacleY(y - 2);

                lifes--;

                if (lifes == 0) {
                    paused = true;
                    createBricksAndRestart();
                }
            }

            if (ball.getRect().top < 0)

            {
                ball.reverseYVelocity();
                ball.clearObstacleY(12);
            }

            if (ball.getRect().left < 0)

            {
                ball.reverseXVelocity();
                ball.clearObstacleX(2);
            }

            if (ball.getRect().right > x - 10) {

                ball.reverseXVelocity();
                ball.clearObstacleX(x - 22);
            }

            if (score == numBricks * 10)

            {
                paused = true;
                createBricksAndRestart();
            }

        }

        public void draw() {

            if (holder.getSurface().isValid()) {
                can = holder.lockCanvas();

                can.drawColor(Color.argb(255, 79, 161, 155));

                p.setColor(Color.argb(255, 255, 255, 255));

                can.drawRect(pad.getRect(), p);

                can.drawRect(ball.getRect(), p);

                p.setColor(Color.argb(255, 173, 52, 52));

                for (int i = 0; i < numBricks; i++) {
                    if (bricks[i].getVisibility()) {
                        can.drawRect(bricks[i].getRect(), p);
                    }
                }

                p.setColor(Color.argb(255, 255, 255, 255));

                p.setTextSize(40);
                can.drawText("Score: " + score + "   Lives: " + lifes, 10, 50, p);

                if (score == numBricks * 10) {
                    p.setTextSize(90);
                    can.drawText("YOU HAVE WON!", 10, y / 2, p);
                }

                if (lifes <= 0) {
                    p.setTextSize(90);
                    can.drawText("YOU HAVE LOST!", 10, y / 2, p);
                }

                holder.unlockCanvasAndPost(can);
            }
        }

        public void pause() {
            playing = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                Log.e("Error:", "joining thread");
            }
        }

        public void resume() {
            playing = true;
            thread = new Thread(this);
            thread.start();
        }
        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    paused = false;
                    if (motionEvent.getX() > x / 2) {

                        pad.setMovementState(pad.RIGHT);
                    } else

                    {
                        pad.setMovementState(pad.LEFT);
                    }

                    break;

                case MotionEvent.ACTION_UP:

                    pad.setMovementState(pad.STOPPED);
                    break;
            }

            return true;
        }

    }
    @Override
    protected void onResume() {
        super.onResume();

        game.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        game.pause();
    }

}