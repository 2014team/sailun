package com.sailun.generator.factory;

import com.sailun.generator.db.DataBaseUtil;
import com.sailun.generator.go.GeneratorCode;
import com.sailun.generator.go.impl.MysqlGeneratorImpl;
import com.sailun.generator.go.impl.SqlserverGeneratorImpl;

public class GeneratorFactory {
	
	public static GeneratorCode getGenerator(){
		
		String dbType = DataBaseUtil.getDbType();
		if(null != dbType){
			if(dbType.equals("mysql")){
				return new MysqlGeneratorImpl();
				
			}else if(dbType.equals("sqlserver")){
				return new SqlserverGeneratorImpl();
				
			}
		}
		return null;
	}

}
