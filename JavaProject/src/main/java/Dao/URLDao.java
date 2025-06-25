package Dao;

import lombok.Getter;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class URLDao {
    // making URLDao Class Sigleton

    private static final URLDao instance = new URLDao();

    public static URLDao getInstance() {
        return instance;
    }

    private Map<String, String> shortUrlVSOriginalUrl = new HashMap<>();

    @Setter
    @Getter
    private Integer UniqueCount = 0;

//    public CreateURLDao(Map<String, String> shortUrlVSOriginalUrl) {
//        this.shortUrlVSOriginalUrl = shortUrlVSOriginalUrl;
//    }

    private String generateUrl(String originalUrl, Integer userId) {
        String generatedUrl = generateMd5hash(originalUrl);
        Integer uniqueCnt = this.getUniqueCount();
        return generatedUrl + "/" + uniqueCnt + "/" + userId.toString();
    }

    public String CreateAndStoreUrl(String originalUrl, Integer userId) {
        String shortUrl ="https://www." + generateUrl(originalUrl, userId);
        addUrl(shortUrl, originalUrl);
        return shortUrl;
    }

    private void addUrl(String shortUrl, String originalUrl) {
        this.shortUrlVSOriginalUrl.put(shortUrl, originalUrl);
        this.setUniqueCount(this.getUniqueCount() + 1);
    }
    public String getOriginalUrl(String shortUrl){
        return this.shortUrlVSOriginalUrl.get(shortUrl);
    }
    public Boolean removeUrl(String shortUrl){
        this.shortUrlVSOriginalUrl.remove(shortUrl);
        return this.shortUrlVSOriginalUrl.get(shortUrl) == null ? Boolean.TRUE :Boolean.FALSE;
    }

    private String generateMd5hash(String originalUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(originalUrl.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
