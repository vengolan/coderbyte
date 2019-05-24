package coderbyte.basicwebapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import coderbyte.basicwebapp.bean.BasicWebAppBean;

@Component
public class BasicWebAppDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public BasicWebAppBean getHitNo(String ipAddress) throws Exception {
		// TODO Auto-generated method stub
	jdbcTemplate.execute("insert ignore into iphits(ip) values('" + ipAddress + "');");
		
		List<Integer> sno = new ArrayList<Integer>();
		String query ="select rank from ( SELECT t.*, @rownum := @rownum + 1 AS rank FROM iphits t,  (SELECT @rownum := 0) r ) m where ip='" + ipAddress  +"'";
		sno = jdbcTemplate.queryForList(query ,Integer.class ); 
		System.out.println(sno + "-----------------------------" ) ;
		return new BasicWebAppBean(sno.get(0).intValue(), ipAddress);
	}
	
}
