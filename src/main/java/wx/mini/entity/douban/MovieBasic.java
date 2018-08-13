package wx.mini.entity.douban;

import org.apache.ibatis.jdbc.Null;

public class MovieBasic {
	private int id;
	private String title;
	private String director;
	private String actors;
	private String cover_url;
	private float rate;
	private byte playable;
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		if(actors==null){
			this.actors = "Not Sure";
		}else{
			this.actors = actors;
		}	
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public byte getPlayable() {
		return playable;
	}
	public void setPlayable(byte playable) {
		this.playable = playable;
	}
	
}
