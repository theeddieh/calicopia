package com.dferreras.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Singleton {
    private static Singleton INSTANCE = null;
 
    public int itemSelected;
    public int monthSelected;
    public int screenIndex;
    public ArrayList<ProduceItem> foods;
    
    // Private constructor suppresses 
    private Singleton() {}
 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Singleton();
            INSTANCE.setFoods();
        }
    }
 
    public static Singleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    // Gets all the food data to be displayed
    // App Engine site: 
    private void setFoods() {
    	
    	
    	/*
    	 * 
    	 * String data = "";  // parameters of request
        try {
             
             // Send the request
             URL url = new URL("http://calicopiatest.appspot.com/");
             URLConnection conn = url.openConnection();
             conn.setDoOutput(true);
             OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
             
             //write parameters
             //writer.write(data);
             //writer.flush();
             
             // Get the response
             StringBuffer answer = new StringBuffer();
             BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             String line;
             while ((line = reader.readLine()) != null) {
                 answer.append(line);
             }
             writer.close();
             reader.close();
             
             //do what you want with the response in answer
             // ....
             
             
         
         } catch (MalformedURLException ex) {
             ex.printStackTrace();
             //resultTextView.setText("malformed");
         } catch (IOException ex) {
             ex.printStackTrace();
             //resultTextView.setText("io");
         }
		finally {
			
		}
    	 */
    	
    	
    	foods = new ArrayList<ProduceItem>();
    	
    	ProduceItem p1 = new ProduceItem("Apple","Apples help with asthma & breathing!", "Look for: Round-shaped Smell Feel for: Firmness, lack of mushiness Avoid! Green apples that have a yellow hue, brownness", "Store/refrigerate: Refrigerate for up to 3 days. If baking, store at room temperature for up to 2 days Keep/freeze: For pie baking, sauce making or butter churning: freeze peeled apples in saltwater, lemon juice or sugar syrup ");
    	ProduceItem p2 = new ProduceItem("Orange", "Oranges lower cholesteral and prevent diabetes", "Avoid blemishes, shriveled, and moldy spots", "Room temp for 3-4 days, refridgerate for 5-6 weeks, freeze teh juice");
    	ProduceItem p3 = new ProduceItem("Banana", "Banana'a act as a mild sedative and mood enhancer", "Look for: yellow with a few brown spots, or with green tips Smell/feel for: Plump and firm Avoid! Blemished, sunken or split skin and strong-smelling bananas ", "Store at room temp. To ripen, put in a paper bag in the sun. Can freeze it with or without peel");
    	ProduceItem p4 = new ProduceItem("Pear", "Eating one pear will give you all the fiber you need for the day!", "Look for: Unblemished skin that is not shriveled or dull Smell/Feel for: Smooth skin free of cuts and bruises Avoid! Looking for pears to eat straight away. They do not ripen on the tree, they will at home!", "Store/refrigerate: To quicken the ripening process, place in paper bag with holes along with ripe oranges or apples. Otherwise, store at room temperature");
    	ProduceItem p5 = new ProduceItem("Lemon", "Lemons can be used topically for skin problems like acne and eczema, drinking in tea or water helps with anxiety, colds, fevers and...canker sores!", "Look for: small lemons Smell/Feel for: heavy for size, that means it is juicy Avoid! Bruises, cuts & blemishes", "Store/refrigerate: juiciest if stored at room temperature up to one week, 5-6 week shelf life if refrigerated Keep/freeze: freeze lemon juice");
    	ProduceItem p6 = new ProduceItem("Carrot", "Carrots help to improve vision, nourish skin, and help clean your teeth!",  "Look for: A straight and firm bunch. If the tops are attached, they should be bright green and fresh! Avoid! Wilted tops and cracked skins",  "Store/refrigerate: Cut tops before refrigerating unwashed for up to 2 weeks Keep/freeze: 8-12 months in freezer");
    	ProduceItem p7 = new ProduceItem("Spinach", "Boiled spinach helps to maintain the strength and density of bones!", "Look for: dark green leaves Smell/Feel for: fresh – smelling Avoid! slimy leaves", "Store/refrigerate: refrigerate for one week Optimal eating:  Dry washed salad in a salad spinner or make your own: place the greens in a clean pillowcase & take it outside and swing it around until they’re dry.");
    	ProduceItem p8 = new ProduceItem("Tomato", "Tomatoes are natural antiseptics and antioxidants!", "Look for: Deep colors Smell/Feel for: Shape doesn’t matter, tasty tomatoes will feel for heavy for size and smell fresh from the vine at stem Avoid! Blemishes and soft spots ", "Store/refrigerate: Keep at room temperature, place in paper bag to ripen! Refrigerate after cutting in plastic wrap for 2 days");
    	ProduceItem p9 = new ProduceItem("Potato", "Potatoes slow your digestion, making you full for longer. They are also great for your heart!", "Look for: Potatoes of similar size for cooking Smell/Feel for: Heavy for size Avoid! Decayed ends, blemishes or sunken spots", "Store/refrigerate: Store in cool dark places, do not refrigerate! Optimal Eating: Use within one week! Keep/freeze: Do not freeze!");
    	ProduceItem p10 = new ProduceItem("Kale", "Kale is antioxidant-rich, good for digestion, detoxing and dieting!", "Look for: Choose dark colored leaves that are small to medium sized Avoid! Brown or yellow leaves", "Store/refrigerate: Refrigerate in a plastic bag for 3-5 days!");
    	ProduceItem p11 = new ProduceItem("Strawberry", "Strawberries are the sweetest way to  curb your appetite, regulate your digestion and lower blood pressure!", "Look for: plumpest, shiniest Smell for: most fragrant Avoid!: wet, stained-looking containers", "Store/Refrigerate: for 3-5 days in open air container Optimal Eating: wash immediately before using, eat at room temperature Keep/Freeze : Gently wash and dry, remove stems. Spread on cooking sheet in freezer. When frozen, transfer to bag & keep for up to a year!");
    	ProduceItem p12 = new ProduceItem("Cucumber", "Cucumbers provide water and fiber in a tasty snack that fills you up!", "Look for: Bright, even color throughout. Fleshy-but not too large in shape Smell/Feel for: Firmness throughout Avoid! Blemishes, soft spots, yellowing, or easily bent cucumbers.","Store/refrigerate: Refrigerate in the crisper drawer for up to 3 days Keep/freeze: After cutting, wrap end in wax paper with a rubber band to prevent drying out");
    	ProduceItem p13 = new ProduceItem("Onion", "Onions detox your body from/with heavy meals!", "Look for: Clean, well-shaped with crisp dry outer skin with no opening at the neck Avoid! Soft  spots, moisture at the neck, and dark patches", "Store/refrigerate:  Green onion- refrigerate. cooking & sweet onions- keep in cool, dark space in ventilated bag. Keep/freeze: Peeled and chopped onions can be frozen, but some flavor will be lost");
    	ProduceItem p14 = new ProduceItem("Garlic", "Garlic is a powerful antibiotic!", "Look for: Plump heads with unbroken skin Smell/Feel for: Firmness Avoid! Soft, shriveled, mold and sprouts", "Store/refrigerate: Once you break the head, the shelf life greatly decreases. Store at room temperature. Cloves can be refrigerated in vinegar!");
    	ProduceItem p15 = new ProduceItem("Broccoli", "Broccoli is helpful in repairing damaged skin!", "Look for: Uniformly-colored tightly-packed clusters Smell/Feel for: Firm stalks and stems Avoid! Slimy spots", "Store/refrigerate:  Refrigerate for 3-5 days in airtight (as possible) plastic bag Optimal eating: Wash before eating Keep/freeze: Freeze blanched broccoli for up to one year" );
    	ProduceItem p16 = new ProduceItem("Zucchini", "Zucchini lowers cholesterol and aids digestion!", "Choosing Fresh Look for:  Average sized with shiny skin Smell/Feel for: Heavy for size Avoid! Blemishes on the skin","Store/refrigerate: Keep unwashed in airtight container in refrigerator for up to a week Keep/freeze: Steam blanch and freeze");
    	ProduceItem p17 = new ProduceItem("Grapefruit", "Grapefruit is a superfood for losing weight and maintaining healthy, smooth skin!", "Look for: Thin, smooth, firm & blemish free skin Smell/Feel for: Heavy for size", "Store/refrigerate: Store at room temperature for 1 week or refrigerate for 2 to 3 weeks");
    	ProduceItem p18 = new ProduceItem("Avocado", "Avocados provide excellent absorption of vitamins for the foods they are eaten with!", "Smell/Feel for: Firm skin and no soft spots, firm but yielding to gentle pressure when ripe", "Store/refrigerate: Store unripe avocados in paper bag at room temperature. Refrigerate when ripe for 2-3 days.");
    	ProduceItem p19 = new ProduceItem("Green beans", "Green beans contain omega-3 fatty acid and have great cardiovascular benefits!", "Look for: Fresh, well colored beans, consistent in size and color Smell/Feel for: Beans that snap easily when bent Avoid! Beans that you can see through the pod", "Store/refrigerate: Refrigerate in plastic bag for up to one week Keep/freeze: Freeze blanched beans");
    	
    	foods.add(p1);
    	foods.add(p2);
    	foods.add(p3);
    	foods.add(p4);
    	foods.add(p5);
    	foods.add(p6);
    	foods.add(p7);
    	foods.add(p8);
    	foods.add(p9);
    	foods.add(p10);
    	foods.add(p11);
    	foods.add(p12);
    	foods.add(p13);
    	foods.add(p14);
    	foods.add(p15);
    	foods.add(p16);
    	foods.add(p17);
    	foods.add(p18);
    	foods.add(p19);
  	
    	
    }

	public ArrayList<ProduceItem> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<ProduceItem> foods) {
		this.foods = foods;
	}
    
    
}
