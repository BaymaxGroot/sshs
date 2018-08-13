package wx.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(value="DianPing", description="大众点评网相关数据", tags="DianPing Controller")
@RequestMapping(value="/dp")
public class DianPingController {
	
}
