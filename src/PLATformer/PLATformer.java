/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLATformer;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import studijosKTU.ScreenKTU;

/**
 *
 * @author teliks
 */
public class PLATformer extends ScreenKTU {
    
    private int prevposH;
    private int prevposW;

    private int posH;
    private int posW;

    private int lives;
    private boolean invincible;
    private boolean canMove;
    
    private boolean stopped;
    private boolean counter;
    
    private boolean animationOn;
    
    private int speed;
    
    private List<Thread> threads;
    
    private int setPosH(int value) {
        prevposH = posH;
        posH = value;
        return posH;
    }

    private int setPosW(int value) {
        prevposW = posW;
        posW = value;
        return posW;
    }

    private List<Clip> clips;

    public PLATformer(boolean animationOn) {
        super(25, 25, 25, 40, ScreenKTU.Grid.ON);
        
        this.animationOn = animationOn;
        
        setUp();
    }

    private void setUp()
    {
        prevposH = 10;
        prevposW = 20;
        posH = 10;
        posW = 35;
        lives = 3;
        invincible = false;
        canMove = false;
        stopped = false;
        speed = 50;
        
        clips = new ArrayList<>();

        threads = new ArrayList<>();
        
        Runnable r = () -> {
            while (!stopped) {
                refresh(10);
            }
        };

        Thread t1 = new Thread(r);
        
        t1.start();
        
        drawGUI();

        if (!counter)
            startCounter();
        else
            canMove = true;
        
        setColors(Color.RED, Color.GREEN);

        Runnable timer = () -> {
            int s = 0;
            int m = 0;

            while (!stopped) {
                fillRect(0, 5, 1, 40, Color.RED);
                print(0, 0, "Time survived: Min " + m + " Sec " + s);
                s++;
                if (s % 5 == 0)
                    speed -= 2;
                if (s >= 60) {
                    m++;
                    s = 0;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        };

        Runnable generateClips = () -> {
            while (!stopped) {
                generateClips();
            }
        };

        Thread t2 = new Thread(generateClips);

        threads.add(t2);
        
        t2.start();

        moveClips();

        paintP();

        Runnable clipMovement = () -> {
            while (!clips.isEmpty() && !stopped) {
                moveClips();
            }
        };

        Runnable guiAnimation = () -> {
            while (!stopped) {
                startAnim();
            }
        };

         Thread t3 = new Thread(timer);

        threads.add(t3);
        
        t3.start();
        
         Thread t4 = new Thread(clipMovement);

        threads.add(t4);
        
        t4.start();
        
         if (this.animationOn)
         {
             Thread t5 = new Thread(guiAnimation);

            threads.add(t5);
        
            t5.start();
         }
    }
    
    private void drawGUI() {    
        setColors(Color.RED, Color.BLACK);

        fillRect(20, 0, 5, 40, Color.BLACK);
        
        fillRect(21, 1, 3, 38, '~');

        setColors(Color.BLACK, Color.gray);

        fillRect(22, 2, 1, 36, Color.gray);

        print(21, 15, "PLATformer");

        setColors(Color.BLACK, Color.RED);

        print(22, 2, "Lives: ❤❤❤");

    }

    private void startCounter()
    {
        try
        {
            int centerH = 10;
            int centerY = 20;
            
            fillRect(1, 0, 18, 40, Color.BLUE);
            fillRect(centerH - 3, centerY - 2, 1, 4, Color.RED);
            fillRect(centerH - 2, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH - 1, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH, centerY - 1, 1, 3, Color.RED);
            fillRect(centerH + 1, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH + 2, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH + 3, centerY - 2, 1, 4, Color.RED);
            Thread.sleep(1000);
            
            fillRect(1, 0, 18, 40, Color.BLUE);
            fillRect(centerH - 3, centerY - 2, 1, 4, Color.RED);
            fillRect(centerH - 2, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH - 1, centerY + 2, 1, 1, Color.RED);
            fillRect(centerH, centerY - 1, 1, 3, Color.RED);
            fillRect(centerH + 1, centerY - 2, 1, 1, Color.RED);
            fillRect(centerH + 2, centerY - 2, 1, 1, Color.RED);
            fillRect(centerH + 3, centerY - 2, 1, 5, Color.RED);
            Thread.sleep(1000);
            
            fillRect(1, 0, 18, 40, Color.BLUE);
            fillRect(centerH - 3, centerY, 7, 1, Color.RED);
            fillRect(centerH - 2, centerY - 1, 1, 1, Color.RED);
            fillRect(centerH + 3, centerY - 1, 1, 3, Color.RED);
            Thread.sleep(1000);
            
            fillRect(1, 0, 18, 40, Color.BLUE);
            
            canMove = true;
            counter = true;
        }
        catch (InterruptedException e) {};
    }
    
    private void startAnim() {
        int x = 20;
        int y = 0;

        int color = 0;

        while (true) {
            switch (color++) {
                case 0:
                    fillRect(x, y, 1, 1, Color.RED);
                    break;
                case 1:
                    fillRect(x, y, 1, 1, Color.BLACK);
                    break;
                case 2:
                    fillRect(x, y, 1, 1, Color.CYAN);
                    color = 0;
                    break;
                default:
                    break;
            }

            if (x < 24 && y == 0) {
                x++;
            } else if (x == 24 && y < 39) {
                y++;
            } else if (y == 39 && x > 20) {
                x--;
            } else if (y > 0 && x == 20) {
                y--;
            }

            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {

            }
        }
    }

    private void generateClips() {
        Clip clip = Clip.GenerateClip(-5, ThreadLocalRandom.current().nextInt(2, 16));

        if (clip.complex) {
            fillClipComplex(clip, Color.yellow);
        } else {
            fillClip(clip, Color.yellow);
        }

        clips.add(clip);

        try {
            Thread.sleep(speed * 20);
        } catch (InterruptedException e) {

        }
    }

    private void fillClip(Clip clip, Color color) {
        fillRect(clip.minH(), clip.minW(), clip.getHeight(), clip.getWidth(), color);
    }

    private void fillClipComplex(Clip clip, Color color) {
        for (IntPair i : clip.getCoordinates()) {
            fillRect(i.h, i.w, 1, 1, color);
        }
    }

    private void moveClips() {
        Iterator<Clip> iter = clips.iterator();

        try {
            while (iter.hasNext()) {
                Clip clip = iter.next();
                if (clip.complex) {
                    fillClipComplex(clip, Color.BLUE);
                } else {
                    fillClip(clip, Color.BLUE);
                }
                clip.moveRight();

                for (IntPair i : clip.getCoordinates()) {
                    if (i.h == posH && i.w == posW) {
                        if (lives > 0 && !invincible) {
                            print(22, 8 + lives--, "-");
                            if (lives == 0) {
                                stopped = true;
                                clearAll(Color.BLACK);
                                setColors(Color.RED, Color.BLACK);
                                print(10, 16, "YOU LOST");
                                print(12, 8, "PRESS ANY KEY TO TRY AGAIN");
                                refresh(10);
                            }
                            Runnable inv = () -> {
                                invincible = true;
                                try {
                                    Thread.sleep(2000);
                                    invincible = false;
                                } catch (InterruptedException e) {
                                }
                            };
                            new Thread(inv).start();
                        }
                    }
                }

                if (clip.minW() < 50) {
                    {
                        if (clip.complex) {
                            fillClipComplex(clip, Color.yellow);
                        } else {
                            fillClip(clip, Color.BLUE);
                        }
                    }
                } else {
                    iter.remove();
                }
            }
        } catch (ConcurrentModificationException e) {

        }

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {

        }
    }

    private void paintP() {
        fillRect(posH, posW, 1, 1, Color.CYAN);
        //refresh();
    }

    private void paintP(int newposH, int newposY) {
        fillRect(prevposH, prevposW, 1, 1, Color.BLUE);
        fillRect(newposH, newposY, 1, 1, Color.CYAN);
        // refresh();
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int key = ke.getKeyCode();

        if (!stopped && canMove) {
            if (key == KeyEvent.VK_LEFT) {
                if (posW > 0) {
                    boolean canMove = true;

                    paintP(setPosH(posH), setPosW(posW - 1));
                }

            }

            if (key == KeyEvent.VK_UP) {
                if (posH > 1) {
                    boolean canMove = true;
                    paintP(setPosH(posH - 1), setPosW(posW));
                }
            }

            if (key == KeyEvent.VK_RIGHT) {
                if (posW < 39) {
                    boolean canMove = true;

                    paintP(setPosH(posH), setPosW(posW + 1));
                }
            }

            if (key == KeyEvent.VK_DOWN) {
                if (posH < 19) {
                    paintP(setPosH(posH + 1), setPosW(posW));
                }
            }
        }
        else if (stopped)
        {
            clearAll(Color.BLUE);
            refresh();
            for (Thread t : threads)
            {
                t.stop();
            }
            setUp();
        }
    }

    public static void main(String[] args) {
        new PLATformer(true);
    }

}
