package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calf {
	private String id;
    private String birthDate;
    private String father;
    private Gender gender;
    
    public Calf() {

    }

    public Calf(String id, String birthDate, String father, Gender gender) {
        super();
        this.id = id;
        this.birthDate = birthDate;
        this.father = father;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

	@Override
	public String toString() {
		return this.id;
	}
    
    
}
