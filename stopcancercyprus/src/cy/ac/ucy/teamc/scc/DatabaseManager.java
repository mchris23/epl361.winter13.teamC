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

	private DatabaseManager(Context context) {
		super(context, "SCC", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create query strings
		String createExamTable = new String(
				"CREATE TABLE EXAMINATION(ID_Examination INTEGER PRIMARY KEY AUTOINCREMENT,examination_name TEXT,examination_description TEXT,examination_frequency INTEGER,examination_sex INTEGER,examination_agerange TEXT,examination_dms TEXT,examination_smoker INTEGER,examination_family_history INTEGER,examination_alcohol INTEGER, image_name TEXT, examination_gender INTEGER, examination_type INTEGER)");
		String createCancerTable = new String(
				"CREATE TABLE CANCER(ID_cancer INTEGER PRIMARY KEY AUTOINCREMENT,cancer_name TEXT,cancer_description TEXT,image_name TEXT)");
		//String createPreventionTable = new String(
				//"CREATE TABLE PREVENTION(ID_prevention INTEGER PRIMARY KEY AUTOINCREMENT,prevention_name TEXT,prevention_description TEXT,image_name TEXT)");
		//String createExamCancerTable = new String(
			//	"CREATE TABLE EXAMINATION_CANCER(ID_Examination INTEGER,ID_cancer INTEGER)");
		//String createCancerPreventionTable = new String(
		//		"CREATE TABLE CANCER_PREVENTION(ID_cancer INTEGER,ID_prevention INTEGER)");

		// execute creation queries
		db.execSQL(createExamTable);
		Log.d("SCC - DBCreate", "Created table EXAMINATION");
		db.execSQL(createCancerTable);
		Log.d("SCC - DBCreate", "Created table CANCER");
		//db.execSQL(createPreventionTable);
		//Log.d("SCC - DBCreate", "Created table PREVENTION");
		//db.execSQL(createExamCancerTable);
		//Log.d("SCC - DBCreate", "Created table EXAMINATION_CANCER");
		//db.execSQL(createCancerPreventionTable);
		//Log.d("SCC - DBCreate", "Created table CANCER_PREVENTION");

		// initialise table data
		addData(db);

	}

	public void addData(SQLiteDatabase db) {
		// since data is going to be static for now, enter here
		
		//Αυτοεξέταση μαστού
		addExamination(db,  "Αυτοεξέταση μαστού","Γυναίκες άνω των 30 μπορούν να κάνουν την αυτοεξέταση μια φορά τον μήνα", 1, 0, "30-120", 3, "0-100", 2, 2, "-", 1,1);
		
		
		
		// Εμβόλιο για τον ιο ανθρώπινων θηλωμάτων
		addExamination(db,  "Eμβόλιο για τον ιό των ανθρωπίνων θηλωμάτων","Eνημερωθείτε για το εμβόλιο και εμβολιαστείτε το συντομότερο.  ", 0, 0, "18-25", 3, "0-100", 2, 2, "-", 1,0);
		
		
		//Καρκίνος του Τραχήλου της Μήτρας 
		addCancer(db, "Καρκίνος του Τραχήλου της Μήτρας ", "Επηρεάζει τον τράχηλο που συνδέει τη μήτρα με τον κόλπο (δες εικ.) \r\nΔεν είναι κληρονομικός. \r\nΜπορεί να προκληθεί από τον ιό των ανθρωπίνων θηλωμάτων (HPV-Human Papilloma Virus) ο οποίος μεταδίδεται με τη σεξουαλική επαφή. \r\nΟι συστάσεις είναι όπως οι έφηβοι 11 ετών και πάνω, αγόρια κορίτσια, εμβολιαστούν για αποτελεσματική πρόληψη.","-");
			
		
		
		//Γνωρίστε το σώμα σας Προστατέψετε τον εαυτό σας για όλους τους άντρες prevention
		addExamination(db,"Γνωρίστε το σώμα σας Προστατέψετε τον εαυτό σας ","Αν είστε καπνιστής/καπνίστρια ενταχθείτε σε Ομάδα Διακοπής του Καπνίσματος και αποδεσμευθείτε από τον 1ο παράγοντα κινδύνου για όλους τους καρκίνους και τον οποίο μπορείτε να ελέγξετε. \r\nΑν μεταφέρετε παιδιά στο αυτοκίνητο ή έχετε παιδιά στο σπίτι μην καπνίζετε στους χώρους αυτούς.Αν δεν καπνίζετε μην ξεκινήσετε ποτέ. Είστε ήδη ελεύθερος/ελεύθερη! \r\nΑν καπνίζουν άλλοι στο χώρο σας διεκδικήστε το δικαίωμά σας για χώρους ελεύθερους από τον καπνό του τσιγάρου. \r\nΤο παθητικό και το τριτογενές κάπνισμα είναι βλαπτικά και επικίνδυνα ιδιαίτερα για παιδιά.",0, 1, "0-120", 3, "0-100", 2, 2, "-", 2,0);
		

		
		
		// Τεστ Παπανικολάου για γυναίκες 18-45 με σεξουαλική επαφή
		addExamination(db, "ΤΕΣΤ ΠΑΠΑΝΙΚΟΛΑΟΥ", "Το Τεστ Παπανικολάου (υγρής κυτταρολογίας) μπορεί να χρησιμοποιηθεί για να διαγνώσει έγκαιρα τον καρκίνο του τραχήλου της μήτρας. Είναι καλό να γίνεται κάθε 1-2 χρόνια, 2 χρόνια μετά την πρώτη σεξουαλική επαφή.", 16, 1, "18-45", 3, "0-100", 2, 2, "-", 1,1);
		
		// Τεστ Παπανικολάου για γυναίκες 45+ με σεξουαλική επαφή
		addExamination(db, "ΤΕΣΤ ΠΑΠΑΝΙΚΟΛΑΟΥ και υπερηχογράφημα", "Το Τεστ Παπανικολάου (υγρής κυτταρολογίας) μπορεί να χρησιμοποιηθεί για να διαγνώσει έγκαιρα τον καρκίνο του τραχήλου της μήτρας. Είναι καλό να γίνεται κάθε 1-2 χρόνια, 2 χρόνια μετά την πρώτη σεξουαλική επαφή. \r\nΑν δεν έχετε ξανακάνει Τεστ Παπανικολάου, μην το αμελήσετε άλλο. Κάντε το τεστ και ένα υπερηχογράφημα στο γυναικολόγο σας. \r\nΑν κληθήτε για εξέταση στα πλαίσια πληθυσμιακού προγράμματος, ανταποκριθείτε άμεσα.", 16, 1, "45-120", 3, "0-100", 2, 2, "-", 1,1);
		
		
		
		//20 ετών μέχρι τα 39 κάνετε κλινική εξέταση για διάγνωση του Καρκίνου του Μαστού
		addExamination(db, "Κλινική εξέταση για διάγνωση του Καρκίνου του Μαστού","", 16, 1, "45-120", 3, "0-100", 2, 2, "-", 1,1);
		
		
		//Καρκίνος του Μαστού
		addCancer(db, "Καρκίνος του Μαστού", "Είναι θεραπεύσιμος όταν γίνεται έγκαιρα η διάγνωση. Περιορίστε την κατανάλωση ζωϊκού λίπους και κρεατικών. Εμπλουτίστε το διαιτολόγιο με φρούτα και λαχανικά (τουλάχιστον 5 μερίδες την ημέρα) και ψαρικά. Πίνετε άφθονο νερό και αποφεύγετε αναψυκτικά και αλκοόλ. Μην καπνίζετε. Κάποιες γυναίκες θεωρούνται άτομα ψηλού κινδύνου λόγω γονιδίων και κληρονομικότητας.","-");
		//Συμβουλευθείτε τον γιατρό σας
		addExamination(db, "Συμβουλευθείτε τον γιατρό σας","Αν έχετε συγγενείς από το στενό οικογενειακό περιβάλλον με καρκίνο του μαστού, ή και παράλληλα με καρκίνο των ωοθηκών ή με καρκίνο του παχέος εντέρου συμβουλευθείτε το γιατρό σας",0,2,"18-25",3,"0-100",1,2,"-",1,1);
		
		//Μαστογραφία και υπερηχογράφημα (ultra sound)"
		addExamination(db,"Μαστογραφία και υπερηχογράφημα (ultra sound) με οικογενειακό ιστορικό","Γνωρίζοντας το ιστορικό της οικογένειάς σας, αν κάποιος στενός συγγενής έχει διαγνωσθεί με κάποιο είδος καρκίνου σε ηλικία κάτω των 40 ετών, ή αν έχει καρκίνο και στους δυο μαστούς, μιλήστε με το γιατρό σας. \r\n Μετά τα 35 ξεκινήστε να κάνετε μαστογραφία κάθε χρόνο Είτε έχετε συμπτώματα είτε όχι η οποία είναι καλά να συνοδεύεται με υπερηχογράφημα (ultra sound).",0,2,"22-65",3,"0-100",2,2,"-",1,1);

		//Μαστογραφία	40-75 
		addExamination(db,"Μαστογραφία","Έχετε ενοχλήσεις ή συμπτώματα όπως: Στο μαστό: \r\n ●αλλαγή στο μέγεθος ή σχήμα \r\n●ρυτιδώδης υφή δέρματος \r\n●σκληρότητα  \r\nΣτη θηλή: \r\n●κοίλανση \r\n●εξόγκωση ή σκλήρυνση \r\n●εκκρίσεις \r\n●ερεθισμός.  \r\nΣτον ώμο: \r\n●πρήξιμο στη μασχάλη, \r\nδιόγκωση λεμφαδένων.  \r\nΓια γυναίκες ηλικίας 50-69 ετών γίνονται μαστογραφίες δωρεάν, στα πλαίσια του προγράμματος πληθυσμιακού ελέγχου του Υπουργείου Υγείας. Η μαστογραφία επαναλαμβάνεται κάθε 2 χρόνια. Η πρόσκληση αποστέλλεται ταχυδρομικώς. Αν δεν έχετε ανταποκριθεί ακόμα δράστε τώρα και αν δεν σας έχει αποσταλεί πρόσκληση επικοινωνήστε με το Υπουργείο Υγείας. \r\nΠροσοχή – Η μαστογραφία μπορεί να εντοπίσει ογκίδιο πριν να το εντοπίσετε εσείς ή ο γιατρός σας \r\n	Κέντρα Μαστογραφίας - Ώρες Λειτουργίας 7:30π.μ.-2:30μ.μ. :\r\n •  Κέντρο Υγείας Αγλαντζιάς - Τηλ: 22444460 \r\n•  Παλαιό Νοσοκομείο Λεμεσού – Τηλ: 25305124 \r\n•  Γενικό Νοσοκομείο Λάρνακας – Τηλ: 24625124 \r\n•  Γενικό Νοσοκομείο Πάφου - Τηλ: 26803225, Ώρες Λειτουργίας 3:30μ.μ.-5:20μ.μ. (Δευτέρα – Παρασκευή) και 9:00π.μ.-1:00μ.μ. (Σάββατο) \r\n•  Γενικό Νοσοκομείο Αμμοχώστου - Τηλ: 23200166",0,2,"40-120",3,"0-100",2,2,"-",1,1);
		
		
		//Εμβολιασμός για τον ιό ανθρωπίνων θηλωμάτων"
		addExamination(db, "Eμβολιασμός για τον ιό ανθρωπίνων θηλωμάτων","Αν δεν έχετε ήδη εμβολιαστεί για τον ιό ανθρωπίνων θηλωμάτων μπορείτε εμβολιαστείτε και για δική σας προστασία.  ",0,2,"18-25",3,"0-100",1,2,"",2,0);
			
		
		//Καρκίνος των όρχεων *
		addCancer(db,"Καρκίνος των όρχεων","Εντοπίζεται σε νεαρές ηλικίες και θεραπεύεται εύκολα και για πάντα όταν εντοπίζεται έγκαιρα. \r\nΗ μηνιαία αυτοεξέταση μπορεί να σας σώσει. \r\nΗ κρυψορχία και κληρονομικότητα αποτελούν πιθανούς παράγοντες κινδύνου","autoeksetasi_orxewn");
		
		//Αυτοεξέταση των όρχεων
		addExamination(db,"Αυτοεξέταση των όρχεων", "Ακολούθησε τα πιο κάτω βήματα για την αυτοεξέταση των όρχεών σας μετά το μπάνιο μια φορά το μήνα (δες εικ.) \r\nΨηλάφισε τους όρχεις. Είναι φυσιολογικό να διαφέρει ο ένας από τον άλλο σε μέγεθος ή στο ύψος που βρίσκεται. \r\nΒρες την επιδιδυμίδα στο πάνω μέρος κάθε όρχι. Είναι μαλακή και ευαίσθητη. \r\nΒρες τον σπερματικό τόνο. Ξεκινά από την κορυφή της επιδιδυμίδας, πίσω από τον όρχι και είναι σαν σωλήνας. \r\nΑν προσέξεις \r\n● αλλαγές στο βάρος ή στο μέγεθος του όρχι \r\n● διόγκωση ή πρίξιμο \r\n● σκλήρυνση ή μικρό όγκο \r\n● πόνο \r\nΖήτα αμέσως ιατρική συμβουλή από ουρολόγο χωρίς αναστολές ή καθυστέρηση",0,2,"15-35",3,"0-100",2,2,"autoeksetasi_orxewn",0,1);

		//Καρκίνος του Προστάτη*
		addCancer(db,"Καρκίνος του Προστάτη","Εντοπίζεται σε νεαρές ηλικίες και θεραπεύεται εύκολα και για πάντα όταν εντοπίζεται έγκαιρα. \r\nΗ μηνιαία αυτοεξέταση μπορεί να σας σώσει. \r\nΗ κρυψορχία και κληρονομικότητα αποτελούν πιθανούς παράγοντες κινδύνου","cancer_prostatis");
		
		
		//Καρκίνος του Παχέος Εντέρου
		addCancer(db,"Καρκίνος του Παχέος Εντέρου","Ο δεύτερος σε συχνότητα καρκίνος σε άνδρες και γυναίκες. \r\nΜπορεί να προληφθεί με ισορροπημένη διατροφή και υγιεινό τρόπο ζωής που περιλαμβάνει καθημερινή άσκηση τουλάχιστον 1 ώρα 5 φορές την εβδομάδα, κατανάλωση αλκοόλ με το μέτρο, χωρίς κάπνισμα. \r\nΜπορεί να θεραπευθεί όταν εντοπισθεί έγκαιρα","cancer_paxeous_enterou");
		
		//κλονοσκόπηση όταν υπάρχει οικογενεικό ιστορικό 
		
		addExamination(db,"Κολονοσλόπηση","Αν έχετε συγγενή 1ου βαθμού με καρκίνο του παχέος εντέρου θα πρέπει να εξεταστείτε, κάνοντας κολονοσκόπηση, 10-15 χρόνια πριν την ηλικία που είχε διαγνωσθεί",0,2,"25-50",3,"0-100",1,2,"-",2,1);
		addExamination(db,"Συμβουλευτείτε ένα γαστρεντερολόγο","Αν έχετε συμπτώματα που πρωτοεμφανίζονται, αλλαγές στις εντερικές σας συνήθειες  και διαρκούν 3-4 εβδομάδες ή έχετε το ακόλουθο ιστορικό συμβουλευτείτε ένα γαστρεντερολόγο. \r\nΑιμορραγία από τον πρωκτό \r\nΑναιμία και αίσθηση κούρασης \r\nΠόνος ή συνεχιζόμενη δυσφορία \r\nΕλκώδη κολίτιδα",0,2,"35-55",3,"0-100",2,2,"-",2,1);
	
		addExamination(db,"Κολονοσκόπηση ή ανάλυση κοπράνων","Είτε έχετε συμπτώματα είτε όχι υποβληθείτε σε μία κολονοσκόπηση ή ανάλυση κοπράνων.\r\nΕξετάσεις που μπορεί να κάνει ο γιατρός: \r\nΔακτυλική εξέταση στο έντερο \r\nΕξέταση αίματος για αναιμία \r\nΆκαμπτη/Εύκαμπτη Σιγμοειδοσκόπηση \r\nΚολονοσκόπηση \r\n Αξονική τομογραφία-εντερογραφία \r\nΓια γυναίκες και άνδρες ηλικίας 50-69 ετών γίνονται αναλύσεις κοπράνων δωρεάν, στα πλαίσια του προγράμματος πληθυσμιακού ελέγχου του Υπουργείου Υγείας, σε κοινότητες της Επαρχίας Λάρνακας. Εάν η ανάλυση είναι θετική ακολουθεί παραπομπή για κολονοσκόπηση για περαιτέρω διερεύνηση. Η πρόσκληση αποστέλλεται ταχυδρομικώς. Αν δεν έχετε ανταποκριθεί ακόμα δράστε.",0,2,"50-65",3,"0-100",2,2,"-",2,1);

		addCancer(db,"Καρκίνος της Ουροδόχου Κύστης","Γνωρίστε το σώμα σας και το ιστορικό της οικογένειάς σας","-");
		addCancer(db,"Καρκίνος του Πνεύμονα – Δέν υπάρχουν μέθοδοι έγκαιρης διάγνωσης σε άτομα χωρίς συμπτώματα","-	Παράγοντες κινδύνου: \r\nΕνεργητικό και παθητικό κάπνισμα	\r\nΈκθεση σε περιβαλλοντικούς ρύπους όπως ο αμίαντος	\r\nΔιακόψτε το κάπνισμα	\r\nΛάβετε προστατευτικά μέτρα και συμμορφωθείτε σε κανονισμούς ασφάλειας στο χώρο εργασίας \r\nΑν έχετε παρετεταμένο, ενοχλήτικό βήχα, αιμόπτυση, πνευμονία που δεν περνάει επισκευτείτε το γιατρό σας \r\nΔιαγνωστικές εξετάσεις είναι το σπιρογράφημα και ακτινογραφία ","-");
	
		
		addCancer(db,"Καρκίνος του Δέρματος, Μελάνωμα","Επαναλαμβανόμενα εγκαύματα λόγω ηλιοθεραπείας /υπερβολικής έκθεσης στον ήλιο αποτελούν τον 1ο παράγοντα κινδύνου για τον καρκίνο του δέρματος και το μελάνωμα \r\nΆτομα ψηλού κινδύνου είναι όσοι έχουν ή είχαν \r\n•	Οικογενειακό ιστορικό μελανώματος \r\n•	Μεγάλο αριθμό σπίλων ή ασυνήθιστους σπίλους που αλλάζουν \r\n•	Ανοιχτόχρωμο δέρμα και μάτια γαλανά \r\n•	Εργάζονται ή δραστηριοποιούνται στο ύπαιθρο ακάλυπτοι \r\n•	Εγκαύματα στην παιδική ηλικία \r\nΑν προσέξετε \r\nΑλλαγή στο μέγεθος ή χρώμα ενός σπίλου (ελιάς) \r\nΠόνο ή αιμορραγία από ένα σπίλο \r\nΜια πληγή που δεν επουλώνει  \r\nΣυμβουλευτείτε το γιατρό σας","-");

	}

	public void addCancer(SQLiteDatabase db, String name, String description, String img) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("cancer_name", name);
		values.put("cancer_description", description);
		values.put("image_name", img);

		// Inserting Row
		db.insert("CANCER", null, values);
		Log.d("SCC - addCancer", "Added cancer: " + name);
		// db.close(); // Closing database connection

		/*if (relatedExams != null)
			addCancerRelatedExams(db, name, relatedExams);

		if (relatedPreventions != null)
			addCancerRelatedPreventions(db, name, relatedPreventions);*/
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

	/*private void addCancerRelatedPreventions(SQLiteDatabase db, String name,
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
	}*/

/* void addCancerPrevention(SQLiteDatabase db, int cid, int pid) {
		ContentValues values = new ContentValues();
		values.put("ID_cancer", cid);
		values.put("ID_prevention", pid);

		// Inserting Row
		db.insert("CANCER_PREVENTION", null, values);
		Log.d("SCC - addCancer", "Added prevention-cancer rel: " + pid + "-"
				+ cid);
	}*/

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
		addExamination(db, name, null, 0, 0, null, 0, null, 0, 0, "-",0,1);
	}

	public void addExamination(SQLiteDatabase db, String name,
			String description, int frequency, int sex, String agerange,
			int smoker, String dms, int familyHistory, int alcohol, String img, int gender,int type) {
		
		//type=0 is examination , type=1 is prevention
		
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
		values.put("examination_type", type);

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
				"SELECT ID_Examination FROM EXAMINATION;");
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
	
	
	public ArrayList<String> getExamNamesonly() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> names = new ArrayList<String>();
		String getNamesQuery = new String(
				"SELECT examination_name FROM EXAMINATION WHERE examination_type=1;");
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
	
	
	public ArrayList<String> getExamNamesonlyPreventions() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> names = new ArrayList<String>();
		String getNamesQuery = new String(
				"SELECT examination_name FROM EXAMINATION WHERE examination_type=0;");
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
	
	
	/*public ArrayList<Exam> getExamObjects() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Exam> names = new ArrayList<Exam>();
		String getNamesQuery = new String(
				"SELECT * FROM EXAMINATION WHERE examination_type=1;");
		Cursor c = db.rawQuery(getNamesQuery, null);
		if (c.moveToFirst()) {
			do {
				names.add(((DatabaseManager) c).getExam(0));
			} while (c.moveToNext());
			db.close();
			return names;
		} else
			db.close();
		return null;
	}*/

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
				+ eID + " AND examination_type=1;");
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

	public ArrayList<Exam> getPrevention(int pID) {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Exam> exams = new ArrayList<Exam>();
		String query = new String("SELECT * FROM EXAMINATION WHERE ID_Examination="
				+ pID + " AND examination_type=0;");
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			exams.add(new Exam(pID,c.getString(1), c.getString(5), c.getInt(7), c
					.getInt(9), c.getString(6), c.getInt(11), c.getInt(8), c
					.getInt(4), c.getString(2), c.getString(10), c.getInt(3)));
			db.close();
			return exams;
		} else {
			db.close();
			return null;
		}

	}
	
	public ArrayList<Exam> getAllExams() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Exam> exams = new ArrayList<Exam>();
		String query = new String("SELECT * FROM EXAMINATION WHERE examination_type=1;");
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



public ArrayList<Exam> getAllPrev() {
	SQLiteDatabase db = this.getReadableDatabase();
	ArrayList<Exam> exams = new ArrayList<Exam>();
	String query = new String("SELECT * FROM EXAMINATION WHERE examination_type=0;");
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