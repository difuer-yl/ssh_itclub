package com.itclub.ssh.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itclub.ssh.domain.AdminMenu;

/**
 * @author chiaki
 *
 */
public class NestedSets extends HibernateDaoSupport {
	private String Db;
	private String tableName = "";
	private String leftKey = "left_key";
	private String rightKey = "right_key";
	private String parentKey = "parent_id";
	private String primaryKey = "id";
	private String levelKey = "level";
	private String multi = "root_id";
	private Map<Integer, AdminMenu> cache=new HashMap<Integer, AdminMenu>();
	public String getDb() {
		return Db;
	}
	public void setDb(String db) {
		Db = db;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getLeftKey() {
		return leftKey;
	}
	public void setLeftKey(String leftKey) {
		this.leftKey = leftKey;
	}
	public String getRightKey() {
		return rightKey;
	}
	public void setRightKey(String rightKey) {
		this.rightKey = rightKey;
	}
	public String getParentKey() {
		return parentKey;
	}
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getLevelKey() {
		return levelKey;
	}
	public void setLevelKey(String levelKey) {
		this.levelKey = levelKey;
	}
	public String getMulti() {
		return multi;
	}
	public void setMulti(String multi) {
		this.multi = multi;
	}
	
	public NestedSets(){}
	public NestedSets( String tableName, String leftKey,
			String rightKey, String parentKey, String primaryKey,
			String levelKey) {
		super();
		this.tableName = tableName;
		this.leftKey = leftKey;
		this.rightKey = rightKey;
		this.parentKey = parentKey;
		this.primaryKey = primaryKey;
		this.levelKey = levelKey;
	}
	public Serializable insert( AdminMenu adminMenu, String position) {
		// If parent is root
		int key=0;
		AdminMenu tmp;
		AdminMenu parent =  this.getItem( adminMenu.getParentId());
		if (parent==null) {
			 adminMenu.setParentId(0);

			// If insert is at the end then left key choose as
			// maximum right key + 1, level - 1
			 adminMenu.setLevel(1);
			if ( position == "top") {
				 key = 1;
			} else {
				 key =  (Integer) getHibernateTemplate().find("SELECT MAX(?) FROM ?", this.rightKey).get(0)+1;
			}
		} else {
			 tmp =  (AdminMenu) this.getHibernateTemplate().find(
				"SELECT ?, ?, ? FROM ? WHERE ? = ?",
				 this.rightKey,
				 this.leftKey,
				 this.levelKey,
				 this.tableName,
				 this.primaryKey,
				 adminMenu.getParentId()
			).get(0);
			 key =  position == "top" ?  tmp.getLft() + 1:  tmp.getRght();
			 adminMenu.setLevel(tmp.getLevel()+ 1);
		}

		// Update tree keys to create gap
		 this.getHibernateTemplate().find(
			"UPDATE ? SET ? = ? + 2, ? = IF(? >= ?, ? + 2, ?) WHERE ? >= ?",
			 this.tableName,
			 this.rightKey,
			 this.rightKey,
			 this.leftKey,
			 this.leftKey,
			(int) key,
			 this.leftKey,
			 this.leftKey,
			 this.rightKey,
			(int) key
		);

		 adminMenu.setLft(key);
		 adminMenu.setRght(key+1);
		 
		// Create new node
		return  this.getHibernateTemplate().save(adminMenu);
	}
	private AdminMenu getItem(int id) {
		System.out.println(this.getHibernateTemplate());
		if (cache.get(id)==null) {
			cache.put(id, (AdminMenu) getHibernateTemplate().find("SELECT ?, ?, ?, ? FROM ? WHERE ? = ?",  this.parentKey,  this.leftKey,  this.rightKey,  this.levelKey,  this.tableName,  this.primaryKey, (int) id));
		}

		return cache.get(id);
	}
}
