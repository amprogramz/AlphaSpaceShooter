package com.Alpha.Space.Shooter;


import javafx.scene.shape.Rectangle;

public class Ammo
{
    private Rectangle ammo = new Rectangle();
    private double movement;
    private int damage;



    public Rectangle getRound()
    {
        return ammo;
    }
    public void setAmmo(Rectangle ammo)
    {
        this.ammo = ammo;
    }
    public void setMovement(double movement)
    {
        this.movement = movement;
    }
    public void setAmmo(double x, double y)
    {
        ammo.setX(x);
        ammo.setY(y);
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public void shoot(EnemyArray enemy)
    {
        ammo.setY(ammo.getY() - movement);
        enemy.checkForDestruction(ammo, damage);
    }
}
