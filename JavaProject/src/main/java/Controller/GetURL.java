package Controller;

import Dao.URLDao;

public class GetURL {
    private final URLDao urlDao = URLDao.getInstance();

    public String getOriginalUrl(String shortUrl) {
        return urlDao.getOriginalUrl(shortUrl) != null ? urlDao.getOriginalUrl(shortUrl)  : "This URL is already Deleted";
    }
}
