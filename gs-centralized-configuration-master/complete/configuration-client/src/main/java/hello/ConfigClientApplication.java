package hello;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${driverClassName}")
    private String driverClassName;
    
    @Value("${url}")
    private String url;
    
    @Value("${username}")
    private String username;
    
    @Value("${password}")
    private String password;
    
    public String getDriverClassName() {
		return driverClassName;
	}





	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}





	public String getUrl() {
		return url;
	}





	public void setUrl(String url) {
		this.url = url;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}

	@RequestMapping("/db")
    String getDbDetails() {
		HashMap<String,String> dbInfo=new HashMap<>();
		dbInfo.put("driverClass",this.driverClassName);
		dbInfo.put("url",this.url);
		dbInfo.put("username",this.username);
		dbInfo.put("password",this.password);
        return dbInfo.toString();
    }
}