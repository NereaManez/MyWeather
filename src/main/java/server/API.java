package server;

import properties.MyConfig;

public class API {

    public static class Routes {
        public static final String SERVER_BASE = "http://" + MyConfig.getInstance().getDBHost() + ":" + MyConfig.getInstance().getDBPort();
        public static final String CITY_ALL = "/city/all";
        public static final String ADD_CITY = "/city/add";
    }

    public static class Type {
        public static final String JSON = "application/json";
        public static final String TEXT_XML = "text/xml";
        public static final String TEXT_HTML = "text/html";
    }
}
