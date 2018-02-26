package bbsTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wm.com.ctbbs.model.UploadFile;
import wm.com.ctbbs.service.UploadService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-context.xml")
public class PwdTest {
    
	@Autowired
	UploadService uploadService;
	
	@Test
	public void run1(){
		UploadFile u= uploadService.getById((long)0);
		System.out.println(u.getPath());
		u.setPath("/sfs/sf是是是sjf/");
		uploadService.update(u);
	}
	
	
}
