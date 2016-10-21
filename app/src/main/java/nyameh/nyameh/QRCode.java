package nyameh.nyameh;

/**
 * Created by Cafeeyen on 10/21/2016.
 */

public class QRCode
{
    protected static boolean checkQRResult(String qrContent){
        if (qrContent.length() > 4 && qrContent.substring(0, 4).compareTo("geo:") == 0
                && (qrContent.length()-qrContent.replaceAll(",", "").length()==1))
        {
            if(getTitude(qrContent, true) != 9999 && getTitude(qrContent, false) != 9999)
                return true;
        }
        return false;
    }

    private static double getTitude(String qrContent, Boolean isLatitude){
        if(isLatitude){
            try {
                double titudeResult = Double.parseDouble(qrContent.split(",")[0].substring(4));
                return titudeResult;
            }catch (Exception ex){return 9999;}
        }
        else{ //longtitude
            try {
                double titudeResult = Double.parseDouble(qrContent.split(",")[1]);
                return titudeResult;
            }catch (Exception ex){return 9999;}
        }

    }
}
