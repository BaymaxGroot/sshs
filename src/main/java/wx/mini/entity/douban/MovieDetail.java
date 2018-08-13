package wx.mini.entity.douban;

public class MovieDetail {
	private String coverUrl;
	private String title;
	private String types;
	private int id;
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types.replaceAll("/", " ");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
