package wx.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(value="DianPing", description="���ڵ������������", tags="DianPing Controller")
@RequestMapping(value="/dp")
public class DianPingController {
	
}
