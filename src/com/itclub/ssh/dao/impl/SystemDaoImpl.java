package com.itclub.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itclub.ssh.dao.SystemDao;
import com.itclub.ssh.domain.AdminMenu;

public class SystemDaoImpl extends HibernateDaoSupport implements SystemDao {

	@Override
	public void saveCategory(AdminMenu adminMenu) {
		this.getHibernateTemplate().save(adminMenu);

	}

	@Override
	public List findCategoryByLevel(int level) {
		List list = getHibernateTemplate().find(
				"from AdminMenu where level=? ", level);

		return list;
	}

	@Override
	public List findSettingAll() {
		List list = getHibernateTemplate().find("from Setting");

		return list;

	}

	@Override
	public List findCategoryAll() {
		List list = getHibernateTemplate().find("from AdminMenu order by lft ");

		return list;
	}

	@Override
	public int findMenuMaxRght() {
		List list = getHibernateTemplate().find(
				"select max(rght) from AdminMenu");
		if (list == null) {
			System.out.println(list.size());
			return (int) list.get(0);
		}
		return 0;
	}

	@Override
	public AdminMenu finMenuById(int id) {
		List list = this.getHibernateTemplate().find(
				" FROM AdminMenu WHERE id = ?", id);
		return (AdminMenu) list.get(0);
	}

	@Override
	public void updateMenu(int key) {
		this.getHibernateTemplate()
				.bulkUpdate(
						"UPDATE AdminMenu SET lft = lft + 2 WHERE rght >= ? and lft >= ? ",
						key, key);
		this.getHibernateTemplate().bulkUpdate(
				"UPDATE AdminMenu SET rght = rght + 2 WHERE rght >= ?", key);
	}

	@Override
	public void saveMenu(AdminMenu adminMenu) {
		this.getHibernateTemplate().save(adminMenu);

	}
	/**
	 * 
	 * 
	 */
	@Override
	public void moveMenu(AdminMenu adminMenu, int key) {
		
		AdminMenu am = this.finMenuById(adminMenu.getId());
		int skew_tree = am.getRght() - am.getLft() + 1;
		int skew_level = adminMenu.getLevel() - am.getLevel();
		String tempsql="";
		if (am.getRght() < key) {
			int skew_edit = key - am.getLft() + 1 - skew_tree;
			 tempsql="UPDATE admin_menu SET "
					+ "lft = IF( rght <= "+am.getRght()+", lft + "+skew_edit+", IF( lft > "+am.getRght()+", lft - "+skew_tree+", lft ) ), "
					+ "level = IF( rght <= "+am.getRght()+", level + "+skew_level+", level ),"
					+ " rght = IF( rght <= "+am.getRght()+", rght + "+skew_edit+", IF( rght <= "+key+", rght - "+skew_tree+", rght ) ), "
					+ "parent_id = IF( parent_id = "+adminMenu.getId()+", "+adminMenu.getParentId()+", parent_id )"
					+ " WHERE rght > "+am.getLft()+" AND lft <= "+key;
			
			
		} else { 
			int skew_edit = key - am.getLft() + 1;
			tempsql=" UPDATE admin_menu SET "
					+ "rght = IF( lft >= "+am.getLft()+", rght + "+skew_edit+", IF( rght < "+am.getLft()+", rght + "+skew_tree+", rght ) ), "
					+ "level = IF( lft >= "+am.getLft()+", level + "+skew_level+", level ),"
					+ " lft = IF( lft >= "+am.getLft()+", lft + "+skew_edit+", IF( lft > "+key+", lft + "+skew_tree+", lft ) ), "
					+ "parent_id = IF( parent_id = "+adminMenu.getId()+", "+adminMenu.getParentId()+", parent_id ) "
					+ "WHERE rght > "+key+" AND lft < "+am.getRght();
			

			
		}
		//执行原生update sql语句
		getSessionFactory().getCurrentSession().createSQLQuery(tempsql).executeUpdate();
	}

	@Override
	public void deleteMenu(int lft, int rght) {
		String tempsql="DELETE FROM admin_menu WHERE lft >= "+lft+" AND rght <= "+rght;
		getSessionFactory().getCurrentSession().createSQLQuery(tempsql).executeUpdate();
		
	}

	@Override
	public void updateMenuByDelete(int lft, int skew, int rght) {
		String sql="UPDATE admin_menu SET lft = IF(lft > "+lft+", lft - "+skew+", lft), rght = rght - "+skew+" WHERE rght > "+rght;
		getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}


}
