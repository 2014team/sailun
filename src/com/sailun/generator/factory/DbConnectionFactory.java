package com.sailun.generator.factory;

import com.sailun.generator.db.DataBaseUtil;
import com.sailun.generator.db.DbConnection;
import com.sailun.generator.db.impl.MySqlConnectionImpl;
import com.sailun.generator.db.impl.SqlserverConnectionImpl;

public class DbConnectionFactory {
	
	public static DbConnection getDbConnection(){
		String dbType = DataBaseUtil.getDbType();
		if(null != dbType){
			if(dbType.equals("mysql")){
				return new MySqlConnectionImpl();
				
			}else if(dbType.equals("sqlserver")){
				return new SqlserverConnectionImpl();
				
			}
		}
		return null;
	}
}
