package coderbyte.basicwebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import coderbyte.basicwebapp.bean.BasicWebAppBean;
import coderbyte.basicwebapp.dao.BasicWebAppDao;

@RestController
public class BasicWebAppController {

    @Autowired
    BasicWebAppDao dao;
    
    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    public String getClientIp() {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
   
    
	@GetMapping(path="getcount")
	public BasicWebAppBean helloWorldPathVariable()  {
		
		System.out.println("Inside Controller...");
		
		try {
			String ipAddress = getClientIp();
			return dao.getHitNo(ipAddress);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
}
