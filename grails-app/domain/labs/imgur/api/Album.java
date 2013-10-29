package labs.imgur.api;

import java.util.Arrays;

/**
 * <strong>Imgur API v3 Album Model</strong> (<a href="http://api.imgur.com/models/album">http://api.imgur.com/models/album</a>)
 * <p><table>
 * <thead align='left'>
 * <tr><th>Key</th><th>Format</th><th>Description</th></tr>
 * </thead>
 * <tr><td>id</td><td>string</td><td>The ID for the album</td></tr>
 * <tr><td>title</td><td>string</td><td>The title of the album in the gallery</td></tr>
 * <tr><td>description</td><td>string</td><td>The description of the album in the gallery</td></tr>
 * <tr><td>datetime</td><td>integer</td><td>Time inserted into the gallery, epoch time</td></tr>
 * <tr><td>cover</td><td>string</td><td>The ID of an image that you want to be the cover of the album</td></tr>
 * <tr><td>account_url</td><td>string</td><td>The account username or null if it's anonymous.</td></tr>
 * <tr><td>privacy</td><td>string</td><td>The privacy level of the album, you can only view public if not logged in as album owner. This sets the privacy level of the album. Values are : public | hidden | secret</td></tr>
 * <tr><td>layout</td><td>string</td><td>Sets the layout to display the album. Values are : blog | grid | horizontal | vertical</td></tr>
 * <tr><td>views</td><td>integer</td><td>The number of album views</td></tr>
 * <tr><td>link</td><td>string</td><td>The URL link to the album</td></tr>
 * <tr><td>deletehash</td><td>string</td><td>OPTIONAL, the deletehash, if you're logged in as the album owner</td></tr>
 * <tr><td>images_count</td><td>integer</td><td>The total number of images in the album (only available when requesting the direct album)</td></tr>
 * <tr><td>images</td><td>Array of {@link labs.imgur.api.Image}</td><td>An array of all the images in the album (only available when requesting the direct album)</td></tr>
 * </table></p>
 */
public class Album {
    
    private String id;
    private String title;
    private String description;
    private Integer datetime;
    private String cover;
    private String accountUrl;
    private String privacy;
    private String layout;
    private Integer views;
    private String link;
    private String deletehash;
    private String imagesCount;
    private Image[] images;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getDatetime() {
        return datetime;
    }
    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getAccountUrl() {
        return accountUrl;
    }
    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }
    public String getPrivacy() {
        return privacy;
    }
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public Integer getViews() {
        return views;
    }
    public void setViews(Integer views) {
        this.views = views;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getDeletehash() {
        return deletehash;
    }
    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }
    public String getImagesCount() {
        return imagesCount;
    }
    public void setImagesCount(String imagesCount) {
        this.imagesCount = imagesCount;
    }
    public Image[] getImages() {
        return images;
    }
    public void setImages(Image[] images) {
        this.images = images;
    }
    @Override
    public String toString() {
	return "Album [id=" + id + ", title=" + title + ", description="
		+ description + ", datetime=" + datetime + ", cover=" + cover
		+ ", accountUrl=" + accountUrl + ", privacy=" + privacy
		+ ", layout=" + layout + ", views=" + views + ", link=" + link
		+ ", deletehash=" + deletehash + ", imagesCount=" + imagesCount
		+ ", images=" + Arrays.toString(images) + "]";
    }
    
}
