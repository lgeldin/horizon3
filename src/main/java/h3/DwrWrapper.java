package h3;

import org.directwebremoting.spring.SpringCreator;
import org.springframework.web.servlet.mvc.ServletWrappingController;

public class DwrWrapper extends ServletWrappingController {
	public void afterPropertiesSet() throws Exception {
		SpringCreator.setOverrideBeanFactory(this.getWebApplicationContext());
		super.afterPropertiesSet();
	}
}
