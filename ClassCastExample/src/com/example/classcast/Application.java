package com.example.classcast;

import java.util.ArrayList;

import com.example.classcast.model.Animal;
import com.example.classcast.model.Cat;
import com.example.classcast.model.Dog;

public class Application {
	
	public static void main(String[] args) {
		ArrayList<Animal> myAnimals = new ArrayList<>();
		myAnimals.add(new Cat());
		myAnimals.add(new Dog());

		/// Dog d= (Dog) myAnimals.get(0);
		// Animal anim=(Animal) myAnimals.get(0);

		Cat myCat = new Cat();
		Animal animal = new Dog();
		Animal an = new Animal();

		// upCasting is implicit to the compiler, so we don't need state it
		// ,(Animal)myCat is not needed
		// Although Cat object remains Cat object, calling walk() would cause the
		// compiler error:
		an = myCat;
		// an.walk(); The method walk() is undefined for the type Animal
		myCat.walk();

		// What if we want to use the variable of type Animal to invoke a method
		// available only to Dog class?
		// Here comes the downcasting. It’s the casting from a superclass to a subclass.
		Dog dog = (Dog) animal;
		dog.sound();
		dog.wuff();
		
		//go though Animal reference list and based on the class of the object , 
		//downcast it and then call the method specific to it.
		for(Animal a:myAnimals) {
			//a.sound();
			if (a.getClass().equals(Cat.class)) {
				((Cat) a).walk();
			} else if (a.getClass().equals(Dog.class)) {
				((Dog) a).wuff();
			}
		}
		
		

	}

}
