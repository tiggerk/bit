package beautychu.control.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beautychu.service.StyleService;

@Controller("json.styleControl")
@RequestMapping("/json/style")
public class StyleControl {
//	static Logger log = Logger.getLogger(ProductControl.class);

	@Autowired
	StyleService styleServie;

	@RequestMapping("/list")
	public Object list() throws Exception {

		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("styleList", styleServie.getList());
		return resultMap;
	}

}
