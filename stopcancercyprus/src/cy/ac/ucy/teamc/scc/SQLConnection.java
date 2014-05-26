package cy.ac.ucy.teamc.scc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.AsyncTask;
import android.util.Log;

public class SQLConnection extends AsyncTask{
/* 
 * Old method using normal HTTP connection
 */
/*	public String getData() {
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
					"http://webdata.in.cs.ucy.ac.cy/home/students/cs/2011/anicol15/public_html/getCancerNames.php");
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

		String cancerNames = new String();
		String res = new String();
		try {
			jArray = new JSONArray(result);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				cancerNames = json_data.getString("cancer_name");
				res = res+cancerNames+"\n";
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
		return res;
	}
	
	
	
	/**old -worked but has us00ll**/
	/* 
	 * New method using normal HTTPS connection
	 */
	public String getDataold() throws IOException {

	/*	Log.e("see1","See1");
		
		try {
			InetAddress address = InetAddress.getByName("http://www.android.com/");
	        
			} catch (UnknownHostException e) {
			e.printStackTrace();
			}
		Log.e("sendsee1","See1");*/
		
		URL url = new URL("http://webdata.in.cs.ucy.ac.cy/home/students/cs/2011/anicol15/public_html/getCancerNames.php");
		   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		   try {
		     InputStream in1 = new BufferedInputStream(urlConnection.getInputStream());
		   }
		    finally {
		     urlConnection.disconnect();
		   }
		   Log.e("sendsee2","See1");
	    BufferedReader in = null;
	    String data = null;

	   /* try {
	        HttpClient client = new DefaultHttpClient();
	        

	        //URI website = new URI("http://www.android.com/");
	        URI website = new URI("http://webdata.in.cs.ucy.ac.cy/home/students/cs/2011/anicol15/public_html/getCancerExams.php");
	        Log.e("see2","See2");
	        HttpGet request = new HttpGet();
	        request.setURI(website);
	        HttpResponse response = client.execute(request);
	        response.getStatusLine().getStatusCode();

	      in= new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "ISO-8859-1"));
	       String sb = new String("");
	    //  BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new ByteArrayOutputStream() , "UTF-8"));
	        String l = "";
	        String nl = System.getProperty("line.separator");
	        while ((l = in.readLine()) != null) {
	        	Log.e("see3","See2");
	            sb = sb + l + nl;
	           // Log.e("dataBYTES",out.toString());
	        }in.close();
	        Charset.forName("UTF-8").encode(sb);
	        data = sb.toString();
	        Log.d("DATA_RECEIVED",data);
	        return data;
	    } catch (Exception e) {
	    	//System.out.println("Exception " + e.getMessage());
	    	e.printStackTrace();
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
	    }*/
	    return null;
	}
	
	

