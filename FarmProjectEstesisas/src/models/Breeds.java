package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Breeds {
	
	private Breed[] breeds;
	
	public Breeds() {
	}
	public Breed[] getBreeds() {
		return breeds;
	}
	public void setBreeds(Breed[] breeds) {
		this.breeds = breeds;
	}
}
