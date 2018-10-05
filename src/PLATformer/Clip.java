/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLATformer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author teliks
 */
public class Clip {
    
    private List<IntPair> coordinates;
    
    public boolean complex;
    
    public Clip(List<IntPair> coordinates)
    {
        this.coordinates = coordinates;
        
        complex = true;
    }
    
    public Clip(int leftW, int upperH, int width, int height)
    {
        coordinates = new ArrayList<>();
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                coordinates.add(new IntPair(upperH + j, leftW + i));
            }
        }
        
        complex = false;
    }
    
    public List<IntPair> getCoordinates()
    {
        return this.coordinates;
    }
    
    public int minW()
    {
        int minw = Integer.MAX_VALUE;
        
        for (IntPair i : this.coordinates)
        {
            if (i.w < minw)
                minw = i.w;
        }
        
        return minw;
    }
    
    public int minH()
    {
        int minH = Integer.MAX_VALUE;
        
        for (IntPair i : this.coordinates)
        {
            if (i.h < minH)
                minH = i.h;
        }
        
        return minH;
    }
    
    public int getWidth()
    {
        List<Integer> width = new ArrayList<>();
        
        for (IntPair i : coordinates)
        {
            if (!width.contains(i.w))
                width.add(i.w);
        }
        
        return width.size();
    }
    
    public int getHeight()
    {
        List<Integer> height = new ArrayList<>();
        
        for (IntPair i : coordinates)
        {
            if (!height.contains(i.h))
                height.add(i.h);
        }
        
        return height.size();
    }
    
    public boolean checkClipping(int w, int h)
    {
        for (IntPair i : coordinates)
        {
            if (w == i.w && h == i.h)
            return true;
        }
        return false;
    } 
    
    public void moveRight()
    {
        for (IntPair i : coordinates)
        {
            i.w += 1;
        }
    }
    
    public static Clip GenerateMemeClip(int leftW, int upperH)
    {
        switch (ThreadLocalRandom.current().nextInt(0, 7))
        {
            case (0):
                return ClipTypes.HalfStarClip(leftW, upperH);
            case (1):
                return ClipTypes.TriangleClip(leftW, upperH);
            case (2):
                return ClipTypes.LIGMAClip(leftW, upperH); 
            case (3):
                return ClipTypes.MFClip(leftW, upperH);
            case(4):
                return ClipTypes.SWClip(leftW, upperH);
            case (5):
                return ClipTypes.XDClip(leftW, upperH);
            case (6):
                return ClipTypes.WaveClip(leftW, upperH);
            default:
                break;
        }
        return null;
    }
    
    public static Clip GenerateClip(int leftW, int upperH)
    {
        switch (ThreadLocalRandom.current().nextInt(0, 5))
        {
            case (0):
                return ClipTypes.HalfStarClip(leftW, upperH);
            case (1):
                return ClipTypes.TriangleClip(leftW, upperH); 
            case (2):
                return ClipTypes.MFClip(leftW, upperH);
            case (3):
                return ClipTypes.XDClip(leftW, upperH);
            case (4):
                return ClipTypes.WaveClip(leftW, upperH);
            default:
                break;
        }
        return null;
    }
}