package UrlShortner;

import UrlShortner.Controller.CreateURL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        CreateURL createURL = new CreateURL();
        // Creating a url;
        String shortUrl = createURL.createUrl("https://www.hdfcsec.com/research/stock-market-ideas/investment-ideas?assetId=3&categoryCode=FUND&Sector=&RecoType=&CallType=OPEN&Target_Min=&Target_Max=&horizon_Max=&horizon_Min=&RecoDateRange=%20&BucketID=379&securityId=", 123, "17/05/2025");
        System.out.printf("shortUrl: " + shortUrl);


//        for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}