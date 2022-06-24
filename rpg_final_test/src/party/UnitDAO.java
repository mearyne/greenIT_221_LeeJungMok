package party;

import java.util.HashMap;
import java.util.Map;

public class UnitDAO {
	private static UnitDAO instance = new UnitDAO();
	
	private UnitDAO() {};
	
	public static UnitDAO getInstance() {
		return instance;
	}
	
	public static Map<Integer, Unit> units = new HashMap<>();
	
}