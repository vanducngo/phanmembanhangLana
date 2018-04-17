package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import constant.UriConstant;

public class UriGHTKAPI {
	public static String executeGetReQuest(String targetURL) {
		HttpURLConnection connection = null;

		try {
			System.out.println(targetURL);
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");

			connection.setRequestProperty("Token", UriConstant.TOKEN.GHTK);

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int c; (c = in.read()) >= 0;)
				sb.append((char) c);

			connection.disconnect();

			String result = sb.toString();
			System.out.println(result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
