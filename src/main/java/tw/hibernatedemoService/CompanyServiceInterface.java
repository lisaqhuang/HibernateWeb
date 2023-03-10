package tw.hibernatedemoService;

import java.util.List;

import tw.hibernatedemo.model.CompanyBean;

public interface CompanyServiceInterface {
	
    public CompanyBean select(int comId);
    public List<CompanyBean> selectAll();
    public CompanyBean insert(CompanyBean comBean);
    public CompanyBean updateOne(int comId,String comName);
    public boolean delete(int comId);


}
