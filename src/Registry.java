import java.util.ArrayList;
import java.io.*;

public class Registry {
	private String name;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Registry(String name){
		this.name = name;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void saveRegistry() {
		try {
			FileOutputStream reg = new FileOutputStream(name + ".ser");
			ObjectOutputStream out;
			out = new ObjectOutputStream(reg);
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			System.out.println("An error occured while saving the registry");
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Player> fetchPlayers() {
		try {
			FileInputStream in = new FileInputStream(name + ".ser");
			ObjectInputStream obj = new ObjectInputStream(in);
			players = (ArrayList<Player>) obj.readObject();
			obj.close();
		} catch (IOException e) {
			System.out.println("An error occured while reading the registry");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error, class not found");	
			e.printStackTrace();
		}
		return players;
	}
}
