import Controller.CreateURL;
import Controller.DeleteURL;
import Controller.GetURL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome!");
        CreateURL createURL = new CreateURL();
        GetURL getURL = new GetURL();
        DeleteURL deleteURL = new DeleteURL();
        // Creating a short url;
        String shortUrl = createURL.createUrl("https://www.hdfcsec.com/research/stock-market-ideas/investment-ideas?assetId=3&categoryCode=FUND&Sector=&RecoType=&CallType=OPEN&Target_Min=&Target_Max=&horizon_Max=&horizon_Min=&RecoDateRange=%20&BucketID=379&securityId=", 123, "17/05/2025");
        System.out.println("\nshortUrl: " + shortUrl);

        // Get Original URL
        String originalUrl = getURL.getOriginalUrl(shortUrl);
        System.out.println("originalUrl is : " + originalUrl);

        // Delete Url
        Boolean isDeleted = deleteURL.deleteUrl(shortUrl);
        System.out.println("Is Url Deleted : " + isDeleted);

        // try getting deleted URL
        String originalUrl2 = getURL.getOriginalUrl(shortUrl);
        System.out.println("originalUrl2 is : " + originalUrl2);
    }
}