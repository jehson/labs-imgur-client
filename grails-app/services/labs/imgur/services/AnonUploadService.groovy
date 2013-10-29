package labs.imgur.services

import java.awt.TexturePaintContext.Byte;
import java.util.prefs.Base64;

import labs.imgur.api.Album
import labs.imgur.api.AlbumCreationRequest
import labs.imgur.api.Image;
import labs.imgur.api.ImageUploadRequest
import labs.imgur.api.BasicResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestTemplate;

class AnonUploadService {
    
    private static final String IMAGE_UPLOAD_ENDPOINT = 'https://api.imgur.com/3/image'
    private static final String ALBUM_CREATION_ENDPOINT = 'https://api.imgur.com/3/album'
    private static final String CLIENT_ID = '99c5fed06cad39e'
    private static final String AUTH_HEADER_KEY = 'Authorization'
    private static final String AUTH_HEADER_VALUE = "Client-ID ${CLIENT_ID}"
    private static final String UPLOAD_TYPE = 'base64'
    private static final String DEFAULT_ALBUM_PRIVACY = 'secret'
    RestTemplate restTemplate
    
    def BasicResponse uploadImage(byte[] imageBytes) {
	
	def imageBase64 = Base64.byteArrayToBase64(imageBytes)
	
	ImageUploadRequest request = new ImageUploadRequest();
	request.setImage(imageBase64);
	request.setType(UPLOAD_TYPE);
	
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.put(AUTH_HEADER_KEY, [AUTH_HEADER_VALUE]);
	HttpEntity<ImageUploadRequest> httpRequest = new HttpEntity<ImageUploadRequest>(request, httpHeaders);
	BasicResponse response = restTemplate.postForObject(IMAGE_UPLOAD_ENDPOINT, httpRequest, BasicResponse.class);
    }
    
    /**
     * @param imageBytes - the image to be uploaded in byte array format
     * @param album - the previously created anonymous album
     * @return {@link labs.imgur.api.BasicResponse} object with {@link labs.imgur.api.Image} for data field (D)
     */
    def BasicResponse uploadImageToAnonymousAlbum(byte[] imageBytes, Album album) {
	def imageBase64 = Base64.byteArrayToBase64(imageBytes)
	
	ImageUploadRequest request = new ImageUploadRequest();
	request.setImage(imageBase64);
	request.setType(UPLOAD_TYPE);
	request.setAlbum(album.deletehash);
	
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.put(AUTH_HEADER_KEY, [AUTH_HEADER_VALUE]);
	HttpEntity<ImageUploadRequest> httpRequest = new HttpEntity<ImageUploadRequest>(request, httpHeaders);
	BasicResponse response = restTemplate.postForObject(IMAGE_UPLOAD_ENDPOINT, httpRequest, BasicResponse.class);
    }
    
    def String uploadImageAndGetLink(byte[] imageBytes) {
	BasicResponse response
	try {
	    response = uploadImage(imageBytes)
	} catch(Exception e) {
	    e.printStackTrace()
	}
	return ((Image)response?.getData())?.getLink()
    }
    
    /**
     * @return {@link labs.imgur.api.BasicResponse} object with {@link labs.imgur.api.Album} for data field (D)
     */
    def BasicResponse createNewEmptyAlbum() {
	AlbumCreationRequest request = new AlbumCreationRequest();
	request.setTitle('Imgur Client POC in Grails!');
	request.setPrivacy(DEFAULT_ALBUM_PRIVACY);
	
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.put(AUTH_HEADER_KEY, [AUTH_HEADER_VALUE]);
	HttpEntity<AlbumCreationRequest> httpRequest = new HttpEntity<AlbumCreationRequest>(request, httpHeaders);
	BasicResponse response = restTemplate.postForObject(ALBUM_CREATION_ENDPOINT, httpRequest, BasicResponse.class);
    }
    
    def BasicResponse updateAnonymousAlbum(Album album) {
	AlbumCreationRequest request = new AlbumCreationRequest();
	request.setTitle(album.title);
	request.setCover(album.cover);
	request.setDescription(album.description);
	request.setLayout(album.layout);
	request.setPrivacy(album.privacy);
	request.setIds(getImageIds(album.images));
	
	def anonAlbumUpdateEndpoint = ALBUM_CREATION_ENDPOINT + "/${album.deletehash}"
	
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.put(AUTH_HEADER_KEY, [AUTH_HEADER_VALUE]);
	HttpEntity<AlbumCreationRequest> httpRequest = new HttpEntity<AlbumCreationRequest>(request, httpHeaders);
	BasicResponse response = restTemplate.postForObject(anonAlbumUpdateEndpoint, httpRequest, BasicResponse.class);
    }
    
    def String[] getImageIds(Image[] images) {
	List<String> imageIds = new ArrayList<String>();
	for(Image image: images){
	    imageIds.add(image.getId());
	}
	return imageIds.toArray();
    }
    
    def Album createAndGetNewAlbum() {
	BasicResponse response
	try {
	    response = createNewEmptyAlbum()
	} catch(Exception e) {
	    e.printStackTrace()
	}
	println "The response in album creation: ${response}."
	println "Album created is ${response.data}."
	return (Album)response?.getData()
    }
    
}
