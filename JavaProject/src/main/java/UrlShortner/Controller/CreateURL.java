package UrlShortner.Controller;

import UrlShortner.Dao.CreateURLDao;

public class CreateURL {
    private CreateURLDao createURLDao = new CreateURLDao();

    public String createUrl(String originalUrl, Integer userId, String ExpiryDate) {
        return createURLDao.CreateAndStoreUrl(originalUrl, userId);
    }
}
