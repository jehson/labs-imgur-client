package labs.imgur.api;

/**
 * <strong>Imgur API v3 Basic Response Model</strong> (<a href="http://api.imgur.com/models/basic">http://api.imgur.com/models/basic</a>)
 * <p><table>
 * <thead align='left'>
 * <tr><th>Key</th><th>Format</th><th>Description</th></tr>
 * </thead>
 * <tr><td>data</td><td>mixed</td><td>Is null, boolean, or integer value. If it's a post then this will contain an object with the all generated values, such as an ID.</td></tr>
 * <tr><td>success</td><td>boolean</td><td>Was the request successful</td></tr>
 * <tr><td>status</td><td>integer</td><td>HTTP Status Code</td></tr>
 * </table></p>
 *
 * @param <D> - varies depending on the request, i.e. for anonymous image upload this field is a {@link labs.imgur.api.Image}
 */

public class BasicResponse<D> {
    private D data;
    private Boolean success;
    private Integer status;
    
    public D getData() {
        return data;
    }
    public void setData(D data) {
        this.data = data;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Override
    public String toString() {
	return "BasicResponse [data=" + data.toString() + ", success=" + success
		+ ", status=" + status + "]";
    }
    
}