	/* 
	 * changedddddddd
	 */
	public String getInternetData() {

		Log.e("see1","See1");
	    BufferedReader in = null;
	    String data = null;

	    try {
	    	HttpParams params = new BasicHttpParams();
	    	params.setParameter(
	    	 
	    	CoreProtocolPNames.HTTP_CONTENT_CHARSET, HTTP.UTF_8);
	        HttpClient client = new DefaultHttpClient(params);
	        

	        URI website = new URI("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/getExams.php"); 
	        
	        Log.e("see2","See2");
	        HttpGet request = new HttpGet();
	        request.setURI(website);
	        HttpResponse response = client.execute(request);
	        response.getStatusLine().getStatusCode();

	      in= new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "ISO-8859-1"));
	       String sb = new String("");
	    //  BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new ByteArrayOutputStream() , "UTF-8"));
	        String l = "";
	        String nl = System.getProperty("line.separator");
	        while ((l = in.readLine()) != null) {
	        	Log.e("see3","See2");
	            sb = sb + l + nl;
	           // Log.e("dataBYTES",out.toString());
	        }in.close();
	        Charset.forName("UTF-8").encode(sb);
	        data = sb.toString();
	        Log.d("DATA_RECEIVED",data);
	        return data;
	    } catch (Exception e) {
	    	//System.out.println("Exception " + e.getMessage());
	    	e.printStackTrace();
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
	
	
	String minegetdata() throws IOException, JSONException, URISyntaxException
	{
		
		
		Log.e("see1","See1");
	    

	        HttpClient client = new DefaultHttpClient();
	        // HttpParams

	        URI website = new URI("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/getExams.php"); 
	        
	        Log.e("see2","See2");
	        HttpGet request = new HttpGet();
	        request.setURI(website);

	        HttpResponse response = client.execute(request);
	       // response.getStatusLine().getStatusCode();
		

	        
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		for (String line = null; (line = reader.readLine()) != null;) {
		    builder.append(line).append("\n");
		}
		String j=builder.toString();
        Log.e("buildeerrr",""+j);
		JSONTokener tokener = new JSONTokener(builder.toString());
		JSONArray finalResult = new JSONArray(tokener);
		
		return j;
	}

	
	//using webdata server-not working
	 /*public String getJSONhttp(){
	    	StringBuilder builder = new StringBuilder();
	    	HttpClient client = new DefaultHttpClient();
	    	HttpGet httpGet = new HttpGet("http://webdata.in.cs.ucy.ac.cy/home/students/cs/2011/anicol15/public_html/getCancerNames.php");
	    	try{
	    		HttpResponse response = client.execute(httpGet);
	    		StatusLine statusLine = response.getStatusLine();
	    		int statusCode = statusLine.getStatusCode();
	    		if(statusCode == 200){
	    			HttpEntity entity = response.getEntity();
	    			InputStream content = entity.getContent();
	    			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
	    			String line;
	    			while((line = reader.readLine()) != null){
	    				builder.append(line);
	    			}
	    		} else {
	    			Log.e("error","Failed to get JSON object");
	    		}
	    	}catch(ClientProtocolException e){
	    		e.printStackTrace();
	    	} catch (IOException e){
	    		e.printStackTrace();
	    	}
	    	String j=builder.toString();
	    	Log.e("build",j);
	    	return j;
	    }
	*/
	

	
	
	/* 
	 * New method using normal HTTPS connection
	 */
	public String getInternetDatamarias() {

		 Log.d("DATA_RECEIVED","See");
	    BufferedReader in = null;
	    String data = null;

	    try {
	        HttpClient client = new DefaultHttpClient();
	        

	        URI website = new URI("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/getExams.php"); 
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
	        Log.e("DATA_RECEIVED2",data);
	        return data;
	    } catch (Exception e) {
	    	e.printStackTrace();
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
	
	/* 
	 * New method using normal HTTPS connection
	 */
	public String getInternetDatamariasWithmychanges() throws UnsupportedEncodingException, IOException, JSONException {

		 Log.d("DATA_RECEIVED","See");

	    String data = null;
	    BufferedReader in = null;
	    try {
	        HttpClient client = new DefaultHttpClient();
	        
	        String timeStamp = "2012-04-13 09:00:30";
	        java.sql.Timestamp udate=null;
	        try{

	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            java.util.Date parsedDate = sdf.parse(timeStamp);
	            System.out.println(parsedDate.toString());
	            udate = new java.sql.Timestamp(parsedDate.getTime());
	            Log.d("TIMESTAMP",udate.toString());

	        }catch (Exception e) {
	            // TODO: handle exception
	        	e.printStackTrace();
	        	return null;
	        }
	        URL website = new URL("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/getExams.php?udate="+udate); 
	        URLConnection tc = website.openConnection();
	         in = new BufferedReader(new InputStreamReader(tc.getInputStream(),"iso-8859-1"),8); 
	        String line = in.readLine();
	        Log.d("line :", line);
	        JSONObject obj = new JSONObject(line);
	        JSONArray ja = obj.getJSONObject("deals").getJSONArray("items");
	        for (int i = 0; i < ja.length(); i++) { // each deal
	            JSONObject jo = (JSONObject) ja.get(i);
	            
	            Log.d("line :", "see");
	        }//for
	            // make the deal
	            /*Exam d = new Exam(jo.getString("title"),
	                    jo.getString("description"),
	                    jo.getString("price"),jo.getString("temperature"), 
	                    jo.getJSONObject("merchant").getString("name"),
	                    jo.getString("deal_image"),
	                    jo.getString("deal_image_highres"));
	            listItems.add(d);
	            Log.d("Deal:", d.toString());*/
	    }
	    finally {
	        if (in != null) {
	            try {
	                in.close();
	                return data;
	            } catch (Exception e) {
	                Log.e("GetMethodEx", e.getMessage());
	            }
	        }
	    }
	    return null;
	}
	        /*HttpGet request = new HttpGet();
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
	        Log.e("DATA_RECEIVED2",data);
	        return data;
	    } catch (Exception e) {
	    	e.printStackTrace();
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

	*/
	
	
	
	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		/*Log.e("see","See");
		try {
			return this.minegetdata();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String a="";
	

	/*	try {
			return this.getDataold();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		//return this.getInternetData();
		//return this.getInternetDatamarias(); //worked initial
		try {
			return this.getInternetDatamariasWithmychanges();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		//return this.getJSONhttp();
		//return this.getData();
	}
}
