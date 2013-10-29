package labs.imgur.api;

import java.util.Arrays;

/**
 * <strong>Imgur API v3 Album Endpoint</strong> (<a href="http://api.imgur.com/endpoints/album">http://api.imgur.com/endpoints/album</a>)
 * <p><table>
 * <thead align='left'>
 * <tr><th>Key</th><th>Required</th><th>Description</th></tr>
 * </thead>
 * <tr><td>ids[]</td><td>optional</td><td>The image ids that you want to be included in the album.</td></tr>
 * <tr><td>title</td><td>optional</td><td>The title of the album</td></tr>
 * <tr><td>description</td><td>optional</td><td>The description of an album</td></tr>
 * <tr><td>privacy</td><td>optional</td><td>Sets the privacy level of the album. Values are : public | hidden | secret</td></tr>
 * <tr><td>layout</td><td>optional</td><td>Sets the layout to display the album. Values are : blog | grid | horizontal | vertical</td></tr>
 * <tr><td>cover</td><td>optional</td><td>The ID of an image that you want to be the cover of the album</td></tr>
 * </table></p>
 * 
 */
public class AlbumCreationRequest {
    
    private String[] ids;
    private String title;
    private String description;
    private String privacy;
    private String layout;
    private String cover;
    
    public String[] getIds() {
        return ids;
    }
    public void setIds(String[] ids) {
        this.ids = ids;
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
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    
}
