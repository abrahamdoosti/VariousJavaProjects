package com.example.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.dao.BoxDao;
import com.example.dao.PrisonerDao;
import com.example.dao.impl.BoxDaoImpl;
import com.example.dao.impl.PrisonerDaoImpl;
import com.example.model.Box;
import com.example.model.Prisoner;
/**
 * The Hundred Prisoners Riddle
 * question is on YouTube: https://www.youtube.com/watch?v=iSNsgj1OCLA
 * 
 * @author abrah
 *
 */
public class PrisonAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrisonerDao prisonserDao = new PrisonerDaoImpl();
		BoxDao boxDao = new BoxDaoImpl();
		List<Prisoner> prisoners = prisonserDao.getPersons();
		List<Box> boxes = boxDao.getBoxes();
		// shuffleNumberInBoxes(boxes);
		float numOfSuccess = 0;
		for (int i = 0; i < 100000; i++) {
			shuffleNumberInBoxes(boxes);
			if (doExperiment(prisoners, boxes)) {
				numOfSuccess++;
			}

		}
		System.out.println("Percent of experiments with success " + (numOfSuccess / 100000) * 100);

	}

	public static void shuffleNumberInBoxes(final List<Box> boxes) {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			randomNumbers.add(i);
		}
		Collections.shuffle(randomNumbers);

		for (int i = 0; i < 100; i++) {
			boxes.get(i).setValue(randomNumbers.get(i));

		}

	}

	public static boolean openBox(final List<Box> boxes, final Prisoner prisoner, int numberOfTries,
			int currentBoxLabelToOpen) {

		if (numberOfTries == 50) {
			return false;
		}

		currentBoxLabelToOpen = boxes.get(currentBoxLabelToOpen - 1).getValue();
		numberOfTries++;

		if (currentBoxLabelToOpen == prisoner.getNumber()) {
			return true;
		} else {
			return openBox(boxes, prisoner, numberOfTries, currentBoxLabelToOpen);
		}
	}

	public static boolean doExperiment(final List<Prisoner> prisoners, final List<Box> boxes) {
		for (Prisoner p : prisoners) {
			if (!openBox(boxes, p, 0, p.getNumber())) {
				return false;
			}
		}
		return true;
	}

}
