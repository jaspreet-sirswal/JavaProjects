package UrlShortner.Dao;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class CreateURLDao {
    private Map<String, String> shortUrlVSOriginalUrl = new HashMap<>();
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
        String shortUrl = generateUrl(originalUrl, userId);
        addUrl(shortUrl, originalUrl);
        return shortUrl;
    }

    public Integer getUniqueCount() {
        return UniqueCount;
    }

    public void setUniqueCount(Integer uniqueCount) {
        UniqueCount = uniqueCount;
    }

    private void addUrl(String shortUrl, String originalUrl) {
        this.shortUrlVSOriginalUrl.put(shortUrl, originalUrl);
        this.setUniqueCount(this.getUniqueCount() + 1);
    }

    private String generateMd5hash(String originalUrl) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(originalUrl.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
