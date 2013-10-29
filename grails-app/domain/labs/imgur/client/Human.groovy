package labs.imgur.client

import labs.imgur.api.Album

class Human {

    String name
    byte[] picture
    String pictureLink
    //Album album
    
    static constraints = {
	name blank:false
	picture blank:false, nullable:true, size:0..1000000
	pictureLink blank:true, nullable:true
	//album blank:true, nullable:true
    }
}
