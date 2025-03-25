package Ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class C13Ex {
	public static void main(String[] args) throws IOException, InterruptedException {
		// OPENWEATHER MAP API를 이용해서 날씨 정보 받아옵니다.
		String API_KEY = "ee6171cdf7597f9f51f38521a91dd6c1";
		String url = "https://api.openweathermap.org/data/2.5/weather?lat=33.44&lon=-94.04&appid="+API_KEY;
		
		// HTTP Request 객체생성
		HttpRequest httpRequest = HttpRequest.newBuilder()
									.uri(URI.create(url))
									.GET()
									.build();
								
		// Http Request 요청 / 응답 확인
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(response.body());
		
		// 가공 처리
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Clas Type
		Root RootObject = objectMapper.readValue(response.body(), Root.class);
		System.out.println("도시이름 : "+RootObject.getName());
		System.out.printf("현재온도 : %.2f°C\n",(RootObject.getMain().getTemp()-273.15));		
		System.out.printf("체감온도 : %.2f°C\n",(RootObject.getMain().getFeels_like()-273.15));
		System.out.printf("최저온도 : %.2f°C\n",(RootObject.getMain().getTemp_min()-273.15));
		System.out.printf("최고온도 : %.2f°C\n",(RootObject.getMain().getTemp_max()-273.15));
		System.out.printf("기압 : %dhPa\n",RootObject.getMain().getPressure());
		System.out.printf("습도 : %d%% \n",RootObject.getMain().getHumidity());
		System.out.printf("해수면 : %dhpa\n",RootObject.getMain().getSea_level());
		System.out.printf("지면기압 : %dhpa",RootObject.getMain().getGrnd_level());
		
		
		
	}	
	
	// class type
		// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
		// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
		/* ObjectMapper om = new ObjectMapper();
		Root root = om.readValue(myJsonString, Root.class); */
		public static class Clouds{
		    public int all;
		    
		    Clouds(){
		    	
		    }

			public Clouds(int all) {
				super();
				this.all = all;
			}

			public int getAll() {
				return all;
			}

			public void setAll(int all) {
				this.all = all;
			}
		    
		}

		public static class Coord{
		    public double lon;
		    public double lat;
		    
		    Coord(){
		    	
		    }
		    
			public Coord(double lon, double lat) {
				super();
				this.lon = lon;
				this.lat = lat;
			}

			public double getLon() {
				return lon;
			}

			public void setLon(double lon) {
				this.lon = lon;
			}

			public double getLat() {
				return lat;
			}

			public void setLat(double lat) {
				this.lat = lat;
			}
		    
			
			
		    
		}

		public static class Main{
		    public double temp;
		    public double feels_like;
		    public double temp_min;
		    public double temp_max;
		    public int pressure;
		    public int humidity;
		    public int sea_level;
		    public int grnd_level;
		    
		    
		    
		    Main(){
		    	
		    }
		    
			public double getTemp() {
				return temp;
			}

			public void setTemp(double temp) {
				this.temp = temp;
			}

			public double getFeels_like() {
				return feels_like;
			}

			public void setFeels_like(double feels_like) {
				this.feels_like = feels_like;
			}

			public double getTemp_min() {
				return temp_min;
			}


			public void setTemp_min(double temp_min) {
				this.temp_min = temp_min;
			}

			public double getTemp_max() {
				return temp_max;
			}

			public void setTemp_max(double temp_max) {
				this.temp_max = temp_max;
			}

			public int getPressure() {
				return pressure;
			}

			public void setPressure(int pressure) {
				this.pressure = pressure;
			}

			public int getHumidity() {
				return humidity;
			}

			public void setHumidity(int humidity) {
				this.humidity = humidity;
			}

			public int getSea_level() {
				return sea_level;
			}

			public void setSea_level(int sea_level) {
				this.sea_level = sea_level;
			}

			public int getGrnd_level() {
				return grnd_level;
			}

			public void setGrnd_level(int grnd_level) {
				this.grnd_level = grnd_level;
			}
			
			public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity,
					int sea_level, int grnd_level) {
				super();
				this.temp = temp;
				this.feels_like = feels_like;
				this.temp_min = temp_min;
				this.temp_max = temp_max;
				this.pressure = pressure;
				this.humidity = humidity;
				this.sea_level = sea_level;
				this.grnd_level = grnd_level;
			}
		    
		    
		}

		public static class Root{
		    public Coord coord;
		    public ArrayList<Weather> weather;
		    public String base;
		    public Main main;
		    public int visibility;
		    public Wind wind;
		    public Clouds clouds;
		    public int dt;
		    public Sys sys;
		    public int timezone;
		    public int id;
		    public String name;
		    public int cod;
		    
		    Root(){
		    	
		    }
			public Root(Coord coord, ArrayList<Weather> weather, String base, Main main, int visibility, Wind wind,
					Clouds clouds, int dt, Sys sys, int timezone, int id, String name, int cod) {
				super();
				this.coord = coord;
				this.weather = weather;
				this.base = base;
				this.main = main;
				this.visibility = visibility;
				this.wind = wind;
				this.clouds = clouds;
				this.dt = dt;
				this.sys = sys;
				this.timezone = timezone;
				this.id = id;
				this.name = name;
				this.cod = cod;
			}
			
			
			public Coord getCoord() {
				return coord;
			}
			public void setCoord(Coord coord) {
				this.coord = coord;
			}
			public ArrayList<Weather> getWeather() {
				return weather;
			}
			public void setWeather(ArrayList<Weather> weather) {
				this.weather = weather;
			}
			public String getBase() {
				return base;
			}
			public void setBase(String base) {
				this.base = base;
			}
			public Main getMain() {
				return main;
			}
			public void setMain(Main main) {
				this.main = main;
			}
			public int getVisibility() {
				return visibility;
			}
			public void setVisibility(int visibility) {
				this.visibility = visibility;
			}
			public Wind getWind() {
				return wind;
			}
			public void setWind(Wind wind) {
				this.wind = wind;
			}
			public Clouds getClouds() {
				return clouds;
			}
			public void setClouds(Clouds clouds) {
				this.clouds = clouds;
			}
			public int getDt() {
				return dt;
			}
			public void setDt(int dt) {
				this.dt = dt;
			}
			public Sys getSys() {
				return sys;
			}
			public void setSys(Sys sys) {
				this.sys = sys;
			}
			public int getTimezone() {
				return timezone;
			}
			public void setTimezone(int timezone) {
				this.timezone = timezone;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getCod() {
				return cod;
			}
			public void setCod(int cod) {
				this.cod = cod;
			}
		    
		    
		    
		}

		public static class Sys{
		    public int type;
		    public int id;
		    public String country;
		    public int sunrise;
		    public int sunset;
		    
		    
		    Sys(){
		    	
		    }
			public Sys(int type, int id, String country, int sunrise, int sunset) {
				super();
				this.type = type;
				this.id = id;
				this.country = country;
				this.sunrise = sunrise;
				this.sunset = sunset;
			}
			
			
			public int getType() {
				return type;
			}
			public void setType(int type) {
				this.type = type;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public int getSunrise() {
				return sunrise;
			}
			public void setSunrise(int sunrise) {
				this.sunrise = sunrise;
			}
			public int getSunset() {
				return sunset;
			}
			public void setSunset(int sunset) {
				this.sunset = sunset;
			}
		}

		public static class Weather{
		    public int id;
		    public String main;
		    public String description;
		    public String icon;
		    
		    Weather(){
		    	
		    }
			public Weather(int id, String main, String description, String icon) {
				super();
				this.id = id;
				this.main = main;
				this.description = description;
				this.icon = icon;
			}
			
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getMain() {
				return main;
			}
			public void setMain(String main) {
				this.main = main;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getIcon() {
				return icon;
			}
			public void setIcon(String icon) {
				this.icon = icon;
			}
		    
		    
		    
		}

		public static class Wind{
		    public double speed;
		    public int deg;
		    public double gust;
		    
		    Wind(){
		    	
		    }
			public Wind(double speed, int deg, double gust) {
				super();
				this.speed = speed;
				this.deg = deg;
				this.gust = gust;
			}
			public double getSpeed() {
				return speed;
			}
			public void setSpeed(double speed) {
				this.speed = speed;
			}
			public int getDeg() {
				return deg;
			}
			public void setDeg(int deg) {
				this.deg = deg;
			}
			public double getGust() {
				return gust;
			}
			public void setGust(double gust) {
				this.gust = gust;
			}
		    
		    
		}

}
