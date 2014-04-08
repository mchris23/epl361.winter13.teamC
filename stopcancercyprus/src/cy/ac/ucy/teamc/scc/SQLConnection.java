package cy.ac.ucy.teamc.scc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.os.AsyncTask;
import android.util.Log;

public class SQLConnection extends AsyncTask{
/* 
 * Old method using normal HTTP connection
 
	public void getData() {
		JSONArray jArray = null;
		String result = null;
		StringBuilder sb = null;
		InputStream is = null;

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		// http post
		try {
			HttpClient httpclient = new DefaultHttpClient();

			// Why to use 10.0.2.2
			HttpPost httppost = new HttpPost(
					"https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/authenticateUser.php");
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("ERROR_HTTP", "Error in http connection" + e.toString());
		}
		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line = "0";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("ERROR_CONVERSION", "Error converting result " + e.toString());
		}

		String examName;
		String examDescr;
		try {
			jArray = new JSONArray(result);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				examName = json_data.getString("Name");
				examDescr = json_data.getString("Description");
			}
		} catch (JSONException e1) {
			Log.e("ERROR_DATABASE",
					"Error processing data from database " + e1.toString());
			// Toast.makeText(getBaseContext(), "No Data Found"
			// ,Toast.LENGTH_LONG).show();
		} catch (ParseException e1) {
			Log.e("ERROR_PARSING",
					"Error parsing data from database " + e1.toString());
		}
	}
	*/
	/* 
	 * New method using normal HTTPS connection
	 */
	public String getInternetData(String file) {


	    BufferedReader in = null;
	    String data = null;

	    try {
	        HttpClient client = new DefaultHttpClient();
	        

	        URI website = new URI("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/"+file); 
	        HttpGet request = new HttpGet();
	        request.setURI(website);
	        HttpResponse response = client.execute(request);
	        response.getStatusLine().getStatusCode();

	        in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	        StringBuffer sb = new StringBuffer("");
	        String l = "";
	        String nl = System.getProperty("line.separator");
	        while ((l = in.readLine()) != null) {
	            sb.append(l + nl);
	        }in.close();
	        data = sb.toString();
	        Log.d("DATA_RECEIVED",data);
	        return data;
	    } catch (Exception e) {
	    	System.out.println("Exception " + e.getMessage());
	    	return data;
	    } finally {
	        if (in != null) {
	            try {
	                in.close();
	                return data;
	            } catch (Exception e) {
	                Log.e("GetMethodEx", e.getMessage());
	            }
	        }
	    }
	}
	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		return this.getInternetData((String)arg0[0]);
	}
}
