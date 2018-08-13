package wx.mini.douban;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import wx.mini.BaseTest;
import wx.mini.dao.douban.DoubanMovieDao;
import wx.mini.entity.douban.MovieType;

public class MovieTyoeDaoTest extends BaseTest {
	
	@Autowired
	private DoubanMovieDao doubanMovieDao;
	
	@Test
	public void testQueryAll() throws Exception {
		
		List<MovieType> types= doubanMovieDao.queryMovieType();
		System.out.println(types);
		
	}
}
