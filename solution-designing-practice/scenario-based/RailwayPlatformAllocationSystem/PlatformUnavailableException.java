package RailwayPlatformAllocationSystem;

//custom exception
public class PlatformUnavailableException extends Exception {
    public PlatformUnavailableException(String msg) {
        super(msg);
    }
}