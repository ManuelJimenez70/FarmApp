package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

public class Manager {

	private Gson gson;

	public Manager() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public String createArrayJson(Cow[] cows) {
		return this.gson.toJson(cows);
	}

	public ArrayList<Cow> readCowJson(String file) {
		JsonParser jParser = new JsonParser();
		JsonObject jsonObjCow = (JsonObject) jParser.parse(file);
		JsonArray jsonArray = (JsonArray) jsonObjCow.get("cows");
		ArrayList<Cow> cows = new ArrayList<Cow>();
		for (int i = 0; i < jsonArray.size(); i++) {
			Cow cow = new Cow();
			JsonObject jObj = (JsonObject) jsonArray.get(i);
			cow.setId(jObj.get("id").getAsString());
			JsonArray calfsArray = jObj.getAsJsonArray("calfs");
			ArrayList<Calf> calfs = new ArrayList<Calf>();
			for (int j = 0; j < calfsArray.size(); j++) {
				Calf calf = new Calf();
				JsonObject calfJ = (JsonObject) calfsArray.get(j);
				calf.setId(calfJ.get("id").getAsString());
				calf.setDate(calfJ.get("birthDate").getAsString());
				calf.setFather(calfJ.get("father").getAsString());
				readGender(calfJ, calf);

				calfs.add(calf);
			}
			cow.setCalfs(calfs);
			readCowState(jObj, cow);
			JsonArray jsonArrayDisease = jObj.getAsJsonArray("diseases");
			ArrayList<String> disease = new ArrayList<String>();
			for (int j = 0; j < jsonArrayDisease.size(); j++) {
				disease.add(jsonArrayDisease.get(j).getAsString());
				cow.setDiseases(disease);
			}
			JsonArray jsonArrayMedicine = jObj.getAsJsonArray("medicineApplied");
			ArrayList<String> medicines = new ArrayList<String>();
			for (int j = 0; j < jsonArrayMedicine.size(); j++) {
				medicines.add(jsonArrayMedicine.get(j).getAsString());
				cow.setMedicineApplied(medicines);
			}
			cow.setHeatDate(jObj.get("heatDate").getAsString());
			cow.setInseminationDate(jObj.get("inseminationDate").getAsString());
			Breed breed = new Breed();
			JsonObject jsonObjBreed = jObj.getAsJsonObject("breed");
			JsonObject breedJ = (JsonObject) jsonObjBreed;
			breed.setName(breedJ.get("name").getAsString());
			breed.setDescription(breedJ.get("description").getAsString());
			breed.setIcon(breedJ.get("icon").getAsString());
			cow.setBreed(breed);
			cows.add(cow);
		}
		return cows;
	}

	public ArrayList<Report> readReportJson(String file) {
		JsonParser jParser = new JsonParser();
		JsonObject jsonReport = (JsonObject) jParser.parse(file);
		JsonArray jsonArray = (JsonArray) jsonReport.get("reports");

		ArrayList<Report> reports = new ArrayList<Report>();

		for (int i = 0; i < jsonArray.size(); i++) {
			Report report = new Report();
			JsonObject jObj = (JsonObject) jsonArray.get(i);
			report.setReportDate(jObj.get("reportDate").getAsString());
			report.setLitersMilk(jObj.get("litersMilk").getAsInt());

			Inventory in = new Inventory();
			JsonObject jsonObjInv = jObj.getAsJsonObject("inventoryConsumed");
			JsonObject invtJson = (JsonObject) jsonObjInv;

			in.setRentMilk(invtJson.get("rentMilk").getAsInt());
			in.setSalt(invtJson.get("salt").getAsInt());
			in.setPreLactation(invtJson.get("preLactation").getAsInt());

			report.setInventoryConsumed(in);
			reports.add(report);
		}
		return reports;
	}

	public LocalDate readLocalDate(JsonObject objJson, String key) {
		String[] fechaArray = objJson.get(key).getAsString().split("-");
		LocalDate fecha = LocalDate.of(Integer.parseInt(fechaArray[0]), Integer.parseInt(fechaArray[1]),
				Integer.parseInt(fechaArray[2]));
		return fecha;
	}

	public void readGender(JsonObject objJson, Calf calf) {
		switch (objJson.get("gender").getAsString()) {
		case "FEMALE":
			calf.setGender(Gender.FEMALE);
			break;
		case "MALE":
			calf.setGender(Gender.MALE);
			break;
		default:
			break;
		}
	}

