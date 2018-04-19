package com.Alpha.Space.Shooter;

public class AIMovements
{
    public static double movePositive(int movement)
    {
        return movement;
    }
    public static double moveNegative(int movement)
    {
        return - movement;
    }
    public static double moveFast(int movement)
    {
        return movement * 2;
    }
    public static double moveRandom(int movement)
    {
        int binaryDecision = (int) (Math.random() * 2);
        System.out.println("Binary decision" + binaryDecision);

        if (binaryDecision == 1)
        {
            return +movement;
        }
        else
        {
            return -movement;
        }

    }

}
