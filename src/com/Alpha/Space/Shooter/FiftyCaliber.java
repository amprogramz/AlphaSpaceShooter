package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FiftyCaliber extends Ammo
{


    public FiftyCaliber()
    {
        Rectangle ammo = new Rectangle();
        ammo.setWidth(2);
        ammo.setHeight(10);
        ammo.setFill(Color.RED);
        super.setAmmo(ammo);
        super.setMovement(30);
        super.setDamage(11);
    }

}