	public void readCowState(JsonObject objJson, Cow cow) {
		switch (objJson.get("cowstate").getAsString()) {
		case "MILKMAID":
			cow.setCowstate(CowState.MILKMAID);
			break;
		case "DRYING":
			cow.setCowstate(CowState.DRYING);
			break;
		case "INSEMINATED":
			cow.setCowstate(CowState.INSEMINATED);
			break;
		case "SIN":
			cow.setCowstate(CowState.SIN);
			break;
		default:
			break;
		}
	}

	public String readJson(String file) {
		StringBuffer response = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("error en conexion " + e.getMessage());
		}
		return response.toString();
	}

	public ArrayList<Breed> readBreed(String file) {
		JsonParser jParser = new JsonParser();
		JsonObject jsonBreed = (JsonObject) jParser.parse(file);
		JsonArray jsonArray = (JsonArray) jsonBreed.get("breeds");
		ArrayList<Breed> breeds = new ArrayList<Breed>();
		for (int i = 0; i < jsonArray.size(); i++) {
			Breed breed = new Breed();
			JsonObject jObj = (JsonObject) jsonArray.get(i);
			breed.setName(jObj.get("name").getAsString());
			breed.setDescription(jObj.get("description").getAsString());
			breed.setIcon(jObj.get("icon").getAsString());
			breeds.add(breed);
		}
		return breeds;
	}

	public ArrayList<Calf> readCalf(String file) {
		JsonParser jParser = new JsonParser();
		JsonObject jsonCalf = (JsonObject) jParser.parse(file);
		JsonArray calfsArray = (JsonArray) jsonCalf.get("calfs");
		ArrayList<Calf> calfs = new ArrayList<Calf>();
		for (int i = 0; i < calfsArray.size(); i++) {
			Calf calf = new Calf();
			JsonObject calfJ = (JsonObject) calfsArray.get(i);
			calf.setId(calfJ.get("id").getAsString());
			calf.setDate(calfJ.get("birthDate").getAsString());
			calf.setFather(calfJ.get("father").getAsString());
			readGender(calfJ, calf);
			calfs.add(calf);
		}
		return calfs;
	}

	public void writeCalf(Calf calf) {
		String json = readJson("resources/calfs/calfs.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCalf = (JsonObject) jParser.parse(json);
		JsonArray calfsArray = jsonCalf.getAsJsonArray("calfs");
		calfsArray.add(this.gson.toJsonTree(calf));
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/calfs/calfs.json"));
			jw.jsonValue(jsonCalf.toString());
			jw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCow(Cow cow) {
		String json = readJson("resources/cows/cows.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCalf = (JsonObject) jParser.parse(json);
		JsonArray calfsArray = jsonCalf.getAsJsonArray("cows");
		calfsArray.add(this.gson.toJsonTree(cow));
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
			jw.jsonValue(jsonCalf.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeReport(Report report) {
		String json = readJson("resources/reports/reports.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCalf = (JsonObject) jParser.parse(json);
		JsonArray reportArray = jsonCalf.getAsJsonArray("reports");
		reportArray.add(this.gson.toJsonTree(report));
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/reports/reports.json"));
			jw.jsonValue(jsonCalf.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCow(Cow cow) {
		String json = readJson("resources/cows/cows.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCow = (JsonObject) jParser.parse(json);
		JsonArray calfsArray = jsonCow.getAsJsonArray("cows");
		for (int i = 0; i < calfsArray.size(); i++) {
			Cow cowToDel = this.gson.fromJson(calfsArray.get(i), Cow.class);
			if (cowToDel.getId().equals(cow.getId())) {
				calfsArray.remove(i);
			}
		}
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
			jw.jsonValue(jsonCow.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCalf(Calf calf) {
		String json = readJson("resources/calfs/calfs.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCalf = (JsonObject) jParser.parse(json);
		JsonArray calfsArray = jsonCalf.getAsJsonArray("calfs");
		for (int i = 0; i < calfsArray.size(); i++) {
			Calf cowToDel = this.gson.fromJson(calfsArray.get(i), Calf.class);
			if (cowToDel.getId().equals(calf.getId())) {
				calfsArray.remove(i);
			}
		}
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/calfs/calfs.json"));
			jw.jsonValue(jsonCalf.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addInsemination(Cow cow, String date) {
        String json = readJson("resources/cows/cows.json");
        JsonParser jParser = new JsonParser();
        JsonObject jsonCow = (JsonObject) jParser.parse(json);
        JsonArray calfsArray = jsonCow.getAsJsonArray("cows");
        
        for (int i = 0; i < calfsArray.size(); i++) {
            Cow cowToDel = this.gson.fromJson(calfsArray.get(i), Cow.class);
            if (cowToDel.getId().equals(cow.getId())) {
            	JsonObject cowToIns = (JsonObject) calfsArray.get(i);
                cowToIns.addProperty("inseminationDate", date);
                cowToIns.addProperty("cowstate", "INSEMINATED");
            }
        }
        try {
            JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
            jw.jsonValue(jsonCow.toString());
            jw.flush();
            jw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void addDateHeat(Cow cow, String date) {
        String json = readJson("resources/cows/cows.json");
        JsonParser jParser = new JsonParser();
        JsonObject jsonCow = (JsonObject) jParser.parse(json);
        JsonArray calfsArray = jsonCow.getAsJsonArray("cows");
        
        for (int i = 0; i < calfsArray.size(); i++) {
            Cow cowToDel = this.gson.fromJson(calfsArray.get(i), Cow.class);
            if (cowToDel.getId().equals(cow.getId())) {
            	JsonObject cowToIns = (JsonObject) calfsArray.get(i);
                cowToIns.addProperty("heatDate", date);
            }
        }
        try {
            JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
            jw.jsonValue(jsonCow.toString());
            jw.flush();
            jw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void addState(Cow cow, CowState cowState) {
        String json = readJson("resources/cows/cows.json");
        JsonParser jParser = new JsonParser();
        JsonObject jsonCow = (JsonObject) jParser.parse(json);
        JsonArray calfsArray = jsonCow.getAsJsonArray("cows");
        
        for (int i = 0; i < calfsArray.size(); i++) {
            Cow cowToDel = this.gson.fromJson(calfsArray.get(i), Cow.class);
            if (cowToDel.getId().equals(cow.getId())) {
            	JsonObject cowToIns = (JsonObject) calfsArray.get(i);
                cowToIns.addProperty("cowstate", cowState.name());
            }
        }
        try {
            JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
            jw.jsonValue(jsonCow.toString());
            jw.flush();
            jw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void addSick(Cow cow) {
		String json = readJson("resources/cows/cows.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCow = (JsonObject) jParser.parse(json);
		JsonArray calfsArray = jsonCow.getAsJsonArray("cows");
		
		for (int i = 0; i < calfsArray.size(); i++) {
			Cow cowTo = this.gson.fromJson(calfsArray.get(i), Cow.class);
			if (cowTo.getId().equals(cow.getId())) {
				JsonObject cowToSick = (JsonObject) calfsArray.get(i);
				JsonArray diseases = cowToSick.getAsJsonArray("diseases");
				if (diseases.size()!=0) {
					for (int j = 0; j < diseases.size(); j++) {
						diseases.remove(j);
					}
				}
				for (int j = 0; j < cow.getDiseases().size(); j++) {
					diseases.add(cow.getDiseases().get(j));
				}

			}
		}
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
			jw.jsonValue(jsonCow.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMedicament(Cow cow) {
		String json = readJson("resources/cows/cows.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCow = (JsonObject) jParser.parse(json);
		JsonArray cowsArray = jsonCow.getAsJsonArray("cows");
		for (int i = 0; i < cowsArray.size(); i++) {
			Cow cowTo = this.gson.fromJson(cowsArray.get(i), Cow.class);
			if (cowTo.getId().equals(cow.getId())) {
				JsonObject cowToSick = (JsonObject) cowsArray.get(i);
				JsonArray meds = cowToSick.getAsJsonArray("medicineApplied");
				if (meds.size()!=0) {
					for (int j = 0; j < meds.size(); j++) {
						meds.remove(j);
					}
				}
				for (int j = 0; j < cow.getMedicineApplied().size(); j++) {
					meds.add(cow.getMedicineApplied().get(j));
				}

			}
		}
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
			jw.jsonValue(jsonCow.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteSickCow(Cow cow) {
		String json = readJson("resources/cows/cows.json");
		JsonParser jParser = new JsonParser();
		JsonObject jsonCow = (JsonObject) jParser.parse(json);
		JsonArray cowsArray = jsonCow.getAsJsonArray("cows");
		for (int i = 0; i < cowsArray.size(); i++) {
			Cow cowTo = this.gson.fromJson(cowsArray.get(i), Cow.class);
			if (cowTo.getId().equals(cow.getId())) {
				JsonObject cowToSick = (JsonObject) cowsArray.get(i);
				cowToSick.add("diseases", new JsonArray(0));
				cowToSick.add("medicineApplied", new JsonArray(0));
			}
		}
		try {
			JsonWriter jw = new JsonWriter(new FileWriter("resources/cows/cows.json"));
			jw.jsonValue(jsonCow.toString());
			jw.flush();
			jw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
