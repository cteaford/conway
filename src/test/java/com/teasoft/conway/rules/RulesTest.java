package com.teasoft.conway.rules;

import org.junit.Test;
import org.junit.Assert;

public class RulesTest {


	@Test
	public void isLiveCellLessThanTwoNeighbors_whenLiveCellHasLessThan2Neighbors_ThenReturnTrue(){
		Assert.assertTrue(Rules.isLiveCellLessThanTwoNeighbors(1,7,true));
	}

	@Test
	public void isLiveCellLessThanTwoNeighbors_whenLiveCellHas2Neighbors_ThenReturnFalse(){
		Assert.assertFalse(Rules.isLiveCellLessThanTwoNeighbors(2,6,true));
	}

	@Test
	public void isLiveCellMoreThanThreeNeighbors_whenLiveCellHasMoreThan3Neighbors_ThenReturnTrue(){
		Assert.assertTrue(Rules.isLiveCellMoreThanThreeNeighbors(4,4,true));
	}

	@Test
	public void isLiveCellMoreThanThreeNeighbors_whenLiveCellHas3Neighbors_ThenReturnFalse(){
		Assert.assertFalse(Rules.isLiveCellMoreThanThreeNeighbors(3,5,true));
	}

	@Test
	public void isDeadCellThreeNeighbors_whenDeadCellHas3Neighbors_ThenReturnTrue(){
		Assert.assertTrue(Rules.isDeadCellThreeNeighbors(3,5,false));
	}

	@Test
	public void isDeadCellThreeNeighbors_whenDeadCellHas2Neighbors_ThenReturnFalse(){
		Assert.assertFalse(Rules.isDeadCellThreeNeighbors(2,6,false));
	}
}