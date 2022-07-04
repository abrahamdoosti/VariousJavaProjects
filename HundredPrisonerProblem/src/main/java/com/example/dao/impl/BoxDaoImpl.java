package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.BoxDao;
import com.example.model.Box;
import com.example.model.Prisoner;

public class BoxDaoImpl implements BoxDao {

	@Override
	public List<Box> getBoxes() {
		List<Box> hundredBoxes = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			hundredBoxes.add(new Box(i));
		}
		return hundredBoxes;
	}

}
