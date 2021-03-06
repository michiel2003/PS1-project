package application.entitys.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "image")
public class Image {
	
	public Image() {
	}
	
	public Image(String url) {
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(url));
			this.width = bimg.getWidth();
			this.height = bimg.getHeight();
			this.url = url;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "width")
	private int width;
	
	@Column(name = "height")
	private int height;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
	
	
	
	

}
