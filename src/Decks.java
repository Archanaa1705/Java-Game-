
/*Please search for name (archanaa) to fix the issue.
Unable to store API values into CARD object.*/

import java.awt.*;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Decks {
	private static Cards[] CardDeckArray = new Cards[52];
	private int index = 0;
	private static HttpURLConnection connection;

	public Decks() {
		int index2 = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Cards a = new Cards(i, j);
				CardDeckArray[index2] = a;
				index2++;
			}
		}
	}

	//Archanaa This is without calling API, values are updated into CardDeckArray

	public void shuffle() {
		index = 0;
		int counter = 0;
		while (counter < 60) {
			Random rand = new Random();
			int x = rand.nextInt(52);
			int y = rand.nextInt(52);
			Cards stored = CardDeckArray[x];
			CardDeckArray[x] = CardDeckArray[y];
			CardDeckArray[y] = stored;
			
			counter++;
		}
	}

	public boolean hasNextCardValue() {
		return index < 52;
	}

	public Cards nextCards() {
		if (index < 52) {
			index++;
			return CardDeckArray[index - 1];
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		Decks deck = new Decks();
		System.out.println("Deck values:" + deck.toString());
		while (deck.hasNextCardValue()) {
			System.out.println(deck.nextCards());
		}
		// archanaa API connection response is successful

		BufferedReader reader;
		String line; // to append each line result and build the content
		StringBuffer responseContent = new StringBuffer();

		try { // Calling API

			// Use of java.net.HttpURLConnection

			URL url = new URL("http://nav-deckofcards.herokuapp.com/shuffle");
			connection = (HttpURLConnection) url.openConnection();

			// request setup of API response connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();
			System.out.println(status);

			// if connection has issues
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);

				}
				reader.close();

				// if connection is successful
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			System.out.println(responseContent.toString());

			parse(responseContent.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();

		} finally {
			connection.disconnect();
		}

		deck.shuffle();
		//System.out.println("Shuffled:" + a.toString());
		int counter = 0;
		while (deck.hasNextCardValue()) {
			System.out.println(deck.nextCards());
		}
	}

	public static String parse(String responseBody) {

		JSONArray suitValues = new JSONArray(responseBody);
//		String[] suits=new String[12];
//		String []ranks=new String[12];;
		for (int i = 0; i < suitValues.length(); i++) {
			JSONObject EachSuitValue = suitValues.getJSONObject(i);
			String j = EachSuitValue.toString();
			
//			   suits[i] = EachSuitValue.getString("suit"); 
//			   ranks[i]	= EachSuitValue.getString("value");
			   System.out.println("responseBody"+responseBody);
			   System.out.println("Array of suitValues"+suitValues);
			}

		return null;
	}
}
