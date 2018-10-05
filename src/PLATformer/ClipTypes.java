/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLATformer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teliks
 */
public class ClipTypes {
    
    public static Clip TriangleClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH + 1, leftW));
        pairs.add(new IntPair(upperH + 2, leftW));
        pairs.add(new IntPair(upperH + 3, leftW));
        pairs.add(new IntPair(upperH + 4, leftW));
        pairs.add(new IntPair(upperH + 1, leftW + 1));
        pairs.add(new IntPair(upperH + 2, leftW + 1));
        pairs.add(new IntPair(upperH + 3, leftW + 1));
        pairs.add(new IntPair(upperH + 2, leftW + 2));
        
        return new Clip(pairs);
    }
    
    public static Clip HalfStarClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH, leftW + 4));
        pairs.add(new IntPair(upperH + 1, leftW + 1));
        pairs.add(new IntPair(upperH + 1, leftW + 3));
        pairs.add(new IntPair(upperH + 2, leftW + 2));
        pairs.add(new IntPair(upperH + 3, leftW + 3));
        pairs.add(new IntPair(upperH + 4, leftW + 4));
        
        return new Clip(pairs);
    }
    
    public static Clip LIGMAClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        //A
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH - 1, leftW));
        pairs.add(new IntPair(upperH + 1, leftW));
        pairs.add(new IntPair(upperH + 2, leftW));
        pairs.add(new IntPair(upperH - 1, leftW - 1));
        pairs.add(new IntPair(upperH + 1, leftW - 1));
        pairs.add(new IntPair(upperH - 1, leftW - 2));
        pairs.add(new IntPair(upperH + 1, leftW - 2));
        pairs.add(new IntPair(upperH - 1, leftW - 3));
        pairs.add(new IntPair(upperH, leftW - 3));
        pairs.add(new IntPair(upperH + 1, leftW - 3));
        pairs.add(new IntPair(upperH + 2, leftW - 3));
        
        //M
        
        pairs.add(new IntPair(upperH - 1, leftW - 5));
        pairs.add(new IntPair(upperH, leftW - 5));
        pairs.add(new IntPair(upperH + 1, leftW - 5));
        pairs.add(new IntPair(upperH + 2, leftW - 5));
        pairs.add(new IntPair(upperH - 1, leftW - 6));
        pairs.add(new IntPair(upperH, leftW - 7));
        pairs.add(new IntPair(upperH + 1, leftW - 7));
        pairs.add(new IntPair(upperH - 1, leftW - 8));
        pairs.add(new IntPair(upperH - 1, leftW - 9));
        pairs.add(new IntPair(upperH, leftW - 9));
        pairs.add(new IntPair(upperH + 1, leftW - 9));
        pairs.add(new IntPair(upperH + 2, leftW - 9));
        
        //G
        
        pairs.add(new IntPair(upperH - 1, leftW - 11));
        pairs.add(new IntPair(upperH + 1, leftW - 11));
        pairs.add(new IntPair(upperH + 2, leftW - 11));
        pairs.add(new IntPair(upperH - 1, leftW - 12));
        pairs.add(new IntPair(upperH + 2, leftW - 12));
        pairs.add(new IntPair(upperH - 1, leftW - 13));
        pairs.add(new IntPair(upperH, leftW - 13));
        pairs.add(new IntPair(upperH + 1, leftW - 13));
        pairs.add(new IntPair(upperH + 2, leftW - 13));
        
        //I
        
        pairs.add(new IntPair(upperH - 1, leftW - 15));
        pairs.add(new IntPair(upperH, leftW - 15));
        pairs.add(new IntPair(upperH + 1, leftW - 15));
        pairs.add(new IntPair(upperH + 2, leftW - 15));
        
        //L
        
        pairs.add(new IntPair(upperH + 2, leftW - 17));
        pairs.add(new IntPair(upperH - 1, leftW - 18));
        pairs.add(new IntPair(upperH, leftW - 18));
        pairs.add(new IntPair(upperH + 1, leftW - 18));
        pairs.add(new IntPair(upperH + 2, leftW - 18));
        
        return new Clip(pairs);
    }
    
    public static Clip MFClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH + 1, leftW + 2));
        pairs.add(new IntPair(upperH + 2, leftW + 2));
        pairs.add(new IntPair(upperH + 1, leftW + 1));
        pairs.add(new IntPair(upperH + 2, leftW + 1));
        pairs.add(new IntPair(upperH - 1, leftW));
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH + 1, leftW));
        pairs.add(new IntPair(upperH + 2, leftW));
        pairs.add(new IntPair(upperH + 1, leftW - 1));
        pairs.add(new IntPair(upperH + 2, leftW - 1));
        pairs.add(new IntPair(upperH + 1, leftW - 2));
        pairs.add(new IntPair(upperH + 2, leftW - 2));
        
        return new Clip(pairs);
    }
    
    public static Clip XDClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH + 1, leftW + 1));
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH + 2, leftW));
        pairs.add(new IntPair(upperH - 1, leftW - 1));
        pairs.add(new IntPair(upperH + 3, leftW - 1));
        pairs.add(new IntPair(upperH - 1, leftW - 2));
        pairs.add(new IntPair(upperH, leftW - 2));
        pairs.add(new IntPair(upperH + 1, leftW - 2));
        pairs.add(new IntPair(upperH + 2, leftW - 2));
        pairs.add(new IntPair(upperH + 3, leftW - 2));
        pairs.add(new IntPair(upperH - 1, leftW - 4));
        pairs.add(new IntPair(upperH + 3, leftW - 4));
        pairs.add(new IntPair(upperH, leftW - 5));
        pairs.add(new IntPair(upperH + 2, leftW - 5));
        pairs.add(new IntPair(upperH + 1, leftW - 6));
        pairs.add(new IntPair(upperH, leftW - 7));
        pairs.add(new IntPair(upperH + 2, leftW - 7));
        pairs.add(new IntPair(upperH - 1, leftW - 8));
        pairs.add(new IntPair(upperH + 3, leftW - 8));
        
        return new Clip(pairs);
    }
    
    public static Clip WaveClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH - 1, leftW + 1));
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH + 1, leftW - 1));
        pairs.add(new IntPair(upperH + 1, leftW - 2));
        pairs.add(new IntPair(upperH + 1, leftW - 3));
        pairs.add(new IntPair(upperH, leftW - 4));
        pairs.add(new IntPair(upperH - 1, leftW - 6));
        pairs.add(new IntPair(upperH - 1, leftW - 7));
        pairs.add(new IntPair(upperH - 1, leftW - 8));
        pairs.add(new IntPair(upperH, leftW - 9));
        pairs.add(new IntPair(upperH + 1, leftW - 10));
        pairs.add(new IntPair(upperH + 1, leftW - 11));
        
        return new Clip(pairs);
    }
    
    public static Clip SWClip(int leftW, int upperH)
    {
        List<IntPair> pairs = new ArrayList<>();
        
        pairs.add(new IntPair(upperH, leftW));
        pairs.add(new IntPair(upperH, leftW + 2));
        pairs.add(new IntPair(upperH, leftW + 3));
        pairs.add(new IntPair(upperH, leftW + 4));
        pairs.add(new IntPair(upperH + 1, leftW));
        pairs.add(new IntPair(upperH + 1, leftW + 2));
        pairs.add(new IntPair(upperH + 2, leftW));
        pairs.add(new IntPair(upperH + 2, leftW + 1));
        pairs.add(new IntPair(upperH + 2, leftW + 2));
        pairs.add(new IntPair(upperH + 2, leftW + 3));
        pairs.add(new IntPair(upperH + 2, leftW + 4));
        pairs.add(new IntPair(upperH + 3, leftW + 2));
        pairs.add(new IntPair(upperH + 3, leftW + 4));
        pairs.add(new IntPair(upperH + 4, leftW));
        pairs.add(new IntPair(upperH + 4, leftW + 1));
        pairs.add(new IntPair(upperH + 4, leftW + 2));
        pairs.add(new IntPair(upperH + 4, leftW + 4));
        
        return new Clip(pairs);
    }
}
