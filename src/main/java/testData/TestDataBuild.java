package testData;

import java.util.ArrayList;
import java.util.List;

import model.AddPlace;
import model.Location;

public class TestDataBuild {

	public AddPlace addPlaceData(String name, String language, String address) {
		AddPlace addPlace = new AddPlace();
		Location location = new Location();
		location.setLat(-38.654);
		location.setLng(33.876);
		addPlace.setLocation(location);
		
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setAddress(address);
		
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		addPlace.setTypes(list);
		
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);
		return addPlace;
	}
}
