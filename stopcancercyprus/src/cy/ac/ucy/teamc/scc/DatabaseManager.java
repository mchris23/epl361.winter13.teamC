package com.example.stopcancercyprus;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {

	private static DatabaseManager instance = null;

	public static synchronized DatabaseManager getHelper(Context context) {
		if (instance == null) {
			instance = new DatabaseManager(context);
			
		}
		return instance;
	}

	private DatabaseManager(Context context) {
		super(context, "SCC", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createExamTable = new String(
				"CREATE TABLE EXAMINATION(ID_Examination INTEGER PRIMARY KEY AUTOINCREMENT,examination_name TEXT,examination_description TEXT,examination_frequency INTEGER,examination_sex INTEGER,examination_agerange TEXT,examination_weight TEXT,examination_smoker INTEGER,examination_height TEXT,examination_family_history INTEGER,examination_alcohol INTEGER)");
		String createCancerTable = new String(
				"CREATE TABLE CANCER(ID_cancer INTEGER PRIMARY KEY AUTOINCREMENT,cancer_name TEXT,cancer_description TEXT)");
		String createPreventionTable = new String(
				"CREATE TABLE PREVENTION(ID_prevention INTEGER PRIMARY KEY AUTOINCREMENT,prevention_name TEXT,prevention_description TEXT)");
		String createExamCancerTable = new String(
				"CREATE TABLE EXAMINATION_CANCER(ID_Examination INTEGER,ID_cancer INTEGER)");
		String createCancerPreventionTable = new String(
				"CREATE TABLE CANCER_PREVENTION(ID_cancer INTEGER,ID_prevention INTEGER)");
		db.execSQL(createExamTable);
		Log.d("ONCREATE","CREATED TABLE EXAM");
		db.execSQL(createCancerTable);
		Log.d("ONCREATE","CREATED TABLE CANCER");
		db.execSQL(createPreventionTable);
		Log.d("ONCREATE","CREATED TABLE PREVENTION");
		db.execSQL(createExamCancerTable);
		db.execSQL(createCancerPreventionTable);
		Log.d("ONCREATE","CREATED ALL TABLES");

	}

	public void addCancer(String name, String description, String[] relatedExams) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("cancer_name", name);
		values.put("cancer_description", description);

		// Inserting Row
		db.insert("CANCER", null, values);
		Log.d("ADDCANCER","INSERTED CANCER NAME="+name+" DESCRIPTION="+description);
		db.close(); // Closing database connection
		if (relatedExams != null) {
			Log.d("ADDCANCER","THERE ARE RELATED EXAMS");
			SQLiteDatabase db2 = this.getReadableDatabase();
			String query = new String(
					"SELECT ID_cancer FROM CANCER WHERE cancer_name='" + name+"';");
			Cursor c = db.rawQuery(query, null);
			Log.d("ADDCANCER","I HAVE EXECUTED THE QUERY");
			if (c.moveToFirst()) {
				for (String i : relatedExams) {
					query = new String(
							"SELECT ID_Examination FROM EXAMINATION WHERE examination_name='"
									+ i+"';");
					db2.rawQuery(query, null);
				}
				db2.close();
			}

		}
	}

	public void addPrevention(String name, String description) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("prevention_name", name);
		values.put("prevention_description", description);

		// Inserting Row
		db.insert("PREVENTION", null, values);
		db.close(); // Closing database connection
	}

	public void addExamination(String name, String description, int frequency,
			int sex, String agerange, String weight, int smoker, String height,
			int familyHistory, int alcohol) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("examination_name", name);
		values.put("examination_description", description);
		values.put("examination_frequency", frequency);
		values.put("examination_sex", sex);
		values.put("examination_agerange", agerange);
		values.put("examination_weight", weight);
		values.put("examination_smoker", smoker);
		values.put("examination_height", height);
		values.put("examination_family_history", familyHistory);
		values.put("examination_alcohol", alcohol);

		// Inserting Row
		db.insert("EXAMINATION", null, values);
		db.close(); // Closing database connection
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS EXAMINATION");
		db.execSQL("DROP TABLE IF EXISTS CANCER");
		db.execSQL("DROP TABLE IF EXISTS PREVENTION");
		db.execSQL("DROP TABLE IF EXISTS EXAMINATION_CANCER");
		db.execSQL("DROP TABLE IF EXISTS CANCER_PREVENTION");
		 
        // Create tables again
        onCreate(db);
	}

	public ArrayList<String> getCancerNames() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> names = new ArrayList<String>();
		String getNamesQuery = new String("SELECT cancer_name FROM CANCER;");
		Cursor c = db.rawQuery(getNamesQuery, null);
		if (c.moveToFirst()) {
			do {
				names.add(c.getString(0));
			} while (c.moveToNext());
			db.close();
			return names;
		} else
			db.close();
		return null;
	}

	public ArrayList<String> getRelatedExamsFromCancer(Cancer ca) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> eNames = new ArrayList<String>();
		int cID = ca.getId();
		String query = new String(
				"SELECT examination_name FROM EXAMINATION JOIN EXAMINATION_CANCER ON EXAMINATION.ID_Examination=EXAMINATION_CANCER.ID_Examination WHERE ID_Cancer="
						+ cID+";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			do {
				eNames.add(c.getString(0));
			} while (c.moveToNext());
			db.close();
			return eNames;
		} else {
			db.close();
			return null;
		}

	}

	public ArrayList<String> getCancerNameDescription(int cID) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> eNames = new ArrayList<String>();
		String query = new String(
				"SELECT cancer_name,cancer_description FROM CANCER WHERE ID_Cancer="
						+ cID+";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			eNames.add(c.getString(0));
			eNames.add(c.getString(1));
			db.close();
			return eNames;
		} else {
			db.close();
			return null;
		}

	}

}
