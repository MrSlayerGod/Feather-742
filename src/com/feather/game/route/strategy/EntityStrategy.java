package com.feather.game.route.strategy;


import com.feather.game.Entity;
import com.feather.game.route.RouteStrategy;

public class EntityStrategy extends RouteStrategy {

	/**
	 * Entity position x.
	 */
	private final int x;
	/**
	 * Entity position y.
	 */
	private final int y;
	/**
	 * Entity size.
	 */
	private final int size;
	/**
	 * Access block flag, see RouteStrategy static final values.
	 */
	private final int accessBlockFlag;

	public EntityStrategy(Entity entity) {
		this(entity, 0);
	}

	public EntityStrategy(Entity entity, int accessBlockFlag) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.size = entity.getSize();
		this.accessBlockFlag = accessBlockFlag;
	}

	@Override
	public boolean canExit(int currentX, int currentY, int sizeXY,
			int[][] clip, int clipBaseX, int clipBaseY) {
		return checkFilledRectangularInteract(clip, currentX
				- clipBaseX, currentY - clipBaseY, sizeXY, sizeXY, x
				- clipBaseX, y - clipBaseY, size, size, accessBlockFlag);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof EntityStrategy))
			return false;
		final EntityStrategy strategy = (EntityStrategy) other;
		return x == strategy.x && y == strategy.y && size == strategy.size
				&& accessBlockFlag == strategy.accessBlockFlag;
	}

	@Override
	public int getApproxDestinationSizeX() {
		return size;
	}

	@Override
	public int getApproxDestinationSizeY() {
		return size;
	}

	@Override
	public int getApproxDestinationX() {
		return x;
	}

	@Override
	public int getApproxDestinationY() {
		return y;
	}

}
