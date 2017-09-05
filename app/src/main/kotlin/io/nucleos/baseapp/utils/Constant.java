package io.nucleos.baseapp.utils;

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 3/12/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
public interface Constant {

    interface Location {
        public static final long INTERVAL = 60000;
    }

    interface Key {
        String ACCESS_TOKEN = "access_token";
        String AUTHORIZATION = "Authorization";
        String JWT = "JWT ";
        String BEARER = "Bearer ";

        String ID = "id";

        String USERS = "users";
        String ME = "me";
        String SESSION = "session";
        String EVENT = "event";
        String CROPPED = "cropped";
    }

    interface Models {

        String AUTH = "auth";
    }

    interface Preferences {
        String APP = "baseAppPreferences";
        String SESSION = "baseAppSessionPreferences";
        String CACHE = "okhttp_cache";
    }

    interface Network {
        interface Status {
            int SUCCESS = 200;
            int CREATED = 201;
            int BAD_REQUEST = 400;
            int UNAUTHORIZED = 401;
            int FORBIDDEN = 403;
            int NOT_FOUND = 404;
            int CONFLICT = 409;
        }
    }

    interface Url {

        String PLAY = "https://play.google.com/store";

        interface Character {
            String BAR = "/";
            String PARAMETER_OPEN = "{";
            String PARAMETER_CLOSE = "}";
            String QUERY = "?";
            String EQUAL = "=";
            String OTHER_QUERY = "&";
        }

        interface Auth {
            String BASE = Character.BAR + Models.AUTH;
        }

        interface User {
            String BASE = Character.BAR + Key.USERS;
            String FIND = BASE;
            String FROM_ID = BASE + Character.BAR + Character.PARAMETER_OPEN + Key.ID + Character.PARAMETER_CLOSE;
            String ME = BASE + Character.BAR + Key.ME;
        }
    }

}
