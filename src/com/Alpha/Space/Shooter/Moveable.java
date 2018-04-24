package com.Alpha.Space.Shooter;

public interface Moveable
{
	/**
	 * Method to require movement with movable objects.
	 * @param screenWidth Width of the playable screen
	 * @param screenHeight Height of the playable screen.
	 * @param ship Ship object to detect collisions.
	 * @param score Score object.
	 */
	public void move(double screenWidth, double screenHeight, Ship ship, Score score);
}
