package miniPjoject.dao;

import java.util.List;

public interface miniProjectDAO {
	
	public List<miniProjectlist> getList(String restaurant);
	
	public List<miniProjectlist> getSelectedList();
	
	public List<miniProjectlist> restaurant(String category);
	
	public List<miniProjectlist> menu(String restaurant);
	
	public int update(String category, String restaurant, String menu);
	
	public List<miniProjectlist> getPolls(String category, String restaurant, String menu);
	
	public List<miniProjectlist> getspecification(String category, String restaurant, String menu);
	
	public miniProjectlist getPollsCount(String category, String restaurant, String menu);
}
