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
		}
		return instance;
	}

	DatabaseManager(Context context) {
		super(context, "SCC", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create query strings
		String createExamTable = new String(
				"CREATE TABLE EXAMINATION(ID_Examination INTEGER PRIMARY KEY AUTOINCREMENT,examination_name TEXT,examination_description TEXT,examination_frequency INTEGER,examination_sex INTEGER,examination_agerange TEXT,examination_dms TEXT,examination_smoker INTEGER,examination_family_history INTEGER,examination_alcohol INTEGER, image_name TEXT, examination_gender INTEGER)");
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
		
		// Î•Î¼Î²ÏŒÎ»Î¹Î¿ Î³Î¹Î± Ï„Î¿Î½ Î¹Î¿ Î±Î½Î¸Ï�ÏŽÏ€Î¹Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½
		addExamination(db,  "EÎ¼Î²ÏŒÎ»Î¹Î¿ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Ï„Ï‰Î½ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½","EÎ½Î·Î¼ÎµÏ�Ï‰Î¸ÎµÎ¯Ï„Îµ Î³Î¹Î± Ï„Î¿ ÎµÎ¼Î²ÏŒÎ»Î¹Î¿ ÎºÎ±Î¹ ÎµÎ¼Î²Î¿Î»Î¹Î±ÏƒÏ„ÎµÎ¯Ï„Îµ Ï„Î¿ ÏƒÏ…Î½Ï„Î¿Î¼ÏŒÏ„ÎµÏ�Î¿.  ", 0, 0, "18-25", 3, "0-100", 2, 2, "-", 1);
		
		
		String[] relatedExamsCancerTraxilou={"Î¤Î•Î£Î¤ Î Î‘Î Î‘Î�Î™ÎšÎŸÎ›Î‘ÎŸÎ¥"};
		String[] relatedExamsPreventions={"Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ Î Ï�Î¿ÏƒÏ„Î±Ï„Î­ÏˆÎµÏ„Îµ Ï„Î¿Î½ ÎµÎ±Ï…Ï„ÏŒ ÏƒÎ±Ï‚ ","EÎ¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½"};
		//ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î¤Ï�Î±Ï‡Î®Î»Î¿Ï… Ï„Î·Ï‚ ÎœÎ®Ï„Ï�Î±Ï‚ 
		addCancer(db, "ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î¤Ï�Î±Ï‡Î®Î»Î¿Ï… Ï„Î·Ï‚ ÎœÎ®Ï„Ï�Î±Ï‚ ", "Î•Ï€Î·Ï�ÎµÎ¬Î¶ÎµÎ¹ Ï„Î¿Î½ Ï„Ï�Î¬Ï‡Î·Î»Î¿ Ï€Î¿Ï… ÏƒÏ…Î½Î´Î­ÎµÎ¹ Ï„Î· Î¼Î®Ï„Ï�Î± Î¼Îµ Ï„Î¿Î½ ÎºÏŒÎ»Ï€Î¿ (Î´ÎµÏ‚ ÎµÎ¹Îº.) \r\nÎ”ÎµÎ½ ÎµÎ¯Î½Î±Î¹ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î¹ÎºÏŒÏ‚. \r\nÎœÏ€Î¿Ï�ÎµÎ¯ Î½Î± Ï€Ï�Î¿ÎºÎ»Î·Î¸ÎµÎ¯ Î±Ï€ÏŒ Ï„Î¿Î½ Î¹ÏŒ Ï„Ï‰Î½ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½ (HPV-Human Papilloma Virus) Î¿ Î¿Ï€Î¿Î¯Î¿Ï‚ Î¼ÎµÏ„Î±Î´Î¯Î´ÎµÏ„Î±Î¹ Î¼Îµ Ï„Î· ÏƒÎµÎ¾Î¿Ï…Î±Î»Î¹ÎºÎ® ÎµÏ€Î±Ï†Î®. \r\nÎŸÎ¹ ÏƒÏ…ÏƒÏ„Î¬ÏƒÎµÎ¹Ï‚ ÎµÎ¯Î½Î±Î¹ ÏŒÏ€Ï‰Ï‚ Î¿Î¹ Î­Ï†Î·Î²Î¿Î¹ 11 ÎµÏ„ÏŽÎ½ ÎºÎ±Î¹ Ï€Î¬Î½Ï‰, Î±Î³ÏŒÏ�Î¹Î± ÎºÎ¿Ï�Î¯Ï„ÏƒÎ¹Î±, ÎµÎ¼Î²Î¿Î»Î¹Î±ÏƒÏ„Î¿Ï�Î½ Î³Î¹Î± Î±Ï€Î¿Ï„ÎµÎ»ÎµÏƒÎ¼Î±Ï„Î¹ÎºÎ® Ï€Ï�ÏŒÎ»Î·ÏˆÎ·.",relatedExamsCancerTraxilou,relatedExamsPreventions,"-");
			
		
		//Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ Î Ï�Î¿ÏƒÏ„Î±Ï„Î­ÏˆÎµÏ„Îµ Ï„Î¿Î½ ÎµÎ±Ï…Ï„ÏŒ ÏƒÎ±Ï‚ Î³Î¹Î± ÏŒÎ»ÎµÏ‚ Ï„Î¹Ï‚ Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ prevention
		addPrevention(db, "Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ Î Ï�Î¿ÏƒÏ„Î±Ï„Î­ÏˆÎµÏ„Îµ Ï„Î¿Î½ ÎµÎ±Ï…Ï„ÏŒ ÏƒÎ±Ï‚ ","Î‘Î½ ÎµÎ¯ÏƒÏ„Îµ ÎºÎ±Ï€Î½Î¯ÏƒÏ„Ï�Î¹Î± ÎµÎ½Ï„Î±Ï‡Î¸ÎµÎ¯Ï„Îµ ÏƒÎµ ÎŸÎ¼Î¬Î´Î± Î”Î¹Î±ÎºÎ¿Ï€Î®Ï‚ Ï„Î¿Ï… ÎšÎ±Ï€Î½Î¯ÏƒÎ¼Î±Ï„Î¿Ï‚ ÎºÎ±Î¹ Î±Ï€Î¿Î´ÎµÏƒÎ¼ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Î±Ï€ÏŒ Ï„Î¿Î½ 1Î¿ Ï€Î±Ï�Î¬Î³Î¿Î½Ï„Î± ÎºÎ¹Î½Î´Ï�Î½Î¿Ï… Î³Î¹Î± ÏŒÎ»Î¿Ï…Ï‚ Ï„Î¿Ï…Ï‚ ÎºÎ±Ï�ÎºÎ¯Î½Î¿Ï…Ï‚ ÎºÎ±Î¹ Ï„Î¿Î½ Î¿Ï€Î¿Î¯Î¿ Î¼Ï€Î¿Ï�ÎµÎ¯Ï„Îµ Î½Î± ÎµÎ»Î­Î³Î¾ÎµÏ„Îµ. \r\nÎ‘Î½ ÎµÎ¯ÏƒÏ„Îµ Î­Î³ÎºÏ…Î¿Ï‚ Î® Î¸Î·Î»Î¬Î¶ÎµÏ„Îµ ÏƒÏ„Î±Î¼Î±Ï„Î®ÏƒÏ„Îµ Ï„Î¿ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î± Î±Î¼Î­ÏƒÏ‰Ï‚. \r\nÎ‘Î½ Î¼ÎµÏ„Î±Ï†Î­Ï�ÎµÏ„Îµ Ï€Î±Î¹Î´Î¹Î¬ ÏƒÏ„Î¿ Î±Ï…Ï„Î¿ÎºÎ¯Î½Î·Ï„Î¿ Î® Î­Ï‡ÎµÏ„Îµ Ï€Î±Î¹Î´Î¹Î¬ ÏƒÏ„Î¿ ÏƒÏ€Î¯Ï„Î¹ Î¼Î·Î½ ÎºÎ±Ï€Î½Î¯Î¶ÎµÏ„Îµ ÏƒÏ„Î¿Ï…Ï‚ Ï‡ÏŽÏ�Î¿Ï…Ï‚ Î±Ï…Ï„Î¿Ï�Ï‚. \r\nÎ‘Î½ Î´ÎµÎ½ ÎºÎ±Ï€Î½Î¯Î¶ÎµÏ„Îµ Î¼Î·Î½ Î¾ÎµÎºÎ¹Î½Î®ÏƒÎµÏ„Îµ Ï€Î¿Ï„Î­. Î•Î¯ÏƒÏ„Îµ Î®Î´Î· ÎµÎ»ÎµÏ�Î¸ÎµÏ�Î·! Î‘Î½ ÎºÎ±Ï€Î½Î¯Î¶Î¿Ï…Î½ Î¬Î»Î»Î¿Î¹ ÏƒÏ„Î¿ Ï‡ÏŽÏ�Î¿ ÏƒÎ±Ï‚ Î´Î¹ÎµÎºÎ´Î¹ÎºÎ®ÏƒÏ„Îµ Ï„Î¿ Î´Î¹ÎºÎ±Î¯Ï‰Î¼Î¬ ÏƒÎ±Ï‚ Î³Î¹Î± Ï‡ÏŽÏ�Î¿Ï…Ï‚ ÎµÎ»ÎµÏ�Î¸ÎµÏ�Î¿Ï…Ï‚ Î±Ï€ÏŒ Ï„Î¿Î½ ÎºÎ±Ï€Î½ÏŒ Ï„Î¿Ï… Ï„ÏƒÎ¹Î³Î¬Ï�Î¿Ï…. \r\nÎ¤Î¿ Ï€Î±Î¸Î·Ï„Î¹ÎºÏŒ ÎºÎ±Î¹ Ï„Î¿ Ï„Ï�Î¹Ï„Î¿Î³ÎµÎ½Î­Ï‚ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î± ÎµÎ¯Î½Î±Î¹ Î²Î»Î±Ï€Ï„Î¹ÎºÎ¬ ÎºÎ±Î¹ ÎµÏ€Î¹ÎºÎ¯Î½Î´Ï…Î½Î± Î¹Î´Î¹Î±Î¯Ï„ÎµÏ�Î± Î³Î¹Î± Ï€Î±Î¹Î´Î¹Î¬.","-");
		
		
		//Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ Î Ï�Î¿ÏƒÏ„Î±Ï„Î­ÏˆÎµÏ„Îµ Ï„Î¿Î½ ÎµÎ±Ï…Ï„ÏŒ ÏƒÎ±Ï‚ Î³Î¹Î± ÏŒÎ»Î¿Ï…Ï‚ Ï„Î¿Ï…Ï‚ Î¬Î½Ï„Ï�ÎµÏ‚ prevention
		addPrevention(db,"Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ Î Ï�Î¿ÏƒÏ„Î±Ï„Î­ÏˆÎµÏ„Îµ Ï„Î¿Î½ ÎµÎ±Ï…Ï„ÏŒ ÏƒÎ±Ï‚ ","Î‘Î½ ÎµÎ¯ÏƒÏ„Îµ ÎºÎ±Ï€Î½Î¹ÏƒÏ„Î®Ï‚ ÎµÎ½Ï„Î±Ï‡Î¸ÎµÎ¯Ï„Îµ ÏƒÎµ ÎŸÎ¼Î¬Î´Î± Î”Î¹Î±ÎºÎ¿Ï€Î®Ï‚ Ï„Î¿Ï… ÎšÎ±Ï€Î½Î¯ÏƒÎ¼Î±Ï„Î¿Ï‚ ÎºÎ±Î¹ Î±Ï€Î¿Î´ÎµÏƒÎ¼ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Î±Ï€ÏŒ Ï„Î¿Î½ 1Î¿ Ï€Î±Ï�Î¬Î³Î¿Î½Ï„Î± ÎºÎ¹Î½Î´Ï�Î½Î¿Ï… Î³Î¹Î± ÏŒÎ»Î¿Ï…Ï‚ Ï„Î¿Ï…Ï‚ ÎºÎ±Ï�ÎºÎ¯Î½Î¿Ï…Ï‚ ÎºÎ±Î¹ Ï„Î¿Î½ Î¿Ï€Î¿Î¯Î¿ Î¼Ï€Î¿Ï�ÎµÎ¯Ï„Îµ Î½Î± ÎµÎ»Î­Î³Î¾ÎµÏ„Îµ. \r\nÎ‘Î½ Î¼ÎµÏ„Î±Ï†Î­Ï�ÎµÏ„Îµ Ï€Î±Î¹Î´Î¹Î¬ ÏƒÏ„Î¿ Î±Ï…Ï„Î¿ÎºÎ¯Î½Î·Ï„Î¿ Î® Î­Ï‡ÎµÏ„Îµ Ï€Î±Î¹Î´Î¹Î¬ ÏƒÏ„Î¿ ÏƒÏ€Î¯Ï„Î¹ Î¼Î·Î½ ÎºÎ±Ï€Î½Î¯Î¶ÎµÏ„Îµ ÏƒÏ„Î¿Ï…Ï‚ Ï‡ÏŽÏ�Î¿Ï…Ï‚ Î±Ï…Ï„Î¿Ï�Ï‚.Î‘Î½ Î´ÎµÎ½ ÎºÎ±Ï€Î½Î¯Î¶ÎµÏ„Îµ Î¼Î·Î½ Î¾ÎµÎºÎ¹Î½Î®ÏƒÎµÏ„Îµ Ï€Î¿Ï„Î­. Î•Î¯ÏƒÏ„Îµ Î®Î´Î· ÎµÎ»ÎµÏ�Î¸ÎµÏ�Î¿Ï‚! \r\nÎ‘Î½ ÎºÎ±Ï€Î½Î¯Î¶Î¿Ï…Î½ Î¬Î»Î»Î¿Î¹ ÏƒÏ„Î¿ Ï‡ÏŽÏ�Î¿ ÏƒÎ±Ï‚ Î´Î¹ÎµÎºÎ´Î¹ÎºÎ®ÏƒÏ„Îµ Ï„Î¿ Î´Î¹ÎºÎ±Î¯Ï‰Î¼Î¬ ÏƒÎ±Ï‚ Î³Î¹Î± Ï‡ÏŽÏ�Î¿Ï…Ï‚ ÎµÎ»ÎµÏ�Î¸ÎµÏ�Î¿Ï…Ï‚ Î±Ï€ÏŒ Ï„Î¿Î½ ÎºÎ±Ï€Î½ÏŒ Ï„Î¿Ï… Ï„ÏƒÎ¹Î³Î¬Ï�Î¿Ï…. \r\nÎ¤Î¿ Ï€Î±Î¸Î·Ï„Î¹ÎºÏŒ ÎºÎ±Î¹ Ï„Î¿ Ï„Ï�Î¹Ï„Î¿Î³ÎµÎ½Î­Ï‚ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î± ÎµÎ¯Î½Î±Î¹ Î²Î»Î±Ï€Ï„Î¹ÎºÎ¬ ÎºÎ±Î¹ ÎµÏ€Î¹ÎºÎ¯Î½Î´Ï…Î½Î± Î¹Î´Î¹Î±Î¯Ï„ÎµÏ�Î± Î³Î¹Î± Ï€Î±Î¹Î´Î¹Î¬.","-");

		
		
		// Î¤ÎµÏƒÏ„ Î Î±Ï€Î±Î½Î¹ÎºÎ¿Î»Î¬Î¿Ï… Î³Î¹Î± Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ 18-45 Î¼Îµ ÏƒÎµÎ¾Î¿Ï…Î±Î»Î¹ÎºÎ® ÎµÏ€Î±Ï†Î®
		addExamination(db, "Î¤Î•Î£Î¤ Î Î‘Î Î‘Î�Î™ÎšÎŸÎ›Î‘ÎŸÎ¥", "Î¤Î¿ Î¤ÎµÏƒÏ„ Î Î±Ï€Î±Î½Î¹ÎºÎ¿Î»Î¬Î¿Ï… (Ï…Î³Ï�Î®Ï‚ ÎºÏ…Ï„Ï„Î±Ï�Î¿Î»Î¿Î³Î¯Î±Ï‚) Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± Ï‡Ï�Î·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹Î·Î¸ÎµÎ¯ Î³Î¹Î± Î½Î± Î´Î¹Î±Î³Î½ÏŽÏƒÎµÎ¹ Î­Î³ÎºÎ±Î¹Ï�Î± Ï„Î¿Î½ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Ï„Ï�Î±Ï‡Î®Î»Î¿Ï… Ï„Î·Ï‚ Î¼Î®Ï„Ï�Î±Ï‚. Î•Î¯Î½Î±Î¹ ÎºÎ±Î»ÏŒ Î½Î± Î³Î¯Î½ÎµÏ„Î±Î¹ ÎºÎ¬Î¸Îµ 1-2 Ï‡Ï�ÏŒÎ½Î¹Î±, 2 Ï‡Ï�ÏŒÎ½Î¹Î± Î¼ÎµÏ„Î¬ Ï„Î·Î½ Ï€Ï�ÏŽÏ„Î· ÏƒÎµÎ¾Î¿Ï…Î±Î»Î¹ÎºÎ® ÎµÏ€Î±Ï†Î®.", 16, 1, "18-45", 3, "0-100", 2, 2, "-", 1);
		
		// Î¤ÎµÏƒÏ„ Î Î±Ï€Î±Î½Î¹ÎºÎ¿Î»Î¬Î¿Ï… Î³Î¹Î± Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ 45+ Î¼Îµ ÏƒÎµÎ¾Î¿Ï…Î±Î»Î¹ÎºÎ® ÎµÏ€Î±Ï†Î®
		addExamination(db, "Î¤Î•Î£Î¤ Î Î‘Î Î‘Î�Î™ÎšÎŸÎ›Î‘ÎŸÎ¥", "Î¤Î¿ Î¤ÎµÏƒÏ„ Î Î±Ï€Î±Î½Î¹ÎºÎ¿Î»Î¬Î¿Ï… (Ï…Î³Ï�Î®Ï‚ ÎºÏ…Ï„Ï„Î±Ï�Î¿Î»Î¿Î³Î¯Î±Ï‚) Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± Ï‡Ï�Î·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹Î·Î¸ÎµÎ¯ Î³Î¹Î± Î½Î± Î´Î¹Î±Î³Î½ÏŽÏƒÎµÎ¹ Î­Î³ÎºÎ±Î¹Ï�Î± Ï„Î¿Î½ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Ï„Ï�Î±Ï‡Î®Î»Î¿Ï… Ï„Î·Ï‚ Î¼Î®Ï„Ï�Î±Ï‚. Î•Î¯Î½Î±Î¹ ÎºÎ±Î»ÏŒ Î½Î± Î³Î¯Î½ÎµÏ„Î±Î¹ ÎºÎ¬Î¸Îµ 1-2 Ï‡Ï�ÏŒÎ½Î¹Î±, 2 Ï‡Ï�ÏŒÎ½Î¹Î± Î¼ÎµÏ„Î¬ Ï„Î·Î½ Ï€Ï�ÏŽÏ„Î· ÏƒÎµÎ¾Î¿Ï…Î±Î»Î¹ÎºÎ® ÎµÏ€Î±Ï†Î®. \r\nÎ‘Î½ Î´ÎµÎ½ Î­Ï‡ÎµÏ„Îµ Î¾Î±Î½Î±ÎºÎ¬Î½ÎµÎ¹ Î¤ÎµÏƒÏ„ Î Î±Ï€Î±Î½Î¹ÎºÎ¿Î»Î¬Î¿Ï…, Î¼Î·Î½ Ï„Î¿ Î±Î¼ÎµÎ»Î®ÏƒÎµÏ„Îµ Î¬Î»Î»Î¿. ÎšÎ¬Î½Ï„Îµ Ï„Î¿ Ï„ÎµÏƒÏ„ ÎºÎ±Î¹ Î­Î½Î± Ï…Ï€ÎµÏ�Î·Ï‡Î¿Î³Ï�Î¬Ï†Î·Î¼Î± ÏƒÏ„Î¿ Î³Ï…Î½Î±Î¹ÎºÎ¿Î»ÏŒÎ³Î¿ ÏƒÎ±Ï‚. \r\nÎ‘Î½ ÎºÎ»Î·Î¸Î®Ï„Îµ Î³Î¹Î± ÎµÎ¾Î­Ï„Î±ÏƒÎ· ÏƒÏ„Î± Ï€Î»Î±Î¯ÏƒÎ¹Î± Ï€Î»Î·Î¸Ï…ÏƒÎ¼Î¹Î±ÎºÎ¿Ï� Ï€Ï�Î¿Î³Ï�Î¬Î¼Î¼Î±Ï„Î¿Ï‚, Î±Î½Ï„Î±Ï€Î¿ÎºÏ�Î¹Î¸ÎµÎ¯Ï„Îµ Î¬Î¼ÎµÏƒÎ±.", 16, 1, "45-120", 3, "0-100", 2, 2, "-", 1);
		
		
		
		//20 ÎµÏ„ÏŽÎ½ Î¼Î­Ï‡Ï�Î¹ Ï„Î± 39 ÎºÎ¬Î½ÎµÏ„Îµ ÎºÎ»Î¹Î½Î¹ÎºÎ® ÎµÎ¾Î­Ï„Î±ÏƒÎ· Î³Î¹Î± Î´Î¹Î¬Î³Î½Ï‰ÏƒÎ· Ï„Î¿Ï… ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï… Ï„Î¿Ï… ÎœÎ±ÏƒÏ„Î¿Ï�
		addExamination(db, "ÎšÎ»Î¹Î½Î¹ÎºÎ® ÎµÎ¾Î­Ï„Î±ÏƒÎ· Î³Î¹Î± Î´Î¹Î¬Î³Î½Ï‰ÏƒÎ· Ï„Î¿Ï… ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï… Ï„Î¿Ï… ÎœÎ±ÏƒÏ„Î¿Ï�","", 16, 1, "45-120", 3, "0-100", 2, 2, "-", 1);
		
		
		String[]relatedExamsCancerMastou={"ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î±","Î£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Ï„Î¿Î½ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚","ÎšÎ»Î¹Î½Î¹ÎºÎ® ÎµÎ¾Î­Ï„Î±ÏƒÎ· Î³Î¹Î± Î´Î¹Î¬Î³Î½Ï‰ÏƒÎ· Ï„Î¿Ï… ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï… Ï„Î¿Ï… ÎœÎ±ÏƒÏ„Î¿Ï�","ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± ÎºÎ±Î¹ Ï…Ï€ÎµÏ�Î·Ï‡Î¿Î³Ï�Î¬Ï†Î·Î¼Î± (ultra sound)"};
		//ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… ÎœÎ±ÏƒÏ„Î¿Ï�
		addCancer(db, "ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… ÎœÎ±ÏƒÏ„Î¿Ï�", "Î•Î¯Î½Î±Î¹ Î¸ÎµÏ�Î±Ï€ÎµÏ�ÏƒÎ¹Î¼Î¿Ï‚ ÏŒÏ„Î±Î½ Î³Î¯Î½ÎµÏ„Î±Î¹ Î­Î³ÎºÎ±Î¹Ï�Î± Î· Î´Î¹Î¬Î³Î½Ï‰ÏƒÎ·. Î ÎµÏ�Î¹Î¿Ï�Î¯ÏƒÏ„Îµ Ï„Î·Î½ ÎºÎ±Ï„Î±Î½Î¬Î»Ï‰ÏƒÎ· Î¶Ï‰ÏŠÎºÎ¿Ï� Î»Î¯Ï€Î¿Ï…Ï‚ ÎºÎ±Î¹ ÎºÏ�ÎµÎ±Ï„Î¹ÎºÏŽÎ½. Î•Î¼Ï€Î»Î¿Ï…Ï„Î¯ÏƒÏ„Îµ Ï„Î¿ Î´Î¹Î±Î¹Ï„Î¿Î»ÏŒÎ³Î¹Î¿ Î¼Îµ Ï†Ï�Î¿Ï�Ï„Î± ÎºÎ±Î¹ Î»Î±Ï‡Î±Î½Î¹ÎºÎ¬ (Ï„Î¿Ï…Î»Î¬Ï‡Î¹ÏƒÏ„Î¿Î½ 5 Î¼ÎµÏ�Î¯Î´ÎµÏ‚ Ï„Î·Î½ Î·Î¼Î­Ï�Î±) ÎºÎ±Î¹ ÏˆÎ±Ï�Î¹ÎºÎ¬. Î Î¯Î½ÎµÏ„Îµ Î¬Ï†Î¸Î¿Î½Î¿ Î½ÎµÏ�ÏŒ ÎºÎ±Î¹ Î±Ï€Î¿Ï†ÎµÏ�Î³ÎµÏ„Îµ Î±Î½Î±ÏˆÏ…ÎºÏ„Î¹ÎºÎ¬ ÎºÎ±Î¹ Î±Î»ÎºÎ¿ÏŒÎ». ÎœÎ·Î½ ÎºÎ±Ï€Î½Î¯Î¶ÎµÏ„Îµ. ÎšÎ¬Ï€Î¿Î¹ÎµÏ‚ Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ Î¸ÎµÏ‰Ï�Î¿Ï�Î½Ï„Î±Î¹ Î¬Ï„Î¿Î¼Î± ÏˆÎ·Î»Î¿Ï� ÎºÎ¹Î½Î´Ï�Î½Î¿Ï… Î»ÏŒÎ³Ï‰ Î³Î¿Î½Î¹Î´Î¯Ï‰Î½ ÎºÎ±Î¹ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î¹ÎºÏŒÏ„Î·Ï„Î±Ï‚.",relatedExamsCancerMastou,relatedExamsPreventions,"-");
		//Î£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Ï„Î¿Î½ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚
		addExamination(db, "Î£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Ï„Î¿Î½ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚","Î‘Î½ Î­Ï‡ÎµÏ„Îµ ÏƒÏ…Î³Î³ÎµÎ½ÎµÎ¯Ï‚ Î±Ï€ÏŒ Ï„Î¿ ÏƒÏ„ÎµÎ½ÏŒ Î¿Î¹ÎºÎ¿Î³ÎµÎ½ÎµÎ¹Î±ÎºÏŒ Ï€ÎµÏ�Î¹Î²Î¬Î»Î»Î¿Î½ Î¼Îµ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Î¼Î±ÏƒÏ„Î¿Ï�, Î® ÎºÎ±Î¹ Ï€Î±Ï�Î¬Î»Î»Î·Î»Î± Î¼Îµ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Ï‰Î½ Ï‰Î¿Î¸Î·ÎºÏŽÎ½ Î® Î¼Îµ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Ï€Î±Ï‡Î­Î¿Ï‚ ÎµÎ½Ï„Î­Ï�Î¿Ï… ÏƒÏ…Î¼Î²Î¿Ï…Î»ÎµÏ…Î¸ÎµÎ¯Ï„Îµ Ï„Î¿ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚",0,2,"18-25",3,"0-100",1,2,"-",1);
		
		//ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± ÎºÎ±Î¹ Ï…Ï€ÎµÏ�Î·Ï‡Î¿Î³Ï�Î¬Ï†Î·Î¼Î± (ultra sound)"
		addExamination(db,"ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± ÎºÎ±Î¹ Ï…Ï€ÎµÏ�Î·Ï‡Î¿Î³Ï�Î¬Ï†Î·Î¼Î± (ultra sound)","Î“Î½Ï‰Ï�Î¯Î¶Î¿Î½Ï„Î±Ï‚ Ï„Î¿ Î¹ÏƒÏ„Î¿Ï�Î¹ÎºÏŒ Ï„Î·Ï‚ Î¿Î¹ÎºÎ¿Î³Î­Î½ÎµÎ¹Î¬Ï‚ ÏƒÎ±Ï‚, Î±Î½ ÎºÎ¬Ï€Î¿Î¹Î¿Ï‚ ÏƒÏ„ÎµÎ½ÏŒÏ‚ ÏƒÏ…Î³Î³ÎµÎ½Î®Ï‚ Î­Ï‡ÎµÎ¹ Î´Î¹Î±Î³Î½Ï‰ÏƒÎ¸ÎµÎ¯ Î¼Îµ ÎºÎ¬Ï€Î¿Î¹Î¿ ÎµÎ¯Î´Î¿Ï‚ ÎºÎ±Ï�ÎºÎ¯Î½Î¿Ï… ÏƒÎµ Î·Î»Î¹ÎºÎ¯Î± ÎºÎ¬Ï„Ï‰ Ï„Ï‰Î½ 40 ÎµÏ„ÏŽÎ½, Î® Î±Î½ Î­Ï‡ÎµÎ¹ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ ÎºÎ±Î¹ ÏƒÏ„Î¿Ï…Ï‚ Î´Ï…Î¿ Î¼Î±ÏƒÏ„Î¿Ï�Ï‚, Î¼Î¹Î»Î®ÏƒÏ„Îµ Î¼Îµ Ï„Î¿ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚. \r\n ÎœÎµÏ„Î¬ Ï„Î± 35 Î¾ÎµÎºÎ¹Î½Î®ÏƒÏ„Îµ Î½Î± ÎºÎ¬Î½ÎµÏ„Îµ Î¼Î±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± ÎºÎ¬Î¸Îµ Ï‡Ï�ÏŒÎ½Î¿ Î•Î¯Ï„Îµ Î­Ï‡ÎµÏ„Îµ ÏƒÏ…Î¼Ï€Ï„ÏŽÎ¼Î±Ï„Î± ÎµÎ¯Ï„Îµ ÏŒÏ‡Î¹ Î· Î¿Ï€Î¿Î¯Î± ÎµÎ¯Î½Î±Î¹ ÎºÎ±Î»Î¬ Î½Î± ÏƒÏ…Î½Î¿Î´ÎµÏ�ÎµÏ„Î±Î¹ Î¼Îµ Ï…Ï€ÎµÏ�Î·Ï‡Î¿Î³Ï�Î¬Ï†Î·Î¼Î± (ultra sound).",0,2,"22-65",3,"0-100",2,2,"-",1);

		//ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î±	40-75 
		addExamination(db,"ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î±","ÎˆÏ‡ÎµÏ„Îµ ÎµÎ½Î¿Ï‡Î»Î®ÏƒÎµÎ¹Ï‚ Î® ÏƒÏ…Î¼Ï€Ï„ÏŽÎ¼Î±Ï„Î± ÏŒÏ€Ï‰Ï‚: Î£Ï„Î¿ Î¼Î±ÏƒÏ„ÏŒ: \r\n â—�Î±Î»Î»Î±Î³Î® ÏƒÏ„Î¿ Î¼Î­Î³ÎµÎ¸Î¿Ï‚ Î® ÏƒÏ‡Î®Î¼Î± \r\nâ—�Ï�Ï…Ï„Î¹Î´ÏŽÎ´Î·Ï‚ Ï…Ï†Î® Î´Î­Ï�Î¼Î±Ï„Î¿Ï‚ \r\nâ—�ÏƒÎºÎ»Î·Ï�ÏŒÏ„Î·Ï„Î±  \r\nÎ£Ï„Î· Î¸Î·Î»Î®: \r\nâ—�ÎºÎ¿Î¯Î»Î±Î½ÏƒÎ· \r\nâ—�ÎµÎ¾ÏŒÎ³ÎºÏ‰ÏƒÎ· Î® ÏƒÎºÎ»Î®Ï�Ï…Î½ÏƒÎ· \r\nâ—�ÎµÎºÎºÏ�Î¯ÏƒÎµÎ¹Ï‚ \r\nâ—�ÎµÏ�ÎµÎ¸Î¹ÏƒÎ¼ÏŒÏ‚.  \r\nÎ£Ï„Î¿Î½ ÏŽÎ¼Î¿: \r\nâ—�Ï€Ï�Î®Î¾Î¹Î¼Î¿ ÏƒÏ„Î· Î¼Î±ÏƒÏ‡Î¬Î»Î·, \r\nÎ´Î¹ÏŒÎ³ÎºÏ‰ÏƒÎ· Î»ÎµÎ¼Ï†Î±Î´Î­Î½Ï‰Î½.  \r\nÎ“Î¹Î± Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ Î·Î»Î¹ÎºÎ¯Î±Ï‚ 50-69 ÎµÏ„ÏŽÎ½ Î³Î¯Î½Î¿Î½Ï„Î±Î¹ Î¼Î±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯ÎµÏ‚ Î´Ï‰Ï�ÎµÎ¬Î½, ÏƒÏ„Î± Ï€Î»Î±Î¯ÏƒÎ¹Î± Ï„Î¿Ï… Ï€Ï�Î¿Î³Ï�Î¬Î¼Î¼Î±Ï„Î¿Ï‚ Ï€Î»Î·Î¸Ï…ÏƒÎ¼Î¹Î±ÎºÎ¿Ï� ÎµÎ»Î­Î³Ï‡Î¿Ï… Ï„Î¿Ï… Î¥Ï€Î¿Ï…Ï�Î³ÎµÎ¯Î¿Ï… Î¥Î³ÎµÎ¯Î±Ï‚. Î— Î¼Î±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± ÎµÏ€Î±Î½Î±Î»Î±Î¼Î²Î¬Î½ÎµÏ„Î±Î¹ ÎºÎ¬Î¸Îµ 2 Ï‡Ï�ÏŒÎ½Î¹Î±. Î— Ï€Ï�ÏŒÏƒÎºÎ»Î·ÏƒÎ· Î±Ï€Î¿ÏƒÏ„Î­Î»Î»ÎµÏ„Î±Î¹ Ï„Î±Ï‡Ï…Î´Ï�Î¿Î¼Î¹ÎºÏŽÏ‚. Î‘Î½ Î´ÎµÎ½ Î­Ï‡ÎµÏ„Îµ Î±Î½Ï„Î±Ï€Î¿ÎºÏ�Î¹Î¸ÎµÎ¯ Î±ÎºÏŒÎ¼Î± Î´Ï�Î¬ÏƒÏ„Îµ Ï„ÏŽÏ�Î± ÎºÎ±Î¹ Î±Î½ Î´ÎµÎ½ ÏƒÎ±Ï‚ Î­Ï‡ÎµÎ¹ Î±Ï€Î¿ÏƒÏ„Î±Î»ÎµÎ¯ Ï€Ï�ÏŒÏƒÎºÎ»Î·ÏƒÎ· ÎµÏ€Î¹ÎºÎ¿Î¹Î½Ï‰Î½Î®ÏƒÏ„Îµ Î¼Îµ Ï„Î¿ Î¥Ï€Î¿Ï…Ï�Î³ÎµÎ¯Î¿ Î¥Î³ÎµÎ¯Î±Ï‚. \r\nÎ Ï�Î¿ÏƒÎ¿Ï‡Î® â€“ Î— Î¼Î±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î± Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± ÎµÎ½Ï„Î¿Ï€Î¯ÏƒÎµÎ¹ Î¿Î³ÎºÎ¯Î´Î¹Î¿ Ï€Ï�Î¹Î½ Î½Î± Ï„Î¿ ÎµÎ½Ï„Î¿Ï€Î¯ÏƒÎµÏ„Îµ ÎµÏƒÎµÎ¯Ï‚ Î® Î¿ Î³Î¹Î±Ï„Ï�ÏŒÏ‚ ÏƒÎ±Ï‚ \r\n	ÎšÎ­Î½Ï„Ï�Î± ÎœÎ±ÏƒÏ„Î¿Î³Ï�Î±Ï†Î¯Î±Ï‚ - Î�Ï�ÎµÏ‚ Î›ÎµÎ¹Ï„Î¿Ï…Ï�Î³Î¯Î±Ï‚ 7:30Ï€.Î¼.-2:30Î¼.Î¼. :\r\n â€¢  ÎšÎ­Î½Ï„Ï�Î¿ Î¥Î³ÎµÎ¯Î±Ï‚ Î‘Î³Î»Î±Î½Ï„Î¶Î¹Î¬Ï‚ - Î¤Î·Î»: 22444460 \r\nâ€¢  Î Î±Î»Î±Î¹ÏŒ Î�Î¿ÏƒÎ¿ÎºÎ¿Î¼ÎµÎ¯Î¿ Î›ÎµÎ¼ÎµÏƒÎ¿Ï� â€“ Î¤Î·Î»: 25305124 \r\nâ€¢  Î“ÎµÎ½Î¹ÎºÏŒ Î�Î¿ÏƒÎ¿ÎºÎ¿Î¼ÎµÎ¯Î¿ Î›Î¬Ï�Î½Î±ÎºÎ±Ï‚ â€“ Î¤Î·Î»: 24625124 \r\nâ€¢  Î“ÎµÎ½Î¹ÎºÏŒ Î�Î¿ÏƒÎ¿ÎºÎ¿Î¼ÎµÎ¯Î¿ Î Î¬Ï†Î¿Ï… - Î¤Î·Î»: 26803225, Î�Ï�ÎµÏ‚ Î›ÎµÎ¹Ï„Î¿Ï…Ï�Î³Î¯Î±Ï‚ 3:30Î¼.Î¼.-5:20Î¼.Î¼. (Î”ÎµÏ…Ï„Î­Ï�Î± â€“ Î Î±Ï�Î±ÏƒÎºÎµÏ…Î®) ÎºÎ±Î¹ 9:00Ï€.Î¼.-1:00Î¼.Î¼. (Î£Î¬Î²Î²Î±Ï„Î¿) \r\nâ€¢  Î“ÎµÎ½Î¹ÎºÏŒ Î�Î¿ÏƒÎ¿ÎºÎ¿Î¼ÎµÎ¯Î¿ Î‘Î¼Î¼Î¿Ï‡ÏŽÏƒÏ„Î¿Ï… - Î¤Î·Î»: 23200166",0,2,"40-120",3,"0-100",2,2,"-",1);
		
		
		//Î•Î¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½"
		addExamination(db, "EÎ¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½","Î‘Î½ Î´ÎµÎ½ Î­Ï‡ÎµÏ„Îµ Î®Î´Î· ÎµÎ¼Î²Î¿Î»Î¹Î±ÏƒÏ„ÎµÎ¯ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½ Î¼Ï€Î¿Ï�ÎµÎ¯Ï„Îµ ÎµÎ¼Î²Î¿Î»Î¹Î±ÏƒÏ„ÎµÎ¯Ï„Îµ ÎºÎ±Î¹ Î³Î¹Î± Î´Î¹ÎºÎ® ÏƒÎ±Ï‚ Ï€Ï�Î¿ÏƒÏ„Î±ÏƒÎ¯Î±.  ",0,2,"18-25",3,"0-100",1,2,"",2);
			
		String[]relatedExamsCancerOrxewn={"Î‘Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏ‰Î½","EÎ¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½"};
		
		//ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏ‰Î½ *
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏ‰Î½","Î•Î½Ï„Î¿Ï€Î¯Î¶ÎµÏ„Î±Î¹ ÏƒÎµ Î½ÎµÎ±Ï�Î­Ï‚ Î·Î»Î¹ÎºÎ¯ÎµÏ‚ ÎºÎ±Î¹ Î¸ÎµÏ�Î±Ï€ÎµÏ�ÎµÏ„Î±Î¹ ÎµÏ�ÎºÎ¿Î»Î± ÎºÎ±Î¹ Î³Î¹Î± Ï€Î¬Î½Ï„Î± ÏŒÏ„Î±Î½ ÎµÎ½Ï„Î¿Ï€Î¯Î¶ÎµÏ„Î±Î¹ Î­Î³ÎºÎ±Î¹Ï�Î±. \r\nÎ— Î¼Î·Î½Î¹Î±Î¯Î± Î±Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± ÏƒÎ±Ï‚ ÏƒÏŽÏƒÎµÎ¹. \r\nÎ— ÎºÏ�Ï…ÏˆÎ¿Ï�Ï‡Î¯Î± ÎºÎ±Î¹ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î¹ÎºÏŒÏ„Î·Ï„Î± Î±Ï€Î¿Ï„ÎµÎ»Î¿Ï�Î½ Ï€Î¹Î¸Î±Î½Î¿Ï�Ï‚ Ï€Î±Ï�Î¬Î³Î¿Î½Ï„ÎµÏ‚ ÎºÎ¹Î½Î´Ï�Î½Î¿Ï…",relatedExamsCancerOrxewn,relatedExamsPreventions,"-");
		
		//Î‘Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏ‰Î½
		addExamination(db,"Î‘Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏ‰Î½", "Î‘ÎºÎ¿Î»Î¿Ï�Î¸Î·ÏƒÎµ Ï„Î± Ï€Î¹Î¿ ÎºÎ¬Ï„Ï‰ Î²Î®Î¼Î±Ï„Î± Î³Î¹Î± Ï„Î·Î½ Î±Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Ï„Ï‰Î½ ÏŒÏ�Ï‡ÎµÏŽÎ½ ÏƒÎ±Ï‚ Î¼ÎµÏ„Î¬ Ï„Î¿ Î¼Ï€Î¬Î½Î¹Î¿ Î¼Î¹Î± Ï†Î¿Ï�Î¬ Ï„Î¿ Î¼Î®Î½Î± (Î´ÎµÏ‚ ÎµÎ¹Îº.) \r\nÎ¨Î·Î»Î¬Ï†Î¹ÏƒÎµ Ï„Î¿Ï…Ï‚ ÏŒÏ�Ï‡ÎµÎ¹Ï‚. Î•Î¯Î½Î±Î¹ Ï†Ï…ÏƒÎ¹Î¿Î»Î¿Î³Î¹ÎºÏŒ Î½Î± Î´Î¹Î±Ï†Î­Ï�ÎµÎ¹ Î¿ Î­Î½Î±Ï‚ Î±Ï€ÏŒ Ï„Î¿Î½ Î¬Î»Î»Î¿ ÏƒÎµ Î¼Î­Î³ÎµÎ¸Î¿Ï‚ Î® ÏƒÏ„Î¿ Ï�ÏˆÎ¿Ï‚ Ï€Î¿Ï… Î²Ï�Î¯ÏƒÎºÎµÏ„Î±Î¹. \r\nÎ’Ï�ÎµÏ‚ Ï„Î·Î½ ÎµÏ€Î¹Î´Î¹Î´Ï…Î¼Î¯Î´Î± ÏƒÏ„Î¿ Ï€Î¬Î½Ï‰ Î¼Î­Ï�Î¿Ï‚ ÎºÎ¬Î¸Îµ ÏŒÏ�Ï‡Î¹. Î•Î¯Î½Î±Î¹ Î¼Î±Î»Î±ÎºÎ® ÎºÎ±Î¹ ÎµÏ…Î±Î¯ÏƒÎ¸Î·Ï„Î·. \r\nÎ’Ï�ÎµÏ‚ Ï„Î¿Î½ ÏƒÏ€ÎµÏ�Î¼Î±Ï„Î¹ÎºÏŒ Ï„ÏŒÎ½Î¿. ÎžÎµÎºÎ¹Î½Î¬ Î±Ï€ÏŒ Ï„Î·Î½ ÎºÎ¿Ï�Ï…Ï†Î® Ï„Î·Ï‚ ÎµÏ€Î¹Î´Î¹Î´Ï…Î¼Î¯Î´Î±Ï‚, Ï€Î¯ÏƒÏ‰ Î±Ï€ÏŒ Ï„Î¿Î½ ÏŒÏ�Ï‡Î¹ ÎºÎ±Î¹ ÎµÎ¯Î½Î±Î¹ ÏƒÎ±Î½ ÏƒÏ‰Î»Î®Î½Î±Ï‚. \r\nÎ‘Î½ Ï€Ï�Î¿ÏƒÎ­Î¾ÎµÎ¹Ï‚ \r\nâ—� Î±Î»Î»Î±Î³Î­Ï‚ ÏƒÏ„Î¿ Î²Î¬Ï�Î¿Ï‚ Î® ÏƒÏ„Î¿ Î¼Î­Î³ÎµÎ¸Î¿Ï‚ Ï„Î¿Ï… ÏŒÏ�Ï‡Î¹ \r\nâ—� Î´Î¹ÏŒÎ³ÎºÏ‰ÏƒÎ· Î® Ï€Ï�Î¯Î¾Î¹Î¼Î¿ \r\nâ—� ÏƒÎºÎ»Î®Ï�Ï…Î½ÏƒÎ· Î® Î¼Î¹ÎºÏ�ÏŒ ÏŒÎ³ÎºÎ¿ \r\nâ—� Ï€ÏŒÎ½Î¿ \r\nÎ–Î®Ï„Î± Î±Î¼Î­ÏƒÏ‰Ï‚ Î¹Î±Ï„Ï�Î¹ÎºÎ® ÏƒÏ…Î¼Î²Î¿Ï…Î»Î® Î±Ï€ÏŒ Î¿Ï…Ï�Î¿Î»ÏŒÎ³Î¿ Ï‡Ï‰Ï�Î¯Ï‚ Î±Î½Î±ÏƒÏ„Î¿Î»Î­Ï‚ Î® ÎºÎ±Î¸Ï…ÏƒÏ„Î­Ï�Î·ÏƒÎ·",0,2,"15-35",3,"0-100",2,2,"autoeksetasi_orxewn",0);

		String[]relatedExamsCancerProstatis={"EÎ¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½"};
		//ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î Ï�Î¿ÏƒÏ„Î¬Ï„Î·*
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î Ï�Î¿ÏƒÏ„Î¬Ï„Î·","Î•Î½Ï„Î¿Ï€Î¯Î¶ÎµÏ„Î±Î¹ ÏƒÎµ Î½ÎµÎ±Ï�Î­Ï‚ Î·Î»Î¹ÎºÎ¯ÎµÏ‚ ÎºÎ±Î¹ Î¸ÎµÏ�Î±Ï€ÎµÏ�ÎµÏ„Î±Î¹ ÎµÏ�ÎºÎ¿Î»Î± ÎºÎ±Î¹ Î³Î¹Î± Ï€Î¬Î½Ï„Î± ÏŒÏ„Î±Î½ ÎµÎ½Ï„Î¿Ï€Î¯Î¶ÎµÏ„Î±Î¹ Î­Î³ÎºÎ±Î¹Ï�Î±. \r\nÎ— Î¼Î·Î½Î¹Î±Î¯Î± Î±Ï…Ï„Î¿ÎµÎ¾Î­Ï„Î±ÏƒÎ· Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± ÏƒÎ±Ï‚ ÏƒÏŽÏƒÎµÎ¹. \r\nÎ— ÎºÏ�Ï…ÏˆÎ¿Ï�Ï‡Î¯Î± ÎºÎ±Î¹ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î¹ÎºÏŒÏ„Î·Ï„Î± Î±Ï€Î¿Ï„ÎµÎ»Î¿Ï�Î½ Ï€Î¹Î¸Î±Î½Î¿Ï�Ï‚ Ï€Î±Ï�Î¬Î³Î¿Î½Ï„ÎµÏ‚ ÎºÎ¹Î½Î´Ï�Î½Î¿Ï…",relatedExamsCancerProstatis,relatedExamsPreventions,"cancer_prostatis");
		
		String[]relatedExamsCancerEnterou={"EÎ¼Î²Î¿Î»Î¹Î±ÏƒÎ¼ÏŒÏ‚ Î³Î¹Î± Ï„Î¿Î½ Î¹ÏŒ Î±Î½Î¸Ï�Ï‰Ï€Î¯Î½Ï‰Î½ Î¸Î·Î»Ï‰Î¼Î¬Ï„Ï‰Î½","ÎšÎ»Î¿Î½Î¿ÏƒÎ»ÏŒÏ€Î·ÏƒÎ·","Î£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Ï„ÎµÎ¯Ï„Îµ Î­Î½Î± Î³Î±ÏƒÏ„Ï�ÎµÎ½Ï„ÎµÏ�Î¿Î»ÏŒÎ³Î¿","ÎšÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· Î® Î±Î½Î¬Î»Ï…ÏƒÎ· ÎºÎ¿Ï€Ï�Î¬Î½Ï‰Î½"};
		
		//ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î Î±Ï‡Î­Î¿Ï‚ Î•Î½Ï„Î­Ï�Î¿Ï…
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î Î±Ï‡Î­Î¿Ï‚ Î•Î½Ï„Î­Ï�Î¿Ï…","ÎŸ Î´ÎµÏ�Ï„ÎµÏ�Î¿Ï‚ ÏƒÎµ ÏƒÏ…Ï‡Î½ÏŒÏ„Î·Ï„Î± ÎºÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ ÏƒÎµ Î¬Î½Î´Ï�ÎµÏ‚ ÎºÎ±Î¹ Î³Ï…Î½Î±Î¯ÎºÎµÏ‚. \r\nÎœÏ€Î¿Ï�ÎµÎ¯ Î½Î± Ï€Ï�Î¿Î»Î·Ï†Î¸ÎµÎ¯ Î¼Îµ Î¹ÏƒÎ¿Ï�Ï�Î¿Ï€Î·Î¼Î­Î½Î· Î´Î¹Î±Ï„Ï�Î¿Ï†Î® ÎºÎ±Î¹ Ï…Î³Î¹ÎµÎ¹Î½ÏŒ Ï„Ï�ÏŒÏ€Î¿ Î¶Ï‰Î®Ï‚ Ï€Î¿Ï… Ï€ÎµÏ�Î¹Î»Î±Î¼Î²Î¬Î½ÎµÎ¹ ÎºÎ±Î¸Î·Î¼ÎµÏ�Î¹Î½Î® Î¬ÏƒÎºÎ·ÏƒÎ· Ï„Î¿Ï…Î»Î¬Ï‡Î¹ÏƒÏ„Î¿Î½ 1 ÏŽÏ�Î± 5 Ï†Î¿Ï�Î­Ï‚ Ï„Î·Î½ ÎµÎ²Î´Î¿Î¼Î¬Î´Î±, ÎºÎ±Ï„Î±Î½Î¬Î»Ï‰ÏƒÎ· Î±Î»ÎºÎ¿ÏŒÎ» Î¼Îµ Ï„Î¿ Î¼Î­Ï„Ï�Î¿, Ï‡Ï‰Ï�Î¯Ï‚ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î±. \r\nÎœÏ€Î¿Ï�ÎµÎ¯ Î½Î± Î¸ÎµÏ�Î±Ï€ÎµÏ…Î¸ÎµÎ¯ ÏŒÏ„Î±Î½ ÎµÎ½Ï„Î¿Ï€Î¹ÏƒÎ¸ÎµÎ¯ Î­Î³ÎºÎ±Î¹Ï�Î±",relatedExamsCancerEnterou,relatedExamsPreventions,"cancer_paxeous_enterou");
		
		//ÎºÎ»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· ÏŒÏ„Î±Î½ Ï…Ï€Î¬Ï�Ï‡ÎµÎ¹ Î¿Î¹ÎºÎ¿Î³ÎµÎ½ÎµÎ¹ÎºÏŒ Î¹ÏƒÏ„Î¿Ï�Î¹ÎºÏŒ 
		
		addExamination(db,"ÎšÎ»Î¿Î½Î¿ÏƒÎ»ÏŒÏ€Î·ÏƒÎ·","Î‘Î½ Î­Ï‡ÎµÏ„Îµ ÏƒÏ…Î³Î³ÎµÎ½Î® 1Î¿Ï… Î²Î±Î¸Î¼Î¿Ï� Î¼Îµ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Ï€Î±Ï‡Î­Î¿Ï‚ ÎµÎ½Ï„Î­Ï�Î¿Ï… Î¸Î± Ï€Ï�Î­Ï€ÎµÎ¹ Î½Î± ÎµÎ¾ÎµÏ„Î±ÏƒÏ„ÎµÎ¯Ï„Îµ, ÎºÎ¬Î½Î¿Î½Ï„Î±Ï‚ ÎºÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ·, 10-15 Ï‡Ï�ÏŒÎ½Î¹Î± Ï€Ï�Î¹Î½ Ï„Î·Î½ Î·Î»Î¹ÎºÎ¯Î± Ï€Î¿Ï… ÎµÎ¯Ï‡Îµ Î´Î¹Î±Î³Î½Ï‰ÏƒÎ¸ÎµÎ¯",0,2,"25-50",3,"0-100",1,2,"-",2);
		addExamination(db,"Î£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Ï„ÎµÎ¯Ï„Îµ Î­Î½Î± Î³Î±ÏƒÏ„Ï�ÎµÎ½Ï„ÎµÏ�Î¿Î»ÏŒÎ³Î¿","Î‘Î½ Î­Ï‡ÎµÏ„Îµ ÏƒÏ…Î¼Ï€Ï„ÏŽÎ¼Î±Ï„Î± Ï€Î¿Ï… Ï€Ï�Ï‰Ï„Î¿ÎµÎ¼Ï†Î±Î½Î¯Î¶Î¿Î½Ï„Î±Î¹, Î±Î»Î»Î±Î³Î­Ï‚ ÏƒÏ„Î¹Ï‚ ÎµÎ½Ï„ÎµÏ�Î¹ÎºÎ­Ï‚ ÏƒÎ±Ï‚ ÏƒÏ…Î½Î®Î¸ÎµÎ¹ÎµÏ‚  ÎºÎ±Î¹ Î´Î¹Î±Ï�ÎºÎ¿Ï�Î½ 3-4 ÎµÎ²Î´Î¿Î¼Î¬Î´ÎµÏ‚ Î® Î­Ï‡ÎµÏ„Îµ Ï„Î¿ Î±ÎºÏŒÎ»Î¿Ï…Î¸Î¿ Î¹ÏƒÏ„Î¿Ï�Î¹ÎºÏŒ ÏƒÏ…Î¼Î²Î¿Ï…Î»ÎµÏ…Ï„ÎµÎ¯Ï„Îµ Î­Î½Î± Î³Î±ÏƒÏ„Ï�ÎµÎ½Ï„ÎµÏ�Î¿Î»ÏŒÎ³Î¿. \r\nÎ‘Î¹Î¼Î¿Ï�Ï�Î±Î³Î¯Î± Î±Ï€ÏŒ Ï„Î¿Î½ Ï€Ï�Ï‰ÎºÏ„ÏŒ \r\nÎ‘Î½Î±Î¹Î¼Î¯Î± ÎºÎ±Î¹ Î±Î¯ÏƒÎ¸Î·ÏƒÎ· ÎºÎ¿Ï�Ï�Î±ÏƒÎ·Ï‚ \r\nÎ ÏŒÎ½Î¿Ï‚ Î® ÏƒÏ…Î½ÎµÏ‡Î¹Î¶ÏŒÎ¼ÎµÎ½Î· Î´Ï…ÏƒÏ†Î¿Ï�Î¯Î± \r\nÎ•Î»ÎºÏŽÎ´Î· ÎºÎ¿Î»Î¯Ï„Î¹Î´Î±",0,2,"35-55",3,"0-100",2,2,"-",2);
	
		addExamination(db,"ÎšÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· Î® Î±Î½Î¬Î»Ï…ÏƒÎ· ÎºÎ¿Ï€Ï�Î¬Î½Ï‰Î½","Î•Î¯Ï„Îµ Î­Ï‡ÎµÏ„Îµ ÏƒÏ…Î¼Ï€Ï„ÏŽÎ¼Î±Ï„Î± ÎµÎ¯Ï„Îµ ÏŒÏ‡Î¹ Ï…Ï€Î¿Î²Î»Î·Î¸ÎµÎ¯Ï„Îµ ÏƒÎµ Î¼Î¯Î± ÎºÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· Î® Î±Î½Î¬Î»Ï…ÏƒÎ· ÎºÎ¿Ï€Ï�Î¬Î½Ï‰Î½.\r\nÎ•Î¾ÎµÏ„Î¬ÏƒÎµÎ¹Ï‚ Ï€Î¿Ï… Î¼Ï€Î¿Ï�ÎµÎ¯ Î½Î± ÎºÎ¬Î½ÎµÎ¹ Î¿ Î³Î¹Î±Ï„Ï�ÏŒÏ‚: \r\nÎ”Î±ÎºÏ„Ï…Î»Î¹ÎºÎ® ÎµÎ¾Î­Ï„Î±ÏƒÎ· ÏƒÏ„Î¿ Î­Î½Ï„ÎµÏ�Î¿ \r\nÎ•Î¾Î­Ï„Î±ÏƒÎ· Î±Î¯Î¼Î±Ï„Î¿Ï‚ Î³Î¹Î± Î±Î½Î±Î¹Î¼Î¯Î± \r\nÎ†ÎºÎ±Î¼Ï€Ï„Î·/Î•Ï�ÎºÎ±Î¼Ï€Ï„Î· Î£Î¹Î³Î¼Î¿ÎµÎ¹Î´Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· \r\nÎšÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· \r\n Î‘Î¾Î¿Î½Î¹ÎºÎ® Ï„Î¿Î¼Î¿Î³Ï�Î±Ï†Î¯Î±-ÎµÎ½Ï„ÎµÏ�Î¿Î³Ï�Î±Ï†Î¯Î± \r\nÎ“Î¹Î± Î³Ï…Î½Î±Î¯ÎºÎµÏ‚ ÎºÎ±Î¹ Î¬Î½Î´Ï�ÎµÏ‚ Î·Î»Î¹ÎºÎ¯Î±Ï‚ 50-69 ÎµÏ„ÏŽÎ½ Î³Î¯Î½Î¿Î½Ï„Î±Î¹ Î±Î½Î±Î»Ï�ÏƒÎµÎ¹Ï‚ ÎºÎ¿Ï€Ï�Î¬Î½Ï‰Î½ Î´Ï‰Ï�ÎµÎ¬Î½, ÏƒÏ„Î± Ï€Î»Î±Î¯ÏƒÎ¹Î± Ï„Î¿Ï… Ï€Ï�Î¿Î³Ï�Î¬Î¼Î¼Î±Ï„Î¿Ï‚ Ï€Î»Î·Î¸Ï…ÏƒÎ¼Î¹Î±ÎºÎ¿Ï� ÎµÎ»Î­Î³Ï‡Î¿Ï… Ï„Î¿Ï… Î¥Ï€Î¿Ï…Ï�Î³ÎµÎ¯Î¿Ï… Î¥Î³ÎµÎ¯Î±Ï‚, ÏƒÎµ ÎºÎ¿Î¹Î½ÏŒÏ„Î·Ï„ÎµÏ‚ Ï„Î·Ï‚ Î•Ï€Î±Ï�Ï‡Î¯Î±Ï‚ Î›Î¬Ï�Î½Î±ÎºÎ±Ï‚. Î•Î¬Î½ Î· Î±Î½Î¬Î»Ï…ÏƒÎ· ÎµÎ¯Î½Î±Î¹ Î¸ÎµÏ„Î¹ÎºÎ® Î±ÎºÎ¿Î»Î¿Ï…Î¸ÎµÎ¯ Ï€Î±Ï�Î±Ï€Î¿Î¼Ï€Î® Î³Î¹Î± ÎºÎ¿Î»Î¿Î½Î¿ÏƒÎºÏŒÏ€Î·ÏƒÎ· Î³Î¹Î± Ï€ÎµÏ�Î±Î¹Ï„Î­Ï�Ï‰ Î´Î¹ÎµÏ�ÎµÏ�Î½Î·ÏƒÎ·. Î— Ï€Ï�ÏŒÏƒÎºÎ»Î·ÏƒÎ· Î±Ï€Î¿ÏƒÏ„Î­Î»Î»ÎµÏ„Î±Î¹ Ï„Î±Ï‡Ï…Î´Ï�Î¿Î¼Î¹ÎºÏŽÏ‚. Î‘Î½ Î´ÎµÎ½ Î­Ï‡ÎµÏ„Îµ Î±Î½Ï„Î±Ï€Î¿ÎºÏ�Î¹Î¸ÎµÎ¯ Î±ÎºÏŒÎ¼Î± Î´Ï�Î¬ÏƒÏ„Îµ.",0,2,"50-65",3,"0-100",2,2,"-",2);

		String[]relatedExamsCancerOurodoxos={};
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î·Ï‚ ÎŸÏ…Ï�Î¿Î´ÏŒÏ‡Î¿Ï… ÎšÏ�ÏƒÏ„Î·Ï‚","Î“Î½Ï‰Ï�Î¯ÏƒÏ„Îµ Ï„Î¿ ÏƒÏŽÎ¼Î± ÏƒÎ±Ï‚ ÎºÎ±Î¹ Ï„Î¿ Î¹ÏƒÏ„Î¿Ï�Î¹ÎºÏŒ Ï„Î·Ï‚ Î¿Î¹ÎºÎ¿Î³Î­Î½ÎµÎ¹Î¬Ï‚ ÏƒÎ±Ï‚",relatedExamsCancerOurodoxos,relatedExamsPreventions,"-");
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î Î½ÎµÏ�Î¼Î¿Î½Î± â€“ Î”Î­Î½ Ï…Ï€Î¬Ï�Ï‡Î¿Ï…Î½ Î¼Î­Î¸Î¿Î´Î¿Î¹ Î­Î³ÎºÎ±Î¹Ï�Î·Ï‚ Î´Î¹Î¬Î³Î½Ï‰ÏƒÎ·Ï‚ ÏƒÎµ Î¬Ï„Î¿Î¼Î± Ï‡Ï‰Ï�Î¯Ï‚ ÏƒÏ…Î¼Ï€Ï„ÏŽÎ¼Î±Ï„Î±","-	Î Î±Ï�Î¬Î³Î¿Î½Ï„ÎµÏ‚ ÎºÎ¹Î½Î´Ï�Î½Î¿Ï…: \r\nÎ•Î½ÎµÏ�Î³Î·Ï„Î¹ÎºÏŒ ÎºÎ±Î¹ Ï€Î±Î¸Î·Ï„Î¹ÎºÏŒ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î±	\r\nÎˆÎºÎ¸ÎµÏƒÎ· ÏƒÎµ Ï€ÎµÏ�Î¹Î²Î±Î»Î»Î¿Î½Ï„Î¹ÎºÎ¿Ï�Ï‚ Ï�Ï�Ï€Î¿Ï…Ï‚ ÏŒÏ€Ï‰Ï‚ Î¿ Î±Î¼Î¯Î±Î½Ï„Î¿Ï‚	\r\nÎ”Î¹Î±ÎºÏŒÏˆÏ„Îµ Ï„Î¿ ÎºÎ¬Ï€Î½Î¹ÏƒÎ¼Î±	\r\nÎ›Î¬Î²ÎµÏ„Îµ Ï€Ï�Î¿ÏƒÏ„Î±Ï„ÎµÏ…Ï„Î¹ÎºÎ¬ Î¼Î­Ï„Ï�Î± ÎºÎ±Î¹ ÏƒÏ…Î¼Î¼Î¿Ï�Ï†Ï‰Î¸ÎµÎ¯Ï„Îµ ÏƒÎµ ÎºÎ±Î½Î¿Î½Î¹ÏƒÎ¼Î¿Ï�Ï‚ Î±ÏƒÏ†Î¬Î»ÎµÎ¹Î±Ï‚ ÏƒÏ„Î¿ Ï‡ÏŽÏ�Î¿ ÎµÏ�Î³Î±ÏƒÎ¯Î±Ï‚ \r\nÎ‘Î½ Î­Ï‡ÎµÏ„Îµ Ï€Î±Ï�ÎµÏ„ÎµÏ„Î±Î¼Î­Î½Î¿, ÎµÎ½Î¿Ï‡Î»Î®Ï„Î¹ÎºÏŒ Î²Î®Ï‡Î±, Î±Î¹Î¼ÏŒÏ€Ï„Ï…ÏƒÎ·, Ï€Î½ÎµÏ…Î¼Î¿Î½Î¯Î± Ï€Î¿Ï… Î´ÎµÎ½ Ï€ÎµÏ�Î½Î¬ÎµÎ¹ ÎµÏ€Î¹ÏƒÎºÎµÏ…Ï„ÎµÎ¯Ï„Îµ Ï„Î¿ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚ \r\nÎ”Î¹Î±Î³Î½Ï‰ÏƒÏ„Î¹ÎºÎ­Ï‚ ÎµÎ¾ÎµÏ„Î¬ÏƒÎµÎ¹Ï‚ ÎµÎ¯Î½Î±Î¹ Ï„Î¿ ÏƒÏ€Î¹Ï�Î¿Î³Ï�Î¬Ï†Î·Î¼Î± ÎºÎ±Î¹ Î±ÎºÏ„Î¹Î½Î¿Î³Ï�Î±Ï†Î¯Î± ",relatedExamsCancerOurodoxos,relatedExamsPreventions,"-");
	
		
		addCancer(db,"ÎšÎ±Ï�ÎºÎ¯Î½Î¿Ï‚ Ï„Î¿Ï… Î”Î­Ï�Î¼Î±Ï„Î¿Ï‚, ÎœÎµÎ»Î¬Î½Ï‰Î¼Î±","Î•Ï€Î±Î½Î±Î»Î±Î¼Î²Î±Î½ÏŒÎ¼ÎµÎ½Î± ÎµÎ³ÎºÎ±Ï�Î¼Î±Ï„Î± Î»ÏŒÎ³Ï‰ Î·Î»Î¹Î¿Î¸ÎµÏ�Î±Ï€ÎµÎ¯Î±Ï‚ /Ï…Ï€ÎµÏ�Î²Î¿Î»Î¹ÎºÎ®Ï‚ Î­ÎºÎ¸ÎµÏƒÎ·Ï‚ ÏƒÏ„Î¿Î½ Î®Î»Î¹Î¿ Î±Ï€Î¿Ï„ÎµÎ»Î¿Ï�Î½ Ï„Î¿Î½ 1Î¿ Ï€Î±Ï�Î¬Î³Î¿Î½Ï„Î± ÎºÎ¹Î½Î´Ï�Î½Î¿Ï… Î³Î¹Î± Ï„Î¿Î½ ÎºÎ±Ï�ÎºÎ¯Î½Î¿ Ï„Î¿Ï… Î´Î­Ï�Î¼Î±Ï„Î¿Ï‚ ÎºÎ±Î¹ Ï„Î¿ Î¼ÎµÎ»Î¬Î½Ï‰Î¼Î± \r\nÎ†Ï„Î¿Î¼Î± ÏˆÎ·Î»Î¿Ï� ÎºÎ¹Î½Î´Ï�Î½Î¿Ï… ÎµÎ¯Î½Î±Î¹ ÏŒÏƒÎ¿Î¹ Î­Ï‡Î¿Ï…Î½ Î® ÎµÎ¯Ï‡Î±Î½ \r\nâ€¢	ÎŸÎ¹ÎºÎ¿Î³ÎµÎ½ÎµÎ¹Î±ÎºÏŒ Î¹ÏƒÏ„Î¿Ï�Î¹ÎºÏŒ Î¼ÎµÎ»Î±Î½ÏŽÎ¼Î±Ï„Î¿Ï‚ \r\nâ€¢	ÎœÎµÎ³Î¬Î»Î¿ Î±Ï�Î¹Î¸Î¼ÏŒ ÏƒÏ€Î¯Î»Ï‰Î½ Î® Î±ÏƒÏ…Î½Î®Î¸Î¹ÏƒÏ„Î¿Ï…Ï‚ ÏƒÏ€Î¯Î»Î¿Ï…Ï‚ Ï€Î¿Ï… Î±Î»Î»Î¬Î¶Î¿Ï…Î½ \r\nâ€¢	Î‘Î½Î¿Î¹Ï‡Ï„ÏŒÏ‡Ï�Ï‰Î¼Î¿ Î´Î­Ï�Î¼Î± ÎºÎ±Î¹ Î¼Î¬Ï„Î¹Î± Î³Î±Î»Î±Î½Î¬ \r\nâ€¢	Î•Ï�Î³Î¬Î¶Î¿Î½Ï„Î±Î¹ Î® Î´Ï�Î±ÏƒÏ„Î·Ï�Î¹Î¿Ï€Î¿Î¹Î¿Ï�Î½Ï„Î±Î¹ ÏƒÏ„Î¿ Ï�Ï€Î±Î¹Î¸Ï�Î¿ Î±ÎºÎ¬Î»Ï…Ï€Ï„Î¿Î¹ \r\nâ€¢	Î•Î³ÎºÎ±Ï�Î¼Î±Ï„Î± ÏƒÏ„Î·Î½ Ï€Î±Î¹Î´Î¹ÎºÎ® Î·Î»Î¹ÎºÎ¯Î± \r\nÎ‘Î½ Ï€Ï�Î¿ÏƒÎ­Î¾ÎµÏ„Îµ \r\nÎ‘Î»Î»Î±Î³Î® ÏƒÏ„Î¿ Î¼Î­Î³ÎµÎ¸Î¿Ï‚ Î® Ï‡Ï�ÏŽÎ¼Î± ÎµÎ½ÏŒÏ‚ ÏƒÏ€Î¯Î»Î¿Ï… (ÎµÎ»Î¹Î¬Ï‚) \r\nÎ ÏŒÎ½Î¿ Î® Î±Î¹Î¼Î¿Ï�Ï�Î±Î³Î¯Î± Î±Ï€ÏŒ Î­Î½Î± ÏƒÏ€Î¯Î»Î¿ \r\nÎœÎ¹Î± Ï€Î»Î·Î³Î® Ï€Î¿Ï… Î´ÎµÎ½ ÎµÏ€Î¿Ï…Î»ÏŽÎ½ÎµÎ¹  \r\nÎ£Ï…Î¼Î²Î¿Ï…Î»ÎµÏ…Ï„ÎµÎ¯Ï„Îµ Ï„Î¿ Î³Î¹Î±Ï„Ï�ÏŒ ÏƒÎ±Ï‚",relatedExamsCancerOurodoxos,relatedExamsPreventions,"-");

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
					addCancerRelatedExams(db, name, new String[]{i});
					Log.d("SCC - addCancer", "Added related exam: " + i);
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
					addPrevention(db,i,null,null);
					addCancerRelatedPreventions(db, name, new String[]{i});
					Log.d("SCC - addCancer", "Added related prevention: "
							+ i);
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
		addExamination(db, name, null, 0, 0, null, 0, null, 0, 0, "-",0);
	}

	public void addExamination(SQLiteDatabase db, String name,
			String description, int frequency, int sex, String agerange,
			int smoker, String dms, int familyHistory, int alcohol, String img, int gender) {
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
		values.put("examination_gender", gender);

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
				"SELECT ID_cancer, cancer_name,cancer_description,image_name FROM CANCER WHERE ID_Cancer="
						+ cID + ";");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			cancers.add(new Cancer(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
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
			exams.add(new Exam(eID,c.getString(1), c.getString(5), c.getInt(7), c
					.getInt(9), c.getString(6), c.getInt(11), c.getInt(8), c
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
					.getString(2),c.getString(3)));
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
				exams.add(new Exam(c.getInt(0),c.getString(1), c.getString(5), c.getInt(7),
						c.getInt(9), c.getString(6), c.getInt(11), c.getInt(8),
						c.getInt(4), c.getString(2), c.getString(10), c
								.getInt(3)));
			} while (c.moveToNext());
			return exams;
		} else {
			db.close();
			return null;
		}

	}

}