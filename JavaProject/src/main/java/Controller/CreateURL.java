package Controller;
import Dao.URLDao;

public class CreateURL {
    private final URLDao urlDao = URLDao.getInstance();

    public String createUrl(String originalUrl, Integer userId, String ExpiryDate) {
        return urlDao.CreateAndStoreUrl(originalUrl, userId);
    }
}
