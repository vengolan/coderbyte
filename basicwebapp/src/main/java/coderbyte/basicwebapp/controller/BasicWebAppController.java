package coderbyte.basicwebapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import coderbyte.basicwebapp.dao.BasicWebAppDao;
import coderbyte.basicwebapp.model.BasicWebAppBean;

@RestController
public class BasicWebAppController {

    @Autowired
    BasicWebAppDao dao;
    
    private HttpServletRequest request;
    
    @Autowired
    private HttpServletResponse response;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    

    /**
     * 
     * Method to get Client IP address.
     * Get originating IP address, if request forwarded from proxy or load balancer. 
     * @return - Client IP Address
     */
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
   
    
    
    /**
     * Rest API method - this gets the rank of the IP address from the dao object, and returns the bean. 
     * @return - Return bean that contains IP address and the rank. This to be returned as json to client 
     */
	@GetMapping(path="getrank")
	public BasicWebAppBean helloWorldPathVariable() throws Exception{


			//get client IP address
			String ipAddress = getClientIp();
			
			//get rank for this IP address from dao. 
			return dao.getHitNo(ipAddress);
	
	}
	
	
	
}
