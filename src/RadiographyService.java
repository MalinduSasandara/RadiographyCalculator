public class RadiographyService {
    public String calculateSOD(double sourceSize,double ofd,double maxUg){
        //calculate minimum SOD
        if(sourceSize <= 0 || ofd <=0 || maxUg <= 0){
            return "Error All values must be positive numbers";
        }
        double sod = (sourceSize * ofd) / maxUg;
        double sfd = sod + ofd;

        return String.format("\"Minimum SOD = %.1f mm\\nSFD = %.1f mm\", sod, sfd");
    }
    //calculate new exposure time

}








