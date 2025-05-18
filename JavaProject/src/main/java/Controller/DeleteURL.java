package Controller;

import Dao.URLDao;

public class DeleteURL {
    private static final URLDao urlDao = URLDao.getInstance();
    public Boolean deleteUrl(String shortUrl){
        return urlDao.removeUrl(shortUrl);
    }
}
