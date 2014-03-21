package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {

	private static DatabaseManager instance;

	public static synchronized DatabaseManager getHelper(Context context) {
		if (instance == null) {
			instance = new DatabaseManager(context);
			instance.getReadableDatabase();
		}
		return instance;
	}

	private DatabaseManager(Context context) {
		super(context, "SCC", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create query strings
		String createExamTable = new String(
				"CREATE TABLE EXAMINATION(ID_Examination INTEGER PRIMARY KEY AUTOINCREMENT,examination_name TEXT,examination_description TEXT,examination_frequency INTEGER,examination_sex INTEGER,examination_agerange TEXT,examination_dms TEXT,examination_smoker INTEGER,examination_family_history INTEGER,examination_alcohol INTEGER, image_name TEXT)");
		String createCancerTable = new String(
				"CREATE TABLE CANCER(ID_cancer INTEGER PRIMARY KEY AUTOINCREMENT,cancer_name TEXT,cancer_description TEXT,image_name TEXT)");
		String createPreventionTable = new String(
				"CREATE TABLE PREVENTION(ID_prevention INTEGER PRIMARY KEY AUTOINCREMENT,prevention_name TEXT,prevention_description TEXT,image_name TEXT)");
		String createExamCancerTable = new String(
				"CREATE TABLE EXAMINATION_CANCER(ID_Examination INTEGER,ID_cancer INTEGER)");
		String createCancerPreventionTable = new String(
				"CREATE TABLE CANCER_PREVENTION(ID_cancer INTEGER,ID_prevention INTEGER)");

		// execute creation queries
		db.execSQL(createExamTable);
		Log.d("SCC - DBCreate", "Created table EXAMINATION");
		db.execSQL(createCancerTable);
		Log.d("SCC - DBCreate", "Created table CANCER");
		db.execSQL(createPreventionTable);
		Log.d("SCC - DBCreate", "Created table PREVENTION");
		db.execSQL(createExamCancerTable);
		Log.d("SCC - DBCreate", "Created table EXAMINATION_CANCER");
		db.execSQL(createCancerPreventionTable);
		Log.d("SCC - DBCreate", "Created table CANCER_PREVENTION");

		// initialise table data
		addData(db);

	}

	public void addData(SQLiteDatabase db) {
		// since data is going to be static for now, enter here
		addCancer(
				db,
				"ΚΑΡΚΙΝΟΣ ΤΩΝ ΩΟΘΗΚΩΝ",
				"Oι ωοθήκες είναι μέρος του γυναικείου συστήματος αναπαραγωγής. Υπάρχει μια ωοθήκη σε κάθε πλευρά της μήτρας.\nΟ καρκίνος των ωοθηκών είναι ένας κακοήθης όγκος στη μία ή και στις δύο ωοθήκες. Υπάρχουν δύο τύποι, ο επιθηλιακός καρκίνος των ωοθηκών, που είναι ο πιο κοινός τύπος καρκίνου των ωοθηκών, και ο μη επιθηλιακός καρκίνος.\nΟι ακόλουθοι παράγοντες αυξάνουν τις πιθανότητες μιας γυναίκας να αναπτύξει καρκίνο στις ωοθήκες:\nηλικία, ιστορικό γέννησης παιδιών, ορμονικοί παράγοντες. Δεν υπάρχει αποδεδειγμένη σχέση μεταξύ του καρκίνου των ωοθηκών και της πλούσιας σε λίπη διατροφής, της χρήσης ταλκ γύρω από την περιοχή των γεννητικών οργάνων, ή του ιού της παρωτίτιδας (μαγουλάδες).",
				new String[] { "ΕΞΕΤΑΣΗ ΑΙΜΑΤΟΣ CA125" },
				new String[] { "ΥΓΙΕΙΝΗ ΔΙΑΤΡΟΦΗ" }, null);

		addCancer(
				db,
				"ΚΑΡΚΙΝΟΣ ΤΟΥ ΠΡΟΣΤΑΤΗ",
				"Ο καρκίνος του προστάτη είναι μια νόσος σοβαρή αλλά όχι πάντοτε θανατηφόρος. Έχει αργή εξέλιξη και όσο πρωιμότερη είναι η διάγνωσή τόσο μεγαλύτερες είναι οι πιθανότητες ριζικής θεραπείας.\nΠαράγοντες κινδύνου:\n•	Η προχωρημένη ηλικία.\n•	Το οικογενειακό ιστορικό.\n•	Η διατροφή πλούσια σε λιπαρά και η παχυσαρκία.\n•	Τα υψηλά επίπεδα τεστοστερόνης.\n•	Η επαγγελματική έκθεση στο κάδμιο, η εργασία σε βιομηχανία ελαστικών και η ιονίζουσα ακτινοβολία.",
				new String[] { "ΜΕΤΡΗΣΗ ΠΡΟΣΤΑΤΙΚΟΥ ΑΝΤΙΓΟΝΟΥ (PSA)",
						"ΔΑΚΤΥΛΙΚΗ ΕΞΕΤΑΣΗ", "ΒΙΟΨΙΑ ΠΡΟΣΤΑΤΗ" },
				new String[] { "ΥΓΙΕΙΝΗ ΔΙΑΤΡΟΦΗ" }, null);

		addExamination(db, "ΕΞΕΤΑΣΗ ΑΙΜΑΤΟΣ CA125",
				"ΕΞΕΤΑΣΗ ΑΙΜΑΤΟΣ CA125 για τον καρκίνο των ωοθηκών.", 12, 1,
				"50-90", 3, "0-40", 0, 0, null);
		addExamination(
				db,
				"ΜΕΤΡΗΣΗ ΠΡΟΣΤΑΤΙΚΟΥ ΑΝΤΙΓΟΝΟΥ (PSA)",
				"ΜΕΤΡΗΣΗ ΠΡΟΣΤΑΤΙΚΟΥ ΑΝΤΙΓΟΝΟΥ (PSA) για τον καρκίνο του προστάτη.",
				12, 0, "40-50", 3, "0-40", 0, 0, null);
		addPrevention(
				db,
				"ΥΓΙΕΙΝΗ ΔΙΑΤΡΟΦΗ",
				"Μειώστε την κατανάλωση τροφών υψηλής περιεκτικότητας σε λίπος, δίνοντας έμφαση στα φρούτα, στα λαχανικά και στις φυτικές ίνες ολικής αλέσεως. Επιπλέον, προτιμήστε τροφές που είναι πλούσιες σε λυκοπένη, μια αντιοξειδωτική ουσία, όπως ωμές ή μαγειρεμένες ντομάτες, προϊόντα ντομάτας, γκρέιπ φρουτ και καρπούζι. Το σκόρδο και τα λαχανικά, όπως το μπρόκολο, τα λαχανάκια Βρυξελλών, το λάχανο και το κουνουπίδι έχουν επίσης αντικαρκινική δράση. Προστασία πιθανόν παρέχουν και τα προϊόντα σόγιας που περιέχουν ισοφλαβονοειδή και η βιταμίνη E.",
				null);

	}

	public void addCancer(SQLiteDatabase db, String name, String description,
			String[] relatedExams, String[] relatedPreventions, String img) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("cancer_name", name);
		values.put("cancer_description", description);
		values.put("image_name", img);

		// Inserting Row
		db.insert("CANCER", null, values);
		Log.d("SCC - addCancer", "Added cancer: " + name);
		// db.close(); // Closing database connection

		if (relatedExams != null)
			addCancerRelatedExams(db, name, relatedExams);

		if (relatedPreventions != null)
			addCancerRelatedPreventions(db, name, relatedPreventions);
	}

	private void addCancerRelatedExams(SQLiteDatabase db, String name,
			String[] relatedExams) {
		// SQLiteDatabase db2 = this.getReadableDatabase();
		// find the cancer just added
		String query = new String(
				"SELECT ID_cancer FROM CANCER WHERE cancer_name='" + name + "'");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			for (String i : relatedExams) {
				// find related exam's id
				query = new String(
						"SELECT ID_Examination FROM EXAMINATION WHERE examination_name='"
								+ i + "'");
				Cursor c2 = db.rawQuery(query, null);
				if (c2.moveToFirst()) {
					// add entry to CANCER_EXAM table
					addCancerExam(db, c.getInt(0), c2.getInt(0));
				} else {
					// add exam
					addExamination(db, i);
					Log.d("SCC - addCancer", "Added related exam: " + name);
				}
			}
			// db2.close();
		} else {
			Log.e("SCC - addCancerRelatedExams", "COULD NOT RETRIEVE CANCER ID");
		}
	}

	private void addCancerExam(SQLiteDatabase db, int cid, int eid) {
		ContentValues values = new ContentValues();
		values.put("ID_Examination", eid);
		values.put("ID_cancer", cid);

		// Inserting Row
		db.insert("EXAMINATION_CANCER", null, values);
		Log.d("SCC - addCancer", "Added examination-cancer rel: " + eid + "-"
				+ cid);
	}

	private void addCancerRelatedPreventions(SQLiteDatabase db, String name,
			String[] relatedPreventions) {
		// find the cancer just added
		String query = new String(
				"SELECT ID_cancer FROM CANCER WHERE cancer_name='" + name + "'");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			for (String i : relatedPreventions) {
				// find related exam's id
				query = new String(
						"SELECT ID_prevention FROM PREVENTION WHERE prevention_name='"
								+ i + "'");
				Cursor c2 = db.rawQuery(query, null);
				if (c2.moveToFirst()) {
					// add entry to CANCER_PREVENTION table
					addCancerPrevention(db, c.getInt(0), c2.getInt(0));
				} else {
					// add prevention
					addPrevention(db, i, null, null);
					Log.d("SCC - addCancer", "Added related prevention: "
							+ name);
				}
			}
			// db2.close();
		}
	}

	private void addCancerPrevention(SQLiteDatabase db, int cid, int pid) {
		ContentValues values = new ContentValues();
		values.put("ID_cancer", cid);
		values.put("ID_prevention", pid);

		// Inserting Row
		db.insert("CANCER_PREVENTION", null, values);
		Log.d("SCC - addCancer", "Added prevention-cancer rel: " + pid + "-"
				+ cid);
	}

	public void addPrevention(SQLiteDatabase db, String name,
			String description, String img) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("prevention_name", name);
		values.put("prevention_description", description);
		values.put("image_name", img);
		String query = new String(
				"SELECT ID_prevention FROM PREVENTION WHERE prevention_name='"
						+ name + "'");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			// if prevention already exists by name, update description
			db.update("PREVENTION", values, "ID_prevention=" + c.getInt(0),
					null);
			Log.d("SCC - addPrevention", "Updated prevention: " + name);

		} else {

			// Inserting Row
			db.insert("PREVENTION", null, values);
			Log.d("SCC - addPrevention", "Added prevention: " + name);
		}
		// db.close(); // Closing database connection
	}

	public void addExamination(SQLiteDatabase db, String name) {
		addExamination(db, name, null, 0, 0, null, 0, null, 0, 0, null);
	}

	public void addExamination(SQLiteDatabase db, String name,
			String description, int frequency, int sex, String agerange,
			int smoker, String dms, int familyHistory, int alcohol, String img) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		// change to dms
		values.put("examination_name", name);
		values.put("examination_description", description);
		values.put("examination_frequency", frequency);
		values.put("examination_sex", sex);
		values.put("examination_agerange", agerange);
		values.put("examination_dms", dms);
		values.put("examination_smoker", smoker);
		values.put("examination_family_history", familyHistory);
		values.put("examination_alcohol", alcohol);
		values.put("image_name", img);

		String query = new String(
				"SELECT ID_Examination FROM EXAMINATION WHERE examination_name='"
						+ name + "'");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			// if prevention already exists by name, update description
			db.update("EXAMINATION", values, "ID_Examination=" + c.getInt(0),
					null);
			Log.d("SCC - addExamination", "Updated examination: " + name);

		} else {
			// Inserting Row
			db.insert("EXAMINATION", null, values);
			Log.d("SCC - addExam", "Added examination: " + name);
		}
		// db.close(); // Closing database connection
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion != oldVersion) {
			// drop and recreate tables
			db.execSQL("DROP TABLE IF EXISTS EXAMINATION");
			db.execSQL("DROP TABLE IF EXISTS CANCER");
			db.execSQL("DROP TABLE IF EXISTS PREVENTION");
			db.execSQL("DROP TABLE IF EXISTS EXAMINATION_CANCER");
			db.execSQL("DROP TABLE IF EXISTS CANCER_PREVENTION");
			onCreate(db);
		}
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

	public ArrayList<String> getExamNames() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> names = new ArrayList<String>();
		String getNamesQuery = new String(
				"SELECT examination_name FROM EXAMINATION;");
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

	public ArrayList<String> getPreventionNames() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> names = new ArrayList<String>();
		String getNamesQuery = new String(
				"SELECT prevention_name FROM PREVENTION;");
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
						+ cID + ";");
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

	public ArrayList<Cancer> getCancer(int cID) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Cancer> cancers = new ArrayList<Cancer>();
		String query = new String(
				"SELECT ID_cancer, cancer_name,cancer_description FROM CANCER WHERE ID_Cancer="
						+ cID + ";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			cancers.add(new Cancer(c.getInt(0), c.getString(1), c.getString(2)));
			db.close();
			return cancers;
		} else {
			db.close();
			return null;
		}

	}

	public ArrayList<Exam> getExam(int eID) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Exam> exams = new ArrayList<Exam>();
		String query = new String("SELECT * FROM EXAMINATION WHERE ID_Examination="
				+ eID + ";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			exams.add(new Exam(c.getString(1), c.getString(5), c.getInt(7), c
					.getInt(9), c.getString(6), c.getInt(5), c.getInt(8), c
					.getInt(4), c.getString(2), c.getString(10), c.getInt(3)));
			db.close();
			return exams;
		} else {
			db.close();
			return null;
		}

	}

	public ArrayList<Prevention> getPrevention(int pID) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Prevention> preventions = new ArrayList<Prevention>();
		String query = new String(
				"SELECT * FROM PREVENTION WHERE ID_prevention=" + pID + ";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			preventions.add(new Prevention(c.getInt(0), c.getString(1), c
					.getString(2)));
			db.close();
			return preventions;
		} else {
			db.close();
			return null;
		}

	}

	public ArrayList<Exam> getAllExams() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Exam> exams = new ArrayList<Exam>();
		String query = new String("SELECT * FROM EXAMINATION;");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			do {
				exams.add(new Exam(c.getString(1), c.getString(5), c.getInt(7),
						c.getInt(9), c.getString(6), c.getInt(5), c.getInt(8),
						c.getInt(4), c.getString(2), c.getString(10), c
								.getInt(3)));
			} while (c.moveToNext());
			db.close();
			return exams;
		} else {
			db.close();
			return null;
		}

	}

}
