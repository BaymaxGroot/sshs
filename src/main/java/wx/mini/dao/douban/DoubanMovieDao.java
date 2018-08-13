package wx.mini.dao.douban;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;

import wx.mini.entity.douban.MovieBasic;
import wx.mini.entity.douban.MovieDetail;
import wx.mini.entity.douban.MoviePlayLink;
import wx.mini.entity.douban.MovieType;

public interface DoubanMovieDao {

	/**
	 * Call the types list of Movie
	 * 
	 * @return
	 */
	List<MovieType> queryMovieType();

	/**
	 * Call movies list for one page from all movies
	 * 
	 * @param from
	 * @param size
	 * @return
	 */
	List<MovieBasic> queryMovieList(@Param("from") int from, @Param("size") int size);

	/**
	 * Call movies list for one page who's type is offered
	 * 
	 * @param type
	 * @param from
	 * @param size
	 * @return
	 */
	List<MovieBasic> queryMovieListThroughType(@Param("type") int type, @Param("from") int from,
			@Param("size") int size);

	/**
	 * Call movies list for one page who's name like offered
	 * 
	 * @param name
	 * @param from
	 * @param size
	 * @return
	 */
	List<MovieBasic> queryMovieListThroughName(@Param("name") String name, @Param("from") int from,
			@Param("size") int size);

	/**
	 * Call movies list for one page who's name like offered and type is offered
	 * 
	 * @param type
	 * @param name
	 * @param from
	 * @param size
	 * @return
	 */
	List<MovieBasic> queryMovieListThroughNameAndType(@Param("type") int type, @Param("name") String name,
			@Param("from") int from, @Param("size") int size);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	MovieDetail queryMovieDetailThroughID(@Param("id") int id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<MoviePlayLink> queryMoviePlayLinks(@Param("id") int id);
}
