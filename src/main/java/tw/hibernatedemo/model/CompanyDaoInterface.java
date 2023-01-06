package tw.hibernatedemo.model;

import java.util.List;

public interface CompanyDaoInterface {
	
	public CompanyBean insert(CompanyBean comBean);
	public CompanyBean select(int comId);
	public List<CompanyBean> selectAll();
	public CompanyBean updateOne(int comId,String newName);
	public boolean deleteOne(int comId);

}
