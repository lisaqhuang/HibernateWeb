package tw.hibernatedemoService;

import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;
import tw.hibernatedemo.model.CompanyDaoInterface;

public class CompanyService implements CompanyServiceInterface {
	
	private CompanyDao comDao;
	
	public CompanyService(Session session) {
		this.comDao= new CompanyDao(session);
	}

	@Override
	public CompanyBean select(int comId) {
		
		return comDao.select(comId);
	}

	@Override
	public List<CompanyBean> selectAll() {
		
		return comDao.selectAll();
	}

	@Override
	public CompanyBean insert(CompanyBean comBean) {
		
		return comDao.insert(comBean);
	}

	@Override
	public CompanyBean updateOne(int comId, String comName) {
		return comDao.updateOne(comId,comName);
	}

	@Override
	public boolean delete(int comId) {
		
		return comDao.deleteOne(comId);
	}

	
}
