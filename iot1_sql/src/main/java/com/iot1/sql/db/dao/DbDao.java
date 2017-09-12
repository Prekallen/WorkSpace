package com.iot1.sql.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.metadata.Table;

import com.iot1.sql.db.dto.DataBase;
import com.iot1.sql.db.dto.DbInfo;

public interface DbDao {
	public DbInfo selectDbInfo(DbInfo di);
	public List<DbInfo> selectDbInfoList(DbInfo di) ;
	public boolean isConnecteDB(DbInfo di) throws Exception;
	public List<DataBase> selectDatabaseList() throws Exception;
	public List<Table> selectTableList(DataBase di) throws Exception;
	public Map selectTableInfo(String tName);
}
