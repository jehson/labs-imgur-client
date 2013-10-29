package labs.imgur.api;

/**
 * <strong>Imgur API v3 Image Upload Endpoint</strong> (<a href="http://http://api.imgur.com/endpoints/image">http://api.imgur.com/endpoints/image</a>)
 * <p><table>
 * <thead align='left'>
 * <tr><th>Key</th><th>Required</th><th>Description</th></tr>
 * </thead>
 * <tr><td>image</td><td>required</td><td>A binary file, base64 data, or a URL for an image</td></tr>
 * <tr><td>album</td><td>optional</td><td>The id of the album you want to add the image to. For anonymous albums, {album} should be the deletehash that is returned at creation.</td></tr>
 * <tr><td>type</td><td>optional</td><td>The type of the file that's being sent; file, base64 or URL</td></tr>
 * <tr><td>name</td><td>optional</td><td>The name of the file, this is automatically detected if uploading a file with a POST and multipart / form-data</td></tr>
 * <tr><td>title</td><td>optional</td><td>The title of the image</td></tr>
 * <tr><td>description</td><td>optional</td><td>The description of the image</td></tr>
 * </table></p>
 */
public class ImageUploadRequest {
    
    private String image;
    private String type;
    private String album;
    
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAlbum() {
	return album;
    }
    public void setAlbum(String album) {
	this.album = album;
    }
    
}
