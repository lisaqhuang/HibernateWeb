package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CompanyDao implements CompanyDaoInterface {
	
	private Session session;
	
	//依賴注入Dependency Injection
	public CompanyDao(Session session) {
		this.session = session;
	}
	
	
	@Override
	public CompanyBean insert(CompanyBean comBean) {
		
		CompanyBean companyBean = session.get(CompanyBean.class, comBean.getCompanyId());
		if(companyBean == null) {
			
			session.save(comBean);
			return comBean;
		}
		return null;
	}

	@Override
	public CompanyBean select(int comId) {
		// TODO Auto-generated method stub
		
		
		return session.get(CompanyBean.class, comId);
	}

	@Override
	public List<CompanyBean> selectAll() {
		// TODO Auto-generated method stub
		
		Query<CompanyBean> query =session.createQuery("from CompanyBean", CompanyBean.class);
		List<CompanyBean> result = query.getResultList();
		return result;
	}

	@Override
	public CompanyBean updateOne(int comId, String newName) {
		// TODO Auto-generated method stub
		
		CompanyBean comBean = session.get(CompanyBean.class, comId);
		
		if(comBean !=null) {
			comBean.setCompanyName(newName);
			return comBean;
		}
		
		return null;
	}

	@Override
	public boolean deleteOne(int comId) {
		// TODO Auto-generated method stub
		CompanyBean comBean = session.get(CompanyBean.class, comId);
		if(comBean != null) {
			session.delete(comBean);
			return true;
		}
		
		return false;
	}

}
