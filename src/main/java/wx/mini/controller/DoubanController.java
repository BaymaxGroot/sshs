package wx.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import wx.mini.dao.douban.DoubanMovieDao;
import wx.mini.entity.douban.MovieBasic;
import wx.mini.entity.douban.MovieDetail;
import wx.mini.entity.douban.MoviePlayLink;
import wx.mini.entity.douban.MovieType;

@Api(value = "Douban", description = "Information collected from douban.movie", tags = "Douban Controller")
@Controller
@RequestMapping(value = "/db")
public class DoubanController {

	@Autowired
	private DoubanMovieDao doubanMovieDao;

	@ApiOperation(value = "Get a list of movie types ", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/mtype", method = RequestMethod.GET)
	@ResponseBody
	public List<MovieType> getMovieType() {
		List<MovieType> tlist = doubanMovieDao.queryMovieType();
		return tlist;
	}

	@ApiOperation(value = "Get the movie list", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "Movie's type id", dataType = "Integer", paramType = "query", required = false, defaultValue = "0"),
			@ApiImplicitParam(name = "name", value = "Part of the movie's name", dataType = "String", paramType = "query", required = false, defaultValue = ""),
			@ApiImplicitParam(name = "from", value = "Start index to get", dataType = "Integer", paramType = "query", required = true, defaultValue = "0"),
			@ApiImplicitParam(name = "size", value = "Size of movies per page", dataType = "Integer", paramType = "query", required = true, defaultValue = "10") })
	public List<MovieBasic> getMovieList(int type, String name, int from, int size) {
		List<MovieBasic> mlist = null;
		if (type < 0 || from < 0 || size <= 0) {
			mlist = null;
		} else {
			if (type == 0) {
				if (name == null || name.replaceAll(" ", "").equals("")) {
					mlist = doubanMovieDao.queryMovieList(from, size);
				} else {
					mlist = doubanMovieDao.queryMovieListThroughName(name, from, size);
				}
			} else {
				if (name == null || name.replaceAll(" ", "").equals("")) {
					mlist = doubanMovieDao.queryMovieListThroughType(type, from, size);
				} else {
					mlist = doubanMovieDao.queryMovieListThroughNameAndType(type, name, from, size);
				}
			}
		}
		return mlist;
	}
	
	@ApiOperation(value = "Get movie's detail info according movie id", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "Movie's id", dataType = "Integer", paramType = "query", required = true, defaultValue = "0")})
	public MovieDetail getMovieDetail(int id) {
		MovieDetail mDetail= doubanMovieDao.queryMovieDetailThroughID(id);
		return mDetail;
	}
	
	@ApiOperation(value = "Get movie's play links according movie id", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/mplays", method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "Movie's id", dataType = "Integer", paramType = "query", required = true, defaultValue = "0")})
	public List<MoviePlayLink> getMoviePlayLinks(int id) {
		List<MoviePlayLink> mPlays= doubanMovieDao.queryMoviePlayLinks(id);
		return mPlays;
	}

}
