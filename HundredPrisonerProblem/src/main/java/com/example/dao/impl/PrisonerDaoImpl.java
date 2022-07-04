package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.PrisonerDao;
import com.example.model.Prisoner;

public class PrisonerDaoImpl implements PrisonerDao {

	@Override
	public List<Prisoner> getPersons() {
		List<Prisoner> hundredPersons = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			hundredPersons.add(new Prisoner(i));
		}
		return hundredPersons;
	}

}
