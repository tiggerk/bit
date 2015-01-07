package beautychu.control.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beautychu.service.StylePhotoService;

@Controller("json.stylePhotoControl")
@RequestMapping("/json/stylePhoto")
public class StylePhotoControl {
//	static Logger log = Logger.getLogger(ProductControl.class);

	@Autowired
	StylePhotoService stylePhotoServie;

	@RequestMapping("/list")
	public Object list(int no) throws Exception {

		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("stylePhotoList", stylePhotoServie.getList(no));
		return resultMap;
	}

}
