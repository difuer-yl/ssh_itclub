package com.itclub.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itclub.ssh.dao.SystemDao;
import com.itclub.ssh.domain.AdminMenu;
import com.itclub.ssh.domain.Setting;
import com.itclub.ssh.service.SystemService;

public class SystemServiceImpl implements SystemService {

	private SystemDao systemDao;

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public void addCategory(AdminMenu adminMenu) {
		int key = 0;
		AdminMenu tmp;
		if (adminMenu.getParentId() == 0) {

			// If insert is at the end then left key choose as
			// maximum right key + 1, level - 1
			adminMenu.setLevel(1);
			key = systemDao.findMenuMaxRght() + 1;
		} else {
			tmp = systemDao.finMenuById(adminMenu.getParentId());
			key = tmp.getRght();
			adminMenu.setLevel(tmp.getLevel() + 1);
		}

		systemDao.updateMenu(key);
		// Update tree keys to create gap

		adminMenu.setLft(key);
		adminMenu.setRght(key + 1);

		// Create new node
		systemDao.saveMenu(adminMenu);
	}

	@Override
	public List getCategory() {
		List list = systemDao.findCategoryAll();
		return list;
	}

	@Override
	public Map getSetting() {
		List<Setting> list = systemDao.findSettingAll();
		Map<String, String> map = new HashMap<>();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			map.put(list.get(i).getSkey(), list.get(i).getSvalue());
		}
		return map;
	}

	@Override
	public List<AdminMenu> getCategoryTopLevel() {
		List list = systemDao.findCategoryByLevel(1);
		return list;
	}

	@Override
	public AdminMenu getCategoryById(int id) {
		return systemDao.finMenuById(id);
	}

	@Override
	public void updateCategory(AdminMenu adminMenu) {
		
		//只有修改了父级分类才去修改分类
		AdminMenu am=systemDao.finMenuById(adminMenu.getId());
        if(am.getParentId()!=adminMenu.getParentId()){
        	int key=0;
    		AdminMenu tmp;
    		
    		if (adminMenu.getParentId()==0) {

    			// If insert is at the end then left key choose as
    			// maximum right key + 1, level - 1
    			 adminMenu.setLevel(1);
    			 key =systemDao.findMenuMaxRght();
    		} else {
    			tmp=systemDao.finMenuById(adminMenu.getParentId());
        		if(tmp==null)return;
    			 key =tmp.getRght()-1;
    			 adminMenu.setLevel(tmp.getLevel()+ 1);
    		}
    		if(key>=am.getLft()&&key<=am.getRght())return;
    		systemDao.moveMenu(adminMenu, key);
        }
		
	}

	@Override
	public String deleteMenu(int id) {
		AdminMenu item = systemDao.finMenuById(id);
		if (item==null) {
			return "删除失败！";
		}

		int skew =  item.getRght() -  item.getLft() + 1;
		// delete node
		systemDao.deleteMenu(item.getLft(),item.getRght());
		systemDao.updateMenuByDelete(item.getLft(),skew,item.getRght());
		return "删除成功！";
	}
}
